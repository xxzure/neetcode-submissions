class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length > n - 1) {
            return false;
        }
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);

        }
        Set<Integer> visited = new HashSet<>();
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        while(queue.isEmpty() == false) {
            int size = queue.size();
            while(size != 0) {
                int node = queue.removeFirst();
                visited.add(node);
                for (int neighbor : graph.get(node)) {
                    if (visited.contains(neighbor)) {
                        if (graph.get(neighbor).contains(node)) {
                            continue;
                        }
                        return false;
                    }
                    queue.add(neighbor);
                    
                }
                size--;
            }
        }

        return visited.size() == n;
    }
    private boolean helper(int n, int parent, Set<Integer> visited, List<List<Integer>> graph) {
        if (visited.contains(n)) {
            return false;
        }
        visited.add(n);
        for (int neighbor : graph.get(n)) {
            if (neighbor == parent) {
                continue;
            }
            if (helper(neighbor, n, visited, graph) == false) {
                return false;
            } 
        }
        return true;
    }
}
