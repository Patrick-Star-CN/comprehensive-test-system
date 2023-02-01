package  team.CowsAndHorses.dao;

import team.CowsAndHorses.domain.*;

import org.apache.ibatis.annotations.*;


import java.util.List;
@Mapper
public interface TeacherScoreDao {
    @Select("select id,deyu,stu_id,stu_name,deyu_basicAssessD1,deyu_otherTotalD2,deyu_D2_groupAssess,deyu_D2_socialRespons,deyu_D2_politicalLearn,deyu_D2_minusTotal,deyu_D2_honorTotal from score where year=#{year}")
    List<ScoreEntity> getDeyu(int year);

    @Select("select * from stu_info where stu_year=#{stuYear} and is_first1=0 ")
    public List<StuInfoEntity> getUnenteredStu11(int stuYear);
    @Select("select * from stu_info where stu_year=#{stuYear} and is_first2=0 ")
    public List<StuInfoEntity> getUnenteredStu12(int stuYear);
    @Select("select * from stu_info where stu_year=#{stuYear} and is_first3=0 ")
    public List<StuInfoEntity> getUnenteredStu13(int stuYear);

    @Select("select * from stu_info where stu_year=#{stuYear} and is_first4=0 ")
    public List<StuInfoEntity> getUnenteredStu14(int stuYear);

    @Select("select * from stu_info where stu_year=#{stuYear} and is_first5=0 ")
    public List<StuInfoEntity> getUnenteredStu15(int stuYear);

    @Select("select * from stu_info where stu_year=#{stuYear} and is_first6=0 ")
    public List<StuInfoEntity> getUnenteredStu16(int stuYear);
    //获取年级为stu_year第二学年没有录入成绩的学生名单
    @Select("select * from stu_info where stu_year=#{stuYear} and is_second1=0 ")
    public List<StuInfoEntity> getUnenteredStu21(int stuYear);

    @Select("select * from stu_info where stu_year=#{stuYear} and is_second2=0 ")
    public List<StuInfoEntity> getUnenteredStu22(int stuYear);

    @Select("select * from stu_info where stu_year=#{stuYear} and is_second3=0 ")
    public List<StuInfoEntity> getUnenteredStu23(int stuYear);


    @Select("select * from stu_info where stu_year=#{stuYear} and is_second4=0 ")
    public List<StuInfoEntity> getUnenteredStu24(int stuYear);
    @Select("select * from stu_info where stu_year=#{stuYear} and is_second5=0 ")
    public List<StuInfoEntity> getUnenteredStu25(int stuYear);

    @Select("select * from stu_info where stu_year=#{stuYear} and is_second6=0 ")
    public List<StuInfoEntity> getUnenteredStu26(int stuYear);
    //获取年级为stu_year第三学年没有录入成绩的学生名单
    @Select("select * from stu_info where stu_year=#{stuYear} and is_third1=0 ")
    public List<StuInfoEntity> getUnenteredStu31(int stuYear);

    @Select("select * from stu_info where stu_year=#{stuYear} and is_third2=0 ")
    public List<StuInfoEntity> getUnenteredStu32(int stuYear);

    @Select("select * from stu_info where stu_year=#{stuYear} and is_third3=0 ")
    public List<StuInfoEntity> getUnenteredStu33(int stuYear);

    @Select("select * from stu_info where stu_year=#{stuYear} and is_third4=0 ")
    public List<StuInfoEntity> getUnenteredStu34(int stuYear);
    //获取年级为stu_year第四学年没有录入成绩的学生名单
    @Select("select * from stu_info where stu_year=#{stuYear} and is_third5=0 ")
    public List<StuInfoEntity> getUnenteredStu35(int stuYear);
    @Select("select * from stu_info where stu_year=#{stuYear} and is_third6=0 ")
    public List<StuInfoEntity> getUnenteredStu36(int stuYear);
    @Select("select * from stu_info where stu_year=#{stuYear} and is_forth1=0 ")
    public List<StuInfoEntity> getUnenteredStu41(int stuYear);

    @Select("select * from stu_info where stu_year=#{stuYear} and is_forth2=0 ")
    public List<StuInfoEntity> getUnenteredStu42(int stuYear);

