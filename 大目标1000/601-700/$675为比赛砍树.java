import java.util.*;

/**
 *   0 表示障碍，无法触碰
 *   1 表示地面，可以行走
 *   比 1 大的数 表示有树的单元格，可以行走，数值表示树的高度
 *   你需要按照树的高度从低向高砍掉所有的树，每砍过一颗树，该单元格的值变为 1（即变为地面）。
 * 输入：forest = [[1,2,3],[0,0,4],[7,6,5]]
 * 输出：6
 * 解释：沿着上面的路径，你可以用 6 步，按从最矮到最高的顺序砍掉这些树。
 *
 *
 */
public class $675为比赛砍树 {

    int[][] move ={{-1,0},{1,0},{0,1},{0,-1}};
    public int cutOffTree(List<List<Integer>> forest) {
        List<int[]> list=new ArrayList<>();
        list.add(new int[]{0,0,forest.get(0).get(0)});
        for(int i=0;i<forest.size();i++){
            for(int j=0;j<forest.get(i).size();j++){
                int a=forest.get(i).get(j);
                if(a>1){ list.add(new int[]{i,j,a}); }
            }
        }
        list.sort((a, b) -> a[2] - b[2]); // 按高度排序

        int ans = minSteps(new int[]{0,0}, list.get(0), forest); // 找到到最小树的步数
        if(ans==-1){ return -1; }
        for(int i=1;i<list.size();i++){
            int d = minSteps(list.get(i-1), list.get(i), forest);
            if(d==-1){ return -1; }
            ans+=d;
        }
        return ans;
    }
    //BFS 计算 a->b 需要的最短路程，假如无法到达，则返回-1；
    private int minSteps(int[] a, int[] b, List<List<Integer>> forest){
        if(a[0]==b[0] && a[1]==b[1]){ return 0; }
        Queue<int[]> q = new LinkedList<>();
        boolean[][] cameBefore = new boolean[55][55];
        q.add(a);
        cameBefore[a[0]][a[1]] = true;
        int ans = 0;
        while(q.size()>0) {
            ans++;
            int size = q.size();
            for(int i=0; i<size; i++) {
                int[] p = q.poll();
                for(int j=0; j<4; j++) {
                    int x = p[0] + move[j][0], y = p[1] + move[j][1];
                    if(x>=0 && x<forest.size() && y>=0 && y<forest.get(0).size() && forest.get(x).get(y)!=0 && !cameBefore[x][y]){
                        if(x==b[0] && y==b[1]){ return ans; }
                        q.add(new int[]{x,y});
                        cameBefore[x][y]=true;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<List<Integer>> forest = new ArrayList<>();
        forest.add(Arrays.asList(1,2,3));
        forest.add(Arrays.asList(0,0,4));
        forest.add(Arrays.asList(7,6,5));
        System.out.println(new $675为比赛砍树().cutOffTree(forest));
    }
}
