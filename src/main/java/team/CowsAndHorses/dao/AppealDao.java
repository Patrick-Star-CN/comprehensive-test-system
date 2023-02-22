package  team.CowsAndHorses.dao;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import team.CowsAndHorses.domain.Appeal;

@Mapper
public interface AppealDao {

    @Insert("insert into appeal values(id,#{stuNumber},#{moduleId},#{content},#{isApproval},#{status})")
    public int submit(Appeal apl);


}
