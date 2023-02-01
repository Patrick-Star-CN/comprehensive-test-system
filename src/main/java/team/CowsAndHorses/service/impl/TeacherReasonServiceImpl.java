package team.CowsAndHorses.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import team.CowsAndHorses.dao.TeacherReasonDao;
import team.CowsAndHorses.domain.ReasonEntity;
import team.CowsAndHorses.service.TeacherReasonService;

import java.util.List;

@RequiredArgsConstructor
@CacheConfig(cacheNames = "ExpireOneMin")
@Service
public class TeacherReasonServiceImpl implements TeacherReasonService {
    final TeacherReasonDao teacherReasonDao;

    @Override
    public List<ReasonEntity> getReason(){return teacherReasonDao.getReason();}
    @Override
    public int addReason(String content){return teacherReasonDao.addReason(content);}
    @Override
    public int deleteReason(int id){return teacherReasonDao.deleteReason(id);}
}
