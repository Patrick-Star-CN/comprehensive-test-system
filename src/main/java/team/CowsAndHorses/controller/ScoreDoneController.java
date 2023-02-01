package  team.CowsAndHorses.controller;

import team.CowsAndHorses.domain.ScoreDoneEntity;
import  team.CowsAndHorses.domain.ScoreEntity;


import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import team.CowsAndHorses.domain.StuInfoEntity;
import team.CowsAndHorses.service.StudentScoreService;

import java.util.List;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/student")
@SessionAttributes(names="student",types = StuInfoEntity.class)
public class ScoreDoneController {
    final StudentScoreService studentScoreService;



    @PostMapping("/getreason")
    @ResponseBody
    public Result getReason(@RequestBody int year, HttpSession session){
        Result res=new Result();
        StuInfoEntity tempStu = (StuInfoEntity) session.getAttribute("student");
        String num = tempStu.getStuNumber();
        ScoreDoneEntity scoDo =new ScoreDoneEntity();
        scoDo.setYear(year);
        scoDo.setStuNumber(num);
        int s=studentScoreService.getReason(num,year);
        List<Integer> list=studentScoreService.getIsApproval(scoDo);
        int isApproval=1;
        for(Integer i:list){
            if(i==0){
                isApproval=0;
                break;
            }

        }

        if(isApproval==0){
            if(s>0){
                res.setCode(3);
                res.setData(s);
                res.setMsg("获取理由成功");
                return res;
            }
            else{
                res.setCode(3);
                res.setData(s);
                res.setMsg("获取理由失败");
                return res;
            }
        }
        else{
            res.setCode(3);
            res.setData(null);
            res.setMsg("已全部通过");
            return res;
        }
    }
}
