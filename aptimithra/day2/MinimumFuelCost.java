import java.util.*;

class MinimumFuelCost {
    private static List<List<Integer>> adj;
    private static int[] dist;

    public static int minFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1; 
        adj = new ArrayList<>(n);
        for (int i = 0; i < n; ++i)
            adj.add(new ArrayList<>());

        for (int[] road : roads) {
            int from = road[0], to = road[1];
            adj.get(from).add(to);
            adj.get(to).add(from);
        }

        dist = new int[n];
        Arrays.fill(dist, -1);
        dfs(0, -1, 0); 

        int minFuel = 0;
        for (int i = 1; i < n; i++) {
            int distance = dist[i];
            int fuelNeeded = (int) Math.ceil((double) distance / seats); 
            minFuel += fuelNeeded;
        }

        return minFuel;
    }

    private static void dfs(int node, int parent, int distance) {
        dist[node] = distance;
        for (int neighbor : adj.get(node)) {
            if (neighbor != parent)
                dfs(neighbor, node, distance + 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] roadsInput = scanner.nextLine().split(",\\s*");
        int[][] roads = new int[roadsInput.length][2];
        for (int i = 0; i < roadsInput.length; i++) {
            String[] road = roadsInput[i].split("\\s+");
            roads[i][0] = Integer.parseInt(road[0]);
            roads[i][1] = Integer.parseInt(road[1]);
        }
        int seats = scanner.nextInt();
        int result = minFuelCost(roads, seats);
        System.out.println(result);
    }
}
