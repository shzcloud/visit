package shz.visit.hash;

import shz.core.PRException;
import shz.jdbc.record.JdbcConsistentHash;
import shz.spring.BeanContainer;
import shz.visit.entity.SysVisitData;

import java.io.IOException;
import java.io.InputStream;

public class VisitDataConsistentHash extends JdbcConsistentHash<VisitDataConsistentHash, SysVisitData> {
    public VisitDataConsistentHash(int num) {
        super(num);
    }

    public VisitDataConsistentHash() {
    }

    @Override
    protected InputStream createTableInputStream() {
        try {
            return BeanContainer.getResource("/sql/sys_visit_data.sql").getInputStream();
        } catch (IOException e) {
            throw PRException.of(e);
        }
    }
}
