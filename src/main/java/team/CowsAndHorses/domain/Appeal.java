package  team.CowsAndHorses.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Appeal {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer year;
    private Integer stuId;
    private Integer moduleId;
    private String college;
    private String content;
    private String status;
}
