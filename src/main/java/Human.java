public class Human {
    public int speed;
    public static int a = 10;

    public void move(int metr)
    {

        if (metr <= 0)
        {
            System.out.println("Already in place.");
            return;
        }

        metr = a;
        System.out.println(metr);

        System.out.println("Пройшов " + speed + " шагів.");

        print();
    }

    public static void print()
    {
        System.out.println("Static print");
    }
}
