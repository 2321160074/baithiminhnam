package model;

import java.net.InterfaceAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import util.FileHelper;
/*
  Tác giả: Họ tên sinh viên
*/
public class QLKhachHang {

    private ArrayList<KhachHang> dsKhachHang;

    public QLKhachHang() {
        dsKhachHang = new ArrayList<>();
    }

    public QLKhachHang(ArrayList<KhachHang> dsKhachHang) {
        this.dsKhachHang = dsKhachHang;
    }

    public ArrayList<KhachHang> getDsKhachHang() {
        return dsKhachHang;
    }

    public void setDsKhachHang(ArrayList<KhachHang> dsKhachHang) {
        this.dsKhachHang = dsKhachHang;
    }

    //sinh viên cải đặt cho các phương thức xử lý sau
   
    public void DocDanhSachKhachHang(String FILE_NHAP) {
        ArrayList<String> data = FileHelper.readFileText(FILE_NHAP); //doc file
        //đổ dữ liệu vào danh sách
        dsKhachHang.clear();
        for (String item : data) {
            String[] arr = item.split(";");
            KhachHang kh = new KhachHang();
            kh.setMaso(arr[0]);
            kh.setHoten(arr[1]);
            kh.setLoai(Integer.parseInt(arr[2]));
            kh.setChisomoi(Double.parseDouble(arr[3]));
            kh.setChisocu(Double.parseDouble(arr[4]));
            dsKhachHang.add(kh);
        }

    }

    public boolean GhiHoaDon(String FILE_XUAT) {
ArrayList<String> data = new ArrayList<>();
        for (KhachHang kh : dsKhachHang) {
            String info = kh.getMaso() + ";" + kh.getHoten() + ";" + kh.getTieuThu()+ ";" + kh.getTienTra();
            data.add(info);
        }
        return FileHelper.writeFileText(FILE_XUAT, data);
      
    }
   
    public void sapXepTheoLoaiHinh() {
                 Collections.sort(dsKhachHang, new Comparator<KhachHang>() {
            @Override
            public int compare(KhachHang kh1, KhachHang kh2) {
                return Integer.compare(kh2.getLoai(), kh1.getLoai());
            }
        });      
    }
    
    public double getTieuThuCaoNhat()
    {
             double max = 0.0;
        for (KhachHang kh : dsKhachHang) {
            double tieuThu = kh.getTieuThu();
            if (tieuThu > max) {
                max = tieuThu;
            }
        }
        return max; 
    }
    
    public double getTieuThuThapNhat()
    {

        return 0;

    }
    
    public double getTieuThuTrungBinh()
    {
     double tongTieuThu = 0.0;
        for (KhachHang kh : dsKhachHang) {
            tongTieuThu += kh.getTieuThu();
        }
        return dsKhachHang.size() > 0 ? tongTieuThu / dsKhachHang.size() : 0.0;
      
    }
}
