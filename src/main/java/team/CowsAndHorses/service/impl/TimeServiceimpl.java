package team.CowsAndHorses.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import team.CowsAndHorses.dao.TimeDao;
import team.CowsAndHorses.domain.Time;
import team.CowsAndHorses.service.TimeService;

@RequiredArgsConstructor
@CacheConfig(cacheNames = "ExpireOneMin")
@Service
public class TimeServiceimpl implements TimeService {
    final TimeDao timedao;

    @Override
    public Time getTime(Time t) {
        return timedao.getTime(t);
    }
}
