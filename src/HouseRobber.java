public class HouseRobber {
    int cache[];
    public int rob(int[] nums) {
        cache= new int[nums.length];
        for (int i= 0; i < nums.length; i++){
            cache[i]= -1;
        }
        return rob(nums, 0);
    }
    private int rob(int[] nums, int i){
        //base
        if (i >= nums.length) return 0;
        if (cache[i] != -1) return cache[i];
        else{
            int tmp1= nums[i] + rob(nums, i+2);
            int tmp2= rob(nums, i+1);
            if (tmp1 > tmp2){
                cache[i]= tmp1;
                return tmp1;
            }
            cache[i]= tmp2;
            return tmp2;
        }
    }
    public static void main(String[] args){
        HouseRobber h= new HouseRobber();
        int sol= h.rob(new int[]{1, 2, 3, 1});
        System.out.println("sol is "+sol);
    }
}
