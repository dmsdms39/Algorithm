import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the triplets function below.
    static long triplets(int[] a, int[] b, int[] c) {

        long res = 0;

        int[] A = remove(a);
        int[] B = remove(b);
        int[] C = remove(c);
        
        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);

        for(int i : B)//B를 기준으로
        {
            long a1 = get(A, i);//A에 i 이하인 숫자 갯수
            long c1 = get(C, i);//C에 위피한 i 이하인 숫자
            res += a1 * c1;
        }

        return res;
    }

    private static int[] remove(int[] a){
        Set <Integer> set = new HashSet<>();
        for(int i : a)
            set.add(i);

        int len = set.size();

        int result[] = new int[len];

        int cnt = 0;

        for(int item : set){
            result[cnt++] = item;
        }

        return result;

    }

    static int get(int[] arr, int std){
        int low = 0;
        int high = arr.length - 1;
        int count = 0;

        while(low <= high){
            //정렬된 배열이므로 중간부터 탐색해서 카운트함
            int mid = low + (high-low)/2;
            // 숫자보다 작으면 mid를 반환할 생각해주면서 하나씩 높여감
            if(arr[mid] <= std){
                count = mid + 1;//mid는 index라서
                low = mid +1;//그 다음자리도 비교해볼라고
            }
            else
                high = mid - 1;
        }

        return count;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] lenaLenbLenc = scanner.nextLine().split(" ");

        int lena = Integer.parseInt(lenaLenbLenc[0]);

        int lenb = Integer.parseInt(lenaLenbLenc[1]);

        int lenc = Integer.parseInt(lenaLenbLenc[2]);

        int[] arra = new int[lena];

        String[] arraItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lena; i++) {
            int arraItem = Integer.parseInt(arraItems[i]);
            arra[i] = arraItem;
        }

        int[] arrb = new int[lenb];

        String[] arrbItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenb; i++) {
            int arrbItem = Integer.parseInt(arrbItems[i]);
            arrb[i] = arrbItem;
        }

        int[] arrc = new int[lenc];

        String[] arrcItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenc; i++) {
            int arrcItem = Integer.parseInt(arrcItems[i]);
            arrc[i] = arrcItem;
        }

        long ans = triplets(arra, arrb, arrc);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
