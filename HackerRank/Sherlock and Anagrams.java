import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        HashMap <String, Integer> map = new HashMap<String, Integer>();
        int res = 0;
        for(int i=0;i<s.length();i++)
            for(int j=i+1;j<=s.length();j++)
            {
                int value = 0 ;
                String[] temparr = (s.substring(i,j)).split("");
                String subString = "";
                Arrays.sort(temparr);
                for(int k=0;k<temparr.length;k++)
                    subString += temparr[k];
                
                if(map.containsKey(subString)){
                    value = map.get(subString);
                }
                map.put(subString, value+1) ;
                System.out.println(subString);
            }
        Set key = map.keySet();

        for(Iterator iterator = key.iterator();iterator.hasNext();){
            String Key = (String)iterator.next();
            int value = map.get(Key);
            if(value>1)//value 2부터 조합을 만들 수 있음
                res += value*(value-1)/2;
        }

        return res;
    

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
