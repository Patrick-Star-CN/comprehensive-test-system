package team.CowsAndHorses.service;


import org.springframework.transaction.annotation.Transactional;
import team.CowsAndHorses.domain.Reason;
import team.CowsAndHorses.domain.TeacherInfo;

import java.util.List;

@Transactional

public interface ReasonService {
    List<Reason> get(TeacherInfo teacher);
    void add(TeacherInfo teacher, String content);
    void delete(TeacherInfo teacher, int id);
    void update(TeacherInfo teacher, int id, String content);
}
