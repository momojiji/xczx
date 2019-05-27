package com.huashu.dao;

import com.huashu.pojo.Location;
import entity.LocationVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Auther: wyan
 * @Date: 2019/4/24 21:18
 * @Description:
 */
@Mapper
public interface LocationMapper {


    @Select("select l.*,d.dormitoryname buildname from tb_location l,tb_dormitory d where l.buildid = d.id")
    List<LocationVo> findAll();

    @Select("select * from tb_location where id = #{id}")
    Location findById(String id);

    @Insert("insert into tb_location values(#{id},#{gdLat},#{gdLon},#{locationNum},#{buildid})")
    void save(Location location);

    @Update("update  tb_location set gdLat=#{gdLat},gdLon=#{gdLon},locatioNum=#{locationNum},buildid=#{buildid}" +
            " where id = #{id}")
    void update(Location location);

    @Delete("delete from tb_location where id = #{id}")
    void deleteById(String id);
}
