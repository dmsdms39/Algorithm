import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution12
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[][] dp = new int[N+1][K+1];

            for(int i = 0; i < N; i++){
                int v = sc.nextInt();
                int c = sc.nextInt();

                for (int j = 1; j <= K; j++) {
                    //들어갈 수 있는 최대 부피보다 현재 물건 부피가 클 때.
                    if (v > j){
                        //이전 무게에 담은 가치와 동일함
                        dp[i+1][j] = dp[i][j];
                    }
                    else{
                        dp[i+1][j] = Math.max(dp[i][j], dp[i][j-v] + c);
                    }
                }
            }

            System.out.printf("#%d %d\n", test_case, dp[N][K]);


        }
    }
}