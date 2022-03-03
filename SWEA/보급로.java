import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Solution33
{
//    private static final int MAX_VAL = 90000;

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = Integer.parseInt(br.readLine());
            String[][] matrix = new String[N][N];
            int[][] dp = new int[N][N];
            boolean[][] visited = new boolean[N][N];
            int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
            Queue<int[]> queue = new LinkedList<>();

            for (int i = 0; i < N; i++) {
//                Arrays.fill(dp[i], MAX_VAL);
                matrix[i] = br.readLine().split("");
            }

            dp[0][0] = Integer.parseInt(matrix[0][0]);
            visited[0][0] = true;
            queue.offer(new int[]{0, 0});

            while(!queue.isEmpty()){
                int[] now = queue.poll();
                int x = now[0];
                int y = now[1];

                for(int[] d: dir){
                    int nx = x + d[0];
                    int ny = y + d[1];
                    if(0 <= nx & nx < N & 0 <= ny & ny < N){

                        int nowDist = dp[x][y] + Integer.parseInt(matrix[nx][ny]);

                        if(!visited[nx][ny] | nowDist < dp[nx][ny]) {
                            visited[nx][ny] = true;
                            queue.offer(new int[]{nx, ny});
                            dp[nx][ny] = nowDist;
                        }
                    }
                }
            }
            System.out.printf("#%d %d\n", test_case, dp[N-1][N-1]);
        }
    }
}