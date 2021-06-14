/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DungChung;

import Connect.getConnection;
import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;
import static java.awt.Frame.HAND_CURSOR;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * 
 */
public class DungChung extends getConnection {

    public PreparedStatement prepareStatement(String sql, Object[] args) throws SQLException {
        PreparedStatement ps = con.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            ps.setObject(i + 1, args[i]);
        }
        return ps;
    }

    public void statement(String sql, JTable tbl, String[] header) throws SQLException {
        DefaultTableModel model = new DefaultTableModel(header, 0);
        tbl.setDefaultEditor(Object.class, null);
        tbl.getTableHeader().setCursor(new Cursor(HAND_CURSOR));
        tbl.getTableHeader().setFont(new Font("Segoe UI", 1, 13));
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Vector data = new Vector();
            for (int i = 0; i < header.length; i++) {
                data.add(rs.getObject(i + 1));
            }
            model.addRow(data);
        }
        tbl.setModel(model);
        con.close();
    }

    public void hoverButton(int so, JLabel lbl, String hinh) {
        if (so == 1) {
            ImageIcon icon = new ImageIcon("src//Hinh//" + hinh);
            lbl.setIcon(icon);
            lbl.setCursor(new Cursor(HAND_CURSOR));
        } else {
            ImageIcon icon = new ImageIcon("src//Hinh//" + hinh);
            lbl.setIcon(icon);
        }
    }
    
    public void hoverButton5(int so, JButton btn, String hinh) {
        if (so == 1) {
            ImageIcon icon = new ImageIcon("src//Hinh//" + hinh);
            btn.setIcon(icon);
            btn.setCursor(new Cursor(HAND_CURSOR));
        } else {
            ImageIcon icon = new ImageIcon("src//Hinh//" + hinh);
            btn.setIcon(icon);
        }
    }

    public void transTXT(JTextField[] txts) {
        for (JTextField txt : txts) {
            txt.setBackground(new Color(0, 0, 0, 0));
        }
    }

    public void hideLBLError(JLabel[] lbls) {
        for (JLabel lbl : lbls) {
            lbl.setVisible(false);
        }
    }

    public boolean check(JLabel[] lbl, JTextField[] txt) {
        for (int i = 0; i < txt.length; i++) {
            if (txt[i].getText().isEmpty() || txt[i].getText().equals("0")) {
                lbl[i].setVisible(true);
                txt[i].requestFocus();
                return false;
            }
        }
        return true;
    }

    public void reset(JTextField[] txts) {
        for (JTextField txt : txts) {
            txt.setText(null);
        }
        txts[0].requestFocus();
        txts[0].setEditable(true);
    }

    public void thoat() {
        int r = JOptionPane.showConfirmDialog(null, "Bạn thật sự muốn thoát?", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (r == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public void xetSo(JTextField txt) {
        txt.setText(txt.getText().replaceFirst("[ a-zA-Z]", ""));
    }

    public void editColumnWidth(int[] col, JTable tbl) {
        for (int i = 0; i < tbl.getColumnCount(); i++) {
            TableColumn column = tbl.getColumnModel().getColumn(i);
            column.setMinWidth(col[i]);
            column.setMaxWidth(col[i]);
            column.setPreferredWidth(col[i]);
        }
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tbl.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        ((DefaultTableCellRenderer) tbl.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
    }
    
    
    public void hoverButtonqaz(int so, JButton btn, String hinh) {
        if (so == 1) {
            ImageIcon icon = new ImageIcon("src//Hinh//" + hinh);
            btn.setIcon(icon);
            btn.setCursor(new Cursor(HAND_CURSOR));
        } else {
            ImageIcon icon = new ImageIcon("src//Hinh//" + hinh);
            btn.setIcon(icon);
        }
    }
}
