import java.util.Arrays;

/**
 * Created by Administrator on 2020/6/26.
 */
public class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //1.合并后排序
//        System.arraycopy(nums2,0,nums1,m,n);
//        Arrays.sort(nums1);

        //2.从后往前
        int newLen=m+n;
        int index=newLen-1,i=m-1,j=n-1;
        for(;i>=0 && j>=0;index--){
            nums1[index]=nums1[i]>nums2[j]?nums1[i--]:nums2[j--];
        }
        if(i<0){
            System.arraycopy(nums2,0,nums1,0,j+1);
        }
    }



    public static void main(String[] args) {
        int[] nums1={1,2,3,0,0,0};
        int[] nums2={2,5,6};
        merge(nums1,3,nums2,3);
        System.out.println(Arrays.toString(nums1));


    }

}
