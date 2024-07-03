package GoldmanSachs.CodePairRound;

import java.util.ArrayList;
import java.util.List;
/*
https://leetcode.com/problems/median-of-two-sorted-arrays/description/

Given two sorted arrays nums1 and nums2 of size m and n respectively,
return the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.(For odd resulted array we should return middle element)

 */
public class MedianOfTwoSortedArray {

    public static void main(String[] args){
        int[] A = new int[]{1,3,5};
        int[] B = new int[]{2,4};
        System.out.println("Median: "+ findMedianSortedArraysMySolution(A, B));
        System.out.println("Median Eff: "+ findMedianSortedArraysEfficient(A, B));
        int[] A1 = new int[]{1,2};
        int[] B1 = new int[]{3,4};
        System.out.println("Median: "+ findMedianSortedArraysMySolution(A1, B1));
        System.out.println("Median Eff: "+ findMedianSortedArraysEfficient(A1, B1));
    }
    public static double findMedianSortedArraysMySolution(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        int a=nums1.length, b=nums2.length, i=0, j=0;
        while(i<a && j<b){
            if(nums1[i]<nums2[j]){
                list.add(nums1[i]);
                i++;
            }
            else{
                list.add(nums2[j]);
                j++;
            }
        }
        while(i<a){
            list.add(nums1[i]);
            i++;
        }
        while(j<b){
            list.add(nums2[j]);
            j++;
        }
        int n=list.size()/2;
        if(list.size() % 2 != 0)
            return list.get(n) * 1.0;
        return (list.get(n) + list.get(n-1)) / 2.0;
    }
    public static double findMedianSortedArraysEfficient(int[] nums1, int[] nums2) {
        int a=nums1.length, b=nums2.length, i=0, j=0, m1=0,m2=0;
        for(int cnt=0;cnt<=(a+b)/2;cnt++){
            m2=m1;
            if(i!=a && j!=b){
                if(nums1[i] > nums2[j])
                    m1 = nums2[j++];
                else
                    m1 = nums1[i++];
            }
            else if(i<a)
                m1 = nums1[i++];
            else
                m1 = nums2[j++];
        }

        if((a+b) % 2 != 0)
            return m1 * 1.0;
        return (m1+m2) / 2.0;
    }
}
