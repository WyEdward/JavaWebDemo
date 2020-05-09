/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.40 : Database - bookplatform
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bookplatform` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bookplatform`;

/*Table structure for table `books` */

DROP TABLE IF EXISTS `books`;

CREATE TABLE `books` (
  `book_id` int(8) NOT NULL AUTO_INCREMENT COMMENT '书本id',
  `book_name` varchar(45) DEFAULT NULL COMMENT '书名',
  `book_writer` varchar(24) DEFAULT NULL COMMENT '书的作者',
  `book_press` varchar(45) DEFAULT NULL COMMENT '出版社',
  `book_remakes` varchar(150) DEFAULT NULL COMMENT '捐者备注',
  `book_date` datetime DEFAULT NULL COMMENT '捐书的日期',
  `user_id` int(6) DEFAULT NULL COMMENT '捐书人的id',
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `books` */

insert  into `books`(`book_id`,`book_name`,`book_writer`,`book_press`,`book_remakes`,`book_date`,`user_id`) values (1,'测试书','测试作者','测试出版社','测试',NULL,1),(3,'测试书2','测试作者','测试出版社','测试2','2019-10-17 00:00:00',1),(4,'测试书3','测试作者','测试出版社','测试3','2019-10-17 20:54:34',1),(5,'测试书4','测试作者4','测试出版社4','测试4','2019-10-17 22:18:49',2),(6,'朝花夕拾','鲁迅','西冷印社','无','2019-10-21 08:15:11',7),(7,'毛泽东守则','列宁托尔斯泰','娃哈哈出版社','我爱你','2019-10-27 19:25:28',9),(9,'Android移动应用开发','黑吗程序员','中国铁道出版社','多学学编程','2019-10-27 19:26:55',9),(10,'测试捐书','鲁迅','测试出版社','测试捐书','2019-10-27 20:10:07',2),(11,'日害扯呼','刘先生','西不冷印社','图一乐','2019-10-27 21:59:26',11),(12,'书1','作者1','出版社1','备注1','2019-10-27 23:01:20',2),(13,'书4','作者4','出版社4','备注4','2019-10-27 23:16:58',2),(14,'测试书5','测试作者5','测试出版社5','测试5','2019-10-27 23:33:13',2),(15,'测试书','测试作者','测试出版社','无','2019-10-28 08:21:52',12),(16,'测试书2','测试作者2','测试出版社2','测试备注2','2019-10-28 08:29:15',12),(17,'《呐喊》','鲁迅','xxx出版社','','2019-11-03 20:26:16',14),(18,NULL,NULL,NULL,NULL,'2019-11-03 20:26:24',14),(19,'《呐喊》','鲁迅','xxx出版社','','2019-11-03 20:26:49',14),(20,'测试1','测试','测试','测试','2019-12-16 09:26:22',2),(21,'我是金未央','鲁迅','xxx','xxx','2019-12-16 09:26:32',17);

/*Table structure for table `donation_orders` */

DROP TABLE IF EXISTS `donation_orders`;

CREATE TABLE `donation_orders` (
  `donation_id` int(8) NOT NULL AUTO_INCREMENT COMMENT '捐单id',
  `user_id1` int(24) DEFAULT NULL COMMENT '捐书的人(查一下是不是基金会用户)',
  `user_id2` int(24) DEFAULT NULL COMMENT '收书的人(查一下是不是基金会用户)',
  `donation_date` date DEFAULT NULL COMMENT '捐款日期',
  `donation_remarks` varchar(90) DEFAULT NULL COMMENT '订单捐赠备注',
  `book_id` int(8) DEFAULT NULL COMMENT '书的id',
  PRIMARY KEY (`donation_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `donation_orders` */

insert  into `donation_orders`(`donation_id`,`user_id1`,`user_id2`,`donation_date`,`donation_remarks`,`book_id`) values (1,2,1,'2019-10-17','测试4',5),(2,7,1,'2019-10-21','无',6),(3,9,1,'2019-10-27','我爱你',7),(4,9,1,'2019-10-27','多学学编程',9),(5,2,1,'2019-10-27','测试捐书',10),(6,11,1,'2019-10-27','图一乐',11),(7,2,1,'2019-10-27','备注1',12),(8,2,1,'2019-10-27','备注4',13),(9,2,1,'2019-10-27','测试5',14),(10,12,1,'2019-10-28','无',15),(11,12,1,'2019-10-28','测试备注2',16),(12,2,1,'2019-12-16','测试',20),(13,17,1,'2019-12-16','xxx',21);

/*Table structure for table `instiutions` */

DROP TABLE IF EXISTS `instiutions`;

CREATE TABLE `instiutions` (
  `instiution_id` int(8) NOT NULL AUTO_INCREMENT COMMENT '基金会id',
  `instiutions_name` varchar(45) NOT NULL COMMENT '基金会名称',
  `instiution_address` varchar(75) DEFAULT NULL COMMENT '基金会地址',
  `instiution_email` varchar(45) DEFAULT NULL COMMENT '基金会邮箱',
  `instiution_number` varchar(11) DEFAULT NULL COMMENT '基金会电话',
  `instiution_linkman` varchar(45) DEFAULT NULL COMMENT '基金会联系人',
  `instiution_donate` int(11) DEFAULT '0' COMMENT '基金会捐赠数量',
  `instiution_actingdonate` int(11) DEFAULT '0' COMMENT '基金会代理捐赠数量',
  PRIMARY KEY (`instiution_id`,`instiutions_name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `instiutions` */

insert  into `instiutions`(`instiution_id`,`instiutions_name`,`instiution_address`,`instiution_email`,`instiution_number`,`instiution_linkman`,`instiution_donate`,`instiution_actingdonate`) values (1,'测试基金会','基金会测试地址','测试邮箱','测试电话','测试联系人',0,0),(2,'测试名称','测试地址','测试邮箱','测试电话','测试联系人',0,0),(3,'测试','测试','测试','测试','测试',0,0);

/*Table structure for table `instiutions_user` */

DROP TABLE IF EXISTS `instiutions_user`;

CREATE TABLE `instiutions_user` (
  `user_id` int(9) NOT NULL COMMENT '代表基金会的人id',
  `instiution_id` int(45) NOT NULL COMMENT '基金会id',
  PRIMARY KEY (`user_id`,`instiution_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `instiutions_user` */

insert  into `instiutions_user`(`user_id`,`instiution_id`) values (1,1),(2,3),(12,2);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int(6) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_nick` varchar(24) DEFAULT NULL COMMENT '用户昵称',
  `user_password` varchar(45) DEFAULT NULL COMMENT '用户密码',
  `user_phone` varchar(12) DEFAULT NULL COMMENT '用户电话',
  `create_time` datetime DEFAULT NULL COMMENT '用户创建时间',
  `user_email` varchar(45) NOT NULL COMMENT '用户邮箱',
  `isinstiutions` int(11) NOT NULL DEFAULT '0' COMMENT '是不是基金会用户',
  `user_donations` int(6) DEFAULT '0' COMMENT '用户捐书数量',
  `user_bedonations` int(6) NOT NULL DEFAULT '0' COMMENT '被捐赠数量',
  PRIMARY KEY (`user_id`,`user_email`,`user_bedonations`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`user_id`,`user_nick`,`user_password`,`user_phone`,`create_time`,`user_email`,`isinstiutions`,`user_donations`,`user_bedonations`) values (1,'基金会用户','123456','基金会电话','2019-10-17 20:01:38','111',1,3,0),(2,'普通用户','123456','普通电话',NULL,'222',3,6,0),(3,'我爱罗','123456','112132','2019-10-19 15:28:12','123456',0,0,0),(4,'罗','123456','132465','2019-10-19 16:04:51','444',0,0,0),(6,'123','123','123','2019-10-21 08:10:48','123@qq.com',0,0,0),(7,'我爱你','123456789','123456789','2019-10-21 08:10:50','123456789',0,1,0),(8,'skrskr','111','1111','2019-10-21 08:14:20','222222',0,0,0),(9,'我好帅','1590330','18888688682','2019-10-27 19:22:53','2499906063',0,3,0),(10,'jjj','999gml','999gml','2019-10-27 19:31:05','999gml',0,0,0),(11,'刘学军先生','062511','18888689111','2019-10-27 21:55:52','88347895@qq.com',0,1,0),(12,'项目经理','123456','18888685862','2019-10-28 08:20:53','1240561342@qq.com',2,2,0),(13,'abc','123','14789365214','2019-11-03 20:13:07','15615',0,0,0),(16,'mqw','123','14785236914','2019-11-03 20:59:27','147',0,0,0),(17,'我是金未央','123','1233','2019-12-16 09:18:47','123',0,1,0),(18,'xina','123456','188886852565','2019-12-16 09:24:07','1240561342@qq.com',0,0,0),(19,'12412','123456','188886852565','2019-12-16 09:24:50','1240561342@qq.com',0,0,0),(20,'1234','1234','1234','2019-12-16 09:27:57','1234',0,0,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
