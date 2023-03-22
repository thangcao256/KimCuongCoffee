package Interface.ThongKe;
import Models.Ban;
import Models.DsOrder;
import Models.HoaDon;
import Models.Loai;
import Models.TaiKhoan;
import Models.ThucDon;
import Mysql.ConnectSQL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class JpThongKe extends javax.swing.JPanel {
    ConnectSQL cn = new ConnectSQL();

    NumberFormat chuyentien = new DecimalFormat("#,###,###");
    public JpThongKe() {
        initComponents();
        FillTableHD();
        FillTableMon();
        loadinfo();
    }
    public void loadinfo(){
        ArrayList<Ban> arrTable = cn.GetBan(0);
        if (arrTable.size()>0) {
            int soban = 0;
            soban = arrTable.stream().map((_item) -> 1).reduce(soban, Integer::sum);
            lbltongban.setText(String.valueOf(soban));
         }
        ArrayList<Loai> loai = cn.GetLoai();
        if (arrTable.size() >0) {
            int soban = 0;
            soban = loai.stream().map((_item) -> 1).reduce(soban, Integer::sum);
            lbltongloai.setText(String.valueOf(soban));
         }
        ArrayList<ThucDon> td = cn.GetThucDon(null);
        if (arrTable.size() >0) {
            int soban = 0;
            soban = td.stream().map((_item) -> 1).reduce(soban, Integer::sum);
            lbltongmon.setText(String.valueOf(soban));
         }
        ArrayList<TaiKhoan> tk = cn.GetTaiKhoan();
        if (arrTable.size() >0) {
            int soban = 0;
            soban = tk.stream().map((_item) -> 1).reduce(soban, Integer::sum);
            lbltaikhoan.setText(String.valueOf(soban));
         }        
    }
    public void FillTableHD() {
        ArrayList<HoaDon> arrTable = cn.GetDSHD();
        DefaultTableModel tbmodel = new DefaultTableModel();

        tbmodel.addColumn("Mã hóa đơn");
        tbmodel.addColumn("Thời gian");
        tbmodel.addColumn("Tiền món");
        tbmodel.addColumn("Giảm giá");
        tbmodel.addColumn("Thành tiền");
        tbmodel.addColumn("Điểm bán");
        tbmodel.addColumn("Các món");
        SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy HH:mm a");
        if (arrTable.size() >0) {
            int hd = 0, tongtien=0, tongtienmon =0,giam=0, tonggiam =0;
            for (HoaDon td : arrTable) {
                hd++;
                tongtien += td.GetTongTien();
                String tenban = cn.GetBan(td.GetMaBan()).get(0).GetTenBan();
                ArrayList<DsOrder> order = cn.GetDsOrder(td.GetMaHD());
                String cacmon = "";
                int tienmon =0;
                for(DsOrder ds : order){
                    tienmon += ds.GetGia() * ds.GetSoLuong();
                    cacmon += ds.GetTenMon()+"("+ds.GetSoLuong()+")"+", ";
                }
                tongtienmon += tienmon;
                   
                    String dv = "";
                    if(td.GetGiamGia() >100){
                        giam = td.GetGiamGia();
                    }
                    if(td.GetGiamGia() == 0){
                        giam = 0;
                    }
                    if(td.GetGiamGia() <=100 && td.GetGiamGia() != 0){
                        giam = td.GetGiamGia() * tienmon / 100;
                        dv = "("+String.valueOf(td.GetGiamGia())+"%)";
                    }
                    tonggiam += giam;
                tbmodel.addRow(new Object[]{td.GetMaHD(), sf.format(td.GetGioDen()), chuyentien.format(tienmon), chuyentien.format(giam)+dv , chuyentien.format(td.GetTongTien()), tenban, cacmon});
            }
            lblgiam.setText(chuyentien.format(tonggiam)+" VNĐ");
            lbltienmon.setText(chuyentien.format(tongtienmon)+" VNĐ");
            lbltienthu.setText(chuyentien.format(tongtienmon - tonggiam)+" VNĐ");
            lblhd.setText(String.valueOf(hd)+" hóa đơn");

        }
        tbaleHD.setModel(tbmodel);
        for(int i = 0; i < tbaleHD.getColumnCount();i++){
            Class<?> col = tbaleHD.getColumnClass(i);
            tbaleHD.setDefaultEditor(col, null);
        }   
        tbaleHD.getColumnModel().getColumn(0).setMaxWidth(100);
        tbaleHD.getColumnModel().getColumn(1).setMinWidth(130);
        tbaleHD.getColumnModel().getColumn(1).setMaxWidth(130);
        tbaleHD.getColumnModel().getColumn(2).setMaxWidth(100);
        tbaleHD.getColumnModel().getColumn(3).setMaxWidth(100);
        tbaleHD.getColumnModel().getColumn(4).setMaxWidth(100);
        tbaleHD.getColumnModel().getColumn(5).setMaxWidth(100);
    } 
    public void FillTableMon() {
        ArrayList<ThucDon> arrTable = cn.GetChiTietMonByMa();
        
        DefaultTableModel tbmodel = new DefaultTableModel();

        tbmodel.addColumn("Tên món");
        tbmodel.addColumn("Đơn vị tính");
        tbmodel.addColumn("Số lượng");
        tbmodel.addColumn("Doanh thu");
        if (arrTable != null) {
            
            int somon = 0,tienmon=0;
            for (ThucDon td : arrTable) {
                ArrayList<DsOrder> ct = cn.GetGiaSoLuong(td.GetMaMon());
                if(cn.GetGiaSoLuong(td.GetMaMon()).size() > 0){
                    int gia =0,soluong =0;
                     for(DsOrder i : ct){
                         somon += i.GetSoLuong();
                         soluong += i.GetSoLuong();
                         gia += i.GetGia() * i.GetSoLuong();
                     }
                     tienmon += gia;
                         tbmodel.addRow(new Object[]{ct.get(0).GetTenMon(), ct.get(0).GetDVT(), soluong, chuyentien.format(gia)+" VNĐ"});
                }
            }
            lblmon.setText(String.valueOf(somon)+" món");

        } else {
        }
        tbmon.setModel(tbmodel);
        for(int i = 0; i < tbmon.getColumnCount();i++){
            Class<?> col = tbmon.getColumnClass(i);
            tbmon.setDefaultEditor(col, null);
        }        
    }    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbmon = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbaleHD = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblhd = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblmon = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbltienthu = new javax.swing.JLabel();
        lbltienmon = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblgiam = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbltongban = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbltongmon = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbltongloai = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbltaikhoan = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        dateChooser1 = new datechooser.beans.DateChooserCombo();
        dateChooser2 = new datechooser.beans.DateChooserCombo();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setForeground(new java.awt.Color(162, 11, 11));

        tbmon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbmon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tên món", "Đơn vị tính", "Số lượng", "Doanh thu"
            }
        ));
        jScrollPane1.setViewportView(tbmon);

        tbaleHD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbaleHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Thời gian", "Tiền món", "Giảm giá", "Thành tiền", "Điểm bán", "Các món"
            }
        ));
        jScrollPane2.setViewportView(tbaleHD);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Tổng số hóa đơn:");

        lblhd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblhd.setText("...");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Tổng số món đã bán:");

        lblmon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblmon.setText("...");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Tổng doanh thu:");

        lbltienthu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbltienthu.setText("...");

        lbltienmon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbltienmon.setText("...");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Tiền giảm giá: ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Tiền món:");

        lblgiam.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblgiam.setText("...");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Tổng số bàn: ");

        lbltongban.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbltongban.setText("jLabel7");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Tổng số món:");

        lbltongmon.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbltongmon.setText("jLabel7");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Tổng số loại:");

        lbltongloai.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbltongloai.setText("jLabel7");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Tổng số tài khoản:");

        lbltaikhoan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbltaikhoan.setText("jLabel7");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Thống kê theo món");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Thống kê theo hóa đơn");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Từ ngày");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Đến ngày");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Thống kê");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        dateChooser1.setCurrentView(new datechooser.view.appearance.AppearancesList("custom",
            new datechooser.view.appearance.ViewAppearance("custom",
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 13),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 13),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    true,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 13),
                    new java.awt.Color(0, 0, 255),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 13),
                    new java.awt.Color(128, 128, 128),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 11),
                    new java.awt.Color(0, 51, 255),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 13),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(255, 0, 0),
                    false,
                    false,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                (datechooser.view.BackRenderer)null,
                false,
                true)));
    dateChooser1.setCalendarBackground(new java.awt.Color(133, 140, 148));
    dateChooser1.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 14));
    dateChooser1.setLocale(new java.util.Locale("vi", "VN", ""));
    dateChooser1.setNavigateFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11));
    dateChooser1.setBehavior(datechooser.model.multiple.MultyModelBehavior.SELECT_PERIOD);

    dateChooser2.setCurrentView(new datechooser.view.appearance.AppearancesList("custom",
        new datechooser.view.appearance.ViewAppearance("custom",
            new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 13),
                new java.awt.Color(0, 0, 0),
                new java.awt.Color(0, 0, 255),
                false,
                true,
                new datechooser.view.appearance.swing.ButtonPainter()),
            new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 11),
                new java.awt.Color(0, 51, 255),
                new java.awt.Color(0, 0, 255),
                true,
                true,
                new datechooser.view.appearance.swing.ButtonPainter()),
            new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 13),
                new java.awt.Color(0, 0, 255),
                new java.awt.Color(0, 0, 255),
                false,
                true,
                new datechooser.view.appearance.swing.ButtonPainter()),
            new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 13),
                new java.awt.Color(128, 128, 128),
                new java.awt.Color(0, 0, 255),
                false,
                true,
                new datechooser.view.appearance.swing.LabelPainter()),
            new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 13),
                new java.awt.Color(0, 0, 0),
                new java.awt.Color(0, 0, 255),
                false,
                true,
                new datechooser.view.appearance.swing.LabelPainter()),
            new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 13),
                new java.awt.Color(0, 0, 0),
                new java.awt.Color(255, 0, 0),
                false,
                false,
                new datechooser.view.appearance.swing.ButtonPainter()),
            (datechooser.view.BackRenderer)null,
            false,
            true)));
