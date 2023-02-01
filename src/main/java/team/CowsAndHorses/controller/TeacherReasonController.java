package  team.CowsAndHorses.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import team.CowsAndHorses.domain.ReasonEntity;
import team.CowsAndHorses.domain.Teacher;
import team.CowsAndHorses.service.TeacherReasonService;

import java.util.List;
import java.util.Map;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/teacher")
@SessionAttributes(names = "teacher",types = Teacher.class)
public class TeacherReasonController {
    final TeacherReasonService teacherReasonService;

    @RequestMapping(value="/get/reasons")
    @ResponseBody
    public Result getReason(){
        List<ReasonEntity> reason = teacherReasonService.getReason();
       if (reason!=null) return new Result(Code.GET_REASON_OK,reason,"获取理由库成功！");
       return new Result(Code.GET_REASON_ERR,null,"获取理由库失败！");
    }
    @RequestMapping("/set/reason")
    @ResponseBody
    public Result setReason(@RequestBody Map<String,Object> map){
        boolean is_add= (boolean) map.get("is_add");
        boolean is_delete=(boolean) map.get("is_delete");
        if(is_add){
            String content= (String) map.get("content");
            if(teacherReasonService.addReason(content)>0) {
                return new Result(Code.ADD_REASON_OK,true,"添加成功！");
            }
            return new Result(Code.ADD_REASON_ERR,false,"添加失败！");
            }
        if(is_delete){
            int id= (int) map.get("id");
            if(teacherReasonService.deleteReason(id)>0){
                return  new Result(Code.DELETE_REASON_OK,true,"删除成功！");
            }
            return new Result(Code.DELETE_REASON_ERR,false,"删除失败!");
        }
          return  new Result(Code.SET_REASON_OK,null,"未操作理由库");
    }

}
