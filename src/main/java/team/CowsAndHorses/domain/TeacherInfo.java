package  team.CowsAndHorses.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeacherInfo {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private String college;
    private Integer moduleId;
}
