package team.CowsAndHorses.controller;


import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.stp.StpUtil;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import team.CowsAndHorses.constant.AuthConst;
import team.CowsAndHorses.domain.Score;
import team.CowsAndHorses.domain.StuInfo;
import team.CowsAndHorses.dto.AjaxResult;
import team.CowsAndHorses.dto.ScoreDto;
import team.CowsAndHorses.service.StuInfoService;
import team.CowsAndHorses.service.StudentScoreService;


@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/student")
@SessionAttributes(names = "student", types = StuInfo.class)
public class ScoreController {
    final private StudentScoreService scoservice;

    final private StuInfoService stuservice;

    @GetMapping("/query/myself")
    @SaCheckRole(value = {AuthConst.R_student})
    @ResponseBody
    public Object queryMyScore(@RequestParam Integer year) {
        StuInfo stu = stuservice.selectById(StpUtil.getLoginIdAsInt());
        return AjaxResult.SUCCESS(scoservice.queryScore(stu, stu.getStuNumber(), year));
    }

    @GetMapping("/query/others/{stu_number}")
    @SaCheckRole(value = {AuthConst.R_student})
    @ResponseBody
    public Object queryOtherScore(@PathVariable String stu_number, @RequestParam Integer year) {
        StuInfo stu = stuservice.selectById(StpUtil.getLoginIdAsInt());
        return AjaxResult.SUCCESS(scoservice.queryScore(stu, stu_number, year));
    }

    @PostMapping("/declaration/submit")
    @SaCheckRole(value = {AuthConst.R_student})
    @ResponseBody
    public Object subScore(@RequestBody ScoreDto sco) {
        StuInfo stu = stuservice.selectById(StpUtil.getLoginIdAsInt());
        scoservice.subScore(sco, stu);
        return AjaxResult.SUCCESS();
    }

    @GetMapping("/check")
    @SaCheckRole(value = {AuthConst.R_student})
    @ResponseBody
    public Object checkScore(@RequestParam Integer year) {
        StuInfo stu = stuservice.selectById(StpUtil.getLoginIdAsInt());
        return AjaxResult.SUCCESS(scoservice.checkApproval(stu.getId(), year));
    }

    @GetMapping("/get/reason")
    @SaCheckRole(value = {AuthConst.R_student})
    @ResponseBody
    public Object getReason(@RequestParam Integer year) {
        StuInfo stu = stuservice.selectById(StpUtil.getLoginIdAsInt());
        return AjaxResult.SUCCESS(scoservice.getReason(stu.getId(), year));
    }
}