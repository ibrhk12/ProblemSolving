public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] answer = new int[nums1.length];
        int[] indexJs = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++)
            for (int j = 0; j < nums2.length; j++)
                if (nums1[i] == nums2[j])
                    indexJs[i] = j;
        int next = -1;
        int count = 0;
        for (int j = 0; j < indexJs.length; j++) {
            next = -1;
            for (int k = indexJs[j] + 1; k < nums2.length; k++)
                if(nums2[k] > nums2[indexJs[j]]){
                    next = nums2[k];
                    break;
                }
            answer[count ++ ] = next;
        }
        return answer;
    }
}
