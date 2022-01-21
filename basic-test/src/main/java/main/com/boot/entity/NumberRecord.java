package main.com.boot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author mubai
 * @since 2021-11-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("wbt_number_record")
public class NumberRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 万
     */
    private Integer num1;

    /**
     * 千
     */
    private Integer num2;

    /**
     * 百
     */
    private Integer num3;

    /**
     * 十
     */
    private Integer num4;

    /**
     * 个
     */
    private Integer num5;

    /**
     * 记录key，唯一值
     */
    private String recordKey;

    /**
     * 求余结果，求余失败为空
     */
    private Integer ysNum;


}
