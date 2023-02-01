package  team.CowsAndHorses.dao;

import team.CowsAndHorses.domain.ContentEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ContentDao {
    @Delete("delete from content where stu_number=#{stuNumber} and year=#{year} and moduleId=#{moduleId}")
    public int deleteCon(ContentEntity c);

    @Select("select * from content where stu_number=#{stuNumber} and year=#{year} and moduleId=#{moduleId}")
    public int selectbCon(ContentEntity c);

    @Insert("insert into content values(#{content},id,#{stuNumber},#{year},#{moduleId})")
    public int subCon(ContentEntity c);


}
