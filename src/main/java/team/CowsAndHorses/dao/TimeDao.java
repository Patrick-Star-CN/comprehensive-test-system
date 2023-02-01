package  team.CowsAndHorses.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import team.CowsAndHorses.domain.Time;

@Mapper
public interface TimeDao {
    @Select("select * from time where id=#{id}")
    public Time getTime(Time t);
}