    @Select("select * from stu_info where stu_year=#{stuYear} and is_forth3=0 ")
    public List<StuInfoEntity> getUnenteredStu43(int stuYear);

    @Select("select * from stu_info where stu_year=#{stuYear} and is_forth4=0 ")
    public List<StuInfoEntity> getUnenteredStu44(int stuYear);

    @Select("select * from stu_info where stu_year=#{stu_year} and is_forth5=0 ")
    public List<StuInfoEntity> getUnenteredStu45(int stu_year);

    @Select("select * from stu_info where stu_year=#{stuYear} and is_forth6=0 ")
    public List<StuInfoEntity> getUnenteredStu46(int stuYear);

    @Select("select stu_number stuNumber ,stu_name stuName,deyu deyu,deyu_basicAssessD1 deyuBasicAssessD1,deyu_otherTotalD2 deyuOtherTotalD2,deyu_D2_groupAssess deyuD2GroupAssess,deyu_D2_socialRespons deyuD2SocialRespons,deyu_D2_politicalLearn deyuD2PoliticalLearn, deyu_D2_minusTotal deyuD2MinusTotal,deyu_D2_honorTotal deyuD2HonorTotal from score where stu_number=#{stu_number} and year=#{year}")
    public ScoreEntity getItems1(@Param("year") int year, @Param("stu_number") String stuNumber);

    @Select("select stu_number,stu_name,zhiyu,zhiyu_GPA from score where stu_number=#{stu_number} and year=#{year}")
    public ScoreEntity getItems2(@Param("year") int year, @Param("stu_number") String stuNumber);

    @Select("select stu_number,stu_name,tiyu,tiyu_scoreTotalT1,tiyu_T1_score1,tiyu_T1_score2,tiyu_otherTotalT2,tiyu_T2_races,tiyu_T2_earlyExercise from score where stu_number=#{stu_number} and year=#{year} ")
    public ScoreEntity getItems3(@Param("year") int year, @Param("stu_number") String stuNumber);

    @Select("select stu_number,stu_name,meiyu,meiyu_practiceM1,meiyu_competitionM2 from score where stu_number=#{stu_number} and year=#{year}  ")
    public ScoreEntity getItems4(@Param("year") int year, @Param("stu_number") String stuNumber);

    @Select("select stu_number,stu_name,laoyu,laoyu_dailyTotalL1,laoyu_L1_roomdaily,laoyu_L1_roomActivity,laoyu_L1_roomPerform,laoyu_volunteerL2, laoyu_internshipL3 from score where stu_number=#{stu_number} and year=#{year}  ")
    public ScoreEntity getItems5(@Param("year") int year, @Param("stu_number") String stuNumber);

    @Select("select stu_number,stu_name,cxcy,cxcy_scoreTotalC1,cxcy_C1_competition,cxcy_C1_levelGrade,cxcy_socialActivityC2,cxcy_socialWorkC3 from score where stu_number=#{stu_number} and year=#{year}")
    public ScoreEntity getItems6(@Param("year") int year, @Param("stu_number") String stuNumber);
    @Update("update score set deyu= #{deyu},deyu_basicAssessD1=#{deyuBasicAssessD1},deyu_otherTotalD2=#{deyuOtherTotalD2},deyu_D2_groupAssess=#{deyuD2GroupAssess},deyu_D2_socialRespons=#{deyuD2SocialRespons},deyu_D2_politicalLearn=#{deyuD2PoliticalLearn},deyu_D2_minusTotal=#{deyuD2MinusTotal},deyu_D2_honorTotal=#{deyuD2HonorTotal} where stu_number=#{stuNumber} and year=#{year}  ")
    public int enterScore1( ScoreEntity deyuScore);
    @Insert("INSERT INTO score_done (stu_number,year,deyu,deyu_basicAssessD1,deyu_otherTotalD2,deyu_D2_groupAssess,deyu_D2_socialRespons,deyu_D2_politicalLearn,deyu_D2_minusTotal,deyu_D2_honorTotal,teacher,is_approval) values(#{stuNumber},#{year},#{deyu},#{deyuBasicAssessD1},#{deyuOtherTotalD2},#{deyuD2GroupAssess},#{deyuD2SocialRespons},#{deyuD2PoliticalLearn},#{deyuD2MinusTotal},#{deyuD2HonorTotal},#{teacher},#{isApproval})")
    public int addDone1( ScoreDoneEntity scoreDone);

