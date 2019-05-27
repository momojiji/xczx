package com.huashu.dao;

import com.huashu.pojo.Visitor;
import com.huashu.pojo.Workorder;
import entity.workorder.WorkOrderListVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName VisitorMapper
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/26 22:30
 * @Version 1.0
 */
@Mapper
public interface WorkorderMapper {

    List<WorkOrderListVo> findAllBySearch(Workorder workorder);

    WorkOrderListVo findWorkerDetail(String id);
}
