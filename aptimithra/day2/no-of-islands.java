import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[][] grid = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        Set<String> islands = new HashSet<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder islandShape = new StringBuilder();
                    dfs(grid, i, j, i, j, islandShape);
                    islands.add(islandShape.toString());
                }
            }
        }

        System.out.println(islands.size());
    }

    private static void dfs(int[][] grid, int startRow, int startCol, int currentRow, int currentCol, StringBuilder islandShape) {
        if (currentRow < 0 || currentRow >= grid.length || currentCol < 0 || currentCol >= grid[0].length || grid[currentRow][currentCol] == 0) {
            return;
        }
        grid[currentRow][currentCol] = 0;
        islandShape.append((currentRow - startRow) + "_" + (currentCol - startCol) + "_");
        dfs(grid, startRow, startCol, currentRow - 1, currentCol, islandShape); // Up
        dfs(grid, startRow, startCol, currentRow + 1, currentCol, islandShape); // Down
        dfs(grid, startRow, startCol, currentRow, currentCol - 1, islandShape); // Left
        dfs(grid, startRow, startCol, currentRow, currentCol + 1, islandShape); // Right
    }
}
