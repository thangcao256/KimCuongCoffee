-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 01, 2021 lúc 06:41 AM
-- Phiên bản máy phục vụ: 10.4.19-MariaDB
-- Phiên bản PHP: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `qlcafe`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ban`
--

CREATE TABLE `ban` (
  `MaBan` int(11) NOT NULL,
  `TenBan` varchar(55) COLLATE utf8_unicode_ci NOT NULL,
  `TrangThai` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `ban`
--

INSERT INTO `ban` (`MaBan`, `TenBan`, `TrangThai`) VALUES
(1, 'Bàn 1', 'Đã đặt trước'),
(2, 'Bàn 2', 'Đã đặt trước'),
(3, 'Bàn 3', 'Trống'),
(4, 'Bàn 4', 'Đã đặt trước'),
(5, 'Bàn 5', 'Trống'),
(6, 'Bàn 6', 'Trống'),
(7, 'Bàn 7', 'Trống'),
(8, 'Bàn 8', 'Đã đặt trước'),
(9, 'Bàn 9', 'Trống'),
(10, 'Bàn 10', 'Đã đặt trước'),
(11, 'Bàn 11', 'Đã đặt trước'),
(13, 'Bàn 12', 'Trống'),
(14, 'Bàn 13', 'Đã đặt trước'),
(15, 'Bàn 14', 'Trống'),
(16, 'Bàn 15', 'Trống'),
(17, 'Bàn 16', 'Đã đặt trước'),
(18, 'Bàn 17', 'Trống'),
(19, 'Bàn 18', 'Trống'),
(25, 'Bàn 19', 'Đã đặt trước'),
(31, 'Bàn 20', 'Trống');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitiethd`
--

