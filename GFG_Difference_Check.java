import java.util.*;

class Solution {
    public int minDifference(String[] arr) {
        int n = arr.length;
        int[] timeInSeconds = new int[n];

        for (int i = 0; i < n; i++) {
            timeInSeconds[i] = convertToSeconds(arr[i]);
        }

        Arrays.sort(timeInSeconds);

        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            minDiff = Math.min(minDiff, timeInSeconds[i] - timeInSeconds[i - 1]);
        }

        int wrapAroundDiff = 86400 - timeInSeconds[n - 1] + timeInSeconds[0];
        minDiff = Math.min(minDiff, wrapAroundDiff);

        return minDiff;
    }

    private int convertToSeconds(String time) {
        String[] parts = time.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        int s = Integer.parseInt(parts[2]);
        return h * 3600 + m * 60 + s;
    }
}

