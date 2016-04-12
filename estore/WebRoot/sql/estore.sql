/*
MySQL Data Transfer
Source Host: localhost
Source Database: estore
Target Host: localhost
Target Database: estore
Date: 2014-4-16 22:21:29
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for book
-- ----------------------------
CREATE TABLE `book` (
  `bid` char(32) NOT NULL,
  `bname` varchar(100) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `author` varchar(50) DEFAULT NULL,
  `image` varchar(200) DEFAULT NULL,
  `cid` char(32) DEFAULT NULL,
  `isdel` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`bid`),
  KEY `cid` (`cid`),
  CONSTRAINT `book_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for category
-- ----------------------------
CREATE TABLE `category` (
  `cid` char(32) NOT NULL,
  `cname` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
CREATE TABLE `orderitem` (
  `itemid` char(32) NOT NULL,
  `count` int(11) DEFAULT NULL,
  `subtotal` decimal(10,2) DEFAULT NULL,
  `bid` char(32) DEFAULT NULL,
  `oid` char(32) DEFAULT NULL,
  PRIMARY KEY (`itemid`),
  KEY `bid` (`bid`),
  KEY `oid` (`oid`),
  CONSTRAINT `orderitem_ibfk_1` FOREIGN KEY (`bid`) REFERENCES `book` (`bid`),
  CONSTRAINT `orderitem_ibfk_2` FOREIGN KEY (`oid`) REFERENCES `orders` (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
CREATE TABLE `orders` (
  `oid` char(32) NOT NULL,
  `total` decimal(10,2) DEFAULT NULL,
  `ordertime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `state` int(11) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `uid` char(32) DEFAULT NULL,
  PRIMARY KEY (`oid`),
  KEY `uid` (`uid`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
CREATE TABLE `user` (
  `uid` char(32) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `state` tinyint(1) DEFAULT NULL,
  `code` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `book` VALUES ('001', '封神榜', '50.00', '姜子牙', 'book_img/xh1.jpg', '1', '0');
INSERT INTO `book` VALUES ('002', '剑逆苍穹', '40.00', '大法官', 'book_img/xh2.jpg', '1', '0');
INSERT INTO `book` VALUES ('003', '薄环凉色', '28.00', '甄嬛', 'book_img/yq1.jpg', '2', '0');
INSERT INTO `book` VALUES ('004', '旋风侠盗', '61.00', '阿园', 'book_img/wx1.jpg', '5', '0');
INSERT INTO `book` VALUES ('005', '你懂我的爱', '73.00', '莫言', 'book_img/yq2.jpg', '2', '0');
INSERT INTO `book` VALUES ('006', '东归喋血', '48.00', '张瑞峰', 'book_img/wx2.jpg', '5', '0');
INSERT INTO `book` VALUES ('007', '守夜', '62.00', '斯蒂芬金', 'book_img/kb1.jpg', '4', '0');
INSERT INTO `book` VALUES ('008', '日本恐怖小说选', '39.00', '村山魁多', 'book_img/kb2.jpg', '4', '0');
INSERT INTO `book` VALUES ('009', 'Java培训就业教程', '58.00', '张孝祥', 'book_img/kj1.jpg', '6', '0');
INSERT INTO `book` VALUES ('010', '精通Hibernate', '67.00', '孙鑫', 'book_img/kj2.jpg', '6', '0');
INSERT INTO `book` VALUES ('011', 'Java编程思想', '108.00', 'James', 'book_img/kj4.jpg', '6', '0');
INSERT INTO `book` VALUES ('012', 'Struts2详解', '42.00', '涛哥', 'book_img/kj8.jpg', '6', '0');
INSERT INTO `book` VALUES ('013', 'JavaWeb开发详解', '32.00' '涛哥', 'book_img/kj5.jpg', '6', '0');
INSERT INTO `category` VALUES ('1', '玄幻');
INSERT INTO `category` VALUES ('2', '言情');
INSERT INTO `category` VALUES ('4', '恐怖');
INSERT INTO `category` VALUES ('5', '武侠');
INSERT INTO `category` VALUES ('6', '科技');
INSERT INTO `category` VALUES ('ef32d6d638084c2ba47df91b740637aa', 'JAVAEE');
INSERT INTO `orderitem` VALUES ('0bcab422f4ad40c7bc9823d8d829709f', '1', '48.00', '006', 'c14535eb78f34895a04dd11ea884a326');
INSERT INTO `orderitem` VALUES ('0cd3d5c23040472c9fe1d23faa1997e2', '1', '67.00', '010', 'b82b9d4de1fd4232ab440dab99827dd7');
INSERT INTO `orderitem` VALUES ('1e63e9db57ef4e00ba2de0e2810b25c0', '1', '62.00', '007', 'a46d724c5d0d439786eb1d28f5fcc69c');
INSERT INTO `orderitem` VALUES ('21789102cbc34ed9a0aca01bd045db49', '1', '28.00', '003', 'c14535eb78f34895a04dd11ea884a326');
INSERT INTO `orderitem` VALUES ('483c8d7174874e1da3748f7de8cf394e', '1', '50.00', '001', '7cb89cd3915744d3b2efd9af1eac5f56');
INSERT INTO `orderitem` VALUES ('5f845a881b664b1c8cf6df831eabe4a5', '1', '73.00', '005', 'ceb80d1050d54699a7bb2683db9ebd9c');
INSERT INTO `orderitem` VALUES ('60278654ed474058a050d3f8774834dc', '1', '58.00', '009', 'a46d724c5d0d439786eb1d28f5fcc69c');
INSERT INTO `orderitem` VALUES ('6998d7c0293244029866524b345e33cc', '1', '50.00', '001', 'ce9e9c066d954aed9b7150591e2849a7');
INSERT INTO `orderitem` VALUES ('6d403bec468040aea1d4c4af8c493d87', '1', '73.00', '005', 'df3725fd837a4414ae2857e865451d49');
INSERT INTO `orderitem` VALUES ('73e4db98860142b78e1a7c175f849c00', '1', '42.00', '1b629ce80992407b96987595eb2300d9', '21d247ae13cf4140a285ce27c82664aa');
INSERT INTO `orderitem` VALUES ('78b9df34d5f74c16b6473948adfbc88d', '1', '48.00', '006', '666909b0dc2d4889a69f379e413a466c');
INSERT INTO `orderitem` VALUES ('947ec99cc605407a928bd06348a64e3a', '1', '67.00', '010', 'c45b5f7481844812bedb46d403bc620e');
INSERT INTO `orderitem` VALUES ('9c49af8bde5c46189a05af522d6e134d', '1', '73.00', '005', 'ce9e9c066d954aed9b7150591e2849a7');
INSERT INTO `orderitem` VALUES ('aae23adafbda4a0b875f0a37bf1e2155', '1', '67.00', '010', 'a46d724c5d0d439786eb1d28f5fcc69c');
INSERT INTO `orderitem` VALUES ('ac9740170df74a0a9b367c7c8772f1d5', '1', '50.00', '001', '8ec4d22cf8f64d1898fa50580fbc0e29');
INSERT INTO `orderitem` VALUES ('ae95f7c01c1e404289dc06abca49a345', '1', '62.00', '007', 'df3725fd837a4414ae2857e865451d49');
INSERT INTO `orderitem` VALUES ('b07c573ddbbe422eb8f580166a416251', '1', '108.00', '011', 'c45b5f7481844812bedb46d403bc620e');
INSERT INTO `orderitem` VALUES ('c066f785a1a447b288aff75165b6b873', '1', '28.00', '003', 'e7d2ca05508f479790c9d0bfb9688a92');
INSERT INTO `orderitem` VALUES ('e2583ad4044a4317b4e406bfd066f959', '1', '40.00', '002', 'df3725fd837a4414ae2857e865451d49');
INSERT INTO `orderitem` VALUES ('ed68b349a43341b2b22b3383a5845780', '1', '62.00', '007', 'b82b9d4de1fd4232ab440dab99827dd7');
INSERT INTO `orders` VALUES ('21d247ae13cf4140a285ce27c82664aa', '42.00', '2014-03-24 09:31:01', '4', '北京市海淀区金燕龙大厦2楼216室无敌收', '2569206c5326402cbad18ece4555340c');
INSERT INTO `orders` VALUES ('666909b0dc2d4889a69f379e413a466c', '48.00', '2014-03-24 09:48:46', '1', '北京市海淀区金燕龙大厦2楼216室无敌收', '3f31c4d780f348d1a6f94431f206be83');
INSERT INTO `orders` VALUES ('7cb89cd3915744d3b2efd9af1eac5f56', '50.00', '2014-03-22 21:42:51', '1', null, '2569206c5326402cbad18ece4555340c');
INSERT INTO `orders` VALUES ('8ec4d22cf8f64d1898fa50580fbc0e29', '50.00', '2014-03-24 09:48:04', '1', null, '3f31c4d780f348d1a6f94431f206be83');
INSERT INTO `orders` VALUES ('a46d724c5d0d439786eb1d28f5fcc69c', '187.00', '2014-03-24 09:48:19', '1', null, '3f31c4d780f348d1a6f94431f206be83');
INSERT INTO `orders` VALUES ('b82b9d4de1fd4232ab440dab99827dd7', '129.00', '2014-03-24 09:48:39', '1', null, '3f31c4d780f348d1a6f94431f206be83');
INSERT INTO `orders` VALUES ('c14535eb78f34895a04dd11ea884a326', '76.00', '2014-03-23 09:50:22', '4', '北京市海淀区金燕龙大厦2楼203室涛哥收', '2569206c5326402cbad18ece4555340c');
INSERT INTO `orders` VALUES ('c45b5f7481844812bedb46d403bc620e', '175.00', '2014-03-23 09:46:14', '2', null, '2569206c5326402cbad18ece4555340c');
INSERT INTO `orders` VALUES ('ce9e9c066d954aed9b7150591e2849a7', '123.00', '2014-03-24 09:48:30', '1', null, '3f31c4d780f348d1a6f94431f206be83');
INSERT INTO `orders` VALUES ('ceb80d1050d54699a7bb2683db9ebd9c', '73.00', '2014-03-24 10:14:41', '1', null, '2569206c5326402cbad18ece4555340c');
INSERT INTO `orders` VALUES ('df3725fd837a4414ae2857e865451d49', '175.00', '2014-03-23 10:09:14', '1', '北京市海淀区金燕龙大厦2楼203室涛哥收', '2569206c5326402cbad18ece4555340c');
INSERT INTO `orders` VALUES ('e7d2ca05508f479790c9d0bfb9688a92', '28.00', '2014-03-24 09:48:24', '1', null, '3f31c4d780f348d1a6f94431f206be83');
INSERT INTO `user` VALUES ('0e9818db44a04a9f96fd63cadcc21fd0', 'admin', 'admin', 'admin@estore.com', '0', null);
INSERT INTO `user` VALUES ('2569206c5326402cbad18ece4555340c', 'aaa', 'aaa', 'aaa@estore.com', '1', '57c22c61c35e40a897908b4c016d0540');
INSERT INTO `user` VALUES ('3f31c4d780f348d1a6f94431f206be83', 'ccc', 'ccc', 'itcast_cxf@qq.com', '1', '79d720d5b05e4313b93428456635c1d71caa4215a37f48058741f1fec8adffd8');
