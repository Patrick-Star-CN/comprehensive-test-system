package team.CowsAndHorses.controller;


import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.stp.StpUtil;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import team.CowsAndHorses.constant.AuthConst;
import team.CowsAndHorses.domain.Appeal;
import team.CowsAndHorses.domain.StuInfo;
import team.CowsAndHorses.dto.AjaxResult;
import team.CowsAndHorses.service.AppealService;
import team.CowsAndHorses.service.StuInfoService;


@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/student")
@SessionAttributes(names="student",types = StuInfo.class)
public class AppealController {

    final AppealService appealService;
    final StuInfoService stuService;

    @PostMapping("/submit/appeal")
    @SaCheckRole(AuthConst.R_student)
    @ResponseBody
    public Object submitAppeal(@RequestParam String content, @RequestParam Integer year, @RequestParam Integer module_id){
        StuInfo stu = stuService.selectById(StpUtil.getLoginIdAsInt());
        appealService.submit(stu, content, year, module_id);
        return AjaxResult.SUCCESS();
    }

    @GetMapping("/query/appeal")
    @SaCheckRole(AuthConst.R_student)
    @ResponseBody
    public Object queryAppeal(@RequestParam Integer year){
        StuInfo stu = stuService.selectById(StpUtil.getLoginIdAsInt());
        return AjaxResult.SUCCESS(appealService.query(stu, year));
    }
}
