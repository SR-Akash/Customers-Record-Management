-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 15, 2019 at 07:15 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `customer_service`
--

-- --------------------------------------------------------

--
-- Table structure for table `final_service`
--

CREATE TABLE `final_service` (
  `Name` varchar(20) NOT NULL,
  `Service` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `final_service`
--

INSERT INTO `final_service` (`Name`, `Service`) VALUES
('suvo', 'FnF'),
('Akash', 'FnF'),
('Akash', 'FnF'),
('Akash', 'FnF'),
('Akash', 'Call Rate'),
('Akash', 'Network Problem'),
('Akash', 'Network Problem'),
('Akash', 'Internet Package'),
('Akash', 'Minute Package'),
('Akash', 'SMS Package'),
('Akash', 'Call Drop'),
('Akash', 'New Connection'),
('Akash', 'Emergency Call'),
('zakir', 'SMS Package'),
('zakir', 'Network Problem'),
('zakir', 'Emergency Call'),
('zakir', 'Call Rate'),
('zakir', 'Minute Package'),
('zakir', 'New Connection'),
('zakir', 'Call Drop'),
('zakir', 'Internet Package'),
('zakir', 'FnF'),
('zakir', 'Call Rate'),
('zakir', 'FnF'),
('zakir', 'FnF'),
('zakir', 'Call Rate'),
('ETY', 'FnF'),
('ETY', 'Call Rate'),
('ETY', 'Network Problem'),
('ETY', 'Internet Package'),
('ETY', 'Minute Package'),
('ETY', 'SMS Package'),
('ETY', 'Call Drop'),
('ETY', 'New Connection'),
('ETY', 'Emergency Call'),
('reza', 'New Connection'),
('sadika', 'SMS Package'),
('reza', 'Call Rate');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `id` int(20) NOT NULL,
  `Username` varchar(20) NOT NULL,
  `Pass` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`id`, `Username`, `Pass`) VALUES
(1, 'omi', '123');

-- --------------------------------------------------------

--
-- Table structure for table `userlogin`
--

CREATE TABLE `userlogin` (
  `id` int(20) NOT NULL,
  `Username` varchar(20) NOT NULL,
  `Service` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `userreg`
--

CREATE TABLE `userreg` (
  `id` int(20) NOT NULL,
  `Username` varchar(20) NOT NULL,
  `Pass` varchar(20) NOT NULL,
  `Phone` int(20) NOT NULL,
  `Email` varchar(20) NOT NULL,
  `Address` varchar(20) NOT NULL,
  `Gender` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userreg`
--

INSERT INTO `userreg` (`id`, `Username`, `Pass`, `Phone`, `Email`, `Address`, `Gender`) VALUES
(7, 'Zakir', '1', 17, 'zakir@gmail.com', 'Uttara', 'Male'),
(9, 'reza', '1', 17, 'reza@gmail.com', 'Savar', 'Female'),
(10, 'Akash', '1', 253, 'ssg', 'hv', 'vl'),
(11, 'sadika', '1', 11, 'svs', 'gd', 'hth');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `userlogin`
--
ALTER TABLE `userlogin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `userreg`
--
ALTER TABLE `userreg`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `userlogin`
--
ALTER TABLE `userlogin`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `userreg`
--
ALTER TABLE `userreg`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
