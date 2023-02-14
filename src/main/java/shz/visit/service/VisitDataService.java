package shz.visit.service;

import org.springframework.beans.factory.annotation.Autowired;
import shz.jdbc.JdbcService;
import shz.orm.record.RecordService;
import shz.visit.entity.SysVisitData;

public class VisitDataService extends RecordService<SysVisitData> {
    @Autowired
    protected JdbcService jdbcService;

    public SysVisitData selectByVisitId(Long visitId) {
        if (visitId == null || visitId <= 0L) return null;
        SysVisitData entity = new SysVisitData();
        entity.setVisitId(visitId);
        return selectOneByKey(entity, true, null, Boolean.FALSE);
    }
}
