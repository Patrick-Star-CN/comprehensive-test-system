package  team.CowsAndHorses.dao;

import team.CowsAndHorses.domain.CommentEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentDao {
    @Insert("insert into comment values (id,#{postId},#{nickName},#{content},#{createTime})")
    public int subComment(CommentEntity comment);

    @Update("update comment set content=#{content},create_time=#{createTime} where id=#{id} and post_id=#{postId}")
    public int update(CommentEntity comment);

    @Delete("delete from comment where id=#{id} and post_id=#{postId}")
    public int deleteCom(CommentEntity comment);

    @Select("select * from comment where post_id=#{postId}")
    public List<CommentEntity> getComment(CommentEntity comment);
}
