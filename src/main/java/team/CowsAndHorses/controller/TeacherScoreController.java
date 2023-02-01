package  team.CowsAndHorses.controller;


import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import team.CowsAndHorses.domain.ScoreDoneEntity;
import team.CowsAndHorses.domain.ScoreEntity;
import team.CowsAndHorses.domain.StuInfoEntity;
import team.CowsAndHorses.domain.Teacher;
import team.CowsAndHorses.service.StuInfoService;
import team.CowsAndHorses.service.TeacherScoreService;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/teacher")
@SessionAttributes(names = "teacher",types = Teacher.class)
public class TeacherScoreController {
    final TeacherScoreService teacherScoreService;
    final StuInfoService stuService;

    @RequestMapping("/get/declaration")
    @ResponseBody
    public Result getDeyu(int year, HttpSession session){
        String msg;
        Teacher t= (Teacher) session.getAttribute("teacher");
        int moduleId=t.getModuleId() ;
        if(moduleId==1){
            List<ScoreEntity> data= teacherScoreService.getDeyu(year);
            if(data!=null) {
                msg="获取申报表成功！";
                return new Result(Code.GET_DECLARATION_OK,data,msg);
            }
        }
        return new Result(Code.GET_DECLARATION_ERR,null,"failed!");
    }


    @RequestMapping("/get/unapproved/list")
    @ResponseBody
    public Result getUnenteredStu(@RequestBody Map<String,Object> map, HttpSession session){
        Teacher t= (Teacher) session.getAttribute("teacher");
        int year= (int) map.get("year");
        int stuYear=(int)map.get("stu_year");
        int moduleId=t.getModuleId();
        String msg; List<StuInfoEntity> data;
        if(moduleId==1) {
            if (year - stuYear == 0) {
                data = teacherScoreService.getUnenteredStu11(stuYear);
                if (data != null) {
                    msg = "获取未审批名单成功！";
                    return new Result(Code.GET_UNENTEREDSTU_OK, data, msg);
                }
            }
            if (year - stuYear == 1) {
                data = teacherScoreService.getUnenteredStu21(stuYear);
                if (data != null) {
                    msg = "获取未审批名单成功！";
                    return new Result(Code.GET_UNENTEREDSTU_OK, data, msg);
                }
            }
            if (year - stuYear == 2) {
                data = teacherScoreService.getUnenteredStu31(stuYear);
                if (data != null) {
                    msg = "获取未审批名单成功！";
                    return new Result(Code.GET_UNENTEREDSTU_OK, data, msg);
                }
            } if (year - stuYear == 3) {
                data = teacherScoreService.getUnenteredStu41(stuYear);
                if (data != null) {
                    msg = "获取未审批名单成功！";
                    return new Result(Code.GET_UNENTEREDSTU_OK, data, msg);
                }
            }
        }
            if(moduleId==2) {
                if (year - stuYear == 0) {
                    data = teacherScoreService.getUnenteredStu12(stuYear);
                    if (data != null) {
                        msg = "获取未审批名单成功！";
                        return new Result(Code.GET_UNENTEREDSTU_OK, data, msg);
                    }
                }
                if (year - stuYear == 1) {
                    data = teacherScoreService.getUnenteredStu22(stuYear);
                    if (data != null) {
                        msg = "获取未审批名单成功！";
                        return new Result(Code.GET_UNENTEREDSTU_OK, data, msg);
                    }
                }
                if (year - stuYear == 2) {
                    data = teacherScoreService.getUnenteredStu32(stuYear);
                    if (data != null) {
                        msg = "获取未审批名单成功！";
                        return new Result(Code.GET_UNENTEREDSTU_OK, data, msg);
                    }
                }
                if (year - stuYear == 3) {
                    data = teacherScoreService.getUnenteredStu42(stuYear);
                    if (data != null) {
                        msg = "获取未审批名单成功！";
                        return new Result(Code.GET_UNENTEREDSTU_OK, data, msg);
                    }
                }
            }
                if(moduleId==3) {
                    if (year - stuYear == 0) {
                        data = teacherScoreService.getUnenteredStu13(stuYear);
                        if (data != null) {
                            msg = "获取未审批名单成功！";
                            return new Result(Code.GET_UNENTEREDSTU_OK, data, msg);
                        }
                    }
                    if (year - stuYear == 1) {
                        data = teacherScoreService.getUnenteredStu23(stuYear);
                        if (data != null) {
                            msg = "获取未审批名单成功！";
                            return new Result(Code.GET_UNENTEREDSTU_OK, data, msg);
                        }
                    }
                    if (year - stuYear == 2) {
                        data = teacherScoreService.getUnenteredStu33(stuYear);
                        if (data != null) {
                            msg = "获取未审批名单成功！";
                            return new Result(Code.GET_UNENTEREDSTU_OK, data, msg);
                        }
                    }
                    if (year - stuYear == 3) {
                        data = teacherScoreService.getUnenteredStu43(stuYear);
                        if (data != null) {
                            msg = "获取未审批名单成功！";
                            return new Result(Code.GET_UNENTEREDSTU_OK, data, msg);
                        }
                    }
                }

                    if(moduleId==4) {
                        if (year - stuYear == 0) {
                            data = teacherScoreService.getUnenteredStu14(stuYear);
                            if (data != null) {
                                msg = "获取未审批名单成功！";
                                return new Result(Code.GET_UNENTEREDSTU_OK, data, msg);
                            }
                        }
                        if (year - stuYear == 1) {
                            data = teacherScoreService.getUnenteredStu24(stuYear);
                            if (data != null) {
                                msg = "获取未审批名单成功！";
                                return new Result(Code.GET_UNENTEREDSTU_OK, data, msg);
                            }
                        }
                        if (year - stuYear == 2) {
                            data = teacherScoreService.getUnenteredStu34(stuYear);
                            if (data != null) {
                                msg = "获取未审批名单成功！";
                                return new Result(Code.GET_UNENTEREDSTU_OK, data, msg);
                            }
                        }
                        if (year - stuYear == 3) {
                            data = teacherScoreService.getUnenteredStu44(stuYear);
                            if (data != null) {
                                msg = "获取未审批名单成功！";
                                return new Result(Code.GET_UNENTEREDSTU_OK, data, msg);
                            }
                        }
                    }

                        if(moduleId==5) {
                            if (year - stuYear == 0) {
                                data = teacherScoreService.getUnenteredStu15(stuYear);
                                if (data != null) {
                                    msg = "获取未审批名单成功！";
                                    return new Result(Code.GET_UNENTEREDSTU_OK, data, msg);
                                }
                            }
                            if (year - stuYear == 1) {
                                data = teacherScoreService.getUnenteredStu25(stuYear);
                                if (data != null) {
                                    msg = "获取未审批名单成功！";
                                    return new Result(Code.GET_UNENTEREDSTU_OK, data, msg);
                                }
                            }
                            if (year - stuYear == 2) {
                                data = teacherScoreService.getUnenteredStu35(stuYear);
                                if (data != null) {
                                    msg = "获取未审批名单成功！";
                                    return new Result(Code.GET_UNENTEREDSTU_OK, data, msg);
                                }
                            }
                            if (year - stuYear == 3) {
                                data = teacherScoreService.getUnenteredStu45(stuYear);
                                if (data != null) {
                                    msg = "获取未审批名单成功！";
                                    return new Result(Code.GET_UNENTEREDSTU_OK, data, msg);
                                }
                            }
                        }
                            if(moduleId==6) {
                                if (year - stuYear == 0) {
                                    data = teacherScoreService.getUnenteredStu16(stuYear);
                                    if (data != null) {
                                        msg = "获取未审批名单成功！";
                                        return new Result(Code.GET_UNENTEREDSTU_OK, data, msg);
                                    }
                                }
                                if (year - stuYear == 1) {
                                    data = teacherScoreService.getUnenteredStu26(stuYear);
                                    if (data != null) {
                                        msg = "获取未审批名单成功！";
                                        return new Result(Code.GET_UNENTEREDSTU_OK, data, msg);
                                    }
                                }
                                if (year - stuYear == 2) {
                                    data = teacherScoreService.getUnenteredStu36(stuYear);
                                    if (data != null) {
                                        msg = "获取未审批名单成功！";
                                        return new Result(Code.GET_UNENTEREDSTU_OK, data, msg);
                                    }
                                }
                                if (year - stuYear == 3) {
                                    data = teacherScoreService.getUnenteredStu46(stuYear);
                                    if (data != null) {
                                        msg = "获取未审批名单成功！";
                                        return new Result(Code.GET_UNENTEREDSTU_OK, data, msg);
                                    }
                                }
                            }

      return new Result( Code.GET_UNENTEREDSTU_ERR,null,"获取未审批名单失败！");
    }


    @RequestMapping(value ="get/item")
    @ResponseBody
    public Result getItems( HttpSession session){
        int year= (int) session.getAttribute("year");
        String stuNumber= (String) session.getAttribute("stu_number");
        String msg;
        Teacher t= (Teacher) session.getAttribute("teacher");
        int moduleId=t.getModuleId();

        if(moduleId==1){
            ScoreEntity deyuScore=teacherScoreService.getItems1(year,stuNumber);

            if(deyuScore!=null){
                msg="查询成功！";
                return  new Result(Code.GET_ITEMS_OK,deyuScore,msg);
            }
        }
        if(moduleId==2){
            ScoreEntity zhiyuScore=teacherScoreService.getItems2(year,stuNumber);

            if(zhiyuScore!=null){
                msg="查询成功！";
                return  new Result(Code.GET_ITEMS_OK,zhiyuScore,msg);
            }
        }

        if(moduleId==3){
            ScoreEntity tiyuScore=teacherScoreService.getItems3(year,stuNumber);

            if(tiyuScore!=null){
                msg="查询成功！";
                return  new Result(Code.GET_ITEMS_OK,tiyuScore,msg);
            }
        }
        if(moduleId==4){
            ScoreEntity meiyuScore=teacherScoreService.getItems4(year,stuNumber);

            if(meiyuScore!=null){
                msg="查询成功！";
                return  new Result(Code.GET_ITEMS_OK,meiyuScore,msg);
            }
        }
        if(moduleId==5){
            ScoreEntity meiyuScore=teacherScoreService.getItems5(year,stuNumber);

            if(meiyuScore!=null){
                msg="查询成功！";
                return  new Result(Code.GET_ITEMS_OK,meiyuScore,msg);
            }
        }

        if(moduleId==6){
            ScoreEntity cxcyScore=teacherScoreService.getItems6(year,stuNumber);

            if(cxcyScore!=null){
                msg="查询成功！";
                return  new Result(Code.GET_ITEMS_OK,cxcyScore,msg);
            }
        }


        return  new Result(Code.GET_ITEMS_ERR,null,"查询失败！");
    }