dateChooser2.setCalendarBackground(new java.awt.Color(133, 140, 148));
dateChooser2.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 14));
dateChooser2.setLocale(new java.util.Locale("vi", "VN", ""));
dateChooser2.setNavigateFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11));
dateChooser2.setBehavior(datechooser.model.multiple.MultyModelBehavior.SELECT_PERIOD);

jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
jLabel15.setForeground(new java.awt.Color(102, 0, 0));
jLabel15.setText("KIM CƯƠNG COFFEE");

jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
jLabel16.setText("PREMIUM QUALITY");

javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
this.setLayout(layout);
layout.setHorizontalGroup(
    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(layout.createSequentialGroup()
        .addGap(69, 69, 69)
        .addComponent(jLabel12)
        .addGap(221, 221, 221)
        .addComponent(jLabel13)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(dateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(11, 11, 11)
        .addComponent(jLabel14)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(dateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(5, 5, 5)
        .addComponent(jButton1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jLabel11)
        .addGap(78, 78, 78))
    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbltienthu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(121, 121, 121))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lbltienmon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblgiam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblhd, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbltongban)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbltongmon)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbltongloai)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbltaikhoan)
                                .addGap(245, 245, 245))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblmon)
                                .addGap(335, 335, 335)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(80, 80, 80))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(23, 23, 23))))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel12)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(dateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(13, 13, 13)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblmon)
                    .addComponent(jLabel2)
                    .addComponent(lblhd)))
            .addGap(10, 10, 10)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(lbltienmon))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(lblgiam))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jLabel15)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel16)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lbltienthu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(lbltongmon)
                    .addComponent(jLabel6)
                    .addComponent(lbltongban)
                    .addComponent(jLabel8)
                    .addComponent(lbltongloai)
                    .addComponent(jLabel9)
                    .addComponent(lbltaikhoan)))
            .addContainerGap())
    );
    }// </editor-fold>//GEN-END:initComponents

    public void fillbydate1(){
        ArrayList<ThucDon> arrTable = cn.GetChiTietMonByMa();
        Date d1 = dateChooser1.getSelectedDate().getTime();
        Date d2 = dateChooser2.getSelectedDate().getTime();
        String s1 = String.format("%1$tY-%1$tm-%1$td", d1);
        String s2 = String.format("%1$tY-%1$tm-%1$td", d2);
        
        DefaultTableModel tbmodel = new DefaultTableModel();

        tbmodel.addColumn("Tên món");
        tbmodel.addColumn("Đơn vị tính");
        tbmodel.addColumn("Số lượng");
        tbmodel.addColumn("Doanh thu");
        if(arrTable.size() > 0) {
            int somon = 0,tienmon=0;
            for (ThucDon td : arrTable) {
                ArrayList<DsOrder> ct = cn.GetHdByDate(s1, s2, td.GetMaMon());
                if(ct.size() > 0){
                    int gia =0,soluong =0;
                     for(DsOrder i : ct){
                         somon += i.GetSoLuong();
                         soluong += i.GetSoLuong();
                         gia += i.GetGia() * i.GetSoLuong();
                     }
                     tienmon += gia;
                         tbmodel.addRow(new Object[]{ct.get(0).GetTenMon(), ct.get(0).GetDVT(), soluong, chuyentien.format(gia)+" VNĐ"});
                }
            }
            lblmon.setText(String.valueOf(somon)+" món");
            tbmon.setModel(tbmodel);
        }
        
        for(int i = 0; i < tbmon.getColumnCount();i++){
            Class<?> col = tbmon.getColumnClass(i);
            tbmon.setDefaultEditor(col, null);
        }                
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(dateChooser1.getText().isEmpty() || dateChooser2.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Bạn cần chọn ngày để thống kê !");
            return;
        }
        fillbydate1();
        fillbydate2();
        
        //SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
    public void fillbydate2(){
        Date d1 = dateChooser1.getSelectedDate().getTime();
        Date d2 = dateChooser2.getSelectedDate().getTime();
        String s1 = String.format("%1$tY-%1$tm-%1$td", d1);
        String s2 = String.format("%1$tY-%1$tm-%1$td", d2);        
       ArrayList<HoaDon> arrTable = cn.GetDSHD();
        DefaultTableModel tbmodel = new DefaultTableModel();

        tbmodel.addColumn("Mã hóa đơn");
        tbmodel.addColumn("Thời gian");
        tbmodel.addColumn("Tiền món");
        tbmodel.addColumn("Giảm giá");
        tbmodel.addColumn("Thành tiền");
        tbmodel.addColumn("Điểm bán");
        tbmodel.addColumn("Các món");
        SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy HH:mm a");
        if (arrTable.size() >0) {
            int hd = 0, tongtien=0, tongtienmon =0,giam=0, tonggiam =0;
            for (HoaDon td : arrTable) {
                
                tongtien += td.GetTongTien();
                String tenban = cn.GetBan(td.GetMaBan()).get(0).GetTenBan();
                ArrayList<DsOrder> order = cn.GetCtHDByDate(td.GetMaHD(), s1, s2);
                if(order.size() >0){
                    hd++;
                    String cacmon = "";
                    int tienmon =0;
                    for(DsOrder ds : order){
                        tienmon += ds.GetGia() * ds.GetSoLuong();
                        cacmon += ds.GetTenMon()+"("+ds.GetSoLuong()+")"+", ";
                    }
                    tongtienmon += tienmon;

                        String dv = "";
                        if(td.GetGiamGia() >100){
                            giam = td.GetGiamGia();
                        }
                        if(td.GetGiamGia() == 0){
                            giam = 0;
                        }
                        if(td.GetGiamGia() <=100 && td.GetGiamGia() != 0){
                            giam = td.GetGiamGia() * tienmon / 100;
                            dv = "("+String.valueOf(td.GetGiamGia())+"%)";
                        }
                        tonggiam += giam;
                    tbmodel.addRow(new Object[]{td.GetMaHD(), sf.format(td.GetGioDen()), chuyentien.format(tienmon), chuyentien.format(giam)+dv , chuyentien.format(td.GetTongTien()), tenban, cacmon});
            
                }
            }
            lblgiam.setText(chuyentien.format(tonggiam)+" VNĐ");
            lbltienmon.setText(chuyentien.format(tongtienmon)+" VNĐ");
            lbltienthu.setText(chuyentien.format(tongtienmon - tonggiam)+" VNĐ");
            lblhd.setText(String.valueOf(hd)+" hóa đơn");
            tbaleHD.setModel(tbmodel);
        }
        
        for(int i = 0; i < tbaleHD.getColumnCount();i++){
            Class<?> col = tbaleHD.getColumnClass(i);
            tbaleHD.setDefaultEditor(col, null);
        }   
        tbaleHD.getColumnModel().getColumn(0).setMaxWidth(100);
        tbaleHD.getColumnModel().getColumn(1).setMinWidth(130);
        tbaleHD.getColumnModel().getColumn(1).setMaxWidth(130);
        tbaleHD.getColumnModel().getColumn(2).setMaxWidth(100);
        tbaleHD.getColumnModel().getColumn(3).setMaxWidth(100);
        tbaleHD.getColumnModel().getColumn(4).setMaxWidth(100);
        tbaleHD.getColumnModel().getColumn(5).setMaxWidth(100);        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserCombo dateChooser1;
    private datechooser.beans.DateChooserCombo dateChooser2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblgiam;
    private javax.swing.JLabel lblhd;
    private javax.swing.JLabel lblmon;
    private javax.swing.JLabel lbltaikhoan;
    private javax.swing.JLabel lbltienmon;
    private javax.swing.JLabel lbltienthu;
    private javax.swing.JLabel lbltongban;
    private javax.swing.JLabel lbltongloai;
    private javax.swing.JLabel lbltongmon;
    private javax.swing.JTable tbaleHD;
    private javax.swing.JTable tbmon;
    // End of variables declaration//GEN-END:variables
}
