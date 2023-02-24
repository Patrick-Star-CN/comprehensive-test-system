package team.CowsAndHorses.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author Patrick_Star
 * @version 1.0
 */
@Data
@Builder
public class ScoreDoneDto {
    private Integer score_done_id;
    private String stu_name;
    private String stu_number;
    private Integer is_approval;
}
