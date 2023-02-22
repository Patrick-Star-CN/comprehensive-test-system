package team.CowsAndHorses.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author Patrick_Star
 * @version 1.0
 */
@Data
@Builder
public class ItemScoreDto {
    private String stu_name;
    private String stu_number;
    private List<String> score;
    private List<String> content;
    private List<PictureDto> picture;
}
