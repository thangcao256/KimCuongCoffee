/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.QuanLy;

import Interface.BanHang.jpThucDon;
import Models.Loai;
import Mysql.ConnectSQL;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author ThangIKCU
 */
public class DLQl_Sua_Nhom extends javax.swing.JDialog {
    ConnectSQL cn = new ConnectSQL();
    /**
     * Creates new form DLQl_Sua_Nhom
     */
    String mausac, MaNhom;
    public DLQl_Sua_Nhom(java.awt.Frame parent, boolean modal, String manhom) {
        super(parent, modal);
        initComponents();
        MaNhom = manhom;
        Loai l = cn.GetLoaiByMa(manhom);
        mausac = l.GetMauSac();
        txtten.setText(l.GetTenLoai());
        jpmau.setBackground(Color.decode(mausac));
        lblten.setText("Sửa nhóm - "+l.GetTenLoai());  
 
        ColorSelectionModel model = chonmau.getSelectionModel();
        ChangeListener changeListener = new ChangeListener() {
            public void stateChanged(ChangeEvent changeEvent) {
                Color cl = chonmau.getColor();
                String hex = String.format("#%06x", cl.getRGB() & 0x00FFFFFF);
                jpmau.setBackground(Color.decode(hex));                
            }
        };
        model.addChangeListener(changeListener);        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblten = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtten = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        chonmau = new javax.swing.JColorChooser();
        jLabel3 = new javax.swing.JLabel();
        jpmau = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 0), 2));
        jPanel1.setPreferredSize(new java.awt.Dimension(760, 510));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Tên loại:");

        lblten.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblten.setForeground(new java.awt.Color(51, 0, 51));
        lblten.setText("NHÓM MENU");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Hủy bỏ");
        jButton1.setPreferredSize(new java.awt.Dimension(120, 40));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtten.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Xác nhận");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        chonmau.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        chonmau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chonmauMousePressed(evt);
            }
        });
        chonmau.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                chonmauPropertyChange(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Màu sắc:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Màu sắc hiển thị");

        javax.swing.GroupLayout jpmauLayout = new javax.swing.GroupLayout(jpmau);
        jpmau.setLayout(jpmauLayout);
        jpmauLayout.setHorizontalGroup(
            jpmauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpmauLayout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jLabel2)
                .addContainerGap(118, Short.MAX_VALUE))
        );
        jpmauLayout.setVerticalGroup(
            jpmauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpmauLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chonmau, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtten, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblten))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                                .addComponent(jpmau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(38, 38, 38))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(lblten)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jpmau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chonmau, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(txtten.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Tên loại không được để trống !");
            txtten.requestFocus();
            return;
        }
        Color cl = chonmau.getColor();
        String hex = String.format("#%06x", cl.getRGB() & 0x00FFFFFF);
        if("#ffffff".equals(hex)){
            hex = mausac;
        } 

        Loai loai = new Loai();
        loai.SetTenLoai(txtten.getText());
        loai.SetMauSac(hex);
        loai.SetMaLoai(MaNhom);
        int update = cn.UpdateLoai(loai);
        if(update > 0){
            Jp_QLNhomMon.nhom.FillTable();
            Jp_QLNhomMon.nhom.updateUI();
            try{
                Jp_QLThucDon.td.Fillcbb();
                Jp_QLThucDon.td.FillTable(null);
                Jp_QLThucDon.td.updateUI();
                jpThucDon.td.FillLoai();
                jpThucDon.td.updateUI();
            }catch(Exception e){

            }
            this.dispose();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void chonmauMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chonmauMousePressed

      

        // TODO add your handling code here:
    }//GEN-LAST:event_chonmauMousePressed

    private void chonmauPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_chonmauPropertyChange
          // TODO add your handling code here:
    }//GEN-LAST:event_chonmauPropertyChange

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JColorChooser chonmau;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jpmau;
    private javax.swing.JLabel lblten;
    private javax.swing.JTextField txtten;
    // End of variables declaration//GEN-END:variables
}
