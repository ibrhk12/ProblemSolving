import java.util.Arrays;

public class DailyTempraturesArray {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Arrays.fill(answer, 0);
        int maxTemp = 29;
        for(int i = temperatures.length - 1; i >= 0; i--){
            if(temperatures[i] >= maxTemp){
                maxTemp = temperatures[i];
                continue;
            }
            int search = 1;
            while(temperatures[i + search] <= temperatures[i]){
                search += answer[i + search];
            }
            answer[i] = search;
        }
        return answer;
    }
}
/*
[73, 74, 75, 71, 69, 72, 76, 73]
[0 , 0 , 4 , 2 , 1 , 1 , 0 , 0 ]
* */