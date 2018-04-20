/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.17-log : Database - hnis
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hnis` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `hnis`;

/*Table structure for table `case` */

DROP TABLE IF EXISTS `case`;

CREATE TABLE `case` (
  `case_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '病例主键',
  `patient_id` int(11) DEFAULT NULL COMMENT '关联病人人（已在数据库）',
  `patient_name` varchar(16) DEFAULT NULL COMMENT '病人名字（未在数据库中）',
  `doctor_id` int(11) DEFAULT NULL COMMENT '关联医生（写病例的人）',
  `disease_id` int(11) DEFAULT NULL COMMENT '疾病id',
  `illness_time` varchar(10) DEFAULT NULL COMMENT '患病时间',
  `illness_grade` varchar(10) DEFAULT NULL COMMENT '患病等级',
  `cure_time` varchar(20) DEFAULT NULL COMMENT '治疗时间',
  `cure_cycle` varchar(10) DEFAULT NULL COMMENT '治疗周期',
  `illness_desc` varchar(1024) DEFAULT NULL COMMENT '病情描述',
  `remark` varchar(1024) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`case_id`),
  KEY `fk_case_patient_id` (`patient_id`),
  KEY `fk_case_disease` (`disease_id`),
  KEY `fk_case_doctor_id` (`doctor_id`),
  CONSTRAINT `fk_case_disease` FOREIGN KEY (`disease_id`) REFERENCES `diseasedetail` (`disease_id`) ON DELETE CASCADE,
  CONSTRAINT `fk_case_doctor_id` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`doctor_id`) ON DELETE NO ACTION,
  CONSTRAINT `fk_case_patient_id` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`) ON DELETE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `case` */

/*Table structure for table `dictionary` */

DROP TABLE IF EXISTS `dictionary`;

CREATE TABLE `dictionary` (
  `dictionary_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '字典主键',
  `data_code` int(11) DEFAULT NULL COMMENT '数据码',
  `data_type` varchar(32) DEFAULT NULL COMMENT '数据类型',
  `data_value` varchar(32) DEFAULT NULL COMMENT '数据值',
  PRIMARY KEY (`dictionary_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `dictionary` */

insert  into `dictionary`(`dictionary_id`,`data_code`,`data_type`,`data_value`) values (1,0,'userType','管理员'),(2,1,'userType','医生'),(3,2,'userType','病人'),(4,3,'userType','游客'),(5,1,'hospDeptType','五官科');

/*Table structure for table `diseasedetail` */

DROP TABLE IF EXISTS `diseasedetail`;

CREATE TABLE `diseasedetail` (
  `disease_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '疾病主键',
  `department_id` varchar(16) DEFAULT NULL COMMENT '所属科室',
  `type_id` varchar(16) DEFAULT NULL COMMENT '所示类型',
  `desease_description` varchar(2048) DEFAULT NULL COMMENT '描述',
  `desease_manifestation` varchar(2048) DEFAULT NULL COMMENT '病发表现',
  `therapeutic_method` varchar(2048) DEFAULT NULL COMMENT '治疗方法',
  `therapeutic_mark` varchar(20) DEFAULT NULL COMMENT '治疗标识（自我治疗、在线治疗、到院治疗）',
  `entry_time` varchar(20) DEFAULT NULL COMMENT '录入时间',
  `entry_person` varchar(20) DEFAULT NULL COMMENT '录入人',
  PRIMARY KEY (`disease_id`),
  KEY `fk_disease_dept_id` (`department_id`),
  KEY `fk_disease_type_id` (`type_id`),
  KEY `fk_disease_user_id` (`entry_person`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `diseasedetail` */

/*Table structure for table `diseasetype` */

DROP TABLE IF EXISTS `diseasetype`;

CREATE TABLE `diseasetype` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `diseasetype` */

/*Table structure for table `doctor` */

DROP TABLE IF EXISTS `doctor`;

CREATE TABLE `doctor` (
  `doctor_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '医生主键',
  `user_id` int(11) DEFAULT NULL COMMENT '关联用户id',
  `doctor_name` varchar(50) DEFAULT NULL COMMENT '医生名',
  `doctor_sex` varchar(4) DEFAULT NULL COMMENT '性别',
  `departement_id` varchar(16) DEFAULT NULL COMMENT '所属科室',
  `doctor_title` varchar(16) DEFAULT NULL COMMENT '医生头衔',
  `doctor_hospital` varchar(50) DEFAULT NULL COMMENT '所属医院',
  `doctor_icon` varchar(100) DEFAULT NULL COMMENT '医生照片',
  PRIMARY KEY (`doctor_id`),
  KEY `fk_doctor_dept_id` (`departement_id`),
  KEY `fk_user_doctor_id` (`user_id`),
  CONSTRAINT `fk_user_doctor_id` FOREIGN KEY (`user_id`) REFERENCES `useraccount` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `doctor` */

insert  into `doctor`(`doctor_id`,`user_id`,`doctor_name`,`doctor_sex`,`departement_id`,`doctor_title`,`doctor_hospital`,`doctor_icon`) values (1,2,'matte','M','全部','教授','人民医院',NULL);

/*Table structure for table `hospotaldepartment` */

DROP TABLE IF EXISTS `hospotaldepartment`;

CREATE TABLE `hospotaldepartment` (
  `department_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '科室主键',
  `department_name` varchar(50) DEFAULT NULL COMMENT '科室名',
  `department_impl` varchar(256) DEFAULT NULL COMMENT '科室描述',
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `hospotaldepartment` */

/*Table structure for table `information` */

DROP TABLE IF EXISTS `information`;

CREATE TABLE `information` (
  `information_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '资讯主键',
  `information_time` varchar(20) DEFAULT NULL COMMENT '上传时间',
  `information_author` varchar(20) DEFAULT NULL COMMENT '上传作者',
  `information_title` varchar(50) DEFAULT NULL COMMENT '资讯标题（50字以内）',
  `information_main` varchar(2048) DEFAULT NULL COMMENT '资讯内容',
  `information_label` varchar(100) DEFAULT NULL COMMENT '资讯标签',
  `entry_porson` int(11) DEFAULT NULL COMMENT '上传人',
  PRIMARY KEY (`information_id`),
  KEY `fk_information_entry_id` (`entry_porson`),
  CONSTRAINT `fk_information_entry_id` FOREIGN KEY (`entry_porson`) REFERENCES `useraccount` (`user_id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `information` */

/*Table structure for table `patient` */

DROP TABLE IF EXISTS `patient`;

CREATE TABLE `patient` (
  `patient_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '病人主键',
  `user_id` int(11) DEFAULT NULL COMMENT '关联用户id',
  `patient_name` varchar(50) DEFAULT NULL COMMENT '病人名字',
  `patient_sex` varchar(2) DEFAULT NULL COMMENT '病人性别',
  `patient_born` varchar(10) DEFAULT NULL COMMENT '病人生日',
  `patient_nation` varchar(10) DEFAULT NULL COMMENT '病人民族',
  `bloodtype` varchar(4) DEFAULT NULL COMMENT '血型',
  `patient_occupation` varchar(20) DEFAULT NULL COMMENT '职业',
  `patient_marriage` varchar(4) DEFAULT NULL COMMENT '婚否',
  `patient_icon` varchar(100) DEFAULT NULL COMMENT '病人图片',
  PRIMARY KEY (`patient_id`),
  KEY `fk_user_id` (`user_id`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `useraccount` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `patient` */

insert  into `patient`(`patient_id`,`user_id`,`patient_name`,`patient_sex`,`patient_born`,`patient_nation`,`bloodtype`,`patient_occupation`,`patient_marriage`,`patient_icon`) values (1,3,'goy','M','1996-06-16','汉族','O','程序猿','未婚',NULL);

/*Table structure for table `useraccount` */

DROP TABLE IF EXISTS `useraccount`;

/*
Navicat MySQL Data Transfer

Source Server         : zhaojiamin
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : hnis

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-04-20 15:56:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for useraccount
-- ----------------------------
DROP TABLE IF EXISTS `useraccount`;

CREATE TABLE `useraccount` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户主键',
  `user_name` varchar(20) NOT NULL COMMENT '用户名称（可做登陆）',
  `user_phone` varchar(20) DEFAULT NULL COMMENT '用户手机号（登陆）',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `user_type` int(11) DEFAULT NULL COMMENT '用户类型（1：管理员 2:医生 3：病人 4：普通用户',
  `account_type` int(11) DEFAULT '1' COMMENT '账户类型（开启/关闭）',
  `creat_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of useraccount
-- ----------------------------
INSERT INTO `useraccount` VALUES ('1', 'admin', 'admin', '1234', '1', '1', '2018-01-01 12:12:12');
INSERT INTO `useraccount` VALUES ('2', 'matte', '18670759820', '1234', '2', '1', '2018-01-01 12:12:12');
INSERT INTO `useraccount` VALUES ('3', 'goy', '18670759821', '1234', '3', '1', '2018-01-01 12:12:12');
INSERT INTO `useraccount` VALUES ('4', 'hisak', '18670679823', '1234', '2', '1', '2018-04-20 15:55:25');


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
