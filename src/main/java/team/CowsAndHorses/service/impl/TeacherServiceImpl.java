package team.CowsAndHorses.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import team.CowsAndHorses.dao.TeacherDao;
import team.CowsAndHorses.domain.StuInfo;
import team.CowsAndHorses.domain.TeacherInfo;
import team.CowsAndHorses.domain.Time;
import team.CowsAndHorses.service.TeacherService;

@RequiredArgsConstructor
@CacheConfig(cacheNames = "ExpireOneMin")
@Service
public class TeacherServiceImpl implements TeacherService {
    final TeacherDao teacherDao;

    @Override
    public TeacherInfo login(String username, String password) {
        return teacherDao.selectOne(new QueryWrapper<TeacherInfo>()
                .eq("username", username)
                .eq("password", password));
    }

    @Override
    public TeacherInfo selectById(int id) {
        return teacherDao.selectOne(new QueryWrapper<TeacherInfo>()
                .eq("id", id));
    }

    @Override
    public void changePassword(TeacherInfo teacher) {
        UpdateWrapper<TeacherInfo> wrapper = new UpdateWrapper<>();
        wrapper.eq("username", teacher.getUsername())
                .set("password", teacher.getPassword());
        teacherDao.update(null, wrapper);
    }

}
