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
    public AjaxResult<java.util.List<team.CowsAndHorses.dto.ScoreFetchDto>> getUnenteredStu(@RequestParam Integer year) {
        TeacherInfo teacher = teacherService.selectById(StpUtil.getLoginIdAsInt());
        return AjaxResult.SUCCESS(teacherScoreService.query(teacher, year));
    }

    @GetMapping("/get/items")
    @SaCheckRole(value = {AuthConst.R_teacher})
    @ResponseBody
    public AjaxResult<team.CowsAndHorses.dto.ItemScoreDto> getItemScore(@RequestParam Integer score_id) {
        TeacherInfo teacher = teacherService.selectById(StpUtil.getLoginIdAsInt());
        return AjaxResult.SUCCESS(teacherScoreService.queryItem(teacher, score_id));
    }

    @PostMapping("/approval")
    @SaCheckRole(value = {AuthConst.R_teacher})
    @ResponseBody
    public AjaxResult<Object> approval(@RequestParam Integer score_id,
                                       @RequestParam Integer is_approval,
                                       @RequestParam String reason) {
        TeacherInfo teacher = teacherService.selectById(StpUtil.getLoginIdAsInt());
        teacherScoreService.approval(teacher, score_id, is_approval, reason);
        return AjaxResult.SUCCESS();
    }

    @PostMapping("/approval/list")
    @SaCheckRole(value = {AuthConst.R_teacher})
    @ResponseBody
    public AjaxResult<Object> approvalList(@RequestParam Integer[] score_id,
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
    public AjaxResult<Object> enterScore(@RequestBody Map<String, Object> map) {
        TeacherInfo teacher = teacherService.selectById(StpUtil.getLoginIdAsInt());
        int year = (Integer) map.get("year");
        String stuNumber = (String) map.get("stu_number");
        Map<String, String> scoreMap = (Map<String, String>) map.get("score");
        teacherScoreService.enter(teacher, stuNumber, year, scoreMap);
        return AjaxResult.SUCCESS();
    }
}
