import java.util.*;

public class Solution{
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        // Build the adjacency list
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prereq = pair[1];
            adj.get(prereq).add(course); // edge: prereq → course
            inDegree[course]++;
        }

        // Queue for nodes with 0 in-degree
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0)
                queue.add(i);
        }

        int visited = 0;

        // Kahn’s BFS
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            visited++;
            System.out.println(curr + "->");


            for (int neighbor : adj.get(curr)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // If we visited all nodes, return true
        return visited == numCourses;
    }
}

    