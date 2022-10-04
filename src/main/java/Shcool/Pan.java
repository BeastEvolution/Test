package Shcool;

public class Pan extends WritingInstrument{

    private int substanceForWriting;

    public Pan(int substanceForWriting) {
        super(substanceForWriting);
    }

    @Override
    public void writeDown() {
        substanceForWriting -= 5;

        System.out.println("Take Pan.");
        System.out.println("Writing...");
        System.out.println("Written.");
    }
}
