package Shcool;

public class WritingInstrument {
    private int substanceForWriting;


    public WritingInstrument(int substanceForWriting)
    {
        if(substanceForWriting >= 0)
        {
            this.substanceForWriting = substanceForWriting;
        }
        else
        {
            this.substanceForWriting = 0;
        }
    }

    public int getSubstanceForWriting()
    {
        return substanceForWriting;
    }

    public void writeDown()
    {
        substanceForWriting -= 10;

        System.out.println("Writing...");
        System.out.println("Written.");
    }
}
