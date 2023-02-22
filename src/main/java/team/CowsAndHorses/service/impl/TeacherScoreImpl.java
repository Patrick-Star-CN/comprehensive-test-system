package team.CowsAndHorses.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import team.CowsAndHorses.constant.ErrorCode;
import team.CowsAndHorses.constant.ModuleConstant;
import team.CowsAndHorses.dao.PictureDao;
import team.CowsAndHorses.dao.ScoreDao;
import team.CowsAndHorses.dao.ScoreDoneDao;
import team.CowsAndHorses.domain.*;
import team.CowsAndHorses.dto.ItemScoreDto;
import team.CowsAndHorses.dto.PictureDto;
import team.CowsAndHorses.dto.ScoreFetchDto;
import team.CowsAndHorses.exception.AppException;
import team.CowsAndHorses.service.StuInfoService;
import team.CowsAndHorses.service.TeacherScoreService;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@CacheConfig(cacheNames = "ExpireOneMin")
@Service
public class TeacherScoreImpl implements TeacherScoreService {
    final ScoreDoneDao scoreDoneDao;
    final StuInfoService stuInfoService;
    final ScoreDao scoreDao;
    final PictureDao pictureDao;

    @Override
    public List<ScoreFetchDto> query(TeacherInfo teacher, int year) {
        List<Score> scores = scoreDao.selectList(new QueryWrapper<Score>()
                .eq("year", year)
                .eq("college", teacher.getCollege())
                .eq(ModuleConstant.moduleApproved[teacher.getModuleId()], false));
        List<ScoreFetchDto> list = new ArrayList<>();
        for (Score score : scores) {
            StuInfo stu = stuInfoService.selectById(score.getStuId());
            ScoreFetchDto scoreFetchDto = ScoreFetchDto.builder()
                    .score_id(score.getId())
                    .stu_name(stu.getStuName())
                    .stu_number(stu.getStuNumber())
                    .build();
            double scoreSum = 0;
            switch (teacher.getModuleId()) {
                case 1: {
                    scoreSum = score.getDeyuGroupAssessScore() + score.getDeyuSocialRespScore() + score.getDeyuHonorTotalScore();
                    break;
                }
                case 3: {
                    scoreSum = score.getTiyuRacesScore();
                    break;
                }
                case 4: {
                    scoreSum = score.getMeiyuCompetitionScore() + score.getMeiyuPracticeScore();
                    break;
                }
                case 5: {
                    scoreSum = score.getLaoyuRoomActivityScore();
                    break;
                }
                case 6: {
                    scoreSum = score.getCxcyCompetitionScore() + score.getCxcyLevelGradeScore() + score.getCxcySocialActivityScore();
                    break;
                }
                default: {
                }
            }
            scoreFetchDto.setScore(String.valueOf(scoreSum));
            list.add(scoreFetchDto);
        }
        return list;
    }

