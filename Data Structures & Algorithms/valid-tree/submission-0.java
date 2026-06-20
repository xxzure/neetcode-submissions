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
        if (helper(0, -1, visited, graph) == false) return false;
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
