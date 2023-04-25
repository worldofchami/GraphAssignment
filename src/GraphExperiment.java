import java.util.Random;

public class GraphExperiment
{
    public static void main(String[] args)
    {
        int vertices, edges;
        vertices = 6; //(int) Math.abs(Math.random() * 10);
        edges = 8; //(int) ((Math.random()) * (Math.pow(vertices, 2) + 1));
        
        /*
            Format:
            A B 2
            A D 4
            A E 3
            B C 5
            C E 6
            C F 8
            D E 1
            E F 7
        */

        /*

        */

        // final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // String alphabetRange = alphabet.substring(0, vertices);

        // for(int i = 0; i < edges; i++)
        // {
        //     String firstLetter = alphabetRange.charAt(i) + "";
        //     String newRange = alphabetRange.substring(i+1, alphabetRange.length());

        //     Random random = new Random();
        //     int idx = (int) (random.nextInt(alphabetRange.length() - (i+1)) + (i+1));
        //     System.out.println(firstLetter + " " + alphabetRange.charAt(idx-2));
        // }

        // Graph graph = new Graph();
        
        RandomGraph rg = new RandomGraph();

        System.out.println(rg);
    }
}