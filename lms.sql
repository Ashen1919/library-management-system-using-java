-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 22, 2024 at 04:09 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lms`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(3) NOT NULL,
  `name` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `name`, `password`) VALUES
(1, 'Ashen', 'ashen2001');

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `id` int(2) NOT NULL,
  `book_id` int(4) NOT NULL,
  `book_name` varchar(30) NOT NULL,
  `author_name` varchar(30) NOT NULL,
  `quantity` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`id`, `book_id`, `book_name`, `author_name`, `quantity`) VALUES
(3, 2, 'Management Principles', 'John De Grandhome', 5),
(4, 3, 'Software Engineering', 'Paul Collingwood', 6);

-- --------------------------------------------------------

--
-- Table structure for table `issue_details`
--

CREATE TABLE `issue_details` (
  `id` int(3) NOT NULL,
  `issue_id` int(3) NOT NULL,
  `bookId` varchar(20) NOT NULL,
  `studentId` varchar(20) NOT NULL,
  `issueDate` varchar(15) NOT NULL,
  `returnDate` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `issue_details`
--

INSERT INTO `issue_details` (`id`, `issue_id`, `bookId`, `studentId`, `issueDate`, `returnDate`) VALUES
(3, 100, '02', '2303s0834', '2024-09-07', '2024-09-15'),
(4, 102, '02', '2303s0834', '2024-09-07', '2024-09-15'),
(5, 105, '02', '2303s0834', '2024-09-07', '2024-09-15'),
(6, 104, '02', '2303s0834', '2024-09-07', '2024-09-15'),
(7, 103, '02', '2303s0834', '2024-09-07', '2024-09-15'),
(8, 106, '02', '2305s0876', '2024-09-07', '2024-09-15'),
(9, 107, '02', '2305s0892', '2024-09-07', '2024-09-15'),
(13, 108, '03', '2303s0834', '2024-09-11', '2024-09-18');

-- --------------------------------------------------------

--
-- Table structure for table `return_details`
--

CREATE TABLE `return_details` (
  `id` int(3) NOT NULL,
  `issueId` int(3) NOT NULL,
  `returnId` int(10) NOT NULL,
  `bookId` varchar(20) NOT NULL,
  `studentId` varchar(20) NOT NULL,
  `issueDate` varchar(15) NOT NULL,
  `currentDate` varchar(15) NOT NULL,
  `returnDate` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `return_details`
--

INSERT INTO `return_details` (`id`, `issueId`, `returnId`, `bookId`, `studentId`, `issueDate`, `currentDate`, `returnDate`) VALUES
(4, 105, 13, '02', '2303s0834', '2024-09-07', '2024-09-11', '2024-09-15'),
(5, 106, 12, '02', '2305s0876', '2024-09-07', '2024-09-17', '2024-09-15');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `id` int(3) NOT NULL,
  `stu_id` varchar(20) NOT NULL,
  `stu_name` varchar(30) NOT NULL,
  `course` varchar(40) NOT NULL,
  `email` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `stu_id`, `stu_name`, `course`, `email`) VALUES
(1, '2303s0834', 'Ashen Gimhana Dissanayaka', 'B.Sc.(Hons) in Computer Science', '2303s0834@saegis.ac.lk'),
(2, '2305s0892', 'Kasuni Madeesha', 'B.Sc.(Hons) in Software Engineering', '2305s0892@saegis.ac.lk'),
(3, '2305s0876', 'Namal Rajapaksha', 'B.Sc.(Hons) in Software Engineering', '2305s0876@saegis.ac.lk');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(10) NOT NULL,
  `name` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `contact` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `name`, `email`, `password`, `contact`) VALUES
(2, 'Kasuni', 'kasu@gmail.com', 'kasuni2001', '0741366911'),
(3, 'Gimhana', 'gimhana@gmail.com', 'gimhana2001', '0762234567'),
(4, 'ashen', 'ashendissanayaka0@gmail.com', 'ashen2001', '0764426675');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `issue_details`
--
ALTER TABLE `issue_details`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `return_details`
--
ALTER TABLE `return_details`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `id` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `issue_details`
--
ALTER TABLE `issue_details`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `return_details`
--
ALTER TABLE `return_details`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
