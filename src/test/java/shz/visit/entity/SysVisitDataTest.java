package shz.visit.entity;

import org.junit.jupiter.api.Test;
import shz.core.io.FileHelp;
import shz.core.io.IOHelp;
import shz.jdbc.JdbcService;
import shz.jdbc.entity.SysTableNode;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class SysVisitDataTest {
    int tableNum = 4;

    @Test
    void create() {
        JdbcService jdbcService = new JdbcService();
        jdbcService.setDataSource(
                "com.mysql.cj.jdbc.Driver",
                "jdbc:mysql://192.168.1.105:3306/visit?useUnicode=true&characterEncoding=utf8&useSSL=false&autoReconnect=true&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true",
                "root",
                "root"
        );

        String tableName = "sys_visit_data";
        File file = FileHelp.findFile("**/sql/" + tableName + ".sql");
        if (file == null) return;
        List<String> sqls = jdbcService.fromIs(IOHelp.newBufferedInputStream(file.toPath()));

        for (int i = 0; i < tableNum; ++i) {
            String tableNameX = tableName + "_0_" + i;
            jdbcService.executeBatch(0, sqls.stream().map(sql -> sql.replaceAll(tableName, tableNameX)).toArray(String[]::new));
        }
    }

    @Test
    void merge() {
        JdbcService jdbcService = new JdbcService();
        jdbcService.setDataSource(
                "com.mysql.cj.jdbc.Driver",
                "jdbc:mysql://192.168.1.105:3306/visit?useUnicode=true&characterEncoding=utf8&useSSL=false&autoReconnect=true&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true",
                "root",
                "root"
        );

        String tableName = "sys_visit_data";
        File file = FileHelp.findFile("**/sql/" + tableName + "_merge.sql");
        if (file == null) return;
        List<String> sqls = jdbcService.fromIs(IOHelp.newBufferedInputStream(file.toPath()));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tableNum; ++i) {
            if (i > 0) sb.append(',');
            sb.append(tableName).append("_0_").append(i);
        }

        String s = sb.toString();
        String mergePlaceholder = "@MERGE_PLACEHOLDER@";
        jdbcService.executeBatch(0, sqls.stream().map(sql -> sql.replaceAll(mergePlaceholder, s)).toArray(String[]::new));
    }

    @Test
    void initTableNode() {
        JdbcService jdbcService = new JdbcService();
        jdbcService.setDataSource(
                "com.mysql.cj.jdbc.Driver",
                "jdbc:mysql://192.168.1.105:3306/xxx_demo?useUnicode=true&characterEncoding=utf8&useSSL=false&autoReconnect=true&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true",
                "root",
                "root"
        );

        List<SysTableNode> entities = new ArrayList<>(tableNum);
        for (int i = 0; i < tableNum; ++i) entities.add(entity("0_" + i));

        jdbcService.batchInsertOrUpdate(entities, "tableName", "node");
    }

    SysTableNode entity(String node) {
        SysTableNode entity = new SysTableNode();
        entity.setTableName("sys_visit_data");
        entity.setNode(node);
        entity.setDsName("visit");
        return entity;
    }
}