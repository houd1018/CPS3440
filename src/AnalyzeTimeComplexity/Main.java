package AnalyzeTimeComplexity;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
       writeResult('W');
    }

    /**
     * This method gets the average value of 100 random array and write result into .txt file
     * @param caseRunning Worst, best and average case
     */
    private static void writeResult(char caseRunning){
        FileWriter fileWriter;
        try{
            fileWriter = new FileWriter("D:/" + caseRunning + ".txt");
            double[] res = new double[6];
            for (int i = 100; i <= 5000; i = i + 100){
                //repeat 100 times for each size
                for(int j = 0; j < 100; j++){
                    //res[0]: size of array
                    res[0] = i;
                    res[1] += Timer.selectionSortTimer(generateArr(i, caseRunning));
                    res[2] += Timer.insertSortTimer(generateArr(i, caseRunning));
                    res[3] += Timer.mergeSortTimer(generateArr(i, caseRunning));
                    res[4] += Timer.theoryNTimer(i);
                    res[5] += Timer.theoryNSquareTimer(i);
                }
                //get average value
                for(int k = 1; k < res.length; k++){
                    res[k] = res[k] / 100;
                }
                System.out.println(Arrays.toString(res));
                fileWriter.write(Arrays.toString(res).replace("[","").replace("]","") + "\r\n");
            }
            fileWriter.flush();
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * This method generates arrays in different size and cases.
     * @param size The size of array.
     * @param caseRunning Worst, best and average case
     */
    private static int[] generateArr(int size, char caseRunning){
        int[] arr = new int[size];
        for(int i = 0; i < arr.length; i++){
            arr[i] = (int)(Math.random()*100+1);
        }
        if(caseRunning == 'B'){
            Arrays.sort(arr);
            return arr;
        }
        else if(caseRunning == 'W'){
            Integer[] temp = Arrays.stream(arr).boxed().toArray(Integer[]::new);
            Arrays.sort(temp, Collections.reverseOrder());
            arr = Arrays.stream(temp).mapToInt(Integer::byteValue).toArray();
            return arr;
        }
        else{
            return arr;
        }
    }
}
