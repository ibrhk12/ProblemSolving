public class MissingNumberBitManipulation {
    public int missingNumber(int[] nums) {
        int missingNumber = 0;
        for(int i = 0; i <= nums.length; i++)
            missingNumber ^= i ^ nums[i];
        return missingNumber;
    }
}
