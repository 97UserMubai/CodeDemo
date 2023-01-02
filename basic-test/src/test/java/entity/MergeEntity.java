package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname MergeEntity
 * @Description TODO
 * @Date 2023-1-2 20:42
 * @Created by mubai
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MergeEntity {
    private int firstRow;
    private int lastRow;
    private int firstCol;
    private int lastCol;
}
