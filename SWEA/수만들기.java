import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

class Solution
{
    public static int ans;
//    public static String[] numbers;
    public static int[] numbers;

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T =Integer.parseInt(br.readLine());
        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
//            sc.nextLine();
//            int N = Integer.parseInt(br.readLine());
//            StringTokenizer st = new StringTokenizer(br.readLine());
            numbers = new int[N];
//            int K = Integer.parseInt(br.readLine());

            for (int i = 0; i < N; i++) {
//                numbers[i] = Integer.parseInt(st.nextToken());
                numbers[i] = sc.nextInt();
            }
//            numbers = sc.nextLine().split(" ");
            int K = sc.nextInt();
            ans = K;

            PriorityQueue<RemainData> pq = new PriorityQueue<>();
            pq.offer(new RemainData(0, K));

            while(!pq.isEmpty()){
                boolean isDev = false;
                RemainData now = pq.poll();

                if (now.value == 0){
                    ans = now.depth;
                    break;
                }

                for (int num : numbers){
//                    int num = Integer.parseInt(numStr);
                    if(now.value >= num){
                        isDev = true;
                        pq.offer(new RemainData(now.depth + now.value % num, now.value / num));
                    }
                }

                if(!isDev){
                    pq.offer(new RemainData(now.depth + 1, now.value - 1));
                }
            }

            System.out.printf("#%d %d\n", test_case, ans);

        }
    }

    static class RemainData implements Comparable<RemainData>{
        int depth;
        int value;

        public RemainData(int depth, int value) {
            this.depth = depth;
            this.value = value;
        }

        @Override
        public int compareTo(RemainData o) {
            return this.depth - o.depth;
        }
    }
}