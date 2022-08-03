package pl.training.jsf.domain;

import java.time.Instant;

public interface TimeProvider {

    Instant getTimestamp();

}
