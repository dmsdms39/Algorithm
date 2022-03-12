import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minTime function below.
    static long minTime(long[] machines, long goal) {
        long minpp = machines[0];
        long maxpp = machines[0];
        long mindays;
        long maxdays;

        for(int i = 0; i < machines.length; i++){
            minpp = Math.min(minpp, machines[i]);
            maxpp = Math.max(maxpp, machines[i]);
        }
        mindays = goal*minpp/machines.length;//2분의 1씩 만듬
        maxdays = goal*maxpp/machines.length;

        while(mindays != maxdays){
            long mid = (mindays + maxdays)/2; 
            long production = 0;

            for(int i =0; i< machines.length;i++)
                production += mid/machines[i];

            if(production < goal)
                mindays = mid+1;
            else//같거나 많다면 최대값 변경
                maxdays = mid;
        }
        
        return mindays;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nGoal = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nGoal[0]);

        long goal = Long.parseLong(nGoal[1]);

        long[] machines = new long[n];

        String[] machinesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long machinesItem = Long.parseLong(machinesItems[i]);
            machines[i] = machinesItem;
        }

        long ans = minTime(machines, goal);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
