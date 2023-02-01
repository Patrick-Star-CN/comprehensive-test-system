package  team.CowsAndHorses.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Teacher {
    private String username;
    private String password;
    private String college;
    private Integer moduleId;

    public Teacher() {
    }

    public Teacher(String username, String password, String college, Integer moduleId) {
        this.username = username;
        this.password = password;
        this.college = college;
        this.moduleId = moduleId;
    }

    @Override
    public String toString() {
        return "teacher{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", college='" + college + '\'' +
                ", moduleId=" + moduleId +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }
}
