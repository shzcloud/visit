SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_visit
-- ----------------------------
DROP TABLE IF EXISTS `sys_visit`;
CREATE TABLE `sys_visit`  (
  `id` bigint UNSIGNED NOT NULL COMMENT '主键',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `app_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'DEFAULT' COMMENT '应用程序名',
  `destroyed_time` datetime(0) NOT NULL COMMENT '销毁时间',
  `elapsed_time` bigint UNSIGNED NOT NULL COMMENT '耗时(ms)',
  `login` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否登入',
  `userid` bigint UNSIGNED NULL DEFAULT NULL COMMENT '登入账号id',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '登入账号',
  `ip` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'ip地址',
  `port` int NOT NULL DEFAULT -1 COMMENT '端口',
  `mac` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'mac地址',
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '访问路径',
  `method` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'GET' COMMENT '请求方法',
  `referer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '链接来源',
  `exception` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否异常',
  `exception_code` int NULL DEFAULT NULL COMMENT '异常编码',
  `exception_msg` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '异常信息',
  `browser` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '浏览器',
  `browser_version` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '浏览器版本',
  `os` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作系统',
  `ajax` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否Ajax请求',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `AK_idx_sys_visit_ct`(`create_time`) USING BTREE,
  INDEX `AK_idx_sys_visit_et`(`elapsed_time`) USING BTREE,
  INDEX `AK_idx_sys_visit_userid`(`userid`) USING BTREE,
  INDEX `AK_idx_sys_visit_ip`(`ip`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统访问记录' ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;
