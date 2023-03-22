package Interface.BanHang;
import Models.Ban;
import Mysql.ConnectSQL;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;//Tạo ra Object mặc định (0,0)
import java.awt.event.MouseAdapter;//1 lớp abstract để nhận các keyboard event
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public final class jpBanHang extends javax.swing.JPanel {
    ConnectSQL cn = new ConnectSQL();
    ArrayList<Ban> arrBan;
    ArrayList<Ban> ban;
    int MaBan;
    public static jpBanHang bh;
    public jpBanHang() {
        initComponents();
        bh = this;
        FillBan();
        jButton2.setBackground(Color.decode("#66ff33")); //Xanh lá
        jButton1.setBackground(Color.decode("#ff0000")); //Đỏ
        jButton3.setBackground(Color.decode("#ffff00")); //Vàng
    }
    
    public void fillLb(){
        jPanel2.removeAll();
        jPanel2.add(jLabel1);
        jPanel2.updateUI();        
    }
    
    public void FillBan(){
        arrBan = cn.GetBan(0);
        if(arrBan != null){
            jpBan.removeAll();
            JButton[] btn = new JButton[arrBan.size()];
            for(int i=0;i<arrBan.size();i++){
                btn[i] = new JButton();
                btn[i].setName(String.valueOf(arrBan.get(i).GetMaBan()));
                String[] mb = arrBan.get(i).GetTenBan().split(" ");
                
                btn[i].setText(mb[1]);
                btn[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/ico-Table.png")));
                Border thickBorder = new LineBorder(Color.WHITE,8);
                btn[i].setBorder(thickBorder);
                btn[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
                btn[i].setBackground(Color.decode("#66ff33"));
                btn[i].setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
                btn[i].setForeground(new java.awt.Color(51, 51, 51));
            
                //Lấy ra trạng thái bàn -> so sánh chuỗi -> lấy ra màu của jbutton
                if(arrBan.get(i).GetTrangThai().equals("Đang phục vụ")){
                    btn[i].setBackground(Color.decode("#ff0000"));
                }
                if(arrBan.get(i).GetTrangThai().equals("Đã đặt trước")){
                    btn[i].setBackground(Color.decode("#ffff00"));
                }                
                btn[i].setPreferredSize(new Dimension(90, 70));

                btn[i].addMouseListener(new MouseAdapter() {
                        @Override
                        
                        //Sự kiện click chuột vào bàn
                        public void mousePressed(MouseEvent e) {
                            JpGoiMon goimon;
                            ban = cn.GetBan(Integer.parseInt(e.getComponent().getName()));
                            if(ban != null){                            
                                goimon = new JpGoiMon(  ban.get(0).GetTrangThai(),
                                                        ban.get(0).GetTenBan(),
                                                        ban.get(0).GetMaBan()
                                                        );
                                jPanel2.removeAll();
                                jPanel2.add(goimon);
                                jPanel2.updateUI();
                            }
                        }                    
                });
                jpBan.add(btn[i]);
                jpBan.updateUI();
            }
        }
            
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jpBan = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setBackground(Color.decode("#e6e6e6"));
        setPreferredSize(new java.awt.Dimension(1280, 519));

        jPanel2.setBackground(Color.decode("#e6e6e6"));
        jPanel2.setPreferredSize(new java.awt.Dimension(580, 519));
        jPanel2.setLayout(new java.awt.BorderLayout(200, 300));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/cafe-menu-abstract-pattern-brown-colors-coffee-beans-background-32625326.jpg"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(580, 519));
        jLabel1.setMinimumSize(new java.awt.Dimension(580, 519));
        jLabel1.setPreferredSize(new java.awt.Dimension(580, 519));
        jPanel2.add(jLabel1, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(Color.decode("#e6e6e6"));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 102)));

        jpBan.setBackground(Color.decode("#e6e6e6"));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Trống");

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Phục vụ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Đã đặt trước");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("PREMIUM QUALITY");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 0, 0));
        jLabel6.setText("KIM CƯƠNG COFFEE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jpBan, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(83, 83, 83)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(126, 126, 126)
                        .addComponent(jLabel2))
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jpBan, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jButton2))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jpBan;
    // End of variables declaration//GEN-END:variables
}
