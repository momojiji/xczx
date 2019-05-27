package com.huashu.dao;

import com.huashu.pojo.Dormitory;
import com.huashu.pojo.Room;
import entity.dormitory.DormitoryVo;
import entity.dormitory.RoomVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Auther: wyan
 * @Date: 2019/1/11 01:39
 * @Description:
 */
@Mapper
public interface RoomMapper {




    @Update("update tb_room set isvalidate = 1 where id = #{roomId}")
    void deleteById(String roomId);


    @Select("select ID, roomname, roomnum, roomcode, roomtypeid, dormitoryid, sextype, status, isvalidate, remarks, creator, createdate, modifitor, modifiedate from tb_room where 1=1 order by id desc ")
    List<Room> findAllRecord(Room room);

    DormitoryVo findDormitoryVoById(String roomId);

    List<Room> findPageRommJson(Room room);

    @Select("select * from tb_room where roomname=#{roomname} and dormitoryid=#{dormitoryid}")
    Room findByNameAndParent(@Param("roomname") String roomname, @Param("dormitoryid")String dormitoryid);
}
