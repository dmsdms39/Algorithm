import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {
        
        int sum = 0;

        Arrays.sort(contests, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                return -1 * Integer.compare(arr1[0],arr2[0]);
                // if( arr1[0] > arr2[0] )
                //     return -1;//값 크면 변경..
                // else
                //     return 1;
            }
        });
        //-1* Integer.compare(arr1[0],arr2[0]);사용해도됨

        

        for(int i = 0; i < contests.length ; i++)
        {
            int luck = contests[i][0];
            int importance = contests[i][1];

            if( importance==1 )
                if(k > 0){
                    sum += luck;
                    k--;
                }
                else
                    sum-= luck;
           
            else
                sum += luck;
                
            // System.out.println("luck : "+ luck);
            // System.out.println("importance : "+ importance);
        }

        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
