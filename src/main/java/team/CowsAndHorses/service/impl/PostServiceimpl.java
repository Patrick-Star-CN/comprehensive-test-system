package team.CowsAndHorses.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import team.CowsAndHorses.dao.PostDao;
import team.CowsAndHorses.domain.PostEntity;
import team.CowsAndHorses.service.PostService;

import java.util.List;

@RequiredArgsConstructor
@CacheConfig(cacheNames = "ExpireOneMin")
@Service
public class PostServiceimpl implements PostService {

     final PostDao podao;

    @Override
    public int subPost(PostEntity post) {
        return podao.subPost(post);
    }

    @Override
    public int updatePost(PostEntity post) {
        return podao.updatePost(post);
    }

    @Override
    public int deletePost(PostEntity post) {
        return podao.deletePost(post);
    }

    @Override
    public List<PostEntity> getPost(PostEntity post) {
        return podao.getPost(post);
    }


}
