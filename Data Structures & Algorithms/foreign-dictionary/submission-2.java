class Solution {
    
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    graph.get(word1.charAt(j)).add(word2.charAt(j));
                    break;
                }
            }
        }
        Map<Character, Boolean> visited = new HashMap<>();
        StringBuilder res = new StringBuilder();

        // 遍历图中的每一个字母
        for (char c : graph.keySet()) {
            // 如果 dfs 返回 true 说明有环，按照题目要求直接返回空字符串
            if (dfs(c, graph, visited, res)) {
                return "";
            }
        }

        // 重点：因为我们在 DFS 的最后才把节点加入 res（后序遍历），
        // 所以越基础（没有出边）的字母越早被加进去，整个结果其实是反的。
        // 最后必须 reverse() 一下才是真正的字典序！
        return res.reverse().toString();
    }
    private boolean dfs(char c, Map<Character, Set<Character>> graph, Map<Character, Boolean> visited, StringBuilder res) {
        if (visited.containsKey(c)) {
            return visited.get(c);
        }
        visited.put(c, true);
        for (char neighbor : graph.getOrDefault(c, new HashSet<>())) {
            if (dfs(neighbor, graph, visited, res)) {
                return true;
            }
        }
        visited.put(c, false);
        res.append(c);
        return false;
    }
}