    @Override
    public ItemScoreDto queryItem(TeacherInfo teacher, int scoreId) {
        Score score = scoreDao.selectOne(new QueryWrapper<Score>()
                .eq("id", scoreId));
        StuInfo stu = stuInfoService.selectById(score.getStuId());
        ItemScoreDto item = ItemScoreDto.builder()
                .stu_name(stu.getStuName())
                .stu_number(stu.getStuNumber()).build();

        switch (teacher.getModuleId()) {
            case 1: {
                item.setScore(new ArrayList<>());
                item.getScore().add(String.valueOf(score.getDeyuGroupAssessScore()));
                item.getScore().add(String.valueOf(score.getDeyuSocialRespScore()));
                item.getScore().add(String.valueOf(score.getDeyuHonorTotalScore()));
                item.setContent(new ArrayList<>());
                item.getContent().add(score.getDeyuGroupAssessContent());
                item.getContent().add(score.getDeyuSocialRespContent());
                item.getContent().add(score.getDeyuHonorTotalContent());
                item.setPicture(new ArrayList<>());
                for (int i = 1; i <= 3; i++) {
                    List<Picture> pictures = pictureDao.selectList(new QueryWrapper<Picture>()
                            .eq("score_id", scoreId)
                            .eq("item_id", i));
                    for (Picture picture : pictures) {
                        item.getPicture().add(PictureDto.builder()
                                .image(picture.getPhoto())
                                .item_id(i).build());
                    }
                }
                break;
            }
            case 3: {
                item.setScore(new ArrayList<>());
                item.getScore().add(String.valueOf(score.getTiyuRacesScore()));
                item.setContent(new ArrayList<>());
                item.getContent().add(score.getTiyuRacesContent());
                item.setPicture(new ArrayList<>());
                List<Picture> pictures = pictureDao.selectList(new QueryWrapper<Picture>()
                        .eq("score_id", scoreId)
                        .eq("item_id", 4));
                for (Picture picture : pictures) {
                    item.getPicture().add(PictureDto.builder()
                            .image(picture.getPhoto())
                            .item_id(4).build());
                }
                break;
            }
            case 4: {
                item.setScore(new ArrayList<>());
                item.getScore().add(String.valueOf(score.getMeiyuPracticeScore()));
                item.getScore().add(String.valueOf(score.getMeiyuCompetitionScore()));
                item.setContent(new ArrayList<>());
                item.getContent().add(score.getMeiyuPracticeContent());
                item.getContent().add(score.getMeiyuCompetitionContent());
                item.setPicture(new ArrayList<>());
                for (int i = 5; i <= 6; i++) {
                    List<Picture> pictures = pictureDao.selectList(new QueryWrapper<Picture>()
                            .eq("score_id", scoreId)
                            .eq("item_id", i));
                    for (Picture picture : pictures) {
                        item.getPicture().add(PictureDto.builder()
                                .image(picture.getPhoto())
                                .item_id(i).build());
                    }
                }
                break;
            }
            case 5: {
                item.setScore(new ArrayList<>());
                item.getScore().add(String.valueOf(score.getLaoyuRoomActivityScore()));
                item.setContent(new ArrayList<>());
                item.getContent().add(score.getLaoyuRoomActivityContent());
                item.setPicture(new ArrayList<>());
                List<Picture> pictures = pictureDao.selectList(new QueryWrapper<Picture>()
                        .eq("score_id", scoreId)
                        .eq("item_id", 7));
                for (Picture picture : pictures) {
                    item.getPicture().add(PictureDto.builder()
                            .image(picture.getPhoto())
                            .item_id(7).build());
                }
                break;
            }
            case 6: {
                item.setScore(new ArrayList<>());
                item.getScore().add(String.valueOf(score.getCxcyCompetitionScore()));
                item.getScore().add(String.valueOf(score.getCxcyLevelGradeScore()));
                item.getScore().add(String.valueOf(score.getCxcySocialActivityScore()));
                item.setContent(new ArrayList<>());
                item.getContent().add(score.getCxcyCompetitionContent());
                item.getContent().add(score.getCxcyLevelGradeContent());
                item.getContent().add(score.getCxcySocialActivityContent());
                item.setPicture(new ArrayList<>());
                for (int i = 8; i <= 10; i++) {
                    List<Picture> pictures = pictureDao.selectList(new QueryWrapper<Picture>()
                            .eq("score_id", scoreId)
                            .eq("item_id", i));
                    for (Picture picture : pictures) {
                        item.getPicture().add(PictureDto.builder()
                                .image(picture.getPhoto())
                                .item_id(i).build());
                    }
                }
                break;
            }
            default: {
            }
        }
        return item;
    }

    @Override
    public void approval(TeacherInfo teacher, int scoreId, int isApproval, String reason) {
        Score score = scoreDao.selectById(scoreId);
        if (score == null || !score.getCollege().equals(teacher.getCollege())) {
            throw new AppException(ErrorCode.PARAM_ERROR);
        }
        UpdateWrapper<Score> wrapper = new UpdateWrapper<>();
        if (isApproval == 0) {
            wrapper.eq("id", scoreId)
                    .set(ModuleConstant.moduleReason[teacher.getModuleId()], reason);
        } else {
            wrapper.eq("id", scoreId)
                    .set(ModuleConstant.moduleApproved[teacher.getModuleId()], true);
            ScoreDone one = scoreDoneDao.selectOne(new QueryWrapper<ScoreDone>()
                    .eq("stu_id", score.getStuId())
                    .eq("year", score.getYear()));
            ScoreDone scoreDone = ScoreDone.builder()
                    .stuId(score.getStuId())
                    .college(score.getCollege())
                    .year(score.getYear()).build();
            if (one != null) {
                dealScoreDone(teacher.getModuleId(), one, score);
                scoreDoneDao.update(one, null);
            } else {
                dealScoreDone(teacher.getModuleId(), scoreDone, score);
                scoreDoneDao.insert(scoreDone);
            }
        }
        scoreDao.update(null, wrapper);
    }

    private void dealScoreDone(int moduleId, ScoreDone scoreDone, Score score) {
        switch (moduleId) {
            case 1: {
                scoreDone.setDeyuGroupAssess(score.getDeyuGroupAssessScore());
                scoreDone.setDeyuSocialRespons(score.getDeyuSocialRespScore());
                scoreDone.setDeyuHonorTotal(score.getDeyuHonorTotalScore());
                break;
            }
            case 3: {
                scoreDone.setTiyuRaces(score.getTiyuRacesScore());
                break;
            }
            case 4: {
                scoreDone.setMeiyuPractice(score.getMeiyuPracticeScore());
                scoreDone.setMeiyuCompetition(score.getMeiyuCompetitionScore());
                break;
            }
            case 5: {
                scoreDone.setLaoyuRoomActivity(score.getLaoyuRoomActivityScore());
                break;
            }
            case 6: {
                scoreDone.setCxcyCompetition(score.getCxcyCompetitionScore());
                scoreDone.setCxcySocialActivity(score.getCxcySocialActivityScore());
                scoreDone.setCxcyLevelGrade(score.getCxcyLevelGradeScore());
                break;
            }
            default: {
            }
        }
    }

}
