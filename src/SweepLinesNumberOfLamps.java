import java.util.Arrays;
import java.util.Comparator;

public class SweepLinesNumberOfLamps {
    public int[] numOfLamps(int[][] ranges, int[] points){
        int[] answer = new int[points.length];
        int[][] swpLine = new int[ranges.length * 2][2];
        int populate = 0;
        int minPoint = Integer.MAX_VALUE;
        int maxPoint = Integer.MIN_VALUE;
        for(int[] r : ranges){
            swpLine[populate][0] = r[0];
            swpLine[populate++][1] = 1;
            swpLine[populate][0] = r[1];
            swpLine[populate++][1] = -1;
        }
        Arrays.sort(swpLine, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0]? o1[0] - o2[0] : o2[1] - o1[1];
            }
        });
        System.out.println(Arrays.deepToString(swpLine));
        int minNum = swpLine[0][0];
        int maxNUm = swpLine[swpLine.length - 1][0];
        int nOfIntersections = 0;
        int[] nLine = new int[maxNUm + 1];
        for(int i = 0; i < swpLine.length; i++){
            nOfIntersections += swpLine[i][1];
            if(nLine[swpLine[i][0]] == 0)
                nLine[swpLine[i][0]] = nOfIntersections;
            if(i < swpLine.length - 1){
                for(int j = 1; j < swpLine[i + 1][0] - swpLine[i][0]; j++){
                    nLine[swpLine[i][0] + j] = nOfIntersections;
                }
            }
        }
        System.out.println(Arrays.toString(nLine));
        for(int i = 0; i < points.length; i++){
            if(minNum <= points[i] && points[i] <= maxNUm)
                answer[i] = nLine[points[i]];
            else
                answer[i] = 0;
        }
        return answer;
    }
}
