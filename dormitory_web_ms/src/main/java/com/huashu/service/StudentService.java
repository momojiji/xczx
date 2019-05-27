package com.huashu.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huashu.dao.StudentDao;
import com.huashu.dao.StudentMapper;
import com.huashu.pojo.Student;
import entity.StatusCode;
import entity.student.StudentVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class StudentService {

	@Autowired
	private StudentDao studentDao;

	@Autowired
	private StudentMapper studentMapper;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Student> findAll() {
		return studentDao.findAll();
	}

	/**
	 * 查询全部列表
	 * @return
	 * @param pageNum
	 * @param pageSize
	 */
	public PageInfo<StudentVo> findAllStudentVo(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		List<StudentVo> list = studentMapper.findAllStudentVo();
		return new PageInfo<StudentVo>(list);
	}
	/**
	 * 查询全部列表
	 * @return
     * @param map
     */
	public PageInfo<StudentVo> findAllStudentVo(Map<String,String> map) {
		Integer pageNum = Integer.parseInt((String)map.get("pageNum"));
		Integer pageSize = Integer.parseInt((String)map.get("pageSize"));
		PageHelper.startPage(pageNum,pageSize);
		List<StudentVo> list = studentMapper.findStudentVoById(map);
		return new PageInfo<StudentVo>(list);
	}
	/**
	 * 查询条件学生数据
	 * @return
	 */
	public PageInfo<StudentVo> findStudentVoByMap(Map<String,String> map) {
		Integer pageNum = Integer.parseInt((String)map.get("pageNum"));
		Integer pageSize = Integer.parseInt((String)map.get("pageSize"));
		PageHelper.startPage(pageNum,pageSize);
		List<StudentVo> list = studentMapper.findStudentVoById(map);
		return new PageInfo<StudentVo>(list);
	}
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Student> findSearch(Map whereMap, int page, int size) {
		Specification<Student> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return studentDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Student> findSearch(Map whereMap) {
		Specification<Student> specification = createSpecification(whereMap);
		return studentDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Student findById(String id) {
		return studentDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param student
	 */
	public String add(Student student) {
		student.setId( idWorker.nextId()+"" );
		student.setPassword(StatusCode.DEFAULT_PASSWORD);
		if(StringUtils.isNotEmpty(student.getSex()+"")&&student.getSex()==0){
			student.setPersonphone(StatusCode.DEFAULT_BOY_IMAGE);
			student.setBooklogo(StatusCode.DEFAULT_BOY_IMAGE);
		}else{
			student.setPersonphone(StatusCode.DEFAULT_GIRL_IMAGE);
			student.setBooklogo(StatusCode.DEFAULT_GIRL_IMAGE);
		}
		studentDao.save(student);
		return student.getId();
	}

	/**
	 * 修改
	 * @param student
	 */
	public void update(Student student) {
		studentDao.save(student);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		studentDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Student> createSpecification(Map searchMap) {

		return new Specification<Student>() {

			@Override
			public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("id")!=null && !"".equals(searchMap.get("id"))) {
                	predicateList.add(cb.like(root.get("id").as(String.class), "%"+(String)searchMap.get("id")+"%"));
                }
                // 
                if (searchMap.get("studentname")!=null && !"".equals(searchMap.get("studentname"))) {
                	predicateList.add(cb.like(root.get("studentname").as(String.class), "%"+(String)searchMap.get("studentname")+"%"));
                }
                // 
                if (searchMap.get("studentnum")!=null && !"".equals(searchMap.get("studentnum"))) {
                	predicateList.add(cb.like(root.get("studentnum").as(String.class), "%"+(String)searchMap.get("studentnum")+"%"));
                }
                // 
                if (searchMap.get("collegecode")!=null && !"".equals(searchMap.get("collegecode"))) {
                	predicateList.add(cb.like(root.get("collegecode").as(String.class), "%"+(String)searchMap.get("collegecode")+"%"));
                }
                // 
                if (searchMap.get("classid")!=null && !"".equals(searchMap.get("classid"))) {
                	predicateList.add(cb.like(root.get("classid").as(String.class), "%"+(String)searchMap.get("classid")+"%"));
                }
                // 
                if (searchMap.get("namedbefore")!=null && !"".equals(searchMap.get("namedbefore"))) {
                	predicateList.add(cb.like(root.get("namedbefore").as(String.class), "%"+(String)searchMap.get("namedbefore")+"%"));
                }
                // 
                if (searchMap.get("namecpde")!=null && !"".equals(searchMap.get("namecpde"))) {
                	predicateList.add(cb.like(root.get("namecpde").as(String.class), "%"+(String)searchMap.get("namecpde")+"%"));
                }
                // 
                if (searchMap.get("examnum")!=null && !"".equals(searchMap.get("examnum"))) {
                	predicateList.add(cb.like(root.get("examnum").as(String.class), "%"+(String)searchMap.get("examnum")+"%"));
                }
                // 
                if (searchMap.get("collegeid")!=null && !"".equals(searchMap.get("collegeid"))) {
                	predicateList.add(cb.like(root.get("collegeid").as(String.class), "%"+(String)searchMap.get("collegeid")+"%"));
                }
                // 
                if (searchMap.get("majornum")!=null && !"".equals(searchMap.get("majornum"))) {
                	predicateList.add(cb.like(root.get("majornum").as(String.class), "%"+(String)searchMap.get("majornum")+"%"));
                }
                // 
                if (searchMap.get("majorid")!=null && !"".equals(searchMap.get("majorid"))) {
                	predicateList.add(cb.like(root.get("majorid").as(String.class), "%"+(String)searchMap.get("majorid")+"%"));
                }
                // 
                if (searchMap.get("direction")!=null && !"".equals(searchMap.get("direction"))) {
                	predicateList.add(cb.like(root.get("direction").as(String.class), "%"+(String)searchMap.get("direction")+"%"));
                }
                // 
                if (searchMap.get("disciplines")!=null && !"".equals(searchMap.get("disciplines"))) {
                	predicateList.add(cb.like(root.get("disciplines").as(String.class), "%"+(String)searchMap.get("disciplines")+"%"));
                }
                // 
                if (searchMap.get("subject")!=null && !"".equals(searchMap.get("subject"))) {
                	predicateList.add(cb.like(root.get("subject").as(String.class), "%"+(String)searchMap.get("subject")+"%"));
                }
                // 
                if (searchMap.get("Internationalcode")!=null && !"".equals(searchMap.get("Internationalcode"))) {
                	predicateList.add(cb.like(root.get("Internationalcode").as(String.class), "%"+(String)searchMap.get("Internationalcode")+"%"));
                }
                // 
                if (searchMap.get("professionallevel")!=null && !"".equals(searchMap.get("professionallevel"))) {
                	predicateList.add(cb.like(root.get("professionallevel").as(String.class), "%"+(String)searchMap.get("professionallevel")+"%"));
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

	public void deleteByIds(String[] studentIds) {
		for (String studentId : studentIds) {
			studentDao.deleteById(studentId);
		}
	}

    public Student findStudentByIdCard(String idcard) {
		return studentMapper.findStudentByIdCard(idcard);
    }
}
