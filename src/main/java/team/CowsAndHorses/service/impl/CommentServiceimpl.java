package team.CowsAndHorses.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import team.CowsAndHorses.constant.ErrorCode;
import team.CowsAndHorses.dao.CommentDao;
import team.CowsAndHorses.domain.Comment;
import team.CowsAndHorses.domain.Post;
import team.CowsAndHorses.domain.StuInfo;
import team.CowsAndHorses.domain.TeacherInfo;
import team.CowsAndHorses.exception.AppException;
import team.CowsAndHorses.service.CommentService;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@RequiredArgsConstructor
@CacheConfig(cacheNames = "ExpireOneMin")
@Service
public class CommentServiceimpl implements CommentService {
    final CommentDao commentDao;

    @Override
    public void submit(TeacherInfo teacher, String content, int postId) {
        commentDao.insert(Comment.builder()
                .content(content)
                .postId(postId)
                .publisherId(teacher.getId())
                .createTime(new Date(Calendar.getInstance().getTime().getTime())).build());
    }

    @Override
    public void submit(StuInfo stu, String content, int postId) {
        commentDao.insert(Comment.builder()
                .content(content)
                .postId(postId)
                .publisherId(stu.getId())
                .createTime(new Date(Calendar.getInstance().getTime().getTime())).build());
    }

    @Override
    public void update(TeacherInfo teacher, int commentId, String content) {
        update(commentId, content, teacher.getId());
    }

    @Override
    public void update(StuInfo stu, int commentId, String content) {
        update(commentId, content, stu.getId());
    }

    public void update(int commentId, String content, int id) {
        Comment comment = commentDao.selectById(commentId);
        if (comment.getPublisherId() != id) {
            throw new AppException(ErrorCode.FORBIDDEN);
        }
        comment.setContent(content);
        comment.setCreateTime(new Date(Calendar.getInstance().getTime().getTime()));
        commentDao.updateById(comment);
    }


    @Override
    public void delete(TeacherInfo teacher, int commentId) {
        Comment comment = commentDao.selectById(commentId);
        if (!comment.getPublisherId().equals(teacher.getId())) {
            throw new AppException(ErrorCode.FORBIDDEN);
        }
        commentDao.deleteById(comment);
    }

    @Override
    public void delete(StuInfo stu, int commentId) {
        Comment comment = commentDao.selectById(commentId);
        if (!comment.getPublisherId().equals(stu.getId())) {
            throw new AppException(ErrorCode.FORBIDDEN);
        }
        commentDao.deleteById(comment);
    }

    @Override
    public List<Comment> get(int postId) {
        List<Comment> comments = commentDao.selectList(new QueryWrapper<Comment>()
                .eq("post_id", postId));
        for (Comment comment : comments) {
            comment.setPublisherId(comment.getPublisherId() >= 100000 ? 1 : 0);
        }
        return comments;
    }
}
