import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

    private final static int MAX_NODE = 10000;
    private final static int ADD_HEAD = 1;
    private final static int ADD_TAIL = 2;
    private final static int ADD_NUM = 3;
    private final static int FIND = 4;
    private final static int REMOVE = 5;
    private final static int PRINT = 6;
    private final static int PRINT_REVERSE = 7;
    private final static int END = 99;

    private final static UserSolution usersolution = new UserSolution();

    private static BufferedReader br;

    public static void run() throws Exception {
        int cmd, data, num, ret;
        int[] output = new int[MAX_NODE];
        String str;
        StringTokenizer st;

        while(true) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            cmd = Integer.parseInt(st.nextToken());

            switch(cmd) {
                case ADD_HEAD :
                    data = Integer.parseInt(st.nextToken());
                    usersolution.addNode2Head(data);
                    break;

                case ADD_TAIL :
                    data = Integer.parseInt(st.nextToken());
                    usersolution.addNode2Tail(data);
                    break;

                case ADD_NUM :
                    data = Integer.parseInt(st.nextToken());
                    num = Integer.parseInt(st.nextToken());
                    usersolution.addNode2Num(data, num);
                    break;

                case FIND :
                    data = Integer.parseInt(st.nextToken());
                    num = usersolution.findNode(data);
                    System.out.println(num);
                    break;

                case REMOVE :
                    data = Integer.parseInt(st.nextToken());
                    usersolution.removeNode(data);
                    break;

                case PRINT :
                    ret = usersolution.getList(output);
                    for(int i = 0; i < ret; i++) {
                        System.out.print(output[i] + " ");
                    }
                    System.out.println();
                    break;

                case PRINT_REVERSE :
                    ret = usersolution.getReversedList(output);
                    for(int i = 0; i < ret; i++) {
                        System.out.print(output[i] + " ");
                    }
                    System.out.println();
                    break;

                case END :
                    return;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int TC;
        //System.setIn(new java.io.FileInputStream("res/sample_input.txt"));

        br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        TC = Integer.parseInt(str);

        for (int tc = 1; tc <= TC; tc++) {
            System.out.println("#" + tc);
            usersolution.init();
            run();
            System.out.println();
        }
    }
}

class Node {
    public int data;
    public Node prev;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class UserSolution {

    private final static int MAX_NODE = 10000;

    private Node[] node = new Node[MAX_NODE];
    private int nodeCnt = 0;
    private Node head;
    private Node tail;

    public Node getNode(int data) {
        node[nodeCnt] = new Node(data);
        return node[nodeCnt++];
    }

    public void init() {
        nodeCnt = 0;
        head = getNode(-1);
        tail = getNode(-1);
        head.next = tail;
        tail.prev = head;
    }

    public void addNode2Head(int data) {
        Node nNode = getNode(data);
        nNode.prev = head;
        nNode.next = head.next;
        head.next.prev = nNode;
        head.next = nNode;
    }

    public void addNode2Tail(int data) {
        Node nNode = getNode(data);
        nNode.next = tail;
        nNode.prev = tail.prev;
        tail.prev.next = nNode;
        tail.prev = nNode;
    }

    public void addNode2Num(int data, int num) {
        Node nNode = getNode(data);
        Node tmp = head;

        for(int i = 0; i < num; i++){
            tmp = tmp.next;
        }
        //tmp 앞에 삽입
        nNode.next = tmp;
        nNode.prev = tmp.prev;
        tmp.prev.next = nNode;
        tmp.prev = nNode;
    }

    public int findNode(int data) {
        Node tmp = head;
        int cnt = 0;

        while( tmp.next != null){
            if(tmp.data == data){
                break;
            }
            tmp = tmp.next;
            cnt++;
        }
        return cnt;
    }

    public void removeNode(int data) {
        Node rmvNode = null;
        Node tmp = head;

        while(tmp != null){
            if(tmp.data == data){
                rmvNode = tmp;
                break;
            }
            tmp = tmp.next;
        }

        if (rmvNode != null){
            rmvNode.prev.next = rmvNode.next;
            rmvNode.next.prev = rmvNode.prev;
            nodeCnt--;
        }
    }

    public int getList(int[] output) {
        Node tmp = head;
        int cnt = 0;
        while (tmp.next.next != null){
            output[cnt++] = tmp.next.data;
            tmp = tmp.next;
        }

        return cnt;
    }

    public int getReversedList(int[] output) {
        Node tmp = tail;
        int cnt = 0;
        while (tmp.prev.prev != null){
            output[cnt++] = tmp.prev.data;
            tmp = tmp.prev;
        }

        return cnt;
    }
}