    @RequestMapping(value ="get/batch/item")
    @ResponseBody
    public Result getBatchItems( HttpSession session){
        int year= (int) session.getAttribute("year");
       List<String> list= (List<String>) session.getAttribute("list");
        Teacher t= (Teacher) session.getAttribute("teacher");
        int moduleId=t.getModuleId();
        List<ScoreEntity> list1 = new ArrayList<ScoreEntity>();
        List<ScoreEntity> list2 = new ArrayList<ScoreEntity>();
        List<ScoreEntity> list3 = new ArrayList<ScoreEntity>();
        List<ScoreEntity> list4 = new ArrayList<ScoreEntity>();
        List<ScoreEntity> list5 = new ArrayList<ScoreEntity>();
        List<ScoreEntity> list6 = new ArrayList<ScoreEntity>();

       for(String stu_number:list) {
           if (moduleId == 1) {
               ScoreEntity deyuScore = teacherScoreService.getItems1(year, stu_number);

               if (deyuScore != null) {
                   list1.add(deyuScore);

               }
           }
           if (moduleId == 2) {
               ScoreEntity zhiyuScore = teacherScoreService.getItems2(year, stu_number);

               if (zhiyuScore != null) {
                   list2.add(zhiyuScore);
               }
           }

           if (moduleId == 3) {
               ScoreEntity tiyuScore = teacherScoreService.getItems3(year, stu_number);

               if (tiyuScore != null) {
                  list3.add(tiyuScore);
               }
           }
           if (moduleId == 4) {
               ScoreEntity meiyuScore = teacherScoreService.getItems4(year, stu_number);

               if (meiyuScore != null) {
                   list4.add(meiyuScore);
               }
           }
           if (moduleId == 5) {
               ScoreEntity laoyuScore = teacherScoreService.getItems5(year, stu_number);

               if (laoyuScore != null) {
                 list5.add(laoyuScore);
               }
           }

           if (moduleId == 6) {
               ScoreEntity cxcyScore = teacherScoreService.getItems6(year, stu_number);

               if (cxcyScore != null) {
                  list6.add(cxcyScore);
               }
           }
       }
       if(list1!=null) return new Result(Code.GET_ITEMS_OK,list1,"批量查询成功！");
        if(list2!=null) return new Result(Code.GET_ITEMS_OK,list2,"批量查询成功！");
        if(list3!=null) return new Result(Code.GET_ITEMS_OK,list3,"批量查询成功！");
        if(list4!=null) return new Result(Code.GET_ITEMS_OK,list4,"批量查询成功！");
        if(list5!=null) return new Result(Code.GET_ITEMS_OK,list5,"批量查询成功！");
        if(list6!=null) return new Result(Code.GET_ITEMS_OK,list6,"批量查询成功！");


        else return  new Result(Code.GET_ITEMS_ERR,null,"查询失败！");
    }
    @RequestMapping(value ="get/items")
    @ResponseBody
    public Result getItem( @RequestBody Map<String,Object> map, HttpSession session){
        int year= (int) map.get("year");
        String stuNumber= (String) map.get("stu_number");
        String msg;
        Teacher t= (Teacher) session.getAttribute("teacher");
        int moduleId=t.getModuleId();

        if(moduleId==1){
            ScoreEntity deyuScore=teacherScoreService.getItems1(year,stuNumber);

            if(deyuScore!=null){
                msg="查询成功！";
                return  new Result(Code.GET_ITEMS_OK,deyuScore,msg);
            }
        }
        if(moduleId==2){
            ScoreEntity zhiyuScore=teacherScoreService.getItems2(year,stuNumber);

            if(zhiyuScore!=null){
                msg="查询成功！";
                return  new Result(Code.GET_ITEMS_OK,zhiyuScore,msg);
            }
        }

        if(moduleId==3){
            ScoreEntity tiyuScore=teacherScoreService.getItems3(year,stuNumber);

            if(tiyuScore!=null){
                msg="查询成功！";
                return  new Result(Code.GET_ITEMS_OK,tiyuScore,msg);
            }
        }
        if(moduleId==4){
            ScoreEntity meiyuScore=teacherScoreService.getItems4(year,stuNumber);

            if(meiyuScore!=null){
                msg="查询成功！";
                return  new Result(Code.GET_ITEMS_OK,meiyuScore,msg);
            }
        }
        if(moduleId==5){
            ScoreEntity meiyuScore=teacherScoreService.getItems5(year,stuNumber);

            if(meiyuScore!=null){
                msg="查询成功！";
                return  new Result(Code.GET_ITEMS_OK,meiyuScore,msg);
            }
        }

        if(moduleId==6){
            ScoreEntity cxcyScore=teacherScoreService.getItems6(year,stuNumber);

            if(cxcyScore!=null){
                msg="查询成功！";
                return  new Result(Code.GET_ITEMS_OK,cxcyScore,msg);
            }
        }


        return  new Result(Code.GET_ITEMS_ERR,null,"查询失败！");
    }


//    @RequestMapping("/batch/enter/score")
//    @ResponseBody
//    public Result batchEnterScore(@RequestBody Map<String, Object> map, HttpSession session){
//        String msg;
//        Teacher t= (Teacher) session.getAttribute("teacher");
//        int moduleId=t.getModuleId();
//        int year= (int) map.get("year");
//        List<String> list= (List<String>) map.get("list");
//        for(String stu_number:list) {
//            if (moduleId == 1) {
//                ScoreEntity deyuScore = new ScoreEntity();
//                ScoreDoneEntity deyuscore = new ScoreDoneEntity();
//                deyuScore.setStu_number(stu_number);
//                deyuScore.setYear(year);
//                deyuScore.setDeyu((String) map.get("deyu"));
//                deyuScore.setDeyu_basicAssessD1((String) map.get("deyu_basicAssessD1"));
//                deyuScore.setDeyu_otherTotalD2((String) map.get("deyu_otherTotalD2"));
//                deyuScore.setDeyu_D2_groupAssess((String) map.get("deyu_D2_groupAssess"));
//                deyuScore.setDeyu_D2_socialRespons((String) map.get("deyu_D2_socialRespons"));
//                deyuScore.setDeyu_D2_politicalLearn((String) map.get("deyu_D2_politicalLearn"));
//                deyuScore.setDeyu_D2_minusTotal((String) map.get("deyu_D2_minusTotal"));
//                deyuScore.setDeyu_D2_honorTotal((String) map.get("deyu_D2_honorTotal"));
//                deyuscore.setStu_number(stu_number);
//                deyuscore.setYear(year);
//                deyuscore.setDeyu((String) map.get("deyu"));
//                deyuscore.setDeyu_basicAssessD1((String) map.get("deyu_basicAssessD1"));
//                deyuscore.setDeyu_otherTotalD2((String) map.get("deyu_otherTotalD2"));
//                deyuscore.setDeyu_D2_groupAssess((String) map.get("deyu_D2_groupAssess"));
//                deyuscore.setDeyu_D2_socialRespons((String) map.get("deyu_D2_socialRespons"));
//                deyuscore.setDeyu_D2_politicalLearn((String) map.get("deyu_D2_politicalLearn"));
//                deyuscore.setDeyu_D2_minusTotal((String) map.get("deyu_D2_minusTotal"));
//                deyuscore.setDeyu_D2_honorTotal((String) map.get("deyu_D2_honorTotal"));
//                deyuscore.setTeacher(t.getUsername());
//                if (teacherScoreService.enterScore1(deyuScore) > 0) {
//                    teacherScoreService.enterDone1(deyuscore);
//                    msg = "录入成功！";
//                    return new Result(Code.ENTER_SCORE_OK, deyuScore, msg);
//                }
//            }
//            if (moduleId == 2) {
//                ScoreEntity zhiyuScore = new ScoreEntity();
//                ScoreDoneEntity zhiyuscore = new ScoreDoneEntity();
//                zhiyuScore.setStu_number(stu_number);
//                zhiyuScore.setYear(year);
//                zhiyuScore.setZhiyu((String) map.get("zhiyu"));
//                zhiyuScore.setZhiyu_GPA((String) map.get("zhiyu_GPA"));
//                zhiyuscore.setStu_number(stu_number);
//                zhiyuscore.setYear(year);
//                zhiyuscore.setZhiyu((String) map.get("zhiyu"));
//                zhiyuscore.setZhiyu_GPA((String) map.get("zhiyu_GPA"));
//                zhiyuscore.setTeacher(t.getUsername());
//                if (teacherScoreService.enterScore2(zhiyuScore) > 0) {
//                    teacherScoreService.enterDone2(zhiyuscore);
//                    msg = "录入成功！";
//                    return new Result(Code.ENTER_SCORE_OK, zhiyuScore, msg);
//                }
//            }
//
//
//            if (moduleId == 3) {
//                ScoreEntity tiyuScore = new ScoreEntity();
//                ScoreDoneEntity tiyuscore = new ScoreDoneEntity();
//                tiyuScore.setStu_number(stu_number);
//                tiyuScore.setYear(year);
//                tiyuScore.setTiyu((String) map.get("tiyu"));
//                tiyuScore.setTiyu_scoreTotalT1((String) map.get("tiyu_scoreTotalT1"));
//                tiyuScore.setTiyu_T1_score1((String) map.get("tiyu_T1_score1"));
//                tiyuScore.setTiyu_T1_score2((String) map.get("tiyu_T1_score2"));
//                tiyuScore.setTiyu_otherTotalT2((String) map.get("tiyu_otherTotalT2"));
//                tiyuScore.setTiyu_T2_races((String) map.get("tiyu_T2_races"));
//                tiyuScore.setTiyu_T2_races((String) map.get("tiyu_T2_earlyExercise"));
//                tiyuscore.setStu_number(stu_number);
//                tiyuscore.setYear(year);
//                tiyuscore.setTiyu((String) map.get("tiyu"));
//                tiyuscore.setTiyu_scoreTotalT1((String) map.get("tiyu_scoreTotalT1"));
//                tiyuscore.setTiyu_T1_score1((String) map.get("tiyu_T1_score1"));
//                tiyuscore.setTiyu_T1_score2((String) map.get("tiyu_T1_score2"));
//                tiyuscore.setTiyu_otherTotalT2((String) map.get("tiyu_otherTotalT2"));
//                tiyuscore.setTiyu_T2_races((String) map.get("tiyu_T2_races"));
//                tiyuscore.setTiyu_T2_races((String) map.get("tiyu_T2_earlyExercise"));
//                tiyuscore.setTeacher(t.getUsername());
//
//                if (teacherScoreService.enterScore3(tiyuScore) > 0) {
//                    teacherScoreService.enterDone3(tiyuscore);
//                    msg = "录入成功！";
//                    return new Result(Code.ENTER_SCORE_OK, tiyuScore, msg);
//                }
//            }
//            if (moduleId == 4) {
//                ScoreEntity meiyuScore = new ScoreEntity();
//                ScoreDoneEntity meiyuscore = new ScoreDoneEntity();
//                meiyuScore.setStu_number(stu_number);
//                meiyuScore.setYear(year);
//                meiyuScore.setMeiyu((String) map.get("meiyu"));
//                meiyuScore.setMeiyu_practiceM1((String) map.get("meiyu_practiceM1"));
//                meiyuscore.setMeiyu_competitionM2((String) map.get("meiyu_competitionM2"));
//                meiyuscore.setStu_number(stu_number);
//                meiyuscore.setYear(year);
//                meiyuscore.setMeiyu((String) map.get("meiyu"));
//                meiyuscore.setMeiyu_practiceM1((String) map.get("meiyu_practiceM1"));
//                meiyuscore.setMeiyu_competitionM2((String) map.get("meiyu_competitionM2"));
//                meiyuscore.setTeacher(t.getUsername());
//                if (teacherScoreService.enterScore4(meiyuScore) > 0) {
//                    teacherScoreService.enterDone4(meiyuscore);
//                    msg = "录入成功！";
//                    return new Result(Code.ENTER_SCORE_OK, meiyuScore, msg);
//                }
//            }
//            if (moduleId == 5) {
//                ScoreEntity laoyuScore = new ScoreEntity();
//                ScoreDoneEntity laoyuscore = new ScoreDoneEntity();
//                laoyuScore.setStu_number(stu_number);
//                laoyuScore.setYear(year);
//                laoyuScore.setLaoyu((String) map.get("laoyu"));
//                laoyuScore.setLaoyu_dailyTotalL1((String) map.get("laoyu_dailyTotalL1"));
//                laoyuScore.setLaoyu_L1_roomDaily((String) map.get("laoyu_L1_roomDaily"));
//                laoyuScore.setLaoyu_L1_roomActivity((String) map.get("laoyu_L1_roomActivity"));
//                laoyuScore.setLaoyu_L1_roomPerform((String) map.get("laoyu_L1_roomPerform"));
//                laoyuScore.setLaoyu_volunteerL2((String) map.get("laoyu_volunteerL2"));
//                laoyuScore.setLaoyu_internshipL3((String) map.get("laoyu_internshipL3"));
//                laoyuscore.setStu_number(stu_number);
//                laoyuscore.setYear(year);
//                laoyuscore.setLaoyu((String) map.get("laoyu"));
//                laoyuscore.setLaoyu_dailyTotalL1((String) map.get("laoyu_dailyTotalL1"));
//                laoyuscore.setLaoyu_L1_roomDaily((String) map.get("laoyu_L1_roomDaily"));
//                laoyuscore.setLaoyu_L1_roomActivity((String) map.get("laoyu_L1_roomActivity"));
//                laoyuscore.setLaoyu_L1_roomPerform((String) map.get("laoyu_L1_roomPerform"));
//                laoyuscore.setLaoyu_volunteerL2((String) map.get("laoyu_volunteerL2"));
//                laoyuscore.setLaoyu_internshipL3((String) map.get("laoyu_internshipL3"));
//                laoyuscore.setTeacher(t.getUsername());
//
//                if (teacherScoreService.enterScore5(laoyuScore) > 0) {
//                    teacherScoreService.enterDone5(laoyuscore);
//                    msg = "录入成功！";
//                    return new Result(Code.ENTER_SCORE_OK, laoyuScore, msg);
//                }
//            }
//            if (moduleId == 6) {
//                ScoreEntity cxcyScore = new ScoreEntity();
//                ScoreDoneEntity cxcyscore = new ScoreDoneEntity();
//                cxcyScore.setStu_number(stu_number);
//                cxcyScore.setYear(year);
//                cxcyScore.setCxcy((String) map.get("cxcy"));
//                cxcyScore.setCxcy_scoreTotalC1((String) map.get("cxcy_scoreTotalC1"));
//                cxcyScore.setCxcy_C1_competition((String) map.get("cxcy_C1_competition"));
//                cxcyScore.setCxcy_C1_levelGrade((String) map.get("cxcy_C1_levelGrade"));
//                cxcyScore.setCxcy_socialActivityC2((String) map.get("cxcy_socialActivityC2"));
//                cxcyScore.setCxcy_socialWorkC3((String) map.get("cxcy_socialWorkC3"));
//                cxcyscore.setStu_number(stu_number);
//                cxcyscore.setYear(year);
//                cxcyscore.setCxcy((String) map.get("cxcy"));
//                cxcyscore.setCxcy_scoreTotalC1((String) map.get("cxcy_scoreTotalC1"));
//                cxcyscore.setCxcy_C1_competition((String) map.get("cxcy_C1_competition"));
//                cxcyscore.setCxcy_C1_levelGrade((String) map.get("cxcy_C1_levelGrade"));
//                cxcyscore.setCxcy_socialActivityC2((String) map.get("cxcy_socialActivityC2"));
//                cxcyscore.setCxcy_socialWorkC3((String) map.get("cxcy_socialWorkC3"));
//                cxcyscore.setTeacher(t.getUsername());
//                if (teacherScoreService.enterScore6(cxcyScore) > 0) {
//                    teacherScoreService.enterDone6(cxcyscore);
//                    msg = "录入成功！";
//                    return new Result(Code.ENTER_SCORE_OK, cxcyScore, msg);
//                }
//            }
//        }
//
//        return new Result(Code.ENTER_SCORE_ERR,null,"录入失败！");
//    }

