package team.CowsAndHorses.service;


import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;
import team.CowsAndHorses.domain.ScoreDoneEntity;
import team.CowsAndHorses.domain.ScoreEntity;

import java.util.List;

@Transactional
public interface StudentScoreService {

    public List<Integer> getIsApproval(ScoreDoneEntity scodo);

    public ScoreEntity queryMyScore(ScoreEntity sco);

    public ScoreEntity queryOtherScore(ScoreEntity sco);

    public int subScore(ScoreEntity sco);

    public int getReason(@Param("stuNumber") String stuNumber, @Param("year") int year);
}
