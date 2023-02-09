package shz.visit.entity;

import shz.core.ToString;
import shz.jdbc.record.JdbcConsistentHashRecordEntity;
import shz.orm.annotation.Id;
import shz.orm.annotation.Table;
import shz.visit.hash.VisitDataConsistentHash;

import java.util.Collections;
import java.util.List;

@Table("sys_visit_data")
public class SysVisitData extends JdbcConsistentHashRecordEntity<SysVisitData, VisitDataConsistentHash> {
    @Id
    private Long id;
    private Long visitId;
    private String requestData;
    private String responseData;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Long getVisitId() {
        return visitId;
    }

    public void setVisitId(Long visitId) {
        this.visitId = visitId;
    }

    public String getRequestData() {
        return requestData;
    }

    public void setRequestData(String requestData) {
        this.requestData = requestData;
    }

    public String getResponseData() {
        return responseData;
    }

    public void setResponseData(String responseData) {
        this.responseData = responseData;
    }

    @Override
    public String toString() {
        return "SysVisitData{" +
                "id=" + id +
                ", visitId=" + visitId +
                ", requestData='" + requestData + '\'' +
                ", responseData='" + responseData + '\'' +
                '}';
    }

    @Override
    public String key() {
        return ToString.normal(getVisitId());
    }

    @Override
    public List<String> keyFieldNames() {
        return Collections.singletonList("visitId");
    }
}
