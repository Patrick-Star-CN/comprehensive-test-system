package team.CowsAndHorses.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import team.CowsAndHorses.dao.ContentDao;
import team.CowsAndHorses.domain.ContentEntity;
import team.CowsAndHorses.service.ContentService;

@RequiredArgsConstructor
@CacheConfig(cacheNames = "ExpireOneMin")
@Service
public class ContentServiceimpl implements ContentService {
    final ContentDao contentdao;

    @Override
    public int deleteCon(ContentEntity c) {
        return contentdao.deleteCon(c);
    }

    @Override
    public int subCon(ContentEntity c) {
        return contentdao.subCon(c);
    }

    @Override
    public int selectCom(ContentEntity c) {
        return contentdao.selectbCon(c);
    }
}
