package com.huashu.service;

import com.huashu.pojo.StudentCourse;
import com.huashu.pojo.StudentScore;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @Auther: wyan
 * @Date: 2019/4/8 20:35
 * @Description:
 */
@Service
@Transactional
public class ImportService {

    @Autowired
    private StudentCourseService courseService;

    @Autowired
    private StudentScoreService scoreService;

    public List<List<Cell>> getBankListByExcel(InputStream inputStream, String originalFilename) throws Exception {
        List list = new ArrayList<>();
        //创建Excel工作薄
        Workbook work = this.getWorkbook(inputStream, originalFilename);
        if (null == work) {
            throw new Exception("创建Excel工作薄为空！");
        }
        Sheet sheet = null;
        Row row = null;
        Cell cell = null;

        for (int i = 0; i < work.getNumberOfSheets(); i++) {
            sheet = work.getSheetAt(i);
            if (sheet == null) {
                continue;
            }

            for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {

                row = sheet.getRow(j);
                if (row == null || row.getFirstCellNum() == j) {
                    continue;
                }
                System.out.println(row.getFirstCellNum());
                List<Cell> li = new ArrayList<>();
                for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
                    /*if(j>48&&y==1){
                        cell = row.getCell(1);
                        li.add(cell);
                    }*/
                    cell = row.getCell(y);
                    li.add(cell);
                }
                list.add(li);
            }
        }
        work.close();
        return list;
    }
    /**
     * 判断文件格式
     *
     * @param inStr
     * @param fileName
     * @return
     * @throws Exception
     */
    public Workbook getWorkbook(InputStream inStr, String fileName) throws Exception {
        Workbook workbook = null;
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        if (".xls".equals(fileType)) {
            workbook = new HSSFWorkbook(inStr);
        } else if (".xlsx".equals(fileType)) {
            workbook = new XSSFWorkbook(inStr);
        } else {
            throw new Exception("请上传excel文件！");
        }
        return workbook;
    }

    /**
     * 读取excel数据
     * @param  file
     */
    public   void readExcelToClass(File file) {

        Workbook wb = null;
        try {
            wb = WorkbookFactory.create(file);
            readExcelClassInfo(wb, 0, 0, 0);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 读取excel数据
     * @param  file
     */
    public   void readExcelToScore(File file) {

        Workbook wb = null;
        try {
            wb = WorkbookFactory.create(file);
            readExcelToScore(wb, 0, 0, 0,file.getName());
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 读取excel文件
     * @param  wb
     * @param sheetIndex sheet页下标：从0开始
     * @param startReadLine 开始读取的行:从0开始
     * @param tailLine 去除最后读取的行
     */
    private  void readExcelToScore(Workbook wb,int sheetIndex, int startReadLine, int tailLine,String fileName) {

        Sheet sheet = wb.getSheetAt(sheetIndex);
        Row row = null;
        String courseyear = "";
        String coursesge="";
        String course1 = "";
        String course2 =  "";
        String course3 = "";
        String course4 = "";
        String course5 = "";
        String course6 = "";
        String course7 = "";
        String course8 = "";
        String course9 = "";
        String courseCredit1 = "";
        String courseCredit2 =  "";
        String courseCredit3 = "";
        String courseCredit4 = "";
        String courseCredit5 = "";
        String courseCredit6 = "";
        String courseCredit7 = "";
        String courseCredit8 = "";
        String courseCredit9 = "";
        for(int i=startReadLine; i<sheet.getLastRowNum()-tailLine+1; i++) {

            row = sheet.getRow(i);
            //每一条学生成绩row需要创建9个对象 作为九门功课成绩
            StudentScore studentScore1 = new StudentScore();
            StudentScore studentScore2 = new StudentScore();
            StudentScore studentScore3 = new StudentScore();
            StudentScore studentScore4 = new StudentScore();
            StudentScore studentScore5 = new StudentScore();
            StudentScore studentScore6 = new StudentScore();
            StudentScore studentScore7 = new StudentScore();
            StudentScore studentScore8 = new StudentScore();
            StudentScore studentScore9 = new StudentScore();
            //开始解析每一条表格记录
            String cellValue = getCellValue(row.getCell(1));
            int cellRow = 0;

            //解析成绩的年份
            if(cellValue.startsWith("年级：")){
                courseyear=fileName.substring(0,4);
                coursesge=fileName.substring(6,10);
                cellRow=i;
            }else
                //包含课程的名称 取出来
                if(cellValue.trim().equals("")&&i==cellRow+1){
                    course1 = getCellValue(row.getCell(4)).trim();
                    course2 = getCellValue(row.getCell(5)).trim();
                    course3 = getCellValue(row.getCell(6)).trim();
                    course4 = getCellValue(row.getCell(7)).trim();
                    course5 = getCellValue(row.getCell(8)).trim();
                    course6 = getCellValue(row.getCell(9)).trim();
                    course7 = getCellValue(row.getCell(10)).trim();
                    course8 = getCellValue(row.getCell(11)).trim();
                    course9 = getCellValue(row.getCell(12)).trim();
                }else
                    //包含课程的学分 取出来
                    if(cellValue.startsWith("学生")){
                        courseCredit1 = getCellValue(row.getCell(4)).trim();
                        courseCredit2 = getCellValue(row.getCell(5)).trim();
                        courseCredit3 = getCellValue(row.getCell(6)).trim();
                        courseCredit4 = getCellValue(row.getCell(7)).trim();
                        courseCredit5 = getCellValue(row.getCell(8)).trim();
                        courseCredit6 = getCellValue(row.getCell(9)).trim();
                        courseCredit7 = getCellValue(row.getCell(10)).trim();
                        courseCredit8 = getCellValue(row.getCell(11)).trim();
                        courseCredit9 = getCellValue(row.getCell(12)).trim();
                    }else if(row.getCell(1).getCellType()==Cell.CELL_TYPE_NUMERIC){
                        String courseScore1 = getCellValue(row.getCell(4)).trim();
                        studentScore1.setCoursescore(courseScore1);
                        String courseScore2 = getCellValue(row.getCell(5)).trim();
                        studentScore2.setCoursescore(courseScore2);
                        String courseScore3 = getCellValue(row.getCell(6)).trim();
                        studentScore3.setCoursescore(courseScore3);
                        String courseScore4 = getCellValue(row.getCell(7)).trim();
                        studentScore4.setCoursescore(courseScore4);
                        String courseScore5 = getCellValue(row.getCell(8)).trim();
                        studentScore5.setCoursescore(courseScore5);
                        String courseScore6 = getCellValue(row.getCell(9)).trim();
                        studentScore6.setCoursescore(courseScore6);
                        String courseScore7 = getCellValue(row.getCell(10)).trim();
                        studentScore7.setCoursescore(courseScore7);
                        String courseScore8 = getCellValue(row.getCell(11)).trim();
                        studentScore8.setCoursescore(courseScore8);
                        String courseScore9 = getCellValue(row.getCell(12)).trim();
                        studentScore9.setCoursescore(courseScore9);
                        //设置学生总分 平均分 姓名 学号
                        studentScore1.setTotalscore(getCellValue(row.getCell(18)).trim());
                        studentScore1.setAvgscore(getCellValue(row.getCell(19)).trim());
                        studentScore1.setStudentname(getCellValue(row.getCell(3)).trim());
                        studentScore1.setStudentno(getCellValue(row.getCell(2)).trim());

                        studentScore2.setTotalscore(getCellValue(row.getCell(18)).trim());
                        studentScore2.setAvgscore(getCellValue(row.getCell(19)).trim());
                        studentScore2.setStudentname(getCellValue(row.getCell(3)).trim());
                        studentScore2.setStudentno(getCellValue(row.getCell(2)).trim());
                        studentScore3.setTotalscore(getCellValue(row.getCell(18)).trim());
                        studentScore3.setAvgscore(getCellValue(row.getCell(19)).trim());
                        studentScore3.setStudentname(getCellValue(row.getCell(3)).trim());
                        studentScore3.setStudentno(getCellValue(row.getCell(2)).trim());
                        studentScore4.setTotalscore(getCellValue(row.getCell(18)).trim());
                        studentScore4.setAvgscore(getCellValue(row.getCell(19)).trim());
                        studentScore4.setStudentname(getCellValue(row.getCell(3)).trim());
                        studentScore4.setStudentno(getCellValue(row.getCell(2)).trim());
                        studentScore5.setTotalscore(getCellValue(row.getCell(18)).trim());
                        studentScore5.setAvgscore(getCellValue(row.getCell(19)).trim());
                        studentScore5.setStudentname(getCellValue(row.getCell(3)).trim());
                        studentScore5.setStudentno(getCellValue(row.getCell(2)).trim());
                        studentScore6.setTotalscore(getCellValue(row.getCell(18)).trim());
                        studentScore6.setAvgscore(getCellValue(row.getCell(19)).trim());
                        studentScore6.setStudentname(getCellValue(row.getCell(3)).trim());
                        studentScore6.setStudentno(getCellValue(row.getCell(2)).trim());
                        studentScore7.setTotalscore(getCellValue(row.getCell(18)).trim());
                        studentScore7.setAvgscore(getCellValue(row.getCell(19)).trim());
                        studentScore7.setStudentname(getCellValue(row.getCell(3)).trim());
                        studentScore7.setStudentno(getCellValue(row.getCell(2)).trim());
                        studentScore8.setTotalscore(getCellValue(row.getCell(18)).trim());
                        studentScore8.setAvgscore(getCellValue(row.getCell(19)).trim());
                        studentScore8.setStudentname(getCellValue(row.getCell(3)).trim());
                        studentScore8.setStudentno(getCellValue(row.getCell(2)).trim());
                        studentScore9.setTotalscore(getCellValue(row.getCell(18)).trim());
                        studentScore9.setAvgscore(getCellValue(row.getCell(19)).trim());
                        studentScore9.setStudentname(getCellValue(row.getCell(3)).trim());
                        studentScore9.setStudentno(getCellValue(row.getCell(2)).trim());
                        //赋值每个学生成绩对象的年份和学期
                        studentScore1.setCourseyear(courseyear);
                        studentScore1.setCoursestage(coursesge);
                        studentScore2.setCourseyear(courseyear);
                        studentScore2.setCoursestage(coursesge);
                        studentScore3.setCourseyear(courseyear);
                        studentScore3.setCoursestage(coursesge);
                        studentScore4.setCourseyear(courseyear);
                        studentScore4.setCoursestage(coursesge);
                        studentScore5.setCourseyear(courseyear);
                        studentScore5.setCoursestage(coursesge);
                        studentScore6.setCourseyear(courseyear);
                        studentScore6.setCoursestage(coursesge);
                        studentScore7.setCourseyear(courseyear);
                        studentScore7.setCoursestage(coursesge);
                        studentScore8.setCourseyear(courseyear);
                        studentScore8.setCoursestage(coursesge);
                        studentScore9.setCourseyear(courseyear);
                        studentScore9.setCoursestage(coursesge);
                        //设置课程名和学分
                        studentScore1.setCoursecredit(courseCredit1);
                        studentScore1.setCoursename(course1);
                        studentScore2.setCoursecredit(courseCredit2);
                        studentScore2.setCoursename(course2);
                        studentScore3.setCoursecredit(courseCredit3);
                        studentScore3.setCoursename(course3);
                        studentScore4.setCoursecredit(courseCredit4);
                        studentScore4.setCoursename(course4);
                        studentScore5.setCoursecredit(courseCredit5);
                        studentScore5.setCoursename(course5);
                        studentScore6.setCoursecredit(courseCredit6);
                        studentScore6.setCoursename(course6);
                        studentScore7.setCoursecredit(courseCredit7);
                        studentScore7.setCoursename(course7);
                        studentScore8.setCoursecredit(courseCredit8);
                        studentScore8.setCoursename(course8);
                        studentScore9.setCoursecredit(courseCredit9);
                        studentScore9.setCoursename(course9);

                    }
            //存储9条学生记录
            scoreService.save(studentScore1,studentScore2,studentScore3,studentScore4,studentScore5,
                    studentScore6,studentScore7,studentScore8,studentScore9);


        }

    }

    /**
     * 读取excel文件
     * @param  wb
     * @param sheetIndex sheet页下标：从0开始
     * @param startReadLine 开始读取的行:从0开始
     * @param tailLine 去除最后读取的行
     */
    private  void readExcelClassInfo(Workbook wb,int sheetIndex, int startReadLine, int tailLine) {

        Sheet sheet = wb.getSheetAt(sheetIndex);
        Row row = null;

        for(int i=startReadLine; i<sheet.getLastRowNum()-tailLine+1; i++) {
            //获取当前的年和月份 计算学期
            String teamAge = "";
            Calendar cale =  Calendar.getInstance();
            int year = cale.get(Calendar.YEAR);
            int month = cale.get(Calendar.MONTH) + 1;
            if(month>=8){
                teamAge = year+"年第一学期";
            }else{
                teamAge = year-1+"年第二学期";
            }

            //一个班级最多保存五条记录 上午 1 2 下午 3 4 晚上 5
            StudentCourse course1 = new StudentCourse();
            course1.setCoursestage(teamAge);

            StudentCourse course2 = new StudentCourse();
            course2.setCoursestage(teamAge);
            StudentCourse course3 = new StudentCourse();
            course3.setCoursestage(teamAge);
            StudentCourse course4 = new StudentCourse();
            course4.setCoursestage(teamAge);
            StudentCourse course5 = new StudentCourse();
            course5.setCoursestage(teamAge);
            row = sheet.getRow(i);
            int classIndex = 1;
            //2  7 12 17 22 27 32 37
            for(Cell c : row) {
                c.setCellType(Cell.CELL_TYPE_STRING);
                boolean isMerge = isMergedRegion(sheet, i, c.getColumnIndex());
                //判断是否具有合并单元格
                if(isMerge) {
                    String rs = getMergedRegionValue(sheet, row.getRowNum(), c.getColumnIndex());
                    System.out.print(rs + "  ");
                }else {
                    System.out.println(c.getColumnIndex()+"=="+c.getRichStringCellValue());
                    if(c.getColumnIndex()==1){
                        String name = c.getRichStringCellValue().toString();
                        name=name.substring(0,name.length()-4);
                        course1.setCoursename(name);
                        course2.setCoursename(name);
                        course3.setCoursename(name);
                        course4.setCoursename(name);
                        course5.setCoursename(name);
                    }
                    //周一的课程
                    if(c.getColumnIndex()>=2&&c.getColumnIndex()<=6){
                        //第1阶段
                        if(c.getColumnIndex()%5==2){
                            course1.setMonday(c.getRichStringCellValue().toString());
                            course1.setCoursestage("1");
                        }
                        //第2阶段
                        if(c.getColumnIndex()%5==3){
                            course2.setMonday(c.getRichStringCellValue().toString());
                            course2.setCoursestage("2");
                        }
                        //第3阶段
                        if(c.getColumnIndex()%5==4){
                            course3.setMonday(c.getRichStringCellValue().toString());
                            course3.setCoursestage("3");
                        }
                        //第4阶段
                        if(c.getColumnIndex()%5==0){
                            course4.setMonday(c.getRichStringCellValue().toString());
                            course4.setCoursestage("4");
                        }
                        //第5阶段
                        if(c.getColumnIndex()%5==1){
                            course5.setMonday(c.getRichStringCellValue().toString());
                            course5.setCoursestage("5");
                        }
                    }//周二课程
                    else if(c.getColumnIndex()>=7&&c.getColumnIndex()<=11){
                            //第1阶段
                            if(c.getColumnIndex()%5==2){
                                course1.setTuesday(c.getRichStringCellValue().toString());
                                course1.setCoursestage("1");
                            }
                            //第2阶段
                            if(c.getColumnIndex()%5==3){
                                course2.setTuesday(c.getRichStringCellValue().toString());
                                course2.setCoursestage("2");
                            }
                            //第3阶段
                            if(c.getColumnIndex()%5==4){
                                course3.setTuesday(c.getRichStringCellValue().toString());
                                course3.setCoursestage("3");
                            }
                            //第4阶段
                            if(c.getColumnIndex()%5==0){
                                course4.setTuesday(c.getRichStringCellValue().toString());
                                course4.setCoursestage("4");
                            }
                            //第5阶段
                            if(c.getColumnIndex()%5==1){
                                course5.setTuesday(c.getRichStringCellValue().toString());
                                course5.setCoursestage("5");
                            }
                    }//周三课程
                    else if(c.getColumnIndex()>=12&&c.getColumnIndex()<=16){
                        //第1阶段
                        if(c.getColumnIndex()%5==2){
                            course1.setWednesday(c.getRichStringCellValue().toString());
                            course1.setCoursestage("1");
                        }
                        //第2阶段
                        if(c.getColumnIndex()%5==3){
                            course2.setWednesday(c.getRichStringCellValue().toString());
                            course2.setCoursestage("2");
                        }
                        //第3阶段
                        if(c.getColumnIndex()%5==4){
                            course3.setWednesday(c.getRichStringCellValue().toString());
                            course3.setCoursestage("3");
                        }
                        //第4阶段
                        if(c.getColumnIndex()%5==0){
                            course4.setWednesday(c.getRichStringCellValue().toString());
                            course4.setCoursestage("4");
                        }
                        //第5阶段
                        if(c.getColumnIndex()%5==1){
                            course5.setWednesday(c.getRichStringCellValue().toString());
                            course5.setCoursestage("5");
                        }
                    }
                    //周四课程
                    else if(c.getColumnIndex()>=17&&c.getColumnIndex()<=21){
                        //第1阶段
                        if(c.getColumnIndex()%5==2){
                            course1.setThursday(c.getRichStringCellValue().toString());
                            course1.setCoursestage("1");
                        }
                        //第2阶段
                        if(c.getColumnIndex()%5==3){
                            course2.setThursday(c.getRichStringCellValue().toString());
                            course2.setCoursestage("2");
                        }
                        //第3阶段
                        if(c.getColumnIndex()%5==4){
                            course3.setThursday(c.getRichStringCellValue().toString());
                            course3.setCoursestage("3");
                        }
                        //第4阶段
                        if(c.getColumnIndex()%5==0){
                            course4.setThursday(c.getRichStringCellValue().toString());
                            course4.setCoursestage("4");
                        }
                        //第5阶段
                        if(c.getColumnIndex()%5==1){
                            course5.setThursday(c.getRichStringCellValue().toString());
                            course5.setCoursestage("5");
                        }
                    }
                    //周五课程
                    else if(c.getColumnIndex()>=22&&c.getColumnIndex()<=26){
                        //第1阶段
                        if(c.getColumnIndex()%5==2){
                            course1.setFriday(c.getRichStringCellValue().toString());
                            course1.setCoursestage("1");
                        }
                        //第2阶段
                        if(c.getColumnIndex()%5==3){
                            course2.setFriday(c.getRichStringCellValue().toString());
                            course2.setCoursestage("2");
                        }
                        //第3阶段
                        if(c.getColumnIndex()%5==4){
                            course3.setFriday(c.getRichStringCellValue().toString());
                            course3.setCoursestage("3");
                        }
                        //第4阶段
                        if(c.getColumnIndex()%5==0){
                            course4.setFriday(c.getRichStringCellValue().toString());
                            course4.setCoursestage("4");
                        }
                        //第5阶段
                        if(c.getColumnIndex()%5==1){
                            course5.setFriday(c.getRichStringCellValue().toString());
                            course5.setCoursestage("5");
                        }
                    }
                    //周六课程
                    else if(c.getColumnIndex()>=27&&c.getColumnIndex()<=31){
                        //第1阶段
                        if(c.getColumnIndex()%5==2){
                            course1.setSaturday(c.getRichStringCellValue().toString());
                            course1.setCoursestage("1");
                        }
                        //第2阶段
                        if(c.getColumnIndex()%5==3){
                            course2.setSaturday(c.getRichStringCellValue().toString());
                            course2.setCoursestage("2");
                        }
                        //第3阶段
                        if(c.getColumnIndex()%5==4){
                            course3.setSaturday(c.getRichStringCellValue().toString());
                            course3.setCoursestage("3");
                        }
                        //第4阶段
                        if(c.getColumnIndex()%5==0){
                            course4.setSaturday(c.getRichStringCellValue().toString());
                            course4.setCoursestage("4");
                        }
                        //第5阶段
                        if(c.getColumnIndex()%5==1){
                            course5.setSaturday(c.getRichStringCellValue().toString());
                            course5.setCoursestage("5");
                        }
                    }
                    //周日课程
                    else if(c.getColumnIndex()>31){
                        //第1阶段
                        if(c.getColumnIndex()%5==2){
                            course1.setSunday(c.getRichStringCellValue().toString());
                            course1.setCoursestage("1");
                        }
                        //第2阶段
                        if(c.getColumnIndex()%5==3){
                            course2.setSunday(c.getRichStringCellValue().toString());
                            course2.setCoursestage("2");
                        }
                        //第3阶段
                        if(c.getColumnIndex()%5==4){
                            course3.setSunday(c.getRichStringCellValue().toString());
                            course3.setCoursestage("3");
                        }
                        //第4阶段
                        if(c.getColumnIndex()%5==0){
                            course4.setSunday(c.getRichStringCellValue().toString());
                            course4.setCoursestage("4");
                        }
                        //第5阶段
                        if(c.getColumnIndex()%5==1){
                            course5.setSunday(c.getRichStringCellValue().toString());
                            course5.setCoursestage("5");
                        }
                    }

                }
            }
            System.out.println("一行结束开始存储5条数据");
            courseService.save(course1,course2,course3,course4 ,course5);
            System.out.println("结束存储5条数据");
        }

    }

    /**
     * 获取合并单元格的值
     * @param sheet
     * @param row
     * @param column
     * @return
     */
    public   String getMergedRegionValue(Sheet sheet ,int row , int column){

        int sheetMergeCount = sheet.getNumMergedRegions();

        for(int i = 0 ; i < sheetMergeCount ; i++){
            CellRangeAddress ca = sheet.getMergedRegion(i);
            int firstColumn = ca.getFirstColumn();
            int lastColumn = ca.getLastColumn();
            int firstRow = ca.getFirstRow();
            int lastRow = ca.getLastRow();

            if(row >= firstRow && row <= lastRow){

                if(column >= firstColumn && column <= lastColumn){
                    Row fRow = sheet.getRow(firstRow);
                    Cell fCell = fRow.getCell(firstColumn);
                    return getCellValue(fCell) ;
                }
            }
        }

        return null ;
    }

    /**
     * 判断合并了行
     * @param sheet
     * @param row
     * @param column
     * @return
     */
    private  boolean isMergedRow(Sheet sheet,int row ,int column) {

        int sheetMergeCount = sheet.getNumMergedRegions();
        for (int i = 0; i < sheetMergeCount; i++) {
            CellRangeAddress range = sheet.getMergedRegion(i);
            int firstColumn = range.getFirstColumn();
            int lastColumn = range.getLastColumn();
            int firstRow = range.getFirstRow();
            int lastRow = range.getLastRow();
            if(row == firstRow && row == lastRow){
                if(column >= firstColumn && column <= lastColumn){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断指定的单元格是否是合并单元格
     * @param sheet
     * @param row 行下标
     * @param column 列下标
     * @return
     */
    private  boolean isMergedRegion(Sheet sheet,int row ,int column) {

        int sheetMergeCount = sheet.getNumMergedRegions();
        for (int i = 0; i < sheetMergeCount; i++) {

            CellRangeAddress range = sheet.getMergedRegion(i);
            int firstColumn = range.getFirstColumn();
            int lastColumn = range.getLastColumn();
            int firstRow = range.getFirstRow();
            int lastRow = range.getLastRow();
            if(row >= firstRow && row <= lastRow){
                if(column >= firstColumn && column <= lastColumn){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断sheet页中是否含有合并单元格
     * @param sheet
     * @return
     */
    private  boolean hasMerged(Sheet sheet) {
        return sheet.getNumMergedRegions() > 0 ? true : false;
    }

    /**
     * 合并单元格
     * @param sheet
     * @param firstRow 开始行
     * @param lastRow 结束行
     * @param firstCol 开始列
     * @param lastCol 结束列
     */
    private  void mergeRegion(Sheet sheet, int firstRow, int lastRow, int firstCol, int lastCol) {
        sheet.addMergedRegion(new CellRangeAddress(firstRow, lastRow, firstCol, lastCol));
    }

    /**
     * 获取单元格的值
     * @param cell
     * @return
     */
    public  String getCellValue(Cell cell){

        if(cell == null) return "";

        if(cell.getCellType() == Cell.CELL_TYPE_STRING){

            return cell.getStringCellValue();

        }else if(cell.getCellType() == Cell.CELL_TYPE_BOOLEAN){

            return String.valueOf(cell.getBooleanCellValue());

        }else if(cell.getCellType() == Cell.CELL_TYPE_FORMULA){

            return cell.getCellFormula() ;

        }else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){

            return String.valueOf(cell.getNumericCellValue());

        }
        return "";
    }
}
