-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 20, 2024 at 05:54 AM
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
-- Database: `saegislibrary`
--

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `id` int(11) NOT NULL,
  `isbn` varchar(20) NOT NULL,
  `category_id` int(11) NOT NULL,
  `title` text NOT NULL,
  `author` varchar(150) NOT NULL,
  `publisher` varchar(150) NOT NULL,
  `publish_date` date NOT NULL,
  `status` int(1) NOT NULL,
  `cover_page` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`id`, `isbn`, `category_id`, `title`, `author`, `publisher`, `publish_date`, `status`, `cover_page`) VALUES
(22, '0-061-96436-0', 3, 'Basic Of IT', 'Collingwood', 'Steven publisher', '2024-08-19', 0, 'uploads/3.jpg'),
(23, '0-061-96436-1', 2, 'Management Concepts', 'Ashely silva', 'Beta Publishers', '2024-08-05', 0, 'uploads/4.jpg'),
(24, '0-061-96436-2', 1, 'General English', 'Stephen Hawkings', 'Jacobs Publisher', '2024-07-16', 0, 'uploads/6.jpg'),
(25, '0-061-96436-3', 3, 'Computer Science', 'John Doily', 'JK publishing', '2024-06-19', 0, 'uploads/5.jpg'),
(26, '0-061-96436-4', 1, 'Fundamental of English', 'Scott Meyers', 'Hoobstank Publishers', '2024-05-22', 0, 'uploads/1.jpg'),
(27, '0-061-96436-5', 2, 'Manager Theory', 'Philip de Silva', 'HK Publishers', '2024-07-30', 0, 'uploads/2.jpg'),
(28, '0-061-96436-6', 3, 'Software Engineering Concepts', 'Jorsh de Zoysa', 'Demo Publisher', '2024-03-11', 0, 'uploads/b1.jpg'),
(29, '0-061-96436-7', 3, 'Programming C/C++', 'Wishva Gunathilake', 'Gunathilake Publishers', '2024-06-19', 0, 'uploads/b2.jpg'),
(30, '0-061-96436-9', 1, 'IELTS Simple', 'Sakya Gunawardene', 'Sakya Publishers', '2024-06-05', 0, 'uploads/b4.jpg'),
(31, '0-061-96436-10', 2, 'Human Resource Management', 'Nuwan Zoysa', 'Zoysa Publishers', '2024-04-08', 0, 'uploads/b5.jpg'),
(32, '0-061-96436-11', 1, 'Basic Grammar', 'Paul Sterlin', 'Steven Publisher', '2024-06-25', 0, 'uploads/b1.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
(1, 'English'),
(2, 'Management'),
(3, 'Information Technology');

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `id` int(11) NOT NULL,
  `title` text NOT NULL,
  `code` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`id`, `title`, `code`) VALUES
(1, 'Bachelor of Business Administration (BBA)', 'BBA'),
(2, 'Bachelor of Science (Honours) in Computer Science', 'BSCCS'),
(3, 'Bachelor of Business Management Honours Degree', 'BBM'),
(4, 'Bachelor of Business Management Honors in Tourism and Hospitality Management Degree', 'BBMTH'),
(5, 'Bachelor of Business Management Honours Degree', 'BBM'),
(6, 'Bachelor of Business Management Honours In Accounting & Finance', 'BBA'),
(7, 'Bachelor of Business Management Honours in Human Resource Management', 'BBMHR'),
(8, 'Bachelor of Business Management Honours In Marketing Degree', 'BBMM'),
(9, 'Bachelor of Business Management Honours in Logistics and Supply Chain Management', 'BBMLSM'),
(10, 'Bachelor of Information Technology (BIT)', 'BIT'),
(11, 'BSc (Honours) in Information Technology', 'BSCIT'),
(12, 'BSc (Honours) in Software Engineering', 'BSCSE'),
(13, 'BA in English', 'BAE');

-- --------------------------------------------------------

--
-- Table structure for table `past_papers`
--

