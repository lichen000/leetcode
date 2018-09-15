package mangolost;

//On a N * N grid, we place some 1 * 1 * 1 cubes.
//
//        Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).
//
//        Return the total surface area of the resulting shapes.
//
//
//
//        Example 1:
//
//        Input: [[2]]
//        Output: 10
//        Example 2:
//
//        Input: [[1,2],[3,4]]
//        Output: 34
//        Example 3:
//
//        Input: [[1,0],[0,2]]
//        Output: 16
//        Example 4:
//
//        Input: [[1,1,1],[1,0,1],[1,1,1]]
//        Output: 32
//        Example 5:
//
//        Input: [[2,2,2],[2,1,2],[2,2,2]]
//        Output: 46
//
//
//        Note:
//
//        1 <= N <= 50
//        0 <= grid[i][j] <= 50

/**
 *
 */
public class Solution0892 {

    /**
     * @param grid
     * @return
     */
    public int surfaceArea(int[][] grid) {
        int result = 0;
        int count = 0; //count表示占用的方格数
        int num = 0; //num表示总立方体个数
        int up = 0; //up表示某方格与其上方方格放置的贴合方块数，需要减掉2*up面积
        int left = 0; //up表示某方格与其左方方格放置的贴合方块数，需要减掉2*left面积
        for (int i = 0; i < grid.length; i++) {
            int[] row = grid[i];
            for (int j = 0; j < row.length; j++) {
                int val = row[j];
                if (val > 0) {
                    num += val;
                    count++;
                    if (i > 0) {
                        up += Math.min(grid[i - 1][j], val);
                    }
                    if (j > 0) {
                        left += Math.min(grid[i][j - 1], val);
                    }
                }
            }
        }
        //总面积等于占用的方格的上下底面积，加上每个方块四个面面积，再扣除重复计算的贴合面面积
        result = num * 4 + count * 2 - (up + left) * 2;
        return result;
    }

    public static void main(String[] args) {
        Solution0892 solution = new Solution0892();
        int[][] grid1 = {{2}};
        int[][] grid2 = {{1, 2}, {3, 4}};
        int[][] grid3 = {{1, 0}, {0, 2}};
        int[][] grid4 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] grid5 = {{2, 2, 2}, {2, 1, 2}, {2, 2, 2}};
        System.out.println(solution.surfaceArea(grid1));
        System.out.println(solution.surfaceArea(grid2));
        System.out.println(solution.surfaceArea(grid3));
        System.out.println(solution.surfaceArea(grid4));
        System.out.println(solution.surfaceArea(grid5));
    }
}