package  team.CowsAndHorses.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import team.CowsAndHorses.domain.Appeal;

import java.util.List;

@Mapper
public interface TeacherAppealDao {

    @Select("select * from appeal where year=#{year} and module_id=#{moduleId} and status=\"未处理\"  ")
    public List<Appeal> getAppeal(@Param("year") int year, @Param("moduleId") int moduleId);

    @Update("update appeal set is_approval=#{is_approval},status=\"已通过\" where id=#{appeal_id}")
    public int isAppeal(@Param("is_approval") int isApproval, @Param("appeal_id") int appealId);

    @Update("update appeal set is_approval=#{is_approval},status=\"未通过\" where id=#{appeal_id}")
    public int isnotAppeal(@Param("is_approval") int isApproval, @Param("appeal_id") int appealId);

}
