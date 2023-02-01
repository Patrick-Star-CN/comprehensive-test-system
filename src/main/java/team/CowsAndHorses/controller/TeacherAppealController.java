package  team.CowsAndHorses.controller;


import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import team.CowsAndHorses.domain.AppealEntity;
import team.CowsAndHorses.domain.Teacher;
import team.CowsAndHorses.service.TeacherAppealService;

import java.util.List;
import java.util.Map;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/teacher")
@SessionAttributes(names = "teacher",types = Teacher.class)
public class TeacherAppealController {
    final TeacherAppealService teacherAppealService;

    @RequestMapping("/get/appeal")
    @ResponseBody
    public Result getAppeal(@Param("year") int year, HttpSession session){
        Teacher t= (Teacher) session.getAttribute("teacher");
        int moduleId=t.getModuleId();
        List<AppealEntity> appeal = teacherAppealService.getAppeal(year, moduleId);
        System.out.println(appeal.size());
        if(appeal!=null){
            return new Result(Code.GET_APPEAL_OK,appeal,"获取申诉列表成功！");

        }
        return new Result(Code.APPROVAL_ERR,null,"获取申诉列表失败！");
    }


    @RequestMapping("/appeal")
    @ResponseBody
    public Result isAppeal(@RequestBody Map<String, Object> map, HttpSession session){
        int is_approval= (int) map.get("is_approval");
        int appeal_id=(int)map.get("appeal_id");
        if(is_approval==1){
            if(teacherAppealService.isAppeal(is_approval,appeal_id)>0){
                return new Result(Code.APPEAL_OK,true,"申诉通过");
            }
            else return new Result(Code.APPEAL_ERR,false,"未成功审批通过申诉");
        }
        else {
            if(teacherAppealService.isnotAppeal(is_approval,appeal_id)>0){
                return new Result(Code.APPEAL_OK,true,"申诉失败");
            }
            else return new Result(Code.APPEAL_ERR,false,"未成功审批不通过申诉");
        }
    }

}
