package shz.visit.hash;

import shz.core.PRException;
import shz.jdbc.record.JdbcConsistentHash;
import shz.spring.BeanContainer;
import shz.visit.entity.SysVisit;

import java.io.IOException;
import java.io.InputStream;

public class VisitConsistentHash extends JdbcConsistentHash<VisitConsistentHash, SysVisit> {
    public VisitConsistentHash(int num) {
        super(num);
    }

    public VisitConsistentHash() {
    }

    @Override
    protected InputStream createTableInputStream() {
        try {
            return BeanContainer.getResource("/sql/sys_visit.sql").getInputStream();
        } catch (IOException e) {
            throw PRException.of(e);
        }
    }
}
