import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Generator
{
    private int vertices, edges;
    private Random random = new Random();

    private String contents;

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
        this.contents = "";

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
        while(matrixSublength(connectionMatrix) < edges)
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

            endVertexConnections = connectionMatrix.get(endVertexIndex);

            endVertexConnections.add(startVertex);

            startVertexConnections.add(endVertex);

            // System.out.println(startVertexConnections.toString());

            int weight = random.nextInt(10 - 1) + 1;

            contents += String.format("%s %s %s", startVertex, endVertex, Integer.toString(weight)) + "\n";
            
            // int c = 0;
            // for(ArrayList<String> al : connectionMatrix)
            // {
            //     if(!al.isEmpty()) System.out.println(c + " " + al);
            //     c++;
            // }
            // System.out.println("----------------------------");
        }

        contents = contents.trim();        
    }

    private int matrixSublength(ArrayList< ArrayList<String> > matrix)
    {
        int count = 0;

        for(ArrayList<String> list : matrix)
        {
            if(!list.isEmpty())
                count++;
        }

        return count;
    }

    public void createNewFile()
    {
        String fileName = "data/Dataset-" + vertices + "-" + edges + ".txt";

        try
        {
            File file = new File(fileName);

            if(file.createNewFile())
                System.out.println("File " + file.getName() + " created");
            
            else
                System.out.println("File " + fileName + " already exists");

            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(contents);
            fileWriter.close();
        }

        catch(Exception e)
        {
            System.out.println("File error");
        }
    }
}
