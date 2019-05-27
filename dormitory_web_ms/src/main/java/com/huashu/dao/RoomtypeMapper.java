package com.huashu.dao;

import com.huashu.pojo.Roomtype;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @ClassName RoomtypeMapper
 * @Description 房间类型的持久类
 * @Author Administrator
 * @Date 2019/2/26 14:06
 * @Version 1.0
 */
@Mapper
public interface RoomtypeMapper {
    public List<Roomtype> findAllBySearch(Map map);
}
