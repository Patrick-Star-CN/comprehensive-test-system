package  team.CowsAndHorses.domain;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Score {
    private int id;
    private int stuId;
    private String college;
    private int year;
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private Integer isApprovedDeyu;
    private Double deyuGroupAssessScore;
    private String deyuGroupAssessContent;
    private Double deyuSocialRespScore;
    private String deyuSocialRespContent;
    private Double deyuHonorTotalScore;
    private String deyuHonorTotalContent;
    private String deyuReason;
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private Integer isApprovedTiyu;
    private Double tiyuRacesScore;
    private String tiyuRacesContent;
    private String tiyuReason;
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private Integer isApprovedMeiyu;
    private Double meiyuPracticeScore;
    private String meiyuPracticeContent;
    private Double meiyuCompetitionScore;
    private String meiyuCompetitionContent;
    private String meiyuReason;
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private Integer isApprovedLaoyu;
    private Double laoyuRoomActivityScore;
    private String laoyuRoomActivityContent;
    private String laoyuReason;
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private Integer isApprovedCxcy;
    private Double cxcyCompetitionScore;
    private String cxcyCompetitionContent;
    private Double cxcyLevelGradeScore;
    private String cxcyLevelGradeContent;
    private Double cxcySocialActivityScore;
    private String cxcySocialActivityContent;
    private String cxcyReason;

    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private Boolean isApproved;
}