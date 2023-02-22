package team.CowsAndHorses.dto;

import lombok.Data;

/**
 * @author Patrick_Star
 * @version 1.0
 */
@Data
public class ScoreDto {
    private String year;
    private Item deyu_group_assess;
    private Item deyu_social_resp;
    private Item deyu_honor_total;

    private Item tiyu_races;

    private Item meiyu_practice;
    private Item meiyu_competition;

    private Item laoyu_room_activity;

    private Item cxcy_competition;
    private Item cxcy_level_grade;
    private Item cxcy_social_activity;
}

