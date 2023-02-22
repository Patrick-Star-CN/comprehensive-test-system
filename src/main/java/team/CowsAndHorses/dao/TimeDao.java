package  team.CowsAndHorses.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import team.CowsAndHorses.domain.Time;

@Mapper
public interface TimeDao extends BaseMapper<Time> {
}
