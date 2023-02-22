package team.CowsAndHorses.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author Patrick_Star
 * @version 1.0
 */
@Data
@Builder
public class ScoreFetchDto {
    private Integer score_id;
    private String stu_name;
    private String stu_number;
    private String score;
}
