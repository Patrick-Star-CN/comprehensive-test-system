package team.CowsAndHorses.controller;


import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.stp.StpUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import team.CowsAndHorses.constant.AuthConst;
import team.CowsAndHorses.domain.StuInfo;
import team.CowsAndHorses.domain.Time;
import team.CowsAndHorses.dto.AjaxResult;
import team.CowsAndHorses.service.StuInfoService;
import team.CowsAndHorses.service.TimeService;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/student")
@SessionAttributes(names="student",types = StuInfo.class)
public class TimeController {
    final StuInfoService stuInfoService;
    final TimeService timeservice;

    @GetMapping("/time")
    @SaCheckRole(value = {AuthConst.R_student})
    @ResponseBody
    public Object getTime(@RequestParam Integer year){
        StuInfo stu = stuInfoService.selectById(StpUtil.getLoginIdAsInt());
        return AjaxResult.SUCCESS(timeservice.query(stu.getStuCollege(), year));
    }
}
