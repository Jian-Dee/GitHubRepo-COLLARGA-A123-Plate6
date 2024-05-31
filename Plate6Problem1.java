import java.util.*;

public class Plate6Problem1 {

    private static void searchPath(String nodeCollarga, Map<String, List<String>> adjListCollarga, Set<String> visitedCollarga) {
        visitedCollarga.add(nodeCollarga);
        for (String neighborCollarga : adjListCollarga.get(nodeCollarga)) {
            if (!visitedCollarga.contains(neighborCollarga)) {
                searchPath(neighborCollarga, adjListCollarga, visitedCollarga);
            }
        }
    }

    public static void main(String[] args) {
        Scanner inCollarga = new Scanner(System.in);

        Map<String, List<String>> adjListCollarga = new HashMap<>();
        Set<String> verticesCollarga = new HashSet<>();


        System.out.println("Enter the edges (e.g. \"ab\"). (Type 'end' to finish):");
        while (true) {
            String inputCollarga = inCollarga.nextLine();
            if (inputCollarga.equalsIgnoreCase("end")) {
                break;
            }

            if (inputCollarga.length() != 2) {
                System.out.println("Invalid edge format. Please use \"ab\" format.");
                continue;
            }

            String u = inputCollarga.substring(0,1);
            String v = inputCollarga.substring(1);

            verticesCollarga.add(u);
            verticesCollarga.add(v);

            adjListCollarga.putIfAbsent(u, new ArrayList<>());
            adjListCollarga.putIfAbsent(v, new ArrayList<>());

            adjListCollarga.get(u).add(v);
            adjListCollarga.get(v).add(u);
        }

        Set<String> visitedCollarga = new HashSet<>();
        int componentCountCollarga = 0;
        
        // check each vertex of it traverse all the edges at once without disconnecting.
        for (String vertex : verticesCollarga) {
            if (!visitedCollarga.contains(vertex)) {
                searchPath(vertex, adjListCollarga, visitedCollarga);
                componentCountCollarga++;
            }
        }

        if (componentCountCollarga == 1) {
            System.out.println("The graph is connected.");
        } else {
            System.out.println("The graph is not connected.");
            System.out.println("Number of connected components: " + componentCountCollarga);
        }

        inCollarga.close();
    }

}
