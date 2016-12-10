import java.util.ArrayDeque;
import java.util.Deque;

/**
 * this class represents a single work stealing processor, it is
 * {@link Runnable} so it is suitable to be executed by threads.
 * <p>
 * Note for implementors: you may add methods and synchronize any of the
 * existing methods in this class *BUT* you must be able to explain why the
 * synchronization is needed. In addition, the methods you add can only be
 * private, protected or package protected - in other words, no new public
 * methods
 */
public class Processor implements Runnable {

    private boolean isStopped;
    private final WorkStealingThreadPool pool;
    private final int id;
    private final ArrayDeque<Task> tasks;

    /**
     * constructor for this class
     * <p>
     * IMPORTANT:
     * 1) this method is package protected, i.e., only classes inside
     * the same package can access it - you should *not* change it to
     * public/private/protected
     * <p>
     * 2) you may not add other constructors to this class
     * nor you allowed to add any other parameter to this constructor - changing
     * this may cause automatic tests to fail..
     *
     * @param id   - the processor id (every processor need to have its own unique
     *             id inside its thread pool)
     * @param pool - the thread pool which owns this processor
     */
    /*package*/ Processor(int id, WorkStealingThreadPool pool) {
        this.id = id;
        this.pool = pool;
        this.tasks = new ArrayDeque<Task>();
    }

    @Override
    public void run() {
        while () {
            try {
                if (tasks.isEmpty()) {
                    //stealTask;
                } else {
                    Task t = tasks.pollFirst();
                    t.handle(this);
                }
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    /**
     * add the task to the queue of the processor
     *
     * @param task - the task accepted from the thread pool
     */
    void addTask(Task<?> task) {
        tasks.addFirst(task);
    }

}
