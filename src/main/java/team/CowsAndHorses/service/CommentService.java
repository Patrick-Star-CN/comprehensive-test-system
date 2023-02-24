package team.CowsAndHorses.service;

import org.springframework.transaction.annotation.Transactional;
import team.CowsAndHorses.domain.Comment;
import team.CowsAndHorses.domain.Post;
import team.CowsAndHorses.domain.StuInfo;
import team.CowsAndHorses.domain.TeacherInfo;

import java.util.List;

@Transactional
public interface CommentService {
    void submit(TeacherInfo teacher, String content, int postId);

    void submit(StuInfo stu, String content, int postId);

    void update(TeacherInfo teacher, int commentId, String content);

    void update(StuInfo stu, int commentId, String content);

    void delete(TeacherInfo teacher, int commentId);

    void delete(StuInfo stu, int commentId);

    List<Comment> get(int postId);
}
