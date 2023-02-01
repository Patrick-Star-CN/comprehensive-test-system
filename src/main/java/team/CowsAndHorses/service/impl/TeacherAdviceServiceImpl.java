package team.CowsAndHorses.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import team.CowsAndHorses.dao.TeacherAdviceDao;
import team.CowsAndHorses.domain.AdviceEntity;
import team.CowsAndHorses.service.TeacherAdviceService;

import java.util.List;

@RequiredArgsConstructor
@CacheConfig(cacheNames = "ExpireOneMin")
@Service
public class TeacherAdviceServiceImpl implements TeacherAdviceService {
    final TeacherAdviceDao teacherAdviceDao;

    @Override
    public List<AdviceEntity> getAdvice () {
        return teacherAdviceDao.getAdvice();
    }

    @Override
    public int dealAdvice(AdviceEntity advice) {
        return teacherAdviceDao.dealAdvice(advice);
    }
}
