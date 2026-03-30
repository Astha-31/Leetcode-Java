import java.util.*;

public class ScoutsPath {
    
    static class State {
        int pos1, pos2;
        long visited; // bitmask for visited towns
        int count;
        
        State(int pos1, int pos2, long visited, int count) {
            this.pos1 = pos1;
            this.pos2 = pos2;
            this.visited = visited;
            this.count = count;
        }
        
        String getKey() {
            return pos1 + "," + pos2 + "," + visited;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        int start1 = sc.nextInt();
        int start2 = sc.nextInt();
        int outpost = sc.nextInt();
        
        // BFS
        Queue<State> queue = new LinkedList<>();
        Set<String> visitedStates = new HashSet<>();
        
        // Initial state
        long initialVisited = (1L << start1) | (1L << start2);
        State initial = new State(start1, start2, initialVisited, 2);
        queue.offer(initial);
        visitedStates.add(initial.getKey());
        
        while (!queue.isEmpty()) {
            State curr = queue.poll();
            
            // Check if both reached outpost
            if (curr.pos1 == outpost && curr.pos2 == outpost) {
                System.out.println(curr.count);
                return;
            }
            
            // Scout 1 moves, Scout 2 stays
            if (curr.pos1 != outpost) {
                for (int next1 : graph.get(curr.pos1)) {
                    boolean isVisited = (curr.visited & (1L << next1)) != 0;
                    if (!isVisited || next1 == outpost) {
                        long newVisited = curr.visited | (1L << next1);
                        int newCount = curr.count + (isVisited ? 0 : 1);
                        State newState = new State(next1, curr.pos2, newVisited, newCount);
                        String key = newState.getKey();
                        if (!visitedStates.contains(key)) {
                            visitedStates.add(key);
                            queue.offer(newState);
                        }
                    }
                }
            }
            
            // Scout 2 moves, Scout 1 stays
            if (curr.pos2 != outpost) {
                for (int next2 : graph.get(curr.pos2)) {
                    boolean isVisited = (curr.visited & (1L << next2)) != 0;
                    if (!isVisited || next2 == outpost) {
                        long newVisited = curr.visited | (1L << next2);
                        int newCount = curr.count + (isVisited ? 0 : 1);
                        State newState = new State(curr.pos1, next2, newVisited, newCount);
                        String key = newState.getKey();
                        if (!visitedStates.contains(key)) {
                            visitedStates.add(key);
                            queue.offer(newState);
                        }
                    }
                }
            }
            
            // Both scouts move
            if (curr.pos1 != outpost && curr.pos2 != outpost) {
                for (int next1 : graph.get(curr.pos1)) {
                    for (int next2 : graph.get(curr.pos2)) {
                        // Cannot meet at same town unless it's outpost
                        if (next1 == next2 && next1 != outpost) {
                            continue;
                        }
                        
                        boolean isVisited1 = (curr.visited & (1L << next1)) != 0;
                        boolean isVisited2 = (curr.visited & (1L << next2)) != 0;
                        
                        if ((isVisited1 && next1 != outpost) || (isVisited2 && next2 != outpost)) {
                            continue;
                        }
                        
                        long newVisited = curr.visited | (1L << next1) | (1L << next2);
                        int addCount = 0;
                        if (!isVisited1) addCount++;
                        if (!isVisited2 && next1 != next2) addCount++;
                        int newCount = curr.count + addCount;
                        
                        State newState = new State(next1, next2, newVisited, newCount);
                        String key = newState.getKey();
                        if (!visitedStates.contains(key)) {
                            visitedStates.add(key);
                            queue.offer(newState);
                        }
                    }
                }
            }
        }
        
        System.out.println("Impossible");
    }
}