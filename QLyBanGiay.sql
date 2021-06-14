create database QLBanGiayFinal
go
use QLBanGiayFinal
go

create table TUYENBAY
(
	MaTuyenBay varchar(10) primary key,
	TenTuyenBay varchar(10)
	)
go
create table THUONGHIEUGIAY
(
	MaHang varchar(10) primary key,
	TenHang nvarchar(50),
	QuocGia nvarchar(50)
)
go


create table KHACHHANG
(
	CMND varchar(10) primary key,
	HoTen nvarchar(50),
	GioiTinh bit default 1,
	DienThoai varchar(10),
	Email varchar(50),
	DiaChi nvarchar(50)
)
go

create table NHANVIEN
(
	MaNhanVien varchar(10) primary key,
	MatKhau varchar(30),
	VaiTro Nvarchar(30),
	HoTen nvarchar(50),
	GioiTinh bit,
	DienThoai varchar(10),
	Email varchar(50),
	DiaChi nvarchar(50),
	Hinh varchar(100)
)
go

create table HANGGIAY
(
	MaHangGiay varchar(10) primary key,
	TenHangGiay nvarchar(50)
)
go

create table NHAPHANG
(
	MaNhapHang varchar(10) primary key,
	MaHang varchar(10),
	FOREIGN KEY (MaHang) REFERENCES THUONGHIEUGIAY(MaHang)
)
go

create table CHUYENBAY
(
	MaChuyenBay varchar(10) primary key,
	NgayDi date,
	NgayDen date,
	GioKhoiHanh time,
	Giaycaocap int,
	GiayPhoThong int,
	MaTuyenBay varchar(10),
	MaMayBay varchar(10),
	FOREIGN KEY (MaTuyenBay) REFERENCES TUYENBAY(MaTuyenBay),
	FOREIGN KEY (MaMayBay) REFERENCES NhapHang(MaNhapHang)
)
go

create table SizeGiay
(
	MaSize varchar(10) primary key,
	TenSize nvarchar(50)
)
go

create table GIAY
(
	MaGiay varchar(10) primary key,
	MaHangGiay varchar(10),
	MaSize varchar(10),
	MaChuyenBay varchar(10),
	GiaBan float,
	FOREIGN KEY (MaSize) REFERENCES SizeGiay(MaSize),
	FOREIGN KEY (MaHangGiay) REFERENCES HANGGIAY(MaHangGiay),
	FOREIGN KEY (MaChuyenBay) REFERENCES CHUYENBAY(MaChuyenBay),
)
go

create table DICHVU
(
	MaDichVu varchar(10),
	MaGiay varchar(10),
	TenDichVu Nvarchar(50),
	GiaDichVu float,
	primary key (MaDichVu, MaGiay),
	FOREIGN KEY (MaGiay) REFERENCES GIAY(MaGiay)
)
go

create table HOADON
(
	MaHoaDon varchar(10) primary key,
	NgayLap varchar(20),
	CMND varchar(10),
	MaNhanVien varchar(10),
	FOREIGN KEY (CMND) REFERENCES KHACHHANG(CMND),
	FOREIGN KEY (MaNhanVien) REFERENCES NHANVIEN(MaNhanVien)
)
go

create table HOADONCHITIET
(
	MaHoaDon varchar(10),
	MaGiay varchar(10),
	SoGheDat int,
	primary key (MaHoaDon, MaGiay),
	FOREIGN KEY (MaHoaDon) REFERENCES HOADON(MaHoaDon),
	FOREIGN KEY (MaGiay) REFERENCES GIAY(MaGiay)
)
go

insert into THUONGHIEUGIAY values('HG01', N'Nike', N'Mỹ')
insert into THUONGHIEUGIAY values('HG02', N'Adídas', N'Hy Lạp')
insert into THUONGHIEUGIAY values('HG03', N'Puma', N'Tây Ban Nha')

insert into NHAPHANG values('NH01', 'HG01')
insert into NHAPHANG values('NH02', 'HG02')
insert into NHAPHANG values('NH03', 'HG03')



insert into TUYENBAY values('TB01', 'Anh')
insert into TUYENBAY values('TB02', 'My')
insert into TUYENBAY values('TB03', 'Han')

