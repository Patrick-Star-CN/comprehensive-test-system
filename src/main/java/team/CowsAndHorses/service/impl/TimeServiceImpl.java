package team.CowsAndHorses.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import team.CowsAndHorses.dao.TimeDao;
import team.CowsAndHorses.domain.StuInfo;
import team.CowsAndHorses.domain.TeacherInfo;
import team.CowsAndHorses.domain.Time;
import team.CowsAndHorses.service.TimeService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@CacheConfig(cacheNames = "ExpireOneMin")
@Service
public class TimeServiceImpl implements TimeService {
    final TimeDao timedao;

    @Override
    public Time query(int module, String college, int year) {
        return timedao.selectOne(new QueryWrapper<Time>()
                .eq("module", module)
                .eq("college", college)
                .eq("year", year));
    }

    @Override
    public List<Time> query(String college, int year) {
        return timedao.selectList(new QueryWrapper<Time>()
                .eq("college", college)
                .eq("year", year));
    }

    @Override
    public void insert(Date ddl, TeacherInfo teacher, Integer year) {
        timedao.insert(Time.builder()
                .ddl(ddl)
                .college(teacher.getCollege())
                .module(teacher.getModuleId())
                .year(year).build());
    }

    @Override
    public void update(Date ddl, TeacherInfo teacher) {
        UpdateWrapper<Time> wrapper = new UpdateWrapper<>();
        wrapper.eq("college", teacher.getCollege())
                .eq("module", teacher.getModuleId())
                .set("ddl", ddl);
        timedao.update(null, wrapper);
    }
}
