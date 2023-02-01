package team.CowsAndHorses.service;

import org.springframework.transaction.annotation.Transactional;
import team.CowsAndHorses.domain.Teacher;
import team.CowsAndHorses.domain.Time;

@Transactional
public interface TeacherService {

    /**
     * 注册
     * @param teacher
     * @return
     */
    public int register(Teacher teacher);
    /**
     * 登录
     * @param teacher
     * @return
     */
    public Teacher login( Teacher teacher);


//    /**
//     * 按id删除
//     * @param id
//     * @return
//     */
//    public boolean delete(Integer id);
//
    /**
     * 按id查询
     * @param username
     * @return
     */
    public Teacher selectByName(String username);

    /**
     * 修改密码
     * @param teacher
     */
    public int update(Teacher teacher);


    public int setTime(Time time);
//    /**
//     * 查询全部
//     * @return
//     */
//    public List<Book> getAll();
}
