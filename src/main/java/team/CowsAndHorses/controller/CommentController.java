package  team.CowsAndHorses.controller;



import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import team.CowsAndHorses.domain.CommentEntity;
import team.CowsAndHorses.domain.StuInfoEntity;
import team.CowsAndHorses.service.CommentService;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/comment")
@SessionAttributes(names="student",types = StuInfoEntity.class)
public class CommentController {
    final CommentService comservice;

    @RequestMapping("/post")
    @ResponseBody
    public Result subComment(@RequestBody CommentEntity comentity, HttpSession session){
        Result res =new Result();
        StuInfoEntity temp_stu=(StuInfoEntity)session.getAttribute("student");
        String name=temp_stu.getStuName();
        comentity.setNickName(name);

        Date date=new Date();
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);
        ParsePosition pos=new ParsePosition(8);
        Date current_time=formatter.parse(dateString,pos);
        comentity.setCreateTime(current_time);

        if(comservice.subComment(comentity)>0){
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

    @RequestMapping("/update")
    @ResponseBody
    public Result update(@RequestBody CommentEntity comentity, HttpSession session){
        Result res=new Result();
        StuInfoEntity temp_stu=(StuInfoEntity)session.getAttribute("student");
        String name=temp_stu.getStuName();
        comentity.setNickName(name);

        Date date=new Date();
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);
        ParsePosition pos=new ParsePosition(8);
        Date current_time=formatter.parse(dateString,pos);
        comentity.setCreateTime(current_time);

        if(comservice.update(comentity)>0){
            res.setCode(3);
            res.setData(null);
            res.setMsg("修改成功");
            return res;
        }
        else{
            res.setCode(3);
            res.setData(null);
            res.setMsg("修改失败");
            return res;
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Result deletePost(@RequestBody CommentEntity comentity){
        Result res=new Result();
        if(comservice.deleteCom(comentity)>0){
            res.setCode(3);
            res.setData(null);
            res.setMsg("删除成功");
            return res;
        }
        else{
            res.setCode(3);
            res.setData(null);
            res.setMsg("删除失败");
            return res;
        }
    }

    @RequestMapping("/getcomment")
    @ResponseBody
    public Result getCom(@RequestBody CommentEntity comentity){
        Result res=new Result();
        List<CommentEntity> com= comservice.getCom(comentity);
        if(com!=null){
            res.setCode(3);
            res.setData(com);
            res.setMsg("获取成功");
            return res;
        }
        else{
            res.setCode(3);
            res.setData(null);
            res.setMsg("获取失败");
            return res;
        }
    }
}
