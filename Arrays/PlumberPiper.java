import java.util.*;

public class PlumberPiper {
    static class Cell {
Row = -1, destCol = -1;

        // Find S and D
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (wall[i][j] == 'S') {
                    startRow = i;
                    startCol = j;
                }
                if (wall[i][j] == 'D') {
                    destRow = i;
                    destCol = j;
                }
            }
        }

        // Use BFS (0-1 BFS since cost = 1 for G, 0 for S or D)
        int[][] dist = new int[n][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        Deque<Cell> dq = new ArrayDeque<>();

        dq.addFirst(new Cell(startRow, startCol, 0));
        dist[startRow][startCol] = 0;

        while (!dq.isEmpty()) {
            Cell cur = dq.pollFirst();

            if (cur.row == destRow && cur.col == destCol) {
                return cur.cost; // reached destination
            }

            for (int k = 0; k < 4; k++) {
                int nr = cur.row + dr[k];
                int nc = cur.col + dc[k];

                if (nr >= 0 && nc >= 0 && nr < n && nc < n && wall[nr][nc] != 'R') {
                    int newCost = cur.cost + (wall[nr][nc] == 'G' ? 1 : 0);

                    if (newCost < dist[nr][nc]) {
                        dist[nr][nc] = newCost;
                        if (wall[nr][nc] == 'G')
                            dq.addLast(new Cell(nr, nc, newCost)); // cost 1 → add to back
                        else
                            dq.addFirst(new Cell(nr, nc, newCost)); // cost 0 → add to front
                    }
                }
            }
        }

        return -1; // if D cannot be reached
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        char[][] wall = new char[n][n];
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                wall[i][j] = parts[j].charAt(0);
            }
        }

        int result = minGreenBricks(wall);
        System.out.println(result);
    }
}
