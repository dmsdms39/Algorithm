public class UserSolution {
    public int[][] childList;
    public int[] childCnt;
    public boolean[] visited;
    public int target = 0;
    public int depth = 0;

    public void dfs_init(int N, int[][] path) {
        childList = new int[100][5];
        childCnt = new int[100];
        visited = new boolean[100];

        for(int[] node: path){
            if (node[0] == 0){
                break;
            }
            childList[node[0]][childCnt[node[0]]++] = node[1];
        }
        //childCnt에 더해진 값이 저장되는지 확인해보기
    }

    public int dfs(int N) {
        int ret = -1;
        visited[N] = true;

        if (depth == 0){
            target = N;
        }

        for(int adj: childList[N]){
            if(adj == 0 || ret != -1){
                break;
            }
            if(!visited[adj]){
                if(adj > target){
                    if(depth == 0){
                        visited = new boolean[100];
                    }
                    else{ depth--;}
                    return adj;
                }
                else {
                    depth++;
                    ret = dfs(adj);
                }
            }
        }
        if(depth == 0){//다 돌고나서 처음 재귀로 돌아온 경우
            visited = new boolean[100];
        }
        else{ depth--;}

        return ret;
    }
}