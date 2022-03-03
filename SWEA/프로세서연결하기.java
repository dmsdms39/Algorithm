import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution19
{
    public static int N, minLen, maxCnt;
    public static String[][] board;
    public static ArrayList<int[]> core;
    public static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();


        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = sc.nextInt();
            board = new String[N][N];
            core = new ArrayList<>();
            minLen = N * N;
            maxCnt = 0;

            sc.nextLine();
            for (int i = 0; i < N; i++) {
                board[i] = sc.nextLine().split(" ");
            }
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if(board[r][c].endsWith("1")){
                        if(r != 0 & r != N-1 & c != 0 & c != N-1){
                            core.add(new int[]{r, c});
                        }
                        else{ maxCnt++; }//맨끝 코어갯수
                    }
                }

            }

            dfs(0, 0, maxCnt);

            System.out.printf("#%d %d\n", test_case, minLen);
        }
    }

    public static void dfs(int coreIdx, int nowLen, int nowCnt) {

        if(coreIdx == core.size()){
            if(nowCnt > maxCnt){
                maxCnt = nowCnt;
                minLen = nowLen;
            }
            else if(nowCnt == maxCnt){
                if(nowLen < minLen){
                    minLen = nowLen;
                }
            }
            return;
        }

        dfs(coreIdx+1, nowLen, nowCnt);
        int[] pos = core.get(coreIdx);
        int row = pos[0], col = pos[1];

        for(int[] d : dir){
            int len = 0;
            if(isConnect(row, col, d)){
                int dr = d[0];
                int dc = d[1];

                while(0 <= row + dr & row + dr < N & 0 <= col + dc & col + dc < N) {
                    row += dr;
                    col += dc;
                    board[row][col] = "C";
                    len++;
                }

                dfs(coreIdx+1, nowLen + len, nowCnt+1);

                while(board[row][col].endsWith("C")){
                    board[row][col] = "0";
                    row -= dr;
                    col -= dc;
                }
            }
        }
    }

    public static boolean isConnect(int row, int col, int[] d) {
        int dr = d[0];
        int dc = d[1];

        while(0 <= row + dr & row + dr < N & 0 <= col + dc & col + dc < N) {
            row += dr;
            col += dc;

            if(!board[row][col].endsWith("0")){
                return false;
            }

        }
        return true;
    }
}