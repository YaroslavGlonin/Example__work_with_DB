package db;

import javax.swing.Box;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import db.javadbf.DBFException;
import db.javadbf.DBFField;
import db.javadbf.DBFReader;
import db.javadbf.DBFRow;
import db.javadbf.DBFUtils;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class Frame {
    public static void main(String[] args) 
    {
    	render_frame();
    }
    static void render_frame()
    {
    	String[] items = {"PZN","UER","RGN","IND","NNP","ADR","RKC","NAMEP","NEWNUM","NEWKS","TELEF","REGN","OKPO","DATEDEL","KSNP","R_CLOSE"};
  	  	final JFrame frame = new JFrame("Demo");
  	  	final ModelData md = new ModelData();
  	  	final JTable table = new JTable(md);
  	  	final JPanel btnPnl = new JPanel(new BorderLayout());
        final JPanel topBtnPnl = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        final JPanel bottombtnPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
        final JScrollPane jp = new JScrollPane(table);
        JButton btn= new JButton("Add");
        topBtnPnl.add(btn);
        JButton btnd= new JButton("Del");
        topBtnPnl.add(btnd);
        final JComboBox cb = new JComboBox(items);
        topBtnPnl.add(cb);
        JButton btns= new JButton("Sort");
        topBtnPnl.add(btns);
        btnPnl.add(topBtnPnl, BorderLayout.NORTH);
        btnPnl.add(bottombtnPnl, BorderLayout.CENTER);
        table.getTableHeader().setReorderingAllowed(false);
        //---------------------------------------------------
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
          	  md.addtoarr();
          	  frame.remove(jp);
          	  frame.add(jp, BorderLayout.CENTER);
            }
       });
        btnd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
          	//  System.out.println(String.valueOf(table.getSelectedRow()));
            	md.deltoarr(table.getSelectedRow());
          	  frame.remove(jp);
          	  frame.add(jp, BorderLayout.CENTER);
            }
       });
        btns.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
          	  System.out.println(String.valueOf(cb.getSelectedItem()));
          	 md.sortarr(String.valueOf(cb.getSelectedItem()));
          	  frame.remove(jp);
          	  frame.add(jp, BorderLayout.CENTER);
            }
       });
        //-----------------------------------------------------
  	  TableColumn col = table.getColumnModel().getColumn(2);
  	  col.setCellEditor(new ComboBoxEditor(md.srgn));
  	  TableColumn col1 = table.getColumnModel().getColumn(4);
  	  col1.setCellEditor(new ComboBoxEditor(md.stnp));
  	  TableColumn col2 = table.getColumnModel().getColumn(0);
  	  col2.setCellEditor(new ComboBoxEditor(md.spzn));
  	  TableColumn col3 = table.getColumnModel().getColumn(1);
  	  col3.setCellEditor(new ComboBoxEditor(md.suer));
  	  //---------------------------------------------------
        frame.add(table.getTableHeader(), BorderLayout.NORTH);
        frame.add(btnPnl, BorderLayout.SOUTH);
        frame.add(jp, BorderLayout.CENTER);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1500, 600);
        frame.setVisible(true);
    }
}

