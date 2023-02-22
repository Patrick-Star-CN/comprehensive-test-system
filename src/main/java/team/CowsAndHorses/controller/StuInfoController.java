package team.CowsAndHorses.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.stp.StpUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import team.CowsAndHorses.constant.AuthConst;
import team.CowsAndHorses.constant.ErrorCode;
import team.CowsAndHorses.domain.StuInfo;
import team.CowsAndHorses.dto.AjaxResult;
import team.CowsAndHorses.exception.AppException;
import team.CowsAndHorses.service.StuInfoService;

import java.util.Map;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/student")
@SessionAttributes(names = "student", types = StuInfo.class)
public class StuInfoController {

    @Autowired
    private StuInfoService stuservice;

    @PostMapping("/login")
    @ResponseBody
    public Object login(@RequestBody Map<String, Object> map) {
        String stuNumber = (String) map.get("stu_number");
        String stuPassword = (String) map.get("stu_password");
        if (stuNumber == null || stuPassword == null) {
            throw new AppException(ErrorCode.PARAM_ERROR);
        }
        StuInfo stu = stuservice.login(stuNumber, stuPassword);
        if (stu == null) {
            throw new AppException(ErrorCode.PASSWORD_OR_STUDENT_ID_ERROR);
        }
        StpUtil.logout(stu.getId());
        StpUtil.login(stu.getId());
        return AjaxResult.SUCCESS();
    }

    @PostMapping("/change/password")
    @SaCheckRole(AuthConst.R_student)
    @ResponseBody
    public Object changePsd(@RequestBody Map<String, Object> map) {
        StuInfo stu = stuservice.selectById(StpUtil.getLoginIdAsInt());
        String pwd = stu.getStuPassword();
        String oldPassword = (String) map.get("old_password");
        String newPassword = (String) map.get("new_password");
        if (pwd.equals(oldPassword) && newPassword != null) {
            stu.setStuPassword(newPassword);
            stuservice.changePassword(stu);
            return AjaxResult.SUCCESS();
        } else {
            return AjaxResult.FAIL("修改失败");
        }
    }
}
