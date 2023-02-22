package team.CowsAndHorses.service;


import org.springframework.transaction.annotation.Transactional;
import team.CowsAndHorses.domain.TeacherInfo;
import team.CowsAndHorses.domain.Time;

import java.sql.Date;
import java.util.List;

@Transactional
public interface TimeService {
    Time query(int module, String college, int year);

    List<Time> query(String college, int year);

    void insert(Date ddl, TeacherInfo teacher, Integer year);

    void update(Date ddl, TeacherInfo teacher);
}
