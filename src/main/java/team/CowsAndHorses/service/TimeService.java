package team.CowsAndHorses.service;


import org.springframework.transaction.annotation.Transactional;
import team.CowsAndHorses.domain.Time;

@Transactional
public interface TimeService {
    public Time getTime(Time t);
}
