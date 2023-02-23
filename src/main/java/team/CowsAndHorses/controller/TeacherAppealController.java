package team.CowsAndHorses.controller;


import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.stp.StpUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import team.CowsAndHorses.constant.AuthConst;
import team.CowsAndHorses.domain.TeacherInfo;
import team.CowsAndHorses.dto.AjaxResult;
import team.CowsAndHorses.service.AppealService;
import team.CowsAndHorses.service.TeacherService;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/teacher")
public class TeacherAppealController {
    final AppealService appealService;
    final TeacherService teacherService;

    @GetMapping("/get/appeal")
    @SaCheckRole(value = {AuthConst.R_teacher})
    @ResponseBody
    public Object getAppeal(@RequestParam Integer year){
        TeacherInfo teacher = teacherService.selectById(StpUtil.getLoginIdAsInt());
        return AjaxResult.SUCCESS(appealService.query(teacher, year));
    }

    @RequestMapping("/appeal")
    @SaCheckRole(value = {AuthConst.R_teacher})
    @ResponseBody
    public Object isAppeal(@RequestParam Integer appeal_id, @RequestParam Integer is_approval){
        TeacherInfo teacher = teacherService.selectById(StpUtil.getLoginIdAsInt());
        appealService.updateStatus(teacher, appeal_id, is_approval);
        return AjaxResult.SUCCESS();
    }

}
