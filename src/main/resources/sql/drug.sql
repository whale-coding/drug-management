/*
 Navicat Premium Data Transfer

 Source Server         : mysql8
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : drug

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 23/07/2021 12:24:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for billinfo
-- ----------------------------
DROP TABLE IF EXISTS `billinfo`;
CREATE TABLE `billinfo`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商名称',
  `dname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品名称',
  `count` int(10) NULL DEFAULT NULL COMMENT '药品数量',
  `total` float(20, 2) NULL DEFAULT NULL COMMENT '总金额',
  `buytime` datetime(0) NULL DEFAULT NULL COMMENT '进货时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '账单信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of billinfo
-- ----------------------------
INSERT INTO `billinfo` VALUES (1, '哈药六厂', '感冒灵', 1000, 22500.00, '2021-02-02 16:00:00');

-- ----------------------------
-- Table structure for druginfo
-- ----------------------------
DROP TABLE IF EXISTS `druginfo`;
CREATE TABLE `druginfo`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `supplier` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商',
  `producttime` date NULL DEFAULT NULL COMMENT '生产时间',
  `warrenty` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '保质期（月）',
  `number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品编码',
  `price` float(20, 2) NULL DEFAULT NULL COMMENT '价格',
  `stock` int(10) NULL DEFAULT NULL COMMENT '库存',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '药品信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of druginfo
-- ----------------------------
INSERT INTO `druginfo` VALUES (2, '感冒灵', '哈药六厂', '2020-01-27', '24', '1001', 22.50, 50);
INSERT INTO `druginfo` VALUES (3, '白药片', '云南白药', '2021-02-02', '36', '2021052', 30.50, 100);

-- ----------------------------
-- Table structure for owinfo
-- ----------------------------
DROP TABLE IF EXISTS `owinfo`;
CREATE TABLE `owinfo`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品名称',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出库/入库',
  `count` int(10) NULL DEFAULT NULL COMMENT '数量',
  `operator` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '出入库' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of owinfo
-- ----------------------------
INSERT INTO `owinfo` VALUES (1, '白药片', '出库', 3, '华佗', '2021-02-20 14:21:53');
INSERT INTO `owinfo` VALUES (2, '感冒灵', '入库', 20, '扁鹊', '2021-02-20 14:22:12');

-- ----------------------------
-- Table structure for problem
-- ----------------------------
DROP TABLE IF EXISTS `problem`;
CREATE TABLE `problem`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品名称',
  `dcount` int(10) NULL DEFAULT NULL COMMENT '问题药品数量',
  `dprice` float(20, 2) NULL DEFAULT NULL COMMENT '药品单价',
  `reason` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '问题原因',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '问题药品' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of problem
-- ----------------------------
INSERT INTO `problem` VALUES (1, '感冒灵', 2, 22.50, '受潮了。不能欺骗消费者。', '2021-02-24 14:19:36');

-- ----------------------------
-- Table structure for returngoods
-- ----------------------------
DROP TABLE IF EXISTS `returngoods`;
CREATE TABLE `returngoods`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品名称',
  `count` int(10) NULL DEFAULT NULL COMMENT '数量',
  `reason` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '退货原因',
  `total` float(20, 2) NULL DEFAULT NULL COMMENT '总金额',
  `operatetime` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '收到退货' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of returngoods
-- ----------------------------
INSERT INTO `returngoods` VALUES (1, '感冒灵', 1, '过期', 12.50, '2021-02-25 16:00:00');

-- ----------------------------
-- Table structure for returnsupplier
-- ----------------------------
DROP TABLE IF EXISTS `returnsupplier`;
CREATE TABLE `returnsupplier`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品名称',
  `dcount` int(10) NULL DEFAULT NULL COMMENT '数量',
  `sname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商名称',
  `buytime` datetime(0) NULL DEFAULT NULL COMMENT '进货时间',
  `reason` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '退货原因',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '退货时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '退货给供应商' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of returnsupplier
-- ----------------------------
INSERT INTO `returnsupplier` VALUES (1, '感冒灵', 10, '哈药六厂', '2021-02-24 16:00:00', '过期了呗！！！', '2021-02-26 16:00:00');

-- ----------------------------
-- Table structure for saleinfo
-- ----------------------------
DROP TABLE IF EXISTS `saleinfo`;
CREATE TABLE `saleinfo`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品名称',
  `dnumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品编号',
  `count` int(10) NULL DEFAULT NULL COMMENT '数量',
  `total` float(20, 2) NULL DEFAULT NULL COMMENT '金额',
  `operator` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人',
  `operatetime` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '销售记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of saleinfo
-- ----------------------------
INSERT INTO `saleinfo` VALUES (1, '感冒灵', '1001', 2, 45.00, '张三', '2021-02-25 16:00:00');

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商名称',
  `content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商描述',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '供应商' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES (1, '哈药六厂', '东北很知名的企业之一', '2018-01-17 11:52:53');
INSERT INTO `supplier` VALUES (2, '云南白药', '云南白药是云南著名的中成药，由名贵药材制成，具有化瘀止血、活血止痛、解毒消肿之功效。', '2021-02-18 14:20:49');
INSERT INTO `supplier` VALUES (3, '阿斯利康', '作为一家以创新为驱动的全球性生物制药企业，阿斯利康始终相信“科学，激发无限可能”，并将科学作为一切工作的重中之重。', '2021-07-23 12:19:38');
INSERT INTO `supplier` VALUES (4, '辉瑞', '辉瑞制药有限公司为中美合资兴建的大型现代化制药企业，1989年10月成立，注册资本为5,040万美元，投资总额为6,040万美元，是目前国内投资规模最大的合资制药企业之一', '2021-07-14 12:19:59');
INSERT INTO `supplier` VALUES (5, '扬子江药业', '扬子江药业集团是一家總部位於中华人民共和国江苏省泰州市的跨国制药企业，研究总部位于上海市。', '2021-06-17 15:22:05');
INSERT INTO `supplier` VALUES (6, '恒瑞医药', '恒瑞医药始建于1970年，2000年在上海证券交易所上市（沪市：600276），是中国最大的抗肿瘤药和手术用药的研究和生产基地，也是中国最具创新能力的大型制药企业之一。', '2021-07-10 12:22:14');
INSERT INTO `supplier` VALUES (7, '罗氏', '罗氏公司(Roche)是以研究为导向的健康事业公司，创立于1896年，总部位于瑞士巴塞尔。', '2021-07-04 12:22:17');
INSERT INTO `supplier` VALUES (8, '拜耳', '德国拜耳集团(Bayer)是全球最为知名的《财富》世界500强企业之一,全球制药巨头。', '2021-07-25 12:22:19');
INSERT INTO `supplier` VALUES (9, '赛诺菲', '赛诺菲（法語：Sanofi）总部位于法国巴黎，是世界上第五大的制药企业，致力于医药产品的研究、开发、生产以及销售', '2021-08-01 12:22:23');
INSERT INTO `supplier` VALUES (10, '正大天晴', '正大天晴药业集团是集科研、生产和销售为一体的创新型医药集团企业，是国内最大的肝健康药物研发和生产基地，为国家重点高新技术企业', '2021-07-31 12:22:27');
INSERT INTO `supplier` VALUES (11, '石药集团', '石药集团有限公司（“石药集团”）（股份代号：1093.HK）是香港知名医药上市企业之一。', '2021-08-07 12:22:30');
INSERT INTO `supplier` VALUES (12, '科伦集团', '科伦药业创立于1996年，13年产业疾行，现已成为拥有省内外16家子(分)公司的现代化药业集团。', '2021-10-29 12:22:34');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '123456');

SET FOREIGN_KEY_CHECKS = 1;
