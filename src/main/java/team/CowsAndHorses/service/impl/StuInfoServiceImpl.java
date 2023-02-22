package team.CowsAndHorses.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import team.CowsAndHorses.dao.StuInfoDao;
import team.CowsAndHorses.domain.StuInfo;
import team.CowsAndHorses.service.StuInfoService;

@RequiredArgsConstructor
@CacheConfig(cacheNames = "ExpireOneMin")
@Service
public class StuInfoServiceImpl implements StuInfoService {
    
    final StuInfoDao stuinfodao;

    @Override
    public StuInfo login(String stuNumber, String stuPassword){
        return stuinfodao.selectOne(new QueryWrapper<StuInfo>()
                .eq("stu_number", stuNumber)
                .eq("stu_password", stuPassword));
    }

    @Override
    public void changePassword(StuInfo stu){
        UpdateWrapper<StuInfo> wrapper = new UpdateWrapper<>();
        wrapper.eq("stu_number", stu.getStuNumber())
                .set("stu_password", stu.getStuPassword());
        stuinfodao.update(null, wrapper);
    }

    @Override
    public StuInfo selectByNumber(String stuNumber){
        return stuinfodao.selectOne(new QueryWrapper<StuInfo>()
                .eq("stu_number", stuNumber));
    }

    @Override
    public StuInfo selectById(int id) {
        return stuinfodao.selectById(id);
    }
}
