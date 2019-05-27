package com.huashu.controller;

import com.github.pagehelper.PageInfo;
import com.huashu.pojo.Classinfo;
import com.huashu.pojo.College;
import com.huashu.pojo.Major;
import com.huashu.pojo.Student;
import com.huashu.service.ClassinfoService;
import com.huashu.service.CollegeService;
import com.huashu.service.MajorService;
import com.huashu.service.StudentService;
import entity.Result;
import entity.StatusCode;
import entity.student.EditStudentVo;
import entity.student.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 控制器层
 * @author Administrator
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private MajorService majorService;

	@Autowired
	private ClassinfoService classinfoService;

	@Autowired
	private CollegeService collegeService;


	
	/**
	 * 异步添加
	 * @param student
	 */
	@RequestMapping(value="/addStudentSyn")
	public Result addRoomSyn(@RequestBody Student student){

		studentService.add(student);
		return new Result(true,StatusCode.OK,"添加成功");
	}
	/**
	 * 修改查询
	 * @param studentId
	 */
	@RequestMapping(value="/findStudentById")
	public Result findStudentById( String studentId ){
		EditStudentVo editStudentVo = new EditStudentVo();
		Student student = studentService.findById(studentId);
		editStudentVo.setStudent(student);
		//查询当前学生所在的院校对象
		College college = collegeService.findById(student.getCollegeid());
		//学生所在的学校id
		String collegeParentId = college.getParentid();
		editStudentVo.setCollegeParentId(collegeParentId);
		//查询学校的所有学院
		List<College> instituteList =collegeService.findInstituteByCollegeId(collegeParentId);
		editStudentVo.setInstituteList(instituteList);
		//查询学院所有的专业json
		Map majorMap = new HashMap();
		majorMap.put("collegeid",college.getId());
		List<Major> majorList = majorService.findSearch(majorMap);
		editStudentVo.setMajorList(majorList);
		//查询专业下所有班级
		Map classMap = new HashMap();
		classMap.put("majorid",student.getMajorid());
		List<Classinfo> classinfoList = classinfoService.findSearch(classMap);
		editStudentVo.setClassList(classinfoList);

		return new Result(true,StatusCode.OK,"修改成功",editStudentVo);
	}
	/**
	 * 修改更新
	 * @param student
	 */
	@RequestMapping(value="/editStudentSyn")
	public Result uadateStudent(@RequestBody Student student ){
		studentService.update(student);
		return new Result(true,StatusCode.OK,"修改成功");
	}
	
	/**
	 * 删除
	 * @param studentIds
	 */
	@RequestMapping(value="/deleteStudentByIds")
	public Result delete(@RequestBody String [] studentIds ){
		studentService.deleteByIds(studentIds);
		return new Result(true,StatusCode.OK,"删除成功");
	}
	/**
	 * 查询全部的学校json
	 * 查询全部的学院json
	 * @return
	 */
	@RequestMapping("/findStudentPageById")
	public Result findStudentPageById(@RequestBody Map<String,String> map){

		PageInfo<StudentVo> pageInfo = (PageInfo<StudentVo>) studentService.findAllStudentVo(map);
		return new Result(true,StatusCode.OK,"查询成功",pageInfo);
	}

	//根据查询参数查询学生信息
	//findStudentPageByParams
	@RequestMapping("/findStudentPageByParams")
	public Result findStudentPageByParams(@RequestBody Map<String,String> map){

		PageInfo<StudentVo> pageInfo = (PageInfo<StudentVo>) studentService.findStudentVoByMap(map);
		return new Result(true,StatusCode.OK,"查询成功",pageInfo);
	}
    /**
     * 查询全部学生的json数据
     * @return
     */
    @RequestMapping("/findStudentJson")
    public Result findAllCollegeJson(Integer pageNum,Integer pageSize){

        //查询所有的学生
        PageInfo<StudentVo> pageInfo = (PageInfo<StudentVo>) studentService.findAllStudentVo(pageNum,pageSize);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }
}
