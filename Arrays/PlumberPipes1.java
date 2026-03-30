import java.util.*;

public class PlumberPipes1 {
    static class Cell {
        int row, col, cost;

        Cell(int r, int c, int cost) {
            this.row = r;
            this.col = c;
            this.cost = cost;
        }
    }

    static int[] dr = {-1, 1, 0, 0}; // Directions: Up, Down, Left, Right
    static int[] dc = {0, 0, -1, 1};

    /**
     * Finds the minimum number of Green Bricks ('G') to break to lay a pipe 
     * from Source ('S') to Destination ('D'), avoiding Red Bricks ('R').
     * Uses 0-1 BFS.
     * @param wall The N x N character grid representing the wall.
     * @return The minimum number of 'G' bricks to break, or -1 if 'D' is unreachable.
     */
    public static int minGreenBricks(char[][] wall) {
        int n = wall.length;
        int startRow = -1, startCol = -1;
        int destRow = -1, destCol = -1;

        // 1. Find S and D coordinates
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

        if (startRow == -1 || destRow == -1) return -1; // Should not happen with valid input

        // 2. Initialize for 0-1 BFS
        int[][] dist = new int[n][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        
        // Deque is used for 0-1 BFS: Cost 0 to front, Cost 1 to back
        Deque<Cell> dq = new ArrayDeque<>();

        dq.addFirst(new Cell(startRow, startCol, 0));
        dist[startRow][startCol] = 0;

        // 3. Perform 0-1 BFS
        while (!dq.isEmpty()) {
            Cell cur = dq.pollFirst();

            if (cur.row == destRow && cur.col == destCol) {
                return cur.cost; // Reached destination with minimum cost
            }

            // Check all 4 adjacent cells
            for (int k = 0; k < 4; k++) {
                int nr = cur.row + dr[k];
                int nc = cur.col + dc[k];

                // Check bounds and ensure it's not a Red Brick ('R')
                if (nr >= 0 && nc >= 0 && nr < n && nc < n && wall[nr][nc] != 'R') {
                    
                    // Cost is 1 for Green Brick ('G'), 0 otherwise ('S' or 'D')
                    int moveCost = (wall[nr][nc] == 'G' ? 1 : 0);
                    int newTotalCost = cur.cost + moveCost;

                    if (newTotalCost < dist[nr][nc]) {
                        dist[nr][nc] = newTotalCost;
                        
                        if (moveCost == 1)
                            dq.addLast(new Cell(nr, nc, newTotalCost)); // Cost 1 → add to back
                        else
                            dq.addFirst(new Cell(nr, nc, newTotalCost)); // Cost 0 → add to front
                    }
                }
            }
        }

        return -1; // Destination 'D' cannot be reached
    }

    /**
     * Parses the compressed string representation of a wall row into a char array.
     * Example: "3R1D" -> ['R', 'R', 'R', 'D']
     * @param compressedRow The string representing a row in compressed format.
     * @param n The dimension of the wall (N).
     * @return The expanded character array row.
     */
    private static char[] expandRow(String compressedRow, int n) {
        char[] row = new char[n];
        int col = 0;
        int i = 0;
        
        while (i < compressedRow.length() && col < n) {
            StringBuilder numStr = new StringBuilder();
            // Read the number part
            while (i < compressedRow.length() && Character.isDigit(compressedRow.charAt(i))) {
                numStr.append(compressedRow.charAt(i));
                i++;
            }
            
            int count = 1;
            if (numStr.length() > 0) {
                count = Integer.parseInt(numStr.toString());
            }
            
            if (i < compressedRow.length()) {
                char brickType = compressedRow.charAt(i);
                i++; // Move past the brick type
                
                // Expand the brick type 'count' times
                for (int k = 0; k < count && col < n; k++) {
                    row[col++] = brickType;
                }
            }
        }
        return row;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Assuming N is the first line input
        if (!sc.hasNextInt()) {
            System.err.println("Error: Expected wall size N.");
            return;
        }
        int n = sc.nextInt();
        sc.nextLine(); // Consume the rest of the line

        char[][] wall = new char[n][n];
        
        // Read and expand N rows
        for (int i = 0; i < n; i++) {
            if (!sc.hasNextLine()) {
                 System.err.println("Error: Insufficient input lines for wall.");
                 return;
            }
            String compressedRow = sc.nextLine().trim();
            wall[i] = expandRow(compressedRow, n);
        }

        // --- Debug Print Wall (Optional) ---
        // for (int i = 0; i < n; i++) {
        //     System.out.println(new String(wall[i]));
        // }
        // -----------------------------------

        int result = minGreenBricks(wall);
        System.out.println(result);
    }
}
