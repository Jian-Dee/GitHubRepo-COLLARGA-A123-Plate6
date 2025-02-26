import java.util.*;

public class Plate6Problem5 {
    public static boolean isBipartite(Map<String, List<String>> adjList, Set<String> vertexSet) {
        Map<String, Integer> group = new HashMap<>();
        Queue<String> queue = new LinkedList<>();

        for (String start : vertexSet) {
            if (!group.containsKey(start)) {
                queue.add(start);
                group.put(start, 0); // Assign a group (0 or 1)

                while (!queue.isEmpty()) {
                    String node = queue.poll();
                    int currentGroup = group.get(node);

                    for (String neighbor : adjList.get(node)) {
                        if (!group.containsKey(neighbor)) {
                            group.put(neighbor, 1 - currentGroup); // Assign the opposite group to the neighbor
                            queue.add(neighbor);
                        } else if (group.get(neighbor) == currentGroup) {
                            return false; // If the neighbor is in the same group, the graph is not bipartite
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, List<String>> adjList = new HashMap<>();
        Set<String> vertexSet = new HashSet<>();

        System.out.println("Bipartite Graph Checker || by Jian Collarga");

        System.out.println("Enter the edges (e.g. \"ab\") (type 'end' to finish):");

        while (true) {
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("end")) {
                break;
            }

            if (input.length() != 2) {
                System.out.println("Invalid edge format. Please use (e.g. \"ab\") format.");
                continue;
            }

            String u = input.substring(0,1);
            String v = input.substring(1);

            vertexSet.add(u);
            vertexSet.add(v);

            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.putIfAbsent(v, new ArrayList<>());

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        boolean isBipartite = isBipartite(adjList, vertexSet);

        if (isBipartite) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }

        sc.close();
    }

}