    @RequestMapping("/enter/score")
    @ResponseBody
    public Result enterScore(@RequestBody Map<String, Object> map, HttpSession session){
        String msg;
        Teacher t= (Teacher) session.getAttribute("teacher");
        int moduleId=t.getModuleId();
        int year= (int) map.get("year");
        String stu_number= (String) map.get("stu_number");
        if(moduleId==1) {
            ScoreEntity deyuScore=new ScoreEntity();
            ScoreDoneEntity deyuScoreDone =new ScoreDoneEntity();
            deyuScore.setStuNumber(stu_number);
            deyuScore.setYear(year);
            deyuScore.setDeyu((String) map.get("deyu"));
            deyuScore.setDeyuBasicAssessD1((String) map.get("deyu_basicAssessD1"));
            deyuScore.setDeyuOtherTotalD2((String) map.get("deyu_otherTotalD2"));
            deyuScore.setDeyuD2GroupAssess((String) map.get("deyu_D2_groupAssess"));
            deyuScore.setDeyuD2SocialRespons((String) map.get("deyu_D2_socialRespons"));
            deyuScore.setDeyuD2PoliticalLearn((String) map.get("deyu_D2_politicalLearn"));
            deyuScore.setDeyuD2MinusTotal((String) map.get("deyu_D2_minusTotal"));
            deyuScore.setDeyuD2HonorTotal((String) map.get("deyu_D2_honorTotal"));
            deyuScoreDone.setStuNumber(stu_number);
            deyuScoreDone.setYear(year);
            deyuScoreDone.setDeyu((String) map.get("deyu"));
            deyuScoreDone.setDeyuBasicAssessD1((String) map.get("deyu_basicAssessD1"));
            deyuScoreDone.setDeyuOtherTotalD2((String) map.get("deyu_otherTotalD2"));
            deyuScoreDone.setDeyuD2GroupAssess((String) map.get("deyu_D2_groupAssess"));
            deyuScoreDone.setDeyuD2SocialRespons((String) map.get("deyu_D2_socialRespons"));
            deyuScoreDone.setDeyuD2PoliticalLearn((String) map.get("deyu_D2_politicalLearn"));
            deyuScoreDone.setDeyuD2MinusTotal((String) map.get("deyu_D2_minusTotal"));
            deyuScoreDone.setDeyuD2HonorTotal((String) map.get("deyu_D2_honorTotal"));
            deyuScoreDone.setTeacher(t.getUsername());
            if (teacherScoreService.enterScore1(deyuScore)>0){
                teacherScoreService.enterDone1(deyuScoreDone);
                msg="录入成功！";
                return new Result(Code.ENTER_SCORE_OK,deyuScore,msg);
            }
        }
        if(moduleId==2) {
            ScoreEntity zhiyuScore=new ScoreEntity();
            ScoreDoneEntity zhiyuScoreDone =new ScoreDoneEntity();
            zhiyuScore.setStuNumber(stu_number);
            zhiyuScore.setYear(year);
            zhiyuScore.setZhiyu((String) map.get("zhiyu"));
            zhiyuScore.setZhiyuGPA((String) map.get("zhiyu_GPA"));
            zhiyuScoreDone.setStuNumber(stu_number);
            zhiyuScoreDone.setYear(year);
            zhiyuScoreDone.setZhiyu((String) map.get("zhiyu"));
            zhiyuScoreDone.setZhiyuGPA((String) map.get("zhiyu_GPA"));
            zhiyuScoreDone.setTeacher(t.getUsername());
            if (teacherScoreService.enterScore2(zhiyuScore)>0){
                teacherScoreService.enterDone2(zhiyuScoreDone);
                msg="录入成功！";
                return new Result(Code.ENTER_SCORE_OK,zhiyuScore,msg);
            }
        }


        if(moduleId==3) {
            ScoreEntity tiyuScore=new ScoreEntity();
            ScoreDoneEntity tiyuScoreDone =new ScoreDoneEntity();
            tiyuScore.setStuNumber(stu_number);
            tiyuScore.setYear(year);
            tiyuScore.setTiyu((String) map.get("tiyu"));
            tiyuScore.setTiyuScoreTotalT1((String) map.get("tiyu_scoreTotalT1"));
            tiyuScore.setTiyuT1Score1((String) map.get("tiyu_T1_score1"));
            tiyuScore.setTiyuT1Score2((String) map.get("tiyu_T1_score2"));
            tiyuScore.setTiyuOtherTotalT2((String) map.get("tiyu_otherTotalT2"));
            tiyuScore.setTiyuT2Races((String) map.get("tiyu_T2_races"));
            tiyuScore.setTiyuT2Races((String) map.get("tiyu_T2_earlyExercise"));
            tiyuScoreDone.setStuNumber(stu_number);
            tiyuScoreDone.setYear(year);
            tiyuScoreDone.setTiyu((String) map.get("tiyu"));
            tiyuScoreDone.setTiyuScoreTotalT1((String) map.get("tiyu_scoreTotalT1"));
            tiyuScoreDone.setTiyuT1Score1((String) map.get("tiyu_T1_score1"));
            tiyuScoreDone.setTiyuT1Score2((String) map.get("tiyu_T1_score2"));
            tiyuScoreDone.setTiyuOtherTotalT2((String) map.get("tiyu_otherTotalT2"));
            tiyuScoreDone.setTiyuT2Races((String) map.get("tiyu_T2_races"));
            tiyuScoreDone.setTiyuT2Races((String) map.get("tiyu_T2_earlyExercise"));
            tiyuScoreDone.setTeacher(t.getUsername());

            if (teacherScoreService.enterScore3(tiyuScore)>0){
                teacherScoreService.enterDone3(tiyuScoreDone);
                msg="录入成功！";
                return new Result(Code.ENTER_SCORE_OK,tiyuScore,msg);
            }
        }
        if(moduleId==4) {
            ScoreEntity meiyuScore=new ScoreEntity();
            ScoreDoneEntity meiyuScoreDone =new ScoreDoneEntity();
            meiyuScore.setStuNumber(stu_number);
            meiyuScore.setYear(year);
            meiyuScore.setMeiyu((String) map.get("meiyu"));
            meiyuScore.setMeiyuPracticeM1((String) map.get("meiyu_practiceM1"));
            meiyuScoreDone.setMeiyuCompetitionM2((String) map.get("meiyu_competitionM2"));
            meiyuScoreDone.setStuNumber(stu_number);
            meiyuScoreDone.setYear(year);
            meiyuScoreDone.setMeiyu((String) map.get("meiyu"));
            meiyuScoreDone.setMeiyuPracticeM1((String) map.get("meiyu_practiceM1"));
            meiyuScoreDone.setMeiyuCompetitionM2((String) map.get("meiyu_competitionM2"));
            meiyuScoreDone.setTeacher(t.getUsername());
            if (teacherScoreService.enterScore4(meiyuScore)>0){
                teacherScoreService.enterDone4(meiyuScoreDone);
                msg="录入成功！";
                return new Result(Code.ENTER_SCORE_OK,meiyuScore,msg);
            }
        }
        if(moduleId==5) {
            ScoreEntity laoyuScore=new ScoreEntity();
            ScoreDoneEntity laoyuScoreDone =new ScoreDoneEntity();
            laoyuScore.setStuNumber(stu_number);
            laoyuScore.setYear(year);
            laoyuScore.setLaoyu((String) map.get("laoyu"));
            laoyuScore.setLaoyuDailyTotalL1((String) map.get("laoyu_dailyTotalL1"));
            laoyuScore.setLaoyuL1RoomDaily((String) map.get("laoyu_L1_roomDaily"));
            laoyuScore.setLaoyuL1RoomActivity((String) map.get("laoyu_L1_roomActivity"));
            laoyuScore.setLaoyuL1RoomPerform((String) map.get("laoyu_L1_roomPerform"));
            laoyuScore.setLaoyuVolunteerL2((String) map.get("laoyu_volunteerL2"));
            laoyuScore.setLaoyuInternshipL3((String) map.get("laoyu_internshipL3"));
            laoyuScoreDone.setStuNumber(stu_number);
            laoyuScoreDone.setYear(year);
            laoyuScoreDone.setLaoyu((String) map.get("laoyu"));
            laoyuScoreDone.setLaoyuDailyTotalL1((String) map.get("laoyu_dailyTotalL1"));
            laoyuScoreDone.setLaoyuL1RoomDaily((String) map.get("laoyu_L1_roomDaily"));
            laoyuScoreDone.setLaoyuL1RoomActivity((String) map.get("laoyu_L1_roomActivity"));
            laoyuScoreDone.setLaoyuL1RoomPerform((String) map.get("laoyu_L1_roomPerform"));
            laoyuScoreDone.setLaoyuVolunteerL2((String) map.get("laoyu_volunteerL2"));
            laoyuScoreDone.setLaoyuInternshipL3((String) map.get("laoyu_internshipL3"));
            laoyuScoreDone.setTeacher(t.getUsername());

            if (teacherScoreService.enterScore5(laoyuScore)>0){
                teacherScoreService.enterDone5(laoyuScoreDone);
                msg="录入成功！";
                return new Result(Code.ENTER_SCORE_OK,laoyuScore,msg);
            }
        }
        if(moduleId==6) {
            ScoreEntity cxcyScore=new ScoreEntity();
            ScoreDoneEntity cxcyScoreDone =new ScoreDoneEntity();
            cxcyScore.setStuNumber(stu_number);
            cxcyScore.setYear(year);
            cxcyScore.setCxcy((String) map.get("cxcy"));
            cxcyScore.setCxcyScoreTotalC1((String) map.get("cxcy_scoreTotalC1"));
            cxcyScore.setCxcyC1Competition((String) map.get("cxcy_C1_competition"));
            cxcyScore.setCxcyC1LevelGrade((String) map.get("cxcy_C1_levelGrade"));
            cxcyScore.setCxcySocialActivityC2((String) map.get("cxcy_socialActivityC2"));
            cxcyScore.setCxcySocialWorkC3((String) map.get("cxcy_socialWorkC3"));
            cxcyScoreDone.setStuNumber(stu_number);
            cxcyScoreDone.setYear(year);
            cxcyScoreDone.setCxcy((String) map.get("cxcy"));
            cxcyScoreDone.setCxcyScoreTotalC1((String) map.get("cxcy_scoreTotalC1"));
            cxcyScoreDone.setCxcyC1Competition((String) map.get("cxcy_C1_competition"));
            cxcyScoreDone.setCxcyC1LevelGrade((String) map.get("cxcy_C1_levelGrade"));
            cxcyScoreDone.setCxcySocialActivityC2((String) map.get("cxcy_socialActivityC2"));
            cxcyScoreDone.setCxcySocialWorkC3((String) map.get("cxcy_socialWorkC3"));
            cxcyScoreDone.setTeacher(t.getUsername());
            if (teacherScoreService.enterScore6(cxcyScore)>0){
                teacherScoreService.enterDone6(cxcyScoreDone);
                msg="录入成功！";
                return new Result(Code.ENTER_SCORE_OK,cxcyScore,msg);
            }
        }

        return new Result(Code.ENTER_SCORE_ERR,null,"录入失败！");
    }


