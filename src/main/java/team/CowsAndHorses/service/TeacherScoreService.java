package team.CowsAndHorses.service;


import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;
import team.CowsAndHorses.domain.ScoreDoneEntity;
import team.CowsAndHorses.domain.ScoreEntity;
import team.CowsAndHorses.domain.StuInfoEntity;

import java.util.List;

@Transactional
public interface TeacherScoreService {
    /**
     * 获取德育版块
     */
    public List<ScoreEntity> getDeyu(int year);
    public List<StuInfoEntity> getUnenteredStu11(int stuYear);
    public List<StuInfoEntity> getUnenteredStu12(int stuYear);

    public List<StuInfoEntity> getUnenteredStu13(int stuYear);

    public List<StuInfoEntity> getUnenteredStu14(int stuYear);

    public List<StuInfoEntity> getUnenteredStu15(int stuYear);

    public List<StuInfoEntity> getUnenteredStu16(int stuYear);
    public List<StuInfoEntity> getUnenteredStu21(int stuYear);

    public List<StuInfoEntity> getUnenteredStu22(int stuYear);
    public List<StuInfoEntity> getUnenteredStu23(int stuYear);
    public List<StuInfoEntity> getUnenteredStu24(int stuYear);
    public List<StuInfoEntity> getUnenteredStu25(int stuYear);
    public List<StuInfoEntity> getUnenteredStu26(int stuYear);

    public List<StuInfoEntity> getUnenteredStu31(int stuYear);
    public List<StuInfoEntity> getUnenteredStu32(int stuYear);
    public List<StuInfoEntity> getUnenteredStu33(int stuYear);
    public List<StuInfoEntity> getUnenteredStu34(int stuYear);
    public List<StuInfoEntity> getUnenteredStu35(int stuYear);
    public List<StuInfoEntity> getUnenteredStu36(int stuYear);


    public List<StuInfoEntity> getUnenteredStu41(int stuYear);
    public List<StuInfoEntity> getUnenteredStu42(int stuYear);
    public List<StuInfoEntity> getUnenteredStu43(int stuYear);
    public List<StuInfoEntity> getUnenteredStu44(int stuYear);
    public List<StuInfoEntity> getUnenteredStu45(int stuYear);
    public List<StuInfoEntity> getUnenteredStu46(int stuYear);
    public ScoreEntity getItems1(@Param("year") int year, @Param("stu_number")String stuNumber);

    public ScoreEntity getItems2(@Param("year") int year, @Param("stu_number")String stuNumber);

    public ScoreEntity getItems3(@Param("year") int year, @Param("stu_number")String stuNumber);


    public ScoreEntity getItems4(@Param("year") int year, @Param("stu_number")String stuNumber);

    public ScoreEntity getItems5(@Param("year") int year, @Param("stu_number")String stuNumber);

    public ScoreEntity getItems6(@Param("year") int year, @Param("stu_number")String stuNumber);

    public int enterScore1( ScoreEntity deyuScore);

    public int enterScore2(ScoreEntity zhiyuScore);
    public int enterScore3(ScoreEntity tiyuScore);
    public int enterScore4(ScoreEntity meiyuScore);
    public int enterScore5(ScoreEntity laoyuScore);
    public int enterScore6(ScoreEntity cxcyScore);

    public int approval11(String stuNumber);
    public int approval12(String stuNumber);
    public int approval13(String stuNumber);
    public int approval14(String stuNumber);
    public int approval15(String stuNumber);
    public int approval16(String stuNumber);
    public int approval21(String stuNumber);
    public int approval22(String stuNumber);
    public int approval23(String stuNumber);
    public int approval24(String stuNumber);
    public int approval25(String stuNumber);
    public int approval26(String stuNumber);
    public int approval31(String stuNumber);
    public int approval32(String stuNumber);
    public int approval33(String stuNumber);
    public int approval34(String stuNumber);
    public int approval35(String stuNumber);
    public int approval36(String stuNumber);
    public int approval41(String stuNumber);
    public int approval42(String stuNumber);
    public int approval43(String stuNumber);
    public int approval44(String stuNumber);
    public int approval45(String stuNumber);
    public int approval46(String stuNumber);
    public int wdapproval11(String stuNumber);
    public int wdapproval12(String stuNumber);
    public int wdapproval13(String stuNumber);
    public int wdapproval14(String stuNumber);
    public int wdapproval15(String stuNumber);
    public int wdapproval16(String stuNumber);
    public int wdapproval21(String stuNumber);
    public int wdapproval22(String stuNumber);
    public int wdapproval23(String stuNumber);
    public int wdapproval24(String stuNumber);
    public int wdapproval25(String stuNumber);
    public int wdapproval26(String stuNumber);
    public int wdapproval31(String stuNumber);
    public int wdapproval32(String stuNumber);
    public int wdapproval33(String stuNumber);
    public int wdapproval34(String stuNumber);
    public int wdapproval35(String stuNumber);
    public int wdapproval36(String stuNumber);
    public int wdapproval41(String stuNumber);
    public int wdapproval42(String stuNumber);
    public int wdapproval43(String stuNumber);
    public int wdapproval44(String stuNumber);
    public int wdapproval45(String stuNumber);
    public int wdapproval46(String stuNumber);
    public int addDone1( ScoreDoneEntity scoreDone);
    public int addDone2( ScoreDoneEntity scoreDone);
    public int addDone3( ScoreDoneEntity scoreDone);
    public int addDone4( ScoreDoneEntity scoreDone);
    public int addDone5( ScoreDoneEntity scoreDone);
    public int addDone6( ScoreDoneEntity scoreDone);

    public List<ScoreDoneEntity> getApprovedList(String teacher);

    public int deleteDone(ScoreDoneEntity scoreDone);

    public int enterDone1( ScoreDoneEntity deyuScoreDone );

    public int enterDone2(ScoreDoneEntity zhiyuScoreDone);

    public int enterDone3(ScoreDoneEntity tiyuScoreDone);

    public int enterDone4(ScoreDoneEntity meiyuScoreDone);
    public int enterDone5(ScoreDoneEntity laoyuScoreDone);

    public int enterDone6(ScoreDoneEntity cxcyScoreDone);

    //public int approval11(List list);

    public int setReason1(ScoreEntity reason);
    public int setReason2(ScoreEntity reason);
    public int setReason3(ScoreEntity reason);
    public int setReason4(ScoreEntity reason);
    public int setReason5(ScoreEntity reason);
    public int setReason6(ScoreEntity reason);

    public int addDone(ScoreDoneEntity scoreDone);
    public List<String> getPictures(@Param("stu_number") String stu_number,@Param("year") int year,@Param("moduleId") int moduleId);
    public String getContent(@Param("stu_number") String stu_number,@Param("year") int year,@Param("moduleId") int moduleId);
}
