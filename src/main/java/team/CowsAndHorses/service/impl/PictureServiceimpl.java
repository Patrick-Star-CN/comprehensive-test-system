package team.CowsAndHorses.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import team.CowsAndHorses.dao.PictureDao;
import team.CowsAndHorses.domain.PictureEntity;
import team.CowsAndHorses.service.PictureService;

@RequiredArgsConstructor
@CacheConfig(cacheNames = "ExpireOneMin")
@Service
public class PictureServiceimpl implements PictureService {
    final PictureDao pictureDao;

    @Override
    public int subPicture(PictureEntity p) {
        return pictureDao.subPicture(p);
    }

    @Override
    public int getPicture(PictureEntity p) {
        return pictureDao.getPicture(p);
    }

    @Override
    public int delPicture(PictureEntity p) {
        return pictureDao.delPicture(p);
    }
}
