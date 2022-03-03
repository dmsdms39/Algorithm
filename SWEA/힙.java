import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution32
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            System.out.printf("#%d", test_case);
            for (int i = 0; i < N; i++) {
                int op1 = sc.nextInt();
                if(op1 == 1){
                    pq.offer(sc.nextInt());
                }
                else {
                    if(!pq.isEmpty()) {
                        System.out.printf(" %d", pq.poll());
                    }
                    else {
                        System.out.printf(" -1");
                    }
                }
            }
            System.out.println("");
        }
    }
}