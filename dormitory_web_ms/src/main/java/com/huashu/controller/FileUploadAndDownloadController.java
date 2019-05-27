package com.huashu.controller;

import com.huashu.pojo.*;
import com.huashu.service.*;
import entity.Result;
import entity.StatusCode;
import org.apache.poi.ss.usermodel.Cell;
import org.csource.fastdfs.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import util.DateUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @Auther: wyan
 * @Date: 2019/2/13 19:04
 * @Description:
 */
@RestController
@CrossOrigin
@RequestMapping("/file")
public class FileUploadAndDownloadController {

    private static  final Logger LOGGER = LoggerFactory.getLogger(FileUploadAndDownloadController.class);


    @Value("${huashu.fastdfs.image_Server_Address}")
    private String imageServerAddress;

    @Autowired
    private ImportService importService;

    @Autowired
    private CollegeService collegeService;

    @Autowired
    private UserService userService;

    @Autowired
    private MajorService majorService;
    @Autowired
    private ClassinfoService classinfoService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private DormitoryService dormitoryService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private AllocationService allocationService;

    @Autowired
    private AllocationStudentService allocationStudentService;

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public Result upload(@RequestParam(value = "file", required = true) MultipartFile file) {

        try {
            //加载配置文件（trackerserver地址）
            ClientGlobal.initByProperties("config/fastdfs-client.properties");

            //tracker client，请求tracker得到storage地址
            TrackerClient trackerClient = new TrackerClient();
            //连接tracker server
            TrackerServer trackerServer = trackerClient.getConnection();
            ProtoCommon.activeTest(trackerServer.getSocket());
            //得到strorage的地址
            StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
            //strage client用来上传文件
            //构造参数 TrackerServer trackerServer, StorageServer storageServer
            StorageClient1 storageClient1 = new StorageClient1(trackerServer,storageServer);
            //得到新文件字节
            byte[] bytes = file.getBytes();
            //得到文件扩展名
            String originalFilename = file.getOriginalFilename();//原始名称
            String ext = originalFilename.substring(originalFilename.lastIndexOf(".")+1);
            String fileId = imageServerAddress+ File.separator+storageClient1.upload_file1(bytes, ext, null);
            return new Result(true,20000,"上传成功",fileId);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("upload to fastDFS error{}",e.getMessage());
            return new Result(false,9999,"上传失败",e.getMessage());

        }

    }

    @RequestMapping(value = "/uploadExcel")
    @ResponseBody
    public String uploadExcel(HttpServletRequest request) throws Exception {
        /*MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        MultipartFile file = multipartRequest.getFile("filename");
        if (file.isEmpty()) {
            return "文件不能为空";
        }
        InputStream inputStream = file.getInputStream();*/
        InputStream inputStream = new FileInputStream(
                ResourceUtils.getFile("classpath:zushuang.xlsx"));
        List<List<Cell>> list = importService.getBankListByExcel(inputStream, "nv.xlsx");
        inputStream.close();
        parseObject(list);

        return "上传成功";
    }
    @RequestMapping(value = "/uploadClassInfo")
    @ResponseBody
    public String uploadClassInfo(HttpServletRequest request) throws Exception {
        /*MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        MultipartFile file = multipartRequest.getFile("filename");
        */
        importService.readExcelToClass(ResourceUtils.getFile("classpath:555.xls"));

        return "上传成功";
    }
    @RequestMapping(value = "/uploadStudentScore")
    @ResponseBody
    public String uploadStudentScore(HttpServletRequest request) throws Exception {
        /*MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        MultipartFile file = multipartRequest.getFile("filename");
        */
        importService.readExcelToScore(ResourceUtils.getFile("classpath:2017年度第一学期成绩.xls"));

        return "上传成功";
    }


