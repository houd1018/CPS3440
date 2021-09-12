package AnalyzeTimeComplexity;

/**
 * This class is for recording time in each algorithm
 */
public class Timer {

    public static long selectionSortTimer(int[] arr){
        long begin = System.currentTimeMillis();
        SelectionSort.selectSort(arr);
        long end = System.currentTimeMillis();
        return end - begin;
    }

    public static long insertSortTimer(int[] arr){
        long begin = System.currentTimeMillis();
        InsertionSort.insertSort(arr);
        long end = System.currentTimeMillis();
        return end - begin;
    }

    public static long mergeSortTimer(int[] arr){
        long begin = System.currentTimeMillis();
        MergeSort.mergeSort(arr, 0, arr.length -1);
        long end = System.currentTimeMillis();
        return end - begin;
    }

    public static long theoryNTimer(int size){
        int[] temp = new int[size];
        long begin = System.currentTimeMillis();
        for(int i = 0; i < size; i++){
            temp[i] = i;
        }
        long end = System.currentTimeMillis();
        return end - begin;
    }

    public static long theoryNSquareTimer(int size){
        int[] temp = new int[size];
        long begin = System.currentTimeMillis();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                temp[i] = i;
            }
        }
        long end = System.currentTimeMillis();
        return end - begin;
    }
}
