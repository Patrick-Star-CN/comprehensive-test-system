package team.CowsAndHorses.service;


import org.springframework.transaction.annotation.Transactional;
import team.CowsAndHorses.domain.Post;
import team.CowsAndHorses.domain.StuInfo;
import team.CowsAndHorses.domain.TeacherInfo;

import java.util.List;

@Transactional
public interface PostService {
    void submit(TeacherInfo teacher, String content);

    void submit(StuInfo stu, String content);

    void update(TeacherInfo teacher, int postId, String content);

    void update(StuInfo stu, int postId, String content);

    void delete(TeacherInfo teacher, int postId);

    void delete(StuInfo stu, int postId);

    List<Post> get();
}
