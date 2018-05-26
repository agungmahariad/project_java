-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 26, 2018 at 02:26 AM
-- Server version: 10.1.25-MariaDB
-- PHP Version: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_penggajian`
--

-- --------------------------------------------------------

--
-- Table structure for table `bulan`
--

CREATE TABLE `bulan` (
  `nama_bulan` varchar(20) NOT NULL,
  `id_bulan` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bulan`
--

INSERT INTO `bulan` (`nama_bulan`, `id_bulan`) VALUES
('Januari', 1),
('Februari', 2),
('Maret', 3),
('April', 4),
('Mei', 5),
('Juni', 6),
('Juli', 7),
('Agustus', 8),
('September', 9),
('Oktober', 10),
('November', 11),
('Desember', 12);

-- --------------------------------------------------------

--
-- Table structure for table `data_gaji`
--

CREATE TABLE `data_gaji` (
  `kd_karyawan` varchar(10) NOT NULL,
  `tanggal` date NOT NULL,
  `id_bulan` int(2) NOT NULL,
  `id_gaji` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `data_gaji`
--

INSERT INTO `data_gaji` (`kd_karyawan`, `tanggal`, `id_bulan`, `id_gaji`) VALUES
('KR002', '2018-05-18', 5, 1),
('KR003', '2018-05-18', 5, 2),
('KR001', '2018-05-19', 5, 3),
('KR005', '2018-05-15', 5, 4),
('KR004', '2018-05-25', 5, 5),
('KR006', '2018-05-25', 5, 6);

-- --------------------------------------------------------

--
-- Stand-in structure for view `q_data`
-- (See below for the actual view)
--
CREATE TABLE `q_data` (
`kd_karyawan` varchar(5)
,`nama_karyawan` varchar(50)
,`umur` int(2)
,`jenis_kelamin` varchar(9)
,`jabatan` varchar(25)
,`alamat` text
,`tanggal` date
,`nama_bulan` varchar(20)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `q_gaji`
-- (See below for the actual view)
--
CREATE TABLE `q_gaji` (
`kd_karyawan` varchar(5)
,`nama_karyawan` varchar(50)
,`jabatan` varchar(25)
,`gaji_pokok` int(99)
,`tunjangan` int(99)
,`lembur` int(99)
,`bonus` int(99)
,`potongan` int(99)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `q_gajih`
-- (See below for the actual view)
--
CREATE TABLE `q_gajih` (
`kd_karyawan` varchar(5)
,`nama_karyawan` varchar(50)
,`umur` int(2)
,`jenis_kelamin` varchar(9)
,`jabatan` varchar(25)
,`alamat` text
,`tanggal` date
,`id_bulan` int(2)
);

-- --------------------------------------------------------

--
-- Table structure for table `tb_gaji`
--

CREATE TABLE `tb_gaji` (
  `kd_karyawan` varchar(5) NOT NULL,
  `nama_karyawan` varchar(50) NOT NULL,
  `gaji_pokok` int(99) NOT NULL,
  `tunjangan` int(99) NOT NULL,
  `lembur` int(99) NOT NULL,
  `bonus` int(99) NOT NULL,
  `potongan` int(99) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_gaji`
--

INSERT INTO `tb_gaji` (`kd_karyawan`, `nama_karyawan`, `gaji_pokok`, `tunjangan`, `lembur`, `bonus`, `potongan`) VALUES
('KR002', 'Hamz', 1000, 3, 4, 5, 6),
('KR001', 'Firman', 100000, 200000, 300000, 400000, 800000),
('KR003', 'Agung Mahariyad', 10000000, 10000000, 2500000, 1000000, 1000),
('KR005', 'Jess No Dilong', 100000000, 9999999, 999999, 9999999, 2000),
('KR004', 'Junaedi', 10, 10, 10, 10, 10),
('KR006', 'Baru', 1, 2, 3, 4, 6),
('KR007', 'Arif', 2, 3, 5, 6, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tb_karyawan`
--

CREATE TABLE `tb_karyawan` (
  `kd_karyawan` varchar(5) NOT NULL,
  `nama_karyawan` varchar(50) NOT NULL,
  `umur` int(2) NOT NULL,
  `jenis_kelamin` varchar(9) NOT NULL,
  `jabatan` varchar(25) NOT NULL,
  `alamat` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_karyawan`
--

INSERT INTO `tb_karyawan` (`kd_karyawan`, `nama_karyawan`, `umur`, `jenis_kelamin`, `jabatan`, `alamat`) VALUES
('KR001', 'Firman', 18, 'Laki-laki', 'Manager', 'muncang tengah'),
('KR002', 'Hamz', 20, 'Laki-laki', 'Staf Administrasi', 'muncang ujung'),
('KR003', 'Agung Mahariyad', 17, 'Laki-laki', 'General Manager', 'muncang'),
('KR004', 'Junaedi', 20, 'L', 'Manager', 'alamat'),
('KR005', 'Jess No Dilong', 17, 'Laki-laki', 'General Manager', 'Saint Heaven'),
('KR006', 'Baru', 90, 'L', 'Manager', 'Alamatku'),
('KR007', 'Arif', 20, 'Laki-laki', 'Supervisor', 'cisarua');

-- --------------------------------------------------------

--
-- Table structure for table `tb_user`
--

CREATE TABLE `tb_user` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_user`
--

INSERT INTO `tb_user` (`username`, `password`) VALUES
('admin', 'admin123');

-- --------------------------------------------------------

--
-- Structure for view `q_data`
--
DROP TABLE IF EXISTS `q_data`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `q_data`  AS  select `tb_karyawan`.`kd_karyawan` AS `kd_karyawan`,`tb_karyawan`.`nama_karyawan` AS `nama_karyawan`,`tb_karyawan`.`umur` AS `umur`,`tb_karyawan`.`jenis_kelamin` AS `jenis_kelamin`,`tb_karyawan`.`jabatan` AS `jabatan`,`tb_karyawan`.`alamat` AS `alamat`,`data_gaji`.`tanggal` AS `tanggal`,`bulan`.`nama_bulan` AS `nama_bulan` from ((`data_gaji` join `tb_karyawan` on((`data_gaji`.`kd_karyawan` = `tb_karyawan`.`kd_karyawan`))) join `bulan` on((`data_gaji`.`id_bulan` = `bulan`.`id_bulan`))) ;

-- --------------------------------------------------------

--
-- Structure for view `q_gaji`
--
DROP TABLE IF EXISTS `q_gaji`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `q_gaji`  AS  select `tb_karyawan`.`kd_karyawan` AS `kd_karyawan`,`tb_karyawan`.`nama_karyawan` AS `nama_karyawan`,`tb_karyawan`.`jabatan` AS `jabatan`,`tb_gaji`.`gaji_pokok` AS `gaji_pokok`,`tb_gaji`.`tunjangan` AS `tunjangan`,`tb_gaji`.`lembur` AS `lembur`,`tb_gaji`.`bonus` AS `bonus`,`tb_gaji`.`potongan` AS `potongan` from (`tb_karyawan` join `tb_gaji` on((`tb_karyawan`.`kd_karyawan` = `tb_gaji`.`kd_karyawan`))) ;

-- --------------------------------------------------------

--
-- Structure for view `q_gajih`
--
DROP TABLE IF EXISTS `q_gajih`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `q_gajih`  AS  select `tb_karyawan`.`kd_karyawan` AS `kd_karyawan`,`tb_karyawan`.`nama_karyawan` AS `nama_karyawan`,`tb_karyawan`.`umur` AS `umur`,`tb_karyawan`.`jenis_kelamin` AS `jenis_kelamin`,`tb_karyawan`.`jabatan` AS `jabatan`,`tb_karyawan`.`alamat` AS `alamat`,`data_gaji`.`tanggal` AS `tanggal`,`data_gaji`.`id_bulan` AS `id_bulan` from (`tb_karyawan` left join `data_gaji` on((`tb_karyawan`.`kd_karyawan` = `data_gaji`.`kd_karyawan`))) ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bulan`
--
ALTER TABLE `bulan`
  ADD PRIMARY KEY (`id_bulan`);

--
-- Indexes for table `data_gaji`
--
ALTER TABLE `data_gaji`
  ADD PRIMARY KEY (`id_gaji`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `data_gaji`
--
ALTER TABLE `data_gaji`
  MODIFY `id_gaji` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
