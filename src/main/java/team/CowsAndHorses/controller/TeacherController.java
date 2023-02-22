package team.CowsAndHorses.controller;


import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.stp.StpUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import team.CowsAndHorses.constant.AuthConst;
import team.CowsAndHorses.constant.ErrorCode;
import team.CowsAndHorses.domain.TeacherInfo;
import team.CowsAndHorses.dto.AjaxResult;
import team.CowsAndHorses.exception.AppException;
import team.CowsAndHorses.service.TeacherService;
import team.CowsAndHorses.service.TimeService;

import java.sql.Date;
import java.util.Map;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/teacher")
@SessionAttributes(names = "teacher", types = TeacherInfo.class)
public class TeacherController {

    final TeacherService teacherService;
    final TimeService timeService;

    @PostMapping("/login")
    @ResponseBody
    public Object login(@RequestBody Map<String, Object> map) {
        String username = (String) map.get("username");
        String password = (String) map.get("password");
        if (username == null || password == null) {
            throw new AppException(ErrorCode.PARAM_ERROR);
        }
        TeacherInfo teacher = teacherService.login(username, password);
        if (teacher == null) {
            throw new AppException(ErrorCode.PASSWORD_OR_STUDENT_ID_ERROR);
        }
        StpUtil.logout(teacher.getId());
        StpUtil.login(teacher.getId());
        return AjaxResult.SUCCESS(teacher.getModuleId());
    }

    @PostMapping(value = "/change/password")
    @SaCheckRole(value = {AuthConst.R_teacher})
    @ResponseBody
    public Object update(@RequestBody Map<String, Object> map) {
        TeacherInfo teacher = teacherService.selectById(StpUtil.getLoginIdAsInt());
        String pwd = teacher.getPassword();
        String oldPassword = (String) map.get("old_password");
        String newPassword = (String) map.get("new_password");
        if (pwd.equals(oldPassword) && newPassword != null) {
            teacher.setPassword(newPassword);
            teacherService.changePassword(teacher);
            return AjaxResult.SUCCESS();
        } else {
            return AjaxResult.FAIL("修改失败");
        }
    }

    @PostMapping("/set/time")
    @SaCheckRole(value = {AuthConst.R_teacher})
    @ResponseBody
    public Object setTime(@RequestBody Map<String, Object> map) {
        TeacherInfo teacher = teacherService.selectById(StpUtil.getLoginIdAsInt());
        Date ddl = Date.valueOf((String) map.get("ddl"));
        int year = (int) map.get("year");
        if (timeService.query(teacher.getModuleId(), teacher.getCollege(), year) != null) {
            timeService.update(ddl, teacher);
        } else {
            timeService.insert(ddl, teacher, year);
        }
        return AjaxResult.SUCCESS();
    }

}