    @RequestMapping(value="/change/score",method = RequestMethod.PUT)
    @ResponseBody
    public Result changeScore(@RequestBody Map<String, Object> map, HttpSession session){
        String msg;
        Teacher t= (Teacher) session.getAttribute("teacher");
        int moduleId=t.getModuleId();
        int year= (int) map.get("year");
        String stu_number= (String) map.get("stu_number");
        if(moduleId==1) {
            ScoreEntity deyuScore=new ScoreEntity();
            ScoreDoneEntity deyuScoreDone =new ScoreDoneEntity();
            deyuScore.setStuNumber(stu_number);
            deyuScore.setYear(year);
            deyuScore.setDeyu((String) map.get("deyu"));
            deyuScore.setDeyuBasicAssessD1((String) map.get("deyu_basicAssessD1"));
            deyuScore.setDeyuOtherTotalD2((String) map.get("deyu_otherTotalD2"));
            deyuScore.setDeyuD2GroupAssess((String) map.get("deyu_D2_groupAssess"));
            deyuScore.setDeyuD2SocialRespons((String) map.get("deyu_D2_socialRespons"));
            deyuScore.setDeyuD2PoliticalLearn((String) map.get("deyu_D2_politicalLearn"));
            deyuScore.setDeyuD2MinusTotal((String) map.get("deyu_D2_minusTotal"));
            deyuScore.setDeyuD2HonorTotal((String) map.get("deyu_D2_honorTotal"));
            deyuScoreDone.setStuNumber(stu_number);
            deyuScoreDone.setYear(year);
            deyuScoreDone.setDeyu((String) map.get("deyu"));
            deyuScoreDone.setDeyuBasicAssessD1((String) map.get("deyu_basicAssessD1"));
            deyuScoreDone.setDeyuOtherTotalD2((String) map.get("deyu_otherTotalD2"));
            deyuScoreDone.setDeyuD2GroupAssess((String) map.get("deyu_D2_groupAssess"));
            deyuScoreDone.setDeyuD2SocialRespons((String) map.get("deyu_D2_socialRespons"));
            deyuScoreDone.setDeyuD2PoliticalLearn((String) map.get("deyu_D2_politicalLearn"));
            deyuScoreDone.setDeyuD2MinusTotal((String) map.get("deyu_D2_minusTotal"));
            deyuScoreDone.setDeyuD2HonorTotal((String) map.get("deyu_D2_honorTotal"));
            deyuScoreDone.setTeacher(t.getUsername());
            if (teacherScoreService.enterScore1(deyuScore)>0){
                teacherScoreService.enterDone1(deyuScoreDone);
                msg="修改成功！";
                return new Result(Code.ENTER_SCORE_OK,deyuScore,msg);
            }
        }
        if(moduleId==2) {
            ScoreEntity zhiyuScore=new ScoreEntity();
            ScoreDoneEntity zhiyuScoreDone =new ScoreDoneEntity();
            zhiyuScore.setStuNumber(stu_number);
            zhiyuScore.setYear(year);
            zhiyuScore.setZhiyu((String) map.get("zhiyu"));
            zhiyuScore.setZhiyuGPA((String) map.get("zhiyu_GPA"));
            zhiyuScoreDone.setStuNumber(stu_number);
            zhiyuScoreDone.setYear(year);
            zhiyuScoreDone.setZhiyu((String) map.get("zhiyu"));
            zhiyuScoreDone.setZhiyuGPA((String) map.get("zhiyu_GPA"));
            zhiyuScoreDone.setTeacher(t.getUsername());
            if (teacherScoreService.enterScore2(zhiyuScore)>0){
                teacherScoreService.enterDone2(zhiyuScoreDone);
                msg="修改成功！";
                return new Result(Code.ENTER_SCORE_OK,zhiyuScore,msg);
            }
        }


        if(moduleId==3) {
            ScoreEntity tiyuScore=new ScoreEntity();
            ScoreDoneEntity tiyuScoreDone =new ScoreDoneEntity();
            tiyuScore.setStuNumber(stu_number);
            tiyuScore.setYear(year);
            tiyuScore.setTiyu((String) map.get("tiyu"));
            tiyuScore.setTiyuScoreTotalT1((String) map.get("tiyu_scoreTotalT1"));
            tiyuScore.setTiyuT1Score1((String) map.get("tiyu_T1_score1"));
            tiyuScore.setTiyuT1Score2((String) map.get("tiyu_T1_score2"));
            tiyuScore.setTiyuOtherTotalT2((String) map.get("tiyu_otherTotalT2"));
            tiyuScore.setTiyuT2Races((String) map.get("tiyu_T2_races"));
            tiyuScore.setTiyuT2Races((String) map.get("tiyu_T2_earlyExercise"));
            tiyuScoreDone.setStuNumber(stu_number);
            tiyuScoreDone.setYear(year);
            tiyuScoreDone.setTiyu((String) map.get("tiyu"));
            tiyuScoreDone.setTiyuScoreTotalT1((String) map.get("tiyu_scoreTotalT1"));
            tiyuScoreDone.setTiyuT1Score1((String) map.get("tiyu_T1_score1"));
            tiyuScoreDone.setTiyuT1Score2((String) map.get("tiyu_T1_score2"));
            tiyuScoreDone.setTiyuOtherTotalT2((String) map.get("tiyu_otherTotalT2"));
            tiyuScoreDone.setTiyuT2Races((String) map.get("tiyu_T2_races"));
            tiyuScoreDone.setTiyuT2Races((String) map.get("tiyu_T2_earlyExercise"));
            tiyuScoreDone.setTeacher(t.getUsername());

            if (teacherScoreService.enterScore3(tiyuScore)>0){
                teacherScoreService.enterDone3(tiyuScoreDone);
                msg="修改成功！";
                return new Result(Code.ENTER_SCORE_OK,tiyuScore,msg);
            }
        }
        if(moduleId==4) {
            ScoreEntity meiyuScore=new ScoreEntity();
            ScoreDoneEntity meiyuScoreDone =new ScoreDoneEntity();
            meiyuScore.setStuNumber(stu_number);
            meiyuScore.setYear(year);
            meiyuScore.setMeiyu((String) map.get("meiyu"));
            meiyuScore.setMeiyuPracticeM1((String) map.get("meiyu_practiceM1"));
            meiyuScoreDone.setMeiyuCompetitionM2((String) map.get("meiyu_competitionM2"));
            meiyuScoreDone.setStuNumber(stu_number);
            meiyuScoreDone.setYear(year);
            meiyuScoreDone.setMeiyu((String) map.get("meiyu"));
            meiyuScoreDone.setMeiyuPracticeM1((String) map.get("meiyu_practiceM1"));
            meiyuScoreDone.setMeiyuCompetitionM2((String) map.get("meiyu_competitionM2"));
            meiyuScoreDone.setTeacher(t.getUsername());
            if (teacherScoreService.enterScore4(meiyuScore)>0){
                teacherScoreService.enterDone4(meiyuScoreDone);
                msg="修改成功！";
                return new Result(Code.ENTER_SCORE_OK,meiyuScore,msg);
            }
        }
        if(moduleId==5) {
            ScoreEntity laoyuScore=new ScoreEntity();
            ScoreDoneEntity laoyuScoreDone =new ScoreDoneEntity();
            laoyuScore.setStuNumber(stu_number);
            laoyuScore.setYear(year);
            laoyuScore.setLaoyu((String) map.get("laoyu"));
            laoyuScore.setLaoyuDailyTotalL1((String) map.get("laoyu_dailyTotalL1"));
            laoyuScore.setLaoyuL1RoomDaily((String) map.get("laoyu_L1_roomDaily"));
            laoyuScore.setLaoyuL1RoomActivity((String) map.get("laoyu_L1_roomActivity"));
            laoyuScore.setLaoyuL1RoomPerform((String) map.get("laoyu_L1_roomPerform"));
            laoyuScore.setLaoyuVolunteerL2((String) map.get("laoyu_volunteerL2"));
            laoyuScore.setLaoyuInternshipL3((String) map.get("laoyu_internshipL3"));
            laoyuScoreDone.setStuNumber(stu_number);
            laoyuScoreDone.setYear(year);
            laoyuScoreDone.setLaoyu((String) map.get("laoyu"));
            laoyuScoreDone.setLaoyuDailyTotalL1((String) map.get("laoyu_dailyTotalL1"));
            laoyuScoreDone.setLaoyuL1RoomDaily((String) map.get("laoyu_L1_roomDaily"));
            laoyuScoreDone.setLaoyuL1RoomActivity((String) map.get("laoyu_L1_roomActivity"));
            laoyuScoreDone.setLaoyuL1RoomPerform((String) map.get("laoyu_L1_roomPerform"));
            laoyuScoreDone.setLaoyuVolunteerL2((String) map.get("laoyu_volunteerL2"));
            laoyuScoreDone.setLaoyuInternshipL3((String) map.get("laoyu_internshipL3"));
            laoyuScoreDone.setTeacher(t.getUsername());

            if (teacherScoreService.enterScore5(laoyuScore)>0){
                teacherScoreService.enterDone5(laoyuScoreDone);
                msg="修改成功！";
                return new Result(Code.ENTER_SCORE_OK,laoyuScore,msg);
            }
        }
        if(moduleId==6) {
            ScoreEntity cxcyScore=new ScoreEntity();
            ScoreDoneEntity cxcyScoreDone =new ScoreDoneEntity();
            cxcyScore.setStuNumber(stu_number);
            cxcyScore.setYear(year);
            cxcyScore.setCxcy((String) map.get("cxcy"));
            cxcyScore.setCxcyScoreTotalC1((String) map.get("cxcy_scoreTotalC1"));
            cxcyScore.setCxcyC1Competition((String) map.get("cxcy_C1_competition"));
            cxcyScore.setCxcyC1LevelGrade((String) map.get("cxcy_C1_levelGrade"));
            cxcyScore.setCxcySocialActivityC2((String) map.get("cxcy_socialActivityC2"));
            cxcyScore.setCxcySocialWorkC3((String) map.get("cxcy_socialWorkC3"));
            cxcyScoreDone.setStuNumber(stu_number);
            cxcyScoreDone.setYear(year);
            cxcyScoreDone.setCxcy((String) map.get("cxcy"));
            cxcyScoreDone.setCxcyScoreTotalC1((String) map.get("cxcy_scoreTotalC1"));
            cxcyScoreDone.setCxcyC1Competition((String) map.get("cxcy_C1_competition"));
            cxcyScoreDone.setCxcyC1LevelGrade((String) map.get("cxcy_C1_levelGrade"));
            cxcyScoreDone.setCxcySocialActivityC2((String) map.get("cxcy_socialActivityC2"));
            cxcyScoreDone.setCxcySocialWorkC3((String) map.get("cxcy_socialWorkC3"));
            cxcyScoreDone.setTeacher(t.getUsername());
            if (teacherScoreService.enterScore6(cxcyScore)>0){
                teacherScoreService.enterDone6(cxcyScoreDone);
                msg="修改成功！";
                return new Result(Code.ENTER_SCORE_OK,cxcyScore,msg);
            }
        }

        return new Result(Code.ENTER_SCORE_ERR,null,"修改失败！");
    }

