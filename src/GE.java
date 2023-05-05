import java.util.ArrayList;

public class GE
{
    public static void main(String[] args)
    {
        Graph graph = new Graph();
        String[] files = {"data/Dataset-20-140.txt"};
        int vertices = Integer.parseInt(files[0].substring(files[0].indexOf('-')+1, files[0].lastIndexOf("-")));

        graph.main(files);

        // ArrayList<Double> d = graph.distances;
        // removeEverySecond(d);

        // System.out.println(d.size());

        // graph.dijkstra("Node" + vertices);
    }

    public static void removeEverySecond(ArrayList<Double> list)
    {
        for(int i = 0; i < list.size(); i+=2)
        {
            list.remove(i);
        }
    }
}
