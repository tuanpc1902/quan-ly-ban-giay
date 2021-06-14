/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DungChung;

import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 *
 * 
 */
public class ExportExcel {
    public void exportExcel(String title, String sheetName, JTable tbl, int[] colWidth) {
        try {
            Workbook wb = new HSSFWorkbook();
            CreationHelper createHelper = wb.getCreationHelper();
            Sheet sheet = wb.createSheet(sheetName);
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, tbl.getColumnCount() - 1));
            for (int i = 0; i < tbl.getColumnCount(); i++) {
                sheet.setColumnWidth(i, colWidth[i]);
            }
            
            // set font, cỡ chữ, in đậm, màu chữ Title
            HSSFCellStyle style_Title = (HSSFCellStyle) wb.createCellStyle();
            org.apache.poi.ss.usermodel.Font font_Title = wb.createFont();
            font_Title.setFontHeightInPoints((short) 16);
            font_Title.setFontName("Times New Roman");
            font_Title.setColor(IndexedColors.PLUM.getIndex());
            font_Title.setBoldweight((short) 1000);
            style_Title.setFont(font_Title);
            Row row_Title = sheet.createRow(0);
            row_Title.createCell(0).setCellValue(title);
            row_Title.getCell(0).setCellStyle(style_Title);

            // set font, cỡ chữ, in đậm, màu chữ Column Name
            HSSFCellStyle style_ColName = (HSSFCellStyle) wb.createCellStyle();
            org.apache.poi.ss.usermodel.Font font_ColName = wb.createFont();
            font_ColName.setFontHeightInPoints((short) 14);
            font_ColName.setFontName("Times New Roman");
            font_ColName.setColor(IndexedColors.BLACK.getIndex());
            font_ColName.setBoldweight((short) 1000);
            style_ColName.setFont(font_ColName);
            Row row_ColName = sheet.createRow(1);
            for (int i = 0; i < tbl.getColumnCount(); i++) {
                row_ColName.createCell(i).setCellValue(tbl.getColumnName(i));
                row_ColName.getCell(i).setCellStyle(style_ColName);
            }
            
            // set font, cỡ chữ, in đậm, màu chữ Column Name
            HSSFCellStyle style_Data = (HSSFCellStyle) wb.createCellStyle();
            org.apache.poi.ss.usermodel.Font font_Data = wb.createFont();
            font_Data.setFontHeightInPoints((short) 13);
            font_Data.setFontName("Times New Roman");
            font_Data.setColor(IndexedColors.BLACK.getIndex());
            style_Data.setFont(font_Data);
            for (int i = 0; i < tbl.getRowCount(); i++) {
                Row row_Data = sheet.createRow(i + 2);
                for (int j = 0; j < tbl.getColumnCount(); j++) {
                    row_Data.createCell(j).setCellValue(createHelper.createRichTextString(String.valueOf(tbl.getValueAt(i, j))));
                    row_Data.getCell(j).setCellStyle(style_Data);
                }
            }
            JFileChooser chooser = new JFileChooser();
            chooser.setFileFilter(new FileNameExtensionFilter("MS Excel file(.xls)", "xls"));
            int ans = chooser.showSaveDialog(null);
            File file = null;
            if (ans == JFileChooser.APPROVE_OPTION) {
                file = chooser.getSelectedFile();
            }
            FileOutputStream fileOut = new FileOutputStream(file + ".xls");
            wb.write(fileOut);
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
