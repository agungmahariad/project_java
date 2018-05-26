/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penggajian;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import penggajian.data_gaji;

/**
 *
 * @author ASUS
 */
public class gaji extends javax.swing.JFrame {

    private LocalDate now = LocalDate.now();
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM");
    private DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private DateFormat sdf = new SimpleDateFormat("MM");
    public DefaultTableModel tabmodel;
    public Statement st;
    public ResultSet rs;
    public String kd_karyawan;
    public Integer bulan2;
    public Integer gaji2;
    public Integer tunjangan2;
    public Integer lembur2;
    public Integer bonus2;
    public Integer potongan2;
    public String kode;
    public Integer id_bulan;
    public ResultSet rs1;
    public ResultSet rs2;
    Connection cn = koneksi.koneksidb.getkoneksi();
    
    public gaji() {
        initComponents();
        judul();
        tampildata();
//        tampil_bulan();
//        tampil_karyawan();
    }
    protected void judul(){
        Object[] judul = {"No","Kode Karyawan","Nama Karyawan","Jabatan"};
        tabmodel = new DefaultTableModel(null,judul){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        tabel.setModel(tabmodel);
    }
    public DefaultTableModel tabmodel2;
            public String stat;
//        protected void tampilDatabulan(String bulan){
//          try {
//            tabmodel.getDataVector().removeAllElements();
//            tabmodel.fireTableDataChanged();
//            st = cn.createStatement();
//            rs = st.executeQuery("SELECT * FROM tb_karyawan LEFT JOIN data_gaji ON tb_karyawan.kd_karyawan = data_gaji.kd_karyawan where id_bulan = '"+bulan+"'");
//            int no = 0;
//            while (rs.next()) {
//                no++;
//                if (rs.getString("id_bulan") == null) {
//                Object [] data = {
//                    no,
//                    rs.getString("kd_karyawan"),
//                    rs.getString("nama_karyawan"),
//                    rs.getString("jabatan"),
//                    "-",
//                    "-",
//                    "Belum Gaji"
//                };
//                tabmodel.addRow(data);
//                }else{
//                    
//                String tgl_last_gaji = rs.getString("tanggal").toString().substring(0, 7);
//                String tgl_now       = dtf2.format(now).toString().substring(0,7);
//                int tahun_last = Integer.parseInt(tgl_last_gaji.substring(0, 4));
//                int bulan_last = Integer.parseInt(tgl_last_gaji.substring(5, 7));
//                int total_last = tahun_last + bulan_last;
//                int tahun_now = Integer.parseInt(tgl_now.substring(0, 4));
//                int bulan_now = Integer.parseInt(tgl_now.substring(5, 7));
//                int total_now = tahun_now + bulan_now;
////                int hari_last = Integer.parseInt(tgl_last_gaji.substring(7));
////                2018-05-18
//                    if (Integer.parseInt(rs.getString("id_bulan")) == Integer.parseInt(dtf.format(now).substring(1, 2)) && total_last==total_now) {
////                        JOptionPane.showMessageDialog(null, hari_last);
//                    Object [] data = {
//                        no,
//                        rs.getString("kd_karyawan"),
//                        rs.getString("nama_karyawan"),
//                        rs.getString("jabatan"),
//                        rs.getString("id_bulan"),
//                        rs.getString("tanggal"),
//                        "Sudah Gaji"
//                    };
//                    tabmodel.addRow(data);
//                    }else{
////                       JOptionPane.showMessageDialog(null, tgl_last_gaji+tgl_now+" "+rs.getString("id_bulan").toString()+" "+dtf.format(now).substring(1, 2));
//                Object [] data = {
//                    no,
//                    rs.getString("kd_karyawan"),
//                    rs.getString("nama_karyawan"),
//                    rs.getString("jabatan"),
//                    "-",
//                    "-",
//                    "Belum Gaji"
//                };
//                tabmodel.addRow(data);
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    protected void tampilData(){
//          try {
//            tabmodel.getDataVector().removeAllElements();
//            tabmodel.fireTableDataChanged();
//            st = cn.createStatement();
//            rs = st.executeQuery("SELECT * FROM tb_karyawan LEFT JOIN data_gaji ON tb_karyawan.kd_karyawan = data_gaji.kd_karyawan");
//            int no = 0;
//            while (rs.next()) {
//                no++;
////                String status = "";      
//                
//                if (rs.getString("id_bulan") == null) {
//                    
//                Object [] data = {
//                    no,
//                    rs.getString("kd_karyawan"),
//                    rs.getString("nama_karyawan"),
//                    rs.getString("jabatan"),
//                    "-",
//                    "-",
//                    "Belum Gaji"
//                };
//                tabmodel.addRow(data);
//                }else{
//                    
//                String tgl_last_gaji = rs.getString("tanggal").toString().substring(0, 7);
//                String tgl_now       = dtf2.format(now).toString().substring(0,7);
//                int tahun_last = Integer.parseInt(tgl_last_gaji.substring(0, 4));
//                int bulan_last = Integer.parseInt(tgl_last_gaji.substring(5, 7));
//                int total_last = tahun_last + bulan_last;
//                int tahun_now = Integer.parseInt(tgl_now.substring(0, 4));
//                int bulan_now = Integer.parseInt(tgl_now.substring(5, 7));
//                int total_now = tahun_now + bulan_now;
////                int hari_last = Integer.parseInt(tgl_last_gaji.substring(7));
////                2018-05-18
//                    if (Integer.parseInt(rs.getString("id_bulan")) == Integer.parseInt(dtf.format(now).substring(1, 2)) && total_last==total_now) {
////                        JOptionPane.showMessageDialog(null, hari_last);
//                    Object [] data = {
//                        no,
//                        rs.getString("kd_karyawan"),
//                        rs.getString("nama_karyawan"),
//                        rs.getString("jabatan"),
//                        rs.getString("id_bulan"),
//                        rs.getString("tanggal"),
//                        "Sudah Gaji"
//                    };
//                    tabmodel.addRow(data);
//                    }else{
////                       JOptionPane.showMessageDialog(null, tgl_last_gaji+tgl_now+" "+rs.getString("id_bulan").toString()+" "+dtf.format(now).substring(1, 2));
//                Object [] data = {
//                    no,
//                    rs.getString("kd_karyawan"),
//                    rs.getString("nama_karyawan"),
//                    rs.getString("jabatan"),
//                    "-",
//                    "-",
//                    "Belum Gaji"
//                };
//                tabmodel.addRow(data);
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    public void tampildata(){
        try {
            tabmodel.getDataVector().removeAllElements();
            tabmodel.fireTableDataChanged();
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM tb_karyawan");
            int no = 0;
            while (rs.next()) {
                no++;
                 Object [] data = {
                    no,
                    rs.getString("kd_karyawan"),
                    rs.getString("nama_karyawan"),
                    rs.getString("jabatan"),
                };
                tabmodel.addRow(data);
            }
            tabel.setModel(tabmodel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void setkode(String nama_karyawan){
        try{
            st = cn.createStatement();
            rs2 = st.executeQuery("SELECT * FROM tb_gaji WHERE nama_karyawan = '"+nama_karyawan+"' ");
            while(rs2.next()){
                kd_karyawan = rs2.getString("kd_karyawan");
            }
            rs2.close();
        }catch(Exception a){
            JOptionPane.showMessageDialog(null, a.getMessage());
        }
    }
    public String getkode(){
        return kd_karyawan;
    }
    protected void setbulan(String nama_bulan){
        try{
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM bulan WHERE nama_bulan = '"+nama_bulan+"' ");
            while(rs.next()){
                String bulan1 = rs.getString("id_bulan");
                bulan2 = Integer.parseInt(String.valueOf(bulan1));
            }
        }catch(Exception a){
            JOptionPane.showMessageDialog(null, a.getMessage());
        }
    }
    public int getbulan(){
        return bulan2;
    }
    protected void setgaji(String nama_karyawan){
        try{
            st = cn.createStatement();
            rs2 = st.executeQuery("SELECT * FROM tb_gaji WHERE kd_karyawan = '"+nama_karyawan+"' ");
            while(rs2.next()){
                String gaji1 = rs2.getString("gaji_pokok");
                gaji2 = Integer.parseInt(String.valueOf(gaji1));
            }
            rs2.close();
        }catch(Exception a){
            JOptionPane.showMessageDialog(null, a.getMessage());
        }
    }
    public Integer getgaji(){
        return gaji2;
    }
    protected void settunjangan(String nama_karyawan){
        try{
            st = cn.createStatement();
            rs2 = st.executeQuery("SELECT * FROM tb_gaji WHERE kd_karyawan = '"+nama_karyawan+"' ");
            while(rs2.next()){
                String tunjangan1 = rs2.getString("tunjangan");
                tunjangan2 = Integer.parseInt(String.valueOf(tunjangan1));
            }
            rs2.close();
        }catch(Exception a){
            JOptionPane.showMessageDialog(null, a.getMessage());
        }
    }
    public Integer gettunjangan(){
        return tunjangan2;
    }
    protected void setlembur(String nama_karyawan){
        try{
            st = cn.createStatement();
            rs2 = st.executeQuery("SELECT * FROM tb_gaji WHERE kd_karyawan = '"+nama_karyawan+"' ");
            while(rs2.next()){
                String lembur1 = rs2.getString("lembur");
                lembur2 = Integer.parseInt(String.valueOf(lembur1));
            }
            rs2.close();
        }catch(Exception a){
            JOptionPane.showMessageDialog(null, a.getMessage());
        }
    }
    public Integer getlembur(){
        return lembur2;
    }
    protected void setbonus(String nama_karyawan){
        try{
            st = cn.createStatement();
            rs2 = st.executeQuery("SELECT * FROM tb_gaji WHERE kd_karyawan = '"+nama_karyawan+"' ");
            while(rs2.next()){
                String bonus1 = rs2.getString("bonus");
                bonus2 = Integer.parseInt(String.valueOf(bonus1));
            }
            rs2.close();
        }catch(Exception a){
            JOptionPane.showMessageDialog(null, a.getMessage());
        }
    }
    public Integer getbonus(){
        return bonus2;
    }
    protected void setpotongan(String nama_karyawan){
        try{
            st = cn.createStatement();
            rs2 = st.executeQuery("SELECT * FROM tb_gaji WHERE kd_karyawan = '"+nama_karyawan+"' ");
            while(rs2.next()){
                String potongan1 = rs2.getString("potongan");
                potongan2 = Integer.parseInt(String.valueOf(potongan1));
            }
            rs2.close();
        }catch(Exception a){
            JOptionPane.showMessageDialog(null, a.getMessage());
        }
    }
    public Integer getpotongan(){
        return potongan2;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        back = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        label4 = new java.awt.Label();
        label5 = new java.awt.Label();
        label6 = new java.awt.Label();
        label7 = new java.awt.Label();
        label8 = new java.awt.Label();
        gaji = new javax.swing.JTextField();
        lembur = new javax.swing.JTextField();
        tunjangan = new javax.swing.JTextField();
        bonus = new javax.swing.JTextField();
        potongan = new javax.swing.JTextField();
        label9 = new java.awt.Label();
        total = new javax.swing.JTextField();
        bgaji = new javax.swing.JButton();
        bgaji1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(225, 120));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));

        back.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        back.setIcon(new javax.swing.ImageIcon("D:\\Icon\\Back To_64px.png")); // NOI18N
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));

        label1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("Penggajian");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(688, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        label4.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        label4.setText("Gaji Pokok");

        label5.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        label5.setText("Tunjangan Jabatan");

        label6.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        label6.setText("Lembur");

        label7.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        label7.setText("Bonus Tahunan");

        label8.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        label8.setText("Potongan Pinjaman");

        gaji.setEditable(false);
        gaji.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        gaji.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        gaji.setBorder(null);

        lembur.setEditable(false);
        lembur.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        lembur.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lembur.setBorder(null);

        tunjangan.setEditable(false);
        tunjangan.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        tunjangan.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tunjangan.setBorder(null);

        bonus.setEditable(false);
        bonus.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        bonus.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bonus.setBorder(null);

        potongan.setEditable(false);
        potongan.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        potongan.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        potongan.setBorder(null);

        label9.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        label9.setText("Total Gaji");

        total.setEditable(false);
        total.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        total.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        total.setBorder(null);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(potongan, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(tunjangan)
                    .addComponent(gaji))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(total, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(lembur, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(bonus))
                .addGap(18, 18, 18))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(gaji)
                    .addComponent(label4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lembur))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tunjangan, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(bonus, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(label7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(potongan, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bgaji.setBackground(new java.awt.Color(23, 32, 41));
        bgaji.setForeground(new java.awt.Color(255, 255, 255));
        bgaji.setText("Gaji");
        bgaji.setContentAreaFilled(false);
        bgaji.setOpaque(true);
        bgaji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bgajiActionPerformed(evt);
            }
        });

        bgaji1.setBackground(new java.awt.Color(23, 32, 41));
        bgaji1.setForeground(new java.awt.Color(255, 255, 255));
        bgaji1.setText("Data Gaji");
        bgaji1.setContentAreaFilled(false);
        bgaji1.setOpaque(true);
        bgaji1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bgaji1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bgaji, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bgaji1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(bgaji, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bgaji1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        main_menu menu = new main_menu();
        menu.setVisible(true);
        this.hide();
    }//GEN-LAST:event_backMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
//        bulan();
//        bulan.setSelectedItem("Mei");
    }//GEN-LAST:event_formWindowOpened

