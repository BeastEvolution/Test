package Shcool;

public class Pencil extends WritingInstrument {

    private int substanceForWriting;

    public Pencil(int substanceForWriting) {
        super(substanceForWriting);
    }

    public void writeDown()
    {
        substanceForWriting -= 10;
        System.out.println("Take Pencil.");
        System.out.println("Writing...");
        System.out.println("Written.");
    }
}
