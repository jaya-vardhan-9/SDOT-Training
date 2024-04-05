import java.util.*;

public class DFS {

    static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int node) {
        visited[node] = true;
        System.out.print(node + " "); 

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(adj, visited, neighbor);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt(); 
        int E = sc.nextInt(); 

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
        }

        int startNode = sc.nextInt(); 

        boolean[] visited = new boolean[V];
        dfs(adj, visited, startNode);
    }
}