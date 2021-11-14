package LCS;

import java.util.ArrayList;
import java.util.List;

public class LCS_BruteForce {

    //store all sub sequences
    private static List<String> al = new ArrayList<>();

    /**
     * Compare the each subString with different leading characters with subsequence in the array list.
     * Return the longest common subsequence.
     * @param s1 String that will be divided into #digits different substring
     * @param s2 indicates the string that divided into subsequences
     * @return longest subsequence
     */
    public static String lcs(String s1, String s2) {
        //refresh the array list to prepare for next string
        al.clear();
        int LCSLength = 0;
        String longestString = "";
        findSubsequences(s2, "");
        for (int i = s1.length(); i > 0; i--) {
            String str = s1.substring(0, i);
            for (int j = 0; j < al.size(); j++) {
                int Length = isSubsequence(str, al.get(j));
                if (Length > LCSLength) {
                    LCSLength = Length;
                    longestString = al.get(j);
                }
            }
        }
        return longestString;
    }

    /**
     *This function will check the whether the subsequence is contained in the s1,
     * if it is not in s1, then return 0. Otherwise, return the length of s2.
     * @param s1 String that will be divided into #digits different substring
     * @param s2 indicates the string that divided into subsequences
     * @return the #digits of current subsequence
     */
    private static int isSubsequence(String s1, String s2) {
        int LCSLength = 0;
        for (int i = 0; i < s2.length(); i++) {
            if (s1.contains("" + s2.charAt(i))) {
                LCSLength++;
                s1 = s1.substring(s1.indexOf(s2.charAt(i)) + 1);
            } else {
                LCSLength = 0;
                break;
            }
        }
        return LCSLength;
    }

    /**
     *find each subsequence recursively
     * @param s s2 which indicates the string that divided into subsequences
     * @param ans value that is added into Array list
     */
    private static void findSubsequences(String s, String ans) {
        if (s.length() == 0) {
            al.add(ans);
            return;
        }

        findSubsequences(s.substring(1), ans + s.charAt(0));
        findSubsequences(s.substring(1), ans);
    }
}
