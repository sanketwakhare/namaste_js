import java.util.ArrayList;
import java.util.List;

/* LeetCode problem 63. Unique Paths II: https://leetcode.com/problems/unique-paths-ii/ */

/* DP problem : UNSOLVED */
// TODO: revisit - problem is unsolved TLE
public class q5_leetcode_uniquePaths_two {

        public int uniquePathsWithObstacles(int[][] obstacleGrid) {

                int n = obstacleGrid.length;
                int m = obstacleGrid[0].length;
                List<Integer> paths = new ArrayList<Integer>();

                int startRowIndex = 0;
                int startColIndex = 0;
                uniquePaths(startRowIndex, startColIndex, obstacleGrid, paths, n, m);

                return paths.size();

        }

        public void uniquePaths(int i, int j, int[][] grid, List<Integer> paths, int n, int m) {

                if (i == n - 1 && j == m - 1) {
                        // reached to destination
                        paths.add(1);
                        return;

                }

                if (i < 0 || j < 0 || i == n || j == m || grid[i][j] == 1 || grid[i][j] == 2) {
                        return;
                }

                // mark visited
                grid[i][j] = 2;

                uniquePaths(i + 1, j, grid, paths, n, m);
                uniquePaths(i, j + 1, grid, paths, n, m);

                grid[i][j] = 0;

        }

        public static void main(String[] args) {

                // test case 1
                int[][] grid = new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
                q5_leetcode_uniquePaths_two t1 = new q5_leetcode_uniquePaths_two();
                t1.uniquePathsWithObstacles(grid); // 2

                // test case 2
                grid = new int[][] { { 0, 1 }, { 0, 0 } };
                t1.uniquePathsWithObstacles(grid); // 4

                // test case 3
                grid = new int[][] {
                                { 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0,
                                                1, 0, 0, 0, 1,
                                                0, 0 },
                                { 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0,
                                                0, 0, 0, 0, 0,
                                                0, 0 },
                                { 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0,
                                                1, 0, 0, 1, 0,
                                                0, 0 },
                                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0,
                                                0, 1, 0, 0, 1,
                                                0, 1 },
                                { 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                                0, 0, 0, 0, 1,
                                                0, 0 },
                                { 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0,
                                                0, 1, 0, 0, 1,
                                                0, 0 },
                                { 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0,
                                                0, 1, 0, 0, 1,
                                                0, 0 },
                                { 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1,
                                                0, 1, 1, 0, 0,
                                                0, 1 },
                                { 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0,
                                                0, 0, 0, 0, 0,
                                                0, 0 },
                                { 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0,
                                                0, 0, 1, 1, 0,
                                                0, 0 },
                                { 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0,
                                                0, 1, 0, 0, 0,
                                                1, 0 },
                                { 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1,
                                                0, 0, 1, 0, 0,
                                                0, 1 },
                                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0,
                                                1, 0, 0, 1, 0,
                                                0, 0 },
                                { 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                                0, 0, 0, 0, 0,
                                                0, 0 },
                                { 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0,
                                                0, 0, 0, 0, 0,
                                                1, 0 },
                                { 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0,
                                                1, 0, 0, 0, 0,
                                                0, 0 },
                                { 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1,
                                                0, 0, 0, 0, 0,
                                                0, 0 },
                                { 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0,
                                                0, 0, 0, 0, 0,
                                                1, 0 },
                                { 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                                0, 0, 0, 0, 0,
                                                0, 0 },
                                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1,
                                                0, 0, 0, 1, 0,
                                                0, 0 },
                                { 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 1,
                                                1, 0, 0, 0, 0,
                                                0, 0 },
                                { 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0,
                                                0, 0, 0, 0, 0,
                                                0, 0 },
                                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                                0, 1, 0, 0, 0,
                                                0, 0 },
                                { 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0,
                                                0, 0, 0, 0, 0,
                                                0, 0 },
                                { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                                0, 0, 0, 0, 0,
                                                1, 0 },
                                { 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0,
                                                0, 1, 0, 0, 1,
                                                0, 0 },
                                { 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1,
                                                0, 0, 0, 1, 1,
                                                0, 0 },
                                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0,
                                                0, 0, 0, 0, 0,
                                                0, 0 } };
                t1.uniquePathsWithObstacles(grid); // 0

        }

}