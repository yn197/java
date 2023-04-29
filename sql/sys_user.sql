/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50739
 Source Host           : localhost:3306
 Source Schema         : ry-cloud

 Target Server Type    : MySQL
 Target Server Version : 50739
 File Encoding         : 65001

 Date: 29/04/2023 12:15:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `dept_id` bigint(20) NULL DEFAULT NULL COMMENT '部门ID',
  `user_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户账号',
  `nick_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户昵称',
  `user_type` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '00' COMMENT '用户类型（00系统用户）',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '手机号码',
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '头像地址',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '密码',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `login_ip` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '最后登录IP',
  `login_date` datetime NULL DEFAULT NULL COMMENT '最后登录时间',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 300419788222500865 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 103, 'admin', '若依', '00', 'ry@163.com', '15888888888', '1', '', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '0', '0', '127.0.0.1', '2022-10-19 20:41:25', 'admin', '2022-10-19 20:41:25', '', NULL, '管理员');
INSERT INTO `sys_user` VALUES (2, 105, 'ry', '若依', '00', 'ry@qq.com', '15666666666', '1', '', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '0', '0', '127.0.0.1', '2022-10-19 20:41:25', 'admin', '2022-10-19 20:41:25', '', NULL, '测试员');
INSERT INTO `sys_user` VALUES (300125399587753984, 300125399587753985, '测试数据', '若依测试数据', '00', '', '', '0', '', '', '0', '0', '', NULL, '', NULL, '', NULL, NULL);
INSERT INTO `sys_user` VALUES (300404221583298560, 300404221583298561, '测试数据2', '若依测试数据2', '00', '', '', '0', '', '', '0', '0', '', NULL, '', '2023-04-28 15:07:31', '', NULL, NULL);
INSERT INTO `sys_user` VALUES (300405368293429248, 300405368293429249, '测试数据3', '若依测试数据3', '00', '', '', '0', '', '', '0', '0', '', NULL, '', '2023-04-28 15:12:04', '', '2024-04-28 15:12:04', NULL);
INSERT INTO `sys_user` VALUES (300405734238064640, 300405734238064641, '测试数据4', '若依测试数据4', '00', '', '', '0', '', '', '0', '0', '', NULL, '', '2023-04-28 15:13:31', '', '2023-04-29 15:13:31', NULL);
INSERT INTO `sys_user` VALUES (300406363262029824, 300406363262029825, '测试数据5', '若依测试数据5', '00', '', '', '0', '', '', '0', '0', '', NULL, '', '2023-04-28 15:16:01', '', '2024-04-28 15:16:01', NULL);
INSERT INTO `sys_user` VALUES (300419788222500864, 300419788222500865, '测试数据6', '若依测试数据6', '00', '', '', '0', '', '', '0', '0', '', NULL, '', '2023-04-28 16:09:22', '', '2024-04-27 16:09:22', NULL);

SET FOREIGN_KEY_CHECKS = 1;
