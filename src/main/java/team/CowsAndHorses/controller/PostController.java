package team.CowsAndHorses.controller;


import cn.dev33.satoken.stp.StpUtil;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import team.CowsAndHorses.domain.Post;
import team.CowsAndHorses.domain.StuInfo;
import team.CowsAndHorses.domain.TeacherInfo;
import team.CowsAndHorses.dto.AjaxResult;
import team.CowsAndHorses.service.PostService;
import team.CowsAndHorses.service.StuInfoService;
import team.CowsAndHorses.service.TeacherService;


import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/debate")
@SessionAttributes(names="student",types = StuInfo.class)
public class PostController {
    final PostService postService;
    final StuInfoService stuService;
    final TeacherService teacherService;

    @GetMapping("/post")
    @ResponseBody
    public Object getPost(){
        return AjaxResult.SUCCESS(postService.get());
    }

    @PostMapping("/post")
    @ResponseBody
    public Object submitPost(@RequestBody Map<String, Object> map){
        String content = (String) map.get("content");
        StuInfo stu = stuService.selectById(StpUtil.getLoginIdAsInt());
        if (stu != null) {
            postService.submit(stu, content);
        } else {
            TeacherInfo teacher = teacherService.selectById(StpUtil.getLoginIdAsInt());
            postService.submit(teacher, content);
        }
        return AjaxResult.SUCCESS();
    }

    @DeleteMapping("/post")
    @ResponseBody
    public Object deletePost(@RequestParam Integer post_id){
        StuInfo stu = stuService.selectById(StpUtil.getLoginIdAsInt());
        if (stu != null) {
            postService.delete(stu, post_id);
        } else {
            TeacherInfo teacher = teacherService.selectById(StpUtil.getLoginIdAsInt());
            postService.delete(teacher, post_id);
        }
        return AjaxResult.SUCCESS();
    }

    @PutMapping("/post")
    @ResponseBody
    public Object changePost(@RequestBody Map<String, Object> map){
        String content = (String) map.get("content");
        int postId = (int) map.get("post_id");
        StuInfo stu = stuService.selectById(StpUtil.getLoginIdAsInt());
        if (stu != null) {
            postService.update(stu, postId, content);
        } else {
            TeacherInfo teacher = teacherService.selectById(StpUtil.getLoginIdAsInt());
            postService.update(teacher, postId, content);
        }
        return AjaxResult.SUCCESS();
    }

}
