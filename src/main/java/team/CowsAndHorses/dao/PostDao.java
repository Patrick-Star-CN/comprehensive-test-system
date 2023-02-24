package  team.CowsAndHorses.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import team.CowsAndHorses.domain.Post;

import java.util.List;

@Mapper
public interface PostDao extends BaseMapper<Post> {
}
