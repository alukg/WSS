
public class SumRow extends Task<Integer> {
    private int[][] array;
    private int r;

    public SumRow(int[][] array, int r) {
        this.array = array;
        this.r = r;
    }

    protected void start() {
        int sum = 0;
        for (int j = 0; j < array[1].length; j++)
            sum += array[r][j];
        complete(sum);
    }
}