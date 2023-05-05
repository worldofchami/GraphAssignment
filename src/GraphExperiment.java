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

        //20: [80, 140, 200, 260, 320]
        //30: [180, 315, 450, 585, 720]
        //40: [320, 560, 800, 1040, 1280]
        //50: [500, 875, 1250, 1625, 2000]

        // int counter = 0;
        // for(int vertexValue : vertexValues)
        // {
        //     ArrayList<Integer> currentEdgeList = edgeValues.get(counter);

        //     for(int edge : currentEdgeList)
        //     {
        //         System.out.println(vertexValue + "-" + edge);
        //         Generator g = new Generator(vertexValue, edge);

        //         g.createNewFile();
        //     }

        //     counter++;
        // }

        // Generator g = new Generator(20, 80);
        // g.createNewFile();
    }
}