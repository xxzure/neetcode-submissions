class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int res = 0;
        Set<Integer> visit = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (visit.contains(i) == false) {
                res++;
            }
            dfs(i, graph, visit);
        }
        return res;
    }
    private void dfs(int node, List<List<Integer>> graph, Set<Integer> visit) {
        if (visit.contains(node)) return;
        visit.add(node);
        for (int neighbor : graph.get(node)) {
            dfs(neighbor, graph, visit);
        }
    }
}
