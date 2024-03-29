package  team.CowsAndHorses.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class Time {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String college;
    private Integer module;
    private Integer year;
    private Date ddl;
}
