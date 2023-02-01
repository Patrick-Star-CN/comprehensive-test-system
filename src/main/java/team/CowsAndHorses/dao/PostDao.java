package  team.CowsAndHorses.dao;


import org.apache.ibatis.annotations.*;
import team.CowsAndHorses.domain.PostEntity;

import java.util.List;

@Mapper
public interface PostDao {
    @Insert("insert into post values (id,#{nickName},#{content},#{createTime})")
    public int subPost(PostEntity post);

    @Update("update post set content=#{content},create_time=#{createTime} where id=#{id}")
    public int updatePost(PostEntity post);

    @Delete("delete from post where id=#{id}")
    public int deletePost(PostEntity post);

    @Select("select * from post ")
    public List<PostEntity> getPost(PostEntity post);
}
