package com.huashu.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huashu.dao.RoleDao;
import com.huashu.dao.UserDao;
import com.huashu.dao.UserMapper;
import com.huashu.pojo.Role;
import com.huashu.pojo.User;
import entity.StatusCode;
import entity.user.UserVo;
import exception.CustomException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
@Transactional
public class UserService  {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private IdWorker idWorker;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private RoleDao roleDao;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<User> findAll() {
		return userDao.findAll();
	}



	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public User findById(String id) {
		return userDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param user
	 */
	public String add(User user) {
		user.setId( idWorker.nextId()+"" );
		user.setStatus(StatusCode.USER_ENABLE);
		user.setIsvalid(StatusCode.USER_ENABLE);
		user.setCreatedate(new Date());
		if(null!=user.getSex()&&user.getSex()==1){
			user.setPhotos(StatusCode.DEFAULT_GIRL_IMAGE);
		}else{
			user.setPhotos(StatusCode.DEFAULT_BOY_IMAGE);
		}
		if(StringUtils.isNotEmpty(user.getRoleid())){
			Role  role = roleDao.findById(user.getRoleid()).get();
			if(null!=role){
				String rolename = role.getRolename();
				if(rolename.equals("宿舍管理员")){
					user.setUsertype(StatusCode.DORMITORY_MANAGER);
				}else if(rolename.equals("辅导员")){
					user.setUsertype(StatusCode.TRAINER);
				}else if(rolename.equals("维修")){
					user.setUsertype(StatusCode.REPAIRE);
				}else{
					user.setUsertype(StatusCode.LEADER);
				}
			}
		}

		userDao.save(user);
		return user.getId();
	}

	/**
	 * 修改
	 * @param user
	 */
	public void update(User user) {
		userDao.save(user);
	}

	/**
	 * 删除
	 * @param ids
	 */
	public void deleteById(String [] ids) {
		for (String id : ids) {
			userDao.deleteById(id);
		}

	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<User> createSpecification(Map searchMap) {

		return new Specification<User>() {

			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("id")!=null && !"".equals(searchMap.get("id"))) {
                	predicateList.add(cb.like(root.get("id").as(String.class), "%"+(String)searchMap.get("id")+"%"));
                }
                // 
                if (searchMap.get("username")!=null && !"".equals(searchMap.get("username"))) {
                	predicateList.add(cb.equal(root.get("username").as(String.class), searchMap.get("username")));
                }
                // 
                if (searchMap.get("loginname")!=null && !"".equals(searchMap.get("loginname"))) {
                	predicateList.add(cb.equal(root.get("loginname").as(String.class), searchMap.get("loginname")));
                }
                // 
                if (searchMap.get("password")!=null && !"".equals(searchMap.get("password"))) {
                	predicateList.add(cb.equal(root.get("password").as(String.class), (String)searchMap.get("password")));
                }
                // 
                if (searchMap.get("usernum")!=null && !"".equals(searchMap.get("usernum"))) {
                	predicateList.add(cb.like(root.get("usernum").as(String.class), "%"+(String)searchMap.get("usernum")+"%"));
                }
                // 
                if (searchMap.get("deptid")!=null && !"".equals(searchMap.get("deptid"))) {
                	predicateList.add(cb.like(root.get("deptid").as(String.class), "%"+(String)searchMap.get("deptid")+"%"));
                }
                // 
                if (searchMap.get("remarks4")!=null && !"".equals(searchMap.get("remarks4"))) {
                	predicateList.add(cb.like(root.get("remarks4").as(String.class), "%"+(String)searchMap.get("remarks4")+"%"));
                }
                // 
                if (searchMap.get("telphone")!=null && !"".equals(searchMap.get("telphone"))) {
                	predicateList.add(cb.like(root.get("telphone").as(String.class), "%"+(String)searchMap.get("telphone")+"%"));
                }
                // 
                if (searchMap.get("address")!=null && !"".equals(searchMap.get("address"))) {
                	predicateList.add(cb.like(root.get("address").as(String.class), "%"+(String)searchMap.get("address")+"%"));
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

	//用户名密码查询用户
    public UserVo loadUserByUsername(Map map) throws Exception {

	    List<UserVo> userList = userMapper.loginUser(map);
	    if(null==userList||userList.size()<1){
	        return null;
        }
		UserVo dbUser = userList.get(0);

	    return dbUser;
    }

    //修改用户密码
	public void updateUser(Map editMap) throws  Exception {
		Map<String ,String > map = new HashMap<String,String>();
		map.put("loginname",(String)editMap.get("username"));
		Specification<User> specification = createSpecification(map);
		List<User> userList = userDao.findAll(specification);
		if(null==userList||userList.size()>1){
			throw  new CustomException(-9999,"用户不存在");
		}
		User dbUser = userList.get(0);
		dbUser.setPassword((String )editMap.get("password"));
		update(dbUser);
	}
	//条件分页查询
    public PageInfo<UserVo> findUserPage(Map map) {
		Integer pageNum =Integer.parseInt((String)map.get("pageNum"));
		Integer pageSize =Integer.parseInt((String)map.get("pageSize"));
		PageHelper.startPage(pageNum,pageSize);
		List<UserVo> userList = userMapper.findAllUser(map);
		PageInfo<UserVo> pi = new PageInfo<UserVo>(userList);
		return pi;
    }

    public User findUserByNameAndPhone(String username, String phone) {
		return userMapper.findByNameAndPhone(username,phone);
    }
}