    @RequestMapping("/approval")

    public void approval(@RequestBody Map<String,Object> map, HttpSession session,  HttpServletResponse response) throws IOException {
        int year = (int) map.get("year");
        String stu_number = (String) map.get("stu_number");
        boolean is_approval = (boolean) map.get("is_approval");
        Teacher t = (Teacher) session.getAttribute("teacher");
        int moduleId = t.getModuleId();
        StuInfoEntity stu = stuService.selectByNumber(stu_number);
        ScoreEntity items1 = teacherScoreService.getItems1(year, stu_number);
        ScoreDoneEntity scoreDone=new ScoreDoneEntity();
        scoreDone.setStuNumber(stu_number);
        scoreDone.setTeacher(t.getUsername());
        scoreDone.setYear(year);
        int stu_year = stu.getStuYear();
        if (is_approval) {
            scoreDone.setIsApproval(1);
            if (moduleId == 1) {
                scoreDone.setDeyu(items1.getDeyu());
                scoreDone.setDeyuBasicAssessD1(items1.getDeyuBasicAssessD1());
                scoreDone.setDeyuOtherTotalD2(items1.getDeyuOtherTotalD2());
                scoreDone.setDeyuD2GroupAssess(items1.getDeyuD2GroupAssess());
                scoreDone.setDeyuD2SocialRespons(items1.getDeyuD2SocialRespons());
                scoreDone.setDeyuD2PoliticalLearn(items1.getDeyuD2PoliticalLearn());
                scoreDone.setDeyuD2MinusTotal(items1.getDeyuD2MinusTotal());
                scoreDone.setDeyuD2HonorTotal(items1.getDeyuD2HonorTotal());
                if (year - stu_year == 0) {
                if(teacherScoreService.approval11(stu_number)>0) {

                teacherScoreService.addDone1(scoreDone);
                session.setAttribute("stu_number",stu_number);
                session.setAttribute("year",year);

                    response.sendRedirect("get/item");


                }

                }
                if(year-stu_year==1){
                    if(teacherScoreService.approval21(stu_number)>0) {
                        teacherScoreService.addDone1(scoreDone);

                        session.setAttribute("stu_number",stu_number);
                        session.setAttribute("year",year);

                        response.sendRedirect("get/item");


                    }
                }
                if(year-stu_year==2){
                    if(teacherScoreService.approval31(stu_number)>0){
                        teacherScoreService.addDone1(scoreDone);

                        session.setAttribute("stu_number",stu_number);
                        session.setAttribute("year",year);

                        response.sendRedirect("get/item");

                    }
                }
                if(year-stu_year==3){
                    if(teacherScoreService.approval41(stu_number)>0){
                        teacherScoreService.addDone1(scoreDone);
                        session.setAttribute("stu_number",stu_number);
                        session.setAttribute("year",year);

                        response.sendRedirect("get/item");
                    }
                }

            }

            if(moduleId==2){
                scoreDone.setZhiyu(items1.getZhiyu());
                scoreDone.setZhiyuGPA(items1.getZhiyuGPA());
                if (year - stu_year == 0) {
                    if(teacherScoreService.approval12(stu_number)>0) {
                        teacherScoreService.addDone2(scoreDone);

                        session.setAttribute("stu_number",stu_number);
                        session.setAttribute("year",year);

                        response.sendRedirect("get/item");

                    }
                }
                if(year-stu_year==1){
                    if(teacherScoreService.approval22(stu_number)>0){
                        teacherScoreService.addDone2(scoreDone);

                        session.setAttribute("stu_number",stu_number);
                        session.setAttribute("year",year);

                        response.sendRedirect("get/item");

                    }
                }
                if(year-stu_year==2){
                    if(teacherScoreService.approval32(stu_number)>0){
                        teacherScoreService.addDone2(scoreDone);

                        session.setAttribute("stu_number",stu_number);
                        session.setAttribute("year",year);

                        response.sendRedirect("get/item");

                    }
                }
                if(year-stu_year==3){
                    if(teacherScoreService.approval42(stu_number)>0){
                        teacherScoreService.addDone2(scoreDone);
                        session.setAttribute("stu_number",stu_number);
                        session.setAttribute("year",year);

                        response.sendRedirect("get/item");
                    }
                }


            }

            if(moduleId==3) {
                scoreDone.setTiyu(items1.getTiyu());
                scoreDone.setTiyuScoreTotalT1(items1.getTiyuScoreTotalT1());
                scoreDone.setTiyuT1Score1(items1.getTiyuT1Score1());
                scoreDone.setTiyuT1Score2(items1.getTiyuT1Score2());
                scoreDone.setTiyuOtherTotalT2(items1.getTiyuOtherTotalT2());
                scoreDone.setTiyuT2Races(items1.getTiyuT2Races());
                scoreDone.setTiyuT2EarlyExercise(items1.getTiyuT2EarlyExercise());
                if (year - stu_year == 0) {
                    if (teacherScoreService.approval13(stu_number) > 0) {
                        teacherScoreService.addDone3(scoreDone);
                        session.setAttribute("stu_number",stu_number);
                        session.setAttribute("year",year);

                        response.sendRedirect("get/item");
                    }
                }
                if (year - stu_year == 1) {
                    if (teacherScoreService.approval23(stu_number) > 0){
                        teacherScoreService.addDone3(scoreDone);
                        session.setAttribute("stu_number",stu_number);
                        session.setAttribute("year",year);

                        response.sendRedirect("get/item");

                    }
                }
                if (year - stu_year == 2) {
                    if (teacherScoreService.approval33(stu_number) > 0){
                        teacherScoreService.addDone3(scoreDone);
                        session.setAttribute("stu_number",stu_number);
                        session.setAttribute("year",year);

                        response.sendRedirect("get/item");

                    }
                }
                if (year - stu_year == 3) {
                    if (teacherScoreService.approval43(stu_number) > 0){
                        teacherScoreService.addDone3(scoreDone);
                        session.setAttribute("stu_number",stu_number);
                        session.setAttribute("year",year);

                        response.sendRedirect("get/item");
                    }
                }
            }

                if(moduleId==4){
                    scoreDone.setMeiyu(items1.getMeiyu());
                    scoreDone.setMeiyuPracticeM1(items1.getMeiyuPracticeM1());
                    scoreDone.setMeiyuCompetitionM2(items1.getMeiyuCompetitionM2());
                    if (year - stu_year == 0) {
                        if(teacherScoreService.approval14(stu_number)>0) {
                            teacherScoreService.addDone4(scoreDone);
                            session.setAttribute("stu_number",stu_number);
                            session.setAttribute("year",year);

                            response.sendRedirect("get/item");

                        }
                    }
                    if(year-stu_year==1){
                        if(teacherScoreService.approval24(stu_number)>0){
                            teacherScoreService.addDone4(scoreDone);
                            session.setAttribute("stu_number",stu_number);
                            session.setAttribute("year",year);

                            response.sendRedirect("get/item");
                        }
                    }
                    if(year-stu_year==2){
                        if(teacherScoreService.approval34(stu_number)>0){
                            teacherScoreService.addDone4(scoreDone);
                            session.setAttribute("stu_number",stu_number);
                            session.setAttribute("year",year);

                            response.sendRedirect("get/item");
                        }
                    }
                    if(year-stu_year==3){
                        if(teacherScoreService.approval44(stu_number)>0){
                            teacherScoreService.addDone4(scoreDone);
                            session.setAttribute("stu_number",stu_number);
                            session.setAttribute("year",year);

                            response.sendRedirect("get/item");
                        }
                    }


                }
                if(moduleId==5){
                    scoreDone.setLaoyu(items1.getLaoyu());
                    scoreDone.setLaoyuDailyTotalL1(items1.getLaoyuDailyTotalL1());
                    scoreDone.setLaoyuL1RoomActivity(items1.getLaoyuL1RoomActivity());
                    scoreDone.setLaoyuL1RoomDaily(items1.getLaoyuL1RoomDaily());
                    scoreDone.setLaoyuL1RoomPerform(items1.getLaoyuL1RoomPerform());
                    scoreDone.setLaoyuVolunteerL2(items1.getLaoyuVolunteerL2());
                    scoreDone.setLaoyuInternshipL3(items1.getLaoyuInternshipL3());
                    if (year - stu_year == 0) {
                        if(teacherScoreService.approval15(stu_number)>0) {
                            teacherScoreService.addDone5(scoreDone);
                            session.setAttribute("stu_number",stu_number);
                            session.setAttribute("year",year);

                            response.sendRedirect("get/item");
                        }
                    }
                    if(year-stu_year==1){
                        if(teacherScoreService.approval25(stu_number)>0){
                            teacherScoreService.addDone5(scoreDone);

                            session.setAttribute("stu_number",stu_number);
                            session.setAttribute("year",year);

                            response.sendRedirect("get/item");
                        }
                    }
                    if(year-stu_year==2){
                        if(teacherScoreService.approval35(stu_number)>0){
                            teacherScoreService.addDone5(scoreDone);
                            session.setAttribute("stu_number",stu_number);
                            session.setAttribute("year",year);

                            response.sendRedirect("get/item");

                        }
                    }
                    if(year-stu_year==3){
                        if(teacherScoreService.approval45(stu_number)>0){
                            teacherScoreService.addDone5(scoreDone);
                            session.setAttribute("stu_number",stu_number);
                            session.setAttribute("year",year);

                            response.sendRedirect("get/item");

                        }
                    }


                }
                if(moduleId==6){
                    scoreDone.setCxcy(items1.getCxcy());
                    scoreDone.setCxcyScoreTotalC1(items1.getCxcyScoreTotalC1());
                    scoreDone.setCxcyC1Competition(items1.getCxcyC1Competition());
                    scoreDone.setCxcyC1LevelGrade(items1.getCxcyC1LevelGrade());
                    scoreDone.setCxcySocialActivityC2(items1.getCxcySocialActivityC2());
                    scoreDone.setCxcySocialWorkC3(items1.getCxcySocialWorkC3());
                    if (year - stu_year == 0) {
                        if(teacherScoreService.approval16(stu_number)>0) {
                            teacherScoreService.addDone6(scoreDone);
                            session.setAttribute("stu_number",stu_number);
                            session.setAttribute("year",year);

                            response.sendRedirect("get/item");

                        }
                    }
                    if(year-stu_year==1){
                        if(teacherScoreService.approval26(stu_number)>0){
                            teacherScoreService.addDone6(scoreDone);
                            session.setAttribute("stu_number",stu_number);
                            session.setAttribute("year",year);

                            response.sendRedirect("get/item");

                        }
                    }
                    if(year-stu_year==2){
                        if(teacherScoreService.approval36(stu_number)>0){
                            teacherScoreService.addDone6(scoreDone);
                            session.setAttribute("stu_number",stu_number);
                            session.setAttribute("year",year);

                            response.sendRedirect("get/item");

                        }
                    }
                    if(year-stu_year==3){
                        if(teacherScoreService.approval46(stu_number)>0){
                            teacherScoreService.addDone6(scoreDone);
                            session.setAttribute("stu_number",stu_number);
                            session.setAttribute("year",year);

                            response.sendRedirect("get/item");
                        }
                    }


                }


            }
        else if(!is_approval) {
            scoreDone.setIsApproval(0);
            teacherScoreService.addDone(scoreDone);
            String reason= (String) map.get("reason");
            session.setAttribute("stu_number",stu_number);
            session.setAttribute("year",year);
           session.setAttribute("reason",reason);
           response.sendRedirect("not/approval");
        }


    }

