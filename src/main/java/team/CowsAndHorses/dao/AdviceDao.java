package  team.CowsAndHorses.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import team.CowsAndHorses.domain.Advice;

@Mapper
public interface AdviceDao extends BaseMapper<Advice> {
}
