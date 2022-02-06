package lovebabbar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MergeSortedArrSpecialCase {

    public static void main(String[] args) {
        /*int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3; //1,2,2,3,5,6 */
        /*int[] nums1 = {1};
        int m = 1;
        int[] nums2 = {};
        int n = 0; //1*/
        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {1};
        int n = 1; //1
        System.out.print(Arrays.toString(merge(nums1, m, nums2, n)));
    }

    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = nums1.length - 1;

        while (i >=0 && j >=0) {
            if(nums1[i] >= nums2[j]){
                nums1[k] = nums1[i--];
            } else {
                nums1[k] = nums2[j--];
            }
            k--;
        }


        while(i >= 0) {
            nums1[k--] = nums1[i--];
        }

        while(j >= 0) {
            nums1[k--] = nums2[j--];
        }
        return nums1;
    }
}
