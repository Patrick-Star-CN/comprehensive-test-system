package  team.CowsAndHorses.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import team.CowsAndHorses.domain.TeacherInfo;

@Mapper
public interface TeacherDao extends BaseMapper<TeacherInfo> {
}
