class UserSolution {
    public int[][] map;
    public boolean[][] visited;
    public int size;

    void bfs_init(int map_size, int map[][]) {
        this.map = map;
        size = map_size;
        visited = new boolean[size][size];
    }

    int bfs(int x1, int y1, int x2, int y2) {
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        int[][] Q = new int[size * size][3];
        int minDist = size * size;
        int ret = -1, idx = 0, last = idx+1;
        int[] start = {x1, y1, 0};

        Q[idx] = start;

        if(map[y1-1][x1-1] == 1|| map[y2-1][x2-1] == 1){
            return ret;
        }

        while(idx < last){
            int x = Q[idx][0], y = Q[idx][1], dist = Q[idx][2];
            idx++;
            visited[y-1][x-1] = true;

            if(x == x2 & y == y2){
                if(dist < minDist){
                    minDist = dist;
                }
                ret = minDist;
            }

            for(int[] d : dir){
                int nx = x + d[0];
                int ny = y + d[1];

                if(0 < nx & nx <= size & 0 < ny & ny <= size){
                    if(map[ny-1][nx-1] == 0 & !visited[ny-1][nx-1]){
                        int[] next = {nx, ny, dist+1};
                        Q[last++] = next;
                    }
                }
            }
        }

        visited = new boolean[size][size];
        return ret;
    }
}
