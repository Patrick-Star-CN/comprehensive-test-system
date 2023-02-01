package team.CowsAndHorses.service;

import org.springframework.transaction.annotation.Transactional;
import team.CowsAndHorses.domain.AppealEntity;

@Transactional
public interface AppealService {
    public int submit(AppealEntity apl);
}
