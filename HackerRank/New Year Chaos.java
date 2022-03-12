import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {

        int count = 0;
        boolean isChaotic = false;


        for(int i = q.length - 1 ; i > -1  ; i-- )
        {
            //최대로 멀어져도 앞으로는 두 칸 밖에 못감(큰 숫자부터 정렬 되면서..)
            int number = i+1;
            if(q[i] != number){
                
                //한 칸 새치기 한 경우
                if(i > 0 && q[i-1] == number){
                    q[i-1] = q[i];
                    q[i] = number;
                    count++;
                }      
                // 두 칸 앞으로 새치기 한 경우
                else if(i > 1 && q[i-2] == number){
                    q[i-2] = q[i-1];
                    q[i-1] = q[i];
                    q[i] = number;
                    count+=2;
                }

                else{
                    isChaotic = true;
                    System.out.println("Too chaotic");
                    break;
                }
            }
        }

        if(!isChaotic)
           System.out.println(count);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
