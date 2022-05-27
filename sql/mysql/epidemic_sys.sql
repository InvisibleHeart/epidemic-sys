/*
 Navicat Premium Data Transfer

 Source Server         : 毕业设计数据库
 Source Server Type    : MySQL
 Source Server Version : 50650
 Source Host           : 139.196.55.213:3306
 Source Schema         : epidemic_sys

 Target Server Type    : MySQL
 Target Server Version : 50650
 File Encoding         : 65001

 Date: 27/05/2022 10:59:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for morbidity
-- ----------------------------
DROP TABLE IF EXISTS `morbidity`;
CREATE TABLE `morbidity`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '发病ID',
  `patient_id` int(11) NULL DEFAULT 0 COMMENT '患者ID',
  `creat_date` date NULL DEFAULT NULL COMMENT '创建日期',
  `situation_con` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '发病情况',
  `remarks` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '备注',
  `t_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `t_create_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建人',
  `t_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `t_update_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '发病记录管理表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for nuclein
-- ----------------------------
DROP TABLE IF EXISTS `nuclein`;
CREATE TABLE `nuclein`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '核酸ID',
  `patient_id` int(11) NULL DEFAULT 0 COMMENT '患者ID',
  `nuclein_date` date NULL DEFAULT NULL COMMENT '核酸日期',
  `result` int(2) NULL DEFAULT 0 COMMENT '结果【0-阴，1-阳】',
  `remarks` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '备注',
  `t_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `t_create_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建人',
  `t_update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `t_update_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '核酸记录管理表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for patient
-- ----------------------------
DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '患者ID',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '姓名',
  `sex` tinyint(1) NULL DEFAULT 0 COMMENT '性别',
  `age` int(4) NULL DEFAULT 0 COMMENT '年龄',
  `height` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '身高',
  `weight` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '体重',
  `source` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '感染源',
  `status` int(2) NULL DEFAULT 0 COMMENT '状态【0-密切接触者，1-受感染者，2-危重症病人，3-死亡者，4-治愈者， 5-正常】',
  `region_id` int(11) NULL DEFAULT 0 COMMENT '地区ID',
  `identity_card` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '身份证',
  `crowd` int(2) NULL DEFAULT 0 COMMENT '人群【0-儿童，1-少年，2-青年，3-中年，4-老年】',
  `update_date` date NULL DEFAULT NULL COMMENT '日期',
  `cellphone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '联系电话',
  `t_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `t_create_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建人',
  `t_update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `t_update_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '患者管理信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for region
-- ----------------------------
DROP TABLE IF EXISTS `region`;
CREATE TABLE `region`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '地区ID',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '名称',
  `region_count` int(11) NULL DEFAULT 0 COMMENT '数量',
  `t_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `t_create_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建人',
  `t_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `t_update_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '地区管理信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '密码',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '昵称',
  `cellphone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '手机号',
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '邮箱',
  `head_img` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '头像',
  `sex` tinyint(1) NULL DEFAULT 0 COMMENT '性别',
  `role` int(2) NULL DEFAULT 0 COMMENT '角色',
  `t_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `t_create_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建人',
  `t_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `t_update_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息表' ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
