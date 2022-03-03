import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.FileInputStream;


class Solution20
{
    public static String[][] arr;
    public static boolean[][] visited;
    public static int N;
    public static int[][] dir = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};


    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int answer = 0;
            N = sc.nextInt();
            arr = new String[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                arr[i] = sc.next().split("");
            }

            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    if (arr[row][col].equals(".") & !visited[row][col]) {
                        answer += 1;
                        bfs(row, col);
                    }
                }
            }

            System.out.printf("#%d %d\n", test_case, answer);
        }
    }

    private static void bfs(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        visited[row][col] = true;

        while (!queue.isEmpty()){
            boolean pass = false;
            int[] now = queue.poll();
            int x = now[0], y = now[1];

            if(!checkBomb(x, y)){
                pass = true;
            }

            for(int[] d : dir){
                int nx = x + d[0];
                int ny = y + d[1];

                if(0 <= nx & nx < N & 0 <= ny & ny < N ){
                    if(!visited[nx][ny] & arr[nx][ny].equals(".")){
                        if(!checkBomb(nx, ny)) { //주변에 지뢰가 없는 값이면 무조건 추가
                            queue.add(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                        else if(pass) {//주변에 지뢰가 있지만 현재 위치 주변에는 지뢰가 없으므로 visit 체크가능
                            visited[nx][ny] = true;
                        }
                    }

                }
            }

        }
    }

    private static boolean checkBomb(int row, int col) {
        for(int[] d: dir) {
            int ax = row + d[0];
            int ay = col + d[1];

            if (0 <= ax & ax < N & 0 <= ay & ay < N) {
                if (arr[ax][ay].equals("*")) {
                    return true;
                }
            }
        }
        return false;
    }
}