-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Inang: 127.0.0.1
-- Waktu pembuatan: 25 Feb 2016 pada 19.24
-- Versi Server: 5.5.32
-- Versi PHP: 5.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Basis data: `db_laundry`
--
CREATE DATABASE IF NOT EXISTS `db_laundry` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `db_laundry`;

-- --------------------------------------------------------

--
-- Struktur dari tabel `barang`
--

CREATE TABLE IF NOT EXISTS `barang` (
  `kd_barang` varchar(4) NOT NULL,
  `no_rincian` varchar(4) NOT NULL,
  `nm_barang` varchar(30) NOT NULL,
  `stok` varchar(10) NOT NULL,
  `tgl_update_stock` varchar(20) NOT NULL,
  PRIMARY KEY (`kd_barang`),
  KEY `no_rincian` (`no_rincian`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `barang`
--

INSERT INTO `barang` (`kd_barang`, `no_rincian`, `nm_barang`, `stok`, `tgl_update_stock`) VALUES
('B001', 'R001', 'Rinso', '3', 'Feb 9, 2016'),
('B002', 'R002', 'pewangi', '2', 'Feb 9, 2016'),
('B003', 'R002', 'sikat', '10', 'Feb 14, 2016');

-- --------------------------------------------------------

--
-- Struktur dari tabel `jenis_laundry`
--

CREATE TABLE IF NOT EXISTS `jenis_laundry` (
  `id_jenis` varchar(4) NOT NULL,
  `nm_jenis` varchar(20) NOT NULL,
  PRIMARY KEY (`id_jenis`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `jenis_laundry`
--

INSERT INTO `jenis_laundry` (`id_jenis`, `nm_jenis`) VALUES
('C001', 'express'),
('C002', 'normal'),
('C003', 'cuci kering'),
('C004', 'cuci setrika');

-- --------------------------------------------------------

--
-- Struktur dari tabel `karyawan`
--

CREATE TABLE IF NOT EXISTS `karyawan` (
  `nik` int(5) NOT NULL,
  `nm_karyawan` varchar(30) NOT NULL,
  `alamat` text NOT NULL,
  `telp` varchar(13) NOT NULL,
  `jenkel` varchar(1) NOT NULL,
  `user` varchar(10) NOT NULL,
  `pass` varchar(20) NOT NULL,
  `type_user` varchar(10) NOT NULL COMMENT 'admin, operator, kasir',
  PRIMARY KEY (`nik`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `karyawan`
--

INSERT INTO `karyawan` (`nik`, `nm_karyawan`, `alamat`, `telp`, `jenkel`, `user`, `pass`, `type_user`) VALUES
(99901, 'eggy', 'Sambutan', '545454545', 'L', 'eggy', 'eggy', 'admin'),
(99903, 'Raya Bani', 'Samarinda', '0873647344344', 'L', 'ka', 'ka', 'kasir'),
(99904, 'Vicky Shu', 'samarinda', '0237826325372', 'L', 'op', 'op', 'operator'),
(99905, 'aditya', 'samarinda', '0867223235255', 'L', 'adit', 'adit', 'kasir');

-- --------------------------------------------------------

--
-- Struktur dari tabel `konsumen`
--

CREATE TABLE IF NOT EXISTS `konsumen` (
  `kd_konsumen` varchar(4) NOT NULL,
  `nm_konsumen` varchar(30) NOT NULL,
  `alamat` text NOT NULL,
  `telp` varchar(13) NOT NULL,
  PRIMARY KEY (`kd_konsumen`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `konsumen`
--

INSERT INTO `konsumen` (`kd_konsumen`, `nm_konsumen`, `alamat`, `telp`) VALUES
('K002', 'Andre', 'jl. Tarmidi', '0897586570698'),
('K003', 'sari', 'jl. bung tomo', '0897654365678'),
('K004', 'Rudi', 'jl, poros anggana', '0877876576563');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pemakaian_barang`
--

CREATE TABLE IF NOT EXISTS `pemakaian_barang` (
  `kd_pengeluaran` varchar(4) NOT NULL,
  `nik` int(5) NOT NULL,
  `kd_barang` varchar(4) NOT NULL,
  `jumlah` double NOT NULL,
  PRIMARY KEY (`kd_pengeluaran`),
  KEY `nik` (`nik`,`kd_barang`),
  KEY `kd_barang` (`kd_barang`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pemakaian_barang`
--

INSERT INTO `pemakaian_barang` (`kd_pengeluaran`, `nik`, `kd_barang`, `jumlah`) VALUES
('P001', 99901, 'B001', 4);

--
-- Trigger `pemakaian_barang`
--
DROP TRIGGER IF EXISTS `kurang`;
DELIMITER //
CREATE TRIGGER `kurang` AFTER INSERT ON `pemakaian_barang`
 FOR EACH ROW UPDATE barang SET stok = stok - NEW.jumlah WHERE kd_barang = NEW.kd_barang
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `pembelian`
--

CREATE TABLE IF NOT EXISTS `pembelian` (
  `no_pembelian` varchar(4) NOT NULL,
  `id_supplier` varchar(4) NOT NULL,
  `nik` int(5) NOT NULL,
  `tgl_pembelian` varchar(20) NOT NULL,
  `total` double NOT NULL,
  PRIMARY KEY (`no_pembelian`),
  KEY `id_supplier` (`id_supplier`,`nik`),
  KEY `nik` (`nik`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pembelian`
--

INSERT INTO `pembelian` (`no_pembelian`, `id_supplier`, `nik`, `tgl_pembelian`, `total`) VALUES
('BL01', 'S001', 99901, 'Jan 31, 2016', 40000),
('BL02', 'S003', 99903, 'Jan 31, 2016', 9000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `rincian_pembelian`
--

CREATE TABLE IF NOT EXISTS `rincian_pembelian` (
  `no_rincian` varchar(4) NOT NULL,
  `no_pembelian` varchar(4) NOT NULL,
  `jumlah` double NOT NULL,
  PRIMARY KEY (`no_rincian`),
  KEY `no_pembelian` (`no_pembelian`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `rincian_pembelian`
--

INSERT INTO `rincian_pembelian` (`no_rincian`, `no_pembelian`, `jumlah`) VALUES
('R001', 'BL02', 10),
('R002', 'BL01', 3);

--
-- Trigger `rincian_pembelian`
--
DROP TRIGGER IF EXISTS `tambah`;
DELIMITER //
CREATE TRIGGER `tambah` AFTER INSERT ON `rincian_pembelian`
 FOR EACH ROW UPDATE barang SET stok = stok+NEW.jumlah WHERE no_rincian = NEW.no_rincian
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `rincian_transaksi`
--

CREATE TABLE IF NOT EXISTS `rincian_transaksi` (
  `id_rincian` varchar(4) NOT NULL,
  `no_transaksi` varchar(4) NOT NULL,
  `id_pakaian` varchar(4) NOT NULL,
  `jumlah` double NOT NULL,
  PRIMARY KEY (`id_rincian`),
  KEY `id_pakaian` (`id_pakaian`),
  KEY `no_transaksi` (`no_transaksi`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `supplier`
--

CREATE TABLE IF NOT EXISTS `supplier` (
  `id_supplier` varchar(4) NOT NULL,
  `nm_supplier` varchar(30) NOT NULL,
  `alamat` text NOT NULL,
  `telp` varchar(13) NOT NULL,
  PRIMARY KEY (`id_supplier`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `supplier`
--

INSERT INTO `supplier` (`id_supplier`, `nm_supplier`, `alamat`, `telp`) VALUES
('S001', 'Indogrosir', 'jl.sempaja', '0868274575464'),
('S002', 'Alfamart', 'jl.hariadi', '0827436745354'),
('S003', 'indomaret', 'jl.merdeka', '0872861725761');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tarif`
--

CREATE TABLE IF NOT EXISTS `tarif` (
  `id_pakaian` varchar(4) NOT NULL,
  `nm_pakaian` varchar(20) NOT NULL,
  `id_jenis` varchar(4) NOT NULL,
  `tarif` double NOT NULL,
  PRIMARY KEY (`id_pakaian`),
  KEY `id_jenis` (`id_jenis`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tarif`
--

INSERT INTO `tarif` (`id_pakaian`, `nm_pakaian`, `id_jenis`, `tarif`) VALUES
('P001', 'kemeja', 'C001', 10000),
('P002', 'jas', 'C002', 30000),
('P003', 'kaos', 'C003', 5000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE IF NOT EXISTS `transaksi` (
  `no_transaksi` varchar(4) NOT NULL,
  `nik` int(5) NOT NULL,
  `kd_konsumen` varchar(4) NOT NULL,
  `tgl_transaksi` varchar(20) NOT NULL,
  `tgl_ambil` varchar(20) NOT NULL,
  `id_jenis` varchar(4) NOT NULL,
  `id_pakaian` varchar(4) NOT NULL,
  `tarif` double NOT NULL,
  `diskon` varchar(3) NOT NULL,
  `total` double NOT NULL,
  PRIMARY KEY (`no_transaksi`),
  KEY `nik` (`nik`,`kd_konsumen`,`id_jenis`,`id_pakaian`),
  KEY `kd_konsumen` (`kd_konsumen`),
  KEY `id_jenis_laundry` (`id_jenis`),
  KEY `id_pakaian` (`id_pakaian`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`no_transaksi`, `nik`, `kd_konsumen`, `tgl_transaksi`, `tgl_ambil`, `id_jenis`, `id_pakaian`, `tarif`, `diskon`, `total`) VALUES
('T001', 99903, 'K003', 'Feb 10, 2016', 'Feb 12, 2016', 'C001', 'P003', 5000, '0', 50000),
('T002', 99903, 'K003', 'Feb 10, 2016', 'Feb 12, 2016', 'C001', 'P002', 30000, '0', 150000);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `barang`
--
ALTER TABLE `barang`
  ADD CONSTRAINT `barang_ibfk_1` FOREIGN KEY (`no_rincian`) REFERENCES `rincian_pembelian` (`no_rincian`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `pemakaian_barang`
--
ALTER TABLE `pemakaian_barang`
  ADD CONSTRAINT `pemakaian_barang_ibfk_1` FOREIGN KEY (`nik`) REFERENCES `karyawan` (`nik`) ON UPDATE CASCADE,
  ADD CONSTRAINT `pemakaian_barang_ibfk_2` FOREIGN KEY (`kd_barang`) REFERENCES `barang` (`kd_barang`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `pembelian`
--
ALTER TABLE `pembelian`
  ADD CONSTRAINT `pembelian_ibfk_1` FOREIGN KEY (`id_supplier`) REFERENCES `supplier` (`id_supplier`) ON UPDATE CASCADE,
  ADD CONSTRAINT `pembelian_ibfk_2` FOREIGN KEY (`nik`) REFERENCES `karyawan` (`nik`) ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `rincian_pembelian`
--
ALTER TABLE `rincian_pembelian`
  ADD CONSTRAINT `rincian_pembelian_ibfk_1` FOREIGN KEY (`no_pembelian`) REFERENCES `pembelian` (`no_pembelian`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `rincian_transaksi`
--
ALTER TABLE `rincian_transaksi`
  ADD CONSTRAINT `rincian_transaksi_ibfk_1` FOREIGN KEY (`no_transaksi`) REFERENCES `transaksi` (`no_transaksi`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `rincian_transaksi_ibfk_2` FOREIGN KEY (`id_pakaian`) REFERENCES `tarif` (`id_pakaian`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `tarif`
--
ALTER TABLE `tarif`
  ADD CONSTRAINT `tarif_ibfk_1` FOREIGN KEY (`id_jenis`) REFERENCES `jenis_laundry` (`id_jenis`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`nik`) REFERENCES `karyawan` (`nik`) ON UPDATE CASCADE,
  ADD CONSTRAINT `transaksi_ibfk_2` FOREIGN KEY (`kd_konsumen`) REFERENCES `konsumen` (`kd_konsumen`) ON UPDATE CASCADE,
  ADD CONSTRAINT `transaksi_ibfk_4` FOREIGN KEY (`id_pakaian`) REFERENCES `tarif` (`id_pakaian`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `transaksi_ibfk_5` FOREIGN KEY (`id_jenis`) REFERENCES `jenis_laundry` (`id_jenis`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
