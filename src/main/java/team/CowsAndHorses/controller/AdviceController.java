package  team.CowsAndHorses.controller;


import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import team.CowsAndHorses.domain.AdviceEntity;
import team.CowsAndHorses.domain.StuInfoEntity;
import team.CowsAndHorses.service.AdviceService;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/student")
@SessionAttributes(names="student",types = StuInfoEntity.class)
public class AdviceController {
    final AdviceService adviceService;

    @RequestMapping("/submitadvice")
    @ResponseBody
    public Result submitAdvice(@RequestBody AdviceEntity adv, HttpSession session){
        Result res=new Result();
        StuInfoEntity tempStu =(StuInfoEntity) session.getAttribute("student");
        adv.setStatus(0);
        if(adviceService.submint(adv.getStuNumber(),adv.getStuContent(), adv.getTeacherContent(),adv.getStatus())>0) {
            res.setCode(3);
            res.setData(null);
            res.setMsg("提交成功");
            return res;
        }
        else{
            res.setCode(3);
            res.setData(null);
            res.setMsg("提交失败");
            return res;
        }
    }
}
