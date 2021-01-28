package com.test.springtest;

import com.alibaba.fastjson.JSONObject;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@SpringBootTest
class SpringtestApplicationTests {

    @Test
    void contextLoads() {
            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet sheet = wb.createSheet("sheet name");
            sheet.setColumnWidth(0, 256*12+184);
            HSSFRow row0 = sheet.createRow(0);
            row0.createCell(0).setCellValue("第一列");
            row0.createCell(1).setCellValue("第er列");
        try {
            FileOutputStream fileOut = new FileOutputStream("D:\\"+System.currentTimeMillis()+".xls");
            wb.write(fileOut);
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void contextLoads2() {
        Set<String> keySet = new HashSet<String>();
        List<JSONObject> dataList = new ArrayList<JSONObject>();

    }
    @Test
    void contextLoads3() {
        Date date = new Date();
        Long time = date.getTime();
        Long needTime = Integer.valueOf(60*60*1000).longValue();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("date:"+date);
        System.out.println("time:"+time);
        System.out.println("********************************************************");
        Long lastime =time+needTime;
        System.out.println("lastime:"+lastime);
        Date date1 = new Date(lastime);
        System.out.println("date1"+date1);
        System.out.println(lastime>time);
        System.out.println(df.format(date));
        System.out.println(df.format(date1));
        System.out.println("**************************跨年******************************");

        try {
            Date date2 = df.parse("2020-12-31 23:59:41");
            Long thisyear = date2.getTime();
            Long nextyear = thisyear + needTime;
            System.out.println(df.format(date2));
            System.out.println(df.format(new Date(nextyear)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    @Test
    void contextLoads4() {
        String separator = File.separator;
        String FILE_PATH = System.getProperty("user.home")+separator+"接口调用日志";
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
        String name = df.format(date.getTime());
        System.out.println(name);
        File jia = new File(FILE_PATH);
        if(!jia.exists() ||jia.isDirectory()){
            jia.mkdirs();
        }
        File file = new File(FILE_PATH+separator+name+".txt");
        if(!file.exists()){
            try {
                file.createNewFile();
                FileWriter writer = new FileWriter(file , true);
                BufferedWriter out = new BufferedWriter(writer);
                out.write("ninininininin好好哈后");
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    void testOne(){
        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        System.out.println(path);
    }

}
