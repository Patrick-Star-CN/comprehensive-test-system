package  team.CowsAndHorses.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import team.CowsAndHorses.domain.StuInfoEntity;
import team.CowsAndHorses.domain.Time;
import team.CowsAndHorses.service.TimeService;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/student")
@SessionAttributes(names="student",types = StuInfoEntity.class)
public class TimeController {
    final TimeService timeservice;

    @RequestMapping("/gettime")
    @ResponseBody
    public Result getTime(@RequestBody Time t){
        Result res=new Result();
        Time temp=timeservice.getTime(t);
        if(temp!=null){
            res.setCode(1);
            res.setMsg("获取时间成功");
            res.setData(temp);
        }
        else{
            res.setCode(1);
            res.setMsg("获取时间失败");
            res.setData(temp);
        }
        return res;
    }
}
