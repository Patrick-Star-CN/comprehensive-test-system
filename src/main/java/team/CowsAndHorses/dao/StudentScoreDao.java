package  team.CowsAndHorses.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import team.CowsAndHorses.domain.ScoreDoneEntity;
import team.CowsAndHorses.domain.ScoreEntity;

import java.util.List;

@Mapper
public interface StudentScoreDao {
    @Select("select is_approval from score_done where stu_number=#{stuNumber} and year=#{year}")
    public List<Integer> getIsApproval(ScoreDoneEntity scodo);


    @Select("select * from score where stu_number=#{stuNumber} and year= #{year}")
    public ScoreEntity queryMyscore(ScoreEntity sco);

    @Select("select * from score where stu_number=#{stuNumber} and year= #{year}")
    public ScoreEntity queryOtherScore(ScoreEntity sco);

    @Update("update score set deyu_D2_groupAssess=#{deyuD2GroupAssess},deyu_D2_socialRespons=#{deyuD2SocialRespons},deyu_D2_honorTotal=#{deyuD2HonorTotal},tiyu_T2_races=#{tiyuT2Races},meiyu_practiceM1=#{meiyuPracticeM1},meiyu_competitionM2=#{meiyuCompetitionM2},laoyu_L1_roomActivity=#{laoyuL1RoomActivity},cxcy_C1_competition=#{cxcyC1Competition},cxcy_C1_levelGrade=#{cxcyC1LevelGrade},cxcy_socialActivityC2=#{cxcySocialActivityC2} where stu_number=#{stuNumber} ")
    public int subScore(ScoreEntity sco);

    @Update("update score set deyu_D2_groupAssess=#{deyuD2GroupAssess},deyu_D2_socialRespons=#{deyuD2SocialRespons},deyu_D2_honorTotal=#{deyuD2HonorTotal},tiyu_T2_races=#{tiyuT2Races},meiyu_practiceM1=#{meiyuPracticeM1},meiyu_competitionM2=#{meiyuCompetitionM2},laoyu_L1_roomActivity=#{laoyuL1RoomActivity},cxcy_C1_competition=#{cxcyC1Competition},cxcy_C1_levelGrade=#{cxcyC1LevelGrade},cxcy_socialActivityC2=#{cxcySocialActivityC2} where stu_number=#{stuNumber} ")
    public int modifyScore(ScoreEntity sco);

    @Select("select reason1,reason2,reason3,reason4,reason5,reason6 from score where stu_number=#{stuNumber} and year=#{year}")
    public int getReason(@Param("stuNumber") String stuNumber, @Param("year") int year);
}
