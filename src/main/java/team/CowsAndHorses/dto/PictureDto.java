package team.CowsAndHorses.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author Patrick_Star
 * @version 1.0
 */
@Data
@Builder
public class PictureDto {
    private String image;
    private int item_id;
}
