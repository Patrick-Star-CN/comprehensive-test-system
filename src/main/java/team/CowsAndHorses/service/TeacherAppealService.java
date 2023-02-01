package team.CowsAndHorses.service;


import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;
import team.CowsAndHorses.domain.AppealEntity;

import java.util.List;
@Transactional
public interface TeacherAppealService {

    public List<AppealEntity> getAppeal(@Param("year") int year, @Param("moduleId") int moduleId);

    public int isAppeal(@Param("is_approval") int isApproval,@Param("appeal_id") int appealId);

    public int isnotAppeal(@Param("is_approval") int isApproval,@Param("appeal_id") int appealId);
}
