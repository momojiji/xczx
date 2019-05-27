package com.huashu.dao;

import com.huashu.pojo.Checksleep;
import entity.worksleep.WorkSleepListVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName ChecksleepMapper
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/1 18:28
 * @Version 1.0
 */
@Mapper
public interface ChecksleepMapper {
    List<WorkSleepListVo> findAllChecksleepBySearch(Checksleep checksleep);
}
