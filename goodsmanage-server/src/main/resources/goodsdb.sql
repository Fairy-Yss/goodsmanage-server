/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50710
Source Host           : localhost:3306
Source Database       : goodsdb

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2019-09-20 01:12:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `eid` varchar(255) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `mark` varchar(255) DEFAULT NULL,
  `accountNo` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nickName` varchar(255) NOT NULL,
  `roleName` varchar(255) NOT NULL,
  PRIMARY KEY (`id`,`eid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', 'sddxc_55118x2269', null, null, null, 'lqcool', 'lqcool', 'lqcool', 'admin');
INSERT INTO `account` VALUES ('2', 'sddxc_55118x2262', null, null, null, 'sasa', 'sasa', 'sasa', 'admin');
