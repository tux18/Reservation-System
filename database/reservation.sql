-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 28, 2018 at 06:42 PM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `reservation`
--

-- --------------------------------------------------------

--
-- Table structure for table `deleted_reserved`
--

CREATE TABLE `deleted_reserved` (
  `ID` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL,
  `days` varchar(255) NOT NULL,
  `total` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `contact_num` varchar(255) NOT NULL,
  `fname` varchar(255) NOT NULL,
  `lname` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`username`, `password`, `contact_num`, `fname`, `lname`) VALUES
('daks', 'daks', '09876543211', 'Robert', 'Arilla'),
('qwe', 'qwe', '123', 'qwe', 'qwe'),
('test', 'test', '09352341234', 'Robert', 'Tugade');

-- --------------------------------------------------------

--
-- Table structure for table `reports`
--

CREATE TABLE `reports` (
  `ID` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL,
  `total_balance` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reports`
--

INSERT INTO `reports` (`ID`, `date`, `total_balance`) VALUES
('88801', '5/26/2018', '8500.0');

-- --------------------------------------------------------

--
-- Table structure for table `room_reserve`
--

CREATE TABLE `room_reserve` (
  `ID` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL,
  `days` varchar(255) NOT NULL,
  `visitors` varchar(255) NOT NULL,
  `room_number` varchar(255) NOT NULL,
  `room_size` varchar(255) NOT NULL,
  `amenities` varchar(255) NOT NULL,
  `total` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room_reserve`
--

INSERT INTO `room_reserve` (`ID`, `date`, `days`, `visitors`, `room_number`, `room_size`, `amenities`, `total`) VALUES
('1355', '5/26/2018', '4 Day', '2', '141', 'Small', 'Package 1', '2200.0'),
('29312', '5/27/2018', '1 Day', '2', '455', 'Small', 'Package 4', '950.0'),
('48722', '5/27/2018', '1 Day', '234', '324', 'Small', 'Package 1', '550.0'),
('52801', '5/26/2018', '3 Day', '34', '454', 'Small', 'Package 1', '1650.0'),
('82762', '5/26/2018', '1 Day', '5', '232', 'Small', 'Package 1', '550.0');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `deleted_reserved`
--
ALTER TABLE `deleted_reserved`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `reports`
--
ALTER TABLE `reports`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `room_reserve`
--
ALTER TABLE `room_reserve`
  ADD PRIMARY KEY (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
