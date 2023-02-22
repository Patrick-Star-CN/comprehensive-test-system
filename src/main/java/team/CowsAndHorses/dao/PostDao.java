package  team.CowsAndHorses.dao;


import org.apache.ibatis.annotations.*;
import team.CowsAndHorses.domain.Post;

import java.util.List;

@Mapper
public interface PostDao {
    @Insert("insert into post values (id,#{nickName},#{content},#{createTime})")
    public int subPost(Post post);

    @Update("update post set content=#{content},create_time=#{createTime} where id=#{id}")
    public int updatePost(Post post);

    @Delete("delete from post where id=#{id}")
    public int deletePost(Post post);

    @Select("select * from post ")
    public List<Post> getPost(Post post);
}
