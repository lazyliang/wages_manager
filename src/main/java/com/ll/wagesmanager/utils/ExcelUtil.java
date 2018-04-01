package com.ll.wagesmanager.utils;


import com.ll.wagesmanager.entity.User;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

/**
 * Create by ll on 2018/4/1.
 */
public class ExcelUtil {


    public static List<User> readXls(String path) throws IOException {
        InputStream is = new FileInputStream(path);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        List<User> list = new ArrayList();
        // 循环工作表Sheet
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }



            // 循环行Row
            for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow == null) {
                    continue;
                }
                User user = new User();
                // 循环列Cell
                for (int cellNum = 0; cellNum <= hssfRow.getLastCellNum(); cellNum++) {
                    HSSFCell hssfCell = hssfRow.getCell(cellNum);

                    if (hssfCell == null) {
                        continue;
                    }if (rowNum>0){
                        if (cellNum ==0) {
                            user.setName(getValue(hssfCell));
                        }else if(cellNum==1){
                            user.setLoginName(getValue(hssfCell));
                        }else if(cellNum==2){
                            user.setPassword(getValue(hssfCell));
                        }
                    }

                }
                if (rowNum>0) {
                    user.setId(UUID.randomUUID().toString());
                    list.add(user);
                }
            }
        }
        return list;
    }

    private static String getValue(HSSFCell hssfCell) {
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            return String.valueOf(hssfCell.getNumericCellValue());
        } else {
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }

    //xlsx
    public static void readXlsx(String fileName) throws IOException{
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook( fileName);

        // 循环工作表Sheet
        for(int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++){
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt( numSheet);
            if(xssfSheet == null){
                continue;
            }

            // 循环行Row
            for(int rowNum = 0; rowNum <= xssfSheet.getLastRowNum(); rowNum++ ){
                XSSFRow xssfRow = xssfSheet.getRow( rowNum);
                if(xssfRow == null){
                    continue;
                }

                // 循环列Cell
                for(int cellNum = 0; cellNum <= xssfRow.getLastCellNum(); cellNum++){
                    XSSFCell xssfCell = xssfRow.getCell( cellNum);
                    if(xssfCell == null){
                        continue;
                    }
                    System.out.print("   "+getsValue(xssfCell));
                }
                System.out.println();
            }
        }
    }
    private static String getsValue(XSSFCell xssfCell){
        if(xssfCell.getCellType() == xssfCell.CELL_TYPE_BOOLEAN){
            return String.valueOf( xssfCell.getBooleanCellValue());
        }else if(xssfCell.getCellType() == xssfCell.CELL_TYPE_NUMERIC){
            return String.valueOf( xssfCell.getNumericCellValue());
        }else{
            return String.valueOf( xssfCell.getStringCellValue());
        }
    }
}
