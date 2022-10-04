package Shcool;

public class Student {
    Pan pan1 = new Pan(50);
    Pencil pencil1 = new Pencil(50);

    public void writeTextToNotebook(int a)
    {
        if(a == 1)
        {
            write(pan1);
        } else if (a == 2) {
            write(pencil1);
        }
    }

    private void write(WritingInstrument writingInstrument1)
    {
        writingInstrument1.writeDown();
    }
}
