package  team.CowsAndHorses.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdviceDao {

    @Insert("insert into advice values (id,#{stu_number},#{stu_content},#{teacher_content},#{status})")
    public int submit(@Param("stu_number") String stuNumber, @Param("stu_content")String stuContent, @Param("teacher_content")String teacherContent, @Param("status")int status);
}
