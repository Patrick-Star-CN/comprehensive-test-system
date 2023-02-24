package team.CowsAndHorses.controller;


import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.stp.StpUtil;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import team.CowsAndHorses.constant.AuthConst;
import team.CowsAndHorses.domain.Advice;
import team.CowsAndHorses.domain.StuInfo;
import team.CowsAndHorses.domain.TeacherInfo;
import team.CowsAndHorses.dto.AjaxResult;
import team.CowsAndHorses.service.AdviceService;
import team.CowsAndHorses.service.StuInfoService;

import java.util.Map;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/student")
@SessionAttributes(names="student",types = StuInfo.class)
public class AdviceController {
    final AdviceService adviceService;
    final StuInfoService stuService;

    @RequestMapping("/submit/advice")
    @SaCheckRole(AuthConst.R_student)
    @ResponseBody
    public Object submitAdvice(@RequestBody Map<String, Object> map){
        StuInfo stu = stuService.selectById(StpUtil.getLoginIdAsInt());
        String content = (String) map.get("content");
        int moduleId = (int) map.get("module_id");
        int isAnonymous = (int) map.get("is_anonymous");
        adviceService.submit(stu, content, moduleId, isAnonymous);
        return AjaxResult.SUCCESS();
    }

    @GetMapping("/get/advice")
    @SaCheckRole(AuthConst.R_student)
    @ResponseBody
    public Object getAdvice(){
        StuInfo stu = stuService.selectById(StpUtil.getLoginIdAsInt());
        return AjaxResult.SUCCESS(adviceService.query(stu));
    }

    @PostMapping("/change/advice")
    @SaCheckRole(AuthConst.R_student)
    @ResponseBody
    public Object changeAdvice(@RequestBody Map<String, Object> map){
        StuInfo stu = stuService.selectById(StpUtil.getLoginIdAsInt());
        String content = (String) map.get("content");
        int adviceId = (int) map.get("advice_id");
        adviceService.change(stu, content, adviceId);
        return AjaxResult.SUCCESS();
    }
}
