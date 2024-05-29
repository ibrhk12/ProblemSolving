public class TrappingRainWaterArray1 {
    public int trap(int[] height) {
        int result = 0;
        int maxLeft;
        int maxRight;
        for(int i = 0; i < height.length; i ++){
            maxLeft = 0;
            maxRight = 0;
            for(int j = i; j >= 0; j--)
                maxLeft = Math.max(maxLeft, height[j]);
            for(int j = i; j < height.length; j++)
                maxRight = Math.max(maxRight, height[j]);
            result += Math.min(maxLeft, maxRight) - height[i];
        }
        return result;
    }
}
