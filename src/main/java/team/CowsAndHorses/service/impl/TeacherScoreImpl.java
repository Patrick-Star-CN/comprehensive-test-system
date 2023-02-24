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
import team.CowsAndHorses.dto.ScoreDoneDto;
import team.CowsAndHorses.dto.ScoreFetchDto;
import team.CowsAndHorses.exception.AppException;
import team.CowsAndHorses.service.StuInfoService;
import team.CowsAndHorses.service.TeacherScoreService;

import java.sql.Date;
import java.util.*;
import java.util.function.Consumer;


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
                .eq(ModuleConstant.moduleApproved[teacher.getModuleId()], 0));
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
        if (score == null) {
            throw new AppException(ErrorCode.PARAM_ERROR);
        }
        if (!score.getCollege().equals(teacher.getCollege())) {
            throw new AppException(ErrorCode.FORBIDDEN);
        }
        UpdateWrapper<Score> wrapper = new UpdateWrapper<>();
        if (isApproval == 2) {
            wrapper.eq("id", scoreId)
                    .set(ModuleConstant.moduleReason[teacher.getModuleId()], reason)
                    .set(ModuleConstant.moduleApproved[teacher.getModuleId()], 2);
        } else if (isApproval == 1) {
            wrapper.eq("id", scoreId)
                    .set(ModuleConstant.moduleApproved[teacher.getModuleId()], 1);
            ScoreDone one = scoreDoneDao.selectOne(new QueryWrapper<ScoreDone>()
                    .eq("stu_id", score.getStuId())
                    .eq("year", score.getYear()));
            ScoreDone scoreDone = ScoreDone.builder()
                    .stuId(score.getStuId())
                    .college(score.getCollege())
                    .year(score.getYear())
                    .isApproval(false).build();
            if (one != null) {
                dealScoreDone(teacher.getModuleId(), one, score);
                scoreDoneDao.updateById(one);
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
                scoreDone.setMeiyu(scoreDone.getMeiyuPractice() + scoreDone.getMeiyuCompetition());
                scoreDone.setTotal(scoreDone.getTotal() + 1);
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

    @Override
    public void enter(TeacherInfo teacher, String stuNumber, int year, Map<String, String> map) {
        StuInfo stu = stuInfoService.selectByNumber(stuNumber);
        ScoreDone scoreDone = scoreDoneDao.selectOne(new QueryWrapper<ScoreDone>()
                .eq("stu_id", stu.getId())
                .eq("year", year));
        if (scoreDone == null) {
            throw new AppException(ErrorCode.PARAM_ERROR);
        }
        if (!scoreDone.getCollege().equals(teacher.getCollege())) {
            throw new AppException(ErrorCode.FORBIDDEN);
        }
        switch (teacher.getModuleId()) {
            case 1: {
                double score1 = Double.parseDouble(map.get("deyu_basic_assess"));
                double score2 = Double.parseDouble(map.get("deyu_political_learn"));
                double score3 = Double.parseDouble(map.get("deyu_minus_total"));
                if (score1 > 6.0 || score2 > 1.0) {
                    throw new AppException(ErrorCode.PARAM_ERROR);
                }
                scoreDone.setDeyuBasicAssess(score1);
                scoreDone.setDeyuPoliticalLearn(score2);
                scoreDone.setDeyuMinusTotal(score3);
                scoreDone.setDeyuOtherTotal(Math.min(scoreDone.getDeyuGroupAssess()
                        + scoreDone.getDeyuSocialRespons() + scoreDone.getDeyuPoliticalLearn()
                        + scoreDone.getDeyuMinusTotal() + scoreDone.getDeyuHonorTotal(), 4.0));
                scoreDone.setDeyu(scoreDone.getDeyuBasicAssess() + scoreDone.getDeyuOtherTotal());
                scoreDone.setTotal(scoreDone.getTotal() + 1);
                break;
            }
            case 2: {
                DealWithZhiyu(map, scoreDone);
            }
            case 3: {
                double score1 = Double.parseDouble(map.get("tiyu_score1"));
                double score2 = Double.parseDouble(map.get("tiyu_score2"));
                double score3 = Double.parseDouble(map.get("tiyu_early_exercise1"));
                double score4 = Double.parseDouble(map.get("tiyu_early_exercise2"));
                if (score1 > 2.5 || score2 > 2.5 || score3 > 0.5 || score4 > 0.5) {
                    throw new AppException(ErrorCode.PARAM_ERROR);
                }
                scoreDone.setTiyuScore1(score1);
                scoreDone.setTiyuScore2(score2);
                scoreDone.setTiyuScoreTotal(scoreDone.getTiyuScore1() + scoreDone.getTiyuScore2());
                scoreDone.setTiyuEarlyExercise1(score3);
                scoreDone.setTiyuEarlyExercise2(score4);
                scoreDone.setTiyuOtherTotal(scoreDone.getTiyuEarlyExercise1()
                        + scoreDone.getTiyuEarlyExercise2() + scoreDone.getTiyuRaces());
                scoreDone.setTiyu(scoreDone.getTiyuScoreTotal() + scoreDone.getTiyuOtherTotal());
                scoreDone.setTotal(scoreDone.getTotal() + 1);
                break;
            }
            case 5: {
                double score1 = Double.parseDouble(map.get("laoyu_room_daily"));
                double score2 = Double.parseDouble(map.get("laoyu_room_perform"));
                double score3 = Double.parseDouble(map.get("laoyu_volunteer"));
                double score4 = Double.parseDouble(map.get("laoyu_internship"));
                if (score1 > 2.0 || score3 > 4.0) {
                    throw new AppException(ErrorCode.PARAM_ERROR);
                }
                scoreDone.setLaoyuRoomDaily(score1);
                scoreDone.setLaoyuRoomPerform(score2);
                scoreDone.setLaoyuDailyTotal(scoreDone.getLaoyuRoomDaily()
                        + scoreDone.getLaoyuRoomActivity() + scoreDone.getLaoyuRoomPerform());
                scoreDone.setLaoyuVolunteer(score3);
                scoreDone.setLaoyuInternship(score4);
                scoreDone.setLaoyu(Math.min(scoreDone.getLaoyuDailyTotal()
                        + scoreDone.getLaoyuVolunteer() + scoreDone.getLaoyuInternship(), 5.0));
                scoreDone.setTotal(scoreDone.getTotal() + 1);
                break;
            }
            case 6: {
                double score = Double.parseDouble(map.get("cxcy_social_work"));
                scoreDone.setCxcySocialWork(score);
                scoreDone.setCxcyScoreTotal(scoreDone.getCxcyCompetition()
                        + scoreDone.getCxcyLevelGrade());
                scoreDone.setCxcy(Math.min(scoreDone.getCxcyScoreTotal()
                        + scoreDone.getCxcySocialActivity() + scoreDone.getCxcySocialWork(), 12.0));
                scoreDone.setTotal(scoreDone.getTotal() + 1);
                break;
            }
            default: {
            }
        }
        dealWithTotal(scoreDone);
    }

    private void scoreDoneConsumer(ScoreDone scoreDone1) {
        if (scoreDone1.getIsApproval()) {
            scoreDone1.setTotal(5.0);
            scoreDone1.setIsApproval(false);
        } else {
            scoreDone1.setTotal(scoreDone1.getTotal() - 1);
        }
        scoreDoneDao.updateById(scoreDone1);
    }

    ;

    @Override
    public void withdraw(TeacherInfo teacher, String stuNumber, int year) {
        StuInfo stu = stuInfoService.selectByNumber(stuNumber);
        ScoreDone scoreDone = scoreDoneDao.selectOne(new QueryWrapper<ScoreDone>()
                .eq("stu_id", stu.getId())
                .eq("year", year));
        if (scoreDone != null) {
            scoreDoneConsumer(scoreDone);
        }
        Score score = scoreDao.selectOne(new QueryWrapper<Score>()
                .eq("stu_id", stu.getId())
                .eq("year", year));
        switch (teacher.getModuleId()) {
            case 1: {
                score.setIsApprovedDeyu(0);
                break;
            }
            case 2: {
                score.setIsApprovedZhiyu(0);
                break;
            }
            case 3: {
                score.setIsApprovedTiyu(0);
                break;
            }
            case 4: {
                score.setIsApprovedMeiyu(0);
                break;
            }
            case 5: {
                score.setIsApprovedLaoyu(0);
                break;
            }
            case 6: {
                score.setIsApprovedCxcy(0);
                break;
            }
            default: {
            }
        }
        scoreDao.updateById(score);
    }

    @Override
    public Map<String, String> queryDoneDetail(TeacherInfo teacher, int scoreDoneId) {
        ScoreDone scoreDone = scoreDoneDao.selectOne(new QueryWrapper<ScoreDone>()
                .eq("id", scoreDoneId));
        Map<String, String> map = new HashMap<>();
        switch (teacher.getModuleId()) {
            case 1: {
                map.put("deyu_basic_assess", String.valueOf(scoreDone.getDeyuBasicAssess()));
                map.put("deyu_group_assess", String.valueOf(scoreDone.getDeyuGroupAssess()));
                map.put("deyu_social_respons", String.valueOf(scoreDone.getDeyuSocialRespons()));
                map.put("deyu_political_learn", String.valueOf(scoreDone.getDeyuPoliticalLearn()));
                map.put("deyu_minus_total", String.valueOf(scoreDone.getDeyuMinusTotal()));
                map.put("deyu_honor_total", String.valueOf(scoreDone.getDeyuHonorTotal()));
                break;
            }
            case 2: {
                map.put("zhiyu_gpa", String.valueOf(scoreDone.getZhiyuGpa()));
                break;
            }
            case 3: {
                map.put("tiyu_score1", String.valueOf(scoreDone.getTiyuScore1()));
                map.put("tiyu_score2", String.valueOf(scoreDone.getTiyuScore2()));
                map.put("tiyu_races", String.valueOf(scoreDone.getTiyuRaces()));
                map.put("tiyu_early_exercise1", String.valueOf(scoreDone.getTiyuEarlyExercise1()));
                map.put("tiyu_early_exercise2", String.valueOf(scoreDone.getTiyuEarlyExercise2()));
                break;
            }
            case 4: {
                map.put("meiyu_practice", String.valueOf(scoreDone.getMeiyuPractice()));
                map.put("meiyu_competition", String.valueOf(scoreDone.getMeiyuCompetition()));
                break;
            }
            case 5: {
                map.put("laoyu_room_daily", String.valueOf(scoreDone.getLaoyuRoomDaily()));
                map.put("laoyu_room_activity", String.valueOf(scoreDone.getLaoyuRoomActivity()));
                map.put("laoyu_room_perform", String.valueOf(scoreDone.getLaoyuRoomPerform()));
                map.put("laoyu_volunteer", String.valueOf(scoreDone.getLaoyuVolunteer()));
                map.put("laoyu_internship", String.valueOf(scoreDone.getLaoyuInternship()));
                break;
            }
            case 6: {
                map.put("cxcy_competition", String.valueOf(scoreDone.getCxcyCompetition()));
                map.put("cxcy_level_grade", String.valueOf(scoreDone.getCxcyLevelGrade()));
                map.put("cxcy_social_activity", String.valueOf(scoreDone.getCxcySocialActivity()));
                map.put("cxcy_social_work", String.valueOf(scoreDone.getCxcySocialWork()));
                break;
            }
            default: {
            }
        }
        return map;
    }

    @Override
    public List<ScoreDoneDto> queryDone(TeacherInfo teacher, int year) {
        List<ScoreDone> scoreDones = scoreDoneDao.selectList(new QueryWrapper<ScoreDone>()
                .eq("college", teacher.getCollege())
                .eq("year", year));
        List<ScoreDoneDto> list = new ArrayList<>();
        for (ScoreDone scoreDone : scoreDones) {
            StuInfo stu = stuInfoService.selectById(scoreDone.getStuId());
            list.add(ScoreDoneDto.builder()
                    .score_done_id(scoreDone.getId())
                    .stu_name(stu.getStuName())
                    .stu_number(stu.getStuNumber())
                    .is_approval(1).build());
        }
        List<Score> scores = scoreDao.selectList(new QueryWrapper<Score>()
                .eq("college", teacher.getCollege())
                .eq("year", year)
                .eq(ModuleConstant.moduleApproved[teacher.getModuleId()], 2));
        for (Score score : scores) {
            StuInfo stu = stuInfoService.selectById(score.getStuId());
            list.add(ScoreDoneDto.builder()
                    .stu_name(stu.getStuName())
                    .stu_number(stu.getStuNumber())
                    .is_approval(0).build());
        }
        return list;
    }

    @Override
    public void change(TeacherInfo teacher, int scoreDoneId, Map<String, String> map) {
        ScoreDone scoreDone = scoreDoneDao.selectOne(new QueryWrapper<ScoreDone>()
                .eq("id", scoreDoneId));
        if (scoreDone == null) {
            throw new AppException(ErrorCode.PARAM_ERROR);
        }
        if (!scoreDone.getCollege().equals(teacher.getCollege())) {
            throw new AppException(ErrorCode.FORBIDDEN);
        }
        scoreDoneConsumer(scoreDone);
        switch (teacher.getModuleId()) {
            case 1: {
                double score1 = Double.parseDouble(map.get("deyu_basic_assess"));
                double score2 = Double.parseDouble(map.get("deyu_group_assess"));
                double score3 = Double.parseDouble(map.get("deyu_social_respons"));
                double score4 = Double.parseDouble(map.get("deyu_political_learn"));
                double score5 = Double.parseDouble(map.get("deyu_minus_total"));
                double score6 = Double.parseDouble(map.get("deyu_honor_total"));
                if (score1 > 6.0 || score2 > 1.0 || score3 > 2.0 || score4 > 1.0) {
                    throw new AppException(ErrorCode.PARAM_ERROR);
                }
                scoreDone.setDeyuBasicAssess(score1);
                scoreDone.setDeyuGroupAssess(score2);
                scoreDone.setDeyuSocialRespons(score3);
                scoreDone.setDeyuPoliticalLearn(score4);
                scoreDone.setDeyuMinusTotal(score5);
                scoreDone.setDeyuHonorTotal(score6);
                scoreDone.setDeyuOtherTotal(Math.min(scoreDone.getDeyuGroupAssess()
                        + scoreDone.getDeyuSocialRespons() + scoreDone.getDeyuPoliticalLearn()
                        + scoreDone.getDeyuMinusTotal() + scoreDone.getDeyuHonorTotal(), 4.0));
                scoreDone.setDeyu(scoreDone.getDeyuBasicAssess() + scoreDone.getDeyuOtherTotal());
                scoreDone.setTotal(scoreDone.getTotal() + 1);
                break;
            }
            case 2: {
                DealWithZhiyu(map, scoreDone);
                break;
            }
            case 3: {
                double score1 = Double.parseDouble(map.get("tiyu_score1"));
                double score2 = Double.parseDouble(map.get("tiyu_score2"));
                double score3 = Double.parseDouble(map.get("tiyu_races"));
                double score4 = Double.parseDouble(map.get("tiyu_early_exercise1"));
                double score5 = Double.parseDouble(map.get("tiyu_early_exercise2"));
                if (score1 > 2.5 || score2 > 2.5 || score3 > 2 || score4 > 0.5 || score5 > 0.5) {
                    throw new AppException(ErrorCode.PARAM_ERROR);
                }
                scoreDone.setTiyuScore1(score1);
                scoreDone.setTiyuScore2(score2);
                scoreDone.setTiyuScoreTotal(scoreDone.getTiyuScore1() + scoreDone.getTiyuScore2());
                scoreDone.setTiyuRaces(score3);
                scoreDone.setTiyuEarlyExercise1(score4);
                scoreDone.setTiyuEarlyExercise2(score5);
                scoreDone.setTiyuOtherTotal(scoreDone.getTiyuEarlyExercise1()
                        + scoreDone.getTiyuEarlyExercise2() + scoreDone.getTiyuRaces());
                scoreDone.setTiyu(scoreDone.getTiyuScoreTotal() + scoreDone.getTiyuOtherTotal());
                scoreDone.setTotal(scoreDone.getTotal() + 1);
                break;
            }
            case 4: {
                double score1 = Double.parseDouble(map.get("meiyu_practice"));
                double score2 = Double.parseDouble(map.get("meiyu_competition"));
                if (score1 > 0.5 || score2 > 4.5) {
                    throw new AppException(ErrorCode.PARAM_ERROR);
                }
                scoreDone.setMeiyuPractice(score1);
                scoreDone.setMeiyuCompetition(score2);
                scoreDone.setMeiyu(scoreDone.getMeiyuPractice() + scoreDone.getMeiyuCompetition());
                scoreDone.setTotal(scoreDone.getTotal() + 1);
                break;
            }
            case 5: {
                double score1 = Double.parseDouble(map.get("laoyu_room_daily"));
                double score2 = Double.parseDouble(map.get("laoyu_room_activity"));
                double score3 = Double.parseDouble(map.get("laoyu_room_perform"));
                double score4 = Double.parseDouble(map.get("laoyu_volunteer"));
                double score5 = Double.parseDouble(map.get("laoyu_internship"));
                if (score1 > 2.0 || score3 > 4.0) {
                    throw new AppException(ErrorCode.PARAM_ERROR);
                }
                scoreDone.setLaoyuRoomDaily(score1);
                scoreDone.setLaoyuRoomActivity(score2);
                scoreDone.setLaoyuRoomPerform(score3);
                scoreDone.setLaoyuDailyTotal(scoreDone.getLaoyuRoomDaily()
                        + scoreDone.getLaoyuRoomActivity() + scoreDone.getLaoyuRoomPerform());
                scoreDone.setLaoyuVolunteer(score4);
                scoreDone.setLaoyuInternship(score5);
                scoreDone.setLaoyu(Math.min(scoreDone.getLaoyuDailyTotal()
                        + scoreDone.getLaoyuVolunteer() + scoreDone.getLaoyuInternship(), 5.0));
                scoreDone.setTotal(scoreDone.getTotal() + 1);
                break;
            }
            case 6: {
                double score1 = Double.parseDouble(map.get("cxcy_competition"));
                double score2 = Double.parseDouble(map.get("cxcy_level_grade"));
                double score3 = Double.parseDouble(map.get("cxcy_social_activity"));
                double score4 = Double.parseDouble(map.get("cxcy_social_work"));
                scoreDone.setCxcyCompetition(score1);
                scoreDone.setCxcyLevelGrade(score2);
                scoreDone.setCxcySocialActivity(score3);
                scoreDone.setCxcySocialWork(score4);
                scoreDone.setCxcyScoreTotal(scoreDone.getCxcyCompetition()
                        + scoreDone.getCxcyLevelGrade());
                scoreDone.setCxcy(Math.min(scoreDone.getCxcyScoreTotal()
                        + scoreDone.getCxcySocialActivity() + scoreDone.getCxcySocialWork(), 12.0));
                scoreDone.setTotal(scoreDone.getTotal() + 1);
                break;
            }
            default: {
            }
        }
        dealWithTotal(scoreDone);
    }

    public void dealWithTotal(ScoreDone scoreDone) {
        if (scoreDone.getTotal() == 6.0) {
            scoreDone.setTotal(scoreDone.getDeyu()
                    + scoreDone.getZhiyu() + scoreDone.getTiyu()
                    + scoreDone.getMeiyu() + scoreDone.getLaoyu()
                    + scoreDone.getCxcy());
            scoreDone.setIsApproval(true);
            scoreDone.setUpdateTime(new Date(Calendar.getInstance().getTime().getTime()));
        }
        scoreDoneDao.updateById(scoreDone);
    }

    public void DealWithZhiyu(Map<String, String> map, ScoreDone scoreDone) {
        double score = Double.parseDouble(map.get("zhiyu_gpa"));
        if (score > 60.0) {
            throw new AppException(ErrorCode.PARAM_ERROR);
        }
        scoreDone.setZhiyuGpa(score);
        scoreDone.setZhiyu(scoreDone.getZhiyuGpa());
        scoreDone.setTotal(scoreDone.getTotal() + 1);
    }
}
