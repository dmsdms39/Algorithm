import java.util.Scanner;

class Solution9
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        int[] hallway;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            hallway = new int[200]; //복도에서 가장 많이 겹치는 부분
            int N = sc.nextInt();
            int answer = 0;

            for (int m = 0; m < N ; m++){
                int roomA = sc.nextInt();
                int roomB = sc.nextInt();

                if (roomB < roomA){
                    int tmp = roomA;
                    roomA = (roomB-1)/2;
                    roomB = (tmp-1)/2;
                }
                else{
                    roomA = (roomA-1)/2;
                    roomB = (roomB-1)/2;
                }

                for (int i = roomA; i <= roomB; i++){
                    hallway[i] += 1;
                }
            }

            for(int a: hallway){
                if (a > answer){
                    answer = a;
                }
            }

            System.out.printf("#%d %d\n", test_case, answer);

        }
    }
}