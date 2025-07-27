class Solution {
    public int scoreOfString(String s) {

        char[] charArray = s.toCharArray();
        int curVal = 0;
        int nextVal = 0;
        int sum = 0;

        for (int i = 0; i < s.length() - 1; i++) {

            curVal = (int) charArray[i];
            nextVal = (int) charArray[i + 1];

            sum += Math.abs(curVal - nextVal);
        }

        return sum;
        
    }
}