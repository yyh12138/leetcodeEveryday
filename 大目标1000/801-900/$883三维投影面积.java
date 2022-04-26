/**
 * 输入：[[1,2],[3,4]]
 * 输出：17
 * 解释：这里有该形体在三个轴对齐平面上的三个投影(“阴影部分”)。
 */
public class $883三维投影面积 {

    public int projectionArea(int[][] grid) {
        int r = 0;
        int[] arr = new int[grid[0].length];
        for(int i=0;i<grid.length;i++){
            int max = 0;
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]!=0){
                    r++;
                    max = Math.max(max,grid[i][j]);
                    arr[j] = Math.max(arr[j],grid[i][j]);
                }
            }
            r+=max;
        }
        for(int i:arr){
            r+=i;
        }
        return r;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,2},{3,4}};
        System.out.println(new $883三维投影面积().projectionArea(grid));
    }
}
