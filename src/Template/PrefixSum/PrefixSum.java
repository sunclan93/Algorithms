package Template.PrefixSum;

public class PrefixSum {
    /*
    *  Temp 1: size = N
    * */
    public void temp1(int[] nums) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
    }
    /*
    *  Temp 2: size = N + 1
    * */
    public void temp2(int[] nums) {
        int[] sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

}