    @RequestMapping("/batch/approval")

    public void batchApproval(@RequestBody Map<String,Object> map, HttpSession session,  HttpServletResponse response) throws IOException {
        int year = (int) map.get("year");
       List<String> list= (List<String>) map.get("list");
        boolean isApproval = (boolean) map.get("is_approval");
        Teacher t = (Teacher) session.getAttribute("teacher");
        int stu_year= (int) map.get("stu_year");
        int moduleId = t.getModuleId();
        ScoreDoneEntity scoreDone = new ScoreDoneEntity();
        scoreDone.setTeacher(t.getUsername());
        scoreDone.setYear(year);

            if (isApproval) {
                scoreDone.setIsApproval(1);
                for(String stu_number:list) {
                    ScoreEntity items1 = teacherScoreService.getItems1(year, stu_number);

                    scoreDone.setStuNumber(stu_number);
                    if (moduleId == 1) {
                        scoreDone.setDeyu(items1.getDeyu());
                        scoreDone.setDeyuBasicAssessD1(items1.getDeyuBasicAssessD1());
                        scoreDone.setDeyuOtherTotalD2(items1.getDeyuOtherTotalD2());
                        scoreDone.setDeyuD2GroupAssess(items1.getDeyuD2GroupAssess());
                        scoreDone.setDeyuD2SocialRespons(items1.getDeyuD2SocialRespons());
                        scoreDone.setDeyuD2PoliticalLearn(items1.getDeyuD2PoliticalLearn());
                        scoreDone.setDeyuD2MinusTotal(items1.getDeyuD2MinusTotal());
                        scoreDone.setDeyuD2HonorTotal(items1.getDeyuD2HonorTotal());
                        if (year - stu_year == 0) {
                            if (teacherScoreService.approval11(stu_number) > 0) {
                                teacherScoreService.addDone1(scoreDone);
                            }

                        }
                        if (year - stu_year == 1) {
                            if (teacherScoreService.approval21(stu_number) > 0) {
                                teacherScoreService.addDone1(scoreDone);


                            }
                        }
                        if (year - stu_year == 2) {
                            if (teacherScoreService.approval31(stu_number) > 0) {
                                teacherScoreService.addDone1(scoreDone);
                            }
                        }
                        if (year - stu_year == 3) {
                            if (teacherScoreService.approval41(stu_number) > 0) {
                                teacherScoreService.addDone1(scoreDone);
                            }
                        }

                    }

                    if (moduleId == 2) {
                        scoreDone.setZhiyu(items1.getZhiyu());
                        scoreDone.setZhiyuGPA(items1.getZhiyuGPA());
                        if (year - stu_year == 0) {
                            if (teacherScoreService.approval12(stu_number) > 0) {
                                teacherScoreService.addDone2(scoreDone);

                            }
                        }
                        if (year - stu_year == 1) {
                            if (teacherScoreService.approval22(stu_number) > 0) {
                                teacherScoreService.addDone2(scoreDone);
                            }
                        }
                        if (year - stu_year == 2) {
                            if (teacherScoreService.approval32(stu_number) > 0) {
                                teacherScoreService.addDone2(scoreDone);

                            }
                        }
                        if (year - stu_year == 3) {
                            if (teacherScoreService.approval42(stu_number) > 0) {
                                teacherScoreService.addDone2(scoreDone);

                            }
                        }


                    }

                    if (moduleId == 3) {
                        scoreDone.setTiyu(items1.getTiyu());
                        scoreDone.setTiyuScoreTotalT1(items1.getTiyuScoreTotalT1());
                        scoreDone.setTiyuT1Score1(items1.getTiyuT1Score1());
                        scoreDone.setTiyuT1Score2(items1.getTiyuT1Score2());
                        scoreDone.setTiyuOtherTotalT2(items1.getTiyuOtherTotalT2());
                        scoreDone.setTiyuT2Races(items1.getTiyuT2Races());
                        scoreDone.setTiyuT2EarlyExercise(items1.getTiyuT2EarlyExercise());
                        if (year - stu_year == 0) {
                            if (teacherScoreService.approval13(stu_number) > 0) {
                                teacherScoreService.addDone3(scoreDone);
                            }
                        }
                        if (year - stu_year == 1) {
                            if (teacherScoreService.approval23(stu_number) > 0) {
                                teacherScoreService.addDone3(scoreDone);

                            }
                        }
                        if (year - stu_year == 2) {
                            if (teacherScoreService.approval33(stu_number) > 0) {
                                teacherScoreService.addDone3(scoreDone);
                            }
                        }
                        if (year - stu_year == 3) {
                            if (teacherScoreService.approval43(stu_number) > 0) {
                                teacherScoreService.addDone3(scoreDone);

                            }
                        }
                    }

                    if (moduleId == 4) {
                        scoreDone.setMeiyu(items1.getMeiyu());
                        scoreDone.setMeiyuPracticeM1(items1.getMeiyuPracticeM1());
                        scoreDone.setMeiyuCompetitionM2(items1.getMeiyuCompetitionM2());
                        if (year - stu_year == 0) {
                            if (teacherScoreService.approval14(stu_number) > 0) {
                                teacherScoreService.addDone4(scoreDone);

                            }
                        }
                        if (year - stu_year == 1) {
                            if (teacherScoreService.approval24(stu_number) > 0) {
                                teacherScoreService.addDone4(scoreDone);
                            }
                        }
                        if (year - stu_year == 2) {
                            if (teacherScoreService.approval34(stu_number) > 0) {
                                teacherScoreService.addDone4(scoreDone);
                            }
                        }
                        if (year - stu_year == 3) {
                            if (teacherScoreService.approval44(stu_number) > 0) {
                                teacherScoreService.addDone4(scoreDone);
                            }
                        }


                    }
                    if (moduleId == 5) {
                        scoreDone.setLaoyu(items1.getLaoyu());
                        scoreDone.setLaoyuDailyTotalL1(items1.getLaoyuDailyTotalL1());
                        scoreDone.setLaoyuL1RoomActivity(items1.getLaoyuL1RoomActivity());
                        scoreDone.setLaoyuL1RoomDaily(items1.getLaoyuL1RoomDaily());
                        scoreDone.setLaoyuL1RoomPerform(items1.getLaoyuL1RoomPerform());
                        scoreDone.setLaoyuVolunteerL2(items1.getLaoyuVolunteerL2());
                        scoreDone.setLaoyuInternshipL3(items1.getLaoyuInternshipL3());
                        if (year - stu_year == 0) {
                            if (teacherScoreService.approval15(stu_number) > 0) {
                                teacherScoreService.addDone5(scoreDone);
                            }
                        }
                        if (year - stu_year == 1) {
                            if (teacherScoreService.approval25(stu_number) > 0) {
                                teacherScoreService.addDone5(scoreDone);
                            }
                        }
                        if (year - stu_year == 2) {
                            if (teacherScoreService.approval35(stu_number) > 0) {
                                teacherScoreService.addDone5(scoreDone);

                            }
                        }
                        if (year - stu_year == 3) {
                            if (teacherScoreService.approval45(stu_number) > 0) {
                                teacherScoreService.addDone5(scoreDone);

                            }
                        }


                    }
                    if (moduleId == 6) {
                        scoreDone.setCxcy(items1.getCxcy());
                        scoreDone.setCxcyScoreTotalC1(items1.getCxcyScoreTotalC1());
                        scoreDone.setCxcyC1Competition(items1.getCxcyC1Competition());
                        scoreDone.setCxcyC1LevelGrade(items1.getCxcyC1LevelGrade());
                        scoreDone.setCxcySocialActivityC2(items1.getCxcySocialActivityC2());
                        scoreDone.setCxcySocialWorkC3(items1.getCxcySocialWorkC3());
                        if (year - stu_year == 0) {
                            if (teacherScoreService.approval16(stu_number) > 0) {
                                teacherScoreService.addDone6(scoreDone);

                            }
                        }
                        if (year - stu_year == 1) {
                            if (teacherScoreService.approval26(stu_number) > 0) {
                                teacherScoreService.addDone6(scoreDone);
                            }
                        }
                        if (year - stu_year == 2) {
                            if (teacherScoreService.approval36(stu_number) > 0) {
                                teacherScoreService.addDone6(scoreDone);
                            }
                        }
                        if (year - stu_year == 3) {
                            if (teacherScoreService.approval46(stu_number) > 0) {
                                teacherScoreService.addDone6(scoreDone);

                            }
                        }


                    }
                }

               session.setAttribute("list",list);
                session.setAttribute("year",year);
                response.sendRedirect("/api/teacher/get/batch/item");

            }
            else if (!isApproval) {
                scoreDone.setIsApproval(0);
                teacherScoreService.addDone(scoreDone);
                String reason = (String) map.get("reason");
                session.setAttribute("list",list);
                session.setAttribute("year",year);
                session.setAttribute("reason", reason);
                response.sendRedirect("/api/teacher/not/batch/approval");

            }



    }



