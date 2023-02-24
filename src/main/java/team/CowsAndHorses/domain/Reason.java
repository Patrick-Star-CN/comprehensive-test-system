package  team.CowsAndHorses.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Reason {
    @TableId(type = IdType.AUTO)
    private int id;
    private int teacherId;
    private String content;
}
