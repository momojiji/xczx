package com.huashu.dao.util;

import com.huashu.pojo.Dormitory;
import com.huashu.pojo.Resource;
import com.huashu.pojo.Room;
import org.apache.commons.lang.StringUtils;

/**
 * @Auther: wyan
 * @Date: 2019/1/11 23:08
 * @Description: 组装使用的sql的类
 */
public class SqlProvider {

    //根据room对象组装使用的sql
   public static  String getFindRoomByModel(Room room){
       String sql = "select * from tb_room where 1=1 ";
       if(null!=room){
           if(StringUtils.isNotEmpty(room.getRoomcode())){
               sql+= " and roomcode = #{roomcode} ";
           }
       }
       return sql;
   }

    public static String getFindResourceByModel(Resource resource) {
        String sql = "select * from tb_resource  where 1=1 ";
        if(null!=resource){
            if(StringUtils.isNotEmpty(resource.getResourcenum() )){
                sql+= " and resourcenum = #{resourcenum} ";
            }
        }
        return sql;
    }
}
