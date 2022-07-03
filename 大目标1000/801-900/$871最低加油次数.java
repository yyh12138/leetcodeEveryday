/**
 * 输入：target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
 * 输出：2
 * 我们出发时有 10 升燃料。
 * 我们开车来到距起点 10 英里处的加油站，消耗 10 升燃料。将汽油从 0 升加到 60 升。
 * 然后，我们从 10 英里处的加油站开到 60 英里处的加油站（消耗 50 升燃料），
 * 并将汽油从 10 升加到 50 升。然后我们开车抵达目的地。
 * 我们沿途在1两个加油站停靠，所以返回 2 。
 *
 */
public class $871最低加油次数 {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {


        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new $871最低加油次数().minRefuelStops(100, 10, new int[][]{
                {10,60}, {20,30}, {30,30}, {60,40}
        }));
    }
}
