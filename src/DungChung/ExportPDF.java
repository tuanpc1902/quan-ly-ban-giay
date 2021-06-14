/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DungChung;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * 
 */
public class ExportPDF {
    public void exportPDF(String title, JTable tbl){
        try {
            Document document = new Document(PageSize.A3);
            JFileChooser chooser = new JFileChooser();
            chooser.setFileFilter(new FileNameExtensionFilter("PDF(.pdf)", "pdf"));
            int ans = chooser.showSaveDialog(null);
            File file = null;
            if (ans == JFileChooser.APPROVE_OPTION) {
                file = chooser.getSelectedFile();
            }
            PdfWriter.getInstance(document, new FileOutputStream(file + ".pdf"));
            BaseFont baseFont = BaseFont.createFont("src//Font//TIMES.TTF", BaseFont.IDENTITY_H, true);
            document.open();
            
            // Thiết kế Title
            Font font_Title = new Font(baseFont, 16);
            font_Title.setStyle(1);
            document.add(new Paragraph(title, font_Title));
            document.add(new Paragraph(Chunk.NEWLINE));
            
            //Thiết kế Column Name
            Font font_Col = new Font(baseFont, 14);
            font_Col.setStyle(1);
            PdfPTable table_Col = new PdfPTable(tbl.getColumnCount());
            for(int i = 0; i < tbl.getColumnCount(); i++){
                table_Col.addCell(new Paragraph(tbl.getColumnName(i), font_Col));
            }
            document.add(table_Col);
            
            // Thiết kế Data
            Font font_Data = new Font(baseFont, 14);
            for(int i = 0; i < tbl.getRowCount(); i++){
                PdfPTable table = new PdfPTable(tbl.getColumnCount());
                for(int j = 0; j < tbl.getColumnCount(); j++){
                    table.addCell(new Paragraph(String.valueOf(tbl.getValueAt(i, j)), font_Data));
                }
                document.add(table);
            }
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
