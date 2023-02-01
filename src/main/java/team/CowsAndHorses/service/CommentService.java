package team.CowsAndHorses.service;

import org.springframework.transaction.annotation.Transactional;
import team.CowsAndHorses.domain.CommentEntity;

import java.util.List;

@Transactional
public interface CommentService {
    public int subComment(CommentEntity comment);

    public int update(CommentEntity comment);

    public int deleteCom(CommentEntity comment);

    public List<CommentEntity> getCom(CommentEntity comment);
}
