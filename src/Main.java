public class Main {
    public static void main(String[] args) {
        SweepLinesNumberOfLamps swpl = new SweepLinesNumberOfLamps();
        int[][] ranges = new int[][]{
                {1,3},
                {3,5},
                {4,9},
                {5,11}
        };
        int[] points = new int[]{3,5,11};
        swpl.numOfLamps(ranges,points);
    }
}