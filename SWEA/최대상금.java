import java.util.Scanner;
class Solution10
{
    static String[] nums;
    static int answer;
    static boolean[][] visit;

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        sc.nextLine();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            String[] arr = sc.nextLine().split(" ");
            nums = arr[0].split("");
            int exCnt = Integer.parseInt(arr[1]);
            visit = new boolean[exCnt+1][(int) Math.pow(10, nums.length)]; //row 번째 교환 중 해당 숫자[col]가 나온 적이 있다.
            answer = 0;

            dfs(0, exCnt);

            System.out.printf("#%d %d\n", test_case, answer);
        }

    }

    public static void swap(int i, int j){
        String  tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static int getNum(){
        int ret = 0;
        for(String a: nums) {
            ret = ret * 10 + Integer.parseInt(a);
        }
        return ret;
    }

    public static void dfs(int chk, int cnt){
        int length = nums.length;
        int current = getNum();

        if(visit[cnt][current]){
            return;
        }
        visit[cnt][getNum()] = true;

        if (cnt == 0){
            answer = Math.max(answer, current);
            return;
        }

        //현재 체크 중인 값부터 뒤에 값과 하나씩 교환
        for(int i = chk; i < length; i++){
            for(int j = i + 1; j < length; j++){
                swap(i,j);
                dfs(i, cnt-1);
                swap(i,j);
            }
        }
    }
}