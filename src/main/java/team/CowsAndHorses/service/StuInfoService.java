package team.CowsAndHorses.service;


import org.springframework.transaction.annotation.Transactional;
import team.CowsAndHorses.domain.StuInfoEntity;

@Transactional
public interface StuInfoService {

    public StuInfoEntity login(StuInfoEntity stu);

    public int changePassword(StuInfoEntity stu);

    public StuInfoEntity selectByNumber(String stuNumber);

}
