import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution18
{
    private static long[] A, sorted;
    private static int answer;

    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int[] dp = new int[N];
            sc.nextLine();
            A = new long[N];
            sorted = new long[N];
            answer = 0;
//            long[] arr = Arrays.stream(sc.nextLine().split(" "))
//                    .mapToLong(Long::parseLong)
//                    .toArray();

            for (int arrLen = 0; arrLen < N; arrLen++) {
                A[arrLen] = sc.nextLong();
            }

            mergeSort(0, N-1);

            System.out.printf("#%d %d\n", test_case, answer);
        }
    }

    private static void mergeSort(int l, int r) {
        int m;

        if (l < r) {
            m = (l + r) / 2;
            mergeSort(l, m);
            mergeSort(m + 1, r);
            merge(l, m, r);
        }
    }

    private static void merge(int l, int m, int r) {
        int x = l, y = m + 1, k = l;

        while(x <= m || y <= r) {
            if (y > r || (x <= m && A[x] < A[y])) {
                sorted[k] = A[x++];
            }
            else {
                answer += (m - x + 1);
                sorted[k] = A[y++];
            }
            k++;
        }

        // 배열 복사
        for (x = l; x <= r; x++)
            A[x] = sorted[x];
    }
}