package team.CowsAndHorses.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface AdviceService {

    public int submint(@Param("stu_number") String stuNumber, @Param("stu_content")String stuContent, @Param("teacher_content")String teacherContent, @Param("status")int status);
}
