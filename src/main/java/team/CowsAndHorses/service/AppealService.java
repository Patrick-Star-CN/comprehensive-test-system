package team.CowsAndHorses.service;

import org.springframework.transaction.annotation.Transactional;
import team.CowsAndHorses.domain.Appeal;
import team.CowsAndHorses.domain.StuInfo;
import team.CowsAndHorses.domain.TeacherInfo;

import java.util.List;

@Transactional
public interface AppealService {
    void submit(StuInfo stu, String content, int year, int moduleId);

    List<Appeal> query(StuInfo stu, int year);

    List<Appeal> query(TeacherInfo teacher, int year);

    void updateStatus(TeacherInfo teacher, int appealId, int status);
}