    private void parseObject(
            List<List<Cell>> list) {

        for (int i = 0; i < list.size(); i++) {
            College college = new College();
            Major major = new Major();
            Classinfo classinfo = new Classinfo();
            Student student = new Student();
            User user = new User();
            //获取每一行记录
            //赋值学院对象
            List<Cell> lo = list.get(i);
            college.setCollegename(lo.get(6).getStringCellValue());
            college.setDeepth("2");
            college.setParentid("1");
            college.setCollegecode("");
            college.setCollegenum("");
            college.setStatus(StatusCode.NORMAL);
            college.setIsvalidate(StatusCode.NORMAL);
            //查询是否有当前的院校，如果没有直接插入，返回id如果有记录获取记录的id
            College dbCollege = collegeService.findCollegeByName(college.getCollegename());
            String collegeId = "";
            if(null!=dbCollege){
                collegeId=dbCollege.getId();
            }else{
                collegeId = collegeService.add(college);
            }
            //赋值专业对象
            major.setCollegeid("");
            major.setDirection("");
            if(null!=lo.get(7)){
                major.setDisciplines(lo.get(7).getStringCellValue());
            }else{
                major.setDisciplines("");
            }

            if(null!=lo.get(9)){
                major.setInternationalcode(lo.get(9).getStringCellValue());
            }
            major.setIsvalidate(StatusCode.NORMAL);
            major.setMajorcode("");
            major.setCollegeid(collegeId);
            if(null!=lo.get(11)){
                major.setMajorname(lo.get(11).getStringCellValue().trim());
            }else{
                major.setMajornum("");
            }

            if(null!=lo.get(12)){
                major.setProfessionallevel((String)lo.get(12).getStringCellValue());
            }
            if(null!=lo.get(8)){
                major.setSubject((String)lo.get(8).getStringCellValue());
            }
            major.setStatus(StatusCode.NORMAL);
            //查询数据库是否有专业如果有获取id 如果没有插入数据返回id
            Major dbMajor = majorService.findMajorByName(major.getMajorname());
            String majorId ;
            if(null!=dbMajor){
                majorId = dbMajor.getId();
            }else{
                majorId = majorService.add(major);
            }
            //赋值user对象属性
            user.setPhotos(StatusCode.DEFAULT_BOY_IMAGE);
            user.setUsertype(StatusCode.TRAINER);
            user.setIsvalid(StatusCode.USER_ENABLE);
            user.setStatus(StatusCode.NORMAL);
            user.setPassword(StatusCode.DEFAULT_PASSWORD);
            user.setAddress("");
            user.setPoliticastatus("");
            user.setPosition(0);
            user.setRoleid("");
            user.setSex(0);
            String phone ="";
            try{
                phone = lo.get(17).getStringCellValue();
            }catch(Exception e){
                DecimalFormat df = new DecimalFormat("0");
                phone = df.format(lo.get(17).getNumericCellValue());
            }

            user.setTelphone(phone.trim());
            user.setUsername((String)lo.get(16).getStringCellValue().trim());
            user.setUsernum("");
            //查询是否有用户 有返回id 没有添加返回id
            User dbUser = userService.findUserByNameAndPhone(user.getUsername(),phone);
            String userId;
            if(dbUser!=null){
                userId=dbUser.getId();
            }else{
                userId = userService.add(user);
            }
            //赋值班级对象
            classinfo.setAddress("");
            classinfo.setClassinfoname(lo.get(14).getStringCellValue().trim());
            if(null!=lo.get(14)){
                classinfo.setClassinfonum((String)lo.get(14).getStringCellValue());
            }
            classinfo.setIsvalidate(StatusCode.NORMAL);
            classinfo.setMajorid(majorId);
            classinfo.setStatus(StatusCode.NORMAL);
            classinfo.setStucount(100);
            classinfo.setUserid(userId);
            //查询数据库是否有数据 有返回id没有添加记录返回id
            Classinfo dbClass = classinfoService.findClassByName(classinfo.getClassinfoname(),classinfo.getUserid());
            String classId;
            if(null!=dbClass){
                classId = dbClass.getId();
                dbClass.setClassinfocode(lo.get(1).getStringCellValue().trim());
                classinfoService.update(dbClass);
            }else{
                classId = classinfoService.add(classinfo);
            }
            //赋值学生对象
            student.setStudentname((String)lo.get(3).getStringCellValue());
            student.setAppdeviceid("");
            student.setPassword(StatusCode.DEFAULT_PASSWORD);

            System.out.println(i+"行号====");
            try{
                String dateStr = lo.get(22).getStringCellValue();
                if(dateStr.contains(".")){
                    dateStr=dateStr.replace(".","-");
                }
                if(dateStr.contains("/")){
                    dateStr=dateStr.replace("/","-");
                }
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                student.setBirthday(sdf.parse(dateStr));


            }catch (Exception e){
                student.setBirthday(lo.get(22).getDateCellValue());
            }

            student.setClassid(classId);
            student.setCollegecode((String)lo.get(6).getStringCellValue());
            student.setCollegeid(collegeId);
            student.setDirection("");
            if(null!=lo.get(7)){
                student.setDisciplines(lo.get(7).getStringCellValue());
            }

            if(null!=lo.get(20)){
                DecimalFormat df = new DecimalFormat("0");
                String p = df.format(lo.get(20).getNumericCellValue());
                student.setExamnum(p);
            }
            if(null!=lo.get(28)){
                student.setHomeaddress((String)lo.get(28).getStringCellValue());
                student.setIdaddress((String)lo.get(28).getStringCellValue());
            }

            if(null!=lo.get(30)){
                String p="";
                try{
                    double phoneDouble = lo.get(30).getNumericCellValue();
                    DecimalFormat df = new DecimalFormat("0");
                    p = df.format(phoneDouble);
                }catch (Exception e){
                    p=lo.get(30).getStringCellValue();
                }
                student.setHometel(p);
                student.setStudenttel(p);
            }
            student.setIdcard((String)lo.get(21).getStringCellValue());
            student.setIdcardback("");
            student.setIdcardfront("");
            if(null!=lo.get(9)){
                student.setInternationalcode((String)lo.get(9).getStringCellValue());
            }
            student.setIsvalidate(StatusCode.NORMAL);
            student.setLogincount(0);
            if(null!=lo.get(11)){
                student.setMajorid(majorId);
            }
            if(null!=lo.get(10)){
                student.setMajornum(majorId);
            }
            student.setNamecode("");
            student.setNamedbefore("");
            student.setPoliticaloutlook("");
            student.setPresentage(0);
            if(null!=lo.get(12)){
                student.setProfessionallevel((String)lo.get(12).getStringCellValue());
            }
            String sex = (String)lo.get(4).getStringCellValue();
            student.setSex("男".equals(sex)?0:1);
            if(student.getSex()==1){
                student.setPersonphone(StatusCode.DEFAULT_GIRL_IMAGE);
                student.setBooklogo(StatusCode.DEFAULT_GIRL_IMAGE);
            }else{
                student.setPersonphone(StatusCode.DEFAULT_BOY_IMAGE);
                student.setBooklogo(StatusCode.DEFAULT_BOY_IMAGE);
            }
            student.setStatus(StatusCode.NORMAL);
            String studentNum = "";
            try{
                studentNum = lo.get(2).getStringCellValue();
            }catch(Exception e){
                double d = lo.get(2).getNumericCellValue();
                DecimalFormat df = new DecimalFormat("0");
                studentNum = df.format(d);
            }
            student.setStudentnum(studentNum);

            if(null!=lo.get(8)){
                student.setSubject((String)lo.get(8).getStringCellValue());
            }
            //查询学生的数据 如果有返回id没有则添加返回id
            Student dbStudent = studentService.findStudentByIdCard(student.getIdcard());
            String studentId  ;
            if(null!=dbStudent){
                studentId=dbStudent.getId();
            }else{
                studentId=studentService.add(student);
            }
            //赋值给宿舍建筑信息
            Dormitory build = new Dormitory();
            build.setDeepth(StatusCode.FIRST_FLOOR);
            build.setIsvalidate(StatusCode.NORMAL);
            build.setStatus(StatusCode.NORMAL);
            build.setParentid("");
            build.setCollegeid(collegeId);
            if(null!=lo.get(45)){
                build.setDormitoryname(lo.get(45).getStringCellValue().trim());
                build.setDormitorynum(lo.get(45).getStringCellValue().trim());
                build.setDormitorycode(lo.get(45).getStringCellValue().trim());
            }
            //目前是分配给老师 没有宿管数据
            build.setUserid("1107624169253769216");
            //如果没有当前build插入记录返回id 如果有返回记录id
            Dormitory dbBuild = dormitoryService.findDormitoryByName(build.getDormitoryname());
            String buildId ;
            if(null!=dbBuild){
                buildId = dbBuild.getId();
            }else{
                buildId = dormitoryService.add(build);
            }
            Dormitory dormitory = new Dormitory();
            dormitory.setDeepth(StatusCode.SECOND_FLOOR);
            dormitory.setIsvalidate(StatusCode.NORMAL);
            dormitory.setStatus(StatusCode.NORMAL);
            dormitory.setParentid(buildId);
            dormitory.setCollegeid(collegeId);
            if(null!=lo.get(46)){
                String dname = "";
                try{
                    dname = lo.get(46).getStringCellValue();
                }catch(Exception e){
                    double d = lo.get(46).getNumericCellValue();
                    DecimalFormat df = new DecimalFormat("0");
                    dname = df.format(d);
                }
                dormitory.setDormitoryname(dname.trim());
                dormitory.setDormitorynum(dname.trim());
                dormitory.setDormitorycode(dname.trim());
            }
            //目前是分配给老师 没有宿管数据
            dormitory.setUserid("1107624169253769216");
            //如果没有当前build插入记录返回id 如果有返回记录id
            Dormitory dbDormitory = dormitoryService.findDormitoryByNameAndParent(dormitory.getDormitoryname(),dormitory.getParentid());
            String dormitoryId ;
            if(null!=dbDormitory){
                dormitoryId = dbDormitory.getId();
            }else{
                dormitoryId = dormitoryService.add(dormitory);
            }
            //房间信息的存储
            Room room = new Room();
            if(null!=lo.get(47)){

                String roomNum = "";
                try{
                    roomNum = lo.get(47).getStringCellValue();
                }catch (Exception e){
                    double r =lo.get(47).getNumericCellValue();
                    DecimalFormat df = new DecimalFormat("0");
                    roomNum = df.format(r);
                }
                room.setRoomname(roomNum.trim());
                room.setRoomnum(roomNum.trim());
            }
            room.setDormitoryid(dormitoryId);
            room.setCurrentstudent(8);
            room.setBuildid(buildId);
            room.setMaxstudent(8);
            room.setIsvalidate(StatusCode.NORMAL);
            room.setStatus(StatusCode.NORMAL);
            room.setRoomcode("");
            room.setSextype(1);
            room.setRoomtypeid("1107628749274353664");
            //如果没有当前build插入记录返回id 如果有返回记录id
            Room dbRoom = roomService.findByNameAndParent(room.getRoomname(),room.getDormitoryid());
            String roomId ;
            if(null!=dbRoom){
                roomId = dbRoom.getId();
            }else{
                roomId = roomService.add(room);
            }
            //存储宿舍床位
            Allocation allocation = new Allocation();
            allocation.setRoomid(roomId);
            allocation.setRoomnum(roomId);
            allocation.setIsvalid(StatusCode.USER_ENABLE);
            allocation.setStatus(StatusCode.CHECKIN_DISABLE+"");
            allocation.setAllocationdate(DateUtil.getCurrentFromatDate());
            if(null!=lo.get(48)){
                String bedNum = lo.get(48).getStringCellValue();
                allocation.setBednum(bedNum.substring(0,1));
               // String bedStr = bedNum.substring(1);
                String bedStr = bedNum.substring(2,3);
                allocation.setBedtype("上".equals(bedStr)?"0":"1");
            }

            allocation.setBuildid(buildId);
            allocation.setDormitoryid(dormitoryId);
            //查询宿舍床位 有返回id 没有添加返回id
            Allocation dbAllocation = allocationService.findByRoomIdAndDormitoryId(allocation.getRoomid(),allocation.getDormitoryid());
            String alId ;
            if(null!=dbAllocation){
                alId = dbAllocation.getId();
            }else{
                alId = allocationService.add(allocation);
            }
            //存储学生入住信息
            AllocationStudent allocationStudent = new AllocationStudent();
            allocationStudent.setStatus(StatusCode.NORMAL);
            allocationStudent.setIsvalid(StatusCode.NORMAL);
            allocationStudent.setCreatedate(new Date());
            allocationStudent.setAllocation_id(alId);
            allocationStudent.setBednum(allocation.getBednum());
            allocationStudent.setStudentid(studentId);
            allocationStudent.setDormdate(new Date());
            //查询是否入住未入住则添加入住信息
            AllocationStudent dbAllocationStudent = allocationService.findByAlIdAndStudentId(allocationStudent.getAllocation_id(),allocationStudent.getStudentid());
            if(null==dbAllocationStudent){
                allocationStudentService.add(allocationStudent);
            }



        }

    }

}
/*
*
*  SELECT * FROM tb_room WHERE roomname='401' AND dormitoryid='1117007494774919168'

 SELECT * FROM tb_allocation WHERE roomid IN ('1117009792007802880','1117009792221712384')

 SELECT * FROM tb_dormitory WHERE id IN ('1117007494774919168','1117007214897401856')

 SELECT * FROM tb_student WHERE id IN (
  SELECT studentid FROM tb_allocation_student WHERE allocation_id IN('1117009792032968704','1117009792246878208'))

* */