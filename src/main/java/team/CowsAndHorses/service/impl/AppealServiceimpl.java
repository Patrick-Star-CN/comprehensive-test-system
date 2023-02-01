package team.CowsAndHorses.service.impl;
import team.CowsAndHorses.dao.AppealDao;
import team.CowsAndHorses.domain.AppealEntity;
import team.CowsAndHorses.service.AppealService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@CacheConfig(cacheNames = "ExpireOneMin")
@Service
public class AppealServiceimpl implements AppealService {
    final AppealDao appdao;

    @Override
    public int submit(AppealEntity apl) {
        return appdao.submit(apl);
    }
}
