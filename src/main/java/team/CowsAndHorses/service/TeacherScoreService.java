package team.CowsAndHorses.service;


import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;
import team.CowsAndHorses.domain.ScoreDone;
import team.CowsAndHorses.domain.Score;
import team.CowsAndHorses.domain.StuInfo;
import team.CowsAndHorses.domain.TeacherInfo;
import team.CowsAndHorses.dto.ItemScoreDto;
import team.CowsAndHorses.dto.ScoreDoneDto;
import team.CowsAndHorses.dto.ScoreFetchDto;

import java.util.List;
import java.util.Map;

@Transactional
public interface TeacherScoreService {
    List<ScoreFetchDto> query(TeacherInfo teacher, int year);

    ItemScoreDto queryItem(TeacherInfo teacher, int scoreId);

    void approval(TeacherInfo teacher, int scoreId, int isApproval, String reason);

    void enter(TeacherInfo teacher, String stuNumber, int year, Map<String, String> map);

    void withdraw(TeacherInfo teacher, String stuNumber, int year);

    List<ScoreDoneDto> queryDone(TeacherInfo teacher, int year);

    Map<String, String> queryDoneDetail(TeacherInfo teacher, int scoreDoneId);

    void change(TeacherInfo teacher, int scoreDoneId, Map<String, String> map);
}