    private void bgajiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bgajiActionPerformed
        try {
            if (gaji.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Tolol sia");
            }else{
                st = cn.createStatement();
                rs = st.executeQuery("select * from data_gaji where kd_karyawan = '"+tabmodel.getValueAt(tabel.getSelectedRow(),1).toString()+"'");
                if (rs.next()) {
                    String last = rs.getString("tanggal").toString();
                    String date = dtf2.format(now).toString();
                    int tahun_awal = Integer.valueOf(date.substring(0, 4));
                    int bulan_awal = Integer.valueOf(date.substring(5, 7));
                    int tahun_last = Integer.valueOf(last.substring(0, 4));
                    int bulan_last = Integer.valueOf(last.substring(5, 7));
                    int total_awal = tahun_awal+bulan_awal;
                    int total_last = tahun_last+bulan_last;
                    if (total_last == total_awal) {
                        JOptionPane.showMessageDialog(null, "Karyawan telah di gaji pada tanggal : "+last);
                    }else{
                        st.executeUpdate("insert into data_gaji (kd_karyawan,tanggal,id_bulan) values('"+tabmodel.getValueAt(tabel.getSelectedRow(),1).toString()+"','"+dtf2.format(now)+"','"+dtf.format(now)+"')");
                        JOptionPane.showMessageDialog(null, "success!");
                    }
                }else{
                    st.executeUpdate("insert into data_gaji (kd_karyawan,tanggal,id_bulan) values('"+tabmodel.getValueAt(tabel.getSelectedRow(),1).toString()+"','"+dtf2.format(now)+"','"+dtf.format(now)+"')");
                    JOptionPane.showMessageDialog(null, "Success!");
                }
            }
            //            st = cn.createStatement();
            //            st.executeUpdate("insert into data_gaji (kd_karyawan,tanggal,id_bulan) values('"+lbl_kode.getText()+"','"+dtf2.format(now)+"','"+isibulan.getText()+"')");
            //            JOptionPane.showMessageDialog(null, "Success!");
        } catch (Exception a) {
            JOptionPane.showMessageDialog(null, a.getMessage());
        }
    }//GEN-LAST:event_bgajiActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        String nama_karyawan = tabmodel.getValueAt(tabel.getSelectedRow(), 1).toString();
        setkode(nama_karyawan);
        setgaji(nama_karyawan);
        settunjangan(nama_karyawan);
        setlembur(nama_karyawan);
        setbonus(nama_karyawan);
        setpotongan(nama_karyawan);
        gaji.setText(String.valueOf(gaji2));
        tunjangan.setText(String.valueOf(tunjangan2));
        lembur.setText(String.valueOf(lembur2));
        bonus.setText(String.valueOf(bonus2));
        potongan.setText(String.valueOf(potongan2));

        int satu = Integer.parseInt(gaji.getText());
        int dua = Integer.parseInt(tunjangan.getText());
        int tiga = Integer.parseInt(lembur.getText());
        int empat = Integer.parseInt(bonus.getText());
        int lima = Integer.parseInt(potongan.getText());
        int tambahgaji = satu+dua+tiga+empat;
        int totalgaji = tambahgaji - lima;
        total.setText(String.valueOf(totalgaji));
    }//GEN-LAST:event_tabelMouseClicked

    private void bgaji1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bgaji1ActionPerformed
        data_gaji gaji = new data_gaji(this, rootPaneCheckingEnabled);
        gaji.setVisible(true);
    }//GEN-LAST:event_bgaji1ActionPerformed
    
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
            java.util.logging.Logger.getLogger(gaji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gaji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gaji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gaji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gaji().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JButton bgaji;
    private javax.swing.JButton bgaji1;
    private javax.swing.JTextField bonus;
    private javax.swing.JTextField gaji;
    private javax.swing.ButtonGroup grup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private java.awt.Label label8;
    private java.awt.Label label9;
    private javax.swing.JTextField lembur;
    private javax.swing.JTextField potongan;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField total;
    private javax.swing.JTextField tunjangan;
    // End of variables declaration//GEN-END:variables
}
