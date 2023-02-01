package team.CowsAndHorses.service;


import org.springframework.transaction.annotation.Transactional;
import team.CowsAndHorses.domain.PostEntity;

import java.util.List;
@Transactional
public interface PostService {
    public int subPost(PostEntity post);

    public int updatePost(PostEntity post);

    public int deletePost(PostEntity post);

    public List<PostEntity> getPost(PostEntity post);
}
