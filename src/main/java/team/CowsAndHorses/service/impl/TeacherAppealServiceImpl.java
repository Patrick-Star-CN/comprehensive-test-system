package team.CowsAndHorses.service.impl;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import team.CowsAndHorses.dao.TeacherAppealDao;
import team.CowsAndHorses.domain.AppealEntity;
import team.CowsAndHorses.service.TeacherAppealService;

import java.util.List;

@RequiredArgsConstructor
@CacheConfig(cacheNames = "ExpireOneMin")
@Service
public class TeacherAppealServiceImpl implements TeacherAppealService
{
    final TeacherAppealDao teacherAppealDao;

    @Override
    public List<AppealEntity> getAppeal(@Param("year") int year, @Param("moduleId") int moduleId){
        return teacherAppealDao.getAppeal(year,moduleId);
    }
    @Override
    public int isAppeal(@Param("is_approval") int isApproval,@Param("appeal_id") int appealId) {
        return teacherAppealDao.isAppeal(isApproval,appealId);
    }

    @Override
    public int isnotAppeal(@Param("is_approval") int isApproval,@Param("appeal_id") int appealId) {
        return teacherAppealDao.isnotAppeal(isApproval,appealId);
    }
}
