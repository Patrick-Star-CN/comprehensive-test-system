package  team.CowsAndHorses.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Picture {
    @TableId(type = IdType.AUTO)
    private int id;
    private String photo;
    private int itemId;
    private int scoreId;
}
