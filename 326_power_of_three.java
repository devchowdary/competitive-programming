class Solution {
    public boolean isPowerOfThree(int n) {
        int mp3 = 1162261467;
        return n > 0 && mp3 % n == 0;
        
    }
}
