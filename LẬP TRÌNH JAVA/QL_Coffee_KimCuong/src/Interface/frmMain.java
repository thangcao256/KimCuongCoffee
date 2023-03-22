package Interface;
import Interface.BanHang.jpBanHang;
import Interface.Home.JpHome;
import Interface.QuanLy.JpQuanLy;
import Interface.Setting.JpSetting;
import Models.Ban;
import Models.TaiKhoan;
import Mysql.ConnectSQL;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;//pthức để đdạng và ptích date, mon, time
import java.util.ArrayList;
import java.util.Calendar;//pt cđ ngày giữa một tđiểm cụ thể theo time
import Interface.ThongKe.JpThongKe;

public final class frmMain extends javax.swing.JFrame {
    ConnectSQL cn = new ConnectSQL();
    /**
     * Creates new form frmMain
     * @param user
     * @param pass
     * @return 
     */
    public TaiKhoan loadtaikhoan(String user, String pass){
       return cn.GetTaiKhoan(user, pass);       
    }
    
    //Phân quyền đăng nhập
    public frmMain() {
        initComponents();
        fill();
        Clock clock= new Clock(); 
        clock.start(); 
        txtqtv.setText(Run.tk.GetUsername());//Hiền thị usernam trên frame Main
        //Thiết lập trạng thái hiển thị theo lv tài khoản
        if(Run.tk.GetLv() != 1)
        {
            btnQuanLy.setEnabled(false);
            btnThongKe.setEnabled(false);
       }
    }
    
    //Hiển thị thông tin giờ, bàn....
    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss_a");
    
    public class Clock extends Thread { 
        public Clock(){    } 
        @Override
        public void run(){ 
            while(true){ 
                int bandat =0, banpv=0;
                ArrayList<Ban> arrBan = cn.GetBan(0);
                for(int i = 0;i<arrBan.size();i++){
                    if(arrBan.get(i).GetTrangThai().equals("Đang phục vụ")){
                        banpv++;
                    }
                    if(arrBan.get(i).GetTrangThai().equals("Đã đặt trước")){
                        bandat++;
                    }            
                } 
                lblpv.setText(+banpv+" bàn đang phục vụ");
                lbldat.setText(+bandat+" bàn đặt trước");
                Calendar calendar = Calendar.getInstance();                
                String str;  
                str= sdf.format(calendar.getTime()); 
                lbltime.setText(str); 
            try{ 
                sleep(5000); 
              } catch(InterruptedException e){ 
                 System.out.println(e); 
                } 
            } 
        }
    }
    
    public void fill(){
        home = new JpHome();
        jpLayout.add(home);
        jpLayout.updateUI();
        }
    
    jpBanHang banhang;
    JpHome home ;
    JpSetting set;
    JpQuanLy ql;
    JpThongKe tk ;
 
    
    //Load frame theo sự kiện
    public void reloadPanel(int i) {
        jpLayout.removeAll();
        switch (i) {
            case 1:
                if (banhang == null) {
                    banhang = new jpBanHang();
                } 
                jpLayout.add(banhang);
                break;
            case 2:
                if (home == null) {
                    home = new JpHome();
                }
                jpLayout.add(home);
                break;
            case 3:
                if(ql == null){
                    ql = new JpQuanLy();
                }
                jpLayout.add(ql);
                break;
            case 4:
                tk = new JpThongKe();
                jpLayout.add(tk);
                break;
            case 5:
                set = new JpSetting();
                jpLayout.add(set);
                break;                
            default:
                break;
        }
        jpLayout.updateUI();//Phục hồi thuộc tính UI
    }   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jPanel2 = new javax.swing.JPanel();
        btnThietLap = new javax.swing.JButton();
        btnQuanLy = new javax.swing.JButton();
        btnBanHang = new javax.swing.JButton();
        btnThongKe = new javax.swing.JButton();
        jpLayout = new javax.swing.JPanel();
        btnthoat = new javax.swing.JButton();
        btnTrangChu = new javax.swing.JButton();
        lbltime = new javax.swing.JLabel();
        lblpv = new javax.swing.JLabel();
        lbldat = new javax.swing.JLabel();
        txtqtv = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("COFFEE KIM CƯƠNG");
        setBackground(Color.decode("#e6e6e6")
        );
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setForeground(new java.awt.Color(255, 204, 255));
        setLocation(new java.awt.Point(0, 0));
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jPanel2.setBackground(Color.decode("#e6e6e6"));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel2.setToolTipText("HHAHAA");
        jPanel2.setPreferredSize(new java.awt.Dimension(1280, 600));

