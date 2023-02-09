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
) ENGINE = MRG_MYISAM CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统访问记录' INSERT_METHOD = LAST ROW_FORMAT = DYNAMIC UNION = (`sys_visit_0_0`,`sys_visit_0_1`,`sys_visit_0_2`,`sys_visit_0_3`);

-- ----------------------------
-- Table structure for sys_visit_0_0
-- ----------------------------
DROP TABLE IF EXISTS `sys_visit_0_0`;
CREATE TABLE `sys_visit_0_0`  (
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
  INDEX `AK_idx_sys_visit_0_0_ct`(`create_time`) USING BTREE,
  INDEX `AK_idx_sys_visit_0_0_et`(`elapsed_time`) USING BTREE,
  INDEX `AK_idx_sys_visit_0_0_userid`(`userid`) USING BTREE,
  INDEX `AK_idx_sys_visit_0_0_ip`(`ip`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统访问记录' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for sys_visit_0_1
-- ----------------------------
DROP TABLE IF EXISTS `sys_visit_0_1`;
CREATE TABLE `sys_visit_0_1`  (
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
  INDEX `AK_idx_sys_visit_0_1_ct`(`create_time`) USING BTREE,
  INDEX `AK_idx_sys_visit_0_1_et`(`elapsed_time`) USING BTREE,
  INDEX `AK_idx_sys_visit_0_1_userid`(`userid`) USING BTREE,
  INDEX `AK_idx_sys_visit_0_1_ip`(`ip`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统访问记录' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for sys_visit_0_2
-- ----------------------------
DROP TABLE IF EXISTS `sys_visit_0_2`;
CREATE TABLE `sys_visit_0_2`  (
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
  INDEX `AK_idx_sys_visit_0_2_ct`(`create_time`) USING BTREE,
  INDEX `AK_idx_sys_visit_0_2_et`(`elapsed_time`) USING BTREE,
  INDEX `AK_idx_sys_visit_0_2_userid`(`userid`) USING BTREE,
  INDEX `AK_idx_sys_visit_0_2_ip`(`ip`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统访问记录' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for sys_visit_0_3
-- ----------------------------
DROP TABLE IF EXISTS `sys_visit_0_3`;
CREATE TABLE `sys_visit_0_3`  (
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
  INDEX `AK_idx_sys_visit_0_3_ct`(`create_time`) USING BTREE,
  INDEX `AK_idx_sys_visit_0_3_et`(`elapsed_time`) USING BTREE,
  INDEX `AK_idx_sys_visit_0_3_userid`(`userid`) USING BTREE,
  INDEX `AK_idx_sys_visit_0_3_ip`(`ip`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统访问记录' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for sys_visit_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_visit_data`;
CREATE TABLE `sys_visit_data`  (
  `id` bigint UNSIGNED NOT NULL COMMENT '主键',
  `visit_id` bigint UNSIGNED NOT NULL COMMENT '访问ID',
  `request_data` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '请求数据',
  `response_data` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '响应数据',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `AK_ux_sys_visit_data_vid`(`visit_id`) USING BTREE
) ENGINE = MRG_MYISAM CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统访问数据记录' INSERT_METHOD = LAST ROW_FORMAT = DYNAMIC UNION = (`sys_visit_data_0_0`,`sys_visit_data_0_1`,`sys_visit_data_0_2`,`sys_visit_data_0_3`);

-- ----------------------------
-- Table structure for sys_visit_data_0_0
-- ----------------------------
DROP TABLE IF EXISTS `sys_visit_data_0_0`;
CREATE TABLE `sys_visit_data_0_0`  (
  `id` bigint UNSIGNED NOT NULL COMMENT '主键',
  `visit_id` bigint UNSIGNED NOT NULL COMMENT '访问ID',
  `request_data` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '请求数据',
  `response_data` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '响应数据',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `AK_ux_sys_visit_data_0_0_vid`(`visit_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统访问数据记录' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for sys_visit_data_0_1
-- ----------------------------
DROP TABLE IF EXISTS `sys_visit_data_0_1`;
CREATE TABLE `sys_visit_data_0_1`  (
  `id` bigint UNSIGNED NOT NULL COMMENT '主键',
  `visit_id` bigint UNSIGNED NOT NULL COMMENT '访问ID',
  `request_data` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '请求数据',
  `response_data` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '响应数据',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `AK_ux_sys_visit_data_0_1_vid`(`visit_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统访问数据记录' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for sys_visit_data_0_2
-- ----------------------------
DROP TABLE IF EXISTS `sys_visit_data_0_2`;
CREATE TABLE `sys_visit_data_0_2`  (
  `id` bigint UNSIGNED NOT NULL COMMENT '主键',
  `visit_id` bigint UNSIGNED NOT NULL COMMENT '访问ID',
  `request_data` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '请求数据',
  `response_data` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '响应数据',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `AK_ux_sys_visit_data_0_2_vid`(`visit_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统访问数据记录' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for sys_visit_data_0_3
-- ----------------------------
DROP TABLE IF EXISTS `sys_visit_data_0_3`;
CREATE TABLE `sys_visit_data_0_3`  (
  `id` bigint UNSIGNED NOT NULL COMMENT '主键',
  `visit_id` bigint UNSIGNED NOT NULL COMMENT '访问ID',
  `request_data` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '请求数据',
  `response_data` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '响应数据',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `AK_ux_sys_visit_data_0_3_vid`(`visit_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统访问数据记录' ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;
