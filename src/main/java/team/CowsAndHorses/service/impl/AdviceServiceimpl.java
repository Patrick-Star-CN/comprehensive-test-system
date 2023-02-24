package team.CowsAndHorses.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import team.CowsAndHorses.constant.ErrorCode;
import team.CowsAndHorses.dao.AdviceDao;
import team.CowsAndHorses.dao.TeacherDao;
import team.CowsAndHorses.domain.Advice;
import team.CowsAndHorses.domain.StuInfo;
import team.CowsAndHorses.domain.TeacherInfo;
import team.CowsAndHorses.exception.AppException;
import team.CowsAndHorses.service.AdviceService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import team.CowsAndHorses.service.TeacherService;

import java.util.List;

@RequiredArgsConstructor
@CacheConfig(cacheNames = "ExpireOneMin")
@Service
public class AdviceServiceimpl implements AdviceService {
    final AdviceDao adviceDao;
    final TeacherDao teacherDao;

    @Override
    public void submit(StuInfo stu, String content, int moduleId, int isAnonymous) {
        TeacherInfo teacher = teacherDao.selectOne(new QueryWrapper<TeacherInfo>()
                .eq("module_id", moduleId)
                .eq("college", stu.getStuCollege()));
        if (teacher == null) {
            throw new AppException(ErrorCode.PARAM_ERROR);
        }
        Advice advice = Advice.builder()
                .stuId(stu.getId())
                .teacherId(teacher.getId())
                .stuContent(content)
                .isAnonymous(isAnonymous == 1)
                .status(0).build();
        adviceDao.insert(advice);
    }

    @Override
    public void change(StuInfo stu, String content, int adviceId) {
        Advice advice = adviceDao.selectById(adviceId);
        if (advice == null) {
            throw new AppException(ErrorCode.PARAM_ERROR);
        }
        if (advice.getStuId() != stu.getId()) {
            throw new AppException(ErrorCode.FORBIDDEN);
        }
        if (advice.getStatus() == 1) {
            throw new AppException(ErrorCode.PROCESSED);
        }
        advice.setStuContent(content);
        adviceDao.updateById(advice);
    }

    @Override
    public void process(TeacherInfo teacher, String content, int adviceId) {
        Advice advice = adviceDao.selectById(adviceId);
        if (advice == null) {
            throw new AppException(ErrorCode.PARAM_ERROR);
        }
        if (!advice.getTeacherId().equals(teacher.getId())) {
            throw new AppException(ErrorCode.FORBIDDEN);
        }
        if (advice.getStatus() == 1) {
            throw new AppException(ErrorCode.PROCESSED);
        }
        advice.setTeacherContent(content);
        advice.setStatus(1);
        adviceDao.updateById(advice);
    }

    @Override
    public List<Advice> query(StuInfo stu) {
        return adviceDao.selectList(new QueryWrapper<Advice>()
                .eq("stu_id", stu.getId()));
    }

    @Override
    public List<Advice> query(TeacherInfo teacher) {
        return adviceDao.selectList(new QueryWrapper<Advice>()
                .eq("teacher_id", teacher.getId()));
    }
}
