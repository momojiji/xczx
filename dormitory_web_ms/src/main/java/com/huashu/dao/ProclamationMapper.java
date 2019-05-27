package com.huashu.dao;

import com.huashu.pojo.Proclamation;
import entity.proclamation.ProclamationVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Map;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
@Mapper
public interface ProclamationMapper{

    default List<ProclamationVo> findAllProclamationBySearch() {
        return findAllProclamationBySearch();
    }

    List<ProclamationVo> findAllProclamationBySearch(Map map);

    ProclamationVo findProclamationById(String id);
}
