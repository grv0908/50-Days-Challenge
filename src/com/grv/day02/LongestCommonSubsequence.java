package com.grv.day02;

/**
 * @author Gaurav Rajput
 * Created on 31/12/19
 *
 *
 */
class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][ j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }

    public int lcs (String text1,  String text2, int index1, int index2) {
        if (index1 == 0 || index2 == 0)
            return 0;

        if (text1.charAt(index1 - 1) == text2.charAt(index2 - 1)) {
            return 1 + lcs (text1, text2, index1 - 1, index2 - 1);
        } else {
            return Math.max(lcs(text1, text2, index1 - 1, index2), lcs(text1, text2, index1, index2 - 1));
        }
    }
}
