package team.CowsAndHorses.controller;


import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.stp.StpUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import team.CowsAndHorses.constant.AuthConst;
import team.CowsAndHorses.domain.TeacherInfo;
import team.CowsAndHorses.dto.AjaxResult;
import team.CowsAndHorses.service.StuInfoService;
import team.CowsAndHorses.service.TeacherScoreService;
import team.CowsAndHorses.service.TeacherService;

import java.util.Map;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/teacher")
public class TeacherScoreController {
    final TeacherScoreService teacherScoreService;
    final TeacherService teacherService;
    final StuInfoService stuService;


    @GetMapping("/get/unapproved/list")
    @SaCheckRole(value = {AuthConst.R_teacher})
    @ResponseBody
    public Object getUnenteredStu(@RequestParam Integer year) {
        TeacherInfo teacher = teacherService.selectById(StpUtil.getLoginIdAsInt());
        return AjaxResult.SUCCESS(teacherScoreService.query(teacher, year));
    }

    @GetMapping("/get/items")
    @SaCheckRole(value = {AuthConst.R_teacher})
    @ResponseBody
    public Object getItemScore(@RequestParam Integer score_id) {
        TeacherInfo teacher = teacherService.selectById(StpUtil.getLoginIdAsInt());
        return AjaxResult.SUCCESS(teacherScoreService.queryItem(teacher, score_id));
    }

    @PostMapping("/approval")
    @SaCheckRole(value = {AuthConst.R_teacher})
    @ResponseBody
    public Object approval(@RequestParam Integer score_id,
                                       @RequestParam Integer is_approval,
                                       @RequestParam String reason) {
        TeacherInfo teacher = teacherService.selectById(StpUtil.getLoginIdAsInt());
        teacherScoreService.approval(teacher, score_id, is_approval, reason);
        return AjaxResult.SUCCESS();
    }

    @PostMapping("/approval/list")
    @SaCheckRole(value = {AuthConst.R_teacher})
    @ResponseBody
    public Object approvalList(@RequestParam Integer[] score_id,
                                           @RequestParam Integer is_approval,
                                           @RequestParam String reason) {
        TeacherInfo teacher = teacherService.selectById(StpUtil.getLoginIdAsInt());
        for (Integer id : score_id) {
            teacherScoreService.approval(teacher, id, is_approval, reason);
        }
        return AjaxResult.SUCCESS();
    }

    @PostMapping("/enter/score")
    @SaCheckRole(value = {AuthConst.R_teacher})
    @ResponseBody
    public Object enterScore(@RequestBody Map<String, Object> map) {
        TeacherInfo teacher = teacherService.selectById(StpUtil.getLoginIdAsInt());
        int year = (Integer) map.get("year");
        String stuNumber = (String) map.get("stu_number");
        Map<String, String> scoreMap = (Map<String, String>) map.get("score");
        teacherScoreService.enter(teacher, stuNumber, year, scoreMap);
        return AjaxResult.SUCCESS();
    }

    @PutMapping("/change/score")
    @SaCheckRole(value = {AuthConst.R_teacher})
    @ResponseBody
    public Object changeScore(@RequestBody Map<String, Object> map) {
        TeacherInfo teacher = teacherService.selectById(StpUtil.getLoginIdAsInt());
        int scoreDoneId = (Integer) map.get("score_done_id");
        Map<String, String> scoreMap = (Map<String, String>) map.get("score");
        teacherScoreService.change(teacher, scoreDoneId, scoreMap);
        return AjaxResult.SUCCESS();
    }

    @GetMapping("/get/approved/list")
    @SaCheckRole(value = {AuthConst.R_teacher})
    @ResponseBody
    public Object getScoreDone(@RequestParam Integer year) {
        TeacherInfo teacher = teacherService.selectById(StpUtil.getLoginIdAsInt());
        return AjaxResult.SUCCESS(teacherScoreService.queryDone(teacher, year));
    }

    @GetMapping("/get/approved/detail")
    @SaCheckRole(value = {AuthConst.R_teacher})
    @ResponseBody
    public Object getScoreDoneDetail(@RequestParam Integer score_done_id) {
        TeacherInfo teacher = teacherService.selectById(StpUtil.getLoginIdAsInt());
        return AjaxResult.SUCCESS(teacherScoreService.queryDoneDetail(teacher, score_done_id));
    }

    @PutMapping("/withdraw/approval")
    @SaCheckRole(value = {AuthConst.R_teacher})
    @ResponseBody
    public Object withdrawScore(@RequestParam Integer year, @RequestParam String stu_number) {
        TeacherInfo teacher = teacherService.selectById(StpUtil.getLoginIdAsInt());
        teacherScoreService.withdraw(teacher, stu_number, year);
        return AjaxResult.SUCCESS();
    }
}
