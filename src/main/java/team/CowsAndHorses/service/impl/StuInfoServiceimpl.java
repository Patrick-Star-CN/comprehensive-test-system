package team.CowsAndHorses.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import team.CowsAndHorses.dao.StuInfoDao;
import team.CowsAndHorses.domain.StuInfoEntity;
import team.CowsAndHorses.service.StuInfoService;

@RequiredArgsConstructor
@CacheConfig(cacheNames = "ExpireOneMin")
@Service
public class StuInfoServiceimpl implements StuInfoService {
    
    final StuInfoDao stuinfodao;

    @Override
    public StuInfoEntity login(StuInfoEntity stu){
        StuInfoEntity stuentity =stuinfodao.login(stu);
        return stuentity;
    }

    @Override
    public int changePassword(StuInfoEntity stu){
        return stuinfodao.changePassword(stu);
    }

    public StuInfoEntity selectByNumber(String stuNumber){   return stuinfodao.selectByNumber(stuNumber);}

}
