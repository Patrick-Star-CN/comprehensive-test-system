package  team.CowsAndHorses.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import team.CowsAndHorses.domain.Reason;

import java.util.List;
@Mapper
public interface ReasonDao extends BaseMapper<Reason> {
}
