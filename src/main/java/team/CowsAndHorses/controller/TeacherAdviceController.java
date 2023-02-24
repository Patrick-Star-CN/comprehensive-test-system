package team.CowsAndHorses.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.stp.StpUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import team.CowsAndHorses.constant.AuthConst;
import team.CowsAndHorses.domain.TeacherInfo;
import team.CowsAndHorses.dto.AjaxResult;
import team.CowsAndHorses.service.AdviceService;
import team.CowsAndHorses.service.TeacherService;

import java.util.Map;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/teacher")
public class TeacherAdviceController {
    final AdviceService adviceService;
    final TeacherService teacherService;

    @GetMapping("/get/advice")
    @SaCheckRole(value = {AuthConst.R_teacher})
    @ResponseBody
    public Object getAdvice(){
        TeacherInfo teacher = teacherService.selectById(StpUtil.getLoginIdAsInt());
        return AjaxResult.SUCCESS(adviceService.query(teacher));
    }

    @PostMapping("/deal/advice")
    @SaCheckRole(value = {AuthConst.R_teacher})
    @ResponseBody
    public Object dealAdvice(@RequestBody Map<String, Object> map){
        TeacherInfo teacher = teacherService.selectById(StpUtil.getLoginIdAsInt());
        String content = (String) map.get("content");
        int adviceId = (int) map.get("advice_id");
        adviceService.process(teacher, content, adviceId);
        return AjaxResult.SUCCESS();
    }

}
