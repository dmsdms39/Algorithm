import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution22
{
    static class Pos{
        long x;
        long y;

        public Pos(String x, String y) {
            this.x = Long.parseLong(x);
            this.y = Long.parseLong(y);
        }
    }

    static class NodeConnection implements Comparable<NodeConnection>{
        int nodeA;
        int nodeB;
        double powLen;

        public NodeConnection(int a, int b, Double calLen) {
            this.nodeA = a;
            this.nodeB = b;
            this.powLen = calLen;
        }

        @Override
        public int compareTo(NodeConnection o) {
            int check = (int) (this.powLen - o.powLen);
            return check; //내림차순
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
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            Double E = Double.parseDouble(br.readLine());

            PriorityQueue<NodeConnection> queue = new PriorityQueue<>();
            Pos[] island = new Pos[N];
            root = new int[N];
            Double ans = 0.0;


            for (int i = 0; i < N; i++) {
                root[i] = i;
                island[i] = new Pos(st1.nextToken(), st2.nextToken());
            }

            for (int a = 0; a < N - 1; a++) {
                for (int b = a + 1; b < N; b++) {
                    queue.offer(new NodeConnection(a, b, calLen(island[a], island[b])));
                }
            }

            while (!queue.isEmpty()){
                NodeConnection now = queue.poll();
                int rootA = find(now.nodeA);
                int rootB = find(now.nodeB);
                if(rootA != rootB){
                    union(rootA, rootB);
                    ans += E * now.powLen;
                }
            }

            System.out.printf("#%d %.0f\n", test_case, ans);
        }
    }

    private static int find(int X) {
        if( X != root[X] ){
            return find(root[X]);
        }
        return X;
    }

    private static void union(int A, int B) {
        if(A > B) root[A] = B;
        else root[B] = A;
    }

    private static Double calLen(Pos a, Pos b) {
        double diffX = a.x - b.x;
        double diffY = a.y - b.y;

        return diffX * diffX + diffY * diffY;
    }
}