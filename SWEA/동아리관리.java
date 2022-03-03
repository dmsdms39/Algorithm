import java.util.Scanner;

class Solution3
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        int[][] dp;
        T=sc.nextInt();
        sc.nextLine();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int answer = 0;

            String dayManager = sc.nextLine();
            int period = dayManager.length();
            dp = new int[period][1 << 4];

            //조건, 첫날은 A가 키를 가지고 있다.
            //아무도 참여하지 않는 경우는 없다.

            for (int visit = 1; visit < (1 << 4); visit++) {
                int firstMan = 1 << (dayManager.charAt(0)-'A');
                //첫째날 키를 가진 A가 방문하면서, 첫날 담당자가 방문하는 경우
                if ((visit & 1) != 0 && (visit & firstMan) != 0) {
                    dp[0][visit] = 1; //첫째날 가능한 조합 한가지
                }
            }
//            printdp(dp);

            //이틀째부터 모든 날짜 값 넣기
            for (int day = 1; day < period; day++) {
                checkVisit(dayManager, dp, day);
//                printdp(dp);
            }

            for (int val : dp[period-1]){
                answer += val;
                answer %= 1e9+7; //combi에 연산시, answer는 계속 커짐
            }

            System.out.printf("#%d %d\n", test_case, answer);
        }
    }

    public static void checkVisit(String mangers, int[][] dp, int day){
        int dayManager = 1 << (mangers.charAt(day)-'A');
        for (int dv = 1; dv < (1 << 4); dv++){
            //전날 해당 멤버의 visit 조합이 있는 경우에만 체크(키 전달자 확인을 위해)
            if (dp[day-1][dv] != 0) {
                for (int nv = 1; nv < (1 << 4); nv++) {
                    //담당자가 방문하는 하면서, 키를 전달해줄 사람이 있는 경우
                    if((dayManager & nv) != 0 && (dv & nv) != 0){
                        dp[day][nv] += dp[day-1][dv]; //가능한 전날 조합을 더해줌
                        dp[day][nv] %= 1e9+7;
                    }
                }
            }
        }
    }

    public static void printdp(int[][] dp){
        System.out.println("///////////////////////////////");
        for (int i = 0; i < dp.length; i++){
            System.out.print("dp[day"+(i+1)+"]");
            for (int aa: dp[i]){
                System.out.print(aa+" ");
            }
            System.out.println();
        }

    }
}