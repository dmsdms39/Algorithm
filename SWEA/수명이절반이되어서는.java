import java.util.Scanner;
import java.io.FileInputStream;

class Solution17
{
    public static String[] wearLevel, block;
    public static int N, K;

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        sc.nextLine();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            String[] cntNum = sc.nextLine().split(" ");
            N = Integer.parseInt(cntNum[0]);
            K = Integer.parseInt(cntNum[1]);
            wearLevel = sc.nextLine().split(" ");
            block = sc.nextLine().split(" ");

            //최소값 이진 탐색
            int s = 0, e = 200000;
            int answer;

            while (s < e){
                int m = (s + e) / 2;
                if(isPossible(m)) {
                    e = m;
                }
                else{
                    s = m + 1;
                }
            }
            answer = e;

            System.out.printf("#%d %d", test_case, answer);


        }
    }

    private static boolean isPossible(int target) {
        int index = -1;

        for(int splitPos = 0; splitPos < K; splitPos++){
            for (int blockCnt = 0; blockCnt < Integer.parseInt(block[splitPos]); blockCnt++) {
                index++;
                //확인 범위가 끝을 넘어간 경우 불가능한 값이다.
                if(index == N){
                    return false;
                }
                //현재 분할된 블럭 갯수만큼 확인하는 중 target으로 정한 최소값보다 커지면
                //체크 중인 블럭을 리셋하고 다음 구간 확인한다.
                if (Integer.parseInt(wearLevel[index]) > target){
                    splitPos--;
                    break;
                }
            }
        }
        return true;
    }
}