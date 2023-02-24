package team.CowsAndHorses.controller;



import cn.dev33.satoken.stp.StpUtil;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import team.CowsAndHorses.domain.Comment;
import team.CowsAndHorses.domain.StuInfo;
import team.CowsAndHorses.domain.TeacherInfo;
import team.CowsAndHorses.dto.AjaxResult;
import team.CowsAndHorses.service.CommentService;
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
public class CommentController {
    final CommentService comservice;
    final StuInfoService stuService;
    final TeacherService teacherService;

    @GetMapping("/comment")
    @ResponseBody
    public Object getComment(@RequestParam Integer post_id){
        return AjaxResult.SUCCESS(comservice.get(post_id));
    }

    @PostMapping("/comment")
    @ResponseBody
    public Object submitComment(@RequestBody Map<String, Object> map){
        String content = (String) map.get("content");
        int postId = (int) map.get("post_id");
        StuInfo stu = stuService.selectById(StpUtil.getLoginIdAsInt());
        if (stu != null) {
            comservice.submit(stu, content, postId);
        } else {
            TeacherInfo teacher = teacherService.selectById(StpUtil.getLoginIdAsInt());
            comservice.submit(teacher, content, postId);
        }
        return AjaxResult.SUCCESS();
    }

    @DeleteMapping("/comment")
    @ResponseBody
    public Object deleteComment(@RequestParam Integer comment_id){
        StuInfo stu = stuService.selectById(StpUtil.getLoginIdAsInt());
        if (stu != null) {
            comservice.delete(stu, comment_id);
        } else {
            TeacherInfo teacher = teacherService.selectById(StpUtil.getLoginIdAsInt());
            comservice.delete(teacher, comment_id);
        }
        return AjaxResult.SUCCESS();
    }

    @PutMapping("/comment")
    @ResponseBody
    public Object changeComment(@RequestBody Map<String, Object> map){
        String content = (String) map.get("content");
        int commentId = (int) map.get("comment_id");
        StuInfo stu = stuService.selectById(StpUtil.getLoginIdAsInt());
        if (stu != null) {
            comservice.update(stu, commentId, content);
        } else {
            TeacherInfo teacher = teacherService.selectById(StpUtil.getLoginIdAsInt());
            comservice.update(teacher, commentId, content);
        }
        return AjaxResult.SUCCESS();
    }
}
