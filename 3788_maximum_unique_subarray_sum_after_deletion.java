class Solution {
    public int maxSum(int[] nums) {

        int[][] list = new int[nums.length][2];
        int sum = 0;
        int largestNegative = 0;
        boolean zeroExists = false;

        if (nums.length == 1) {
            return nums[0];
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
               if (list[j][1] < 1 && list[j][0] == 0) {
                    list[j][0] = nums[i];
                    list[j][1] += 1;
                    break;
                } 
                if (list[j][1] >= 1 && list[j][0] == nums[i]) {
                    list[j][1] += 1;
                    break;
                } 
            }
        }

        for (int i = 0; i < list.length; i++) {
            if (list[i][0] > 0) {
                sum += list[i][0];
            }
            if (list[i][0] == 0 && list[i][1] >= 1) {
                zeroExists = true;
            }
            for (int j = 0; j < list[i].length; j++) {
                System.out.print(list[i][j] + " ");
            }
            System.out.println();
        }

        if (sum <= 0 && !zeroExists) {
            for (int num : nums) {
                if (num < 0 && (largestNegative == 0 || num > largestNegative)) {
                    largestNegative = num;
                }
            }
            return largestNegative;
        } else {
            return sum;
        }
        
    }
}