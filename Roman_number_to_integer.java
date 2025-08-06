class Solution {
    public int romanToDecimal(String s) {
        Map<Character, Integer> map = Map.of(
            'I', 1, 'V', 5, 'X', 10,
            'L', 50, 'C', 100,
            'D', 500, 'M', 1000
        );

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int curr = map.get(s.charAt(i));
            int next = (i + 1 < s.length()) ? map.get(s.charAt(i + 1)) : 0;

            if (curr < next) sum -= curr;
            else sum += curr;
        }
        return sum;
    }
}

