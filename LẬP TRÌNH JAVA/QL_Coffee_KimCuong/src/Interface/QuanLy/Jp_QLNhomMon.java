package Interface.QuanLy;
import Interface.BanHang.jpThucDon;
import Interface.Run;
import Models.Loai;
import Mysql.ConnectSQL;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Jp_QLNhomMon extends javax.swing.JPanel {
    ConnectSQL cn = new ConnectSQL();
    public static Jp_QLNhomMon nhom;
    public Jp_QLNhomMon() {
        initComponents();
        nhom = this;
        FillTable();
    }
    public void FillTable() {
        ArrayList<Loai> arrTable = cn.GetLoai();
        DefaultTableModel tbmodel = new DefaultTableModel();

        tbmodel.addColumn("Mã loại");
        tbmodel.addColumn("Tên loại");
        tbmodel.addColumn("Màu sắc");

        if (arrTable != null) {
            int soloai = 0;
            for (Loai l : arrTable) {
                soloai++;
                tbmodel.addRow(new Object[]{l.GetMaLoai(), l.GetTenLoai(),l.GetMauSac()});
            }
            lblthongtin.setText(String.valueOf(soloai)+" loại");
        } else {
            JOptionPane.showMessageDialog(null, "Không có loại nào");
        }
        tbNhomMon.setModel(tbmodel);
        for(int i = 0; i < tbNhomMon.getColumnCount();i++){
            Class<?> col = tbNhomMon.getColumnClass(i);
            tbNhomMon.setDefaultEditor(col, null);
        }        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbNhomMon = new javax.swing.JTable();
        bntThem = new javax.swing.JButton();
        bntSua = new javax.swing.JButton();
        bntXoa = new javax.swing.JButton();
        lblthongtin = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txttim = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(960, 492));

        tbNhomMon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbNhomMon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbNhomMon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbNhomMonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbNhomMon);

        bntThem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bntThem.setText("Thêm");
        bntThem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bntThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntThemActionPerformed(evt);
            }
        });

        bntSua.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bntSua.setText("Sửa");
        bntSua.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bntSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSuaActionPerformed(evt);
            }
        });

        bntXoa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bntXoa.setText("Xóa");
        bntXoa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bntXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntXoaActionPerformed(evt);
            }
        });

        lblthongtin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblthongtin.setText("Total");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Tổng số loại:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Tìm loại:");

        txttim.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txttim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttimKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txttim, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblthongtin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bntThem, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bntXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bntSua, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 931, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txttim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblthongtin)
                    .addComponent(bntThem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntSua, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbNhomMonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNhomMonMouseClicked

    }//GEN-LAST:event_tbNhomMonMouseClicked

    private void bntThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntThemActionPerformed
        DLQl_Them_Loai l = new DLQl_Them_Loai(Run.QlCafe, true);
        l.setVisible(true);
    }//GEN-LAST:event_bntThemActionPerformed

    private void bntSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSuaActionPerformed
        int select=tbNhomMon.getSelectedRow();
        if(select<0){
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn nhóm nào !");
        }else{
            String manhom = (String) tbNhomMon.getValueAt(select, 0);
            
            DLQl_Sua_Nhom sua = new DLQl_Sua_Nhom(Run.QlCafe, true, manhom);
            sua.setVisible(true);
        }
    }//GEN-LAST:event_bntSuaActionPerformed

    private void bntXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntXoaActionPerformed
        int[] selectedRows = tbNhomMon.getSelectedRows();

        if (selectedRows.length <= 0) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn nhóm nào !");
        } else {
            ArrayList<String> listmamon = new ArrayList<String>();
            String sp = "";
            for (int i : selectedRows) {
                String ma = (String) tbNhomMon.getValueAt(i, 0);
                listmamon.add(ma);
                String tennhom = (String) tbNhomMon.getValueAt(i, 1);

                sp += tennhom + "\n";
            }
            int qs;
            qs = JOptionPane.showConfirmDialog(null, "Xóa nhóm: \n " + sp, "Xóa nhóm", JOptionPane.YES_NO_OPTION);
            if (qs == JOptionPane.YES_OPTION) {
                boolean xoa = cn.DeleteNhom(listmamon);

                if (xoa == true) {
                    FillTable();
                    try{
                        Jp_QLThucDon.td.Fillcbb();
                        Jp_QLThucDon.td.FillTable(null);
                        Jp_QLThucDon.td.updateUI();
                        jpThucDon.td.FillLoai();
                        jpThucDon.td.updateUI();
                    }catch(Exception e){

                    }
                }else
                JOptionPane.showMessageDialog(null, "Không xóa được loại !");

            }
        }
    }//GEN-LAST:event_bntXoaActionPerformed

    private void txttimKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttimKeyReleased
        ArrayList<Loai> arrTable = cn.SearchLoai(txttim.getText());
        if(arrTable != null){
            DefaultTableModel tbmodel = new DefaultTableModel();

            tbmodel.addColumn("Mã loại");
            tbmodel.addColumn("Tên loại");
            tbmodel.addColumn("Màu sắc");

            int soloai = 0;
            for (Loai l : arrTable) {
                soloai++;
                tbmodel.addRow(new Object[]{l.GetMaLoai(), l.GetTenLoai(),l.GetMauSac()});
            }
            tbNhomMon.setModel(tbmodel);
            for(int i = 0; i < tbNhomMon.getColumnCount();i++){
                Class<?> col = tbNhomMon.getColumnClass(i);
                tbNhomMon.setDefaultEditor(col, null);
            }
        }
    }//GEN-LAST:event_txttimKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntSua;
    private javax.swing.JButton bntThem;
    private javax.swing.JButton bntXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblthongtin;
    private javax.swing.JTable tbNhomMon;
    private javax.swing.JTextField txttim;
    // End of variables declaration//GEN-END:variables
}
