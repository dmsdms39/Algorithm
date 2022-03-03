import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution27
{

    public static void main(String args[]) throws Exception
    {
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int N = Integer.parseInt(br.readLine());
            int ans = 1; //성공으로 초기화
            char c;

            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken(); //노드 인덱스
                c = st.nextToken().charAt(0); //들어갈 문자

                if(ans == 0) continue; //이미 오류라면 체크할 필요없음

                if(i <= N/2) {
                    //연산 문자 나올 자리인데 num이 나올 경우
                    if(isNum(c)){ ans = 0; }
                }
                else if(!isNum(c)){ ans = 0; } //숫자 나올 자리인데 기호가 나올 경우

            }

            System.out.printf("#%d %d\n", test_case, ans);

        }
    }

    private static boolean isNum(char c) {
        if (c == '+') {
            return false;
        } else if (c == '-') {
            return false;
        } else if (c == '*') {
            return false;
        } else if (c == '/') {
            return false;
        } return true;
    }

}