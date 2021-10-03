package RBTree;

import AnalyzeTimeComplexity.Timer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Utilities {
    /**
     * This method generates arrays in different size and cases.
     * @param size The size of array.
     */
    public static int[] generateArr(int size){
        int[] arr = new int[size];
        for(int i = 0; i < arr.length; i++){
            arr[i] = (int)(Math.random()*100+1);
        }
        return arr;
    }

    /**
     * This method gets the average value of 100 random array and write result into .txt file
     * @param caseRunning Worst, best and average case
     */
    public static void writeResult(char caseRunning, RedBlackTree rbt){
        FileWriter fileWriter;
        try{
            fileWriter = new FileWriter("D:/" + caseRunning + ".txt");
            double[] res = new double[4];
            for (int i = 100; i <= 5000; i = i + 100){
                //repeat 100 times for each size
                for(int j = 0; j < 100; j++){
                    //res[0]: size of array
                    res[0] = i;
                    if (caseRunning == 'c'){
                        res[1] += RBTree.Timer.constructionTimer(generateArr(i), rbt);
                    }else if (caseRunning == 's'){
                        res[1] += RBTree.Timer.searchTimer(generateArr(i), rbt);
                    }else{
                        res[1] += RBTree.Timer.insertionTimer(generateArr(i), rbt);
                    }
                    res[2] += Timer.theoryNTimer(i);
                    res[3] += Timer.theoryNSquareTimer(i);
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
}
