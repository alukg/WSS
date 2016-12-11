
public class Main {
    public static void main(String[] args) {
        WorkStealingThreadPool pool = new WorkStealingThreadPool(4);
        int[][] array = new int[5][10];
        // some stuff
        SumMatrix myTask = new SumMatrix(array);
        pool.start();
        pool.submit(myTask);
        //some stuff
//        try {
//            pool.shutdown(); //stopping all the processors when all the already submitted tasks are done
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