insert into KHACHHANG values('221462830', N'Hồ Hoàng Tông', 0, '0856985586', 'tonghh@gmail.com', N'Phú Yên')
insert into KHACHHANG values('123456789', N'Ngô Tuấn Đức', 1, '0123456789', 'ducnt@gmail.com', N'TP Hồ Chí Minh')
insert into KHACHHANG values('123456788', N'Nguyễn Minh Ý', 1, '0123456788', 'minhy@gmail.com', N'Phú Yên')
insert into KHACHHANG values('123456787', N'Đoàn Quốc Trung', 1, '0123456786', 'trungqd@gmail.com', N'TP Hồ Chí Minh')
insert into KHACHHANG values('123456786', N'Phạm Thị Thanh Hằng', 0, '0123456787', 'hangptt@gmail.com', N'TP Hồ Chí Minh')


insert into NHANVIEN values('NV01', '123', N'Nhân viên', N'Thân Ngọc Minh Khuê', 0, '0123456789', 'tnmk@gmail.com', N'Phú Yên', 'croatia.jpg')
insert into NHANVIEN values('NV02', '123', N'Trưởng phòng', N'Lê Văn Ngọc Sơn', 1, '0123456788', 'lvnson@gmail.com', N'TP Hồ Chí Minh', 'trump.jpg')
insert into NHANVIEN values('NV03', '123', N'Nhân viên', N'Nguyễn Ý', 1, '0123456787', 'nguyeny@gmail.com', N'Phú Yên', 'phap.jpg')
insert into NHANVIEN values('NV04', '123', N'Trưởng phòng', N'Lê Trần Tấn Đạt', 1, '0123456786', 'lttdat@gmail.com', N'TP Hồ Chí Minh', 'putin.jpg')
insert into NHANVIEN values('NV05', '123', N'Nhân viên', N'Phan Thanh Hằng', 0, '0123456785', 'hangpt@gmail.com', N'TP Hồ Chí Minh', 'oldUSA.jpg')


set dateformat YMD
insert into CHUYENBAY values('CB01','2019-12-01','2019-12-02','08:20:00','18','151','TB01','NH03')
insert into CHUYENBAY values('CB02','2019-12-01','2019-12-03','22:00:00','24','156','TB01','NH01')
insert into CHUYENBAY values('CB03','2019-12-03','2019-12-05','07:30:00','8','195','TB02','NH02')

insert into HANGGIAY values('LG01', N'Giày Phổ Thông')
insert into HANGGIAY values('LG02', N'Giày Cao Cấp')


insert into SizeGiay values('Sz35', N'Size 35')
insert into SizeGiay values('Sz36', N'Size 36')
insert into SizeGiay values('Sz37', N'Size 37')
insert into SizeGiay values('Sz38', N'Size 38')
insert into SizeGiay values('Sz39', N'Size 39')
insert into SizeGiay values('Sz40', N'Size 40')

insert into GIAY values('N02','LG01','Sz35','CB01','11')
insert into GIAY values('N01','LG02','Sz36','CB02','7')
insert into GIAY values('N03','LG01','Sz37','CB02','14')
insert into GIAY values('N04','LG02','Sz37','CB03','22')

insert into GIAY values('A01','LG01','Sz35','CB02','11')
insert into GIAY values('A02','LG01','Sz39','CB01','7')
insert into GIAY values('A03','LG02','Sz38','CB02','14')
insert into GIAY values('A04','LG01','Sz35','CB02','21')


insert into GIAY values('P01','LG01','Sz36','CB03','14')
insert into GIAY values('P02','LG02','Sz38','CB02','21')
insert into GIAY values('P03','LG02','Sz39','CB01','6')
insert into GIAY values('P04','LG01','Sz40','CB01','7')

insert into DICHVU values('DV01','N01',N'LAU GIÀY','0.75')
insert into DICHVU values('DV02','N02',N'Thay đế','0.2')
insert into DICHVU values('DV03','N03',N'Vệ sinh','0.75')
insert into DICHVU values('DV04','N04',N'1 đổi 1','0.2')

insert into DICHVU values('DV05','A01',N'LAU GIÀY','0.75')
insert into DICHVU values('DV06','A02',N'Thay đế','0.75')
insert into DICHVU values('DV07','A03',N'Vệ sinh','0.2')
insert into DICHVU values('DV08','A04',N'1 đổi 1','0.75')


insert into DICHVU values('DV09','P01',N'1 đổi 1','0.75')
insert into DICHVU values('DV10','P02',N'Vệ sinh','0.2')
insert into DICHVU values('DV11','P03',N'Thay đế','0.75')
insert into DICHVU values('DV12','P04',N'LAU GIÀY','0.2')

