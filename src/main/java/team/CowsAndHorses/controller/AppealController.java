package  team.CowsAndHorses.controller;


import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import team.CowsAndHorses.domain.AppealEntity;
import team.CowsAndHorses.domain.StuInfoEntity;
import team.CowsAndHorses.service.AppealService;


@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/student")
@SessionAttributes(names="student",types = StuInfoEntity.class)
public class AppealController {

    final AppealService appservice;

    @RequestMapping("/submitappeal")
    @ResponseBody
    public Result submitAppeal(@RequestBody AppealEntity app, HttpSession session){
        Result res=new Result();
        StuInfoEntity tempStu =(StuInfoEntity) session.getAttribute("student");
        String num= tempStu.getStuNumber();

        app.setStuNumber(num);
        app.setStatus("1");
        app.setIsApproval(1);

        if(appservice.submit(app)>0) {
            res.setCode(3);
            res.setData(null);
            res.setMsg("申诉成功");
            return res;
        }
        else{
            res.setCode(3);
            res.setData(null);
            res.setMsg("申诉失败");
            return res;
        }
    }
}
