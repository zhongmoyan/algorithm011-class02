import java.util.Arrays;

/**
 * Created by Administrator on 2020/6/26.
 */
public class Solution {

    public static void rotate(int[] nums, int k) {
        int len=nums.length;
        k=k%len;
        if(k<=0 || nums.length == 0)
            return;


        for(int i=0,j=len-1;i<j;i++,j--){
            swap(nums,i,j);
        }
        //分两次反转
        for(int i=0,j=k-1;i<j;i++,j--){
            swap(nums,i,j);
        }
        for(int i=k,j=len-1;i<j;i++,j--){
            swap(nums,i,j);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public static void main(String[] args) {
        int[] a={1,2,3,4,5,6,7};
        rotate(a,3);
        System.out.println(Arrays.toString(a));
        int [] b={-1,-100,3,99};
        rotate(b,2);
        System.out.println(Arrays.toString(b));

    }

}
