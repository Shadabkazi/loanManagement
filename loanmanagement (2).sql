-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 29, 2016 at 03:49 PM
-- Server version: 5.6.25-log
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `loanmanagement`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `Username` varchar(20) NOT NULL,
  `Password` varchar(40) NOT NULL,
  PRIMARY KEY (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`Username`, `Password`) VALUES
('admin', 'q');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
  `C_ID` int(10) NOT NULL AUTO_INCREMENT,
  `Customer_Name` varchar(30) NOT NULL,
  `Gender` char(1) NOT NULL,
  `Email_ID` varchar(30) NOT NULL,
  `Address` varchar(40) NOT NULL,
  `City` varchar(15) NOT NULL,
  `State` varchar(15) NOT NULL,
  `Phone` decimal(10,0) NOT NULL,
  `Occupation` varchar(30) NOT NULL,
  `Annual_Income` int(10) NOT NULL,
  PRIMARY KEY (`C_ID`),
  UNIQUE KEY `Email_ID` (`Email_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1008 ;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`C_ID`, `Customer_Name`, `Gender`, `Email_ID`, `Address`, `City`, `State`, `Phone`, `Occupation`, `Annual_Income`) VALUES
(3, 'Mustafa Rangwala', 'M', 'mustanity@gmail.com', 'Vashi', 'Vashi', 'Maharashtra', '9664619152', 'fukat', 1500),
(1000, 'Abdullah', 'M', 'saqib@gmail.com', 'Nerul, Navi Mumbai', 'Navi Mumbai', 'Maharashtra', '9876543210', 'Student', 150000),
(1001, 'Virat Kohli', 'M', 'virat.kohli@gmail.com', 'new Delhi, Delhi', 'Delhi', 'Delhi', '9356521543', 'Sports', 500000000),
(1007, 'Sameer Khan', 'M', 'sameerkhan123@gmail.com', 'gandhi nagar, Santacruz', 'Mumbai', 'Maharashtra', '9876543210', 'Student', 200000);

-- --------------------------------------------------------

--
-- Table structure for table `customer_loan`
--

CREATE TABLE IF NOT EXISTS `customer_loan` (
  `Loan_ID` int(10) NOT NULL AUTO_INCREMENT,
  `C_ID` int(10) NOT NULL,
  `Loan_Type_ID` int(20) NOT NULL,
  `Loan_Status` varchar(15) NOT NULL,
  `Principle_Amount` int(10) NOT NULL,
  `Balance` int(10) NOT NULL,
  `Total_EMI` int(3) NOT NULL,
  `EMI_Submitted` int(3) NOT NULL,
  `Date_Of_Approval` date DEFAULT NULL,
  `Date_Of_submission` date NOT NULL,
  PRIMARY KEY (`Loan_ID`),
  KEY `C_ID` (`C_ID`,`Loan_Type_ID`),
  KEY `Loan_Type_ID` (`Loan_Type_ID`),
  KEY `C_ID_2` (`C_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4014 ;

--
-- Dumping data for table `customer_loan`
--

INSERT INTO `customer_loan` (`Loan_ID`, `C_ID`, `Loan_Type_ID`, `Loan_Status`, `Principle_Amount`, `Balance`, `Total_EMI`, `EMI_Submitted`, `Date_Of_Approval`, `Date_Of_submission`) VALUES
(4010, 1000, 4, 'Approved', 5000000, 5000000, 24, 0, '2016-03-29', '2016-03-21'),
(4011, 3, 2, 'Not Approved', 800000, 800000, 24, 0, NULL, '2016-03-21'),
(4012, 1007, 5, 'Approved', 100000, 94445, 18, 1, '2016-03-29', '2016-03-29');

-- --------------------------------------------------------

--
-- Table structure for table `loan_type`
--

CREATE TABLE IF NOT EXISTS `loan_type` (
  `Loan_Type_ID` int(10) NOT NULL AUTO_INCREMENT,
  `Loan_Name` varchar(30) NOT NULL,
  `Rate_Of_Interest` int(2) NOT NULL,
  `Minimum_Amount` int(6) NOT NULL,
  `Maximum_Amount` int(10) NOT NULL,
  `Minimum_Tenure` int(2) NOT NULL,
  `Maximum_Tenure` int(3) NOT NULL,
  `Yearly_Income` int(15) NOT NULL,
  PRIMARY KEY (`Loan_Type_ID`),
  UNIQUE KEY `Loan_Name` (`Loan_Name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `loan_type`
--

INSERT INTO `loan_type` (`Loan_Type_ID`, `Loan_Name`, `Rate_Of_Interest`, `Minimum_Amount`, `Maximum_Amount`, `Minimum_Tenure`, `Maximum_Tenure`, `Yearly_Income`) VALUES
(1, 'Personal', 17, 100000, 10000000, 8, 96, 150000),
(2, 'Educational', 16, 50000, 500000, 6, 36, 100000),
(3, 'Home', 10, 100000, 20000000, 12, 120, 200000),
(4, 'Car', 11, 100000, 10000000, 6, 36, 150000),
(5, 'Business', 18, 50000, 100000000, 6, 120, 500000);

-- --------------------------------------------------------

--
-- Table structure for table `operator`
--

CREATE TABLE IF NOT EXISTS `operator` (
  `Username` varchar(20) NOT NULL,
  `Operator_ID` int(5) NOT NULL AUTO_INCREMENT,
  `Password` varchar(40) NOT NULL,
  `C_ID` int(10) DEFAULT NULL,
  PRIMARY KEY (`Operator_ID`),
  UNIQUE KEY `Username` (`Username`),
  KEY `C_ID` (`C_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=15 ;

--
-- Dumping data for table `operator`
--

INSERT INTO `operator` (`Username`, `Operator_ID`, `Password`, `C_ID`) VALUES
('Saziya', 2, '123456', NULL),
('Shadab', 3, 'qwerty', NULL),
('Sameer', 10, 'khan', NULL);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `customer_loan`
--
ALTER TABLE `customer_loan`
  ADD CONSTRAINT `customer_loan_ibfk_1` FOREIGN KEY (`C_ID`) REFERENCES `customer` (`C_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `customer_loan_ibfk_2` FOREIGN KEY (`Loan_Type_ID`) REFERENCES `loan_type` (`Loan_Type_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `operator`
--
ALTER TABLE `operator`
  ADD CONSTRAINT `operator_ibfk_1` FOREIGN KEY (`C_ID`) REFERENCES `customer` (`C_ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
