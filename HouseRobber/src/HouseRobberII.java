/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
 *              because they are adjacent houses.
 * Example 2:
 *
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 */
public class HouseRobberII {
    int cache[];
    boolean endIncluded;
    public int rob(int[] nums) {
        cache= new int[nums.length];
        endIncluded= false;
        for (int i= 0; i < nums.length; i++){
            cache[i]= -1;
        }
        return rob(nums, 0);
    }
    private int rob(int[] nums, int i){
        System.out.println("i "+i);
        //base
        if (i >= nums.length) return 0;
        if (cache[i] != -1) return cache[i];
        else{
            int tmp1= nums[i] + rob(nums, i+2);
            System.out.println("tmp1 "+tmp1);
            int tmp2= rob(nums, i+1);
            System.out.println("tmp2 "+tmp2);
            if (tmp1 > tmp2) {
                if (i == 0 && endIncluded) return tmp2;
                if (i == nums.length-1) endIncluded = true;
                cache[i] = tmp1;
                return tmp1;
                }
                endIncluded= false;
                cache[i] = tmp2;
                return tmp2;
            }
        }

    public static void main(String[] args){
        HouseRobberII h= new HouseRobberII();
        int sol= h.rob(new int[]{1, 2, 3});
        System.out.println("sol is "+sol);
    }
}
