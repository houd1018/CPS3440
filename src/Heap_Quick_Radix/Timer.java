package Heap_Quick_Radix;


public class Timer {

    public static long heapSortTimer(int[] arr){
        long begin = System.currentTimeMillis();
        HeapSort.heapSort(arr);
        long end = System.currentTimeMillis();
        return end - begin;
    }

    public static long quickSortTimer(int[] arr){
        long begin = System.currentTimeMillis();
        QuickSort.quickSort(arr, 0, arr.length - 1);
        long end = System.currentTimeMillis();
        return end - begin;
    }

    public static long radixSortTimer(int[] arr){
        long begin = System.currentTimeMillis();
        RadixSort.radixsort(arr, arr.length);
        long end = System.currentTimeMillis();
        return end - begin;
    }

    public static long theoryNlogNTimer(int size){
        int[] temp = new int[size];
        long begin = System.currentTimeMillis();
        for(int i = 0; i < size; i++){
            for(int j = size - 1; j > 0; j = j / 2){
                temp[j] = i;
            }
        }
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
