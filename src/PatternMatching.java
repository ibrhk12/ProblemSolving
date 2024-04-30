public class PatternMatching {
    public int countMatching(int[] input, int[] pattern){
        int answer = 0;
        for(int i = 1; i < input.length - pattern.length + 1; i++){
            boolean isMatch = false;
            for(int j = i; j < pattern.length + i; j++){
                if(input[j] == input[j - 1] && pattern[j - i] != 0) {
                    isMatch = false;
                    break;
                }
                else if(input[j] > input[j - 1] && pattern[j - i] != 1){
                    isMatch = false;
                    break;
                }
                else if(input[j] < input[ j - 1] && pattern[j - i] != -1) {
                    isMatch = false;
                    break;
                }
                isMatch = true;
            }
            if (isMatch)
                answer++;
        }
        return answer;
    }
}
