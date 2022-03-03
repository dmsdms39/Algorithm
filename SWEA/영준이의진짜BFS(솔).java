import java.io.IOException;
import java.util.*;

class Solution21 {

    public static int T;

    public static int N;

    public static final int MAX_DEPTH = 18;

    public static void main(String[] args) throws NumberFormatException, IOException {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        List<List<Integer>> Tree = new ArrayList<List<Integer>>();
        List<Integer> search = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int t = 1; t <= T; t++) {
            Tree.clear();
            search.clear();
            queue.clear();

            N = sc.nextInt();

            int[] Depths;
            int[][] Parents;

            Depths = new int[N + 1];
            Parents = new int[N + 1][MAX_DEPTH + 1];

            // 트리 연결정보를 담을 배열 선언
            for (int n = 0; n <= N; n++) {
                Tree.add(new ArrayList<Integer>());
            }

            for (int idx = 2; idx <= N; idx++) {
                int tempNode = sc.nextInt();
                Tree.get(idx).add(tempNode);
                Tree.get(tempNode).add(idx);
            }

            BFS(queue, search, Tree, Depths, Parents);
            SetParents(Parents);

            long length = 0;
            for (int i = 0; i < search.size() - 1; i++) {
                int node01 = search.get(i);
                int node02 = search.get(i + 1);
                int lca = LCA(node01, node02, Depths, Parents);
                length += (Depths[node01] - Depths[lca] + Depths[node02] - Depths[lca]);
            }

            System.out.printf("#%d %d\n", t, length);

        }

    }

    public static List<Integer> BFS(Queue<Integer> queue, List<Integer> result, List<List<Integer>> Tree, int[] Depths,
                                    int[][] Parents) {
        boolean[] visits = new boolean[N + 1];
        queue.offer(1);

        // 인접한 노드를 조회하는 루프
        while (!queue.isEmpty()) {
            int visitNode = queue.poll();
            visits[visitNode] = true;
            result.add(visitNode);

            int adjacencySize = Tree.get(visitNode).size();

            for (int i = 0; i < adjacencySize; i++) {
                int adjacencyNode = Tree.get(visitNode).get(i);
                if (!visits[adjacencyNode]) {
                    queue.offer(adjacencyNode);

                    // 바로 위의 부모노드 저장
                    Parents[adjacencyNode][0] = visitNode;
                    // 깊이 저장
                    Depths[adjacencyNode] = Depths[visitNode] + 1;
                }
            }
        }

        return result;
    }

    public static void SetParents(int[][] Parents) {
        // 각 노드들의 2^i승 위의 부모노드를 저장
        for (int i = 1; i <= MAX_DEPTH; i++) {
            for (int n = 1; n <= N; n++) {
                int halfParent = Parents[n][i - 1];
                Parents[n][i] = Parents[halfParent][i - 1];
            }
        }
    }

    public static int LCA(int nodeA, int nodeB, int[] Depths, int[][] Parents) {

        if (Depths[nodeA] < Depths[nodeB]) {
            int temp = nodeA;
            nodeA = nodeB;
            nodeB = temp;
        }

        int diff = Depths[nodeA] - Depths[nodeB];

        // BFS 탐색이라서 nodeA와 nodeB의 깊이는 최대 1이 차이남
        if (diff > 0) {
            nodeA = Parents[nodeA][diff-1];
        }

        if (nodeA == nodeB) {
            return nodeA;
        }

        int d = MAX_DEPTH;

        while(d-- > 0){
            if(Parents[nodeA][d] != Parents[nodeB][d]){
                nodeA = Parents[nodeA][d];
                nodeB = Parents[nodeB][d];
            }
        }

        return Parents[nodeA][0];
    }

}