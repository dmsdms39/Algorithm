import java.util.Scanner;
class Solution8
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        int[] won = {50000, 10000, 5000, 1000, 500, 100, 50, 10};

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int[] answer = new int[8];
            int budget = sc.nextInt();

            for(int i = 0; i < 8; i++){
                answer[i] = budget / won[i];
                budget -= won[i] * answer[i];
            }
            System.out.printf("#%d\n", test_case);
            for(int a: answer){
                System.out.print(a+" ");
            }
            System.out.println();
        }

    }
}