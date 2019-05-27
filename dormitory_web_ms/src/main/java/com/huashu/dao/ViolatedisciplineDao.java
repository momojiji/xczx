package com.huashu.dao;

import com.huashu.pojo.Violatediscipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ViolatedisciplineDao extends JpaRepository<Violatediscipline,String>,JpaSpecificationExecutor<Violatediscipline>{
	
}
