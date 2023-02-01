package  team.CowsAndHorses.controller;


import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import team.CowsAndHorses.domain.PostEntity;
import team.CowsAndHorses.domain.StuInfoEntity;
import team.CowsAndHorses.service.PostService;


import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/debate")
@SessionAttributes(names="student",types = StuInfoEntity.class)
public class PostController {
    final PostService poservice;

    @RequestMapping("/post")
    @ResponseBody
    public Result subPost(@RequestBody PostEntity poentity, HttpSession session){
        Result res=new Result();
        StuInfoEntity temp_stu=(StuInfoEntity)session.getAttribute("student");
        String name=temp_stu.getStuName();
        poentity.setNickName(name);

        Date date=new Date();
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);
        ParsePosition pos=new ParsePosition(8);
        Date current_time=formatter.parse(dateString,pos);
        poentity.setCreateTime(current_time);

        if(poservice.subPost(poentity)>0){
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
    public Result updatePost(@RequestBody PostEntity poentity,HttpSession session){
        Result res=new Result();
        StuInfoEntity temp_stu=(StuInfoEntity)session.getAttribute("student");
        String name=temp_stu.getStuName();
        poentity.setNickName(name);

        Date date=new Date();
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);
        ParsePosition pos=new ParsePosition(8);
        Date current_time=formatter.parse(dateString,pos);
        poentity.setCreateTime(current_time);

        if(poservice.updatePost(poentity)>0){
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
    public Result deletePost(@RequestBody PostEntity poentity){
        Result res=new Result();
        if(poservice.deletePost(poentity)>0){
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

    @RequestMapping("getpost")
    @ResponseBody
    public Result getPost(@RequestBody PostEntity poentity){
        Result res =new Result();
        List<PostEntity> p= poservice.getPost(poentity);
        if(p!=null){
            res.setCode(3);
            res.setData(p);
            res.setMsg("获取成功");
            return res;
        }
        else{
            res.setCode(3);
            res.setData(p);
            res.setMsg("获取失败");
            return res;
        }
    }

}
