import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution29
{
    public static int[] parent;
    public static ArrayList<Integer>[] child;
    public static Boolean[] visited;

    public static void main(String args[]) throws Exception
    {
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            int ans = 0;
            parent = new int[V+1];
            child = new ArrayList[V+1];
            visited = new Boolean[V+1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= V; i++){
                child[i] = new ArrayList<Integer>();
                visited[i] = false;
            }

            for (int i = 2; i <= V; i++) {
                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                parent[c] = p; //들어갈 문자
                child[p].add(c);
            }

            ans = LCA(nodeA, nodeB);

            System.out.printf("#%d %d %d\n", test_case, ans, countSubTree(ans));

        }
    }

    private static int LCA(int nodeA, int nodeB) {
        visited[nodeA] = true;
        visited[nodeB] = true;

        while (nodeA != 1 | nodeB != 1){

           if(nodeA != 1){
               if(!visited[parent[nodeA]]){
                   nodeA = parent[nodeA];
                   visited[nodeA] = true;
               }
               else{
                   return parent[nodeA];
               }
           }

            if(nodeB != 1){
                if(!visited[parent[nodeB]]){
                    nodeB = parent[nodeB];
                    visited[nodeB] = true;
                }
                else{
                    return parent[nodeB];
                }
            }
        }

        return 1;
    }

    private static int countSubTree(int ans) {
        int ret = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(ans);

        while(!queue.isEmpty()){
            int now = queue.poll();
            ret++;

            queue.addAll(child[now]);
        }

        return ret;
    }

}