/**
 * Created by tanyi on 16/8/27.
 */
public class Median {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int medianI = -1;
        int medianJ = -1;
        int resI = -1;
        int resJ = -1;
        int sum = m+n;
        medianI = sum / 2;
        if(sum % 2 == 0) {
            medianJ = medianI;
            medianI -= 1;
        }
        int i = 0;
        int j = 0;
        int inx = 0;
        int cur1 = -1;
        int cur2 = -1;
        int cur = -1;
        while(i < m || j < n) {
            if(i >= m) {
                cur1 = -1;
            }else {
                cur1 = nums1[i];
            }
            if(j >= n) {
                cur2 = -1;
            }else {
                cur2 = nums2[j];
            }
            if(cur1 != -1 && cur2 != -1) {
                if(cur1 <= cur2) {
                    i++;
                    cur = cur1;
                }else {
                    j++;
                    cur = cur2;
                }
            }
            else if(cur1 == -1 && cur2 != -1) {
                j++;
                cur = cur2;
            }else {
                i++;
                cur = cur1;
            }
            if(inx == medianI) {
                resI = cur;
                if(medianJ == -1) {
                    resJ = -1;
                    break;
                }
            }
            if(inx == medianJ) {
                resJ = cur;
                break;
            }
            inx ++;
        }
        if(sum % 2 == 0) {
            return (resI + resJ) / 2.0;
        }
        return resI;
    }
    public static void main(String[] args) {
        Median median = new Median();
        int [] nums1 = {1,3};
        int [] nums2 = {2,4};
        System.out.println(median.findMedianSortedArrays(nums1, nums2));
    }
}
