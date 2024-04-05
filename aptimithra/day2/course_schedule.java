package aptimithra.day2;

public class course_schedule {
    
}
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            int ai = scanner.nextInt();
            int bi = scanner.nextInt();
            graph.get(ai).add(bi);
        }
        if (canFinishCourses(N, graph)) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
    private static boolean canFinishCourses(int numCourses, List<List<Integer>> prerequisites) {
        int[] inDegree = new int[numCourses];
        for (List<Integer> prerequisiteList : prerequisites) {
            for (int prerequisite : prerequisiteList) {
                inDegree[prerequisite]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            for (int neighbor : prerequisites.get(currentCourse)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] > 0) {
                return false;
            }
        }
        return true;
    }
}
