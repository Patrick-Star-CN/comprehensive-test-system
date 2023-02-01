package  team.CowsAndHorses.controller;


import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import team.CowsAndHorses.domain.ContentEntity;
import team.CowsAndHorses.domain.StuInfoEntity;
import team.CowsAndHorses.service.ContentService;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/student")
@SessionAttributes(names="student",types = StuInfoEntity.class)
public class ContentController {
    final ContentService conservice;

    @RequestMapping("/subcontent")
    @ResponseBody
    public Result subContent(@RequestBody ContentEntity con, HttpSession session){
        Result res=new Result();
        StuInfoEntity tempStu =(StuInfoEntity) session.getAttribute("student");
        String num= tempStu.getStuNumber();
        con.setStuNumber(num);

        int i=0;
        if(conservice.selectCom(con)>0){
            conservice.deleteCon(con);
            i=conservice.subCon(con);
        }
        else{
            i=conservice.subCon(con);
        }

        if(i>0){
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