    @Update("update score_done set deyu= #{deyu},deyu_basicAssessD1=#{deyuBasicAssessD1},deyu_otherTotalD2=#{deyuOtherTotalD2},deyu_D2_groupAssess=#{deyuD2GroupAssess},deyu_D2_socialRespons=#{deyuD2SocialRespons},deyu_D2_politicalLearn=#{deyuD2PoliticalLearn},deyu_D2_minusTotal=#{deyuD2MinusTotal},deyu_D2_honorTotal=#{deyuD2HonorTotal} where stu_number=#{stuNumber} and year=#{year} and teacher=#{teacher} ")
    public int enterDone1( ScoreDoneEntity deyuScoreDone );
    @Delete("delete from score_done where stu_number=#{stuNumber} and year=#{year} and teacher=#{teacher}")
    public int deleteDone(ScoreDoneEntity scoreDone);
    @Update("update score set zhiyu=#{zhiyu},zhiyu_GPA=#{zhiyuGPA} where stu_number=#{stuNumber} and year=#{year}")
    public int enterScore2(ScoreEntity zhiyuScore);


    @Insert("INSERT INTO score_done (stu_number,year,zhiyu,zhiyu_GPA,teacher,is_approval) values (#{stuNumber},#{year},#{zhiyu},#{zhiyuGPA},#{teacher},#{isApproval})")
    public  int addDone2( ScoreDoneEntity scoreDone);

    @Update("update score_done set zhiyu=#{zhiyu},zhiyu_GPA=#{zhiyuGPA} where stu_number=#{stuNumber} and year=#{year} and teacher=#{teacher}")
    public int enterDone2(ScoreDoneEntity zhiyuScoreDone);
    @Update("update score set tiyu=#{tiyu},tiyu_scoreTotalT1=#{tiyuScoreTotalT1},tiyu_T1_score1=#{tiyuT1Score1},tiyu_T1_score2=#{tiyuT1Score2},tiyu_otherTotalT2=#{tiyuOtherTotalT2},tiyu_T2_races=#{tiyuT2Races},tiyu_T2_earlyExercise=#{tiyuT2EarlyExercise} where stu_number=#{stuNumber} and year=#{year}")
    public int enterScore3(ScoreEntity tiyuScore);


    @Insert("insert into  score_done (stu_number,year,tiyu,tiyu_scoreTotalT1,tiyu_T1_score1,tiyu_T1_score2,tiyu_otherTotalT2,tiyu_T2_races,tiyu_T2_earlyExercise,teacher,is_approval) values(#{stuNumber},#{year},#{tiyu},#{tiyuScoreTotalT1},#{tiyuT1Score1},#{tiyuT1Score2},#{tiyuOtherTotalT2},#{tiyuT2Races},#{tiyuT2EarlyExercise},#{teacher},#{isApproval})")
    public  int addDone3( ScoreDoneEntity scoreDone);

    @Update("update score_done set tiyu=#{tiyu},tiyu_scoreTotalT1=#{tiyuScoreTotalT1},tiyu_T1_score1=#{tiyuT1Score1},tiyu_T1_score2=#{tiyuT1Score2},tiyu_otherTotalT2=#{tiyuOtherTotalT2},tiyu_T2_races=#{tiyuT2Races},tiyu_T2_earlyExercise=#{tiyuT2EarlyExercise} where stu_number=#{stuNumber} and year=#{year} and teacher=#{teacher}")
    public int enterDone3(ScoreDoneEntity tiyuScoreDone);
    @Update("update score set meiyu=#{meiyu},meiyu_practiceM1=#{meiyuPracticeM1},meiyu_competitionM2=#{meiyuCompetitionM2} where stu_number=#{stuNumber} and year=#{year}")
    public int enterScore4(ScoreEntity meiyuScore);
    @Insert("insert into score_done (stu_number,year,meiyu,meiyu_practiceM1,meiyu_competitionM2,teacher,is_approval) values (#{stuNumber},#{year},#{meiyu},#{meiyuPracticeM1},#{meiyuCompetitionM2},#{teacher},#{isApproval})")
    public  int addDone4( ScoreDoneEntity scoreDone);

