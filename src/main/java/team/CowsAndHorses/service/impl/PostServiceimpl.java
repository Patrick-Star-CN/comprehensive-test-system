package team.CowsAndHorses.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import team.CowsAndHorses.constant.ErrorCode;
import team.CowsAndHorses.dao.PostDao;
import team.CowsAndHorses.domain.Post;
import team.CowsAndHorses.domain.StuInfo;
import team.CowsAndHorses.domain.TeacherInfo;
import team.CowsAndHorses.exception.AppException;
import team.CowsAndHorses.service.PostService;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@RequiredArgsConstructor
@CacheConfig(cacheNames = "ExpireOneMin")
@Service
public class PostServiceimpl implements PostService {
    final PostDao postDao;

    @Override
    public void submit(TeacherInfo teacher, String content) {
        postDao.insert(Post.builder()
                .content(content)
                .publisherId(teacher.getId())
                .createTime(new Date(Calendar.getInstance().getTime().getTime())).build());
    }

    @Override
    public void submit(StuInfo stu, String content) {
        postDao.insert(Post.builder()
                .content(content)
                .publisherId(stu.getId())
                .createTime(new Date(Calendar.getInstance().getTime().getTime())).build());
    }

    @Override
    public void update(TeacherInfo teacher, int postId, String content) {
        update(postId, content, teacher.getId());
    }

    @Override
    public void update(StuInfo stu, int postId, String content) {
        update(postId, content, stu.getId());
    }

    public void update(int postId, String content, int id) {
        Post post = postDao.selectById(postId);
        if (post.getPublisherId() != id) {
            throw new AppException(ErrorCode.FORBIDDEN);
        }
        post.setContent(content);
        post.setCreateTime(new Date(Calendar.getInstance().getTime().getTime()));
        postDao.updateById(post);
    }


    @Override
    public void delete(TeacherInfo teacher, int postId) {
        Post post = postDao.selectById(postId);
        if (!post.getPublisherId().equals(teacher.getId())) {
            throw new AppException(ErrorCode.FORBIDDEN);
        }
        postDao.deleteById(post);
    }

    @Override
    public void delete(StuInfo stu, int postId) {
        Post post = postDao.selectById(postId);
        if (post.getPublisherId() != stu.getId()) {
            throw new AppException(ErrorCode.FORBIDDEN);
        }
        postDao.deleteById(post);
    }

    @Override
    public List<Post> get() {
        List<Post> posts = postDao.selectList(new QueryWrapper<>());
        for (Post post : posts) {
            post.setPublisherId(post.getPublisherId() >= 100000 ? 1 : 0);
        }
        return posts;
    }
}