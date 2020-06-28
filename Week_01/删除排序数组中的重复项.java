import java.util.Arrays;

/**
 * Created by Administrator on 2020/6/26.
 */
public class Solution {

    public static int removeDuplicates(int[] nums) {
        //快慢指针
        int index=0;
        for(int j=1;j<nums.length;j++){
            if(nums[j]!=nums[index])
                nums[++index]=nums[j];
        }
        return index+1;
    }




    public static void main(String[] args) {
        int[] a={1,1,2};
        System.out.println(removeDuplicates(a));
        System.out.println(Arrays.toString(a));
        int [] b={0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(b));
        System.out.println(Arrays.toString(b));
    }

}
