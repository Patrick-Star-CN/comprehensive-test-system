package  team.CowsAndHorses.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import team.CowsAndHorses.domain.Advice;

import java.util.List;
@Mapper
public interface TeacherAdviceDao {

    @Select("select * from advice where status=0")
    public List<Advice> getAdvice ();

    @Update("update advice set teacher_content=#{teacherContent},status=1 where id=#{id}")
    public int dealAdvice(Advice advice);
}
