import java.util.Arrays;

public class $1806还原排列的最小操作步数 {

    public static void main(String[] args) {
        System.out.println(new $1806还原排列的最小操作步数().reinitializePermutation(2));
    }

    public int reinitializePermutation(int n) {
        int[] perm = new int[n];
        int[] arr = new int[n];
        int[] init = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = i;
            init[i] = i;
        }
        int res = 0;
        while (!Arrays.equals(init, arr)) {
            operation(n, perm, arr);
            System.arraycopy(arr, 0, perm, 0, n);
            res++;
        }
        return res;
    }

    private static void operation(int n, int[] perm, int[] arr) {
        for (int i = 0; i < n; i++) {
            if (i%2==0) {
                arr[i] = perm[i/2];
            }else {
                arr[i] = perm[n/2 + (i-1)/2];
            }
        }
    }
}
