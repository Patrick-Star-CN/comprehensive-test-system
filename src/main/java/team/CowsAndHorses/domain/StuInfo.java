package  team.CowsAndHorses.domain;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class StuInfo {
    @TableId(type = IdType.AUTO)
    private int id;
    private String stuNumber;
    private String stuPassword;
    private String stuName;
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private Boolean stuGender;
    private String stuCollege;
    private String stuClass;
    private Integer stuYear;

    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private Boolean isFirst1;
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private Boolean isFirst2;
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private Boolean isFirst3;
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private Boolean isFirst4;
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private Boolean isFirst5;
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private Boolean isFirst6;

    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private Boolean isSecond1;
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private Boolean isSecond2;
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private Boolean isSecond3;
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private Boolean isSecond4;
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private Boolean isSecond5;
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private Boolean isSecond6;

    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private Boolean isThird1;
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private Boolean isThird2;
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private Boolean isThird3;
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private Boolean isThird4;
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private Boolean isThird5;
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private Boolean isThird6;

    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private Boolean isForth1;
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private Boolean isForth2;
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private Boolean isForth3;
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private Boolean isForth4;
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private Boolean isForth5;
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private Boolean isForth6;
}
