package team.CowsAndHorses.service;

import org.springframework.transaction.annotation.Transactional;
import team.CowsAndHorses.domain.TeacherInfo;
import team.CowsAndHorses.domain.Time;

@Transactional
public interface TeacherService {

    /**
     * 登录
     */
    TeacherInfo login(String username, String password);

    /**
     * 按id查询
     */
    TeacherInfo selectById(int id);

    /**
     * 修改密码
     */
    void changePassword(TeacherInfo teacherInfo);

}
