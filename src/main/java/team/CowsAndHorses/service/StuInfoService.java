package team.CowsAndHorses.service;


import org.springframework.transaction.annotation.Transactional;
import team.CowsAndHorses.domain.StuInfo;

@Transactional
public interface StuInfoService {

    StuInfo login(String stuNumber, String stuPassword);

    void changePassword(StuInfo stu);

    StuInfo selectByNumber(String stuNumber);

    StuInfo selectById(int id);
}
