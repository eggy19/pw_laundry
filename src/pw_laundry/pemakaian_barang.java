/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pw_laundry;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MY Compaq
 */
public class pemakaian_barang extends javax.swing.JInternalFrame {
    Connection kon = new koneksi().buka_koneksi();
    Statement stat;
    ResultSet res;
    DefaultTableModel tbm;
    /**
     * Creates new form pemakaian_barang
     */
    public pemakaian_barang() {
        initComponents();
        kd_oto();
        masuk_table();
        relasi_brg();
        relasi_nik();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_pakai = new javax.swing.JTable();
        btn_simpan = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_ubah = new javax.swing.JButton();
        btn_bersih = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cmb_barang = new javax.swing.JComboBox();
        txt_nik = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cmb_nik = new javax.swing.JComboBox();
        txt_barang = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_jumlah = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_pemakaian = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();

        setClosable(true);
        setTitle("PEMAKAIAN BARANG");

        tbl_pakai.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_pakai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_pakaiMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_pakai);

        btn_simpan.setText("Simpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_ubah.setText("Ubah");
        btn_ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ubahActionPerformed(evt);
            }
        });

        btn_bersih.setText("Bersih");
        btn_bersih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bersihActionPerformed(evt);
            }
        });

        jLabel3.setText("NIK");

        cmb_barang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmb_barangMouseEntered(evt);
            }
        });

        jLabel1.setText("Nama Barang");

        cmb_nik.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmb_nikMouseEntered(evt);
            }
        });

        jLabel4.setText("Jumlah");

        txt_jumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_jumlahKeyTyped(evt);
            }
        });

        jLabel2.setText("Kode pemakaian");

        txt_pemakaian.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_pemakaian, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txt_jumlah, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cmb_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmb_nik, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_nik, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_hapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btn_bersih, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_simpan, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel2)
                            .addComponent(txt_pemakaian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel1)
                            .addComponent(txt_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel3)
                            .addComponent(txt_nik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_nik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel4)
                            .addComponent(txt_jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_simpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_hapus)
                        .addGap(3, 3, 3)
                        .addComponent(btn_ubah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_bersih)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_pakaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_pakaiMouseClicked

        btn_simpan.setEnabled(false);
        btn_ubah.setEnabled(true);
        btn_hapus.setEnabled(true);

        int i = tbl_pakai.getSelectedRow();
        if(i == -1){
            return;
        }

        String a = (String) tbm.getValueAt(i, 0);
        txt_pemakaian.setText(a);

        String b = (String) tbm.getValueAt(i, 1);
        cmb_nik.setSelectedItem(b);

        String c = (String) tbm.getValueAt(i, 2);
        cmb_barang.setSelectedItem(c);

        String d = (String) tbm.getValueAt(i, 3);
        txt_jumlah.setText(d);

    }//GEN-LAST:event_tbl_pakaiMouseClicked

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        simpan();
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        hapus();
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
        ubah();
    }//GEN-LAST:event_btn_ubahActionPerformed

    private void btn_bersihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bersihActionPerformed
        bersih();
        kd_oto();

        btn_simpan.setEnabled(true);
        btn_ubah.setEnabled(false);
        btn_hapus.setEnabled(false);
    }//GEN-LAST:event_btn_bersihActionPerformed

    private void cmb_barangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmb_barangMouseEntered
        try {
            ResultSet res;
            stat = kon.createStatement();
            res = stat.executeQuery("SELECT * FROM barang WHERE"
                + " kd_barang= '" +cmb_barang.getSelectedItem() + "'");
            if(res.next()){
                String box = res.getString("nm_barang");
                txt_barang.setText(box);
            }else{

            }
            res.close();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cmb_barangMouseEntered

    private void cmb_nikMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmb_nikMouseEntered
        try {
            ResultSet res;
            stat = kon.createStatement();
            res = stat.executeQuery("SELECT * FROM karyawan WHERE"
                + " nik= '" +cmb_nik.getSelectedItem() + "'");
            if(res.next()){
                String box = res.getString("nm_karyawan");
                txt_nik.setText(box);
            }else{

            }
            res.close();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cmb_nikMouseEntered

    private void txt_jumlahKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_jumlahKeyTyped
        angka(evt);
    }//GEN-LAST:event_txt_jumlahKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_bersih;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton btn_ubah;
    private javax.swing.JComboBox cmb_barang;
    private javax.swing.JComboBox cmb_nik;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tbl_pakai;
    private javax.swing.JTextField txt_barang;
    private javax.swing.JTextField txt_jumlah;
    private javax.swing.JTextField txt_nik;
    private javax.swing.JTextField txt_pemakaian;
    // End of variables declaration//GEN-END:variables

    private void masuk_table(){
        try {
            stat=kon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            tbm = new DefaultTableModel();
            tbm.addColumn("Kode Pakai");
            tbm.addColumn("NIK");
            tbm.addColumn("Kode Barang");
            tbm.addColumn("Jumlah");
            tbl_pakai.setModel(tbm);
            
            res = stat.executeQuery("SELECT * FROM pemakaian_barang");
            while(res.next()){
                tbm.addRow(new Object[]{
                    res.getString("kd_pengeluaran"),
                    res.getString("nik"),
                    res.getString("kd_barang"),
                    res.getString("jumlah"),
                });
                tbl_pakai.setModel(tbm);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
    
    private void ubah(){
        try {
            String sql ="UPDATE pemakaian_barang SET"                    
                    + " nik='"              + cmb_nik.getSelectedItem()
                    + "', kd_barang='"    + cmb_barang.getSelectedItem()
                    + "', jumlah='"  + txt_jumlah.getText()
                    + "' WHERE kd_pengeluaran= '"      + txt_pemakaian.getText() + "'";
            stat = kon.createStatement();
            stat.executeUpdate(sql);
            JOptionPane.showMessageDialog(rootPane, "Data Anda Berhasil Tersimpan ^-^");
        masuk_table();
        bersih();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
    
    private void simpan(){
        if(txt_pemakaian.getText().equals("")
                ||cmb_barang.getSelectedItem().equals("")
                ||cmb_nik.getSelectedItem().equals("")
                ||txt_jumlah.getText().equals(""))
        {
            JOptionPane.showMessageDialog(rootPane, "Masih ada field yang kosong x_x|");
        }else
        {
           try {
            String sql = "INSERT INTO pemakaian_barang VALUES('"
                +txt_pemakaian.getText()            + "','"
                +cmb_nik.getSelectedItem()       + "','"
                +cmb_barang.getSelectedItem()          + "','"                
                +txt_jumlah.getText()                + "')";
        stat = kon.createStatement();
        stat.executeUpdate(sql);
        JOptionPane.showMessageDialog(rootPane, "Data Anda Berhasil Tersimpan ^-^");
       masuk_table();
       kd_oto();
        bersih();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        } 
        }
        
        
    }
    
    private void bersih(){
        txt_jumlah.setText("");
        
        
    }
    
    private void hapus(){
        try {
            String sql = "DELETE FROM pemakaian_barang WHERE kd_pengeluaran ='" + txt_pemakaian.getText() + "'";
            stat = kon.createStatement();
            stat.executeUpdate(sql);
            JOptionPane.showMessageDialog(rootPane, "Data Anda Berhasil Terubah ^-^");
            masuk_table();
            kd_oto();
            bersih();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
    
     private void kd_oto(){
        try {
            String sql = "SELECT MAX(right(kd_pengeluaran,2)) FROM pemakaian_barang";
            
            stat=kon.createStatement();
            res = stat.executeQuery(sql);
            while(res.next()){
                int a = res.getInt(1);
               txt_pemakaian.setText("P00" + Integer.toString(a+1));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
    
    private void relasi_nik(){
        try {
            stat = kon.createStatement();
            res = stat.executeQuery("SELECT * FROM karyawan");
            while(res.next()){
                cmb_nik.addItem(res.getString("nik"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
    
    private void relasi_brg(){
        try {
            stat = kon.createStatement();
            res = stat.executeQuery("SELECT * FROM barang");
            while(res.next()){
                cmb_barang.addItem(res.getString("kd_barang"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
    /*private void relasi_barang(){
        try {
            stat = kon.createStatement();
            res = stat.executeQuery("SELECT * FROM barang");
            while(res.next()){
                cmb_barang.addItem(res.getString("kd_barang"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }*/

    void angka(KeyEvent a){
        if(Character.isAlphabetic(a.getKeyChar())){
            a.consume();
            JOptionPane.showMessageDialog(rootPane, "Tidak bisa memasukan Huruf");
        }
    }
    
}
