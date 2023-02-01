package team.CowsAndHorses.service;


import org.springframework.transaction.annotation.Transactional;
import team.CowsAndHorses.domain.ReasonEntity;

import java.util.List;

@Transactional

public interface TeacherReasonService {
    public List<ReasonEntity> getReason();
    public int addReason(String content);
    public int deleteReason(int id);
}
