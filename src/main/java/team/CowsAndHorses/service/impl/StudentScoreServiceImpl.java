package team.CowsAndHorses.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import team.CowsAndHorses.constant.ErrorCode;
import team.CowsAndHorses.dao.PictureDao;
import team.CowsAndHorses.dao.ScoreDao;
import team.CowsAndHorses.domain.Picture;
import team.CowsAndHorses.domain.Score;
import team.CowsAndHorses.domain.StuInfo;
import team.CowsAndHorses.dto.Item;
import team.CowsAndHorses.dto.ScoreDto;
import team.CowsAndHorses.exception.AppException;
import team.CowsAndHorses.service.StudentScoreService;
import team.CowsAndHorses.service.TimeService;

import java.sql.Date;
import java.util.*;

@RequiredArgsConstructor
@CacheConfig(cacheNames = "ExpireOneMin")
@Service
public class StudentScoreServiceImpl implements StudentScoreService {

    final ScoreDao scoreDao;
    final TimeService timeService;
    final PictureDao pictureDao;


    @Override
    public Score queryScore(String stuNumber, Integer year) {
        return scoreDao.selectOne(new QueryWrapper<Score>()
                .eq("stu_number", stuNumber)
                .eq("year", year));
    }

    @Override
    public void subScore(ScoreDto sco, StuInfo stu) {
        try {
            if (Double.parseDouble(sco.getDeyu_group_assess().getScore()) > 1.0
                    || Double.parseDouble(sco.getDeyu_social_resp().getScore()) > 2.0
                    || Double.parseDouble(sco.getTiyu_races().getScore()) > 2.0
                    || Double.parseDouble(sco.getMeiyu_practice().getScore()) > 0.5
                    || Double.parseDouble(sco.getCxcy_competition().getScore()) > 4.5) {
                throw new AppException(ErrorCode.PARAM_ERROR);
            }
        } catch (NumberFormatException e) {
            throw new AppException(ErrorCode.PARAM_ERROR);
        }
        int year = Integer.parseInt(sco.getYear());
        Date now = new Date(Calendar.getInstance().getTime().getTime());
        Score one = scoreDao.selectOne(new QueryWrapper<Score>()
                .eq("year", sco.getYear())
                .eq("stu_id", stu.getId()));
        Score score = Score.builder()
                .stuId(stu.getId())
                .year(year)
                .college(stu.getStuCollege()).build();
        if (timeService.query(1, stu.getStuCollege(), year) == null || timeService.query(1, stu.getStuCollege(), year).getDdl().after(now)) {
            score.setDeyuGroupAssessScore(Double.parseDouble(sco.getDeyu_group_assess().getScore()));
            score.setDeyuGroupAssessContent(sco.getDeyu_group_assess().getContent());
            score.setDeyuSocialRespScore(Double.parseDouble(sco.getDeyu_social_resp().getScore()));
            score.setDeyuSocialRespContent(sco.getDeyu_social_resp().getContent());
            score.setDeyuHonorTotalScore(Double.parseDouble(sco.getDeyu_honor_total().getScore()));
            score.setDeyuHonorTotalContent(sco.getDeyu_honor_total().getContent());
            score.setIsApprovedDeyu(0);
        } else if (one != null) {
            score.setDeyuGroupAssessScore(one.getDeyuGroupAssessScore());
            score.setDeyuGroupAssessContent(one.getDeyuGroupAssessContent());
            score.setDeyuSocialRespScore(one.getDeyuSocialRespScore());
            score.setDeyuSocialRespContent(one.getDeyuSocialRespContent());
            score.setDeyuHonorTotalScore(one.getDeyuHonorTotalScore());
            score.setDeyuHonorTotalContent(one.getDeyuHonorTotalContent());
            score.setIsApprovedDeyu(one.getIsApprovedDeyu());
            score.setDeyuReason(one.getDeyuReason());
        }
        if (timeService.query(2, stu.getStuCollege(), year) == null || timeService.query(2, stu.getStuCollege(), year).getDdl().after(now)) {
            score.setIsApprovedZhiyu(0);
        } else if (one != null) {
            score.setIsApprovedZhiyu(one.getIsApprovedZhiyu());
        }
        if (timeService.query(3, stu.getStuCollege(), year) == null || timeService.query(3, stu.getStuCollege(), year).getDdl().after(now)) {
            score.setTiyuRacesScore(Double.parseDouble(sco.getTiyu_races().getScore()));
            score.setTiyuRacesContent(sco.getTiyu_races().getContent());
            score.setIsApprovedTiyu(0);
        } else if (one != null) {
            score.setTiyuRacesScore(one.getTiyuRacesScore());
            score.setTiyuRacesContent(one.getTiyuRacesContent());
            score.setIsApprovedTiyu(one.getIsApprovedTiyu());
            score.setTiyuReason(one.getTiyuReason());
        }
        if (timeService.query(4, stu.getStuCollege(), year) == null || timeService.query(4, stu.getStuCollege(), year).getDdl().after(now)) {
            score.setMeiyuPracticeScore(Double.parseDouble(sco.getMeiyu_practice().getScore()));
            score.setMeiyuPracticeContent(sco.getMeiyu_practice().getContent());
            score.setMeiyuCompetitionScore(Double.parseDouble(sco.getMeiyu_competition().getScore()));
            score.setMeiyuCompetitionContent(sco.getMeiyu_competition().getContent());
            score.setIsApprovedMeiyu(0);
        } else if (one != null) {
            score.setMeiyuPracticeScore(one.getMeiyuPracticeScore());
            score.setMeiyuPracticeContent(one.getMeiyuPracticeContent());
            score.setMeiyuCompetitionScore(one.getMeiyuCompetitionScore());
            score.setMeiyuCompetitionContent(one.getMeiyuCompetitionContent());
            score.setIsApprovedMeiyu(one.getIsApprovedMeiyu());
            score.setMeiyuReason(one.getMeiyuReason());
        }
        if (timeService.query(5, stu.getStuCollege(), year) == null || timeService.query(5, stu.getStuCollege(), year).getDdl().after(now)) {
            score.setLaoyuRoomActivityScore(Double.parseDouble(sco.getLaoyu_room_activity().getScore()));
            score.setLaoyuRoomActivityContent(sco.getLaoyu_room_activity().getContent());
            score.setIsApprovedLaoyu(0);
        } else if (one != null) {
            score.setLaoyuRoomActivityScore(one.getLaoyuRoomActivityScore());
            score.setLaoyuRoomActivityContent(one.getLaoyuRoomActivityContent());
            score.setIsApprovedLaoyu(one.getIsApprovedLaoyu());
            score.setLaoyuReason(one.getLaoyuReason());
        }
        if (timeService.query(6, stu.getStuCollege(), year) == null || timeService.query(6, stu.getStuCollege(), year).getDdl().after(now)) {
            score.setCxcyCompetitionScore(Double.parseDouble(sco.getCxcy_competition().getScore()));
            score.setCxcyCompetitionContent(sco.getCxcy_competition().getContent());
            score.setCxcyLevelGradeScore(Double.parseDouble(sco.getCxcy_level_grade().getScore()));
            score.setCxcyLevelGradeContent(sco.getCxcy_level_grade().getContent());
            score.setCxcySocialActivityScore(Double.parseDouble(sco.getCxcy_social_activity().getScore()));
            score.setCxcySocialActivityContent(sco.getCxcy_social_activity().getContent());
            score.setIsApprovedCxcy(0);
        } else if (one != null) {
            score.setCxcyCompetitionScore(one.getCxcyCompetitionScore());
            score.setCxcyCompetitionContent(one.getCxcyCompetitionContent());
            score.setCxcyLevelGradeScore(one.getCxcyLevelGradeScore());
            score.setCxcyLevelGradeContent(one.getCxcyLevelGradeContent());
            score.setCxcySocialActivityScore(one.getCxcySocialActivityScore());
            score.setCxcySocialActivityContent(one.getCxcySocialActivityContent());
            score.setIsApprovedCxcy(one.getIsApprovedCxcy());
            score.setCxcyReason(one.getCxcyReason());
        }
        score.setIsApproved(false);
        if (one != null) {
            score.setId(one.getId());
            scoreDao.update(score, new QueryWrapper<Score>().eq("id", one.getId()));
        } else {
            scoreDao.insert(score);
        }

        int scoreId = scoreDao.selectOne(new QueryWrapper<Score>()
                .eq("year", sco.getYear())
                .eq("stu_id", stu.getId())).getId();
        if (timeService.query(1, stu.getStuCollege(), year) == null || timeService.query(1, stu.getStuCollege(), year).getDdl().after(now)) {
            for (int i = 1; i <= 3; i++) {
                pictureDao.delete(new QueryWrapper<Picture>()
                        .eq("score_id", scoreId)
                        .eq("item_id", i));
            }
            subPicture(sco.getDeyu_group_assess(), scoreId, 1);
            subPicture(sco.getDeyu_social_resp(), scoreId, 2);
            subPicture(sco.getDeyu_honor_total(), scoreId, 3);
        }
        if (timeService.query(3, stu.getStuCollege(), year) == null || timeService.query(1, stu.getStuCollege(), year).getDdl().after(now)) {
            pictureDao.delete(new QueryWrapper<Picture>()
                    .eq("score_id", scoreId)
                    .eq("item_id", 4));
            subPicture(sco.getTiyu_races(), scoreId, 4);
        }
        if (timeService.query(4, stu.getStuCollege(), year) == null || timeService.query(1, stu.getStuCollege(), year).getDdl().after(now)) {
            for (int i = 5; i <= 6; i++) {
                pictureDao.delete(new QueryWrapper<Picture>()
                        .eq("score_id", scoreId)
                        .eq("item_id", i));
            }
            subPicture(sco.getMeiyu_practice(), scoreId, 5);
            subPicture(sco.getMeiyu_competition(), scoreId, 6);
        }
        if (timeService.query(5, stu.getStuCollege(), year) == null || timeService.query(1, stu.getStuCollege(), year).getDdl().after(now)) {
            pictureDao.delete(new QueryWrapper<Picture>()
                    .eq("score_id", scoreId)
                    .eq("item_id", 7));
            subPicture(sco.getLaoyu_room_activity(), scoreId, 7);
        }
        if (timeService.query(6, stu.getStuCollege(), year) == null || timeService.query(1, stu.getStuCollege(), year).getDdl().after(now)) {
            for (int i = 7; i <= 10; i++) {
                pictureDao.delete(new QueryWrapper<Picture>()
                        .eq("score_id", scoreId)
                        .eq("item_id", i));
            }
            subPicture(sco.getCxcy_competition(), scoreId, 8);
            subPicture(sco.getCxcy_level_grade(), scoreId, 9);
            subPicture(sco.getCxcy_social_activity(), scoreId, 10);
        }
    }

