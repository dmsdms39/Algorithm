import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution26
{
    static int N;
    static char[] cArr;
    static StringBuilder ans;

    public static void main(String args[]) throws Exception
    {
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int test_case = 1; test_case <= 10; test_case++)
        {
          N = Integer.parseInt(br.readLine());
          cArr = new char[N+1];
          ans = new StringBuilder();

            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken(); //노드 위치는 넘김
                cArr[i] = st.nextToken().charAt(0); //해당 노드에 들어갈 문자
            }

            inOrder(1); //중위 순회 시작 인덱스

            System.out.printf("#%d %s\n", test_case, ans);

        }
    }

    private static StringBuilder inOrder(int idx) {

        if(idx > N) {
            return null;
        }

        inOrder(2 * idx);//좌측 노드
        ans.append(cArr[idx]);
        inOrder(2 * idx + 1);//우측 노드

        return ans;
    }
}