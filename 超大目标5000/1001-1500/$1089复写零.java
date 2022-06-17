import java.util.Arrays;

/**
 * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 * 注意：请不要在超过该数组长度的位置写入元素。
 * 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 *
 * 输入：[1,0,2,3,0,4,5,0]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
 */
public class $1089复写零 {

    public void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (num==0) {
                i++;
                for (int j = arr.length-1; j >= i+1; j--) {
                    arr[j] = arr[j-1];
                }
                if (i>= arr.length) {
                    break;
                }
                arr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        new $1089复写零().duplicateZeros(new int[] {1,2,3});
    }
}
