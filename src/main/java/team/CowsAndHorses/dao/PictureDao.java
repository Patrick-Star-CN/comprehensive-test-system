package  team.CowsAndHorses.dao;

import team.CowsAndHorses.domain.PictureEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PictureDao {

    @Insert("insert into picture values (id,#{photo},#{moduleId},#{stuNumber},#{year})")
    public int subPicture(PictureEntity p);

    @Select("select * from picture where stu_number=#{stuNumber} and year=#{year} and moduleId=#{moduleId}")
    public int getPicture(PictureEntity p);

    @Delete("delete from picture where stu_number=#{stuNumber} and year=#{year} and moduleId=#{moduleId}")
    public int delPicture(PictureEntity p);
}
