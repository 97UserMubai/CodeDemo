package main.com.boot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import main.com.boot.entity.NumberRecord;
import main.com.boot.mapper.NumberRecordMapper;
import main.com.boot.service.INumberRecordService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author mubai
 * @since 2021-11-26
 */
@Service
public class NumberRecordServiceImpl extends ServiceImpl<NumberRecordMapper, NumberRecord> implements INumberRecordService {

}
