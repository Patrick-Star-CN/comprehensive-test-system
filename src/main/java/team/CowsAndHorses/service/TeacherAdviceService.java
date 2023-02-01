package team.CowsAndHorses.service;


import org.springframework.transaction.annotation.Transactional;
import team.CowsAndHorses.domain.AdviceEntity;

import java.util.List;

@Transactional
public interface TeacherAdviceService {
    public List<AdviceEntity> getAdvice ();
    public int dealAdvice(AdviceEntity advice);

}