set dateformat YMD 
insert into HOADON values('HD01', '2018-11-11', '221462830', 'NV04')
insert into HOADON values('HD02', '2019-10-13', '123456789', 'NV01')
insert into HOADON values('HD03', '2018-09-14', '123456788', 'NV05')
insert into HOADON values('HD04', '2018-08-17', '123456787', 'NV03')
insert into HOADON values('HD05', '2018-07-18', '123456786', 'NV02')

insert into HOADON values('HD06', '2018-07-02', '123456788', 'NV01')
insert into HOADON values('HD07', '2019-08-04', '123456786', 'NV02')
insert into HOADON values('HD08', '2018-03-06', '123456789', 'NV03')
insert into HOADON values('HD09', '2018-03-08', '123456787', 'NV04')
insert into HOADON values('HD10', '2018-01-10', '221462830', 'NV05')

insert into HOADON values('HD11', '2018-02-21', '123456788', 'NV05')
insert into HOADON values('HD12', '2018-01-22', '123456789', 'NV04')
insert into HOADON values('HD13', '2019-04-23', '123456788', 'NV03')
insert into HOADON values('HD14', '2019-05-24', '123456789', 'NV02')
insert into HOADON values('HD15', '2019-06-25', '123456788', 'NV01')

insert into HOADON values('HD16', '2018-07-16', '123456786', 'NV02')
insert into HOADON values('HD17', '2019-07-19', '123456786', 'NV05')
insert into HOADON values('HD18', '2019-06-22', '221462830', 'NV04')
insert into HOADON values('HD19', '2019-04-25', '221462830', 'NV01')
insert into HOADON values('HD20', '2018-01-28', '123456786', 'NV03')

insert into HOADON values('HD21', '2018-04-27', '123456787', 'NV05')
insert into HOADON values('HD22', '2019-06-06', '123456786', 'NV04')
insert into HOADON values('HD23', '2019-06-16', '123456787', 'NV03')
insert into HOADON values('HD24', '2019-07-05', '123456789', 'NV04')
insert into HOADON values('HD25', '2018-01-17', '123456786', 'NV01')

insert into HOADON values('HD26', '2019-02-06', '221462830', 'NV04')
insert into HOADON values('HD27', '2018-05-15', '123456786', 'NV04')
insert into HOADON values('HD28', '2018-05-24', '123456789', 'NV05')
insert into HOADON values('HD29', '2019-06-22', '123456788', 'NV03')
insert into HOADON values('HD30', '2018-04-28', '123456788', 'NV04')

insert into HOADONCHITIET values('HD01', 'N01',3)
insert into HOADONCHITIET values('HD02', 'N01',6)
insert into HOADONCHITIET values('HD03', 'N02',5)
insert into HOADONCHITIET values('HD04', 'N02',6)
insert into HOADONCHITIET values('HD05', 'N03',9)
insert into HOADONCHITIET values('HD06', 'N03',7)
insert into HOADONCHITIET values('HD07', 'N04',9)
insert into HOADONCHITIET values('HD08', 'N04',7)

insert into HOADONCHITIET values('HD09', 'A01',2)
insert into HOADONCHITIET values('HD10', 'A01',8)
insert into HOADONCHITIET values('HD11', 'A02',7)
insert into HOADONCHITIET values('HD12', 'A02',5)
insert into HOADONCHITIET values('HD13', 'A03',2)
insert into HOADONCHITIET values('HD14', 'A03',3)
insert into HOADONCHITIET values('HD15', 'A04',3)
insert into HOADONCHITIET values('HD16', 'A04',5)

insert into HOADONCHITIET values('HD17', 'P01',3)
insert into HOADONCHITIET values('HD18', 'P01',8)
insert into HOADONCHITIET values('HD19', 'P02',8)
insert into HOADONCHITIET values('HD20', 'P02',10)
insert into HOADONCHITIET values('HD21', 'P03',5)
insert into HOADONCHITIET values('HD22', 'P03',9)
insert into HOADONCHITIET values('HD23', 'P04',3)
insert into HOADONCHITIET values('HD24', 'P04',4)

insert into HOADONCHITIET values('HD25', 'A01',3)
insert into HOADONCHITIET values('HD26', 'N01',9)
insert into HOADONCHITIET values('HD27', 'P01',7)
insert into HOADONCHITIET values('HD28', 'A03',8)
insert into HOADONCHITIET values('HD29', 'N04',5)
insert into HOADONCHITIET values('HD30', 'P02',7)