    @Update("update score_done set meiyu=#{meiyu},meiyu_practiceM1=#{meiyuPracticeM1},meiyu_competitionM2=#{meiyuCompetitionM2} where stu_number=#{stuNumber} and year=#{year} and teacher=#{teacher}")
    public int enterDone4(ScoreDoneEntity meiyuScoreDone);

    @Update("update score set laoyu=#{laoyu},laoyu_dailyTotalL1=#{laoyuDailyTotalL1},laoyu_L1_roomDaily=#{laoyuL1RoomDaily},laoyu_L1_roomActivity=#{laoyuL1RoomActivity},laoyu_L1_roomPerform=#{laoyuL1RoomPerform},laoyu_volunteerL2=#{laoyuVolunteerL2},laoyu_internshipL3=#{laoyuInternshipL3} where stu_number=#{stuNumber} and year=#{year} ")
    public int enterScore5(ScoreEntity laoyuScore);
    @Insert("insert into score_done (stu_number,year,laoyu,laoyu_dailyTotalL1,laoyu_L1_roomDaily,laoyu_L1_roomActivity,laoyu_L1_roomPerform,laoyu_volunteerL2,laoyu_internshipL3,teacher,is_approval) values (#{stuNumber},#{year},#{laoyu},#{laoyuDailyTotalL1},#{laoyuL1RoomDaily},#{laoyuL1RoomActivity},#{laoyuL1RoomPerform},#{laoyuVolunteerL2},#{laoyuInternshipL3},#{teacher},#{isApproval})")
    public  int addDone5( ScoreDoneEntity scoreDone);
    @Update("update score_done set laoyu=#{laoyu},laoyu_dailyTotalL1=#{laoyuDailyTotalL1},laoyu_L1_roomDaily=#{laoyuL1RoomDaily},laoyu_L1_roomActivity=#{laoyuL1RoomActivity},laoyu_L1_roomPerform=#{laoyuL1RoomPerform},laoyu_volunteerL2=#{laoyuVolunteerL2},laoyu_internshipL3=#{laoyuInternshipL3} where stu_number=#{stuNumber} and year=#{year} and teacher=#{teacher}")
    public int enterDone5(ScoreDoneEntity laoyuScoreDone);
    @Update("update score set cxcy=#{cxcy},cxcy_scoreTotalC1=#{cxcyScoreTotalC1},cxcy_C1_competition=#{cxcyC1Competition},cxcy_C1_levelGrade=#{cxcyC1LevelGrade},cxcy_socialActivityC2=#{cxcySocialActivityC2},cxcy_socialWorkC3=#{cxcySocialWorkC3}where stu_number=#{stuNumber} and year=#{year}")
    public int enterScore6(ScoreEntity cxcyScore);
    @Insert("insert into score_done (stu_number,year,cxcy,cxcy_scoreTotalC1,cxcy_C1_competition,cxcy_C1_levelGrade,cxcy_socialActivityC2,cxcy_socialWorkC3,teacher,is_approval) values (#{stuNumber},#{year},#{cxcy},#{cxcyScoreTotalC1},#{cxcyC1Competition},#{cxcyC1LevelGrade},#{cxcySocialActivityC2},#{cxcySocialWorkC3},#{teacher},#{isApproval})")
    public  int addDone6( ScoreDoneEntity scoreDone);
    @Update("update score_done set cxcy=#{cxcy},cxcy_scoreTotalC1=#{cxcyScoreTotalC1},cxcy_C1_competition=#{cxcyC1Competition},cxcy_C1_levelGrade=#{cxcyC1LevelGrade},cxcy_socialActivityC2=#{cxcySocialActivityC2},cxcy_socialWorkC3=#{cxcySocialWorkC3}where stu_number=#{stuNumber} and year=#{year} and teacher=#{teacher}")
    public int enterDone6(ScoreDoneEntity cxcyScoreDone);
    @Insert("insert into score_done(stu_number,year,teacher,is_approval) values (#{stuNumber},#{year},#{teacher},#{isApproval})")
    public int addDone(ScoreDoneEntity scoreDone);
    @Update("update stu_info set is_first1=1 where stu_number=#{stuNumber} ")
    public int approval11(String stuNumber);

