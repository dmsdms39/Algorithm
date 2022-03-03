import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//참고 https://pekahblog.tistory.com/127
class Node28 {
    String data;
    int left;
    int right;
}

class Solution28
{
    public static int N;
    public static Node28[] node;

    public static void main(String args[]) throws Exception
    {
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            N = Integer.parseInt(br.readLine());
            node = new Node28[N+1];

            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken(); //노드 인덱스
                node[i] = new Node28();
                node[i].data = st.nextToken(); //들어갈 숫자 or 연산기호

                //연산 기호 일경우
                if(isOP(node[i].data)){
                    node[i].left = Integer.parseInt(st.nextToken());
                    node[i].right = Integer.parseInt(st.nextToken());
                }
            }

            postOrder(1); //중위 순회 시작 인덱스

            System.out.printf("#%d %d\n", test_case, (int)Float.parseFloat(node[1].data));

        }
    }

    private static boolean isOP(String data) {
        char c = data.charAt(0);

        if(c == '+'){
            return true;
        }else if(c == '-'){
            return true;
        }else if(c == '*'){
            return true;
        }else if(c == '/'){
            return true;
        }

        return false;
    }

    private static void postOrder(int idx) {

        if(idx < 1 | idx > N) {
            return;
        }
        int left = node[idx].left;
        int right = node[idx].right;
        char c = node[idx].data.charAt(0);

        postOrder(left);
        postOrder(right);

        if(c == '+'){
            node[idx].data = Float.parseFloat(node[left].data) + Float.parseFloat(node[right].data) + "";
        }else if(c == '-'){
            node[idx].data = Float.parseFloat(node[left].data) - Float.parseFloat(node[right].data) + "";
        }else if(c == '*'){
            node[idx].data = Float.parseFloat(node[left].data) * Float.parseFloat(node[right].data) + "";
        }else if(c == '/'){
            node[idx].data = Float.parseFloat(node[left].data) / Float.parseFloat(node[right].data) + "";
        }
    }

}