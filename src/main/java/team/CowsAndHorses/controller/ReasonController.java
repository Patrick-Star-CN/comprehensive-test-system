package team.CowsAndHorses.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.stp.StpUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import team.CowsAndHorses.constant.AuthConst;
import team.CowsAndHorses.domain.TeacherInfo;
import team.CowsAndHorses.dto.AjaxResult;
import team.CowsAndHorses.service.ReasonService;
import team.CowsAndHorses.service.TeacherService;

import java.util.Map;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/teacher")
public class ReasonController {
    final ReasonService reasonService;
    final TeacherService teacherService;

    @GetMapping(value="/reason")
    @SaCheckRole(value = {AuthConst.R_teacher})
    @ResponseBody
    public Object getReason(){
        TeacherInfo teacher = teacherService.selectById(StpUtil.getLoginIdAsInt());
        return AjaxResult.SUCCESS(reasonService.get(teacher));
    }

    @PostMapping("/reason")
    @SaCheckRole(value = {AuthConst.R_teacher})
    @ResponseBody
    public Object setReason(@RequestBody Map<String,Object> map){
        TeacherInfo teacher = teacherService.selectById(StpUtil.getLoginIdAsInt());
        String content= (String) map.get("content");
        reasonService.add(teacher, content);
        return AjaxResult.SUCCESS();
    }

    @DeleteMapping(value="/reason")
    @SaCheckRole(value = {AuthConst.R_teacher})
    @ResponseBody
    public Object deleteReason(@RequestParam Integer reason_id){
        TeacherInfo teacher = teacherService.selectById(StpUtil.getLoginIdAsInt());
        reasonService.delete(teacher, reason_id);
        return AjaxResult.SUCCESS();
    }

    @PutMapping("/reason")
    @SaCheckRole(value = {AuthConst.R_teacher})
    @ResponseBody
    public Object changeReason(@RequestParam Integer reason_id, @RequestBody Map<String,Object> map){
        TeacherInfo teacher = teacherService.selectById(StpUtil.getLoginIdAsInt());
        String content= (String) map.get("content");
        reasonService.update(teacher, reason_id, content);
        return AjaxResult.SUCCESS();
    }
}
