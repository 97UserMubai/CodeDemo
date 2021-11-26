package com.boot.test.service.impl;

import com.boot.test.entity.NumberRecord;
import com.boot.test.mapper.NumberRecordMapper;
import com.boot.test.service.INumberRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mubai
 * @since 2021-11-26
 */
@Service
public class NumberRecordServiceImpl extends ServiceImpl<NumberRecordMapper, NumberRecord> implements INumberRecordService {

}