    @RequestMapping("/not/approval")
    @ResponseBody
    public Result notApproval (HttpSession session){
        Teacher t= (Teacher) session.getAttribute("teacher");
        int moduleId= t.getModuleId();

        String reason= (String) session.getAttribute("reason");
             String stu_number= (String) session.getAttribute("stu_number");
             int year=(int) session.getAttribute("year");
             ScoreEntity r=new ScoreEntity();
             r.setStuNumber(stu_number);
             r.setYear(year);
             if(moduleId==1) {
                 reason="德育:\n"+reason;
                 r.setReason1(reason);
                 teacherScoreService.setReason1(r);
             }
             if(moduleId==2) {
                 reason="智育:"+reason;
                 r.setReason2(reason);
                 teacherScoreService.setReason2(r);
             }
             if(moduleId==3){
                 reason="体育:"+reason;
                 r.setReason3(reason);
                 teacherScoreService.setReason3(r);
             }
             if(moduleId==4) {
                 reason="美育:"+reason;
                 r.setReason4(reason);
                 teacherScoreService.setReason4(r);
             }
             if(moduleId==5) {
                 reason="劳育:"+reason;
                 r.setReason5(reason);
                 teacherScoreService.setReason5(r);
             }
             if(moduleId==6){
                 reason="创新创业:"+reason;
                 r.setReason6(reason);
                 teacherScoreService.setReason6(r);
             }


        return new Result(Code.APPROVAL_ERR,reason,"审批未通过！");
    }

    @RequestMapping("/not/batch/approval")
    @ResponseBody
    public Result notBatchApproval (HttpSession session){
        Teacher t= (Teacher) session.getAttribute("teacher");
        int moduleId= t.getModuleId();

        List<String> list= (List<String>) session.getAttribute("list");
        String reason= (String) session.getAttribute("reason");
        int year=(int) session.getAttribute("year");

        ScoreEntity r = new ScoreEntity();

        r.setYear(year);
        for(String stu_number:list) {
            r.setStuNumber(stu_number);
            if(moduleId==1) {
                reason="德育:"+reason;
                r.setReason1(reason);
                teacherScoreService.setReason1(r);
            }
            if(moduleId==2) {
                reason="智育:"+reason;
                r.setReason2(reason);
                teacherScoreService.setReason2(r);
            }
            if(moduleId==3){
                reason="体育:"+reason;
                r.setReason3(reason);
                teacherScoreService.setReason3(r);
            }
            if(moduleId==4) {
                reason="美育:"+reason;
                r.setReason4(reason);
                teacherScoreService.setReason4(r);
            }
            if(moduleId==5) {
                reason="劳育:"+reason;
                r.setReason5(reason);
                teacherScoreService.setReason5(r);
            }
            if(moduleId==6){
                reason="创新创业:"+reason;
                r.setReason6(reason);
                teacherScoreService.setReason6(r);
            }


        }
        return new Result(Code.APPROVAL_ERR,reason,"审批未通过！");
    }
//    @RequestMapping("/withdraw/approval")
//    @ResponseBody
//    public Result withdrawApproval(@RequestBody ScoreDoneEntity scoredone,HttpSession session, HttpServletResponse response){
//        Teacher t= (Teacher) session.getAttribute("teacher");
//        String stu_number=scoredone.getStu_number();
//        int year=scoredone.getYear();
//        StuInfoEntity stu=stuservice.selectByNumber(stu_number);
//
//        int stu_year=stu.getStu_year();
//        int moduleId=t.getModuleId();
//        String teacher=t.getUsername();
//        scoredone.setTeacher(teacher);
//        if(moduleId==1){
//            if(year-stu_year==0){
//                if(teacherScoreService.wdapproval11(stu_number)>0){
//                    teacherScoreService.deleteDone(scoredone);
//                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
//                }
//                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
//            }
//            if(year-stu_year==1){
//                if(teacherScoreService.wdapproval21(stu_number)>0){
//                    teacherScoreService.deleteDone(scoredone);
//                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
//                }
//                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
//            }
//            if(year-stu_year==2){
//                if(teacherScoreService.wdapproval31(stu_number)>0){
//                    teacherScoreService.deleteDone(scoredone);
//                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
//                }
//                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
//            }
//            if(year-stu_year==3){
//                if(teacherScoreService.wdapproval41(stu_number)>0){
//                    teacherScoreService.deleteDone(scoredone);
//                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
//                }
//                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
//            }
//
//        }
//        if(moduleId==2){
//            if(year-stu_year==0){
//                if(teacherScoreService.wdapproval12(stu_number)>0){
//                    teacherScoreService.deleteDone(scoredone);
//                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
//                }
//                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
//            }
//            if(year-stu_year==1){
//                if(teacherScoreService.wdapproval22(stu_number)>0){
//                    teacherScoreService.deleteDone(scoredone);
//                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
//                }
//                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
//            }
//            if(year-stu_year==2){
//                if(teacherScoreService.wdapproval32(stu_number)>0){
//                    teacherScoreService.deleteDone(scoredone);
//                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
//                }
//                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
//            }
//            if(year-stu_year==3){
//                if(teacherScoreService.wdapproval42(stu_number)>0){
//                    teacherScoreService.deleteDone(scoredone);
//                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
//                }
//                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
//            }
//
//        }
//        if(moduleId==3){
//            if(year-stu_year==0){
//                if(teacherScoreService.wdapproval13(stu_number)>0){
//                    teacherScoreService.deleteDone(scoredone);
//                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
//                }
//                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
//            }
//            if(year-stu_year==1){
//                if(teacherScoreService.wdapproval23(stu_number)>0){
//                    teacherScoreService.deleteDone(scoredone);
//                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
//                }
//                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
//            }
//            if(year-stu_year==2){
//                if(teacherScoreService.wdapproval33(stu_number)>0){
//                    teacherScoreService.deleteDone(scoredone);
//                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
//                }
//                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
//            }
//            if(year-stu_year==3){
//                if(teacherScoreService.wdapproval43(stu_number)>0){
//                    teacherScoreService.deleteDone(scoredone);
//                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
//                }
//                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
//            }
//
//        }
//        if(moduleId==4){
//            if(year-stu_year==0){
//                if(teacherScoreService.wdapproval14(stu_number)>0){
//                    teacherScoreService.deleteDone(scoredone);
//                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
//                }
//                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
//            }
//            if(year-stu_year==1){
//                if(teacherScoreService.wdapproval24(stu_number)>0){
//                    teacherScoreService.deleteDone(scoredone);
//                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
//                }
//                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
//            }
//            if(year-stu_year==2){
//                if(teacherScoreService.wdapproval34(stu_number)>0){
//                    teacherScoreService.deleteDone(scoredone);
//                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
//                }
//                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
//            }
//            if(year-stu_year==3){
//                if(teacherScoreService.wdapproval44(stu_number)>0){
//                    teacherScoreService.deleteDone(scoredone);
//                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
//                }
//                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
//            }
//
//        }
//        if(moduleId==5){
//            if(year-stu_year==0){
//                if(teacherScoreService.wdapproval15(stu_number)>0){
//                    teacherScoreService.deleteDone(scoredone);
//                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
//                }
//                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
//            }
//            if(year-stu_year==1){
//                if(teacherScoreService.wdapproval25(stu_number)>0){
//                    teacherScoreService.deleteDone(scoredone);
//                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
//                }
//                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
//            }
//            if(year-stu_year==2){
//                if(teacherScoreService.wdapproval35(stu_number)>0){
//                    teacherScoreService.deleteDone(scoredone);
//                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
//                }
//                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
//            }
//            if(year-stu_year==3){
//                if(teacherScoreService.wdapproval45(stu_number)>0){
//                    teacherScoreService.deleteDone(scoredone);
//                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
//                }
//                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
//            }
//
//        }
//        if(moduleId==6){
//            if(year-stu_year==0){
//                if(teacherScoreService.wdapproval16(stu_number)>0){
//                    teacherScoreService.deleteDone(scoredone);
//                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
//                }
//                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
//            }
//            if(year-stu_year==1){
//                if(teacherScoreService.wdapproval26(stu_number)>0){
//                    teacherScoreService.deleteDone(scoredone);
//                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
//                }
//                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
//            }
//            if(year-stu_year==2){
//                if(teacherScoreService.wdapproval36(stu_number)>0){
//                    teacherScoreService.deleteDone(scoredone);
//                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
//                }
//                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
//            }
//            if(year-stu_year==3){
//                if(teacherScoreService.wdapproval46(stu_number)>0){
//                    teacherScoreService.deleteDone(scoredone);
//                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
//                }
//                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
//            }
//
//        }
//
//        return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
//    }