        btnThietLap.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThietLap.setText("THIẾT LẬP");
        btnThietLap.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThietLap.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThietLap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThietLapActionPerformed(evt);
            }
        });

        btnQuanLy.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnQuanLy.setText("QUẢN LÝ");
        btnQuanLy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuanLy.setPreferredSize(new java.awt.Dimension(140, 49));
        btnQuanLy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyActionPerformed(evt);
            }
        });

        btnBanHang.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBanHang.setText("BÁN HÀNG");
        btnBanHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBanHang.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBanHangActionPerformed(evt);
            }
        });

        btnThongKe.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThongKe.setText("THỐNG KÊ");
        btnThongKe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });

        jpLayout.setBackground(Color.decode("#e6e6e6")
        );
        jpLayout.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jpLayout.setLayout(new java.awt.BorderLayout());

        btnthoat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnthoat.setForeground(new java.awt.Color(0, 51, 0));
        btnthoat.setText("Đăng xuất");
        btnthoat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnthoat.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnthoat.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnthoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthoatActionPerformed(evt);
            }
        });

        btnTrangChu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnTrangChu.setText("TRANG CHỦ");
        btnTrangChu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTrangChu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTrangChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrangChuActionPerformed(evt);
            }
        });

        lbltime.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbltime.setForeground(new java.awt.Color(51, 51, 255));
        lbltime.setText("Giờ");

        lblpv.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblpv.setForeground(new java.awt.Color(51, 51, 255));
        lblpv.setText("Đang phục vụ");

        lbldat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbldat.setForeground(new java.awt.Color(51, 51, 255));
        lbldat.setText("Đã đặt");

        txtqtv.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtqtv.setForeground(new java.awt.Color(51, 51, 255));
        txtqtv.setText("tk");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("QTV:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jpLayout, javax.swing.GroupLayout.PREFERRED_SIZE, 1254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnQuanLy, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThietLap, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbltime, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblpv, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbldat, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtqtv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnthoat)
                        .addGap(18, 18, 18))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnQuanLy, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnThietLap, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblpv)
                        .addComponent(lbltime)
                        .addComponent(lbldat)
                        .addComponent(jLabel1)
                        .addComponent(txtqtv)
                        .addComponent(btnthoat)))
                .addGap(10, 10, 10)
                .addComponent(jpLayout, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1241, 1241, 1241)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(266, 266, 266)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 610, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBanHangActionPerformed
        reloadPanel(1);
    }//GEN-LAST:event_btnBanHangActionPerformed
    
    
    public void thoat() {
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE );
        int kq=JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn đóng phần mềm ?","Thông báo",JOptionPane.YES_NO_OPTION);
        if(kq==0)
        {
        System.exit(0);
       }
}
    
    //Đăng xuất tài khoản
    private void btnthoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthoatActionPerformed
        int kq=JOptionPane.showConfirmDialog(null, "Đăng xuất khỏi tài khoản " +Run.tk.GetUsername()+ "?","Thông báo",JOptionPane.YES_NO_OPTION);
        if(kq==0)
        {
            Run.frmlg.setVisible(true);
            Run.frmlg.thoat();
            this.setVisible(false);
        } 
    }//GEN-LAST:event_btnthoatActionPerformed

    private void btnTrangChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrangChuActionPerformed
        reloadPanel(2);
    }//GEN-LAST:event_btnTrangChuActionPerformed

    private void btnThietLapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThietLapActionPerformed
        reloadPanel(5);
    }//GEN-LAST:event_btnThietLapActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

    }//GEN-LAST:event_formMouseClicked

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        reloadPanel(4);
    }//GEN-LAST:event_btnThongKeActionPerformed
    private void btnQuanLyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyActionPerformed
        reloadPanel(3); 
    }//GEN-LAST:event_btnQuanLyActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBanHang;
    private javax.swing.JButton btnQuanLy;
    private javax.swing.JButton btnThietLap;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JButton btnTrangChu;
    private javax.swing.JButton btnthoat;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jpLayout;
    private javax.swing.JLabel lbldat;
    private javax.swing.JLabel lblpv;
    private javax.swing.JLabel lbltime;
    private javax.swing.JLabel txtqtv;
    // End of variables declaration//GEN-END:variables
}
