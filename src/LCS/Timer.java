package LCS;

public class Timer {

    public static long BruteForcetTimer(String s1, String s2) {
        long begin = System.currentTimeMillis();
        LCS_BruteForce.lcs(s1, s2);
        long end = System.currentTimeMillis();
        return end - begin;
    }

    public static long TopDownTimer(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m][n];

        long begin = System.currentTimeMillis();
        LCS_TopDown.lcs(s1, s2, m, n, dp);
        long end = System.currentTimeMillis();
        return end - begin;
    }

    public static long BottomUpTimer(String s1, String s2) {

        int p = s1.length();
        int q = s2.length();

        long begin = System.currentTimeMillis();
        LCS_BottomUp.lcs(s1, s2, p, q);
        long end = System.currentTimeMillis();
        return end - begin;
    }

    public static long theoryNSquareTimer(int size) {
        int[] temp = new int[size];
        long begin = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                temp[i] = i;
            }
        }
        long end = System.currentTimeMillis();
        return end - begin;
    }

    public static long theoryNTimer(int size) {
        int[] temp = new int[size];
        long begin = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            temp[i] = i;
        }
        long end = System.currentTimeMillis();
        return end - begin;
    }


    public static long theoryNPower2Timer(int n) {
        long begin = System.currentTimeMillis();

        towerOfHanoi(n, 'A', 'C', 'B');

        long end = System.currentTimeMillis();
        return end - begin;
    }


    public static long theoryNPower3Timer(int n) {
        long begin = System.currentTimeMillis();

        NPower3Example(n, 'A', 'C', 'B');

        long end = System.currentTimeMillis();
        return end - begin;
    }

    // basic theory example for 2^N time complexity
    private static void towerOfHanoi(int n, char from_rod,
                                     char to_rod, char aux_rod) {
        if (n == 1) {
            return;
        }
        towerOfHanoi(n - 1, from_rod, aux_rod, to_rod);
        towerOfHanoi(n - 1, aux_rod, to_rod, from_rod);
    }

    // basic theory example for 3^N time complexity
    private static void NPower3Example(int n, char from_rod,
                                       char to_rod, char aux_rod) {
        if (n == 1) {
            return;
        }
        NPower3Example(n - 1, from_rod, aux_rod, to_rod);
        NPower3Example(n - 1, aux_rod, to_rod, from_rod);
        NPower3Example(n - 1, to_rod, from_rod, aux_rod);
    }

}
