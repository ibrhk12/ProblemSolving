public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int intendedSum = n * (n + 1) / 2;
        int acctualSum = 0;
        for(int i : nums)
            acctualSum += i;
        return intendedSum - acctualSum;
    }
}
