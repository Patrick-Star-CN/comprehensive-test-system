package  team.CowsAndHorses.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Advice {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer stuId;
    private Integer teacherId;
    private String stuContent;
    private String teacherContent;
    private Integer status;

}
