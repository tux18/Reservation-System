-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 31, 2018 at 04:24 PM
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
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `contact_num` varchar(255) NOT NULL,
  `fname` varchar(255) NOT NULL,
  `lname` varchar(255) NOT NULL,
  `counter` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`username`, `password`, `contact_num`, `fname`, `lname`, `counter`) VALUES
('asd', 'asd', '123', 'qwe', 'qwe', ''),
('daks', 'daks', '09876543211', 'Robert', 'Arilla', ''),
('dddd', 'eee', '000', 'kakak', 'ddd', ''),
('lala', 'lala', '33', 'lala', 'wqe', ''),
('ooo', 'test', '09352341234', 'Robert', 'Tugade', ''),
('qqq', 'asd', '123', 'qwe', 'qwe', '');

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
('82762', '5/26/2018', '550.0'),
('88801', '5/26/2018', '8500.0');

-- --------------------------------------------------------

--
-- Table structure for table `room_number`
--

CREATE TABLE `room_number` (
  `room_num` varchar(255) NOT NULL,
  `person_per_room` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room_number`
--

INSERT INTO `room_number` (`room_num`, `person_per_room`, `status`) VALUES
('Room 1', '1 to 2', 'Reserved'),
('Room 10', '1 to 9', 'Available'),
('Room 11', '1 to 8', 'Available'),
('Room 12', '1 to 5', 'Under Renovation'),
('Room 13', '1 to 5', 'Available'),
('Room 14', '1 to 6', 'Available'),
('Room 15', '1 to 3', 'Available'),
('Room 2', '1 to 2', 'Reserved'),
('Room 3', '1 to 3', 'Available'),
('Room 4', '1 to 2', 'Available'),
('Room 5', '1 to 5', 'Available'),
('Room 6', '1 to 5', 'Available'),
('Room 7', '1 to 4', 'Available'),
('Room 8', '1 to 6', 'Available'),
('Room 9', '1 to 4', 'Available');

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
  `amenities` varchar(255) NOT NULL,
  `xtra_amenities` varchar(255) NOT NULL,
  `total` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room_reserve`
--

INSERT INTO `room_reserve` (`ID`, `date`, `days`, `visitors`, `room_number`, `amenities`, `xtra_amenities`, `total`) VALUES
('68547', '5/31/2018', '6 Hour', '1 to 2', 'Room 1', 'No Amenities', 'No Extra Amenities', '844.0'),
('82336', '5/31/2018', '6 Hour', '1 to 2', 'Room 2', 'No Amenities', 'No Extra Amenities', '844.0');

--
-- Indexes for dumped tables
--

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
-- Indexes for table `room_number`
--
ALTER TABLE `room_number`
  ADD PRIMARY KEY (`room_num`);

--
-- Indexes for table `room_reserve`
--
ALTER TABLE `room_reserve`
  ADD PRIMARY KEY (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
