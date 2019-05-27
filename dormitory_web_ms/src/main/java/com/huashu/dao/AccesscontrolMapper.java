package com.huashu.dao;

import com.huashu.pojo.Accesscontrol;
import entity.accesscontrol.AccesscontrolVo;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName AccesscontrolMapper
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/2 22:11
 * @Version 1.0
 */
@Mapper
public interface AccesscontrolMapper {

    List<AccesscontrolVo> findAllAccesscontrolBySearch(Map map);

}
