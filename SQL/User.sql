/*
 Navicat Premium Data Transfer

 Source Server         : yun
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : 106.12.73.176:3306
 Source Schema         : chatWeb

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 08/01/2019 17:27:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for User
-- ----------------------------
DROP TABLE IF EXISTS `User`;
CREATE TABLE `User`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `account` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `realName` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `mobile` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `head` mediumblob NULL COMMENT '头像',
  `creationDate` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
