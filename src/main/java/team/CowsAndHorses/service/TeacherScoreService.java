package team.CowsAndHorses.service;


import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;
import team.CowsAndHorses.domain.ScoreDone;
import team.CowsAndHorses.domain.Score;
import team.CowsAndHorses.domain.StuInfo;
import team.CowsAndHorses.domain.TeacherInfo;
import team.CowsAndHorses.dto.ItemScoreDto;
import team.CowsAndHorses.dto.ScoreFetchDto;

import java.util.List;

@Transactional
public interface TeacherScoreService {
    List<ScoreFetchDto> query(TeacherInfo teacher, int year);

    ItemScoreDto queryItem(TeacherInfo teacher, int scoreId);

    void approval(TeacherInfo teacher, int scoreId, int isApproval, String reason);
}
