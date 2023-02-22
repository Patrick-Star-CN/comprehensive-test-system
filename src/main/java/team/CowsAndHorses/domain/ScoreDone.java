package  team.CowsAndHorses.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class ScoreDone {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer stuId;
    private String college;
    private Integer year;

    private Double total;

    private Double deyu;
    private Double deyuBasicAssess;
    private Double deyuOtherTotal;
    private Double deyuGroupAssess;
    private Double deyuSocialRespons;
    private Double deyuPoliticalLearn;
    private Double deyuMinusTotal;
    private Double deyuHonorTotal;

    private Double zhiyu;
    private Double zhiyuGpa;

    private Double tiyu;
    private Double tiyuScoreTotal;
    private Double tiyuScore1;
    private Double tiyuScore2;
    private Double tiyuOtherTotal;
    private Double tiyuRaces;
    private Double tiyuEarlyExercise;

    private Double meiyu;
    private Double meiyuPractice;
    private Double meiyuCompetition;

    private Double laoyu;
    private Double laoyuDailyTotal;
    private Double laoyuRoomDaily;
    private Double laoyuRoomActivity;
    private Double laoyuRoomPerform;
    private Double laoyuVolunteer;
    private Double laoyuInternship;

    private Double cxcy;
    private Double cxcyScoreTotal;
    private Double cxcyCompetition;
    private Double cxcyLevelGrade;
    private Double cxcySocialActivity;
    private Double cxcySocialWork;
    private Boolean isApproval;

    private Date updateTime;
}

