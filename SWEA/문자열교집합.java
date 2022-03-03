import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Solution37
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());


        for(int test_case = 1; test_case <= T; test_case++)
        {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            int ans = 0;

            if(N <= M){
                while (st1.hasMoreTokens()) {
                    map.put(st1.nextToken(), 0);
                }
                while (st2.hasMoreTokens()){
                    if(map.containsKey(st2.nextToken())) ans++;
                }
            }
            else {
                while (st2.hasMoreTokens()) {
                    map.put(st2.nextToken(), 0);
                }
                while (st1.hasMoreTokens()){
                    if(map.containsKey(st1.nextToken())) ans++;
                }
            }

            System.out.printf("#%d %d\n", test_case, ans);

        }
    }
}