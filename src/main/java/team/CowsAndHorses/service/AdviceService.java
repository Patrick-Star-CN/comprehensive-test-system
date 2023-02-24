package team.CowsAndHorses.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;
import team.CowsAndHorses.domain.Advice;
import team.CowsAndHorses.domain.StuInfo;
import team.CowsAndHorses.domain.TeacherInfo;

import java.util.List;

@Transactional
public interface AdviceService {

    void submit(StuInfo stu, String content, int moduleId, int isAnonymous);

    void change(StuInfo stu, String content, int adviceId);

    void process(TeacherInfo teacher, String content, int adviceId);

    List<Advice> query(StuInfo stu);

    List<Advice> query(TeacherInfo teacher);
}
