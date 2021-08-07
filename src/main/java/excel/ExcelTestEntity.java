package excel;

import lombok.Data;

import java.util.List;

/**
 * @author by mubai
 * @Classname ExcelTestEntiry
 * @Description
 * @Date 2021/8/7 10:48
 */
@Data
public class ExcelTestEntity {

    private String id;
    private String name;
    private Integer level;
    private List<ExcelTestEntity> children;

    public ExcelTestEntity(String id, String name, Integer level) {
        this.id = id;
        this.name = name;
        this.level = level;
    }
}
