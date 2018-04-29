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
  `patient_name` varchar(50) DEFAULT NULL COMMENT '病人名字（未在数据库中）',
  `doctor_name` varchar(50) DEFAULT NULL COMMENT '主治医生',
  `illness_desc` varchar(1024) DEFAULT NULL COMMENT '病情描述',
  `illness_time` timestamp NULL DEFAULT NULL COMMENT '患病时间',
  `illness_grade` varchar(10) DEFAULT NULL COMMENT '患病等级',
  `cure_time` timestamp NULL DEFAULT NULL COMMENT '治疗时间',
  `cure_cycle` varchar(10) DEFAULT NULL COMMENT '治疗周期',
  `remark` varchar(1024) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`case_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `case` */

/*Table structure for table `case_medicine_detail` */

DROP TABLE IF EXISTS `case_medicine_detail`;

CREATE TABLE `case_medicine_detail` (
  `case_medicine_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '病例用药详情主键',
  `case_id` int(11) DEFAULT NULL COMMENT '关联病例id',
  `medicine_name` varchar(64) DEFAULT NULL COMMENT '药品名/id',
  `consumption` varchar(64) DEFAULT NULL COMMENT '用量',
  `price` double DEFAULT NULL COMMENT '单价',
  `total_price` double DEFAULT NULL COMMENT '总价',
  PRIMARY KEY (`case_medicine_id`),
  KEY `case_medicine_fk` (`case_id`),
  CONSTRAINT `case_medicine_fk` FOREIGN KEY (`case_id`) REFERENCES `case` (`case_id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `case_medicine_detail` */

/*Table structure for table `dictionary` */

DROP TABLE IF EXISTS `dictionary`;

CREATE TABLE `dictionary` (
  `dictionary_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '字典主键',
  `data_code` int(11) DEFAULT NULL COMMENT '数据码',
  `data_type` varchar(32) DEFAULT NULL COMMENT '数据类型',
  `data_value` varchar(32) DEFAULT NULL COMMENT '数据值',
  PRIMARY KEY (`dictionary_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `dictionary` */

insert  into `dictionary`(`dictionary_id`,`data_code`,`data_type`,`data_value`) values (1,1,'userType','管理员'),(2,2,'userType','医生'),(3,3,'userType','病人'),(4,4,'userType','游客'),(5,1,'hospDeptType','五官科'),(6,2,'hospDeptType','内科'),(7,3,'hospDeptType','外科'),(8,4,'hospDeptType','皮肤科'),(9,5,'hospDeptType','科科');

/*Table structure for table `disease_detail` */

DROP TABLE IF EXISTS `disease_detail`;

CREATE TABLE `disease_detail` (
  `disease_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '疾病主键',
  `department` varchar(64) DEFAULT NULL COMMENT '所属科室',
  `disease_type` varchar(64) DEFAULT NULL COMMENT '所示类型',
  `disease_name` varchar(64) DEFAULT NULL COMMENT '疾病名称',
  `desease_description` varchar(2048) DEFAULT NULL COMMENT '描述',
  `desease_manifestation` varchar(2048) DEFAULT NULL COMMENT '病发表现',
  `therapeutic_method` varchar(2048) DEFAULT NULL COMMENT '治疗方法',
  `therapeutic_mark` varchar(20) DEFAULT NULL COMMENT '治疗标识（自我治疗、在线治疗、到院治疗）',
  `entry_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '录入时间',
  `entry_person` varchar(20) DEFAULT NULL COMMENT '录入人',
  PRIMARY KEY (`disease_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `disease_detail` */

insert  into `disease_detail`(`disease_id`,`department`,`disease_type`,`disease_name`,`desease_description`,`desease_manifestation`,`therapeutic_method`,`therapeutic_mark`,`entry_time`,`entry_person`) values (1,'眼科','白眼疾病','天行赤眼','天行赤眼是白睛暴发红赤，眵多粘结，常累及双眼，能迅速传染并引起广泛流行','初感疠气型天行赤眼的病因病机是：因患者内热不重，外邪初感，故局部之病变较明显，而全身脉症尚无明显异常','疏风散热饮子加减，病初起，眼局部症状俱悉，但不严重，全身症状多不明显疏风散邪，兼以清热','到院治疗','2018-04-20 21:41:15','李生'),(2,'眼科','红眼疾病','风轮赤豆','风轮赤豆是因黑睛上有颗粒样小泡突起，且有赤脉追随牵绊，色红如赤小豆之状而得名','本病多因肝经积热，火郁风轮，气血失调，脉络瘀滞所致。或脾虚气弱，痰停气滞，痰气混结，郁于风轮。','本病多因肝经积热，火郁风轮，气血失调，脉络瘀滞所致。或脾虚气弱，痰停气滞，痰气混结，郁于风轮。','到院治疗','2018-04-20 21:41:15','李生'),(3,'儿科','新生儿病','胎怯','胎怯是指初生儿体重低下，身材矮小，脏腑形气均未充实的一种病证。','五脏亏虚型胎怯的症状是：身材短小，形体瘦弱，精神萎靡，气弱声低，目无神采，皮肤薄嫩，肌肤不温，胎毛细软，面色无华，唇甲淡白，肌肉瘠薄，萎软无力，筋弛肢软，虚里动疾，时有惊惕，吮乳量少，指甲软或短，指纹淡。','健脾益肾，培元补虚。','到院治疗','2018-04-20 21:41:15','赵生'),(4,'儿科','新生儿病','脐风','经络闭阻型脐风的证候表现是：喷嚏多涕，烦躁啼哭，张口不利，吮乳口松，苦笑面容，项颈强直，或有四肢抽搐，舌淡红，苔薄，指纹紫。','喷嚏多涕，烦躁啼哭，张口不利，吮乳口松，苦笑面容，项颈强直，或有四肢抽搐，舌淡红，苔薄，指纹紫。','玉真散加减。','到院治疗','2018-04-20 21:41:15','赵生');

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

insert  into `doctor`(`doctor_id`,`user_id`,`doctor_name`,`doctor_sex`,`departement_id`,`doctor_title`,`doctor_hospital`,`doctor_icon`) values (1,2,'matte','M','全能型超级医生','教授导师','人民医院','');

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

/*Table structure for table `medicine` */

DROP TABLE IF EXISTS `medicine`;

CREATE TABLE `medicine` (
  `medicine_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '药品id',
  `medicine_name` varchar(64) DEFAULT NULL COMMENT '药品名字',
  `main_components` varchar(1024) DEFAULT NULL COMMENT '主要成分',
  `user_range` varchar(128) DEFAULT NULL COMMENT '使用范围',
  `user_way` varchar(64) DEFAULT NULL COMMENT '使用方法',
  `user_attention` varchar(128) DEFAULT NULL COMMENT '注意事项',
  `save_way` varchar(128) DEFAULT NULL COMMENT '贮藏方式',
  `specifications` varchar(128) DEFAULT NULL COMMENT '规格',
  `price` double DEFAULT NULL COMMENT '单价',
  PRIMARY KEY (`medicine_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `medicine` */

insert  into `medicine`(`medicine_id`,`medicine_name`,`main_components`,`user_range`,`user_way`,`user_attention`,`save_way`,`specifications`,`price`) values (1,'阿莫西林','玄参、百部、天冬、牡丹皮等','感冒、发烧','口服','孕妇忌口','常温下','10片一版，一盒两版',20),(2,'六味地黄丸','黄连、连翘、哈西草、狗尾巴草','肾亏','口服','正常人不必服用','阴凉处储存','100粒/一瓶',200),(3,'咽喉片','地黄、板蓝根、青果','喉咙痛','口服','过敏者不可复用','干燥处','20片一版，一盒两版',200),(4,'头孢克污片','头孢克污、乳糖、蔗糖','肺炎球菌','口服','感觉恶心者不服用','遮光、密封','18片/版*1版/盒',30.9);

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
  `patient_marriage` varchar(10) DEFAULT NULL COMMENT '婚否',
  `patient_icon` varchar(100) DEFAULT NULL COMMENT '病人图片',
  PRIMARY KEY (`patient_id`),
  KEY `fk_user_id` (`user_id`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `useraccount` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `patient` */

insert  into `patient`(`patient_id`,`user_id`,`patient_name`,`patient_sex`,`patient_born`,`patient_nation`,`bloodtype`,`patient_occupation`,`patient_marriage`,`patient_icon`) values (1,3,'goy','M','undefined','猛汉族','B','程序猿','marry','');

/*Table structure for table `useraccount` */

DROP TABLE IF EXISTS `useraccount`;

CREATE TABLE `useraccount` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户主键',
  `user_name` varchar(20) NOT NULL COMMENT '用户名称（可做登陆）',
  `user_phone` varchar(20) DEFAULT NULL COMMENT '用户手机号（登陆）',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `user_type` varchar(11) DEFAULT NULL COMMENT '用户类型（1：管理员 2:医生 3：病人 4：普通用户',
  `account_type` int(11) DEFAULT '1' COMMENT '账户类型（开启/关闭）',
  `creat_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

/*Data for the table `useraccount` */

insert  into `useraccount`(`user_id`,`user_name`,`user_phone`,`password`,`user_type`,`account_type`,`creat_time`) values (1,'admin','admin','1234','1',1,'2018-04-20 21:41:15'),(2,'matte','18670759820','1234','2',1,'2018-04-20 21:41:15'),(3,'你爱我吗','18670759821','1234','3',2,'2018-04-20 21:41:15'),(4,'hisak','18670679823','1234','2',1,'2018-04-20 15:55:25'),(5,'我是医生','15654958491','1234','2',1,'2018-04-25 15:51:37'),(6,'dawfq','12548889607','1234','2',1,'2018-04-25 15:51:59'),(7,'asdwe','12549878455','1234','3',1,'2018-04-25 15:52:16'),(8,'adf','21312345678','1234','3',1,'2018-04-25 15:52:34'),(9,'sad','12458796521','1234','3',2,'2018-04-25 15:52:53'),(10,'terw','12556988871','1234','3',1,'2018-04-25 15:53:09'),(11,'geqss','12358974611','1234','3',2,'2018-04-25 15:53:30'),(12,'test','12345879641','1234','2',1,'2018-04-25 20:37:04'),(13,'test','12345879641','1234','2',1,'2018-04-25 20:37:00'),(14,'test','12345879641','1234','2',1,'2018-04-25 20:36:10'),(15,'test','12345879641','1234','2',1,'2018-04-25 20:36:11'),(16,'test','12345879641','1234','2',1,'2018-04-25 21:50:39'),(17,'test','12345879641','1234','2',1,'2018-04-25 21:50:39'),(18,'yoga','12345678911','1234','1',2,'2018-04-26 07:57:15'),(19,'yoga','12345678911','1234','3',1,'2018-04-26 07:57:15'),(20,'ryeo','12345678912','1234','3',2,'2018-04-26 07:58:53'),(21,'yeow','12345678913','1234','1',2,'2018-04-26 08:06:25'),(22,'yiiwi','12345678914','1234','2',1,'2018-04-26 08:07:08'),(23,'uane','45789513246','1234','2',1,'2018-04-26 08:14:58'),(24,'我的中文名','12345678915','1234','2',2,'2018-04-26 08:16:25'),(25,'aeont','12345678916','4321','1',1,'2018-04-26 08:18:31');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
