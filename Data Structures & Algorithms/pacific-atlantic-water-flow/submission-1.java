public class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Pacific - top and left
        for (int r = 0; r < m; r++) {
            dfs(heights, pacific, r, 0);
            dfs(heights, atlantic, r, n - 1);
        }

        for (int c = 0; c < n; c++) {
            dfs(heights, pacific, 0, c);
            dfs(heights, atlantic, m - 1, c);
        }

   

        List<List<Integer>> result = new ArrayList<>();

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(
            int[][] heights,
            boolean[][] visited,
            int r,
            int c) {

        if (visited[r][c]) {
            return;
        }

        visited[r][c] = true;

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        for (int[] dir : directions) {

            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr < 0 || nr >= heights.length ||
                nc < 0 || nc >= heights[0].length) {
                continue;
            }

            if (visited[nr][nc]) {
                continue;
            }

            if (heights[nr][nc] < heights[r][c]) {
                continue;
            }

            dfs(heights, visited, nr, nc);
        }
    }
}