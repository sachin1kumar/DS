package array;

public class FindDuplicateInArray {

    public static void main(String[] args) {
        int[] input = {3,1,3,4,2};
        System.out.println(findDuplicate(input));
    }

    private static int findDuplicate(int[] nums) {
        //Using Floyd's Algorithm with O(n) time complexity with the constant space.

        //Fist both slow and fast pointers are at the index 0..
        int slow = nums[0];
        int fast = nums[0];

        do {
            //increment slow pointer slowly.
            slow = nums[slow];
            if (nums[fast] > nums.length) {
                break;
            }
            //increment fast pointer fastly.
            fast = nums[nums[fast]];
        } while(slow != fast);

        //Now, set ptr1 which is our new slow pointer to the 0th Index.
        //And assign fast pointer to the new var i.e. ptr2.
        int ptr1 = nums[0];
        int ptr2 = fast;
        while (ptr1 != ptr2)
        {
            //Now, increment both pointers slowly..
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }

        return ptr1;
    }
}
