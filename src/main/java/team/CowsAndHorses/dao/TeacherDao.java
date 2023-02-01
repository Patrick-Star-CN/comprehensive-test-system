package  team.CowsAndHorses.dao;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import team.CowsAndHorses.domain.Teacher;
import team.CowsAndHorses.domain.Time;

@Mapper
public interface TeacherDao {

    //注册
    @Insert("insert into teacher_info (teacher_name,teacher_password,teacher_college,module_id) values(#{username},#{password},#{college},#{moduleId})")
    public int register(Teacher teacher);

    //登录
    @Select("select teacher_name username,teacher_password password from teacher_info where teacher_name= #{username} and teacher_password=#{password} ")
    public Teacher login( Teacher teacher);

   @Select("select teacher_name username,teacher_password password,teacher_college college, module_id  moduleId from teacher_info where teacher_name=#{username}")
    public Teacher selectByName(String username);

    @Update("update teacher_info set teacher_password = #{password} where teacher_name =  #{username}")
    public int update(Teacher teacher);
   @Update("update time set year=#{year},month=#{month},day=#{day},hour=#{hour} ,minute=#{minute} where id=1")
   public int setTime(Time time);
   @Select("select * from time ")
   public int getTime(Time time);
//
//    @Delete("delete from tbl_book where id = #{id}")
//    public void delete(Integer id);
//
//    @Select("select * from tbl_book where id = #{id}")
//    public Book getById(Integer id);
//
//    @Select("select * from tbl_book")
//    public List<Book> getAll();
}
