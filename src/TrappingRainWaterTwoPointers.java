public class TrappingRainWaterTwoPointers {
    public int trap(int[] height) {
        int result = 0;
        int left = 0, right = height.length - 1;
        int maxLeft = height[0], maxRight = height[height.length - 1];
        while(left < right){
            if(maxLeft < maxRight){
                left ++;
                maxLeft = Math.max(maxLeft, height[left]);
                result += maxLeft - height[left];
            }
            else{
                right --;
                maxRight = Math.max(maxRight, height[right]);
                result += maxRight - height[right];
            }
        }
        return result;
    }
}