    @RequestMapping("/withdraw/approval")
    @ResponseBody
    public Result withdrawApproval(@RequestBody ScoreDoneEntity scoreDone,HttpSession session, HttpServletResponse response){
        Teacher t= (Teacher) session.getAttribute("teacher");
        String stuNumber=scoreDone.getStuNumber();
        int year=scoreDone.getYear();
        StuInfoEntity stu= stuService.selectByNumber(stuNumber);

        int stuYear=stu.getStuYear();
        int moduleId=t.getModuleId();
        String teacher=t.getUsername();
        scoreDone.setTeacher(teacher);
        if(moduleId==1){
            if(year-stuYear==0){
                if(teacherScoreService.wdapproval11(stuNumber)>0){
                    teacherScoreService.deleteDone(scoreDone);
                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
                }
                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
            }
            if(year-stuYear==1){
                if(teacherScoreService.wdapproval21(stuNumber)>0){
                    teacherScoreService.deleteDone(scoreDone);
                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
                }
                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
            }
            if(year-stuYear==2){
                if(teacherScoreService.wdapproval31(stuNumber)>0){
                    teacherScoreService.deleteDone(scoreDone);
                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
                }
                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
            }
            if(year-stuYear==3){
                if(teacherScoreService.wdapproval41(stuNumber)>0){
                    teacherScoreService.deleteDone(scoreDone);
                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
                }
                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
            }

        }
        if(moduleId==2){
            if(year-stuYear==0){
                if(teacherScoreService.wdapproval12(stuNumber)>0){
                    teacherScoreService.deleteDone(scoreDone);
                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
                }
                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
            }
            if(year-stuYear==1){
                if(teacherScoreService.wdapproval22(stuNumber)>0){
                    teacherScoreService.deleteDone(scoreDone);
                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
                }
                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
            }
            if(year-stuYear==2){
                if(teacherScoreService.wdapproval32(stuNumber)>0){
                    teacherScoreService.deleteDone(scoreDone);
                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
                }
                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
            }
            if(year-stuYear==3){
                if(teacherScoreService.wdapproval42(stuNumber)>0){
                    teacherScoreService.deleteDone(scoreDone);
                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
                }
                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
            }

        }
        if(moduleId==3){
            if(year-stuYear==0){
                if(teacherScoreService.wdapproval13(stuNumber)>0){
                    teacherScoreService.deleteDone(scoreDone);
                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
                }
                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
            }
            if(year-stuYear==1){
                if(teacherScoreService.wdapproval23(stuNumber)>0){
                    teacherScoreService.deleteDone(scoreDone);
                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
                }
                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
            }
            if(year-stuYear==2){
                if(teacherScoreService.wdapproval33(stuNumber)>0){
                    teacherScoreService.deleteDone(scoreDone);
                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
                }
                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
            }
            if(year-stuYear==3){
                if(teacherScoreService.wdapproval43(stuNumber)>0){
                    teacherScoreService.deleteDone(scoreDone);
                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
                }
                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
            }

        }
        if(moduleId==4){
            if(year-stuYear==0){
                if(teacherScoreService.wdapproval14(stuNumber)>0){
                    teacherScoreService.deleteDone(scoreDone);
                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
                }
                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
            }
            if(year-stuYear==1){
                if(teacherScoreService.wdapproval24(stuNumber)>0){
                    teacherScoreService.deleteDone(scoreDone);
                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
                }
                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
            }
            if(year-stuYear==2){
                if(teacherScoreService.wdapproval34(stuNumber)>0){
                    teacherScoreService.deleteDone(scoreDone);
                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
                }
                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
            }
            if(year-stuYear==3){
                if(teacherScoreService.wdapproval44(stuNumber)>0){
                    teacherScoreService.deleteDone(scoreDone);
                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
                }
                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
            }

        }
        if(moduleId==5){
            if(year-stuYear==0){
                if(teacherScoreService.wdapproval15(stuNumber)>0){
                    teacherScoreService.deleteDone(scoreDone);
                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
                }
                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
            }
            if(year-stuYear==1){
                if(teacherScoreService.wdapproval25(stuNumber)>0){
                    teacherScoreService.deleteDone(scoreDone);
                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
                }
                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
            }
            if(year-stuYear==2){
                if(teacherScoreService.wdapproval35(stuNumber)>0){
                    teacherScoreService.deleteDone(scoreDone);
                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
                }
                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
            }
            if(year-stuYear==3){
                if(teacherScoreService.wdapproval45(stuNumber)>0){
                    teacherScoreService.deleteDone(scoreDone);
                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
                }
                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
            }

        }
        if(moduleId==6){
            if(year-stuYear==0){
                if(teacherScoreService.wdapproval16(stuNumber)>0){
                    teacherScoreService.deleteDone(scoreDone);
                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
                }
                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
            }
            if(year-stuYear==1){
                if(teacherScoreService.wdapproval26(stuNumber)>0){
                    teacherScoreService.deleteDone(scoreDone);
                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
                }
                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
            }
            if(year-stuYear==2){
                if(teacherScoreService.wdapproval36(stuNumber)>0){
                    teacherScoreService.deleteDone(scoreDone);
                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
                }
                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
            }
            if(year-stuYear==3){
                if(teacherScoreService.wdapproval46(stuNumber)>0){
                    teacherScoreService.deleteDone(scoreDone);
                    return new Result(Code.WITHDRAW_APPROVAL_OK,true,"撤回成功！");
                }
                return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
            }

        }

        return new Result(Code.WITHDRAW_APPROVAL_ERR,false,"撤回失败！");
    }


    @RequestMapping("/get/approved/list")
    @ResponseBody
    public Result getApprovedList (HttpSession session){
      Teacher t = (Teacher) session.getAttribute("teacher");
      List<ScoreDoneEntity> approvedList = teacherScoreService.getApprovedList(t.getUsername());
      if(approvedList!=null){
          return new Result(Code.GET_APPROVED_LIST_OK,approvedList,"获取已审批记录成功！");
      }
      return new Result(Code.GET_APPROVED_LIST_ERR,null,"获取已审批记录失败！");
  }

    @RequestMapping("/get/pictures")
    @ResponseBody
    public Result getPictures(@RequestBody Map<String,Object> map,HttpSession session){
        int year= (int) map.get("year");
        String stuNumber= (String) map.get("stu_number");
        Teacher t= (Teacher) session.getAttribute("teacher");
        int moduleId=t.getModuleId();
        List<String> pictures=teacherScoreService.getPictures(stuNumber,year,moduleId);
        if(pictures !=null){
            return new Result(Code.GET_PICTURES_OK,pictures,"获取图片成功！");
        }
        return new Result(Code.GET_PICTURES_ERR,null,"获取图片失败！");
    }

    @RequestMapping("/get/content")
    @ResponseBody
    public Result getContent(@RequestBody Map<String,Object> map,HttpSession session){
        int year= (int) map.get("year");
        String stuNumber= (String) map.get("stu_number");
        Teacher t= (Teacher) session.getAttribute("teacher");
        int moduleId=t.getModuleId();
        String content= teacherScoreService.getContent(stuNumber,year,moduleId);
        if(content !=null){
            return new Result(Code.GET_CONTENT_OK,content,"获取内容成功！");
        }
        return new Result(Code.GET_CONTENT_ERR,null,"获取内容失败！");
    }

}
