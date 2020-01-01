package com.grv.day01;

/**
 * @author Gaurav Rajput
 * Created on 30/12/19
 *
 * @link
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 *
 * Time Complexity : O(log n)
 * Space Complexity : O(1)
 *
 */
class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums.length == 0)
            return -1;
        else if(nums.length == 1)
            return target == nums[0] ? 0 : -1;

        if(nums[0] <  nums[nums.length - 1]) {
            return binarySearch(nums, target, 0, nums.length - 1);
        } else {
            int pivot = findPivot(nums);

            if (nums[pivot] == target)
                return pivot;
            int resIndex = binarySearch(nums, target, 0, pivot - 1);
            if(resIndex == -1) {
                resIndex = binarySearch(nums, target, pivot, nums.length - 1);
            }
            return resIndex;
        }
    }

    public int findPivot(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(mid == nums.length - 1)
                return mid;
            else if(mid == 0 && nums[mid] > nums[mid + 1]) {
                return mid + 1;
            }
            if(nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                return mid;
            }

            if(nums[0] < nums[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }

    private int binarySearch(int[] a, int target, int start, int end) {
        while(start <= end) {
            int mid = start + (end - start)/ 2;
            if(a[mid] == target)
                return mid;

            if(a[mid]< target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }
}