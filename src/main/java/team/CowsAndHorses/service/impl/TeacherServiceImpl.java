package team.CowsAndHorses.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import team.CowsAndHorses.dao.TeacherDao;
import team.CowsAndHorses.domain.Teacher;
import team.CowsAndHorses.domain.Time;
import team.CowsAndHorses.service.TeacherService;

@RequiredArgsConstructor
@CacheConfig(cacheNames = "ExpireOneMin")
@Service
public class TeacherServiceImpl implements TeacherService {
    final TeacherDao teacherDao;

    @Override
    public int register(Teacher teacher) {
        return  teacherDao.register(teacher);

    }

    @Override
    public Teacher login( Teacher teacher){
        Teacher t=teacherDao.login(teacher);

        if (t != null ) {
            return t;
        }
        return null;

    }

    @Override
    public Teacher selectByName(String username){
       Teacher teacher= teacherDao.selectByName(username);
        return teacher;
    }

    @Override
    public int update(Teacher teacher){
     return teacherDao.update(teacher);
    }

    @Override
    public int setTime(Time time){return teacherDao.setTime(time);}

//    public boolean delete(Integer id) {
//        teacherDao.delete(id);
//        return true;
//    }
//
//    public Book getById(Integer id) {
//        return teacherDao.getById(id);
//    }
//
//    public List<Book> getAll() {
//        return teacherDao.getAll();
//    }
}
