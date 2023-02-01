package  team.CowsAndHorses.controller;


import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import team.CowsAndHorses.domain.ScoreEntity;
import team.CowsAndHorses.domain.StuInfoEntity;
import team.CowsAndHorses.service.StudentScoreService;


@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/student")
@SessionAttributes(names="student",types = StuInfoEntity.class)
public class ScoreController {
    @Autowired
    private StudentScoreService scoservice;

    @PostMapping("/query/myself")
    @ResponseBody
    public Result queryMyScore(@RequestBody ScoreEntity sco, HttpSession session) {
        Result res = new Result();
        StuInfoEntity tempstu = (StuInfoEntity) session.getAttribute("student");
        String num = tempstu.getStuNumber();
        sco.setStuNumber(num);
        ScoreEntity s = scoservice.queryMyScore(sco);
        if (s != null) {
            res.setCode(3);
            res.setData(s);
            res.setMsg("查询成功");
            return res;
        } else {
            res.setCode(3);
            res.setData(s);
            res.setMsg("查询失败");
            return res;
        }
    }

    @PostMapping("/query/others")
    @ResponseBody
    public Result queryOtherScore(@RequestBody ScoreEntity sco) {
        Result res = new Result();
        ScoreEntity s = scoservice.queryOtherScore(sco);
        if (s != null) {
            res.setCode(3);
            res.setData(s);
            res.setMsg("查询成功");
            return res;
        } else {
            res.setCode(3);
            res.setData(s);
            res.setMsg("查询失败");
            return res;
        }
    }

    @PostMapping("/submitdeclaration")
    @ResponseBody
    public Result subScore(@RequestBody ScoreEntity sco, HttpSession session) {
        Result res = new Result();
        StuInfoEntity tempStu = (StuInfoEntity) session.getAttribute("student");
        String num = tempStu.getStuNumber();
        sco.setStuNumber(num);
        if (scoservice.subScore(sco) > 0) {
            res.setCode(3);
            res.setData(null);
            res.setMsg("提交成功");
            return res;
        } else {
            res.setCode(3);
            res.setData(null);
            res.setMsg("提交失败");
            return res;
        }
    }


}


//
//}
