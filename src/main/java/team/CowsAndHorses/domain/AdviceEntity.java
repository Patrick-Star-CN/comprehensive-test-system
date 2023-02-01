package  team.CowsAndHorses.domain;

import lombok.Builder;
import lombok.Data;

@Data

public class AdviceEntity {
    private int id;
    private String stuNumber;
    private String stuContent;
    private String teacherContent;
    private int status;

    public AdviceEntity() {
    }

    @Override
    public String toString() {
        return "AdviceEntity{" +
                "id=" + id +
                ", stu_number='" + stuNumber + '\'' +
                ", stu_content='" + stuContent + '\'' +
                ", teacher_content='" + teacherContent + '\'' +
                ", status=" + status +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStuNumber() {
        return stuNumber;
    }

    public void setStuNumber(String stuNumber) {
        this.stuNumber = stuNumber;
    }

    public String getStuContent() {
        return stuContent;
    }

    public void setStuContent(String stuContent) {
        this.stuContent = stuContent;
    }

    public String getTeacherContent() {
        return teacherContent;
    }

    public void setTeacherContent(String teacherContent) {
        this.teacherContent = teacherContent;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
