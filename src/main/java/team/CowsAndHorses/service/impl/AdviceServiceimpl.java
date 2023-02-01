package team.CowsAndHorses.service.impl;

import team.CowsAndHorses.dao.AdviceDao;
import team.CowsAndHorses.service.AdviceService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@CacheConfig(cacheNames = "ExpireOneMin")
@Service
public class AdviceServiceimpl implements AdviceService {
    final AdviceDao adviceDao;

    @Override
    public int submint(@Param("stu_number") String stuNumber, @Param("stu_content")String stuContent, @Param("teacher_content")String teacherContent, @Param("status")int status) {
        return adviceDao.submit(stuNumber, stuContent, teacherContent,status);
    }
}
