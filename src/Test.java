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
        System.out.println(instancesOf("test", 't'));
    }
}
