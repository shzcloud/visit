package shz.visit.service;

import org.springframework.beans.factory.annotation.Autowired;
import shz.core.function.ActionRunner;
import shz.core.model.PageInfo;
import shz.jdbc.JdbcService;
import shz.orm.record.RecordService;
import shz.spring.model.PageVo;
import shz.visit.entity.SysVisit;
import shz.visit.vo.QueryVisitVo;

import java.util.Comparator;

public class VisitService extends RecordService<SysVisit> {
    @Autowired
    protected JdbcService jdbcService;

    public PageInfo<SysVisit> page(PageVo<QueryVisitVo, SysVisit> pageVo) {
        QueryVisitVo reqVo = pageVo.getData();
        ActionRunner<SysVisit> runner = runner(null, null, null, jdbcService.whereSql(SysVisit.class, reqVo, null, false));
        return page(pageVo.map(), runner, null, Comparator.comparing(SysVisit::getCreateTime));
    }
}
