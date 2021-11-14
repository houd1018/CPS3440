package LCS;

public class LCS_TopDown {

    /**
     * memoization applied in recursive solution
     * @param X first string
     * @param Y second string
     * @param m non-constant arguments which indicates the potion in first string
     * @param n non-constant arguments which indicates the potion in second string
     * @param dp memoization array which stores the already computed data
     * @return length of LCS
     */
    public static int lcs(String X, String Y, int m, int n, int dp[][]) {
        // base case
        if (m == 0 || n == 0) {
            return 0;
        }

        // if the same state has already been
        // computed
        if (dp[m - 1][n - 1] != -1) {
            return dp[m - 1][n - 1];
        }

        // if equal, then we store the value of the
        // function call
        if (X.charAt(m - 1) == Y.charAt(n - 1)) {

            // store it in arr to avoid further repetitive
            // work in future function calls
            dp[m - 1][n - 1] = 1 + lcs(X, Y, m - 1, n - 1, dp);

            return dp[m - 1][n - 1];
        } else {

            // store it in arr to avoid further repetitive
            // work in future function calls
            dp[m - 1][n - 1] = Math.max(lcs(X, Y, m, n - 1, dp),
                    lcs(X, Y, m - 1, n, dp));

            return dp[m - 1][n - 1];
        }
    }
}
