/*
 Navicat Premium Data Transfer

 Source Server         : hw
 Source Server Type    : MySQL
 Source Server Version : 50527
 Source Host           : localhost:3306
 Source Schema         : mybatis

 Target Server Type    : MySQL
 Target Server Version : 50527
 File Encoding         : 65001

 Date: 27/05/2019 11:07:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `aid` int(10) NOT NULL AUTO_INCREMENT,
  `aname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `apwd` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `money` double(10, 2) NOT NULL,
  PRIMARY KEY (`aid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (1, '黄巍', '197956', 12000.00);
INSERT INTO `account` VALUES (2, '马哥', '123456', 8000.00);

-- ----------------------------
-- Table structure for flower
-- ----------------------------
DROP TABLE IF EXISTS `flower`;
CREATE TABLE `flower`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `price` double(10, 2) NOT NULL COMMENT '价格',
  `production` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产地',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of flower
-- ----------------------------
INSERT INTO `flower` VALUES (1, '矮牵牛', 2.50, '南美阿根廷');
INSERT INTO `flower` VALUES (2, '百日草', 5.50, '墨西哥');
INSERT INTO `flower` VALUES (3, '半枝莲', 4.30, '巴西');
INSERT INTO `flower` VALUES (4, '拼命花', 18.88, '香蕉大学');
INSERT INTO `flower` VALUES (5, '有钱花', 16.66, '香蕉大学');
INSERT INTO `flower` VALUES (7, '香蕉花', 6.66, '仙交');
INSERT INTO `flower` VALUES (9, '香蕉花', 6.66, '仙交');

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log`  (
  `outId` int(10) NOT NULL,
  `inId` int(10) NOT NULL,
  `money` double(10, 2) DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES (1, 2, 500.00);
INSERT INTO `log` VALUES (1, 2, 200.00);
INSERT INTO `log` VALUES (1, 2, 800.00);
INSERT INTO `log` VALUES (2, 1, 5000.00);

SET FOREIGN_KEY_CHECKS = 1;
