package team.CowsAndHorses.service.impl;


import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import team.CowsAndHorses.dao.TeacherScoreDao;
import team.CowsAndHorses.domain.ScoreDoneEntity;
import team.CowsAndHorses.domain.ScoreEntity;
import team.CowsAndHorses.domain.StuInfoEntity;
import team.CowsAndHorses.service.TeacherScoreService;

import java.util.List;


@RequiredArgsConstructor
@CacheConfig(cacheNames = "ExpireOneMin")
@Service
public class TeacherScoreImpl implements TeacherScoreService {
    final TeacherScoreDao teacherScoreDao;
    @Override
    public List<ScoreEntity> getDeyu(int year){
        return teacherScoreDao.getDeyu(year);
    }

    @Override
    public List<StuInfoEntity> getUnenteredStu11(int stuYear) {
        return teacherScoreDao.getUnenteredStu11(stuYear);
    }

    @Override
    public List<StuInfoEntity> getUnenteredStu12(int stuYear) {
        return teacherScoreDao.getUnenteredStu12(stuYear);
    }

    @Override
    public List<StuInfoEntity> getUnenteredStu13(int stuYear) {
        return teacherScoreDao.getUnenteredStu13(stuYear);
    }

    @Override
    public List<StuInfoEntity> getUnenteredStu14(int stuYear) {
        return teacherScoreDao.getUnenteredStu14(stuYear);
    }

    @Override
    public List<StuInfoEntity> getUnenteredStu15(int stuYear) {
        return teacherScoreDao.getUnenteredStu15(stuYear);
    }

    @Override
    public List<StuInfoEntity> getUnenteredStu16(int stuYear) {
        return teacherScoreDao.getUnenteredStu16(stuYear);
    }

    @Override
    public List<StuInfoEntity> getUnenteredStu21(int stuYear) {
        return teacherScoreDao.getUnenteredStu21(stuYear);
    }

    @Override
    public List<StuInfoEntity> getUnenteredStu22(int stuYear) {
        return teacherScoreDao.getUnenteredStu22(stuYear);
    }

    @Override
    public List<StuInfoEntity> getUnenteredStu23(int stuYear) {
        return teacherScoreDao.getUnenteredStu23(stuYear);
    }

    @Override
    public List<StuInfoEntity> getUnenteredStu24(int stuYear) {
        return teacherScoreDao.getUnenteredStu24(stuYear);
    }

    @Override
    public List<StuInfoEntity> getUnenteredStu25(int stuYear) {
        return teacherScoreDao.getUnenteredStu25(stuYear);
    }

    @Override
    public List<StuInfoEntity> getUnenteredStu26(int stuYear) {
        return teacherScoreDao.getUnenteredStu26(stuYear);
    }

    @Override
    public List<StuInfoEntity> getUnenteredStu31(int stuYear) {
        return teacherScoreDao.getUnenteredStu31(stuYear);
    }

    @Override
    public List<StuInfoEntity> getUnenteredStu32(int stuYear) {
        return teacherScoreDao.getUnenteredStu32(stuYear);
    }

    @Override
    public List<StuInfoEntity> getUnenteredStu33(int stuYear) {
        return teacherScoreDao.getUnenteredStu33(stuYear);
    }

    @Override
    public List<StuInfoEntity> getUnenteredStu34(int stuYear) {
        return teacherScoreDao.getUnenteredStu34(stuYear);
    }

    @Override
    public List<StuInfoEntity> getUnenteredStu35(int stuYear) {
        return teacherScoreDao.getUnenteredStu35(stuYear);
    }

    @Override
    public List<StuInfoEntity> getUnenteredStu36(int stuYear) {
        return teacherScoreDao.getUnenteredStu36(stuYear);
    }

    @Override
    public List<StuInfoEntity> getUnenteredStu41(int stuYear) {
        return teacherScoreDao.getUnenteredStu41(stuYear);
    }

