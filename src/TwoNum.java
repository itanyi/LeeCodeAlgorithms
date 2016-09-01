import java.util.HashMap;

/**
 * Created by tanyi on 16/8/26.
 */
public class TwoNum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = {-1, -1};
        HashMap<Integer, Integer> vp = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if(vp.containsKey(other)) {
                res[0] = vp.get(other).intValue();
                res[1] = i;
                break;
            }
            vp.put(Integer.valueOf(nums[i]), Integer.valueOf(i));
        }

        return res;
    }

    public void test(int [] nums) {
        nums[0] = -1;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4};

        TwoNum s = new TwoNum();
        /*int [] res = s.twoSum(nums,6);
        System.out.println(res[0] + " " + res[1]);
        */
        s.test(nums);
        System.out.println(nums[0]);
    }
}
