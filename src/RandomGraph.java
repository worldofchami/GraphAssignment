import java.util.ArrayList;
import java.util.Random;

public class RandomGraph
{
    private ArrayList<Integer> vertexValues;
    private ArrayList< ArrayList<Integer> > edgeValues;

    private Random random = new Random();

    private static final int MAX_VERTICES = 100;

    public RandomGraph()
    {
        this.vertexValues = new ArrayList<Integer>();
        // Randomise number of vertices by populating vertexValues AL
        int randomValue = (int) random.nextInt(MAX_VERTICES) + 10;

        while(vertexValues.size() < 5)
        {
            // Only add if randomValue is a multiple of 10
            if(randomValue % 10 == 0 && this.vertexValues.indexOf(randomValue) == -1 && randomValue != 0)
            {
                vertexValues.add(randomValue);
            }

            randomValue = random.nextInt(MAX_VERTICES) + 10;
        }

        this.edgeValues = new ArrayList< ArrayList<Integer> >();

        for(int i = 0; i < this.vertexValues.size(); i++)
        {
            this.edgeValues.add(
                new ArrayList<Integer>()
            );
        }
        
        int counter = 0;
        
        // Foreach vertex
        for(int vertexValue : this.vertexValues)
        {
            int edgesBound = (int) Math.pow(vertexValue, 2);

            ArrayList<Integer> currentVertexList = this.edgeValues.get(counter);

            double multiplier = 0.2;

            while(currentVertexList.size() < 5)
            {
                currentVertexList.add((int) (multiplier * edgesBound));

                multiplier += 0.15;
            }

            counter++;
        }

        // System.out.println(this.vertexValues.toString());
        // for(ArrayList<Integer> al : this.edgeValues)
        // {
        //     System.out.println(al.toString());
        // }
    }

    public ArrayList<Integer> getVertexValues() { return this.vertexValues; }
    public ArrayList< ArrayList<Integer> > getEdgeValues() { return this.edgeValues; }
}