    @Override
    public List<StuInfoEntity> getUnenteredStu42(int stuYear) {
        return teacherScoreDao.getUnenteredStu42(stuYear);
    }

    @Override
    public List<StuInfoEntity> getUnenteredStu43(int stuYear) {
        return teacherScoreDao.getUnenteredStu43(stuYear);
    }

    @Override
    public List<StuInfoEntity> getUnenteredStu44(int stuYear) {
        return teacherScoreDao.getUnenteredStu44(stuYear);
    }

    @Override
    public List<StuInfoEntity> getUnenteredStu45(int stuYear) {
        return teacherScoreDao.getUnenteredStu45(stuYear);
    }

    @Override
    public List<StuInfoEntity> getUnenteredStu46(int stuYear) {
        return teacherScoreDao.getUnenteredStu46(stuYear);
    }

    public ScoreEntity getItems1(@Param("year")int year, @Param("stu_number")String stuNumber){
        return teacherScoreDao.getItems1(year,stuNumber);
    }

    @Override
    public ScoreEntity getItems2(int year, String stuNumber) {
          return teacherScoreDao.getItems2(year,stuNumber);
    }

    @Override
    public ScoreEntity getItems3(int year, String stuNumber) {
          return teacherScoreDao.getItems3(year,stuNumber);
    }

    @Override
    public ScoreEntity getItems4(int year, String stuNumber) {
       return teacherScoreDao.getItems4(year,stuNumber);
    }

    @Override
    public ScoreEntity getItems5(int year, String stuNumber) {
         return teacherScoreDao.getItems5(year,stuNumber);
    }

    @Override
    public ScoreEntity getItems6(int year, String stuNumber) {
         return teacherScoreDao.getItems6(year,stuNumber);
    }

    public int enterScore1(ScoreEntity deyuScore){
        return teacherScoreDao.enterScore1(deyuScore);
    }


    @Override
    public int enterScore2(ScoreEntity zhiyuScore) {
        return teacherScoreDao.enterScore2(zhiyuScore);
    }

    @Override
    public int enterScore3(ScoreEntity tiyuScore) {
        return teacherScoreDao.enterScore3(tiyuScore);
    }

    @Override
    public int enterScore4(ScoreEntity meiyuScore) {
        return teacherScoreDao.enterScore4(meiyuScore);
    }

    @Override
    public int enterScore5(ScoreEntity laoyuScore) {
        return teacherScoreDao.enterScore5(laoyuScore);
    }

    @Override
    public int enterScore6(ScoreEntity cxcyScore) {
        return teacherScoreDao.enterScore6(cxcyScore);
    }



    @Override
    public int approval11(String stuNumber) {
        return teacherScoreDao.approval11(stuNumber);
    }

    @Override
    public int approval12(String stuNumber) {
        return teacherScoreDao.approval12(stuNumber);
    }

    @Override
    public int approval13(String stuNumber) {
        return teacherScoreDao.approval13(stuNumber);
    }

    @Override
    public int approval14(String stuNumber) {
        return teacherScoreDao.approval14(stuNumber);
    }

    @Override
    public int approval15(String stu_number) {
        return teacherScoreDao.approval15(stu_number);
    }

    @Override
    public int approval16(String stuNumber) {
        return teacherScoreDao.approval16(stuNumber);
    }

    @Override
    public int approval21(String stuNumber) {
        return teacherScoreDao.approval21(stuNumber);
    }

    @Override
    public int approval22(String stuNumber) {
        return  teacherScoreDao.approval22(stuNumber);
    }

    @Override
    public int approval23(String stuNumber) {
        return  teacherScoreDao.approval23(stuNumber);
    }

    @Override
    public int approval24(String stuNumber) {
        return  teacherScoreDao.approval24(stuNumber);
    }

    @Override
    public int approval25(String stuNumber) {
        return  teacherScoreDao.approval25(stuNumber);
    }