CREATE TABLE `past_papers` (
  `id` int(20) NOT NULL,
  `code` varchar(20) NOT NULL,
  `title` varchar(50) NOT NULL,
  `year` int(2) NOT NULL,
  `semester` varchar(15) NOT NULL,
  `pdf` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `past_papers`
--

INSERT INTO `past_papers` (`id`, `code`, `title`, `year`, `semester`, `pdf`) VALUES
(14, 'BSCCS', 'B.Sc.(Hons) in Computer Science', 1, '1', 'Computer architecture & organization.pdf'),
(15, 'BSCCS', 'B.Sc.(Hons) in Computer Science', 1, '1', 'Database Management System.pdf'),
(16, 'BSCCS', 'B.Sc.(Hons) in Computer Science', 1, '1', 'English.pdf'),
(17, 'BSCCS', 'B.Sc.(Hons) in Computer Science', 1, '1', 'Fundamental of programming.pdf'),
(18, 'BSCCS', 'B.Sc.(Hons) in Computer Science', 1, '1', 'Fundermentals of Mathematica.pdf'),
(19, 'BSCCS', 'B.Sc.(Hons) in Computer Science', 1, '1', 'Leadership.pdf'),
(20, 'BSCSE', 'B.Sc.(Hons) in Software Engineering', 1, '1', 'Computer architecture & organization.pdf'),
(21, 'BSCSE', 'B.Sc.(Hons) in Software Engineering', 1, '1', 'Database Management System.pdf'),
(22, 'BSCSE', 'B.Sc.(Hons) in Software Engineering', 1, '1', 'English.pdf'),
(23, 'BSCSE', 'B.Sc.(Hons) in Software Engineering', 1, '1', 'Fundamental of programming.pdf'),
(24, 'BSCSE', 'B.Sc.(Hons) in Software Engineering', 1, '1', 'Fundermentals of Mathematica.pdf'),
(25, 'BSCSE', 'B.Sc.(Hons) in Software Engineering', 1, '1', 'Leadership.pdf'),
(26, 'BIT', 'Bachelor of Information Technology', 1, '1', 'Database Management System (BIT).pdf'),
(27, 'BIT', 'Bachelor of Information Technology', 1, '2', 'Database Management System (BIT-2).pdf'),
(28, 'BSCCS', 'B.Sc.(Hons) in Computer Science', 1, '2', 'Data Communication & Ntworks Y1 S2.pdf'),
(29, 'BSCCS', 'B.Sc.(Hons) in Computer Science', 1, '2', 'Object Oriented Programming Y1 S2.pdf'),
(30, 'BSCCS', 'B.Sc.(Hons) in Computer Science', 1, '2', 'Probability and Statistics .pdf'),
(31, 'BSCCS', 'B.Sc.(Hons) in Computer Science', 1, '2', 'Software Engineering 1Y 2S.pdf'),
(32, 'BSCCS', 'B.Sc.(Hons) in Computer Science', 1, '2', 'Web Technologies 2y s1.pdf'),
(33, 'BSCSE', 'B.Sc.(Hons) in Software Engineering', 1, '2', 'Data Communication & Ntworks Y1 S2.pdf'),
(34, 'BSCSE', 'B.Sc.(Hons) in Software Engineering', 1, '2', 'Object Oriented Programming Y1 S2.pdf'),
(35, 'BSCSE', 'B.Sc.(Hons) in Software Engineering', 1, '2', 'Operating Systems semester 2 paper.pdf'),
(36, 'BSCSE', 'B.Sc.(Hons) in Software Engineering', 1, '2', 'Probability and Statistics .pdf'),
(37, 'BSCSE', 'B.Sc.(Hons) in Software Engineering', 1, '2', 'Software Engineering 1Y 2S.pdf'),
(38, 'BSCSE', 'B.Sc.(Hons) in Software Engineering', 1, '2', 'Web Technologies 2y s1.pdf'),
(39, 'BSCCS', 'B.Sc.(Hons) in Software Engineering', 1, '2', 'Operating Systems semester 2 paper.pdf'),
(40, 'BIT', 'Bachelor of Information Technology', 1, '2', 'Data Communication & Network.pdf'),
(41, 'BIT', 'Bachelor of Information Technology', 1, '2', 'Object Oriented Programming .pdf');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(20) NOT NULL,
  `studentID` varchar(15) NOT NULL,
  `email` varchar(30) NOT NULL,
  `otp` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `studentID`, `email`, `otp`) VALUES
(79, '2303s0834', '2303s0834@saegis.ac.lk', '218511'),
(80, '2303s0892', 'ashendissanayaka0@gmail.com', '121238'),
(81, '2303s0422', 'ashendissanayaka0@gmail.com', '416467'),
(82, '2303s0423', 'ashendissanayaka0@gmail.com', '288161'),
(83, '2303s0424', 'ashendissanayaka0@gmail.com', '753688'),
(84, '2303s0425', 'ashendissanayaka0@gmail.com', '867218'),
(85, '2303s0426', 'ashendissanayaka0@gmail.com', '857996'),
(86, '2303s0427', 'ashendissanayaka0@gmail.com', '377487'),
(87, '2303s0428', 'ashendissanayaka0@gmail.com', '603399');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `past_papers`
--
ALTER TABLE `past_papers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `course`
--
ALTER TABLE `course`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `past_papers`
--
ALTER TABLE `past_papers`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=88;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
