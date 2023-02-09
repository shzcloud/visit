SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

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
) ENGINE = MRG_MYISAM CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统访问数据记录' INSERT_METHOD = LAST ROW_FORMAT = DYNAMIC UNION = (@MERGE_PLACEHOLDER@);

SET FOREIGN_KEY_CHECKS = 1;
