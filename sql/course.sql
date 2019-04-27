/*
 Navicat Premium Data Transfer

 Source Server         : VM1
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : 192.168.152.100:3306
 Source Schema         : course

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 27/04/2019 16:14:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for lesson
-- ----------------------------
DROP TABLE IF EXISTS `lesson`;
CREATE TABLE `lesson`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '课程名称',
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '课程图片',
  `enable` tinyint(1) NOT NULL DEFAULT 1 COMMENT '是否可用',
  `page_order` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '章节顺序，返回时是按照这个顺序返回',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lesson
-- ----------------------------
INSERT INTO `lesson` VALUES (1, '测试课程', 'default-icon', 1, NULL);

-- ----------------------------
-- Table structure for page
-- ----------------------------
DROP TABLE IF EXISTS `page`;
CREATE TABLE `page`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '章节名称',
  `enable` tinyint(1) NOT NULL DEFAULT 1 COMMENT '是否可用',
  `lesson_id` int(10) NOT NULL COMMENT '所属课程id',
  `voice_order` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '声音的排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 48 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of page
-- ----------------------------
INSERT INTO `page` VALUES (1, '1.jpg', 1, 1, NULL);
INSERT INTO `page` VALUES (2, '2.jpg', 1, 1, NULL);
INSERT INTO `page` VALUES (3, '3.jpg', 1, 1, NULL);
INSERT INTO `page` VALUES (4, '4.jpg', 1, 1, NULL);
INSERT INTO `page` VALUES (5, '5.jpg', 1, 1, NULL);
INSERT INTO `page` VALUES (6, '6.jpg', 1, 1, NULL);
INSERT INTO `page` VALUES (7, '7.jpg', 1, 1, NULL);
INSERT INTO `page` VALUES (8, '8.jpg', 1, 1, NULL);
INSERT INTO `page` VALUES (9, '9.jpg', 1, 1, NULL);
INSERT INTO `page` VALUES (10, '10.jpg', 1, 1, NULL);
INSERT INTO `page` VALUES (11, '11.jpg', 1, 1, NULL);
INSERT INTO `page` VALUES (12, '12.jpg', 1, 1, NULL);
INSERT INTO `page` VALUES (13, '13.jpg', 1, 1, NULL);
INSERT INTO `page` VALUES (14, '14.jpg', 1, 1, NULL);
INSERT INTO `page` VALUES (15, '15.jpg', 1, 1, NULL);
INSERT INTO `page` VALUES (16, '16.jpg', 1, 1, NULL);
INSERT INTO `page` VALUES (17, '17.jpg', 1, 1, NULL);
INSERT INTO `page` VALUES (18, '18.jpg', 1, 1, NULL);
INSERT INTO `page` VALUES (19, '19.jpg', 1, 1, NULL);
INSERT INTO `page` VALUES (20, '20.jpg', 1, 1, NULL);
INSERT INTO `page` VALUES (21, '21.jpg', 1, 1, NULL);
INSERT INTO `page` VALUES (22, '22.jpg', 1, 1, NULL);
INSERT INTO `page` VALUES (23, '23.jpg', 1, 1, NULL);
INSERT INTO `page` VALUES (24, '24.jpg', 1, 1, NULL);
INSERT INTO `page` VALUES (25, '25.jpg', 1, 1, NULL);
INSERT INTO `page` VALUES (26, '26.jpg', 1, 1, NULL);
INSERT INTO `page` VALUES (27, '27.jpg', 1, 1, NULL);
INSERT INTO `page` VALUES (28, '28.jpg', 1, 1, NULL);
INSERT INTO `page` VALUES (29, '29.jpg', 1, 1, NULL);
INSERT INTO `page` VALUES (30, '30.jpg', 1, 1, NULL);
INSERT INTO `page` VALUES (31, '31.jpg', 1, 1, NULL);

-- ----------------------------
-- Table structure for progress
-- ----------------------------
DROP TABLE IF EXISTS `progress`;
CREATE TABLE `progress`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `uid` int(10) NOT NULL COMMENT '用户id',
  `lesson_id` int(10) NOT NULL COMMENT '课程id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of progress
-- ----------------------------
INSERT INTO `progress` VALUES (1, 1, 1);

-- ----------------------------
-- Table structure for token
-- ----------------------------
DROP TABLE IF EXISTS `token`;
CREATE TABLE `token`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `created` int(11) NOT NULL COMMENT '创建时间',
  `updated` int(11) NOT NULL COMMENT '更新时间',
  `uid` int(20) NOT NULL COMMENT '用户id',
  `token` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户token',
  `effective` tinyint(1) NOT NULL DEFAULT 1 COMMENT '是否生效，0：失效；1：生效',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `用户索引`(`uid`) USING BTREE,
  INDEX `created`(`created`) USING BTREE,
  INDEX `updated`(`updated`) USING BTREE,
  INDEX `token`(`token`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '用户token表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of token
-- ----------------------------
INSERT INTO `token` VALUES (4, 111111111, 222222222, 111, '11111', 1);
INSERT INTO `token` VALUES (5, 1556099074, 1556099074, 1, 'c8a83c3675c3b7dbda06683c7d855716', 0);
INSERT INTO `token` VALUES (6, 1556099865, 1556099865, 1, 'af131679d3d2618d9c58a3201b0192b7', 0);
INSERT INTO `token` VALUES (7, 1556099871, 1556099871, 1, '4077dd406809fe29c3d9ec09b1a4c0cb', 0);
INSERT INTO `token` VALUES (8, 1556337852, 1556337852, 1, 'a6323bdd73a36783c50f338da5b35661', 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'laoliu', '39afab7a3992a9b45fc6005447f4a86d');
INSERT INTO `user` VALUES (2, 'laozhao', '456');

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '视频名称',
  `page_id` int(10) NOT NULL COMMENT '所属页',
  `lesson_id` int(10) NOT NULL COMMENT '课程id',
  `enable` tinyint(1) NOT NULL DEFAULT 1 COMMENT '是否可用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video` VALUES (1, '1.mp4', 16, 1, 1);
INSERT INTO `video` VALUES (2, '2.mp4', 20, 1, 1);
INSERT INTO `video` VALUES (3, '3.mp4', 23, 1, 1);
INSERT INTO `video` VALUES (4, '4.mp4', 27, 1, 1);

-- ----------------------------
-- Table structure for voice
-- ----------------------------
DROP TABLE IF EXISTS `voice`;
CREATE TABLE `voice`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '声音名称',
  `page_id` int(10) NOT NULL COMMENT '所属的章节',
  `lesson_id` int(10) NOT NULL COMMENT '所属课程',
  `enable` tinyint(1) NOT NULL DEFAULT 1 COMMENT '是否可用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of voice
-- ----------------------------
INSERT INTO `voice` VALUES (1, '1.mp3', 1, 1, 1);
INSERT INTO `voice` VALUES (2, '1.mp3', 1, 1, 1);
INSERT INTO `voice` VALUES (3, '2.mp3', 3, 1, 1);
INSERT INTO `voice` VALUES (4, '3.mp3', 4, 1, 1);
INSERT INTO `voice` VALUES (5, '4.mp3', 5, 1, 1);
INSERT INTO `voice` VALUES (6, '5.mp3', 8, 1, 1);
INSERT INTO `voice` VALUES (7, '6.mp3', 8, 1, 1);
INSERT INTO `voice` VALUES (8, '7.mp3', 9, 1, 1);
INSERT INTO `voice` VALUES (9, '8.mp3', 9, 1, 1);
INSERT INTO `voice` VALUES (10, '9.mp3', 9, 1, 1);
INSERT INTO `voice` VALUES (11, '10.mp3', 9, 1, 1);
INSERT INTO `voice` VALUES (12, '11.mp3', 12, 1, 1);
INSERT INTO `voice` VALUES (13, '12.mp3', 12, 1, 1);
INSERT INTO `voice` VALUES (14, '13.mp3', 12, 1, 1);
INSERT INTO `voice` VALUES (15, '14.mp3', 12, 1, 1);
INSERT INTO `voice` VALUES (16, '15.mp3', 13, 1, 1);
INSERT INTO `voice` VALUES (17, '16.mp3', 14, 1, 1);
INSERT INTO `voice` VALUES (18, '17.mp3', 21, 1, 1);
INSERT INTO `voice` VALUES (19, '18.mp3', 21, 1, 1);
INSERT INTO `voice` VALUES (20, '19.mp3', 21, 1, 1);
INSERT INTO `voice` VALUES (21, '20.mp3', 21, 1, 1);
INSERT INTO `voice` VALUES (22, '21.mp3', 21, 1, 1);
INSERT INTO `voice` VALUES (23, '22.mp3', 21, 1, 1);
INSERT INTO `voice` VALUES (24, '23.mp3', 21, 1, 1);
INSERT INTO `voice` VALUES (25, '24.mp3', 21, 1, 1);
INSERT INTO `voice` VALUES (26, '25.mp3', 22, 1, 1);
INSERT INTO `voice` VALUES (27, '26.mp3', 24, 1, 1);
INSERT INTO `voice` VALUES (28, '27.mp3', 25, 1, 1);
INSERT INTO `voice` VALUES (29, '28.mp3', 28, 1, 1);
INSERT INTO `voice` VALUES (30, '29.mp3', 28, 1, 1);
INSERT INTO `voice` VALUES (31, '30.mp3', 29, 1, 1);
INSERT INTO `voice` VALUES (32, '30.mp3', 30, 1, 1);
INSERT INTO `voice` VALUES (33, '30.mp3', 31, 1, 1);

SET FOREIGN_KEY_CHECKS = 1;
