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
-- Database: `libsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(60) NOT NULL,
  `firstname` varchar(30) NOT NULL,
  `lastname` varchar(30) NOT NULL,
  `photo` varchar(200) NOT NULL,
  `created_on` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`, `firstname`, `lastname`, `photo`, `created_on`) VALUES
(1, 'saegislibrary', '$2y$10$akBnJnGukghMvnFfYHDl6eyJdBVgEUUq49An7pmRtnCxvr5W4N5Jq', 'Saegis', 'Library', 'saegis logo.png', '2024-08-31');

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
(24, '0-061-96436-2', 1, 'General English', 'Stephen Hawkings', 'Jacobs Publisher', '2024-07-16', 1, 'uploads/6.jpg'),
(25, '0-061-96436-3', 3, 'Computer Science', 'John Doily', 'JK publishing', '2024-06-19', 0, 'uploads/5.jpg'),
(26, '0-061-96436-4', 1, 'Fundamental of English', 'Scott Meyers', 'Hoobstank Publishers', '2024-05-22', 0, 'uploads/1.jpg'),
(27, '0-061-96436-5', 2, 'Manager Theory', 'Philip de Silva', 'HK Publishers', '2024-07-30', 1, 'uploads/2.jpg'),
(28, '0-061-96436-6', 3, 'Software Engineering Concepts', 'Jorsh de Zoysa', 'Demo Publisher', '2024-03-11', 1, 'uploads/b1.jpg'),
(29, '0-061-96436-7', 3, 'Programming C/C++', 'Wishva Gunathilake', 'Gunathilake Publishers', '2024-06-19', 0, 'uploads/b2.jpg'),
(30, '0-061-96436-9', 1, 'IELTS Simple', 'Sakya Gunawardene', 'Sakya Publishers', '2024-06-05', 0, 'uploads/b4.jpg'),
(31, '0-061-96436-10', 2, 'Human Resource Management', 'Nuwan Zoysa', 'Zoysa Publishers', '2024-04-08', 0, 'uploads/b5.jpg'),
(32, '0-061-96436-11', 1, 'Basic Grammar', 'Paul Sterlin', 'Steven Publisher', '2024-06-25', 0, 'uploads/b1.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `borrow`
--

CREATE TABLE `borrow` (
  `id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `date_borrow` date NOT NULL,
  `status` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `borrow`
--

INSERT INTO `borrow` (`id`, `student_id`, `book_id`, `date_borrow`, `status`) VALUES
(17, 3, 1, '2024-05-04', 0),
(18, 3, 2, '2024-05-04', 1),
(19, 5, 3, '2024-06-26', 0),
(23, 6, 7, '2024-06-26', 1),
(24, 6, 4, '2024-06-26', 0),
(25, 27, 24, '2024-08-20', 0),
(26, 28, 28, '2024-08-20', 0),
(27, 30, 27, '2024-08-20', 0),
(28, 31, 23, '2024-08-20', 1);

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
-- Table structure for table `returns`
--

CREATE TABLE `returns` (
  `id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `date_return` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `returns`
--

INSERT INTO `returns` (`id`, `student_id`, `book_id`, `date_return`) VALUES
(3, 3, 2, '2024-05-04'),
(4, 3, 2, '2024-05-04'),
(5, 6, 4, '2024-06-26'),
(6, 6, 7, '2024-08-14'),
(7, 31, 23, '2024-08-20');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `id` int(11) NOT NULL,
  `student_id` varchar(15) NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `photo` varchar(200) NOT NULL,
  `course_id` int(11) NOT NULL,
  `created_on` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`id`, `student_id`, `firstname`, `lastname`, `photo`, `course_id`, `created_on`) VALUES
(27, '2303s0834', 'Ashen', 'Gimhana', 'IMG_0469.JPG', 2, '2024-08-19'),
(28, '2305s0892', 'Kasuni', 'Madeesha', '1000091428.jpg', 12, '2024-08-19'),
(29, '2305s0876', 'Dinith', 'Tharindu', 'WhatsApp Image 2024-08-19 at 20.46.59_a0466835.jpg', 12, '2024-08-19'),
(30, '2305S0869', 'Disura', 'Sandaruwan', 'WhatsApp Image 2024-08-19 at 20.57.03_f75a748c.jpg', 12, '2024-08-19'),
(31, '2305S0909', 'Sanduni', 'Madushika', 'WhatsApp Image 2024-08-19 at 20.59.33_c0fe1ba3.jpg', 12, '2024-08-19'),
(32, '2305S0924', 'Ushan', 'Sandeepa', '', 12, '2024-08-19');

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
-- Indexes for table `borrow`
--
ALTER TABLE `borrow`
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
-- Indexes for table `returns`
--
ALTER TABLE `returns`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `borrow`
--
ALTER TABLE `borrow`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

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
-- AUTO_INCREMENT for table `returns`
--
ALTER TABLE `returns`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
