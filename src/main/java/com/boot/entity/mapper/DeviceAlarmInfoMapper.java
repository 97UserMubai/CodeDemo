package com.boot.entity.mapper;

import com.boot.entity.DeviceAlarmInfo;
import com.boot.entity.DeviceAlarmInfoExample;
import java.util.List;
import org.springframework.data.repository.query.Param;

public interface DeviceAlarmInfoMapper {
    int countByExample(DeviceAlarmInfoExample example);

    int deleteByExample(DeviceAlarmInfoExample example);

    int deleteByPrimaryKey(Long pkid);

    int insert(DeviceAlarmInfo record);

    int insertSelective(DeviceAlarmInfo record);

    List<DeviceAlarmInfo> selectByExample(DeviceAlarmInfoExample example);

    DeviceAlarmInfo selectByPrimaryKey(Long pkid);

    int updateByExampleSelective(@Param("record") DeviceAlarmInfo record, @Param("example") DeviceAlarmInfoExample example);

    int updateByExample(@Param("record") DeviceAlarmInfo record, @Param("example") DeviceAlarmInfoExample example);

    int updateByPrimaryKeySelective(DeviceAlarmInfo record);

    int updateByPrimaryKey(DeviceAlarmInfo record);
}