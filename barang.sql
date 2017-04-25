-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Inang: 127.0.0.1
-- Waktu pembuatan: 25 Feb 2016 pada 13.39
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

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `barang`
--
ALTER TABLE `barang`
  ADD CONSTRAINT `barang_ibfk_1` FOREIGN KEY (`no_rincian`) REFERENCES `rincian_pembelian` (`no_rincian`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
