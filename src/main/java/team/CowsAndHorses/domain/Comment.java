package  team.CowsAndHorses.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Data
@Builder
public class Comment {
    private int id;
    private int postId;
    private String nickName;
    private String content;
    private Date createTime;
}
