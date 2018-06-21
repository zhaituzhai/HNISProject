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
  `illness_grade` varchar(68) DEFAULT NULL COMMENT '患病等级',
  `cure_time` timestamp NULL DEFAULT NULL COMMENT '治疗时间',
  `cure_cycle` varchar(10) DEFAULT NULL COMMENT '治疗周期',
  `enter_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '录入时间',
  `enter_person` varchar(10) DEFAULT NULL COMMENT '录入人',
  `remark` varchar(1024) DEFAULT NULL COMMENT '备注',
  `medicine_total_price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`case_id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

/*Data for the table `case` */

insert  into `case`(`case_id`,`patient_name`,`doctor_name`,`illness_desc`,`illness_time`,`illness_grade`,`cure_time`,`cure_cycle`,`enter_time`,`enter_person`,`remark`,`medicine_total_price`) values (7,'3-我是傻','庸医','心痛，失恋了，与我无关。','2018-05-01 08:00:00','失恋','2018-05-02 11:38:10','一年','2018-05-04 16:36:40','1',NULL,NULL),(8,'2-god','庸医','咳嗽，咳出血了','2018-05-10 08:00:00','咳嗽','2018-05-02 11:44:19','4天','2018-05-04 16:36:40','1',NULL,NULL),(9,'3-我是傻','庸医','巴拉饿呢','2018-05-01 08:00:00','饿','2018-05-02 11:48:38','7天','2018-05-04 16:36:40','1',NULL,NULL),(10,'4-宅总','庸医','死宅死宅不运动','2018-05-02 08:00:00','不运动','2018-05-02 11:53:04','4天','2018-05-04 16:36:40','1',NULL,NULL),(11,'5-matte','eowbhn','欻额让你','2018-05-03 08:00:00','你','2018-05-02 12:01:46','啥昂你','2018-05-04 16:36:40','1',NULL,NULL),(12,'1-goy','庸医','howsenwosadfwera','2018-05-01 08:00:00','howse','2018-05-02 12:05:14','说我en','2018-05-04 16:36:40','1',NULL,NULL),(13,'5-matte','庸医','哟卡enr','2018-05-02 08:00:00','哟卡','2018-05-02 12:13:12','123','2018-05-04 16:36:40','1',NULL,NULL),(14,'3-我是傻','敏敏','我爱你','2018-05-02 00:00:00','我爱你','2018-05-05 15:22:03','一辈子','2018-05-05 15:22:03','1',NULL,NULL),(15,'7-李帅出','刘医生','老当益壮，没毛病','2018-05-05 00:00:00','没毛病','2018-05-06 13:49:31','50年','2018-05-06 13:49:31','2',NULL,NULL),(16,'8-matte','迷','也和','2018-05-01 00:00:00','也和','2018-05-11 10:15:59','1年','2018-05-11 10:15:59','1',NULL,NULL),(17,'9-我爱狗狗','敏敏','樱花坠','2018-05-01 00:00:00','樱花坠','2018-05-13 17:20:42','三年之约七年','2018-05-13 17:07:00','1',NULL,NULL),(18,'9-我爱狗狗','敏敏','我爱狗狗','2018-05-11 00:00:00','我爱狗狗','2018-05-13 17:20:45','一辈子','2018-05-13 17:13:39','1',NULL,NULL),(19,'9-我爱狗狗','敏敏','我是1号傻瓜','2018-05-10 00:00:00','我是1号傻瓜','2018-05-13 17:20:49','七天','2018-05-13 17:17:37','1',NULL,NULL),(20,'10-','','',NULL,NULL,NULL,'','2018-05-13 22:02:00','1',NULL,NULL),(21,'8-matte','敏','测试例子','2018-05-08 00:00:00','测试例子','2018-05-14 00:00:00','一年','2018-05-14 08:19:15','1',NULL,NULL),(22,'8-matte','敏敏','测试例子2','2018-05-08 00:00:00','测试例子2','2018-05-14 00:00:00','一年','2018-05-14 08:25:15','1',NULL,NULL),(23,'9-我爱狗狗','敏敏','窝是一个兵','2018-05-08 00:00:00','窝是一个兵','2018-05-14 00:00:00','一年','2018-05-14 09:00:41','1',NULL,NULL),(24,'4-宅总','敏敏','不锻炼，肌无力','2018-05-08 00:00:00','不锻炼，肌无力','2018-05-14 00:00:00','一年','2018-05-14 09:24:57','1',NULL,'221.01'),(25,'11-廖承轩','敏敏','睡眠量太多，无精打采。','2018-05-07 00:00:00','睡眠量太多','2018-05-14 00:00:00','3天一个疗程','2018-05-14 22:56:43','1',NULL,'424.38'),(26,'3-我是傻','123','。。。','2018-05-17 00:00:00','卡e','2018-05-18 00:00:00','一年','2018-05-18 23:49:50','1',NULL,'190.77'),(27,'12-goy','面','qqq','2018-05-19 00:00:00','qq','2018-05-24 00:00:00','求','2018-05-19 10:03:00','1',NULL,'600.10'),(28,'4-宅总','matte','123','2018-05-02 00:00:00','123','2018-05-22 00:00:00','uaon','2018-05-21 12:19:34','1',NULL,'61.80'),(29,'4-宅总','matte','天行赤眼是白睛暴发红赤，眵多粘结，常累及双眼，能迅速传染并引起广泛流行\n疏风散热饮子加减，病初起，眼局部症状俱悉，但不严重，全身症状多不明显疏风散邪，兼以清热','2018-05-21 00:00:00','天行赤眼','2018-05-21 00:00:00','1111','2018-05-21 18:45:52','1',NULL,'30.90'),(30,'9-我爱狗狗','matte','经络闭阻型脐风的证候表现是：喷嚏多涕，烦躁啼哭，张口不利，吮乳口松，苦笑面容，项颈强直，或有四肢抽搐，舌淡红，苔薄，指纹紫。\n玉真散加减。','2018-05-21 00:00:00','脐风','2018-05-21 00:00:00','123231','2018-05-21 22:56:06','1',NULL,'30.90'),(31,'11-廖承轩','matte','天行赤眼是白睛暴发红赤，眵多粘结，常累及双眼，能迅速传染并引起广泛流行\n疏风散热饮子加减，病初起，眼局部症状俱悉，但不严重，全身症状多不明显疏风散邪，兼以清热','2018-05-22 00:00:00','天行赤眼','2018-05-22 00:00:00','三周一个疗程','2018-05-22 11:17:57','1',NULL,'30.90'),(32,'4-宅总','matte','天行赤眼是白睛暴发红赤，眵多粘结，常累及双眼，能迅速传染并引起广泛流行\n疏风散热饮子加减，病初起，眼局部症状俱悉，但不严重，全身症状多不明显疏风散邪，兼以清热','2018-05-23 00:00:00','天行赤眼','2018-05-24 00:00:00','12123','2018-05-24 13:45:06','1',NULL,'14.50'),(33,'5-matte','matte','天行赤眼是白睛暴发红赤，眵多粘结，常累及双眼，能迅速传染并引起广泛流行\n疏风散热饮子加减，病初起，眼局部症状俱悉，但不严重，全身症状多不明显疏风散邪，兼以清热','2018-05-26 00:00:00','天行赤眼','2018-05-26 00:00:00','11','2018-05-26 11:11:45','1',NULL,'5.80');

/*Table structure for table `case_medicine_detail` */

DROP TABLE IF EXISTS `case_medicine_detail`;

CREATE TABLE `case_medicine_detail` (
  `case_medicine_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '病例用药详情主键',
  `case_id` int(11) DEFAULT NULL COMMENT '关联病例id',
  `medicine_name` varchar(64) DEFAULT NULL COMMENT '药品名/id',
  `consumption` varchar(64) DEFAULT NULL COMMENT '用量',
  `price` decimal(8,2) DEFAULT NULL COMMENT '单价',
  `total_price` decimal(10,2) DEFAULT NULL COMMENT '总价',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`case_medicine_id`),
  KEY `case_medicine_fk` (`case_id`),
  CONSTRAINT `case_medicine_fk` FOREIGN KEY (`case_id`) REFERENCES `case` (`case_id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

/*Data for the table `case_medicine_detail` */

insert  into `case_medicine_detail`(`case_medicine_id`,`case_id`,`medicine_name`,`consumption`,`price`,`total_price`,`remark`) values (1,12,'六味地黄丸','1盒',NULL,NULL,NULL),(2,12,'苦恋口服液2','1盒',NULL,NULL,NULL),(3,12,'苦恋口服液4','1盒',NULL,NULL,NULL),(4,13,'六味地黄丸','1盒',NULL,NULL,NULL),(5,13,'苦恋口服液2','1盒',NULL,NULL,NULL),(6,14,'苦恋口服液3','12盒',NULL,NULL,NULL),(7,15,'咽喉片','1盒',NULL,NULL,NULL),(8,16,'六味地黄丸','1盒',NULL,NULL,NULL),(9,16,'咽喉片','1盒',NULL,NULL,NULL),(10,16,'咽喉片','1带',NULL,NULL,NULL),(11,17,'测试丸子','1盒',NULL,NULL,NULL),(12,18,'头孢克污片','1盒',NULL,NULL,NULL),(13,19,'测试丸子11','1盒',NULL,NULL,NULL),(14,20,'','e',NULL,NULL,NULL),(15,21,'咽喉片','3undefined',NULL,NULL,NULL),(16,22,'苦情丹','3盒',NULL,NULL,NULL),(17,23,'测试丸子','10盒','12.09','120.90',NULL),(18,24,'苦恋口服液2','1盒','21.01','21.01',NULL),(19,24,'咽喉片','1盒','200.00','200.00',NULL),(20,25,'六味地黄丸','2盒','200.10','400.20',NULL),(21,25,'测试丸子','2盒','12.09','24.18',NULL),(22,26,'头孢克污片','5盒','30.90','154.50',NULL),(23,26,'测试丸子','2袋','12.09','24.18',NULL),(24,26,'测试丸子11','1瓶','12.09','12.09',NULL),(25,27,'六味地黄丸','1盒','200.10','200.10',NULL),(26,27,'咽喉片','2盒','200.00','400.00',NULL),(27,28,'头孢克污片','2盒','30.90','61.80','一天一次，一次一粒'),(28,29,'头孢克污片','1盒','30.90','30.90','一天三次一次一粒'),(29,30,'头孢克污片','1盒','30.90','30.90','一天一包'),(30,31,'头孢克污片','1盒','30.90','30.90','一天三次一次一粒'),(31,32,'叶象花_yexianghua','1盒','1.45','1.45',NULL),(32,32,'杠板归_gangbangui','2盒','1.45','2.90',NULL),(33,32,'羊蹄草_yangticao','3盒','1.45','4.35',NULL),(34,32,'地锦草_dijincao','4盒','1.45','5.80',NULL),(35,33,'叶象花','1克','1.45','1.45',NULL),(36,33,'杠板归','1克','1.45','1.45',NULL),(37,33,'羊蹄草','1克','1.45','1.45',NULL),(38,33,'地锦草','1克','1.45','1.45',NULL);

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
  `disease_medicine` varchar(64) DEFAULT NULL COMMENT '药品单',
  PRIMARY KEY (`disease_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `disease_detail` */

insert  into `disease_detail`(`disease_id`,`department`,`disease_type`,`disease_name`,`desease_description`,`desease_manifestation`,`therapeutic_method`,`therapeutic_mark`,`entry_time`,`entry_person`,`disease_medicine`) values (1,'眼科','白眼疾病','天行赤眼','天行赤眼是白睛暴发红赤，眵多粘结，常累及双眼，能迅速传染并引起广泛流行','初感疠气型天行赤眼的病因病机是：因患者内热不重，外邪初感，故局部之病变较明显，而全身脉症尚无明显异常','疏风散热饮子加减，病初起，眼局部症状俱悉，但不严重，全身症状多不明显疏风散邪，兼以清热','到院治疗','2018-04-20 21:41:15','李生','33-34-35-36'),(2,'眼科','红眼疾病','风轮赤豆','风轮赤豆是因黑睛上有颗粒样小泡突起，且有赤脉追随牵绊，色红如赤小豆之状而得名','本病多因肝经积热，火郁风轮，气血失调，脉络瘀滞所致。或脾虚气弱，痰停气滞，痰气混结，郁于风轮。','本病多因肝经积热，火郁风轮，气血失调，脉络瘀滞所致。或脾虚气弱，痰停气滞，痰气混结，郁于风轮。','到院治疗','2018-04-20 21:41:15','李生','33-34'),(3,'儿科','新生儿病','胎怯','胎怯是指初生儿体重低下，身材矮小，脏腑形气均未充实的一种病证。','五脏亏虚型胎怯的症状是：身材短小，形体瘦弱，精神萎靡，气弱声低，目无神采，皮肤薄嫩，肌肤不温，胎毛细软，面色无华，唇甲淡白，肌肉瘠薄，萎软无力，筋弛肢软，虚里动疾，时有惊惕，吮乳量少，指甲软或短，指纹淡。','本病多因肝经积热，火郁风轮，气血失调，脉络瘀滞所致。或脾虚气弱，痰停气滞，痰气混结，郁于风轮。','到院治疗','2018-04-20 21:41:15','赵生','33-36'),(4,'儿科','新生儿病','脐风','经络闭阻型脐风的证候表现是：喷嚏多涕，烦躁啼哭，张口不利，吮乳口松，苦笑面容，项颈强直，或有四肢抽搐，舌淡红，苔薄，指纹紫。','喷嚏多涕，烦躁啼哭，张口不利，吮乳口松，苦笑面容，项颈强直，或有四肢抽搐，舌淡红，苔薄，指纹紫。','本病多因肝经积热，火郁风轮，气血失调，脉络瘀滞所致。或脾虚气弱，痰停气滞，痰气混结，郁于风轮。','到院治疗','2018-04-20 21:41:15','赵生','33-34-35-36-37');

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `doctor` */

insert  into `doctor`(`doctor_id`,`user_id`,`doctor_name`,`doctor_sex`,`departement_id`,`doctor_title`,`doctor_hospital`,`doctor_icon`) values (1,2,'matte','M','全能型超级医生','教授导师','人民医院',''),(2,4,'老赵','M','脑科','教授','人民医院',NULL),(3,5,'赵嘉敏','M','四肢科','教授','人民医院',NULL);

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
  `medicine_mark` varchar(24) DEFAULT NULL COMMENT '药品简拼',
  `medicine_name` varchar(64) DEFAULT NULL COMMENT '药品名字',
  `main_components` varchar(1024) DEFAULT NULL COMMENT '主要成分',
  `user_range` varchar(512) DEFAULT NULL COMMENT '使用范围',
  `user_way` varchar(512) DEFAULT NULL COMMENT '使用方法',
  `user_attention` varchar(512) DEFAULT NULL COMMENT '注意事项',
  `save_way` varchar(512) DEFAULT NULL COMMENT '贮藏方式',
  `specifications` varchar(512) DEFAULT NULL COMMENT '规格',
  `price` decimal(10,2) DEFAULT NULL COMMENT '单价',
  PRIMARY KEY (`medicine_id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

/*Data for the table `medicine` */

insert  into `medicine`(`medicine_id`,`medicine_mark`,`medicine_name`,`main_components`,`user_range`,`user_way`,`user_attention`,`save_way`,`specifications`,`price`) values (33,NULL,'叶象花_yexianghua','金大戟科植物猩猩草Euphorbia heterophylla L．的干燥全草。银花、黄芩、连翘','凉血调经，散瘀消肿。属止血药下属分类的温经止血药。','内服：煎汤，3～9克，外用：适量，鲜品捣敷。主治月经过多，外伤肿痛，出血，骨折。','尚不明确。','密封、避光、阴凉处','四季均可采收。洗净，鲜用或晒干。','1.45'),(34,NULL,'杠板归_gangbangui','蓼科植物杠板归Polygonum perfoliatum L.的全草。','清热解毒、利咽祛湿。属清热药下属分类的清热解毒药。','用量15～30克，鲜品60～100克；外用适量，捣敷或煎水洗。用治热毒咽喉肿痛、肺热咳嗽、湿热黄疸、水肿、慢性湿疹、瘰疬、疥癣、下肢关节肿痛、淋浊、痢疾等。','具有较强的抗菌、抗病毒作用；对肾性高血压大鼠有抗高血压作用，可显著影响其心肌收缩和血压；具有一定抗诱变作用，对实验动物肿瘤有抑制作用，尚有止血等作用。煎剂对金黄色葡萄球菌、乙型溶血性链球菌及枯草、大肠、宋内氏痢疾、志贺氏痢疾等杆菌有抑制作用。对实验动物肿瘤有抑制作用。','密封、避光、阴凉处','夏季开花时采收，洗净，晒干。生用或鲜用。','1.45'),(35,NULL,'羊蹄草_yangticao','菊科植物一点红Emilia sonchifolia (L.) DC.的全草。','清热解毒、消炎、利尿。属清热药下属分类的清热解毒药。','用量15～30克，煎服；外用适量，鲜品捣烂敷患处。用治上呼吸道感染、咽喉肿痛、口腔溃疡、肺炎、急性肠炎、细菌性痢疾、泌尿系统感染、睾丸炎、乳腺炎、疖肿疮疡、皮肤湿疹、跌打扭伤。','100%煎剂用平板打洞法，对金黄色葡萄球菌、绿脓杆菌、铜绿假单胞菌、伤寒杆菌有抑制作用。其甲醇提取物对艾氏腹水瘤EAC、小鼠成纤维细胞株L929有细胞毒性，并能抑制肿瘤的增长，延长小鼠存活时间和抑制DNA合成。','密封、避光、阴凉处','夏、秋季采收，洗净，晒干，或趁鲜切段，晒干。','1.45'),(36,NULL,'地锦草_dijincao','大戟科植物地锦Euphorbia humifusa Willd,或斑地锦EuphorbiamaculataL.的全草。','清热解毒、凉血止血。属清热药下属分类的清热解毒药。','用量9～20克，水煎服或入散剂，鲜品30~60克；外用捣敷或研末撒。用治痢疾、肠炎、咯血、尿血、便血、崩漏、疮疖痈肿。具有抑菌、止血和中和毒素等作用。','有抗菌和抗寄生虫及解毒作用；止血效果明显。','密封、避光、阴凉处','夏、秋季采全草，洗净，晒干。','1.45'),(37,NULL,'地耳草_diercao','藤黄科植物地耳草Hypericum japonicum Thunb.ex Murray的干燥全草。','清热利湿，解毒，散瘀消肿，止痛。属清热药下属分类的清热燥湿药。','内服：煎汤，15～30克，鲜品30～60克，大剂可用至90～120克；或捣汁。外用：适量，捣烂外敷，或煎水洗。主治湿热黄疸，泄泻，痢疾，肠痈，肺痈，痈疖肿毒，乳蛾，口疮，目赤肿痛，毒蛇咬伤，跌打损伤。','有抗菌作用；对在体和离体蟾蜍心脏有先兴奋后抑制的作用，剂量过大可致心脏纤颤而使心跳停止；对麻醉犬有一定降压作用；能加强离体兔肠收缩，浓度过高可致痉挛，与乙酰胆碱有协同作用。','密封、避光、阴凉处','春、夏季开花时采收全草，晒干或鲜用。','1.45'),(38,NULL,'连钱草_lianqiancao','唇形科植物活血丹Glechoma longituba (Nakai) Kupr.的全草。','利湿通淋、清热解毒、散瘀消肿。属利水渗湿药下属分类的利尿通淋药。','用量15～30克，鲜品30～60克；外用适量，捣敷。用治血瘀腹痛、跌打损伤、水肿、小便不利、湿热黄疸、带下、痈肿疮毒、毒蛇咬伤等。','本品具有利尿、利胆、抗溃疡、溶解结石等作用；还有抑菌作用，对金黄色葡萄球菌及伤寒、福氏痢疾、宋氏痢疾、绿脓杆菌等均有抑制作用。','null','春、秋季采收，洗净，晒干。生用或鲜用。','1.56'),(39,NULL,'虎耳草_huercao','虎耳草科植物虎耳草Saxifraga stolonifera Meerb.的全草。','祛风、清热、清血解毒。属清热药下属分类的清热凉血药。','用量10～15克，煎汤内服；外用适量，煎水洗；鲜用捣敷；或绞汁滴耳及涂布。用治风疹、湿疹、中耳炎、丹毒、咳嗽吐血、肺痈、崩漏、痔疾。','对变形杆菌、伤寒杆菌、痢疾杆菌、金黄色葡萄球菌、绿脓杆菌有不同程度抑制作用。具有强心、利尿作用；对葡萄球菌和链球菌体外实验未发现抑制作用。','密封、避光、阴凉处','夏季割取地上部分，鲜用或晒干。','1.76'),(40,NULL,'伸筋草_shenjincao','石松科植物石松Lycopodium clavatum L.的带根全草。','性温，味微苦、辛。归肝经、脾经、肾经。','祛风寒、除湿消肿、舒筋活络。属祛风湿药下分类的祛风湿强筋骨药。','用于风寒湿痹、关节酸痛、皮肤麻木、四肢软弱、水肿、跌打损伤。煎汤内服，用量3～12克。外用适量，捣敷患处。','密封、避光、阴凉处','夏、秋季茎叶繁茂时连根拔起，除去泥土、杂质，晒干。','1.96'),(41,NULL,'老鹳草_laoguancao','牻牛儿苗科科植物栊牛儿苗Erodium. stephania-num Willd.、老鹳草Geranium wil ordii Maxim.或野老颧草Geranium carolinianum L.的全草。','null','祛风湿，通经络，止泻痢。属祛风湿药下属分类的祛风湿强筋骨药。','用量9～15克，水煎服。临床常用于治疗风湿痹痛、麻木拘挛、筋骨酸痛、泄泻痢疾等症。药理实验表明：老颧草具有抗菌、抗病毒、抗炎、抗肝损伤等作用。此外，尚有止咳、抗氧化、抗诱变及杀伤癌细胞等药理作用。','密封、避光、阴凉处','夏、秋季茎叶繁茂时连根拔起，除去泥土、杂质，晒干。','2.16'),(42,NULL,'白花丹_baihuadan','白花丹科植物白花丹Plumbago zeyla-nicaL．的干燥全草或根。','性温，味辛、苦、涩。有毒。归经无。','祛风除湿，行气活血，解毒消肿。属活血化瘀药下属分类的活血止痛药。','内服：煎汤，9～15克。外用：适量，煎水洗；或捣敷；或涂擦。主治风湿痹痛，心胃气痛，肝脾肿大，血瘀经闭，跌打扭伤，痈肿瘰疬，疥癣瘙痒，毒蛇咬伤。','密封、避光、阴凉处','夏、秋季茎叶繁茂时连根拔起，除去泥土、杂质，晒干。','2.36');

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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `patient` */

insert  into `patient`(`patient_id`,`user_id`,`patient_name`,`patient_sex`,`patient_born`,`patient_nation`,`bloodtype`,`patient_occupation`,`patient_marriage`,`patient_icon`) values (1,3,'goy','M','17','猛汉族','B','程序猿','marry',''),(2,7,'god','M','18','汉族','AB','人','single',NULL),(3,NULL,'我是傻','M','19',NULL,NULL,NULL,NULL,NULL),(4,NULL,'宅总','M','37',NULL,NULL,NULL,NULL,NULL),(5,NULL,'matte','M','123',NULL,NULL,NULL,NULL,NULL),(6,NULL,'狗狗','M','22',NULL,NULL,NULL,NULL,NULL),(7,NULL,'李帅出','M','65',NULL,NULL,NULL,NULL,NULL),(8,NULL,'matte','F','31',NULL,NULL,NULL,NULL,NULL),(9,NULL,'我爱狗狗','M','21',NULL,NULL,NULL,NULL,NULL),(10,NULL,'','M','',NULL,NULL,NULL,NULL,NULL),(11,NULL,'廖承轩','M','21',NULL,NULL,NULL,NULL,NULL),(12,NULL,'goy','M','12',NULL,NULL,NULL,NULL,NULL);

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
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

/*Data for the table `useraccount` */

insert  into `useraccount`(`user_id`,`user_name`,`user_phone`,`password`,`user_type`,`account_type`,`creat_time`) values (1,'admin','admin','1234','1',1,'2018-04-20 21:41:15'),(2,'doctor','doctor','1234','2',1,'2018-04-20 21:41:15'),(3,'patient','patient','1234','3',2,'2018-04-20 21:41:15'),(4,'matte','18670679823','1234','2',1,'2018-04-20 15:55:25'),(5,'我是医生','15654958491','1234','2',1,'2018-04-25 15:51:37'),(6,'gaga','12548889607','1234','2',1,'2018-04-25 15:51:59'),(7,'asdwe','12549878455','1234','3',1,'2018-04-25 15:52:16'),(8,'adf','21312345678','1234','3',1,'2018-04-25 15:52:34'),(9,'sad','12458796521','1234','3',2,'2018-04-25 15:52:53'),(10,'terw','12556988871','1234','3',1,'2018-04-25 15:53:09'),(11,'geqss','12358974611','1234','3',2,'2018-04-25 15:53:30'),(12,'test','12345879641','1234','2',1,'2018-04-25 20:37:04'),(13,'test','12345879641','1234','2',1,'2018-04-25 20:37:00'),(14,'test','12345879641','1234','2',1,'2018-04-25 20:36:10'),(15,'test','12345879641','1234','2',1,'2018-04-25 20:36:11'),(16,'test','12345879641','1234','2',1,'2018-04-25 21:50:39'),(17,'test','12345879641','1234','2',1,'2018-04-25 21:50:39'),(18,'yoga','12345678911','1234','1',2,'2018-04-26 07:57:15'),(19,'yoga','12345678911','1234','3',1,'2018-04-26 07:57:15'),(20,'ryeo','12345678912','1234','3',2,'2018-04-26 07:58:53'),(21,'yeow','12345678913','1234','1',2,'2018-04-26 08:06:25'),(22,'yiiwi','12345678914','1234','2',1,'2018-04-26 08:07:08'),(23,'uane','45789513246','1234','2',1,'2018-04-26 08:14:58'),(24,'我的中文名','12345678915','1234','2',2,'2018-04-26 08:16:25'),(25,'aeont','12345678916','4321','1',1,'2018-04-26 08:18:31'),(26,'minmin','12549878455','123456','2',1,'2018-05-11 10:06:27'),(27,'测试用例','12345678901','1234','2',1,'2018-05-14 19:36:43');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
