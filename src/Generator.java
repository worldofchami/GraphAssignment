import java.util.ArrayList;
import java.util.Random;

public class Generator
{
    private int vertices, edges;
    private Random random = new Random();

    private ArrayList<String> vertexNames;
    
    // Each vertex's connections array
    private ArrayList< ArrayList<String> > connectionMatrix;

    private int vCount;
    // Generate vertices in each text file
    // Generate corresponding edges
    // Generate random weights

    public Generator(int vertices, int edges)
    {
        this.vertices = vertices;
        this.edges = edges;
        this.vCount = 0;
        this.vertexNames = new ArrayList<String>();
        this.connectionMatrix = new ArrayList< ArrayList<String> >();

        // Populate connection matrix with empty AL's
        // Add every vertex with name to ArrayList
        for(int i = 0; i < vertices; i++)
        {
            connectionMatrix.add(
                new ArrayList<String>()
            );

            vertexNames.add("Node" + (i+1));
        }

        // For each edge, randomise nodes and create connection
        for(int j = 0; j < edges; j++)
        {
            int startVertexIndex = random.nextInt(vertices);
            int endVertexIndex = random.nextInt(vertices);

            ArrayList<String> startVertexConnections = connectionMatrix.get(startVertexIndex);
            ArrayList<String> endVertexConnections = connectionMatrix.get(endVertexIndex);

            String startVertex = vertexNames.get(startVertexIndex);
            String endVertex = vertexNames.get(endVertexIndex);

            // Ensures start always != end
            // Ensures no repetition --> end vertex connections doesn't include start vertex
            while(endVertexIndex == startVertexIndex || startVertexConnections.indexOf(endVertex) != -1)
            {
                endVertexIndex = random.nextInt(vertices);
                endVertex = vertexNames.get(endVertexIndex);
            }

            startVertexConnections.add(endVertex);
            endVertexConnections.add(startVertex);

            int weight = random.nextInt(10 - 1) + 1;

            System.out.println(String.format("%s %s %s", startVertex, endVertex, Integer.toString(weight)));
        }
    }
}
