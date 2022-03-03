import java.util.Arrays;
import java.util.Scanner;


class Solution15
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int answer = 0;
            int N = sc.nextInt();
            int P = sc.nextInt();
            sc.nextLine();
            int[] attend = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int maxDay = Arrays.stream(attend).max().orElse(0);
            //Pass 사용할 부분 구분하기 위해 기존에 참석했다면 true를 넣어준다.
            boolean[] visit = new boolean[maxDay + P + 2];
            visit[0] = true;//전날 값 불러오기 위해 0인덱스 필요
            Arrays.stream(attend).forEach(x -> visit[x + 1] = true);

            int r = 1;
            for(int l = 1; l <= maxDay + P + 1; l++){
                if(r > maxDay + P + 1){
                    break;
                }

                if(!visit[l-1]){//이전 항에서 PASS를 사용한 경우라면 넘어왔으니깐 다시 더해줌
                    P++;
                }

                while(P > 0 || (r <= maxDay + P + 1 && visit[r])){
                    if(!visit[r]){ P--;}
                    r++;
                }

                answer = Math.max(answer, r-l);

            }

            System.out.printf("#%d %d\n", test_case, answer);

        }
    }
}