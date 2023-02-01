package team.CowsAndHorses.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import team.CowsAndHorses.dao.StudentScoreDao;
import team.CowsAndHorses.domain.ScoreDoneEntity;
import team.CowsAndHorses.domain.ScoreEntity;
import team.CowsAndHorses.service.StudentScoreService;

import java.util.List;

@RequiredArgsConstructor
@CacheConfig(cacheNames = "ExpireOneMin")
@Service
public class StudentScoreServiceImpl implements StudentScoreService {

    final StudentScoreDao studentScoreDao;
    @Override
    public List<Integer> getIsApproval(ScoreDoneEntity scodo) {
        return studentScoreDao.getIsApproval(scodo);
    }

    @Override
    public ScoreEntity queryMyScore(ScoreEntity sco){
        return studentScoreDao.queryMyscore(sco);
    }

    @Override
    public ScoreEntity queryOtherScore(ScoreEntity sco){return studentScoreDao.queryOtherScore(sco);}

    @Override
    public int subScore(ScoreEntity sco) {
        return studentScoreDao.subScore(sco);
    }

    @Override
    public int getReason(String stuNumber,int year) {
        return studentScoreDao.getReason(stuNumber, year);
    }
}