CREATE TABLE `chitiethd` (
  `MaChiTietHD` int(11) NOT NULL,
  `MaHoaDon` int(11) NOT NULL,
  `MaMon` int(11) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `Gia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `MaHoaDon` int(11) NOT NULL,
  `GiamGia` int(11) DEFAULT NULL,
  `MaBan` int(11) NOT NULL,
  `GioDen` datetime NOT NULL,
  `TongTien` int(11) DEFAULT NULL,
  `TrangThai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhommon`
--

CREATE TABLE `nhommon` (
  `MaLoai` int(11) NOT NULL,
  `TenLoai` varchar(55) COLLATE utf8_unicode_ci NOT NULL,
  `MauSac` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nhommon`
--

INSERT INTO `nhommon` (`MaLoai`, `TenLoai`, `MauSac`) VALUES
(1, 'Cà phê', '#cccccc'),
(2, 'Nước đóng chai', '#66b3ff'),
(3, 'Nước-Lon', '#ff0000'),
(4, 'Lipton-Trà', '#ffcc00'),
(5, 'Sinh tố', '#ffcccc'),
(6, 'Thứ khác', '#cc9900'),
(14, 'Đồ ăn nhanh', '#009966');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `id` int(11) NOT NULL,
  `username` varchar(30) COLLATE utf8_vietnamese_ci NOT NULL,
  `password` varchar(30) COLLATE utf8_vietnamese_ci NOT NULL,
  `lv` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `taikhoan`
--

INSERT INTO `taikhoan` (`id`, `username`, `password`, `lv`) VALUES
(6, 'thanggun99', 'a', 1),
(7, 'nhanvien', '1', 2),
(10, 'nhanvien2', '1', 2),
(11, 'admin', 'admin', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thucdon`
--

CREATE TABLE `thucdon` (
  `MaMon` int(11) NOT NULL,
  `TenMon` varchar(55) COLLATE utf8_unicode_ci NOT NULL,
  `MaLoai` int(11) NOT NULL,
  `DonGia` int(11) NOT NULL,
  `DVT` varchar(55) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `thucdon`
--

INSERT INTO `thucdon` (`MaMon`, `TenMon`, `MaLoai`, `DonGia`, `DVT`) VALUES
(7, 'Nâu đá', 1, 25000, 'Ly'),
(8, 'Nâu nóng', 1, 25000, 'Ly'),
(9, 'Cafe Sữa', 1, 50000, 'Ly'),
(10, 'Lọc đá vắt chanh', 2, 40000, 'Chậu'),
(11, 'Nâu lắc', 1, 69000, 'Ly'),
(12, 'Trà Xanh ', 2, 25000, 'Chai'),
(13, 'Trà C2', 2, 20000, 'Chai'),
(14, 'Chanh muối', 2, 20000, 'Chai'),
(15, 'Coca Cola', 3, 25000, 'Lon'),
(16, 'RedBull', 3, 25000, 'Lon'),
(17, 'Pepsi', 3, 20000, 'Lon'),
(18, 'Trà Gừng', 4, 25000, 'Ly'),
(19, 'Trà Dilmah', 4, 25000, 'Ly'),
(20, 'Trà chanh', 4, 15000, 'Ly'),
(21, 'Trà My', 4, 200000, 'Bát'),
(22, 'Sinh tố Xoài', 5, 30000, 'Ly'),
(23, 'Sinh tố bơ', 5, 35000, 'Ly'),
(24, 'Sinh tố Dưa Hấu', 5, 30000, 'Ly'),
(25, 'Sinh tố Mãng Cầu', 5, 35000, 'Ly'),
(26, 'Sinh tố chanh leo', 5, 30000, 'Ly'),
(27, 'Sinh tố dưa chuột', 5, 35000, 'Ly'),
(28, 'kẹo cao su', 6, 1000, 'cái'),
(29, 'Hướng Dương', 6, 15000, 'Đĩa'),
(30, 'Khoai chiên', 6, 15000, 'Miếng'),
(31, 'Vina', 6, 30000, 'Bao'),
(32, '555', 6, 60000, 'Bao'),
(33, 'Thăng Long', 6, 20000, 'Bao'),
(34, 'Cao cao nóng', 1, 25000, 'Ly'),
(35, 'Ca cao nguội', 1, 25000, 'Ly'),
(36, 'Đen đá', 1, 25000, 'Ly'),
(37, 'Đen nóng ', 1, 25000, 'Ly'),
(38, 'Bia Ken', 3, 25000, 'Lon'),
(40, 'Bia Sài Gòn', 3, 20000, 'Lon'),
(41, 'Bia Hà Nội', 3, 20000, 'Lon'),
(44, 'Bia Kenn', 3, 25000, 'Lon'),
(45, 'Bia Ken', 3, 25000, 'Lon'),
(57, 'Mỳ tôm', 14, 15000, 'Bát'),
(58, 'Bánh mỳ pate', 14, 15000, 'Cái'),
(59, 'Mực nướng', 14, 55000, 'Con');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `ban`
--
ALTER TABLE `ban`
  ADD PRIMARY KEY (`MaBan`);

--
-- Chỉ mục cho bảng `chitiethd`
--
ALTER TABLE `chitiethd`
  ADD PRIMARY KEY (`MaChiTietHD`),
  ADD KEY `MaHoaDon` (`MaHoaDon`),
  ADD KEY `MaMon` (`MaMon`);

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`MaHoaDon`),
  ADD KEY `MaBan` (`MaBan`);

--
-- Chỉ mục cho bảng `nhommon`
--
ALTER TABLE `nhommon`
  ADD PRIMARY KEY (`MaLoai`);

--
-- Chỉ mục cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `thucdon`
--
ALTER TABLE `thucdon`
  ADD PRIMARY KEY (`MaMon`),
  ADD KEY `MaLoai` (`MaLoai`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `ban`
--
ALTER TABLE `ban`
  MODIFY `MaBan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- AUTO_INCREMENT cho bảng `chitiethd`
--
ALTER TABLE `chitiethd`
  MODIFY `MaChiTietHD` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=383;

--
-- AUTO_INCREMENT cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `MaHoaDon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=207;

--
-- AUTO_INCREMENT cho bảng `nhommon`
--
ALTER TABLE `nhommon`
  MODIFY `MaLoai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT cho bảng `thucdon`
--
ALTER TABLE `thucdon`
  MODIFY `MaMon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=66;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `chitiethd`
--
ALTER TABLE `chitiethd`
  ADD CONSTRAINT `chitiethd_ibfk_1` FOREIGN KEY (`MaHoaDon`) REFERENCES `hoadon` (`MaHoaDon`),
  ADD CONSTRAINT `chitiethd_ibfk_2` FOREIGN KEY (`MaMon`) REFERENCES `thucdon` (`MaMon`);

--
-- Các ràng buộc cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`MaBan`) REFERENCES `ban` (`MaBan`);

--
-- Các ràng buộc cho bảng `thucdon`
--
ALTER TABLE `thucdon`
  ADD CONSTRAINT `thucdon_ibfk_1` FOREIGN KEY (`MaLoai`) REFERENCES `nhommon` (`MaLoai`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
