package shz.visit.recorder;

import shz.visit.entity.SysVisit;

import java.util.function.Consumer;

@FunctionalInterface
public interface VisitRecorder extends Consumer<SysVisit> {
}
