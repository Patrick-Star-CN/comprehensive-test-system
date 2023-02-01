package  team.CowsAndHorses.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AppealEntity {
    private int id;
    private int year;
    private String stuNumber;
    private int moduleId;
    private String content;
    private int isApproval;
    private String status;

    @Override
    public String toString() {
        return "AppealEntity{" +
                "id=" + id +
                ", year=" + year +
                ", stu_number='" + stuNumber + '\'' +
                ", module_id=" + moduleId +
                ", content='" + content + '\'' +
                ", is_approval=" + isApproval +
                ", status='" + status + '\'' +
                '}';
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int isIs_approval() {
        return isApproval;
    }

    public void setIsApproval(int isApproval) {
        this.isApproval = isApproval;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }
}
