import java.util.ArrayList;

public class Test
{
    public static int instancesOf(String string, char character)
    {
        if(string.length() == 0)
            return 0;

        else if(string.charAt(0) == character)
            return 1 + instancesOf(string.substring(1), character);
        
        else
            return instancesOf(string.substring(1), character);
    }

    public static void main(String[] args)
    {
        ArrayList< ArrayList<Integer> > ali = new ArrayList< ArrayList<Integer> >();

        for(int i = 0; i < 3; i++)
        {
            ali.add(new ArrayList<Integer>());
        }

        ArrayList<Integer> one = ali.get(0);
        one.add(3);

        for(ArrayList<Integer> al : ali)
        {
            System.out.println(al);
        }
    }
}