    @Override
    public void subPicture(Item item, int scoreId, int itemId) {
        for (String image : item.getImage()) {
            Picture picture = Picture.builder()
                    .itemId(itemId)
                    .scoreId(scoreId)
                    .photo(image).build();
            pictureDao.insert(picture);
        }
    }

    @Override
    public Map<String, Integer> checkApproval(Integer stuId, Integer year) {
        Map<String, Integer> map = new LinkedHashMap<>();
        Score score = scoreDao.selectOne(new QueryWrapper<Score>()
                .eq("stu_id", stuId)
                .eq("year", year));
        if (score == null) {
            return null;
        }
        map.put("is_approved_deyu", score.getIsApprovedDeyu());
        map.put("is_approved_meiyu", score.getIsApprovedMeiyu());
        map.put("is_approved_tiyu", score.getIsApprovedTiyu());
        map.put("is_approved_laoyu", score.getIsApprovedLaoyu());
        map.put("is_approved_cxcy", score.getIsApprovedCxcy());
        return map;
    }

    @Override
    public Map<String, String> getReason(Integer stuId, Integer year) {
        Map<String, String> map = new LinkedHashMap<>();
        Score score = scoreDao.selectOne(new QueryWrapper<Score>()
                .eq("stu_id", stuId)
                .eq("year", year));
        if (score == null) {
            return null;
        }
        map.put("reason_deyu", score.getDeyuReason());
        map.put("reason_meiyu", score.getMeiyuReason());
        map.put("reason_tiyu", score.getTiyuReason());
        map.put("reason_laoyu", score.getLaoyuReason());
        map.put("reason_cxcy", score.getCxcyReason());
        return map;
    }
}
