package com.huashu.dao;

import com.huashu.pojo.Allocation;
import com.huashu.pojo.AllocationStudent;
import com.huashu.pojo.Room;
import entity.dormitory.AllocationMgrVo;
import entity.dormitory.RoomStudentVo;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @Auther: wyan
 * @Date: 2019/1/11 01:39
 * @Description:
 */
@Mapper
public interface AllocationMapper {


    List<RoomStudentVo> findRoomStudent(String roomId);

    void updateAlocationValid(RoomStudentVo rv);

    void updateAlocationAble(String allocationId);

    void updateAlocationDisAble(String allocation_id);

    List<AllocationMgrVo> findAllocationsByParams(Map<String, String> map);

    Allocation findEditAllocation(String alId);

    void deleteAlocationValid(String alId);

    @Select("select * from tb_allocation where roomid=#{roomid} and dormitoryid=#{dormitoryid}")
    Allocation findByRoomIdAndDormitoryId(@Param("roomid")String roomid, @Param("dormitoryid")String dormitoryid);

    @Select("select * from tb_allocation_student where allocation_id=#{allocation_id} and studentid=#{studentid} and status = 0 ")
    AllocationStudent findByAlIdAndStudentId(@Param("allocation_id")String allocation_id, @Param("studentid") String studentid);
}
