package  team.CowsAndHorses.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class Post {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer publisherId;
    private String content;
    private Date createTime;
}
