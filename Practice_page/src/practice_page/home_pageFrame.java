/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package practice_page;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import java.sql.ResultSet;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Asus
 */
public class home_pageFrame extends javax.swing.JFrame {

    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));

    }
    private Object PlotOrientation;

    Color white, defaultColor;
    DefaultTableModel model;
    /**
     * Creates new form home_pageFrame
     */
    public home_pageFrame() {
        initComponents();
        showPieChart();
        white = new Color(255,255,255);
        defaultColor = new Color(153,153,153);
        SetBookDetailsToTable();
        SetDataToCards();
    }

    public final void showPieChart(){
        
        //create dataset
      DefaultPieDataset barDataset = new DefaultPieDataset( );
      barDataset.setValue("English" , Double.valueOf(20));  
      barDataset.setValue("Management" , Double.valueOf(20));   
      barDataset.setValue("Information Technology" , Double.valueOf(40));    
      barDataset.setValue("Engineering" , Double.valueOf(10));  
      
      //create chart
       JFreeChart piechart = ChartFactory.createPieChart("Available Books",barDataset, false,true,false);//explain
      
        PiePlot piePlot = (PiePlot) piechart.getPlot();

      
       //changing pie chart blocks colors
        piePlot.setSectionPaint("English", new Color(255,255,102));
        piePlot.setSectionPaint("Management", new Color(102,255,102));
        piePlot.setSectionPaint("Information Technology", new Color(255,102,153));
        piePlot.setSectionPaint("Engineering", new Color(0,204,204));
      
       
        piePlot.setBackgroundPaint(Color.white);
        
        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        panelBarChart.removeAll();
        panelBarChart.add(barChartPanel, BorderLayout.CENTER);
        panelBarChart.validate();
    }

    public void SetBookDetailsToTable(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "");
            java.sql.Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select* from books");
             
            while(rs.next()){
                String bookId = rs.getString("book_id");
                String bookName = rs.getString("book_name");
                String Author = rs.getString("author_name");
                int Quantity = rs.getInt("quantity");
                
                Object[] obj = {bookId, bookName, Author, Quantity};
                model = (DefaultTableModel)bookTable.getModel();
                model.addRow(obj);
                   
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void SetDataToCards(){
    java.sql.Statement st = null;
    ResultSet rs = null;
    
    
    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "");
        // Create a statement with a scrollable ResultSet
        st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        rs = st.executeQuery("select * from books");
        rs.last();  // Now this works
        noBookLbl.setText(Integer.toString(rs.getRow()));
        
        rs = st.executeQuery("select * from student");
        rs.last();
        noStuLbl.setText(Integer.toString(rs.getRow()));
        
        rs = st.executeQuery("select * from issue_details");
        rs.last();
        noIssueLbl.setText(Integer.toString(rs.getRow()));
        
        rs = st.executeQuery("select * from return_details");
        rs.last();
        noRetLbl.setText(Integer.toString(rs.getRow()));
        
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        // Close resources in a finally block to avoid memory leaks
        try {
            if (rs != null) rs.close();
            if (st != null) st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSCalendarBeanInfo1 = new rojeru_san.componentes.RSCalendarBeanInfo();
        jPanel1 = new javax.swing.JPanel();
        menuLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        stuLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        bookLabel = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        issueLabel = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        returnLabel = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        logoutLabel = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        issueDetailsLabel = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel155 = new javax.swing.JLabel();
        returnDetailsLabel = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        dashPanel = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        noBookLbl = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        noStuLbl = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        noIssueLbl = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        noRetLbl = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        panelBarChart = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookTable = new rojerusan.RSTableMetro();
        bookPanel = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        bookNField = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        authorNField = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        quanField = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        clearBookBtn = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        upId = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        upBook = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        upAuthor = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        upQuan = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        clearUpBookBtn = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        rId = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        rbookName = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        rauthorName = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        rquantity = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        clearRemBookBtn = new javax.swing.JButton();
        stuPanel = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        stuidFrame = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        stunameFrame = new javax.swing.JTextField();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        emailFrame = new javax.swing.JTextField();
        jLabel88 = new javax.swing.JLabel();
        stuaddBtn = new javax.swing.JButton();
        clearStuBtn1 = new javax.swing.JButton();
        courseFrame3 = new javax.swing.JComboBox<>();
        jPanel22 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        stuUpId = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        stuUpName = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        UpEmail = new javax.swing.JTextField();
        StuUpBtn = new javax.swing.JButton();
        findToUpBtn = new javax.swing.JButton();
        clearUpStuBtn = new javax.swing.JButton();
        upCourse = new javax.swing.JComboBox<>();
        jPanel24 = new javax.swing.JPanel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        rSid = new javax.swing.JTextField();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        rSname = new javax.swing.JTextField();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        rEmail = new javax.swing.JTextField();
        removeBtn = new javax.swing.JButton();
        findToRemoveBtn = new javax.swing.JButton();
        clearRemStuBtn = new javax.swing.JButton();
        rCourse = new javax.swing.JComboBox<>();
        issuePanel = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        bookNField1 = new javax.swing.JTextField();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        authorNField1 = new javax.swing.JTextField();
        jLabel106 = new javax.swing.JLabel();
        quanField1 = new javax.swing.JTextField();
        jLabel107 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        detailsFindBtn = new javax.swing.JButton();
        clearBtn2 = new javax.swing.JButton();
        jPanel26 = new javax.swing.JPanel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        stunameFrame1 = new javax.swing.JTextField();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        courseFrame1 = new javax.swing.JTextField();
        jLabel116 = new javax.swing.JLabel();
        emailFrame1 = new javax.swing.JTextField();
        jLabel117 = new javax.swing.JLabel();
        studentDetailsFind = new javax.swing.JButton();
        clearBtn1 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        bookIdField = new javax.swing.JTextField();
        jLabel111 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        issueBtn = new javax.swing.JButton();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        studentIdField1 = new javax.swing.JTextField();
        jLabel122 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        issueId = new javax.swing.JTextField();
        clearBtn = new javax.swing.JButton();
        returnDateChooser = new com.toedter.calendar.JDateChooser();
        issueDateChooser = new com.toedter.calendar.JDateChooser();
        returnPanel = new javax.swing.JPanel();
        issuePanel1 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        bookNField2 = new javax.swing.JTextField();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        authorNField2 = new javax.swing.JTextField();
        jLabel130 = new javax.swing.JLabel();
        quanField2 = new javax.swing.JTextField();
        jLabel131 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        detailsFindBtn1 = new javax.swing.JButton();
        clearBtn3 = new javax.swing.JButton();
        jLabel150 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        issueDateField1 = new javax.swing.JTextField();
        jLabel145 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        returnDateField1 = new javax.swing.JTextField();
        jPanel28 = new javax.swing.JPanel();
        jLabel134 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        stunameFrame2 = new javax.swing.JTextField();
        jLabel136 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        courseFrame2 = new javax.swing.JTextField();
        jLabel140 = new javax.swing.JLabel();
        emailFrame2 = new javax.swing.JTextField();
        jLabel141 = new javax.swing.JLabel();
        studentDetailsFind1 = new javax.swing.JButton();
        clearBtn4 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        jLabel143 = new javax.swing.JLabel();
        jLabel144 = new javax.swing.JLabel();
        bookIdField1 = new javax.swing.JTextField();
        returnBookBtn = new javax.swing.JButton();
        jLabel147 = new javax.swing.JLabel();
        studentIdField2 = new javax.swing.JTextField();
        jLabel149 = new javax.swing.JLabel();
        jLabel151 = new javax.swing.JLabel();
        jLabel152 = new javax.swing.JLabel();
        returnIdField = new javax.swing.JTextField();
        clearBtn5 = new javax.swing.JButton();
        jLabel153 = new javax.swing.JLabel();
        jLabel154 = new javax.swing.JLabel();
        issueIDField = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        issueDetailsPanel = new javax.swing.JPanel();
        jLabel157 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel158 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        issueDetailsTable = new javax.swing.JTable();
        returnDetailsPanel = new javax.swing.JPanel();
        issueDetailsPanel2 = new javax.swing.JPanel();
        jLabel160 = new javax.swing.JLabel();
        returnSearch = new javax.swing.JTextField();
        jLabel161 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        returnDetailsTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1520, 830));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/saegis logo.png"))); // NOI18N
        jPanel1.add(menuLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 11, 70, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LIBRARY MANAGEMENT SYSTEM");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 13, 640, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("SAEGIS");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 13, 160, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/male_user_50px.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 10, 60, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("WELCOME");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1380, 13, 140, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1520, 70));

        jPanel2.setBackground(new java.awt.Color(54, 70, 78));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 0, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Home_26px_2.png"))); // NOI18N
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 56));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Dashboard");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 210, 37));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 270, 60));

        jPanel6.setBackground(new java.awt.Color(54, 70, 78));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(54, 70, 78));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(54, 70, 78));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Book_Shelf_50px.png"))); // NOI18N
        jPanel9.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 55));

        jPanel8.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 320, 60));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Conference_26px.png"))); // NOI18N
        jPanel8.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 55));

        stuLabel.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        stuLabel.setForeground(new java.awt.Color(153, 153, 153));
        stuLabel.setText("Manage Students");
        stuLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        stuLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stuLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stuLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stuLabelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                stuLabelMousePressed(evt);
            }
        });
        jPanel8.add(stuLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 6, 200, 40));

        jPanel6.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 270, 60));

        jPanel4.setBackground(new java.awt.Color(54, 70, 78));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Books_26px.png"))); // NOI18N
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 56));

        jPanel5.setBackground(new java.awt.Color(54, 70, 78));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Book_Shelf_50px.png"))); // NOI18N
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 55));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 320, 60));

        bookLabel.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        bookLabel.setForeground(new java.awt.Color(153, 153, 153));
        bookLabel.setText("Manage Books");
        bookLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bookLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bookLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bookLabelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bookLabelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bookLabelMouseReleased(evt);
            }
        });
        jPanel4.add(bookLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 7, 150, 40));

        jPanel6.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 270, 60));

        jPanel7.setBackground(new java.awt.Color(54, 70, 78));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(54, 70, 78));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel7.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 270, 60));

        jPanel11.setBackground(new java.awt.Color(54, 70, 78));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBackground(new java.awt.Color(54, 70, 78));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel11.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 270, 60));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Sell_26px.png"))); // NOI18N
        jPanel11.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 55));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(153, 153, 153));
        jLabel16.setText("Issue Books");
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel11.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 5, 200, 40));

        jPanel7.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 270, 100));

        issueLabel.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        issueLabel.setForeground(new java.awt.Color(153, 153, 153));
        issueLabel.setText("Issue Books");
        issueLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        issueLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                issueLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                issueLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                issueLabelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                issueLabelMousePressed(evt);
            }
        });
        jPanel7.add(issueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 5, 200, 40));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Sell_26px.png"))); // NOI18N
        jPanel7.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 55));

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 270, 60));

        jPanel13.setBackground(new java.awt.Color(54, 70, 78));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        returnLabel.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        returnLabel.setForeground(new java.awt.Color(153, 153, 153));
        returnLabel.setText("Return Books");
        returnLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        returnLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                returnLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                returnLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                returnLabelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                returnLabelMousePressed(evt);
            }
        });
        jPanel13.add(returnLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 6, 200, 40));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Return_Purchase_26px.png"))); // NOI18N
        jPanel13.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 55));

        jPanel6.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 270, 60));

        jPanel14.setBackground(new java.awt.Color(54, 70, 78));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Exit_26px.png"))); // NOI18N
        jPanel14.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 55));

        logoutLabel.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        logoutLabel.setForeground(new java.awt.Color(153, 153, 153));
        logoutLabel.setText("Logout");
        logoutLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutLabelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                logoutLabelMousePressed(evt);
            }
        });
        jPanel14.add(logoutLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 5, 200, 40));

        jPanel6.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 270, 60));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(153, 153, 153));
        jLabel21.setText("Copyright @2024.");
        jPanel6.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, 140, 30));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Ashen Gimhana.");
        jPanel6.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 610, 140, 30));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(153, 153, 153));
        jLabel23.setText("All Right Received.");
        jPanel6.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 580, 140, 30));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(153, 153, 153));
        jLabel24.setText("Developed by");
        jPanel6.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 610, 100, 30));

        jPanel29.setBackground(new java.awt.Color(54, 70, 78));
        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        issueDetailsLabel.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        issueDetailsLabel.setForeground(new java.awt.Color(153, 153, 153));
        issueDetailsLabel.setText("Issued Details");
        issueDetailsLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        issueDetailsLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                issueDetailsLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                issueDetailsLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                issueDetailsLabelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                issueDetailsLabelMousePressed(evt);
            }
        });
        jPanel29.add(issueDetailsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 3, 200, 40));

        jLabel156.setBackground(new java.awt.Color(255, 255, 255));
        jLabel156.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-borrow-book-26.png"))); // NOI18N
        jPanel29.add(jLabel156, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 55));

        jPanel6.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 270, 60));

        jPanel30.setBackground(new java.awt.Color(54, 70, 78));
        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel155.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-details-26.png"))); // NOI18N
        jPanel30.add(jLabel155, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 40, 50));

        returnDetailsLabel.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        returnDetailsLabel.setForeground(new java.awt.Color(153, 153, 153));
        returnDetailsLabel.setText("Return Details");
        returnDetailsLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        returnDetailsLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                returnDetailsLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                returnDetailsLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                returnDetailsLabelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                returnDetailsLabelMousePressed(evt);
            }
        });
        jPanel30.add(returnDetailsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 5, 200, 40));

        jPanel6.add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 270, 50));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 270, 770));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 270, 780));

        dashPanel.setBackground(new java.awt.Color(255, 255, 255));
        dashPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel15.setBackground(new java.awt.Color(0, 204, 255));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Book_Shelf_50px.png"))); // NOI18N
        jPanel15.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 60, 60));

        noBookLbl.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        noBookLbl.setForeground(new java.awt.Color(255, 255, 255));
        noBookLbl.setText("31");
        jPanel15.add(noBookLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 70, 50));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Total Books");
        jPanel15.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 80, 120, 40));

        dashPanel.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 280, 170));

        jPanel16.setBackground(new java.awt.Color(3, 195, 3));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_People_50px.png"))); // NOI18N
        jPanel16.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 60, 60));

        noStuLbl.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        noStuLbl.setForeground(new java.awt.Color(255, 255, 255));
        noStuLbl.setText("21");
        jPanel16.add(noStuLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 30, 70, 50));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Total Students");
        jPanel16.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 140, 40));

        dashPanel.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 280, 170));

        jPanel17.setBackground(new java.awt.Color(248, 128, 48));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Total Issued Books");
        jPanel17.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 170, 40));

        noIssueLbl.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        noIssueLbl.setForeground(new java.awt.Color(255, 255, 255));
        noIssueLbl.setText("07");
        jPanel17.add(noIssueLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 70, 50));

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Sell_50px.png"))); // NOI18N
        jPanel17.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 60, 60));

        dashPanel.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, 280, 170));

        jPanel18.setBackground(new java.awt.Color(255, 0, 0));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        noRetLbl.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        noRetLbl.setForeground(new java.awt.Color(255, 255, 255));
        noRetLbl.setText("05");
        jPanel18.add(noRetLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 70, 50));

        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-return-book-50.png"))); // NOI18N
        jPanel18.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 60, 60));

        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Total Return Books");
        jPanel18.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 170, 40));

        dashPanel.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 100, 280, 170));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel25.setText("Dashboard");
        dashPanel.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 210, 40));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel30.setText("No. Of Return Books");
        dashPanel.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 70, 150, 30));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel31.setText("No. Of Books");
        dashPanel.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 110, 30));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel32.setText("No. Of Students");
        dashPanel.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 110, 30));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel33.setText("No. Of Issued Books");
        dashPanel.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, 160, 30));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        dashPanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 1210, 10));
        dashPanel.add(panelBarChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 640, 460));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        bookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book Id", "Book Name", "Author", "Quantity"
            }
        ));
        bookTable.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        bookTable.setGridColor(new java.awt.Color(255, 255, 255));
        bookTable.setRowHeight(30);
        jScrollPane1.setViewportView(bookTable);

        dashPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 300, 550, 460));

        jTabbedPane1.addTab("tab1", dashPanel);

        bookPanel.setBackground(new java.awt.Color(255, 255, 255));
        bookPanel.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                bookPanelAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        bookPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel19.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 2, new java.awt.Color(0, 0, 0)));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 51, 51));
        jLabel10.setText("Add Book");
        jPanel19.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 200, 50));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/book-entry (1).png"))); // NOI18N
        jPanel19.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 60, 50));

        idField.setBackground(new java.awt.Color(242, 242, 242));
        idField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        idField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel19.add(idField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 290, 40));

        jLabel48.setBackground(new java.awt.Color(0, 0, 0));
        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-id-35.png"))); // NOI18N
        jPanel19.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 60, 50));

        jLabel49.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel49.setText("Book ID");
        jPanel19.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 230, 30));

        bookNField.setBackground(new java.awt.Color(242, 242, 242));
        bookNField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bookNField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel19.add(bookNField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 290, 40));

        jLabel50.setBackground(new java.awt.Color(0, 0, 0));
        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-book-35.png"))); // NOI18N
        jPanel19.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 60, 50));

        jLabel51.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel51.setText("Book Name");
        jPanel19.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 230, 30));

        jLabel52.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel52.setText("Author Name");
        jPanel19.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 230, 30));

        jLabel53.setBackground(new java.awt.Color(0, 0, 0));
        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-person-35.png"))); // NOI18N
        jPanel19.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 60, 50));

        authorNField.setBackground(new java.awt.Color(242, 242, 242));
        authorNField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        authorNField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel19.add(authorNField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 290, 40));

        jLabel54.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel54.setText("Quantity");
        jPanel19.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, 230, 30));

        quanField.setBackground(new java.awt.Color(242, 242, 242));
        quanField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        quanField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel19.add(quanField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 480, 290, 40));

        jLabel55.setBackground(new java.awt.Color(0, 0, 0));
        jLabel55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-unit-35.png"))); // NOI18N
        jPanel19.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 60, 50));

        jButton1.setBackground(new java.awt.Color(102, 102, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add Book");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel19.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 590, 240, 40));

        clearBookBtn.setBackground(new java.awt.Color(102, 102, 255));
        clearBookBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        clearBookBtn.setForeground(new java.awt.Color(255, 255, 255));
        clearBookBtn.setText("Clear Details");
        clearBookBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearBookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBookBtnActionPerformed(evt);
            }
        });
        jPanel19.add(clearBookBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 660, 240, 40));

        bookPanel.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 770));

        jPanel20.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 0, 2, new java.awt.Color(0, 0, 0)));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/book-writing--removebg-preview (1).png"))); // NOI18N
        jPanel20.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 60, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 51, 51));
        jLabel14.setText("Update Book");
        jPanel20.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 240, 50));

        jLabel56.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel56.setText("Book ID");
        jPanel20.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 230, 30));

        jLabel57.setBackground(new java.awt.Color(0, 0, 0));
        jLabel57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-id-35.png"))); // NOI18N
        jPanel20.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 60, 50));

        upId.setBackground(new java.awt.Color(242, 242, 242));
        upId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        upId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel20.add(upId, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 230, 40));

        jLabel58.setBackground(new java.awt.Color(0, 0, 0));
        jLabel58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-book-35.png"))); // NOI18N
        jPanel20.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 60, 50));

        jLabel59.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel59.setText("Book Name");
        jPanel20.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 230, 30));

        upBook.setBackground(new java.awt.Color(242, 242, 242));
        upBook.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        upBook.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel20.add(upBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 290, 40));

        jLabel60.setBackground(new java.awt.Color(0, 0, 0));
        jLabel60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-person-35.png"))); // NOI18N
        jPanel20.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 60, 50));

        jLabel61.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel61.setText("Author Name");
        jPanel20.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 230, 30));

        upAuthor.setBackground(new java.awt.Color(242, 242, 242));
        upAuthor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        upAuthor.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel20.add(upAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 290, 40));

        jLabel62.setBackground(new java.awt.Color(0, 0, 0));
        jLabel62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-unit-35.png"))); // NOI18N
        jPanel20.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 60, 50));

        jLabel63.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel63.setText("Quantity");
        jPanel20.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, 230, 30));

        upQuan.setBackground(new java.awt.Color(242, 242, 242));
        upQuan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        upQuan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel20.add(upQuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 480, 290, 40));

        jButton2.setBackground(new java.awt.Color(102, 102, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Update Book");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel20.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 590, 240, 40));

        jButton5.setBackground(new java.awt.Color(255, 0, 51));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Find");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel20.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 70, -1));

        clearUpBookBtn.setBackground(new java.awt.Color(102, 102, 255));
        clearUpBookBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        clearUpBookBtn.setForeground(new java.awt.Color(255, 255, 255));
        clearUpBookBtn.setText("Clear Details");
        clearUpBookBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearUpBookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearUpBookBtnActionPerformed(evt);
            }
        });
        jPanel20.add(clearUpBookBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 660, 240, 40));

        bookPanel.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 0, 400, 770));

        jPanel21.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 0, 0, new java.awt.Color(0, 0, 0)));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/remove-book-.png"))); // NOI18N
        jPanel21.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 60, -1));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 51, 51));
        jLabel26.setText("Remove Book");
        jPanel21.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 240, 50));

        jLabel64.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel64.setText("Book ID");
        jPanel21.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 230, 30));

        jLabel65.setBackground(new java.awt.Color(0, 0, 0));
        jLabel65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-id-35.png"))); // NOI18N
        jPanel21.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 60, 50));

        rId.setBackground(new java.awt.Color(242, 242, 242));
        rId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel21.add(rId, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 230, 40));

        jLabel66.setBackground(new java.awt.Color(0, 0, 0));
        jLabel66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-book-35.png"))); // NOI18N
        jPanel21.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 60, 50));

        jLabel67.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel67.setText("Book Name");
        jPanel21.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 230, 30));

        rbookName.setBackground(new java.awt.Color(242, 242, 242));
        rbookName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbookName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel21.add(rbookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 290, 40));

        jLabel68.setBackground(new java.awt.Color(0, 0, 0));
        jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-person-35.png"))); // NOI18N
        jPanel21.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 60, 50));

        jLabel69.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel69.setText("Author Name");
        jPanel21.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 230, 30));

        rauthorName.setBackground(new java.awt.Color(242, 242, 242));
        rauthorName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rauthorName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel21.add(rauthorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 290, 40));

        jLabel70.setBackground(new java.awt.Color(0, 0, 0));
        jLabel70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-unit-35.png"))); // NOI18N
        jPanel21.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 60, 50));

        jLabel71.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel71.setText("Quantity");
        jPanel21.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, 230, 30));

        rquantity.setBackground(new java.awt.Color(242, 242, 242));
        rquantity.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rquantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel21.add(rquantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 480, 290, 40));

        jButton3.setBackground(new java.awt.Color(102, 102, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Remove Book");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel21.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 590, 240, 40));

        jButton4.setBackground(new java.awt.Color(255, 0, 51));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Find");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel21.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 70, -1));

        clearRemBookBtn.setBackground(new java.awt.Color(102, 102, 255));
        clearRemBookBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        clearRemBookBtn.setForeground(new java.awt.Color(255, 255, 255));
        clearRemBookBtn.setText("Clear Details");
        clearRemBookBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearRemBookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearRemBookBtnActionPerformed(evt);
            }
        });
        jPanel21.add(clearRemBookBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 660, 240, 40));

        bookPanel.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, 400, 770));

        jTabbedPane1.addTab("tab2", bookPanel);

        stuPanel.setBackground(new java.awt.Color(255, 255, 255));
        stuPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel23.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 2, new java.awt.Color(0, 0, 0)));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 51, 51));
        jLabel27.setText("Add Student");
        jPanel23.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 45, 230, 50));

        jLabel80.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-student-registration-50.png"))); // NOI18N
        jPanel23.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 47, 60, 50));

        stuidFrame.setBackground(new java.awt.Color(242, 242, 242));
        stuidFrame.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        stuidFrame.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel23.add(stuidFrame, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 290, 40));

        jLabel81.setBackground(new java.awt.Color(0, 0, 0));
        jLabel81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-security-pass-35.png"))); // NOI18N
        jPanel23.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 60, 50));

        jLabel82.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel82.setText("Student ID");
        jPanel23.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 230, 30));

        stunameFrame.setBackground(new java.awt.Color(242, 242, 242));
        stunameFrame.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        stunameFrame.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel23.add(stunameFrame, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 290, 40));

        jLabel83.setBackground(new java.awt.Color(0, 0, 0));
        jLabel83.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-student-35.png"))); // NOI18N
        jPanel23.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 60, 50));

        jLabel84.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel84.setText("Student Name");
        jPanel23.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 230, 30));

        jLabel85.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel85.setText("Course Program");
        jPanel23.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 230, 30));

        jLabel86.setBackground(new java.awt.Color(0, 0, 0));
        jLabel86.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-degree-35.png"))); // NOI18N
        jPanel23.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 60, 50));

        jLabel87.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel87.setText("E-mail");
        jPanel23.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, 230, 30));

        emailFrame.setBackground(new java.awt.Color(242, 242, 242));
        emailFrame.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        emailFrame.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel23.add(emailFrame, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 480, 290, 40));

        jLabel88.setBackground(new java.awt.Color(0, 0, 0));
        jLabel88.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-email-35.png"))); // NOI18N
        jPanel23.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 60, 50));

        stuaddBtn.setBackground(new java.awt.Color(102, 102, 255));
        stuaddBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        stuaddBtn.setForeground(new java.awt.Color(255, 255, 255));
        stuaddBtn.setText("Add Student");
        stuaddBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        stuaddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuaddBtnActionPerformed(evt);
            }
        });
        jPanel23.add(stuaddBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 590, 240, 40));

        clearStuBtn1.setBackground(new java.awt.Color(102, 102, 255));
        clearStuBtn1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        clearStuBtn1.setForeground(new java.awt.Color(255, 255, 255));
        clearStuBtn1.setText("Clear Details");
        clearStuBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearStuBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearStuBtn1ActionPerformed(evt);
            }
        });
        jPanel23.add(clearStuBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 660, 240, 40));

        courseFrame3.setBackground(new java.awt.Color(242, 242, 242));
        courseFrame3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        courseFrame3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "B.Sc.(Hons) in Computer Science", "B.Sc.(Hons) in Software Engineering", "B.Sc.(Hons) in Information Technology", "Bachelor Of Information Technology" }));
        courseFrame3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        courseFrame3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseFrame3ActionPerformed(evt);
            }
        });
        jPanel23.add(courseFrame3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, 290, 40));

        stuPanel.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 770));

        jPanel22.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 0, 2, new java.awt.Color(0, 0, 0)));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-change-user-50.png"))); // NOI18N
        jPanel22.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 45, 60, -1));

        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 51, 51));
        jLabel47.setText("Update Student");
        jPanel22.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 45, 280, 50));

        jLabel72.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel72.setText("Student ID");
        jPanel22.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 230, 30));

        jLabel73.setBackground(new java.awt.Color(0, 0, 0));
        jLabel73.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-security-pass-35.png"))); // NOI18N
        jPanel22.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 60, 50));

        stuUpId.setBackground(new java.awt.Color(242, 242, 242));
        stuUpId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        stuUpId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel22.add(stuUpId, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 230, 40));

        jLabel74.setBackground(new java.awt.Color(0, 0, 0));
        jLabel74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-student-35.png"))); // NOI18N
        jPanel22.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 60, 50));

        jLabel75.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel75.setText("Student Name");
        jPanel22.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 230, 30));

        stuUpName.setBackground(new java.awt.Color(242, 242, 242));
        stuUpName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        stuUpName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel22.add(stuUpName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 290, 40));

        jLabel76.setBackground(new java.awt.Color(0, 0, 0));
        jLabel76.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-degree-35.png"))); // NOI18N
        jPanel22.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 60, 50));

        jLabel77.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel77.setText("Course Program");
        jPanel22.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 230, 30));

        jLabel78.setBackground(new java.awt.Color(0, 0, 0));
        jLabel78.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-email-35.png"))); // NOI18N
        jPanel22.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 60, 50));

        jLabel79.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel79.setText("E-mail");
        jPanel22.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, 230, 30));

        UpEmail.setBackground(new java.awt.Color(242, 242, 242));
        UpEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        UpEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel22.add(UpEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 480, 290, 40));

        StuUpBtn.setBackground(new java.awt.Color(102, 102, 255));
        StuUpBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        StuUpBtn.setForeground(new java.awt.Color(255, 255, 255));
        StuUpBtn.setText("Update Student");
        StuUpBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        StuUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StuUpBtnActionPerformed(evt);
            }
        });
        jPanel22.add(StuUpBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 590, 240, 40));

        findToUpBtn.setBackground(new java.awt.Color(255, 0, 51));
        findToUpBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        findToUpBtn.setForeground(new java.awt.Color(255, 255, 255));
        findToUpBtn.setText("Find");
        findToUpBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        findToUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findToUpBtnActionPerformed(evt);
            }
        });
        jPanel22.add(findToUpBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 70, -1));

        clearUpStuBtn.setBackground(new java.awt.Color(102, 102, 255));
        clearUpStuBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        clearUpStuBtn.setForeground(new java.awt.Color(255, 255, 255));
        clearUpStuBtn.setText("Clear Details");
        clearUpStuBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearUpStuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearUpStuBtnActionPerformed(evt);
            }
        });
        jPanel22.add(clearUpStuBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 660, 240, 40));

        upCourse.setBackground(new java.awt.Color(242, 242, 242));
        upCourse.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        upCourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "B.Sc.(Hons) in Computer Science", "B.Sc.(Hons) in Software Engineering", "B.Sc.(Hons) in Information Technology", "Bachelor Of Information Technology" }));
        upCourse.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        upCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upCourseActionPerformed(evt);
            }
        });
        jPanel22.add(upCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, 290, 40));

        stuPanel.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 0, 400, 770));

        jPanel24.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 0, 0, new java.awt.Color(0, 0, 0)));
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel89.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-remove-administrator-50.png"))); // NOI18N
        jPanel24.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 47, 60, -1));

        jLabel90.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(255, 51, 51));
        jLabel90.setText("Remove Student");
        jPanel24.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 45, 280, 50));

        jLabel91.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel91.setText("Student ID");
        jPanel24.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 230, 30));

        jLabel92.setBackground(new java.awt.Color(0, 0, 0));
        jLabel92.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-security-pass-35.png"))); // NOI18N
        jPanel24.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 60, 50));

        rSid.setBackground(new java.awt.Color(242, 242, 242));
        rSid.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rSid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel24.add(rSid, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 230, 40));

        jLabel93.setBackground(new java.awt.Color(0, 0, 0));
        jLabel93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-student-35.png"))); // NOI18N
        jPanel24.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 60, 50));

        jLabel94.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel94.setText("Student Name");
        jPanel24.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 230, 30));

        rSname.setBackground(new java.awt.Color(242, 242, 242));
        rSname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rSname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel24.add(rSname, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 290, 40));

        jLabel95.setBackground(new java.awt.Color(0, 0, 0));
        jLabel95.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-degree-35.png"))); // NOI18N
        jPanel24.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 60, 50));

        jLabel96.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel96.setText("Course Program");
        jPanel24.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 230, 30));

        jLabel97.setBackground(new java.awt.Color(0, 0, 0));
        jLabel97.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-email-35.png"))); // NOI18N
        jPanel24.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 60, 50));

        jLabel98.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel98.setText("E-mail");
        jPanel24.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, 230, 30));

        rEmail.setBackground(new java.awt.Color(242, 242, 242));
        rEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel24.add(rEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 480, 290, 40));

        removeBtn.setBackground(new java.awt.Color(102, 102, 255));
        removeBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        removeBtn.setForeground(new java.awt.Color(255, 255, 255));
        removeBtn.setText("Remove Student");
        removeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        removeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeBtnActionPerformed(evt);
            }
        });
        jPanel24.add(removeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 590, 240, 40));

        findToRemoveBtn.setBackground(new java.awt.Color(255, 0, 51));
        findToRemoveBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        findToRemoveBtn.setForeground(new java.awt.Color(255, 255, 255));
        findToRemoveBtn.setText("Find");
        findToRemoveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        findToRemoveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findToRemoveBtnActionPerformed(evt);
            }
        });
        jPanel24.add(findToRemoveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 70, -1));

        clearRemStuBtn.setBackground(new java.awt.Color(102, 102, 255));
        clearRemStuBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        clearRemStuBtn.setForeground(new java.awt.Color(255, 255, 255));
        clearRemStuBtn.setText("Clear Details");
        clearRemStuBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearRemStuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearRemStuBtnActionPerformed(evt);
            }
        });
        jPanel24.add(clearRemStuBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 660, 240, 40));

        rCourse.setBackground(new java.awt.Color(242, 242, 242));
        rCourse.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rCourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "B.Sc.(Hons) in Computer Science", "B.Sc.(Hons) in Software Engineering", "B.Sc.(Hons) in Information Technology", "Bachelor Of Information Technology" }));
        rCourse.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        rCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rCourseActionPerformed(evt);
            }
        });
        jPanel24.add(rCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, 290, 40));

        stuPanel.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, 400, 770));

        jTabbedPane1.addTab("tab3", stuPanel);

        issuePanel.setBackground(new java.awt.Color(255, 255, 255));
        issuePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel25.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 0, 2, new java.awt.Color(0, 0, 0)));
        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bookNField1.setBackground(new java.awt.Color(242, 242, 242));
        bookNField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bookNField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel25.add(bookNField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 290, 40));

        jLabel102.setBackground(new java.awt.Color(0, 0, 0));
        jLabel102.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-book-35.png"))); // NOI18N
        jPanel25.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 60, 50));

        jLabel103.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel103.setText("Book Name");
        jPanel25.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 230, 30));

        jLabel104.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel104.setText("Author Name");
        jPanel25.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 230, 30));

        jLabel105.setBackground(new java.awt.Color(0, 0, 0));
        jLabel105.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-person-35.png"))); // NOI18N
        jPanel25.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 60, 50));

        authorNField1.setBackground(new java.awt.Color(242, 242, 242));
        authorNField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        authorNField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel25.add(authorNField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 290, 40));

        jLabel106.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel106.setText("Quantity");
        jPanel25.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, 230, 30));

        quanField1.setBackground(new java.awt.Color(242, 242, 242));
        quanField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        quanField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel25.add(quanField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, 290, 40));

        jLabel107.setBackground(new java.awt.Color(0, 0, 0));
        jLabel107.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-unit-35.png"))); // NOI18N
        jPanel25.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 60, 50));

        jLabel118.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel118.setForeground(new java.awt.Color(255, 51, 51));
        jLabel118.setText("Book Details");
        jPanel25.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 220, 50));

        jLabel119.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/book-entry (1).png"))); // NOI18N
        jPanel25.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 60, 50));

        detailsFindBtn.setBackground(new java.awt.Color(102, 102, 255));
        detailsFindBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        detailsFindBtn.setForeground(new java.awt.Color(255, 255, 255));
        detailsFindBtn.setText("Find Book Details");
        detailsFindBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        detailsFindBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailsFindBtnActionPerformed(evt);
            }
        });
        jPanel25.add(detailsFindBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 580, 240, 40));

        clearBtn2.setBackground(new java.awt.Color(102, 102, 255));
        clearBtn2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        clearBtn2.setForeground(new java.awt.Color(255, 255, 255));
        clearBtn2.setText("Clear Details");
        clearBtn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtn2ActionPerformed(evt);
            }
        });
        jPanel25.add(clearBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 660, 240, 40));

        issuePanel.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 400, 770));

        jPanel26.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 0, 0, new java.awt.Color(0, 0, 0)));
        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel108.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel108.setForeground(new java.awt.Color(255, 51, 51));
        jLabel108.setText("Student Details");
        jPanel26.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 280, 50));

        jLabel109.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-student-registration-50.png"))); // NOI18N
        jPanel26.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 60, 50));

        stunameFrame1.setBackground(new java.awt.Color(242, 242, 242));
        stunameFrame1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        stunameFrame1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel26.add(stunameFrame1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 290, 40));

        jLabel112.setBackground(new java.awt.Color(0, 0, 0));
        jLabel112.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-student-35.png"))); // NOI18N
        jPanel26.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 200, 60, 50));

        jLabel113.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel113.setText("Student Name");
        jPanel26.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 230, 30));

        jLabel114.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel114.setText("Course Program");
        jPanel26.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 230, 30));

        jLabel115.setBackground(new java.awt.Color(0, 0, 0));
        jLabel115.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-degree-35.png"))); // NOI18N
        jPanel26.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 320, 60, 50));

        courseFrame1.setBackground(new java.awt.Color(242, 242, 242));
        courseFrame1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        courseFrame1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel26.add(courseFrame1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 290, 40));

        jLabel116.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel116.setText("E-mail");
        jPanel26.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, 230, 30));

        emailFrame1.setBackground(new java.awt.Color(242, 242, 242));
        emailFrame1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        emailFrame1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel26.add(emailFrame1, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 440, 290, 40));

        jLabel117.setBackground(new java.awt.Color(0, 0, 0));
        jLabel117.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-email-35.png"))); // NOI18N
        jPanel26.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 60, 50));

        studentDetailsFind.setBackground(new java.awt.Color(102, 102, 255));
        studentDetailsFind.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        studentDetailsFind.setForeground(new java.awt.Color(255, 255, 255));
        studentDetailsFind.setText("Find Student Details");
        studentDetailsFind.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        studentDetailsFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentDetailsFindActionPerformed(evt);
            }
        });
        jPanel26.add(studentDetailsFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 580, 240, 40));

        clearBtn1.setBackground(new java.awt.Color(102, 102, 255));
        clearBtn1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        clearBtn1.setForeground(new java.awt.Color(255, 255, 255));
        clearBtn1.setText("Clear Details");
        clearBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtn1ActionPerformed(evt);
            }
        });
        jPanel26.add(clearBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 650, 240, 40));

        issuePanel.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, 400, 770));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 51, 255));
        jLabel28.setText("Issue Book");
        issuePanel.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 250, 50));

        jLabel99.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-book-100.png"))); // NOI18N
        issuePanel.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 110, 120));

        jLabel100.setBackground(new java.awt.Color(0, 0, 0));
        jLabel100.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-id-35.png"))); // NOI18N
        issuePanel.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 60, 50));

        jLabel101.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel101.setText("Book ID");
        issuePanel.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 230, 30));

        bookIdField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bookIdField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        issuePanel.add(bookIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 290, 40));

        jLabel111.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel111.setText("Return Date");
        issuePanel.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 520, 230, 30));

        jLabel110.setBackground(new java.awt.Color(0, 0, 0));
        jLabel110.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-date-35.png"))); // NOI18N
        issuePanel.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 60, 50));

        issueBtn.setBackground(new java.awt.Color(255, 51, 51));
        issueBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        issueBtn.setForeground(new java.awt.Color(255, 255, 255));
        issueBtn.setText("Issue Book");
        issueBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        issueBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issueBtnActionPerformed(evt);
            }
        });
        issuePanel.add(issueBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 620, 240, 40));

        jLabel120.setBackground(new java.awt.Color(0, 0, 0));
        jLabel120.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-security-pass-35.png"))); // NOI18N
        issuePanel.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 60, 50));

        jLabel121.setBackground(new java.awt.Color(0, 0, 0));
        jLabel121.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-calendar-35.png"))); // NOI18N
        issuePanel.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 60, 50));

        studentIdField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        studentIdField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        issuePanel.add(studentIdField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, 290, 40));

        jLabel122.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel122.setText("Student ID");
        issuePanel.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 230, 30));

        jLabel123.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel123.setText("Issue Date");
        issuePanel.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 230, 30));

        jLabel124.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel124.setText("Issue ID");
        issuePanel.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 230, 30));

        jLabel125.setBackground(new java.awt.Color(0, 0, 0));
        jLabel125.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-id-verified-35 (1).png"))); // NOI18N
        issuePanel.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 60, 50));

        issueId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        issueId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        issuePanel.add(issueId, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 290, 40));

        clearBtn.setBackground(new java.awt.Color(102, 102, 255));
        clearBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        clearBtn.setForeground(new java.awt.Color(255, 255, 255));
        clearBtn.setText("Clear Details");
        clearBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });
        issuePanel.add(clearBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 680, 240, 40));

        returnDateChooser.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        returnDateChooser.setDateFormatString("yyyy-MM-dd");
        returnDateChooser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        issuePanel.add(returnDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 550, 290, 40));

        issueDateChooser.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        issueDateChooser.setDateFormatString("yyyy-MM-dd");
        issueDateChooser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        issuePanel.add(issueDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, 290, 40));

        jTabbedPane1.addTab("tab4", issuePanel);

        returnPanel.setBackground(new java.awt.Color(255, 255, 255));
        returnPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        issuePanel1.setBackground(new java.awt.Color(255, 255, 255));
        issuePanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel27.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 0, 2, new java.awt.Color(0, 0, 0)));
        jPanel27.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bookNField2.setBackground(new java.awt.Color(242, 242, 242));
        bookNField2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bookNField2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel27.add(bookNField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 290, 40));

        jLabel126.setBackground(new java.awt.Color(0, 0, 0));
        jLabel126.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-book-35.png"))); // NOI18N
        jPanel27.add(jLabel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 60, 50));

        jLabel127.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel127.setText("Book Name");
        jPanel27.add(jLabel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 230, 30));

        jLabel128.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel128.setText("Author Name");
        jPanel27.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 230, 30));

        jLabel129.setBackground(new java.awt.Color(0, 0, 0));
        jLabel129.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-person-35.png"))); // NOI18N
        jPanel27.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 60, 50));

        authorNField2.setBackground(new java.awt.Color(242, 242, 242));
        authorNField2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        authorNField2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel27.add(authorNField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 290, 40));

        jLabel130.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel130.setText("Quantity");
        jPanel27.add(jLabel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 230, 30));

        quanField2.setBackground(new java.awt.Color(242, 242, 242));
        quanField2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        quanField2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel27.add(quanField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 290, 40));

        jLabel131.setBackground(new java.awt.Color(0, 0, 0));
        jLabel131.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-unit-35.png"))); // NOI18N
        jPanel27.add(jLabel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 60, 50));

        jLabel132.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel132.setForeground(new java.awt.Color(255, 51, 51));
        jLabel132.setText("Book Details");
        jPanel27.add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 220, 50));

        jLabel133.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/book-entry (1).png"))); // NOI18N
        jPanel27.add(jLabel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 60, 50));

        detailsFindBtn1.setBackground(new java.awt.Color(102, 102, 255));
        detailsFindBtn1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        detailsFindBtn1.setForeground(new java.awt.Color(255, 255, 255));
        detailsFindBtn1.setText("Find Book Details");
        detailsFindBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        detailsFindBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailsFindBtn1ActionPerformed(evt);
            }
        });
        jPanel27.add(detailsFindBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 590, 240, 40));

        clearBtn3.setBackground(new java.awt.Color(102, 102, 255));
        clearBtn3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        clearBtn3.setForeground(new java.awt.Color(255, 255, 255));
        clearBtn3.setText("Clear Details");
        clearBtn3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtn3ActionPerformed(evt);
            }
        });
        jPanel27.add(clearBtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 650, 240, 40));

        jLabel150.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel150.setText("Issue Date");
        jPanel27.add(jLabel150, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, 230, 30));

        jLabel148.setBackground(new java.awt.Color(0, 0, 0));
        jLabel148.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-calendar-35.png"))); // NOI18N
        jPanel27.add(jLabel148, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 60, 50));

        issueDateField1.setBackground(new java.awt.Color(242, 242, 242));
        issueDateField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        issueDateField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel27.add(issueDateField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 420, 290, 40));

        jLabel145.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel145.setText("Return Date");
        jPanel27.add(jLabel145, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 480, 230, 30));

        jLabel146.setBackground(new java.awt.Color(0, 0, 0));
        jLabel146.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-date-35.png"))); // NOI18N
        jPanel27.add(jLabel146, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 60, 50));

        returnDateField1.setEditable(false);
        returnDateField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        returnDateField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel27.add(returnDateField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 510, 290, 40));

        issuePanel1.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 400, 770));

        jPanel28.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 0, 0, new java.awt.Color(0, 0, 0)));
        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel134.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel134.setForeground(new java.awt.Color(255, 51, 51));
        jLabel134.setText("Student Details");
        jPanel28.add(jLabel134, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 280, 50));

        jLabel135.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-student-registration-50.png"))); // NOI18N
        jPanel28.add(jLabel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 60, 50));

        stunameFrame2.setBackground(new java.awt.Color(242, 242, 242));
        stunameFrame2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        stunameFrame2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel28.add(stunameFrame2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 290, 40));

        jLabel136.setBackground(new java.awt.Color(0, 0, 0));
        jLabel136.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-student-35.png"))); // NOI18N
        jPanel28.add(jLabel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 200, 60, 50));

        jLabel137.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel137.setText("Student Name");
        jPanel28.add(jLabel137, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 230, 30));

        jLabel138.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel138.setText("Course Program");
        jPanel28.add(jLabel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 230, 30));

        jLabel139.setBackground(new java.awt.Color(0, 0, 0));
        jLabel139.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-degree-35.png"))); // NOI18N
        jPanel28.add(jLabel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 320, 60, 50));

        courseFrame2.setBackground(new java.awt.Color(242, 242, 242));
        courseFrame2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        courseFrame2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel28.add(courseFrame2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 290, 40));

        jLabel140.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel140.setText("E-mail");
        jPanel28.add(jLabel140, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, 230, 30));

        emailFrame2.setBackground(new java.awt.Color(242, 242, 242));
        emailFrame2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        emailFrame2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel28.add(emailFrame2, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 440, 290, 40));

        jLabel141.setBackground(new java.awt.Color(0, 0, 0));
        jLabel141.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-email-35.png"))); // NOI18N
        jPanel28.add(jLabel141, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 60, 50));

        studentDetailsFind1.setBackground(new java.awt.Color(102, 102, 255));
        studentDetailsFind1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        studentDetailsFind1.setForeground(new java.awt.Color(255, 255, 255));
        studentDetailsFind1.setText("Find Student Details");
        studentDetailsFind1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        studentDetailsFind1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentDetailsFind1ActionPerformed(evt);
            }
        });
        jPanel28.add(studentDetailsFind1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 580, 240, 40));

        clearBtn4.setBackground(new java.awt.Color(102, 102, 255));
        clearBtn4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        clearBtn4.setForeground(new java.awt.Color(255, 255, 255));
        clearBtn4.setText("Clear Details");
        clearBtn4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearBtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtn4ActionPerformed(evt);
            }
        });
        jPanel28.add(clearBtn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 650, 240, 40));

        issuePanel1.add(jPanel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, 400, 770));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 51, 255));
        jLabel29.setText("Return Book");
        issuePanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 250, 50));

        jLabel142.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-return-book-100.png"))); // NOI18N
        issuePanel1.add(jLabel142, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 110, 120));

        jLabel143.setBackground(new java.awt.Color(0, 0, 0));
        jLabel143.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-id-35.png"))); // NOI18N
        issuePanel1.add(jLabel143, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 60, 50));

        jLabel144.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel144.setText("Book ID");
        issuePanel1.add(jLabel144, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 230, 30));

        bookIdField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bookIdField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        issuePanel1.add(bookIdField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 290, 40));

        returnBookBtn.setBackground(new java.awt.Color(255, 51, 51));
        returnBookBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        returnBookBtn.setForeground(new java.awt.Color(255, 255, 255));
        returnBookBtn.setText("Return Book");
        returnBookBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        returnBookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnBookBtnActionPerformed(evt);
            }
        });
        issuePanel1.add(returnBookBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 520, 240, 40));

        jLabel147.setBackground(new java.awt.Color(0, 0, 0));
        jLabel147.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-security-pass-35.png"))); // NOI18N
        issuePanel1.add(jLabel147, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 60, 50));

        studentIdField2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        studentIdField2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        issuePanel1.add(studentIdField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 290, 40));

        jLabel149.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel149.setText("Student ID");
        issuePanel1.add(jLabel149, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, 230, 30));

        jLabel151.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel151.setText("Return ID");
        issuePanel1.add(jLabel151, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 230, 30));

        jLabel152.setBackground(new java.awt.Color(0, 0, 0));
        jLabel152.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-id-35.png"))); // NOI18N
        issuePanel1.add(jLabel152, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 60, 50));

        returnIdField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        returnIdField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        issuePanel1.add(returnIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 290, 40));

        clearBtn5.setBackground(new java.awt.Color(102, 102, 255));
        clearBtn5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        clearBtn5.setForeground(new java.awt.Color(255, 255, 255));
        clearBtn5.setText("Clear Details");
        clearBtn5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearBtn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtn5ActionPerformed(evt);
            }
        });
        issuePanel1.add(clearBtn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 580, 240, 40));

        jLabel153.setBackground(new java.awt.Color(0, 0, 0));
        jLabel153.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-id-verified-35 (1).png"))); // NOI18N
        issuePanel1.add(jLabel153, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 60, 50));

        jLabel154.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel154.setText("Issue ID");
        issuePanel1.add(jLabel154, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 230, 30));

        issueIDField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        issueIDField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        issuePanel1.add(issueIDField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 210, 40));

        searchBtn.setBackground(new java.awt.Color(255, 0, 51));
        searchBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchBtn.setForeground(new java.awt.Color(255, 255, 255));
        searchBtn.setText("Search");
        searchBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });
        issuePanel1.add(searchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 173, -1, 30));

        returnPanel.add(issuePanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTabbedPane1.addTab("tab5", returnPanel);

        issueDetailsPanel.setBackground(new java.awt.Color(255, 255, 255));
        issueDetailsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel157.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel157.setForeground(new java.awt.Color(255, 0, 51));
        jLabel157.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-search-26.png"))); // NOI18N
        issueDetailsPanel.add(jLabel157, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 30, 30, 40));

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        issueDetailsPanel.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 32, 280, 40));

        jLabel158.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel158.setForeground(new java.awt.Color(255, 0, 51));
        jLabel158.setText("Issue Details");
        issueDetailsPanel.add(jLabel158, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 180, 40));

        issueDetailsTable.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 1, new java.awt.Color(0, 0, 0)));
        issueDetailsTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        issueDetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Issue ID", "Book ID", "Student ID", "Issue Date", "Return Date"
            }
        ));
        issueDetailsTable.setFocusable(false);
        issueDetailsTable.setGridColor(new java.awt.Color(0, 0, 0));
        issueDetailsTable.setInheritsPopupMenu(true);
        issueDetailsTable.setRowHeight(30);
        issueDetailsTable.setShowGrid(true);
        jScrollPane2.setViewportView(issueDetailsTable);

        issueDetailsPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 1180, 660));

        jTabbedPane1.addTab("tab6", issueDetailsPanel);

        returnDetailsPanel.setBackground(new java.awt.Color(255, 255, 255));
        returnDetailsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        issueDetailsPanel2.setBackground(new java.awt.Color(255, 255, 255));
        issueDetailsPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel160.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel160.setForeground(new java.awt.Color(255, 0, 51));
        jLabel160.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-search-26.png"))); // NOI18N
        issueDetailsPanel2.add(jLabel160, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 30, 30, 40));

        returnSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        returnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnSearchActionPerformed(evt);
            }
        });
        returnSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                returnSearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                returnSearchKeyReleased(evt);
            }
        });
        issueDetailsPanel2.add(returnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 32, 280, 40));

        jLabel161.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel161.setForeground(new java.awt.Color(255, 0, 51));
        jLabel161.setText("Return Details");
        issueDetailsPanel2.add(jLabel161, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 180, 40));

        returnDetailsTable.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 1, new java.awt.Color(0, 0, 0)));
        returnDetailsTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        returnDetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Return ID", "Book ID", "Student ID", "Issue Date", "Returned Date", "Actual Return Date"
            }
        ));
        returnDetailsTable.setFocusable(false);
        returnDetailsTable.setGridColor(new java.awt.Color(0, 0, 0));
        returnDetailsTable.setInheritsPopupMenu(true);
        returnDetailsTable.setRowHeight(30);
        returnDetailsTable.setShowGrid(true);
        jScrollPane3.setViewportView(returnDetailsTable);

        issueDetailsPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 1180, 660));

        returnDetailsPanel.add(issueDetailsPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, -1));

        jTabbedPane1.addTab("tab7", returnDetailsPanel);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 1250, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void bookLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookLabelMouseClicked
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_bookLabelMouseClicked

    private void stuLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuLabelMouseClicked
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_stuLabelMouseClicked

    private void issueLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issueLabelMouseClicked
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_issueLabelMouseClicked

    private void returnLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnLabelMouseClicked
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_returnLabelMouseClicked

    private void bookLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookLabelMousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_bookLabelMousePressed

    private void stuLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuLabelMousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_stuLabelMousePressed

    private void issueLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issueLabelMousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_issueLabelMousePressed

    private void returnLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnLabelMousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_returnLabelMousePressed

    private void logoutLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutLabelMousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_logoutLabelMousePressed

    private void bookLabelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookLabelMouseReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_bookLabelMouseReleased

    private void bookLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookLabelMouseEntered
        // TODO add your handling code here:
        
        bookLabel.setForeground(white);
    }//GEN-LAST:event_bookLabelMouseEntered

    private void bookLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookLabelMouseExited
        // TODO add your handling code here:
        bookLabel.setForeground(defaultColor);
    }//GEN-LAST:event_bookLabelMouseExited

    private void stuLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuLabelMouseEntered
        stuLabel.setForeground(white);
    }//GEN-LAST:event_stuLabelMouseEntered

    private void stuLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuLabelMouseExited
        stuLabel.setForeground(defaultColor);
    }//GEN-LAST:event_stuLabelMouseExited

    private void issueLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issueLabelMouseEntered
        issueLabel.setForeground(white);
    }//GEN-LAST:event_issueLabelMouseEntered

    private void issueLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issueLabelMouseExited
        issueLabel.setForeground(defaultColor);
    }//GEN-LAST:event_issueLabelMouseExited

    private void returnLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnLabelMouseEntered
        returnLabel.setForeground(white);
    }//GEN-LAST:event_returnLabelMouseEntered

    private void returnLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnLabelMouseExited
        returnLabel.setForeground(defaultColor);
    }//GEN-LAST:event_returnLabelMouseExited

    private void logoutLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutLabelMouseEntered
        logoutLabel.setForeground(white);
    }//GEN-LAST:event_logoutLabelMouseEntered

    private void logoutLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutLabelMouseExited
        logoutLabel.setForeground(defaultColor);
    }//GEN-LAST:event_logoutLabelMouseExited

    private void bookPanelAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_bookPanelAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_bookPanelAncestorAdded

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String bookId, bookName, authorName, quantity, query;
        String url = "jdbc:mysql://localhost:3306/lms";
        String user_name = "root";
        String pass = "";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = java.sql.DriverManager.getConnection(url, user_name, pass);
            java.sql.Statement st = (java.sql.Statement) conn.createStatement();
            if("".equals(idField.getText())){
                JOptionPane.showMessageDialog(new JFrame(), "Book ID is require", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }else if("".equals(bookNField.getText())){
                JOptionPane.showMessageDialog(new JFrame(), "Book Name is require", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }else if("".equals(authorNField.getText())){
                JOptionPane.showMessageDialog(new JFrame(), "Author Name is require", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }else if("".equals(quanField.getText())){
                JOptionPane.showMessageDialog(new JFrame(), "Quantity is require", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            else {
            bookId = idField.getText(); 
            bookName    = bookNField.getText();
            authorName = authorNField.getText();
            quantity = quanField.getText();
            
            // Check if book with the same book_id already exists
            String checkQuery = "SELECT COUNT(*) AS count FROM books WHERE book_id = '" + bookId + "'";
            ResultSet rs = st.executeQuery(checkQuery);
            rs.next();
            int count = rs.getInt("count");

            if (count > 0) {
                JOptionPane.showMessageDialog(new JFrame(), "Book ID already exists. Please enter a unique ID.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
            // Insert new book if book_id is unique
            query = "INSERT INTO books(book_id, book_name, author_name, quantity) " +
                    "VALUES('" + bookId + "', '" + bookName + "', '" + authorName + "', '" + quantity + "')";
            st.execute(query);
            
            idField.setText("");
            bookNField.setText("");
            authorNField.setText("");
            quanField.setText("");
            showMessageDialog(null, "New Book has been added successfully!");
            }
            }
            
            
            
            
           
        }
        catch(Exception e){
            System.out.println("Error! " + e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String bookId, bookName, authorName, quantity, query;
        String url = "jdbc:mysql://localhost:3306/lms";
        String user_name = "root";
        String pass = "";

try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = java.sql.DriverManager.getConnection(url, user_name, pass);
    java.sql.Statement st = conn.createStatement();
    
    if ("".equals(upId.getText())) {
        JOptionPane.showMessageDialog(new JFrame(), "Book ID is required", "Error", JOptionPane.ERROR_MESSAGE);
    } else if ("".equals(upBook.getText())) {
        JOptionPane.showMessageDialog(new JFrame(), "Book Name is required", "Error", JOptionPane.ERROR_MESSAGE);
    } else if ("".equals(upAuthor.getText())) {
        JOptionPane.showMessageDialog(new JFrame(), "Author Name is required", "Error", JOptionPane.ERROR_MESSAGE);
    } else if ("".equals(upQuan.getText())) {
        JOptionPane.showMessageDialog(new JFrame(), "Quantity is required", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        bookId = upId.getText();
        bookName = upBook.getText();
        authorName = upAuthor.getText();
        quantity = upQuan.getText();
        
        // Check if book with the entered book_id exists
        String checkQuery = "SELECT COUNT(*) AS count FROM books WHERE book_id = '" + bookId + "'";
        ResultSet rs = st.executeQuery(checkQuery);
        rs.next();
        int count = rs.getInt("count");

        if (count == 0) {
            JOptionPane.showMessageDialog(new JFrame(), "Book ID not found. Please enter a valid ID.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Update the book details if book_id exists
            query = "UPDATE books SET book_name = '" + bookName + "', author_name = '" + authorName + "', quantity = '" + quantity + "' " +
                    "WHERE book_id = '" + bookId + "'";
            st.executeUpdate(query);
            
            // Clear input fields
            upId.setText("");
            upBook.setText("");
            upAuthor.setText("");
            upQuan.setText("");
            
            JOptionPane.showMessageDialog(null, "Book details have been updated successfully!");
        }
    }
} catch (Exception e) {
    System.out.println("Error! " + e.getMessage());
}


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String bookId, query;
        String url = "jdbc:mysql://localhost:3306/lms";
        String user_name = "root";
        String pass = "";

try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = java.sql.DriverManager.getConnection(url, user_name, pass);
    java.sql.Statement st = conn.createStatement();
    
    // Check if the book ID field is empty
    if ("".equals(rId.getText())) {
        JOptionPane.showMessageDialog(new JFrame(), "Book ID is required", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        bookId = rId.getText();
        
        // Check if a book with the entered book_id exists
        String checkQuery = "SELECT COUNT(*) AS count FROM books WHERE book_id = '" + bookId + "'";
        ResultSet rs = st.executeQuery(checkQuery);
        rs.next();
        int count = rs.getInt("count");

        if (count == 0) {
            JOptionPane.showMessageDialog(new JFrame(), "Book ID not found. Please enter a valid ID.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Delete the book if book_id exists
            query = "DELETE FROM books WHERE book_id = '" + bookId + "'";
            st.executeUpdate(query);
            
            // Clear the input field for book ID
            rId.setText("");
            rbookName.setText("");
            rauthorName.setText("");
            rquantity.setText("");
            
            JOptionPane.showMessageDialog(null, "Book has been deleted successfully!");
        }
    }
} catch (Exception e) {
    System.out.println("Error! " + e.getMessage());
}
;

// Add your delete code logic here (from previous version), triggered by a button click or other event.

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Check if the book ID field is empty
    if ("".equals(rId.getText())) {
        JOptionPane.showMessageDialog(new JFrame(), "Book ID is required", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        String url = "jdbc:mysql://localhost:3306/lms";
        String user_name = "root";
        String pass = "";
        String bookId = rId.getText();

        try {
            // Establish connection to the MySQL database
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = java.sql.DriverManager.getConnection(url, user_name, pass);
            java.sql.Statement st = conn.createStatement();

            // Check if a book with the entered book_id exists
            String checkQuery = "SELECT * FROM books WHERE book_id = '" + bookId + "'";
            ResultSet rs = st.executeQuery(checkQuery);

            if (rs.next()) {
                // Book found, autofill other details
                rbookName.setText(rs.getString("book_name"));
                rauthorName.setText(rs.getString("author_name"));
                rquantity.setText(rs.getString("quantity"));
            } else {
                // Book ID not found
                JOptionPane.showMessageDialog(new JFrame(), "Book ID not found. Please enter a valid ID.", "Error", JOptionPane.ERROR_MESSAGE);
                
                // Clear fields in case of invalid book ID
                rId.setText("");
                rbookName.setText("");
                rauthorName.setText("");
                rquantity.setText("");
            }

            // Close the ResultSet and Statement
            rs.close();
            st.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Error! " + e.getMessage());
        }
    }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // Check if the book ID field is empty
    if ("".equals(upId.getText())) {
        JOptionPane.showMessageDialog(new JFrame(), "Book ID is required", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        String url = "jdbc:mysql://localhost:3306/lms";
        String user_name = "root";
        String pass = "";
        String bookId = upId.getText();

        try {
            // Establish connection to the MySQL database
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = java.sql.DriverManager.getConnection(url, user_name, pass);
            java.sql.Statement st = conn.createStatement();

            // Check if a book with the entered book_id exists
            String checkQuery = "SELECT * FROM books WHERE book_id = '" + bookId + "'";
            ResultSet rs = st.executeQuery(checkQuery);

            if (rs.next()) {
                // Book found, autofill other details
                upBook.setText(rs.getString("book_name"));
                upAuthor.setText(rs.getString("author_name"));
                upQuan.setText(rs.getString("quantity"));
            } else {
                // Book ID not found
                JOptionPane.showMessageDialog(new JFrame(), "Book ID not found. Please enter a valid ID.", "Error", JOptionPane.ERROR_MESSAGE);
                
                // Clear fields in case of invalid book ID
                upId.setText("");
                upBook.setText("");
                upAuthor.setText("");
                upQuan.setText("");
            }

            // Close the ResultSet and Statement
            rs.close();
            st.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Error! " + e.getMessage());
        }
    }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void stuaddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuaddBtnActionPerformed
        String stuId, stuName, course, email, query;
        String url = "jdbc:mysql://localhost:3306/lms";
        String user_name = "root";
        String pass = "";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = java.sql.DriverManager.getConnection(url, user_name, pass);
            java.sql.Statement st = (java.sql.Statement) conn.createStatement();
            if("".equals(stuidFrame.getText())){
                JOptionPane.showMessageDialog(new JFrame(), "Student ID is require", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }else if("".equals(stunameFrame.getText())){
                JOptionPane.showMessageDialog(new JFrame(), "Student Name is require", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }else if("".equals(courseFrame3.getSelectedItem().toString())){
                JOptionPane.showMessageDialog(new JFrame(), "Course Program is require", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }else if("".equals(emailFrame.getText())){
                JOptionPane.showMessageDialog(new JFrame(), "E-mail is require", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            else {
            stuId = stuidFrame.getText(); 
            stuName    = stunameFrame.getText();
            course = courseFrame3.getSelectedItem().toString();
            email = emailFrame.getText();
            
            // Check if student with the same stu_id already exists
            String checkQuery = "SELECT COUNT(*) AS count FROM student WHERE stu_id = '" + stuId + "'";
            ResultSet rs = st.executeQuery(checkQuery);
            rs.next();
            int count = rs.getInt("count");

            if (count > 0) {
                JOptionPane.showMessageDialog(new JFrame(), "Student ID already exists. Please enter a unique ID.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
            // Insert new student if stu_id is unique
            query = "INSERT INTO student(stu_id, stu_name, course, email) " +
                    "VALUES('" + stuId + "', '" + stuName + "', '" + course + "', '" + email + "')";
            st.execute(query);
            
            stuidFrame.setText("");
            stunameFrame.setText("");
            courseFrame3.setSelectedItem(null);
            emailFrame.setText("");
            showMessageDialog(null, "New Student has been added successfully!");
            }
            }
            
        }
        catch(Exception e){
            System.out.println("Error! " + e.getMessage());
        }
    }//GEN-LAST:event_stuaddBtnActionPerformed

    private void StuUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StuUpBtnActionPerformed
        String stuId, stuName, course, email, query;
        String url = "jdbc:mysql://localhost:3306/lms";
        String user_name = "root";
        String pass = "";

try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = java.sql.DriverManager.getConnection(url, user_name, pass);
    java.sql.Statement st = conn.createStatement();
    
    if ("".equals(stuUpId.getText())) {
        JOptionPane.showMessageDialog(new JFrame(), "Student ID is required", "Error", JOptionPane.ERROR_MESSAGE);
    } else if ("".equals(stuUpName.getText())) {
        JOptionPane.showMessageDialog(new JFrame(), "Student Name is required", "Error", JOptionPane.ERROR_MESSAGE);
    } else if ("".equals(upCourse.getSelectedItem().toString())) {
        JOptionPane.showMessageDialog(new JFrame(), "Course Program is required", "Error", JOptionPane.ERROR_MESSAGE);
    } else if ("".equals(UpEmail.getText())) {
        JOptionPane.showMessageDialog(new JFrame(), "E-mail is required", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        stuId = stuUpId.getText();
        stuName = stuUpName.getText();
        course = upCourse.getSelectedItem().toString();
        email = UpEmail.getText();
        
        // Check if student with the entered stu_id exists
        String checkQuery = "SELECT COUNT(*) AS count FROM student WHERE stu_id = '" + stuId + "'";
        ResultSet rs = st.executeQuery(checkQuery);
        rs.next();
        int count = rs.getInt("count");

        if (count == 0) {
            JOptionPane.showMessageDialog(new JFrame(), "Student ID not found. Please enter a valid ID.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Update the student details if stu_id exists
            query = "UPDATE student SET stu_name = '" + stuName + "', course = '" + course + "', email = '" + email + "' " +
                    "WHERE stu_id = '" + stuId + "'";
            st.executeUpdate(query);
            
            // Clear input fields
            stuUpId.setText("");
            stuUpName.setText("");
            upCourse.setSelectedItem(null);
            UpEmail.setText("");
            
            JOptionPane.showMessageDialog(null, "Student details have been updated successfully!");
        }
    }
} catch (Exception e) {
    System.out.println("Error! " + e.getMessage());
}
    }//GEN-LAST:event_StuUpBtnActionPerformed

    private void findToUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findToUpBtnActionPerformed
        if ("".equals(stuUpId.getText())) {
        JOptionPane.showMessageDialog(new JFrame(), "Student ID is required", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        String url = "jdbc:mysql://localhost:3306/lms";
        String user_name = "root";
        String pass = "";
        String stuId = stuUpId.getText();

        try {
            // Establish connection to the MySQL database
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = java.sql.DriverManager.getConnection(url, user_name, pass);
            java.sql.Statement st = conn.createStatement();

            // Check if a student with the entered stu_id exists
            String checkQuery = "SELECT * FROM student WHERE stu_id = '" + stuId + "'";
            ResultSet rs = st.executeQuery(checkQuery);

            if (rs.next()) {
                // Student found, autofill other details
                stuUpName.setText(rs.getString("stu_name"));
                upCourse.setSelectedItem(rs.getString("course"));
                UpEmail.setText(rs.getString("email"));
            } else {
                // Book ID not found
                JOptionPane.showMessageDialog(new JFrame(), "Student ID not found. Please enter a valid ID.", "Error", JOptionPane.ERROR_MESSAGE);
                
                // Clear fields in case of invalid student ID
                stuUpId.setText("");
                stuUpName.setText("");
                upCourse.setSelectedItem(null);
                UpEmail.setText("");
            }

            // Close the ResultSet and Statement
            rs.close();
            st.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Error! " + e.getMessage());
        }
    }
    }//GEN-LAST:event_findToUpBtnActionPerformed

    private void removeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBtnActionPerformed
        String stuId, query;
        String url = "jdbc:mysql://localhost:3306/lms";
        String user_name = "root";
        String pass = "";

try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = java.sql.DriverManager.getConnection(url, user_name, pass);
    java.sql.Statement st = conn.createStatement();
    
    // Check if the student ID field is empty
    if ("".equals(rSid.getText())) {
        JOptionPane.showMessageDialog(new JFrame(), "Student ID is required", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        stuId = rSid.getText();
        
        // Check if a student with the entered stu_id exists
        String checkQuery = "SELECT COUNT(*) AS count FROM student WHERE stu_id = '" + stuId + "'";
        ResultSet rs = st.executeQuery(checkQuery);
        rs.next();
        int count = rs.getInt("count");

        if (count == 0) {
            JOptionPane.showMessageDialog(new JFrame(), "Student ID not found. Please enter a valid ID.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Delete the student if stu_id exists
            query = "DELETE FROM student WHERE stu_id = '" + stuId + "'";
            st.executeUpdate(query);
            
            // Clear the input field for student ID
            rSid.setText("");
            rSname.setText("");
            rCourse.setSelectedItem(null);
            rEmail.setText("");
            
            JOptionPane.showMessageDialog(null, "Student has been deleted successfully!");
        }
    }
} catch (Exception e) {
    System.out.println("Error! " + e.getMessage());
}
    }//GEN-LAST:event_removeBtnActionPerformed

    private void findToRemoveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findToRemoveBtnActionPerformed
        if ("".equals(rSid.getText())) {
        JOptionPane.showMessageDialog(new JFrame(), "Student ID is required", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        String url = "jdbc:mysql://localhost:3306/lms";
        String user_name = "root";
        String pass = "";
        String stuId = rSid.getText();

        try {
            // Establish connection to the MySQL database
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = java.sql.DriverManager.getConnection(url, user_name, pass);
            java.sql.Statement st = conn.createStatement();

            // Check if a student with the entered stu_id exists
            String checkQuery = "SELECT * FROM student WHERE stu_id = '" + stuId + "'";
            ResultSet rs = st.executeQuery(checkQuery);

            if (rs.next()) {
                // Student found, autofill other details
                rSname.setText(rs.getString("stu_name"));
                rCourse.setSelectedItem(rs.getString("course"));
                rEmail.setText(rs.getString("email"));
            } else {
                // Book ID not found
                JOptionPane.showMessageDialog(new JFrame(), "Student ID not found. Please enter a valid ID.", "Error", JOptionPane.ERROR_MESSAGE);
                
                // Clear fields in case of invalid Student ID
                rSid.setText("");
                rSname.setText("");
                rCourse.setSelectedItem(null);
                rEmail.setText("");
            }

            // Close the ResultSet and Statement
            rs.close();
            st.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Error! " + e.getMessage());
        }
    }
    }//GEN-LAST:event_findToRemoveBtnActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        issueId.setText("");
        bookIdField.setText("");
        studentIdField1.setText("");
        issueDateChooser.setDate(null);
        returnDateChooser.setDate(null);
        
    }//GEN-LAST:event_clearBtnActionPerformed

    private void studentDetailsFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentDetailsFindActionPerformed
        // Check if the student ID field is empty
        if ("".equals(studentIdField1.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Student ID is required", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String url = "jdbc:mysql://localhost:3306/lms";
            String user_name = "root";
            String pass = "";
            String stuId = studentIdField1.getText();

        try {
            // Establish connection to the MySQL database
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = java.sql.DriverManager.getConnection(url, user_name, pass);
            java.sql.Statement st = conn.createStatement();

            // Check if a student with the entered stu_id exists
            String checkQuery = "SELECT * FROM student WHERE stu_id = '" + stuId + "'";
            ResultSet rs = st.executeQuery(checkQuery);

            if (rs.next()) {
                // Student found, autofill other details
                stunameFrame1.setText(rs.getString("stu_name"));
                courseFrame1.setText(rs.getString("course"));
                emailFrame1.setText(rs.getString("email"));
            } else {
                // Student ID not found
                JOptionPane.showMessageDialog(new JFrame(), "Student ID not found. Please enter a valid ID.", "Error", JOptionPane.ERROR_MESSAGE);
                
                // Clear fields in case of invalid student ID
                studentIdField1.setText("");
                stunameFrame1.setText("");
                courseFrame1.setText("");
                emailFrame1.setText("");
            }

            // Close the ResultSet and Statement
            rs.close();
            st.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Error! " + e.getMessage());
        }
    }
    }//GEN-LAST:event_studentDetailsFindActionPerformed

    private void detailsFindBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsFindBtnActionPerformed
        // Check if the book ID field is empty
        if ("".equals(bookIdField.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Book ID is required", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String url = "jdbc:mysql://localhost:3306/lms";
            String user_name = "root";
            String pass = "";
            String bookId = bookIdField.getText();

        try {
            // Establish connection to the MySQL database
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = java.sql.DriverManager.getConnection(url, user_name, pass);
            java.sql.Statement st = conn.createStatement();

            // Check if a book with the entered book_id exists
            String checkQuery = "SELECT * FROM books WHERE book_id = '" + bookId + "'";
            ResultSet rs = st.executeQuery(checkQuery);

            if (rs.next()) {
                // Book found, autofill other details
                bookNField1.setText(rs.getString("book_name"));
                authorNField1.setText(rs.getString("author_name"));
                quanField1.setText(rs.getString("quantity"));
            } else {
                // Book ID not found
                JOptionPane.showMessageDialog(new JFrame(), "Book ID not found. Please enter a valid ID.", "Error", JOptionPane.ERROR_MESSAGE);
                
                // Clear fields in case of invalid book ID
                bookIdField.setText("");
                bookNField1.setText("");
                authorNField1.setText("");
                quanField1.setText("");
            }

            // Close the ResultSet and Statement
            rs.close();
            st.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Error! " + e.getMessage());
        }
    }
    }//GEN-LAST:event_detailsFindBtnActionPerformed

    private void issueBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issueBtnActionPerformed
        String bookId, stuId, issueDate, returnDate, issue_Id, query;
        String url = "jdbc:mysql://localhost:3306/lms";
        String user_name = "root";
        String pass = "";

try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = java.sql.DriverManager.getConnection(url, user_name, pass);
    java.sql.Statement st = (java.sql.Statement) conn.createStatement();
    
    Date selectedIssueDate = issueDateChooser.getDate();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String issueDateString = dateFormat.format(selectedIssueDate);
    
    Date selectedReturnDate = returnDateChooser.getDate();
    String returnDateString = dateFormat.format(selectedReturnDate);
    
    if ("".equals(issueId.getText())) {
        JOptionPane.showMessageDialog(new JFrame(), "Issue ID is required", "Error", JOptionPane.ERROR_MESSAGE);
    } else if ("".equals(bookIdField.getText())) {
        JOptionPane.showMessageDialog(new JFrame(), "Book ID is required", "Error", JOptionPane.ERROR_MESSAGE);
    } else if ("".equals(studentIdField1.getText())) {
        JOptionPane.showMessageDialog(new JFrame(), "Student ID is required", "Error", JOptionPane.ERROR_MESSAGE);
    } else if ("".equals(selectedIssueDate == null)) {
        JOptionPane.showMessageDialog(new JFrame(), "Issue Date is required", "Error", JOptionPane.ERROR_MESSAGE);
    } else if ("".equals(selectedReturnDate == null)) {
        JOptionPane.showMessageDialog(new JFrame(), "Return Date is required", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        issue_Id = issueId.getText();
        bookId = bookIdField.getText(); 
        stuId = studentIdField1.getText();
        issueDate = issueDateString;
        returnDate = returnDateString;

        // Check if Issue ID already exists
        String checkQuery = "SELECT COUNT(*) AS count FROM issue_details WHERE issue_id = '" + issue_Id + "'";
        ResultSet rs = st.executeQuery(checkQuery);
        rs.next();
        int count = rs.getInt("count");

        if (count > 0) {
            JOptionPane.showMessageDialog(new JFrame(), "Issue ID already exists. Please enter a unique ID.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Check if the book has sufficient quantity
            String checkQuantityQuery = "SELECT quantity FROM books WHERE book_id = '" + bookId + "'";
            rs = st.executeQuery(checkQuantityQuery);
            if (rs.next()) {
                int quantity = rs.getInt("quantity");
                if (quantity > 0) {
                    // Insert into issue_details table
                    query = "INSERT INTO issue_details(issue_id, bookId, studentId, issueDate, returnDate) " +
                            "VALUES('" + issue_Id + "', '" + bookId + "', '" + stuId + "', '" + issueDate + "', '" + returnDate + "')";
                    st.execute(query);

                    // Reduce the quantity of the issued book in the books table
                    String updateQuantityQuery = "UPDATE books SET quantity = quantity - 1 WHERE book_id = '" + bookId + "'";
                    st.execute(updateQuantityQuery);

                    // Clear the form fields
                    issueId.setText("");
                    bookIdField.setText("");
                    studentIdField1.setText("");
                    issueDateChooser.setDate(null);
                    returnDateChooser.setDate(null);

                    // Show success message
                    JOptionPane.showMessageDialog(null, "The book has been issued successfully!");
                } else {
                    // Show error if the book quantity is 0
                    JOptionPane.showMessageDialog(new JFrame(), "The book is out of stock. Can't issue.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "Book not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
} catch (Exception e) {
    System.out.println("Error! " + e.getMessage());
}

    }//GEN-LAST:event_issueBtnActionPerformed

    private void clearBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtn1ActionPerformed
        stunameFrame1.setText("");
        courseFrame1.setText("");
        emailFrame1.setText("");
    }//GEN-LAST:event_clearBtn1ActionPerformed

    private void clearBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtn2ActionPerformed
        bookNField1.setText("");
        authorNField1.setText("");
        quanField1.setText("");
    }//GEN-LAST:event_clearBtn2ActionPerformed

    private void detailsFindBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsFindBtn1ActionPerformed
        // Check if the book ID field is empty
        if ("".equals(bookIdField1.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Book ID is required", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String url = "jdbc:mysql://localhost:3306/lms";
            String user_name = "root";
            String pass = "";
            String issueId = issueIDField.getText();
            String bookId = bookIdField1.getText();

        try {
            // Establish connection to the MySQL database
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = java.sql.DriverManager.getConnection(url, user_name, pass);
            java.sql.Statement st = conn.createStatement();
            java.sql.Statement sts = conn.createStatement();

            // Check if a book with the entered book_id exists
            String checkQuery = "SELECT * FROM books WHERE book_id = '" + bookId + "'";
            String checkSql = "SELECT * FROM issue_details WHERE issue_id = '"+issueId+"'";
            ResultSet rs = st.executeQuery(checkQuery);
            ResultSet srs = sts.executeQuery(checkSql);

            if (rs.next()) {
                // Book found, autofill other details
                bookNField2.setText(rs.getString("book_name"));
                authorNField2.setText(rs.getString("author_name"));
                quanField2.setText(rs.getString("quantity"));
                if(srs.next()){
                    issueDateField1.setText(srs.getString("issueDate"));
                    returnDateField1.setText(srs.getString("returnDate"));
                }else{
                    issueDateField1.setText("");
                    returnDateField1.setText("");
                }
                
            } else {
                // Book ID not found
                JOptionPane.showMessageDialog(new JFrame(), "Book ID not found. Please enter a valid ID.", "Error", JOptionPane.ERROR_MESSAGE);
                
                // Clear fields in case of invalid book ID
                
                bookNField2.setText("");
                authorNField2.setText("");
                quanField2.setText("");
                
            }
            

            // Close the ResultSet and Statement
            rs.close();
            st.close();
            sts.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Error! " + e.getMessage());
        }
    }
    }//GEN-LAST:event_detailsFindBtn1ActionPerformed

    private void clearBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtn3ActionPerformed
        bookNField2.setText("");
        authorNField2.setText("");
        quanField2.setText("");
        issueDateField1.setText("");
        returnDateField1.setText("");
    }//GEN-LAST:event_clearBtn3ActionPerformed

    private void studentDetailsFind1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentDetailsFind1ActionPerformed
        // Check if the student ID field is empty
        if ("".equals(studentIdField2.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Student ID is required", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String url = "jdbc:mysql://localhost:3306/lms";
            String user_name = "root";
            String pass = "";
            String stuId = studentIdField2.getText();

        try {
            // Establish connection to the MySQL database
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = java.sql.DriverManager.getConnection(url, user_name, pass);
            java.sql.Statement st = conn.createStatement();

            // Check if a student with the entered stu_id exists
            String checkQuery = "SELECT * FROM student WHERE stu_id = '" + stuId + "'";
            ResultSet rs = st.executeQuery(checkQuery);

            if (rs.next()) {
                // Student found, autofill other details
                stunameFrame2.setText(rs.getString("stu_name"));
                courseFrame2.setText(rs.getString("course"));
                emailFrame2.setText(rs.getString("email"));
            } else {
                // Student ID not found
                JOptionPane.showMessageDialog(new JFrame(), "Student ID not found. Please enter a valid ID.", "Error", JOptionPane.ERROR_MESSAGE);
                
                // Clear fields in case of invalid student ID
                studentIdField2.setText("");
                stunameFrame2.setText("");
                courseFrame2.setText("");
                emailFrame2.setText("");
            }

            // Close the ResultSet and Statement
            rs.close();
            st.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Error! " + e.getMessage());
        }
    }
    }//GEN-LAST:event_studentDetailsFind1ActionPerformed

    private void clearBtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtn4ActionPerformed
        stunameFrame2.setText("");
        courseFrame2.setText("");
        emailFrame2.setText("");
    }//GEN-LAST:event_clearBtn4ActionPerformed

    private void returnBookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnBookBtnActionPerformed
        String bookId, stuId, return_Id,issue_id,issue_date ,return_date ,query;
        String url = "jdbc:mysql://localhost:3306/lms";
        String user_name = "root";
        String pass = "";

try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = java.sql.DriverManager.getConnection(url, user_name, pass);
    java.sql.Statement st = (java.sql.Statement) conn.createStatement();
    
    if ("".equals(returnIdField.getText())) {
        JOptionPane.showMessageDialog(new JFrame(), "Return ID is required", "Error", JOptionPane.ERROR_MESSAGE);
    } else if ("".equals(bookIdField1.getText())) {
        JOptionPane.showMessageDialog(new JFrame(), "Book ID is required", "Error", JOptionPane.ERROR_MESSAGE);
    } else if ("".equals(studentIdField2.getText())) {
        JOptionPane.showMessageDialog(new JFrame(), "Student ID is required", "Error", JOptionPane.ERROR_MESSAGE);
    
    } else {
        issue_id = issueIDField.getText();
        return_Id = returnIdField.getText();
        bookId = bookIdField1.getText(); 
        stuId = studentIdField2.getText();
        issue_date = issueDateField1.getText();
        return_date = returnDateField1.getText();
        

      
        String checkQuery = "SELECT COUNT(*) AS count FROM return_details WHERE returnId = '" + return_Id + "'";
        ResultSet rs = st.executeQuery(checkQuery);
        rs.next();
        int count = rs.getInt("count");

        if (count > 0) {
            JOptionPane.showMessageDialog(new JFrame(), "Return ID already exists. Please enter a unique ID.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
                    Date currentDate = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String returnDate = sdf.format(currentDate);
                    
                    // Insert into return_details table
                    query = "INSERT INTO return_details(issueId, returnId, bookId, studentId, issueDate, currentDate, returnDate) " +
                            "VALUES('" + issue_id + "' ,'" + return_Id + "', '" + bookId + "', '" + stuId + "', '" + issue_date + "', '" + returnDate + "', '" + return_date + "')";
                    st.execute(query);

                    // Reduce the quantity of the issued book in the books table
                    String updateQuantityQuery = "UPDATE books SET quantity = quantity + 1 WHERE book_id = '" + bookId + "'";
                    st.execute(updateQuantityQuery);

                    // Clear the form fields
                    issueIDField.setText("");
                    returnIdField.setText("");
                    bookIdField1.setText("");
                    studentIdField2.setText("");
                    

                    // Show success message
                    JOptionPane.showMessageDialog(null, "The book has been returned successfully!");
                
            } 
        }
    }
 catch (Exception e) {
    System.out.println("Error! " + e.getMessage());
}
    }//GEN-LAST:event_returnBookBtnActionPerformed

    private void clearBtn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtn5ActionPerformed
        issueIDField.setText("");
        returnIdField.setText("");
        bookIdField1.setText("");
        studentIdField2.setText("");
    }//GEN-LAST:event_clearBtn5ActionPerformed

    private void logoutLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutLabelMouseClicked
        myForm p3 = new myForm();
        p3.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutLabelMouseClicked

    private void clearBookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBookBtnActionPerformed
        idField.setText("");
        bookNField.setText("");
        authorNField.setText("");
        quanField.setText("");
    }//GEN-LAST:event_clearBookBtnActionPerformed

    private void clearUpBookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearUpBookBtnActionPerformed
        upId.setText("");
        upBook.setText("");
        upAuthor.setText("");
        upQuan.setText("");
    }//GEN-LAST:event_clearUpBookBtnActionPerformed

    private void clearRemBookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearRemBookBtnActionPerformed
        rSid.setText("");
        rSname.setText("");
        
        rEmail.setText("");
    }//GEN-LAST:event_clearRemBookBtnActionPerformed

    private void clearRemStuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearRemStuBtnActionPerformed
        stuUpId.setText("");
        stuUpName.setText("");
        
        UpEmail.setText("");
    }//GEN-LAST:event_clearRemStuBtnActionPerformed

    private void clearStuBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearStuBtn1ActionPerformed
        stuidFrame.setText("");
        stunameFrame.setText("");
        
        emailFrame.setText("");
    }//GEN-LAST:event_clearStuBtn1ActionPerformed

    private void clearUpStuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearUpStuBtnActionPerformed
        stuUpId.setText("");
        stuUpName.setText("");
        
        UpEmail.setText("");
    }//GEN-LAST:event_clearUpStuBtnActionPerformed

    private void rCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rCourseActionPerformed
        String selectedValue = rCourse.getSelectedItem().toString();
    }//GEN-LAST:event_rCourseActionPerformed

    private void courseFrame3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseFrame3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseFrame3ActionPerformed

    private void upCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upCourseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_upCourseActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        if ("".equals(issueIDField.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Issue ID is required", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String url = "jdbc:mysql://localhost:3306/lms";
            String user_name = "root";
            String pass = "";
            String issueId = issueIDField.getText();

        try {
            // Establish connection to the MySQL database
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = java.sql.DriverManager.getConnection(url, user_name, pass);
            java.sql.Statement st = conn.createStatement();

            
            
            String sql = "SELECT issueId FROM return_details WHERE issueId = '"+issueId+"'";
            ResultSet srs = st.executeQuery(sql);
            

            if(srs.next()){
                String returnedIssueId = srs.getString("issueId");

                if (issueId.equals(returnedIssueId)) {
                    // Display error if the book is already returned
                    JOptionPane.showMessageDialog(new JFrame(), "This book is already returned.", "Error", JOptionPane.ERROR_MESSAGE);

                    // Clear the issue ID field
                    issueIDField.setText("");
                }
            }
            
            else{
                String checkQuery = "SELECT * FROM issue_details WHERE issue_id = '" + issueId + "'";
                ResultSet rs = st.executeQuery(checkQuery);
            
            if(rs.next()) {
                // Student found, autofill other details
                bookIdField1.setText(rs.getString("bookId"));
                studentIdField2.setText(rs.getString("studentId"));
                
            } else {
                // issue ID not found
                JOptionPane.showMessageDialog(new JFrame(), "Issue ID not found. Please enter a valid ID.", "Error", JOptionPane.ERROR_MESSAGE);
                
                // Clear fields in case of invalid issue ID
                issueIDField.setText("");
                bookIdField1.setText("");
                studentIdField2.setText("");
                
            }
            }

            // Close the ResultSet and Statement
            rs.close();
            st.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Error! " + e.getMessage());
        }
        }
    }//GEN-LAST:event_searchBtnActionPerformed

    private void returnDetailsLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnDetailsLabelMouseClicked
        jTabbedPane1.setSelectedIndex(6);
        String url = "jdbc:mysql://localhost:3306/lms";
        String user_name = "root";
        String pass = "";
        
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = java.sql.DriverManager.getConnection(url, user_name, pass);
            java.sql.Statement st = conn.createStatement();

            
            String sql = "SELECT * FROM return_details";
            ResultSet rs = st.executeQuery(sql);
            
            DefaultTableModel model = (DefaultTableModel)returnDetailsTable.getModel();
            model.setRowCount(0);
            
            while(rs.next()){
                model.addRow(new String[]{rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)});
            }
        }catch(Exception e){
            System.out.println("Error! " + e.getMessage());
        }
    }//GEN-LAST:event_returnDetailsLabelMouseClicked

    private void returnDetailsLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnDetailsLabelMouseEntered
        returnDetailsLabel.setForeground(white);
    }//GEN-LAST:event_returnDetailsLabelMouseEntered

    private void returnDetailsLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnDetailsLabelMouseExited
        returnDetailsLabel.setForeground(defaultColor);
    }//GEN-LAST:event_returnDetailsLabelMouseExited

    private void returnDetailsLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnDetailsLabelMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_returnDetailsLabelMousePressed

    private void issueDetailsLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issueDetailsLabelMouseClicked
        jTabbedPane1.setSelectedIndex(5);
        String url = "jdbc:mysql://localhost:3306/lms";
        String user_name = "root";
        String pass = "";
        
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = java.sql.DriverManager.getConnection(url, user_name, pass);
            java.sql.Statement st = conn.createStatement();

            
            String sql = "SELECT * FROM issue_details";
            ResultSet rs = st.executeQuery(sql);
            DefaultTableModel model = (DefaultTableModel)issueDetailsTable.getModel();
            model.setRowCount(0);
            
            while(rs.next()){
                model.addRow(new String[]{rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5), rs.getString(6)});
            }
        }catch(Exception e){
            System.out.println("Error! " + e.getMessage());
        }
    }//GEN-LAST:event_issueDetailsLabelMouseClicked

    private void issueDetailsLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issueDetailsLabelMouseEntered
        issueDetailsLabel.setForeground(white);
    }//GEN-LAST:event_issueDetailsLabelMouseEntered

    private void issueDetailsLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issueDetailsLabelMouseExited
        issueDetailsLabel.setForeground(defaultColor);
    }//GEN-LAST:event_issueDetailsLabelMouseExited

    private void issueDetailsLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issueDetailsLabelMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_issueDetailsLabelMousePressed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        DefaultTableModel obj = (DefaultTableModel)issueDetailsTable.getModel();
        TableRowSorter<DefaultTableModel> obj1 = new TableRowSorter<>(obj);
        issueDetailsTable.setRowSorter(obj1);
        obj1.setRowFilter(RowFilter.regexFilter(jTextField1.getText()));
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        DefaultTableModel obj = (DefaultTableModel)issueDetailsTable.getModel();
        TableRowSorter<DefaultTableModel> obj1 = new TableRowSorter<>(obj);
        issueDetailsTable.setRowSorter(obj1);
        obj1.setRowFilter(RowFilter.regexFilter(jTextField1.getText()));
    }//GEN-LAST:event_jTextField1KeyReleased

    private void returnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_returnSearchActionPerformed

    private void returnSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_returnSearchKeyPressed
        DefaultTableModel obj = (DefaultTableModel)returnDetailsTable.getModel();
        TableRowSorter<DefaultTableModel> obj1 = new TableRowSorter<>(obj);
        returnDetailsTable.setRowSorter(obj1);
        obj1.setRowFilter(RowFilter.regexFilter(returnSearch.getText()));
    }//GEN-LAST:event_returnSearchKeyPressed

    private void returnSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_returnSearchKeyReleased
        DefaultTableModel obj = (DefaultTableModel)returnDetailsTable.getModel();
        TableRowSorter<DefaultTableModel> obj1 = new TableRowSorter<>(obj);
        returnDetailsTable.setRowSorter(obj1);
        obj1.setRowFilter(RowFilter.regexFilter(returnSearch.getText()));
    }//GEN-LAST:event_returnSearchKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(home_pageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home_pageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home_pageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home_pageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new home_pageFrame().setVisible(true);
            }
        });
    }

    void setUser(String fname) {
        
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton StuUpBtn;
    private javax.swing.JTextField UpEmail;
    private javax.swing.JTextField authorNField;
    private javax.swing.JTextField authorNField1;
    private javax.swing.JTextField authorNField2;
    private javax.swing.JTextField bookIdField;
    private javax.swing.JTextField bookIdField1;
    private javax.swing.JLabel bookLabel;
    private javax.swing.JTextField bookNField;
    private javax.swing.JTextField bookNField1;
    private javax.swing.JTextField bookNField2;
    private javax.swing.JPanel bookPanel;
    private rojerusan.RSTableMetro bookTable;
    private javax.swing.JButton clearBookBtn;
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton clearBtn1;
    private javax.swing.JButton clearBtn2;
    private javax.swing.JButton clearBtn3;
    private javax.swing.JButton clearBtn4;
    private javax.swing.JButton clearBtn5;
    private javax.swing.JButton clearRemBookBtn;
    private javax.swing.JButton clearRemStuBtn;
    private javax.swing.JButton clearStuBtn1;
    private javax.swing.JButton clearUpBookBtn;
    private javax.swing.JButton clearUpStuBtn;
    private javax.swing.JTextField courseFrame1;
    private javax.swing.JTextField courseFrame2;
    private javax.swing.JComboBox<String> courseFrame3;
    private javax.swing.JPanel dashPanel;
    private javax.swing.JButton detailsFindBtn;
    private javax.swing.JButton detailsFindBtn1;
    private javax.swing.JTextField emailFrame;
    private javax.swing.JTextField emailFrame1;
    private javax.swing.JTextField emailFrame2;
    private javax.swing.JButton findToRemoveBtn;
    private javax.swing.JButton findToUpBtn;
    private javax.swing.JTextField idField;
    private javax.swing.JButton issueBtn;
    private com.toedter.calendar.JDateChooser issueDateChooser;
    private javax.swing.JTextField issueDateField1;
    private javax.swing.JLabel issueDetailsLabel;
    private javax.swing.JPanel issueDetailsPanel;
    private javax.swing.JPanel issueDetailsPanel2;
    private javax.swing.JTable issueDetailsTable;
    private javax.swing.JTextField issueIDField;
    private javax.swing.JTextField issueId;
    private javax.swing.JLabel issueLabel;
    private javax.swing.JPanel issuePanel;
    private javax.swing.JPanel issuePanel1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel logoutLabel;
    private javax.swing.JLabel menuLabel;
    private javax.swing.JLabel noBookLbl;
    private javax.swing.JLabel noIssueLbl;
    private javax.swing.JLabel noRetLbl;
    private javax.swing.JLabel noStuLbl;
    private javax.swing.JPanel panelBarChart;
    private javax.swing.JTextField quanField;
    private javax.swing.JTextField quanField1;
    private javax.swing.JTextField quanField2;
    private javax.swing.JComboBox<String> rCourse;
    private javax.swing.JTextField rEmail;
    private javax.swing.JTextField rId;
    private rojeru_san.componentes.RSCalendarBeanInfo rSCalendarBeanInfo1;
    private javax.swing.JTextField rSid;
    private javax.swing.JTextField rSname;
    private javax.swing.JTextField rauthorName;
    private javax.swing.JTextField rbookName;
    private javax.swing.JButton removeBtn;
    private javax.swing.JButton returnBookBtn;
    private com.toedter.calendar.JDateChooser returnDateChooser;
    private javax.swing.JTextField returnDateField1;
    private javax.swing.JLabel returnDetailsLabel;
    private javax.swing.JPanel returnDetailsPanel;
    private javax.swing.JTable returnDetailsTable;
    private javax.swing.JTextField returnIdField;
    private javax.swing.JLabel returnLabel;
    private javax.swing.JPanel returnPanel;
    private javax.swing.JTextField returnSearch;
    private javax.swing.JTextField rquantity;
    private javax.swing.JButton searchBtn;
    private javax.swing.JLabel stuLabel;
    private javax.swing.JPanel stuPanel;
    private javax.swing.JTextField stuUpId;
    private javax.swing.JTextField stuUpName;
    private javax.swing.JButton stuaddBtn;
    private javax.swing.JButton studentDetailsFind;
    private javax.swing.JButton studentDetailsFind1;
    private javax.swing.JTextField studentIdField1;
    private javax.swing.JTextField studentIdField2;
    private javax.swing.JTextField stuidFrame;
    private javax.swing.JTextField stunameFrame;
    private javax.swing.JTextField stunameFrame1;
    private javax.swing.JTextField stunameFrame2;
    private javax.swing.JTextField upAuthor;
    private javax.swing.JTextField upBook;
    private javax.swing.JComboBox<String> upCourse;
    private javax.swing.JTextField upId;
    private javax.swing.JTextField upQuan;
    // End of variables declaration//GEN-END:variables

    

    

    

    
}
