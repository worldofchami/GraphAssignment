import java.util.ArrayList;
import java.util.Random;

public class RandomGraph
{
    public static final int INFINITY = 6; //(int) Double.MAX_VALUE;
    public static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private int vertices, edges;
    private Random random = new Random();
    private ArrayList < ArrayList<Vertex> > verticesAdjacentNodes;

    public RandomGraph()
    {
        this.vertices = 6; //random.nextInt(INFINITY - 1) + 1;
        this.edges = 6; //random.nextInt((int) (Math.pow(this.vertices, 2) + 1) - 1) + 1;
        this.verticesAdjacentNodes = new ArrayList< ArrayList<Vertex> >();

        for(int i = 0; i < this.vertices; i++)
        {
            this.verticesAdjacentNodes.add(new ArrayList<Vertex>());
        }

        for(int j = 0; j < this.edges; j++)
        {
            Vertex startVertex = new Vertex(ALPHABET.charAt(j) + ""); //new Vertex(ALPHABET.charAt(random.nextInt(vertices)) + "");
            Vertex endVertex = new Vertex(ALPHABET.charAt(random.nextInt(vertices)) + "");

            // if(!startVertex.equals(endVertex))
            {
                createEdge(startVertex, endVertex);
            }
        }
    }

    public void createEdge(Vertex start, Vertex end)
    {
        for(ArrayList<Vertex> adjacentNodeList : verticesAdjacentNodes)
        {
            if(adjacentNodeList.indexOf(start) == -1)
            {
                adjacentNodeList.add(end);
            }
        }
    }

    public String toString()
    {
        String output = "";

        for(ArrayList<Vertex> adjacentNodeList : verticesAdjacentNodes)
        {
            output += " ";
            for(Vertex vertex : adjacentNodeList)
            {
                output += vertex.name + " ";
            }
        }

        return output;
    }
}
