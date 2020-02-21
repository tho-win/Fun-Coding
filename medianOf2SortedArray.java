/**
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalSize = nums1.length + nums2.length;
        boolean isOdd = totalSize%2 == 0 ? false : true;
        int ptr1 = 0, ptr2 = 0;
        int median = totalSize/2 + 1;
        int mostRecent = 0;
        int mostRecentPtr = 0;
        int secondRecent = 0;
        int secondRecentPtr = 0;
        while (ptr1+ptr2 < median) {
            if (ptr1 < nums1.length && ptr2 < nums2.length) {
                if (nums1[ptr1] <= nums2[ptr2]) {
                secondRecent = mostRecent;
                mostRecent = 1;
                secondRecentPtr = mostRecentPtr;
                mostRecentPtr = ptr1;
                ptr1++;    
                }
                else {
                    secondRecent = mostRecent;
                    mostRecent = 2;
                    secondRecentPtr = mostRecentPtr;
                    mostRecentPtr = ptr2;
                    ptr2++;
                }
            }
            else if (ptr1 >= nums1.length) {
                secondRecent = mostRecent;
                mostRecent = 2;
                secondRecentPtr = mostRecentPtr;
                mostRecentPtr = ptr2;
                ptr2++;
            }
            else if (ptr2 >= nums2.length) {
                secondRecent = mostRecent;
                mostRecent = 1;
                secondRecentPtr = mostRecentPtr;
                mostRecentPtr = ptr1;
                ptr1++;
            }
        }
        double median1 = 0, median2 = 0;
        ptr1 = ptr1 >= nums1.length ? ptr1-1 : ptr1;
        ptr2 = ptr2 >= nums2.length ? ptr1-2 : ptr2;
        if (!isOdd){
            if (mostRecent == 1)  median1 = nums1[mostRecentPtr];
            else median1 = nums2[mostRecentPtr];
            if (secondRecent == 1)  median2 = nums1[secondRecentPtr];
            else if (secondRecent == 2) median2 = nums2[secondRecentPtr]; 
            return (median1+median2)/2;
        }
        return (mostRecent == 1 ? nums1[mostRecentPtr] : nums2[mostRecentPtr]);
    }
}
