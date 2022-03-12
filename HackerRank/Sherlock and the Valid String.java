import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.Arrays.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {
        
        String answer;
        int arr[] = new int[26];
        int use = 0;

        for(int i=0 ; i < s.length() ; i++){
            arr[s.charAt(i)-'a']++;
        }

        Arrays.sort(arr);

        for(int i = 0; i < 26 ; i++){
            
            if(arr[i] > 0){
                use = i;
                break;
            }
        }

        if(arr[use]==arr[25])
            answer = "YES";
        
            else if((arr[use] == 1 ||arr[use] + 1 == arr[use+1]) && arr[use+1] == arr[25])
            //맨 앞에 숫자만 1 차이 나는 경우 or 하나만 1인 경우
            answer = "YES";

        else if(arr[use] == arr[24] && arr[24] + 1 == arr[25])//맨 뒤에 숫자만 1 차이 나는 경우
            answer = "YES";
        
        else if(use == 25)//사용한 문자가 하나인 경우
            answer = "YES";

        else
            answer = "NO";

        return answer;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
