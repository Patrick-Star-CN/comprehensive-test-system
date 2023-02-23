package  team.CowsAndHorses.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import team.CowsAndHorses.domain.Appeal;

@Mapper
public interface AppealDao extends BaseMapper<Appeal> {
}
