package team.CowsAndHorses.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import team.CowsAndHorses.constant.ErrorCode;
import team.CowsAndHorses.dao.ReasonDao;
import team.CowsAndHorses.domain.Reason;
import team.CowsAndHorses.domain.TeacherInfo;
import team.CowsAndHorses.exception.AppException;
import team.CowsAndHorses.service.ReasonService;

import java.util.List;

@RequiredArgsConstructor
@CacheConfig(cacheNames = "ExpireOneMin")
@Service
public class ReasonServiceImpl implements ReasonService {
    final ReasonDao reasonDao;

    @Override
    public List<Reason> get(TeacherInfo teacher) {
        return reasonDao.selectList(new QueryWrapper<Reason>()
                .eq("teacher_id", teacher.getId()));
    }

    @Override
    public void add(TeacherInfo teacher, String content) {
        reasonDao.insert(Reason.builder()
                .content(content)
                .teacherId(teacher.getId()).build());
    }

    @Override
    public void delete(TeacherInfo teacher, int id) {
        Reason reason = reasonDao.selectById(id);
        if (reason.getTeacherId() != teacher.getId()) {
            throw new AppException(ErrorCode.FORBIDDEN);
        }
        reasonDao.deleteById(reason);
    }

    @Override
    public void update(TeacherInfo teacher, int id, String content) {
        Reason reason = reasonDao.selectById(id);
        if (reason.getTeacherId() != teacher.getId()) {
            throw new AppException(ErrorCode.FORBIDDEN);
        }
        reason.setContent(content);
        reasonDao.updateById(reason);
    }
}
