package  team.CowsAndHorses.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReasonEntity {
    private int id;
    private String content;

    @Override
    public String toString() {
        return "ReasonEntity{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
