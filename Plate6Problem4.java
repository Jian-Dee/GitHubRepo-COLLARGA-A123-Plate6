import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Plate6Problem4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Map<String, Integer> vertexToDegree = new HashMap<>();

        System.out.println("Vertex Degrees Checker || by Jian Collarga");

        System.out.println("Enter the edges (e.g. \"ab\") (type 'end' to finish):");

        while (true) {
            String input = in.nextLine();
            if(input.equalsIgnoreCase("end")){
                break;
            }

            if(input.length() != 2){
                System.out.println("Invalid edge format.  use \"ab\" format.");
                continue;
            }

            String u = input.substring(0,1);
            String v = input.substring(1);

            // add one if degree to the vertex
            vertexToDegree.put(u, vertexToDegree.getOrDefault(u, 0) + 1);
            vertexToDegree.put(v, vertexToDegree.getOrDefault(v, 0) + 1);
        }

        System.out.println("Degrees of vertices:");     
        vertexToDegree.forEach((vertex, degree) -> {
            System.out.println("deg(" + vertex + ") = " + degree);
        });
        
        in.close();
    }
}
