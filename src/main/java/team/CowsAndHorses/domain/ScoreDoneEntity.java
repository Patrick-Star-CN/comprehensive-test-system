package  team.CowsAndHorses.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ScoreDoneEntity {
    private int id;
    private int stuId;
    private String stuName;
    private String stuNumber;
    private int year;

    private String total;
    private String deyu;

    private String deyuBasicAssessD1;
    private String deyuOtherTotalD2;
    private String deyuD2GroupAssess;
    private String deyuD2SocialRespons;
    private String deyuD2PoliticalLearn;
    private String deyuD2MinusTotal;
    private String deyuD2HonorTotal;
    private String zhiyu;
    private String zhiyuGPA;
    private String tiyu;
    private String tiyuScoreTotalT1;
    private String tiyuT1Score1;
    private String tiyuT1Score2;
    private String tiyuOtherTotalT2;
    private String tiyuT2Races;
    private String tiyuT2EarlyExercise;
    private String meiyu;
    private String meiyuPracticeM1;
    private String meiyuCompetitionM2;

    private String teacher;
    public ScoreDoneEntity() {
    }

    private String laoyu;
    private String laoyuDailyTotalL1;
    private String laoyuL1RoomDaily;
    private String laoyuL1RoomActivity;
    private String laoyuL1RoomPerform;
    private String laoyuVolunteerL2;
    private String laoyuInternshipL3;
    private String cxcy;
    private String cxcyScoreTotalC1;
    private String cxcyC1Competition;
    private String cxcyC1LevelGrade;
    private String cxcySocialActivityC2;
    private String cxcySocialWorkC3;
    private int isApproval;

    @Override
    public String toString() {
        return "ScoreDoneEntity{" +
                "id=" + id +
                ", stu_id=" + stuId +
                ", stu_name='" + stuName + '\'' +
                ", stu_number='" + stuNumber + '\'' +
                ", year=" + year +
                ", total='" + total + '\'' +
                ", deyu='" + deyu + '\'' +
                ", deyu_basicAssessD1='" + deyuBasicAssessD1 + '\'' +
                ", deyu_otherTotalD2='" + deyuOtherTotalD2 + '\'' +
                ", deyu_D2_groupAssess='" + deyuD2GroupAssess + '\'' +
                ", deyu_D2_socialRespons='" + deyuD2SocialRespons + '\'' +
                ", deyu_D2_politicalLearn='" + deyuD2PoliticalLearn + '\'' +
                ", deyu_D2_minusTotal='" + deyuD2MinusTotal + '\'' +
                ", deyu_D2_honorTotal='" + deyuD2HonorTotal + '\'' +
                ", zhiyu='" + zhiyu + '\'' +
                ", zhiyu_GPA='" + zhiyuGPA + '\'' +
                ", tiyu='" + tiyu + '\'' +
                ", tiyu_scoreTotalT1='" + tiyuScoreTotalT1 + '\'' +
                ", tiyu_T1_score1='" + tiyuT1Score1 + '\'' +
                ", tiyu_T1_score2='" + tiyuT1Score2 + '\'' +
                ", tiyu_otherTotalT2='" + tiyuOtherTotalT2 + '\'' +
                ", tiyu_T2_races='" + tiyuT2Races + '\'' +
                ", tiyu_T2_earlyExercise='" + tiyuT2EarlyExercise + '\'' +
                ", meiyu='" + meiyu + '\'' +
                ", meiyu_practiceM1='" + meiyuPracticeM1 + '\'' +
                ", meiyu_competitionM2='" + meiyuCompetitionM2 + '\'' +
                ", teacher='" + teacher + '\'' +
                ", laoyu='" + laoyu + '\'' +
                ", laoyu_dailyTotalL1='" + laoyuDailyTotalL1 + '\'' +
                ", laoyu_L1_roomDaily='" + laoyuL1RoomDaily + '\'' +
                ", laoyu_L1_roomActivity='" + laoyuL1RoomActivity + '\'' +
                ", laoyu_L1_roomPerform='" + laoyuL1RoomPerform + '\'' +
                ", laoyu_volunteerL2='" + laoyuVolunteerL2 + '\'' +
                ", laoyu_internshipL3='" + laoyuInternshipL3 + '\'' +
                ", cxcy='" + cxcy + '\'' +
                ", cxcy_scoreTotalC1='" + cxcyScoreTotalC1 + '\'' +
                ", cxcy_C1_competition='" + cxcyC1Competition + '\'' +
                ", cxcy_C1_levelGrade='" + cxcyC1LevelGrade + '\'' +
                ", cxcy_socialActivityC2='" + cxcySocialActivityC2 + '\'' +
                ", cxcy_socialWorkC3='" + cxcySocialWorkC3 + '\'' +
                ", is_approval=" + isApproval +
                '}';
    }

    public int getIsApproval() {
        return isApproval;
    }

    public void setIsApproval(int isApproval) {
        this.isApproval = isApproval;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuNumber() {
        return stuNumber;
    }

    public void setStuNumber(String stuNumber) {
        this.stuNumber = stuNumber;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getDeyu() {
        return deyu;
    }

    public void setDeyu(String deyu) {
        this.deyu = deyu;
    }

    public String getDeyuBasicAssessD1() {
        return deyuBasicAssessD1;
    }

    public void setDeyuBasicAssessD1(String deyuBasicAssessD1) {
        this.deyuBasicAssessD1 = deyuBasicAssessD1;
    }

    public String getDeyuOtherTotalD2() {
        return deyuOtherTotalD2;
    }

    public void setDeyuOtherTotalD2(String deyuOtherTotalD2) {
        this.deyuOtherTotalD2 = deyuOtherTotalD2;
    }

    public String getDeyuD2GroupAssess() {
        return deyuD2GroupAssess;
    }

    public void setDeyuD2GroupAssess(String deyuD2GroupAssess) {
        this.deyuD2GroupAssess = deyuD2GroupAssess;
    }

    public String getDeyuD2SocialRespons() {
        return deyuD2SocialRespons;
    }

    public void setDeyuD2SocialRespons(String deyuD2SocialRespons) {
        this.deyuD2SocialRespons = deyuD2SocialRespons;
    }

    public String getDeyuD2PoliticalLearn() {
        return deyuD2PoliticalLearn;
    }

    public void setDeyuD2PoliticalLearn(String deyuD2PoliticalLearn) {
        this.deyuD2PoliticalLearn = deyuD2PoliticalLearn;
    }

    public String getDeyuD2MinusTotal() {
        return deyuD2MinusTotal;
    }

    public void setDeyuD2MinusTotal(String deyuD2MinusTotal) {
        this.deyuD2MinusTotal = deyuD2MinusTotal;
    }

    public String getDeyuD2HonorTotal() {
        return deyuD2HonorTotal;
    }

    public void setDeyuD2HonorTotal(String deyu_D2_honorTotal) {
        this.deyuD2HonorTotal = deyu_D2_honorTotal;
    }

    public String getZhiyu() {
        return zhiyu;
    }

    public void setZhiyu(String zhiyu) {
        this.zhiyu = zhiyu;
    }

    public String getZhiyuGPA() {
        return zhiyuGPA;
    }

    public void setZhiyuGPA(String zhiyuGPA) {
        this.zhiyuGPA = zhiyuGPA;
    }

    public String getTiyu() {
        return tiyu;
    }

    public void setTiyu(String tiyu) {
        this.tiyu = tiyu;
    }

    public String getTiyuScoreTotalT1() {
        return tiyuScoreTotalT1;
    }

    public void setTiyuScoreTotalT1(String tiyuScoreTotalT1) {
        this.tiyuScoreTotalT1 = tiyuScoreTotalT1;
    }

    public String getTiyuT1Score1() {
        return tiyuT1Score1;
    }

    public void setTiyuT1Score1(String tiyuT1Score1) {
        this.tiyuT1Score1 = tiyuT1Score1;
    }

    public String getTiyuT1Score2() {
        return tiyuT1Score2;
    }

    public void setTiyuT1Score2(String tiyuT1Score2) {
        this.tiyuT1Score2 = tiyuT1Score2;
    }

    public String getTiyuOtherTotalT2() {
        return tiyuOtherTotalT2;
    }

    public void setTiyuOtherTotalT2(String tiyuOtherTotalT2) {
        this.tiyuOtherTotalT2 = tiyuOtherTotalT2;
    }

    public String getTiyuT2Races() {
        return tiyuT2Races;
    }

    public void setTiyuT2Races(String tiyuT2Races) {
        this.tiyuT2Races = tiyuT2Races;
    }

    public String getTiyuT2EarlyExercise() {
        return tiyuT2EarlyExercise;
    }

    public void setTiyuT2EarlyExercise(String tiyuT2EarlyExercise) {
        this.tiyuT2EarlyExercise = tiyuT2EarlyExercise;
    }

    public String getMeiyu() {
        return meiyu;
    }

    public void setMeiyu(String meiyu) {
        this.meiyu = meiyu;
    }

    public String getMeiyuPracticeM1() {
        return meiyuPracticeM1;
    }

    public void setMeiyuPracticeM1(String meiyuPracticeM1) {
        this.meiyuPracticeM1 = meiyuPracticeM1;
    }

    public String getMeiyuCompetitionM2() {
        return meiyuCompetitionM2;
    }

    public void setMeiyuCompetitionM2(String meiyuCompetitionM2) {
        this.meiyuCompetitionM2 = meiyuCompetitionM2;
    }

    public String getLaoyu() {
        return laoyu;
    }

    public void setLaoyu(String laoyu) {
        this.laoyu = laoyu;
    }

    public String getLaoyuDailyTotalL1() {
        return laoyuDailyTotalL1;
    }

    public void setLaoyuDailyTotalL1(String laoyuDailyTotalL1) {
        this.laoyuDailyTotalL1 = laoyuDailyTotalL1;
    }

    public String getLaoyuL1RoomDaily() {
        return laoyuL1RoomDaily;
    }

    public void setLaoyuL1RoomDaily(String laoyuL1RoomDaily) {
        this.laoyuL1RoomDaily = laoyuL1RoomDaily;
    }

    public String getLaoyuL1RoomActivity() {
        return laoyuL1RoomActivity;
    }

    public void setLaoyuL1RoomActivity(String laoyuL1RoomActivity) {
        this.laoyuL1RoomActivity = laoyuL1RoomActivity;
    }

    public String getLaoyuL1RoomPerform() {
        return laoyuL1RoomPerform;
    }

    public void setLaoyuL1RoomPerform(String laoyuL1RoomPerform) {
        this.laoyuL1RoomPerform = laoyuL1RoomPerform;
    }

    public String getLaoyuVolunteerL2() {
        return laoyuVolunteerL2;
    }

    public void setLaoyuVolunteerL2(String laoyuVolunteerL2) {
        this.laoyuVolunteerL2 = laoyuVolunteerL2;
    }

    public String getLaoyuInternshipL3() {
        return laoyuInternshipL3;
    }

    public void setLaoyuInternshipL3(String laoyuInternshipL3) {
        this.laoyuInternshipL3 = laoyuInternshipL3;
    }

    public String getCxcy() {
        return cxcy;
    }

    public void setCxcy(String cxcy) {
        this.cxcy = cxcy;
    }

    public String getCxcyScoreTotalC1() {
        return cxcyScoreTotalC1;
    }

    public void setCxcyScoreTotalC1(String cxcyScoreTotalC1) {
        this.cxcyScoreTotalC1 = cxcyScoreTotalC1;
    }

    public String getCxcyC1Competition() {
        return cxcyC1Competition;
    }

    public void setCxcyC1Competition(String cxcyC1Competition) {
        this.cxcyC1Competition = cxcyC1Competition;
    }

    public String getCxcyC1LevelGrade() {
        return cxcyC1LevelGrade;
    }

    public void setCxcyC1LevelGrade(String cxcyC1LevelGrade) {
        this.cxcyC1LevelGrade = cxcyC1LevelGrade;
    }

    public String getCxcySocialActivityC2() {
        return cxcySocialActivityC2;
    }

    public void setCxcySocialActivityC2(String cxcySocialActivityC2) {
        this.cxcySocialActivityC2 = cxcySocialActivityC2;
    }

    public String getCxcySocialWorkC3() {
        return cxcySocialWorkC3;
    }

    public void setCxcySocialWorkC3(String cxcySocialWorkC3) {
        this.cxcySocialWorkC3 = cxcySocialWorkC3;
    }
}

