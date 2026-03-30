import java.util.*;
import java.io.*;

public class PlumberPipes {
    
    static class Cell {
        int r, c;
        Cell(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine().trim());
        char[][] grid = new char[N][N];
        
        // Parse input and build grid
        for (int i = 0; i < N; i++) {
            String line = br.readLine().trim();
            int col = 0;
            int j = 0;
            
            while (j < line.length() && col < N) {
                // Parse number
                int numStart = j;
                while (j < line.length() && Character.isDigit(line.charAt(j))) {
                    j++;
                }
                int count = Integer.parseInt(line.substring(numStart, j));
                
                // Parse type
                char type = line.charAt(j);
                j++;
                
                // Fill grid
                for (int k = 0; k < count; k++) {
                    grid[i][col++] = type;
                }
            }
        }
        
        // Find all source and destination positions
        List<Cell> sources = new ArrayList<>();
        List<Cell> destinations = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 'S') {
                    sources.add(new Cell(i, j));
                } else if (grid[i][j] == 'D') {
                    destinations.add(new Cell(i, j));
                }
            }
        }
        
        // Multi-source BFS (0-1 BFS)
        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        
        Deque<Cell> deque = new ArrayDeque<>();
        
        // Add all sources with distance 0
        for (Cell src : sources) {
            dist[src.r][src.c] = 0;
            deque.addLast(src);
        }
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        while (!deque.isEmpty()) {
            Cell curr = deque.pollFirst();
            int r = curr.r, c = curr.c;
            
            // Check all 4 neighbors
            for (int dir = 0; dir < 4; dir++) {
                int nr = r + dr[dir];
                int nc = c + dc[dir];
                
                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    char cellType = grid[nr][nc];
                    
                    // Red bricks are blocked
                    if (cellType == 'R') continue;
                    
                    int newDist = dist[r][c];
                    
                    // Green bricks cost 1 to break
                    if (cellType == 'G') {
                        newDist++;
                    }
                    // S and D cost 0
                    
                    if (newDist < dist[nr][nc]) {
                        dist[nr][nc] = newDist;
                        if (cellType == 'G') {
                            deque.addLast(new Cell(nr, nc));
                        } else {
                            deque.addFirst(new Cell(nr, nc));
                        }
                    }
                }
            }
        }
        
        // Find minimum distance to any destination
        int minBreaks = Integer.MAX_VALUE;
        for (Cell dest : destinations) {
            minBreaks = Math.min(minBreaks, dist[dest.r][dest.c]);
        }
        
        System.out.println(minBreaks);
    }
}