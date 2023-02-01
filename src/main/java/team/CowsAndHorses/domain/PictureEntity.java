package  team.CowsAndHorses.domain;

import lombok.Builder;
import lombok.Data;

@Data

public class PictureEntity {
    private int id;
    private String photo;
    private int moduleId;
    private String stuNumber;
    private int year;

    @Override
    public String toString() {
        return "PictureEntity{" +
                "id=" + id +
                ", photo='" + photo + '\'' +
                ", moduleId=" + moduleId +
                ", stu_number='" + stuNumber + '\'' +
                ", year=" + year +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public String getStuNumber() {
        return stuNumber;
    }

    public void setStuNumber(String stuNumber) {
        this.stuNumber = stuNumber;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
