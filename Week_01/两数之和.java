package com.sjf.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2020/6/26.
 */
public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");


//        //错误，题意要的是下标，排序后下标错乱
//        //加个map保存下标
//        HashMap<Integer,Integer> map = new HashMap<>();
//        for (int i=0;i<nums.length;i++){
//            map.put(nums[i],i);
//        }
//        // 排序，快慢指针
//        Arrays.sort(nums);
//        int[] res=new int[2];
//        for(int i=0,j=nums.length-1;i<j;){
//            if(nums[i]+nums[j]==target){
//                res[0]=nums[i];
//                res[1]=nums[j];
//                break;
//            }else if(nums[i]+nums[j]<target){
//                do{
//                    i++;
//                }while (nums[i]==nums[i+1]);//去重
//            }else {
//                do{
//                    j--;
//                }while (nums[j]==nums[j-1]);//去重
//            }
//        }
//        res[0]=map.get(res[0]);
//        res[1]=map.get(res[1]);
//        return res;
    }



    public static void main(String[] args) {
//        int[] nums={2, 7, 11, 15};
        int[] nums={3, 3};
        int[] res=twoSum(nums,6);
        System.out.println(Arrays.toString(res));


    }

}
