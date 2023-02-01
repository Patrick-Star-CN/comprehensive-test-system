package  team.CowsAndHorses.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StuInfoEntity implements Serializable {
    private static final long serialVersionUID = -1;
    private int id;
    private String stuNumber; //学号
    private String stuPassword;
    private String stuName;
    private String stuGender;
    private String stuCollege; //学院
    private String stuClass;  //专业班级
    private int stuYear; //入学年份
    private int isFirst1;
    private int isFirst2;
    private int isFirst3;
    private int isFirst4;
    private int isFirst5;
    private int isFirst6;
    private int isSecond1;
    private int isSecond2;
    private int isSecond3;
    private int isSecond4;
    private int isSecond5;
    private int isSecond6;

    private int isThird1;
    private int isThird2;
    private int isThird3;
    private int isThird4;
    private int isThird5;
    private int isThird6;
    private int isForth1;
    private int isForth2;
    private int isForth3;
    private int isForth4;
    private int isForth5;
    private int isForth6;

    @Override
    public String toString() {
        return "StuInfoEntity{" +
                "id=" + id +
//                ", stu_id=" + stuId +
                ", stu_number='" + stuNumber + '\'' +
                ", stu_password='" + stuPassword + '\'' +
                ", stu_name='" + stuName + '\'' +
                ", stu_gender='" + stuGender + '\'' +
                ", stu_college='" + stuCollege + '\'' +
                ", stu_class='" + stuClass + '\'' +
                ", stu_year=" + stuYear +
                ", is_first1=" + isFirst1 +
                ", is_first2=" + isFirst2 +
                ", is_first3=" + isFirst3 +
                ", is_first4=" + isFirst4 +
                ", is_first5=" + isFirst5 +
                ", is_first6=" + isFirst6 +
                ", is_second1=" + isSecond1 +
                ", is_second2=" + isSecond2 +
                ", is_second3=" + isSecond3 +
                ", is_second4=" + isSecond4 +
                ", is_second5=" + isSecond5 +
                ", is_second6=" + isSecond6 +
                ", is_third1=" + isThird1 +
                ", is_third2=" + isThird2 +
                ", is_third3=" + isThird3 +
                ", is_third4=" + isThird4 +
                ", is_third5=" + isThird5 +
                ", is_third6=" + isThird6 +
                ", is_forth1=" + isForth1 +
                ", is_forth2=" + isForth2 +
                ", is_forth3=" + isForth3 +
                ", is_forth4=" + isForth4 +
                ", is_forth5=" + isForth5 +
                ", is_forth6=" + isForth6 +
                '}';
    }
}
