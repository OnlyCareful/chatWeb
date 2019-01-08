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

 Date: 08/01/2019 17:26:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ChatRecords
-- ----------------------------
DROP TABLE IF EXISTS `ChatRecords`;
CREATE TABLE `ChatRecords`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `send` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发送者ID',
  `receive` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '接收者ID',
  `content` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '内容',
  `creationDate` datetime(0) NOT NULL COMMENT '时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
