package team.CowsAndHorses.service;


import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;
import team.CowsAndHorses.domain.ScoreDone;
import team.CowsAndHorses.domain.Score;
import team.CowsAndHorses.domain.StuInfo;
import team.CowsAndHorses.dto.Item;
import team.CowsAndHorses.dto.ScoreDto;

import java.util.List;
import java.util.Map;

@Transactional
public interface StudentScoreService {

    Object queryScore(StuInfo stu, String stuNumber, Integer year);

    void subScore(ScoreDto sco, StuInfo stu);

    void subPicture(Item item, int scoreId, int modelId);

    Map<String, Integer> checkApproval(Integer stuId, Integer year);

    Map<String, String> getReason(Integer stuId, Integer year);
}
