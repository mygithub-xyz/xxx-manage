/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50515
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2020-08-18 16:31:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for people
-- ----------------------------
DROP TABLE IF EXISTS `people`;
CREATE TABLE `people` (
  `pid` int(100) NOT NULL AUTO_INCREMENT,
  `pname` varchar(255) NOT NULL,
  `countryid` varchar(20) NOT NULL,
  `createtime` datetime NOT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of people
-- ----------------------------
INSERT INTO `people` VALUES ('1', '李白', '111', '2020-08-14 14:42:15');
INSERT INTO `people` VALUES ('2', '百里', '222', '2020-08-14 14:42:19');
INSERT INTO `people` VALUES ('3', '干将', '333', '2020-08-14 14:42:21');
INSERT INTO `people` VALUES ('4', '诸葛亮', '444', '2020-08-14 14:42:23');
INSERT INTO `people` VALUES ('5', '孙膑', '555', '2020-08-14 14:42:26');
INSERT INTO `people` VALUES ('6', '吕布', '666', '2020-08-14 14:42:28');
INSERT INTO `people` VALUES ('7', '宫本', '777', '2020-08-14 14:42:31');
INSERT INTO `people` VALUES ('8', '瑶瑶', '888', '2020-08-14 14:42:33');
INSERT INTO `people` VALUES ('9', '姜子牙', '999', '2020-08-14 14:42:35');
INSERT INTO `people` VALUES ('10', '安吉拉', '1010', '2020-08-14 14:42:38');
INSERT INTO `people` VALUES ('11', '小乔', '1111', '2020-08-14 14:42:40');
INSERT INTO `people` VALUES ('12', '大乔', '1212', '2020-08-14 14:42:43');
INSERT INTO `people` VALUES ('13', '后羿', '1313', '2020-08-17 16:21:25');
INSERT INTO `people` VALUES ('14', '河婆', '1414', '2020-08-17 15:38:26');
INSERT INTO `people` VALUES ('16', '河神', '1515', '2020-08-17 11:28:15');
INSERT INTO `people` VALUES ('17', '河童', '1616', '2020-08-17 16:32:22');
