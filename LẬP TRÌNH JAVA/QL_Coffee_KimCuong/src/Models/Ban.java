package Models;

public class Ban {
    private String  TenBan, TrangThai;
    private int MaBan;
    
    public Ban(){
        this.MaBan =0;
        this.TenBan ="";
        this.TrangThai ="";
    }
    public Ban(int ma, String ten, String trangthai){
        this.MaBan =ma;
        this.TenBan =ten;
        this.TrangThai =trangthai;
    }
    
    public void SetMaBan(int ma){
        this.MaBan = ma;
    }
    public int GetMaBan(){
        return this.MaBan;
    }
    public void SetTenBan(String ten){
        this.TenBan = ten;
    }
    public String GetTenBan(){
        return this.TenBan;
    }
    public void SetTrangThai(String trangthai){
        this.TrangThai = trangthai;
    }
    public String GetTrangThai(){
        return this.TrangThai;
    }
    @Override
    public String toString(){
        return this.TenBan;
    }
}