    @Override
    public int approval26(String stuNumber) {
        return  teacherScoreDao.approval26(stuNumber);
    }

    @Override
    public int approval31(String stuNumber) {
        return  teacherScoreDao.approval31(stuNumber);
    }

    @Override
    public int approval32(String stuNumber) {
        return  teacherScoreDao.approval32(stuNumber);
    }

    @Override
    public int approval33(String stuNumber) {
        return teacherScoreDao.approval33(stuNumber);
    }

    @Override
    public int approval34(String stuNumber) {
        return teacherScoreDao.approval34(stuNumber);
    }

    @Override
    public int approval35(String stuNumber) {
        return teacherScoreDao.approval35(stuNumber);
    }

    @Override
    public int approval36(String stuNumber) {
        return teacherScoreDao.approval36(stuNumber);
    }

    @Override
    public int approval41(String stuNumber) {
        return teacherScoreDao.approval41(stuNumber);
    }

    @Override
    public int approval42(String stuNumber) {
        return teacherScoreDao.approval42(stuNumber);
    }

    @Override
    public int approval43(String stu_number) {
        return teacherScoreDao.approval43(stu_number);
    }

    @Override
    public int approval44(String stuNumber) {
        return teacherScoreDao.approval44(stuNumber);
    }

    @Override
    public int approval45(String stuNumber) {
        return teacherScoreDao.approval45(stuNumber);
    }

    @Override
    public int approval46(String stuNumber) {
        return teacherScoreDao.approval46(stuNumber);
    }
    @Override
    public int wdapproval11(String stu_number) {
        return teacherScoreDao.wdapproval11(stu_number);
    }

    @Override
    public int wdapproval12(String stuNumber) {
        return teacherScoreDao.wdapproval12(stuNumber);
    }

    @Override
    public int wdapproval13(String stu_number) {
        return teacherScoreDao.wdapproval13(stu_number);
    }

    @Override
    public int wdapproval14(String stuNumber) {
        return teacherScoreDao.wdapproval14(stuNumber);
    }

    @Override
    public int wdapproval15(String stuNumber) {
        return teacherScoreDao.wdapproval15(stuNumber);
    }

    @Override
    public int wdapproval16(String stu_number) {
        return teacherScoreDao.wdapproval16(stu_number);
    }

    @Override
    public int wdapproval21(String stuNumber) {
        return teacherScoreDao.wdapproval21(stuNumber);
    }

    @Override
    public int wdapproval22(String stu_number) {
        return  teacherScoreDao.wdapproval22(stu_number);
    }

    @Override
    public int wdapproval23(String stuNumber) {
        return  teacherScoreDao.wdapproval23(stuNumber);
    }

    @Override
    public int wdapproval24(String stu_number) {
        return  teacherScoreDao.wdapproval24(stu_number);
    }

    @Override
    public int wdapproval25(String stuNumber) {
        return  teacherScoreDao.wdapproval25(stuNumber);
    }

    @Override
    public int wdapproval26(String stuNumber) {
        return  teacherScoreDao.wdapproval26(stuNumber);
    }

    @Override
    public int wdapproval31(String stu_number) {
        return  teacherScoreDao.wdapproval31(stu_number);
    }

    @Override
    public int wdapproval32(String stuNumber) {
        return  teacherScoreDao.wdapproval32(stuNumber);
    }

    @Override
    public int wdapproval33(String stuNumber) {
        return teacherScoreDao.wdapproval33(stuNumber);
    }

    @Override
    public int wdapproval34(String stuNumber) {
        return teacherScoreDao.wdapproval34(stuNumber);
    }

    @Override
    public int wdapproval35(String stuNumber) {
        return teacherScoreDao.wdapproval35(stuNumber);
    }

    @Override
    public int wdapproval36(String stuNumber) {
        return teacherScoreDao.wdapproval36(stuNumber);
    }

    @Override
    public int wdapproval41(String stuNumber) {
        return teacherScoreDao.wdapproval41(stuNumber);
    }

