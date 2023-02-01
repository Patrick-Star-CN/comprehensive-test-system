package team.CowsAndHorses.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import team.CowsAndHorses.dao.CommentDao;
import team.CowsAndHorses.domain.CommentEntity;
import team.CowsAndHorses.service.CommentService;

import java.util.List;

@RequiredArgsConstructor
@CacheConfig(cacheNames = "ExpireOneMin")
@Service
public class CommentServiceimpl implements CommentService {
    final CommentDao comdao;

    @Override
    public int subComment(CommentEntity comment) {
        return comdao.subComment(comment);
    }

    @Override
    public int update(CommentEntity comment) {
        return comdao.update(comment);
    }

    @Override
    public int deleteCom(CommentEntity comment) {
        return comdao.deleteCom(comment);
    }

    @Override
    public List<CommentEntity> getCom(CommentEntity comment) {
        return comdao.getComment(comment);
    }


}
