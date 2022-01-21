package main.com.boot.mapper;

import main.com.boot.entity.NumberRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mubai
 * @since 2021-11-26
 */
public interface NumberRecordMapper extends BaseMapper<NumberRecord> {
    List<NumberRecord> getRecentNum();
}
