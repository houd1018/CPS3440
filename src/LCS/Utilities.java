package LCS;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Utilities {

    /**
     * This method gets the average value of 100 random array and write result into .txt file
     * 1 stands for BruteFore method
     * 2 stands for TopDown method
     * 3 stands for BottomUp method
     * @param caseRunning Worst, best and average case
     */
    public static void writeResult(char caseRunning){
        FileWriter fileWriter;
        try{
            fileWriter = new FileWriter("D:/" + caseRunning + ".txt");
            double[] res = new double[4];
            for (int i = 100; i <= 3000; i = i + 100){
                //repeat 100 times for each size
                for(int j = 0; j < 100; j++){
                    //res[0]: size of array
                    res[0] = i;
                    if (caseRunning == '1'){
                        res[1] += Timer.BruteForcetTimer(generateStr(i), generateStr(i));
                    }else if (caseRunning == '2'){
                        res[1] += Timer.TopDownTimer(generateStr(i), generateStr(i));
                    }else{
                        res[1] += Timer.BottomUpTimer(generateStr(i), generateStr(i));
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

    /**
     * generate a random string whose max length is 10 and ranging from "A" to "Z"
     * @return a random string
     */
    private static String generateStr(int lengthOfString){
        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // create StringBuffer string
        StringBuilder sb = new StringBuilder(lengthOfString);
        for (int i = 0; i < lengthOfString; i++) {
            int index = (int)(AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }
}
