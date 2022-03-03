/**아이디어
 이미 10개일 때
 맨처음 원소보다 작은지 비교해봄 -> 그렇다면 아예 추가하지 않고 넘어감
 맨처음 원소보다는 큰 경우 -> heappop으로 맨 위 원소 뺌
 -> 비어있는 자리에 마지막 원소를 담아줌 -> 아래와 비교하며 내려줌.

 아직 10개가 아닐 때
 맨 마지막에 원소 추가 -> 부모 노드와 비교하며 작은 값인 경우 끝까지 올려
 */
class UserSolution {

    public int[][] node = new int[12][2]; //root는 index 1위치에 들어감. 하나 비교를 위한 여유분
    public int nodeCnt;

    public void init() {
        nodeCnt = 0;
        for (int i = 0; i < 12; i++) {
            node[i][0] = -1;
            node[i][1] = -1;
        }
    }

    public void addUser(int uID, int income) {
        //Top10이 가득찼는데 수입이 더 큰 유저가 들어오는 경우
        if(nodeCnt == 10 & income > node[1][1]){
            heapPush(uID, income);
            heapPop();
        }
        else if (nodeCnt < 10){
            heapPush(uID, income);
            int pos = nodeCnt;
            //최솟값 힙 구현
            while (pos > 1){
                int parent = pos / 2; //parent 와 계속 비교해서 자리 바꿔줌.
                swap(parent, pos);
                pos = parent; //루트를 다음 값으로 넣어줌
            }
        }

    }

    void heapPush(int uID, int income){
        nodeCnt++;
        node[nodeCnt][0] = uID;
        node[nodeCnt][1] = income;
    }

    int heapPop() {
        int ret = node[1][0];
        int pos = 1;

        node[1][0] = node[nodeCnt][0];
        node[1][1] = node[nodeCnt][1];

        node[nodeCnt][0] = -1;
        node[nodeCnt][1] = -1;

        nodeCnt--;

        while (pos <= nodeCnt / 2){
            int left = pos * 2;
            int right = pos * 2 + 1;
            int child = left;

            if(right <= nodeCnt) {
                if(node[right][1] < node[left][1] |
                        (node[right][1] == node[left][1] & node[right][0] > node[left][0])) {
                    child = right;
                }
            }

            swap(pos, child);

            pos = child; //루트를 다음 값으로 넣어줌
        }

        return ret;
    }

    void swap(int bigger, int target){
        //수입이 더 많거나, 수입이 같은데 번호가 작은 경우 아래로!
        if (node[bigger][1] > node[target][1] |
                (node[bigger][1] == node[target][1] & node[bigger][0] < node[target][0])){
            int tmpUID = node[target][0];
            int tmpIncome = node[target][1];

            node[target][0] = node[bigger][0];
            node[target][1] = node[bigger][1];

            node[bigger][0] = tmpUID;
            node[bigger][1] = tmpIncome;
        }
    }


    int getTop10(int[] result) {
        int topCnt = nodeCnt;

        for (int i = 0; i < topCnt; i++) {
            result[i] = node[i+1][0];
        }
        return topCnt;
    }
}