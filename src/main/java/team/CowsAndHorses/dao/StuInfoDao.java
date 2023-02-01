package  team.CowsAndHorses.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import team.CowsAndHorses.domain.StuInfoEntity;

@Mapper
public interface StuInfoDao {

    @Select("select * from stu_info where stu_number=#{stuNumber} and stu_password=#{stuPassword}")
    public StuInfoEntity login(StuInfoEntity stuentity);

    @Update("update stu_info set stu_password = #{stuPassword} where stu_number = #{stuNumber}")
    public int changePassword(StuInfoEntity stuentity);

    @Select("select * from stu_info where stu_number=#{stuNumber}")
    public StuInfoEntity selectByNumber(String stuNumber);
}
