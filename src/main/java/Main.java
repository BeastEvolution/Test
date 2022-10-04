import Shcool.Student;

public class Main
{

    public static void main(String[] args)
    {
        Student student1 = new Student();
        student1.writeTextToNotebook(2);

    }

    public static void say (int a)
    {
        System.out.println(a);
    }

    public static void say (double a)
    {
        System.out.println(a + a);
        System.out.println(a);
    }
    public static void say (int a, int b)
    {
        System.out.println(a + b);
    }
}