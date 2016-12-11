import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by shahar on 11/12/2016.
 */
class VersionMonitorTest {
    VersionMonitor vs;
    @BeforeEach
    void setUp() {
        vs = new VersionMonitor();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void getVersion() {
        assertEquals(0,vs.getVersion());
    }

    @Test
    void inc() {

    }

    @Test
    void await() {

    }

}