    @Override
    public int wdapproval42(String stuNumber) {
        return teacherScoreDao.wdapproval42(stuNumber);
    }

    @Override
    public int wdapproval43(String stuNumber) {
        return teacherScoreDao.wdapproval43(stuNumber);
    }

    @Override
    public int wdapproval44(String stuNumber) {
        return teacherScoreDao.wdapproval44(stuNumber);
    }

    @Override
    public int wdapproval45(String stu_number) {
        return teacherScoreDao.wdapproval45(stu_number);
    }

    @Override
    public int wdapproval46(String stuNumber) {
        return teacherScoreDao.wdapproval46(stuNumber);
    }

    public int addDone1( ScoreDoneEntity scoredone){
        return teacherScoreDao.addDone1(scoredone);
    }
    public int addDone2( ScoreDoneEntity scoreDone){
        return teacherScoreDao.addDone2(scoreDone);
    }
    public int addDone3( ScoreDoneEntity scoreDone){
        return teacherScoreDao.addDone3(scoreDone);
    }
    public int addDone4( ScoreDoneEntity scoredone){
        return teacherScoreDao.addDone4(scoredone);
    }
    public int addDone5( ScoreDoneEntity scoreDone){
        return teacherScoreDao.addDone5(scoreDone);
    }
    public int addDone6( ScoreDoneEntity scoreDone){
        return teacherScoreDao.addDone6(scoreDone);
    }

    public List<ScoreDoneEntity> getApprovedList(String teacher){return teacherScoreDao.getApprovedList( teacher);}


    public int deleteDone(ScoreDoneEntity scoreDone){return teacherScoreDao.deleteDone(scoreDone);}

    @Override
    public int enterDone1(ScoreDoneEntity deyuScoreDone) {
        return teacherScoreDao.enterDone1(deyuScoreDone);
    }

    @Override
    public int enterDone2(ScoreDoneEntity zhiyuScoreDone) {
        return teacherScoreDao.enterDone2(zhiyuScoreDone);
    }

    @Override
    public int enterDone3(ScoreDoneEntity tiyuScoreDone) {
        return teacherScoreDao.enterDone3(tiyuScoreDone);
    }

    @Override
    public int enterDone4(ScoreDoneEntity meiyuScoreDone) {
        return teacherScoreDao.enterDone4(meiyuScoreDone);
    }

    @Override
    public int enterDone5(ScoreDoneEntity laoyuScoreDone) {
        return teacherScoreDao.enterDone5(laoyuScoreDone);
    }

    @Override
    public int enterDone6(ScoreDoneEntity cxcyScoreDone) {
        return teacherScoreDao.enterDone6(cxcyScoreDone);
    }

    public int setReason1(ScoreEntity reason){
        return teacherScoreDao.setReason1(reason);
    }

    public int setReason2(ScoreEntity reason){
        return teacherScoreDao.setReason2(reason);
    }
    public int setReason3(ScoreEntity reason){
        return teacherScoreDao.setReason3(reason);
    }
    public int setReason4(ScoreEntity reason){
        return teacherScoreDao.setReason4(reason);
    }
    public int setReason5(ScoreEntity reason){
        return teacherScoreDao.setReason5(reason);
    }
    public int setReason6(ScoreEntity reason){
        return teacherScoreDao.setReason6(reason);
    }

    public int addDone(ScoreDoneEntity scoreDone){
        return teacherScoreDao.addDone(scoreDone);
    }

    public List<String> getPictures(@Param("stu_number") String stuNumber,@Param("year") int year,@Param("moduleId") int moduleId){
        return teacherScoreDao.getPictures(stuNumber,year,moduleId);
    }
    public String getContent(@Param("stu_number") String stuNumber,@Param("year") int year,@Param("moduleId") int moduleId){
        return teacherScoreDao.getContent(stuNumber,year,moduleId);
    }
}
