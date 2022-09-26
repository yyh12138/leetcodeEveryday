import java.util.Arrays;

/**
 * 包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
 * 以任意顺序返回这两个数字均可。
 */
public class $1719消失的两个数字 {
    public int[] missingTwo(int[] nums) {
        int pre=0;
        int post=0;
        int n=nums.length+2;
        for(int i=0;i<nums.length;i++) {
            while(i<nums.length&&nums[i]==-1) { i++; }
            if(i==nums.length) { break; }
            int temp=nums[i]-1;
            while(true) {
                if(temp==n-1) { pre=-1;break; }
                if(temp==n-2) { post=-1;break; }
                if(nums[temp]==-1) { break; }
                int temp2=nums[temp];
                nums[temp]=-1;
                temp=temp2-1;
            }
        }
        int[] result=new int[2];
        int index=0;
        for(int j=0;j<nums.length;j++) {
            if(nums[j]!=-1) {
                result[index++]=j+1;
            }
        }
        if(post!=-1) {
            result[index++]=n-1;
        }
        if(pre!=-1) {
            result[index++]=n;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new $1719消失的两个数字().missingTwo(new int[]{1,3,5,6})));
    }
}