    //    @Update( " <script>" +
//            "update stu_info set is_first=1 " +
//            " where  stu_number  in "+
//            " <foreach collection='list' open='(' item='stu_number' separator=',' close=')'> #{stu_number}</foreach> "+
//            " </script>" )
//    public int approval11(List list);
    @Update("update stu_info set is_first2=1 where stu_number=#{stuNumber}")
    public int approval12(String stuNumber);

    @Update("update stu_info set is_first3=1 where stu_number=#{stuNumber}")
    public int approval13(String stuNumber);
    @Update("update stu_info set is_first4=1 where stu_number=#{stuNumber}")
    public int approval14(String stuNumber);
    @Update("update stu_info set is_first5=1 where stu_number=#{stuNumber}")
    public int approval15(String stuNumber);
    @Update("update stu_info set is_first6=1 where stu_number=#{stuNumber}")
    public int approval16(String stuNumber);
    @Update("update stu_info set is_second1=1 where stu_number=#{stuNumber}")
    public int approval21(String stuNumber);
    @Update("update stu_info set is_second2=1 where stu_number=#{stuNumber}")
    public int approval22(String stuNumber);
    @Update("update stu_info set is_second3=1 where stu_number=#{stuNumber}")
    public int approval23(String stuNumber);
    @Update("update stu_info set is_second4=1 where stu_number=#{stuNumber}")
    public int approval24(String stuNumber);
    @Update("update stu_info set is_second5=1 where stu_number=#{stuNumber}")
    public int approval25(String stu_number);
    @Update("update stu_info set is_second6=1 where stu_number=#{stuNumber}")
    public int approval26(String stuNumber);

    @Update("update stu_info set is_third1=1 where stu_number=#{stuNumber}")
    public int approval31(String stuNumber);

    @Update("update stu_info set is_third2=1 where stu_number=#{stuNumber}")
    public int approval32(String stuNumber);
    @Update("update stu_info set is_third3=1 where stu_number=#{stuNumber}")
    public int approval33(String stuNumber);

    @Update("update stu_info set is_third4=1 where stu_number=#{stuNumber}")
    public int approval34(String stuNumber);

    @Update("update stu_info set is_third5=1 where stu_number=#{stuNumber}")
    public int approval35(String stuNumber);

    @Update("update stu_info set is_third6=1 where stu_number=#{stuNumber}")
    public int approval36(String stuNumber);


    @Update("update stu_info set is_forth1=1 where stu_number=#{stuNumber}")
    public int approval41(String stuNumber);
    @Update("update stu_info set is_forth2=1 where stu_number=#{stuNumber}")
    public int approval42(String stuNumber);
    @Update("update stu_info set is_forth3=1 where stu_number=#{stuNumber}")
    public int approval43(String stuNumber);
    @Update("update stu_info set is_forth4=1 where stu_number=#{stuNumber}")
    public int approval44(String stuNumber);
    @Update("update stu_info set is_forth5=1 where stu_number=#{stuNumber}")
    public int approval45(String stuNumber);
    @Update("update stu_info set is_forth6=1 where stu_number=#{stuNumber}")
    public int approval46(String stuNumber);

