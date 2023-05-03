import java.util.ArrayList;

public class GraphExperiment
{
    public static void main(String[] args)
    {
        RandomGraph rg = new RandomGraph();
        ArrayList<Integer> vertexValues = rg.getVertexValues();
        ArrayList< ArrayList<Integer> > edgeValues = rg.getEdgeValues();

        System.out.println(vertexValues);
        System.out.println(edgeValues);
        
        int counter = 0;
        for(int vertexValue : vertexValues)
        {
            ArrayList<Integer> currentEdgeList = edgeValues.get(counter);

            for(int edge : currentEdgeList)
            {
                System.out.println(vertexValue + "-" + edge);
                Generator g = new Generator(vertexValue, edge);

                g.createNewFile();
            }

            counter++;
        }
    }
}