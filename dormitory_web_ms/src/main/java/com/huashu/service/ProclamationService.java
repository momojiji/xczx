package com.huashu.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huashu.dao.ProclamationDao;
import com.huashu.dao.ProclamationMapper;
import com.huashu.pojo.Major;
import com.huashu.pojo.Proclamation;
import entity.proclamation.ProclamationVo;
import entity.proclamation.ProclamationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import util.IdWorker;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class ProclamationService {

	@Autowired
	private ProclamationDao proclamationDao;


	@Autowired
	private ProclamationMapper proclamationMapper;

	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Proclamation> findAll() {
		return proclamationDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Proclamation> findSearch(Map whereMap, int page, int size) {
		Specification<Proclamation> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return proclamationDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Proclamation> findSearch(Map whereMap) {
		Specification<Proclamation> specification = createSpecification(whereMap);
		return proclamationDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public ProclamationVo findById(String id) {
		return proclamationMapper.findProclamationById(id);
	}
    public Proclamation findDbProclamationById(String id) {
        return proclamationDao.findById(id).get();
    }

	/**
	 * 增加
	 * @param proclamation
	 */
	public void add(Proclamation proclamation) {
		proclamation.setId( idWorker.nextId()+"" );
		proclamationDao.save(proclamation);
	}

	/**
	 * 修改
	 * @param proclamation
	 */
	public void update(Proclamation proclamation) {
		proclamationDao.save(proclamation);
	}

	/**
	 * 删除
	 * @param proclamationIds
	 */
	public void deleteById(String[] proclamationIds) {
		for (String proclamationId:proclamationIds ) {
			proclamationDao.deleteById(proclamationId);
		}

	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Proclamation> createSpecification(Map searchMap) {

		return new Specification<Proclamation>() {

			@Override
			public Predicate toPredicate(Root<Proclamation> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("id")!=null && !"".equals(searchMap.get("id"))) {
                	predicateList.add(cb.like(root.get("id").as(String.class), "%"+(String)searchMap.get("id")+"%"));
                }
                // 
                if (searchMap.get("title")!=null && !"".equals(searchMap.get("title"))) {
                	predicateList.add(cb.like(root.get("title").as(String.class), "%"+(String)searchMap.get("title")+"%"));
                }
                // 
                if (searchMap.get("content")!=null && !"".equals(searchMap.get("content"))) {
                	predicateList.add(cb.like(root.get("content").as(String.class), "%"+(String)searchMap.get("content")+"%"));
                }
                // 
                if (searchMap.get("noticetype")!=null && !"".equals(searchMap.get("noticetype"))) {
                	predicateList.add(cb.like(root.get("noticetype").as(String.class), "%"+(String)searchMap.get("noticetype")+"%"));
                }
                // 
                if (searchMap.get("userid")!=null && !"".equals(searchMap.get("userid"))) {
                	predicateList.add(cb.like(root.get("userid").as(String.class), "%"+(String)searchMap.get("userid")+"%"));
                }
                // 
                if (searchMap.get("remarks")!=null && !"".equals(searchMap.get("remarks"))) {
                	predicateList.add(cb.like(root.get("remarks").as(String.class), "%"+(String)searchMap.get("remarks")+"%"));
                }
                // 
                if (searchMap.get("creator")!=null && !"".equals(searchMap.get("creator"))) {
                	predicateList.add(cb.like(root.get("creator").as(String.class), "%"+(String)searchMap.get("creator")+"%"));
                }
                // 
                if (searchMap.get("modifitor")!=null && !"".equals(searchMap.get("modifitor"))) {
                	predicateList.add(cb.like(root.get("modifitor").as(String.class), "%"+(String)searchMap.get("modifitor")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

	public PageInfo<Proclamation> findAllProclamation(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		List<Proclamation> list = proclamationDao.findAll() ;
		return new PageInfo<Proclamation>(list);
	}

	public PageInfo<ProclamationVo> findAllProclamationBySearch(Map<String,String> map) {
		Integer pageNum = Integer.parseInt((String)map.get("pageNum"));
		Integer pageSize = Integer.parseInt((String)map.get("pageSize"));
		PageHelper.startPage(pageNum,pageSize);
		List<ProclamationVo> list = proclamationMapper.findAllProclamationBySearch(map) ;
		return new PageInfo<ProclamationVo>(list);
	}
}
