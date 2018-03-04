package com.online.edu.common.util;

import java.awt.Component;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFooter;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

public class FileExportImportUtil {
    InputStream os;
    List<List<String>> list = new ArrayList();
    public HSSFWorkbook demoWorkBook = new HSSFWorkbook();
    public HSSFSheet demoSheet;

    public FileExportImportUtil() {
        this.demoSheet = this.demoWorkBook.createSheet("Sheet1");
    }

    public void createTableRow(List<String> cells, short rowIndex) {
        HSSFRow row = this.demoSheet.createRow(rowIndex);

        for(short i = 0; i < cells.size(); ++i) {
            HSSFCell cell = row.createCell(i);
            cell.setCellValue((String)cells.get(i));
        }

    }

    public void createExcelSheeet() throws SQLException {
        for(int i = 0; i < this.list.size(); ++i) {
            this.createTableRow((List)this.list.get(i), (short)i);
        }

    }

    public InputStream exportExcel(HSSFSheet sheet) throws IOException {
        sheet.setGridsPrinted(true);
        HSSFFooter footer = sheet.getFooter();
        footer.setRight("Page " + HSSFFooter.page() + " of " + HSSFFooter.numPages());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            this.demoWorkBook.write(baos);
        } catch (IOException var5) {
            var5.printStackTrace();
        }

        byte[] ba = baos.toByteArray();
        this.os = new ByteArrayInputStream(ba);
        return this.os;
    }

    public InputStream export(List<List<String>> zlist) {
        InputStream myos = null;

        Object var4;
        try {
            this.list = zlist;
            this.createExcelSheeet();
            myos = this.exportExcel(this.demoSheet);
            InputStream var3 = myos;
            return var3;
        } catch (Exception var14) {
            JOptionPane.showMessageDialog((Component)null, "表格导出出错，错误信息 ：" + var14 + "\n错误原因可能是表格已经打开。");
            var14.printStackTrace();
            var4 = null;
        } finally {
            try {
                this.os.close();
                if (myos != null) {
                    myos.close();
                }
            } catch (Exception var13) {
                var13.printStackTrace();
            }

        }

        return (InputStream)var4;
    }

    public HSSFWorkbook getHSSFWorkbook(List<List<String>> zlist) {
        try {
            this.list = zlist;
            this.createExcelSheeet();
            this.demoSheet.setGridsPrinted(true);
            HSSFFooter footer = this.demoSheet.getFooter();
            footer.setRight("Page " + HSSFFooter.page() + " of " + HSSFFooter.numPages());
            return this.demoWorkBook;
        } catch (Exception var3) {
            JOptionPane.showMessageDialog((Component)null, "表格导出出错，错误信息 ：" + var3 + "\n错误原因可能是表格已经打开。");
            var3.printStackTrace();
            return null;
        }
    }

    public static void createRar(HttpServletResponse response, String dir, List<File> srcfile, String expName) {
        if (!(new File(dir)).exists()) {
            (new File(dir)).mkdirs();
        }

        File zipfile = new File(dir + "/" + expName + ".rar");
        FileUtils.deleteFile(zipfile);

        for(int i = 0; i < srcfile.size(); ++i) {
            FileUtils.deleteFile(new File(dir + "/" + expName + i + ".xls"));
        }

        zipFiles(srcfile, zipfile);

        try {
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(zipfile.getName().getBytes("UTF-8"), "ISO8859-1"));
            response.addHeader("Content-Length", "" + zipfile.length());
            InputStream fis = new BufferedInputStream(new FileInputStream(zipfile));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (IOException var8) {
            var8.printStackTrace();
        }

    }

    public static File createExcel(String[] headName, List<List<String>> list, String expName, String dir) throws Exception {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("sheet1");
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell((short)0);

        int x;
        for(x = 0; x < headName.length; ++x) {
            cell = row.createCell((short)x);
            cell.setCellValue(headName[x]);
        }

        for(x = 0; x < list.size(); ++x) {
            row = sheet.createRow(x + 1);
            List<String> rowString = (List)list.get(x);

            for(int i = 0; i < rowString.size(); ++i) {
                cell = row.createCell((short)i);
                cell.setCellValue((String)rowString.get(i));
            }
        }

        File file = new File(dir + "/" + expName + ".xls");
        if (!(new File(dir)).exists()) {
            (new File(dir)).mkdirs();
        }

        FileOutputStream fos = new FileOutputStream(file);
        workbook.write(fos);
        fos.close();
        return file;
    }

    public static void zipFiles(List<File> srcfile, File zipfile) {
        byte[] buf = new byte[1024];
        String ZIP_ENCODEING = "GBK";

        try {
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipfile));
            out.setEncoding(ZIP_ENCODEING);

            for(int i = 0; i < srcfile.size(); ++i) {
                File file = (File)srcfile.get(i);
                FileInputStream in = new FileInputStream(file);
                out.putNextEntry(new ZipEntry(file.getName()));

                int len;
                while((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }

                out.closeEntry();
                in.close();
            }

            out.close();
        } catch (IOException var9) {
            var9.printStackTrace();
        }

    }
}