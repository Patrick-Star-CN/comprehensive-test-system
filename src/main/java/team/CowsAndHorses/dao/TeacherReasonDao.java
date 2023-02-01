package  team.CowsAndHorses.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import team.CowsAndHorses.domain.ReasonEntity;

import java.util.List;
@Mapper
public interface TeacherReasonDao {
    @Select("select * from reason ")
    public List<ReasonEntity> getReason();
    @Insert("insert into reason (content) values (#{content})")
    public int addReason(String content);
    @Delete("delete from reason where id=#{id}")
    public int deleteReason(int id);
}
