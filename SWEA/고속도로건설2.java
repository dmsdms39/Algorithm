import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution23
{
    static class Highway implements Comparable<Highway>{
        int nodeA;
        int nodeB;
        int cost;

        public Highway(String[] info) {
            nodeA = Integer.parseInt(info[0]);
            nodeB = Integer.parseInt(info[1]);
            cost = Integer.parseInt(info[2]);
        }


        @Override
        public int compareTo(Highway o) {
            return this.cost - o.cost;//오름차순
        }
    }

    public static int[] root;

    public static void main(String args[]) throws Exception
    {
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
            PriorityQueue<Highway> queue = new PriorityQueue<>();
            root = new int[N+1];
            int ans = 0;

            for (int i = 1; i <= N; i++) {
                root[i] = i;
            }

            for (int i = 0; i < M; i++) {
                queue.offer(new Highway(br.readLine().split(" ")));
            }

            while (!queue.isEmpty()){
                Highway now = queue.poll();
                int rootA = find(now.nodeA);
                int rootB = find(now.nodeB);
                if(rootA != rootB){
                    union(rootA, rootB);
                    ans += now.cost;
                }
            }

            System.out.printf("#%d %d\n", test_case, ans);

        }
    }

    private static int find(int X) {
        if(X != root[X]) return find(root[X]);
        else return X;
    }

    private static void union(int A, int B) {
        if (A > B) root[A] = B;
        else root[B] = A;
    }
}