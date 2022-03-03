import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//16번
class Solution16
{
    public static void main(String args[]) throws Exception
    {
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T;
        T= Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int L = Integer.parseInt(br.readLine());
            int N = Integer.parseInt(br.readLine());
            ArrayList<int[]> SandE = new ArrayList<>();

            for (int se = 0; se < N; se++) {
                SandE.add(Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray());//한줄 한줄 int로 바꾸기, stream 오래걸리면 나중에 바꿔도 됌
            }

            for(int[] a: SandE){
                System.out.println(a[0]+" "+a[1]);
            }

        }
    }
}