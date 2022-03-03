import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution11
{
    public static void main(String args[]) throws Exception
    {
		Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        sc.nextLine();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            String[] strings = sc.nextLine().split(" ");
            int row = strings[0].length();
            int col = strings[1].length();
            int[][] dp = new int[row+1][col+1];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (strings[0].charAt(i) == strings[1].charAt(j)) {
                        dp[i + 1][j + 1] = dp[i][j] + 1;
                    }
                    else {
                        dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                    }
                }
            }
            System.out.println("#" + test_case + " "+dp[row][col]);

        }
    }
}