    /**
     *撤回审批
     * @param stu_number
     * @return
     */
    @Update("update stu_info set is_first1=0 where stu_number=#{stuNumber}")
    public int wdapproval11(String stuNumber);
    @Update("update stu_info set is_first2=0 where stu_number=#{stuNumber}")
    public int wdapproval12(String stuNumber);
    @Update("update stu_info set is_first3=0 where stu_number=#{stuNumber}")
    public int wdapproval13(String stuNumber);
    @Update("update stu_info set is_first4=0 where stu_number=#{stuNumber}")
    public int wdapproval14(String stuNumber);
    @Update("update stu_info set is_first5=0 where stu_number=#{stuNumber}")
    public int wdapproval15(String stuNumber);
    @Update("update stu_info set is_first6=0 where stu_number=#{stuNumber}")
    public int wdapproval16(String stuNumber);
    @Update("update stu_info set is_second1=0 where stu_number=#{stuNumber}")
    public int wdapproval21(String stuNumber);
    @Update("update stu_info set is_second2=0 where stu_number=#{stuNumber}")
    public int wdapproval22(String stuNumber);
    @Update("update stu_info set is_second3=0 where stu_number=#{stuNumber}")
    public int wdapproval23(String stuNumber);
    @Update("update stu_info set is_second4=0 where stu_number=#{stuNumber}")
    public int wdapproval24(String stuNumber);
    @Update("update stu_info set is_second5=0 where stu_number=#{stuNumber}")
    public int wdapproval25(String stuNumber);
    @Update("update stu_info set is_second6=0 where stu_number=#{stuNumber}")
    public int wdapproval26(String stuNumber);

    @Update("update stu_info set is_third1=0 where stu_number=#{stuNumber}")
    public int wdapproval31(String stuNumber);

    @Update("update stu_info set is_third2=0 where stu_number=#{stuNumber}")
    public int wdapproval32(String stuNumber);
    @Update("update stu_info set is_third3=0 where stu_number=#{stuNumber}")
    public int wdapproval33(String stuNumber);

    @Update("update stu_info set is_third4=0 where stu_number=#{stuNumber}")
    public int wdapproval34(String stuNumber);

    @Update("update stu_info set is_third5=0 where stu_number=#{stuNumber}")
    public int wdapproval35(String stuNumber);

    @Update("update stu_info set is_third6=1 where stu_number=#{stuNumber}")
    public int wdapproval36(String stuNumber);


    @Update("update stu_info set is_forth1=0 where stu_number=#{stuNumber}")
    public int wdapproval41(String stuNumber);
    @Update("update stu_info set is_forth2=0 where stu_number=#{stuNumber}")
    public int wdapproval42(String stuNumber);
    @Update("update stu_info set is_forth3=0 where stu_number=#{stuNumber}")
    public int wdapproval43(String stuNumber);
    @Update("update stu_info set is_forth4=0 where stu_number=#{stuNumber}")
    public int wdapproval44(String stuNumber);
    @Update("update stu_info set is_forth5=0 where stu_number=#{stuNumber}")
    public int wdapproval45(String stuNumber);
    @Update("update stu_info set is_forth6=0 where stu_number=#{stuNumber}")
    public int wdapproval46(String stuNumber);

    @Select("select * from stu_info where year=#{year} and stu_year=#{stu_year} ")
    public List<StuInfoEntity> getApprovedStu(@Param("year") int year,@Param("stu_year") int stuYear);
    @Select("select * from score_done where teacher=#{teacher} order by time desc")
    public List<ScoreDoneEntity> getApprovedList(String teacher);

    @Update("update score set reason1=#{reason1} where stu_number=#{stuNumber} and year=#{year}")
    public int setReason1(ScoreEntity reason);

    @Update("update score set reason2=#{reason2} where stu_number=#{stuNumber} and year=#{year}")
    public int setReason2(ScoreEntity reason);

    @Update("update score set reason3=#{reason3} where stu_number=#{stuNumber} and year=#{year}")
    public int setReason3(ScoreEntity reason);

    @Update("update score set reason4=#{reason4} where stu_number=#{stuNumber} and year=#{year}")
    public int setReason4(ScoreEntity reason);

    @Update("update score set reason5=#{reason5} where stu_number=#{stuNumber} and year=#{year}")
    public int setReason5(ScoreEntity reason);
    @Update("update score set reason6=#{reason6} where stu_number=#{stuNumber} and year=#{year}")
    public int setReason6(ScoreEntity reason);

    @Select("select photo from picture where stu_number=#{stu_number} and year=#{year} and moduleId=#{moduleId}")
    public List<String> getPictures(@Param("stu_number") String stuNumber,@Param("year") int year,@Param("moduleId") int moduleId);

    @Select("select content from content where stu_number=#{stu_number} and year=#{year} and moduleId=#{moduleId}")
    public String getContent(@Param("stu_number") String stuNumber,@Param("year") int year,@Param("moduleId") int moduleId);
}
