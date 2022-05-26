/**
 * 四叉树节点
 */
class Nodee {
    public boolean val;
    public boolean isLeaf;
    public Nodee topLeft;
    public Nodee topRight;
    public Nodee bottomLeft;
    public Nodee bottomRight;
    public Nodee() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    public Nodee(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    public Nodee(boolean val, boolean isLeaf, Nodee topLeft, Nodee topRight, Nodee bottomLeft, Nodee bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};

public class $427建立四叉树 {

    public Nodee construct(int[][] grid) {
        return formNode(grid,0,grid.length-1,0,grid.length-1);
    }
    public Nodee formNode(int[][] grid, int l, int r, int low, int high){
        if(allSame(grid,l,r,low,high)){
            return new Nodee(grid[l][low]==1,true);
        }
        int mid1=(l+r)/2,mid2=(low+high)/2;
        Nodee topLeft=formNode(grid,l,mid1,low,mid2);
        Nodee topRight=formNode(grid,l,mid1,mid2+1,high);
        Nodee bottomLeft=formNode(grid,mid1+1,r,low,mid2);
        Nodee bottomRight=formNode(grid,mid1+1,r,mid2+1,high);
        return new Nodee(true,false,topLeft,topRight,bottomLeft,bottomRight);
    }
    public boolean allSame(int[][] grid, int l, int r, int low, int high){
        //判断矩阵某区域是否同值
        for(int i=l;i<=r;i++){for(int j=low;j<=high;j++){if(grid[i][j]!=grid[l][low]){return false;}}}
        return true;
    }

    public static void main(String[] args) {
        new $427建立四叉树().construct(new int[][]{
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0}
        });
    }
}
