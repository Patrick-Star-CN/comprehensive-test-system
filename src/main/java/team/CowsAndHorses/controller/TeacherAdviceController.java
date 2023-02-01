package  team.CowsAndHorses.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import team.CowsAndHorses.domain.AdviceEntity;
import team.CowsAndHorses.domain.Teacher;
import team.CowsAndHorses.service.TeacherAdviceService;

import java.util.List;
import java.util.Map;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/teacher")
@SessionAttributes(names = "teacher",types = Teacher.class)
public class TeacherAdviceController {
    final TeacherAdviceService teacherAdviceService;

    @RequestMapping("/get/advice")
    @ResponseBody
    public Result getAdvice(){
        List<AdviceEntity> advice=teacherAdviceService.getAdvice();
        if(advice!=null){
            return new Result(Code.GET_ADVICE_OK,advice,"获取未处理意见成功！");
        }
        return new Result(Code.GET_ADVICE_ERR,null,"获取未处理意见失败或全部已处理！");
    }
    @RequestMapping("/deal/advice")
    @ResponseBody
    public Result dealAdvice(@RequestBody Map<String,Object> map){
        String teacherContent= (String) map.get("teacher_content");
        int id= (int) map.get("id");
        AdviceEntity advice=new AdviceEntity();
        advice.setId(id);
        advice.setTeacherContent(teacherContent);
        if(teacherAdviceService.dealAdvice(advice)>0){
            return new Result(Code.DEAL_ADVICE_OK,null,"处理成功！");
        }
        return new Result(Code.DEAL_ADVICE_ERR,null,"处理失败！");
    }

}
