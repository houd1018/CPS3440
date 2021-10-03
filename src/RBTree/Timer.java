package RBTree;

/**
 * This class is for recording time in each algorithm
 */
public class Timer {

    public static long constructionTimer(int[] arr, RedBlackTree rbt){
        long begin = System.currentTimeMillis();
        for(int i = 0; i < arr.length; i++){
            rbt.insert(arr[i]);
        }
        long end = System.currentTimeMillis();
        return end - begin;
    }

    public static long searchTimer(int[] arr, RedBlackTree rbt){

        for(int i = 0; i < arr.length; i++){
            rbt.insert(arr[i]);
        }

        long begin = System.currentTimeMillis();
        for (int i = 0; i < 10; i++){
            rbt.searchTree((int)(Math.random()*100+1));
        }
        long end = System.currentTimeMillis();
        return end - begin;
    }

    public static long insertionTimer(int[] arr, RedBlackTree rbt){

        for(int i = 0; i < arr.length; i++){
            rbt.insert(arr[i]);
        }

        long begin = System.currentTimeMillis();
        for (int i = 0; i < 10; i++){
            rbt.insert((int)(Math.random()*100+1));
        }
        long end = System.currentTimeMillis();
        return end - begin;
    }
}
