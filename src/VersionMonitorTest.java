import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by shahar on 11/12/2016.
 */
class VersionMonitorTest {
    VersionMonitor vs;
    Thread thread1;
    Thread thread2;
    Thread thread3;
    @BeforeAll
    void setUpAll() {
        thread1 = new Thread(()-> {
            for (int i = 0; i < 100; i++)
                vs.inc();
        });
        thread2 = new Thread(()->{
            for(int i=0; i<100; i++)
                vs.inc();
        });
        thread3 = new Thread(()->{
            for(int i=0; i<100; i++)
                vs.inc();
        });
    }
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
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        }
        catch(InterruptedException e){}
        assertEquals(300,vs.getVersion());

    }

    @Test
    void await() {

    }

}