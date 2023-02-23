package team.CowsAndHorses.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import team.CowsAndHorses.constant.AppealStatus;
import team.CowsAndHorses.constant.ErrorCode;
import team.CowsAndHorses.dao.AppealDao;
import team.CowsAndHorses.domain.Appeal;
import team.CowsAndHorses.domain.StuInfo;
import team.CowsAndHorses.domain.TeacherInfo;
import team.CowsAndHorses.exception.AppException;
import team.CowsAndHorses.service.AppealService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@CacheConfig(cacheNames = "ExpireOneMin")
@Service
public class AppealServiceimpl implements AppealService {
    final AppealDao appealDao;

    @Override
    public void submit(StuInfo stu, String content, int year, int moduleId) {
        Appeal appeal = Appeal.builder()
                .stuId(stu.getId())
                .college(stu.getStuCollege())
                .content(content)
                .year(year)
                .moduleId(moduleId)
                .status(AppealStatus.UNPROCESSED).build();
        appealDao.insert(appeal);
    }

    @Override
    public List<Appeal> query(StuInfo stu, int year) {
        return appealDao.selectList(new QueryWrapper<Appeal>()
                .eq("stu_id", stu.getId())
                .eq("year", year));
    }

    @Override
    public List<Appeal> query(TeacherInfo teacher, int year) {
        return appealDao.selectList(new QueryWrapper<Appeal>()
                .eq("module_id", teacher.getModuleId())
                .eq("college", teacher.getCollege())
                .eq("year", year));
    }

    @Override
    public void updateStatus(TeacherInfo teacher, int appealId, int isApproval) {
        Appeal appeal = appealDao.selectById(appealId);
        if (appeal == null) {
            throw new AppException(ErrorCode.PARAM_ERROR);
        }
        if (!appeal.getCollege().equals(teacher.getCollege())
                || !appeal.getModuleId().equals(teacher.getModuleId())) {
            throw new AppException(ErrorCode.FORBIDDEN);
        }
        if (isApproval == 0) {
            appeal.setStatus(AppealStatus.REJECT);
        } else {
            appeal.setStatus(AppealStatus.ACCEPT);
        }
        appealDao.update(appeal, null);
    }
}
