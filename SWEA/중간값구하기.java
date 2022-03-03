import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

class Solution34
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            PriorityQueue<Integer> leftQ = new PriorityQueue(Collections.reverseOrder());
            PriorityQueue<Integer> rightQ = new PriorityQueue();

            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            long ans = 0;

            leftQ.offer(Integer.parseInt(input[1]));
            for (int i = 0; i < N; i++) {
                String[] nums = br.readLine().split(" ");
                leftQ.offer(Integer.parseInt(nums[0]));
                rightQ.offer(Integer.parseInt(nums[1]));

                int leftMax = leftQ.peek();
                int rightMin = rightQ.peek();

                if(leftMax > rightMin){
                    leftQ.poll();
                    leftQ.offer(rightMin);

                    rightQ.poll();
                    rightQ.offer(leftMax);
                }

//                ans += leftQ.peek() % 20171109;
                ans += leftQ.peek();
            }

            System.out.printf("#%d %d\n", test_case, ans % 20171109);

        }
    }
}