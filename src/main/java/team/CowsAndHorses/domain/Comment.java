package  team.CowsAndHorses.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class Comment {
    @TableId(type = IdType.AUTO)
    private int id;
    private int postId;
    private Integer publisherId;
    private String content;
    private Date createTime;
}
