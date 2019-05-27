package com.huashu.dao;

import com.huashu.pojo.Appbannel;
import com.huashu.pojo.Classinfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName AppbannelMapper
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/1 16:48
 * @Version 1.0
 */
@Mapper
public interface AppbannelMapper {

    List<Appbannel> findAllAppbannelBySearch(Appbannel appbannel);
}
