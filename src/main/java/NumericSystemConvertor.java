import java.util.ArrayList;
import java.util.List;

public class NumericSystemConvertor {

    public static String  convertBinaryNumberIntoHexNumber(String binaryNumber)
    {
        String hexNumber = "";

        List<Integer> ListOfBinaryNumberDigits = convertToListOfBinaryDigitMultipleOfFour(binaryNumber);

        List<List<Integer>> BinaryRepresentationOfHexDigit = getBinaryRepresentingOfHexDigits(ListOfBinaryNumberDigits);

        for (List<Integer> hexDigit : BinaryRepresentationOfHexDigit)
        {
            hexNumber += convertBinaryNumberIntoHexDigit(hexDigit);
        }

        return hexNumber;
    }

    /*
        Turns a binary number record as a sting, into a list consisting of digits of that number.
        Add zeros to the left side to make the number of elements a multiple of four.
        To convert this number to hexadecimal system in the future.
     */
    private static List<Integer> convertToListOfBinaryDigitMultipleOfFour(String binaryNumber)
    {
        int initialCapacity = binaryNumber.length() + (4 - binaryNumber.length() % 4);
        List<Integer> listOfBinaryDigits = new ArrayList<>(initialCapacity);

        char[] charArray = binaryNumber.toCharArray();

        //Add zeros in begining of List to represent the hex digits correctly.
        if (charArray.length % 4 != 0)
        {
            int numberOfZerosToRepresentNumberCorrectly = 4 - (charArray.length % 4);
            for (int i = 0; i < numberOfZerosToRepresentNumberCorrectly; i++)
            {
                listOfBinaryDigits.add(0);
            }
        }

        for (char character: charArray)
        {
            listOfBinaryDigits.add(Character.digit(character,2));
        }

        return listOfBinaryDigits;
    }

    /*
        Get a list of binary digits representing one digit in the hexadecimal system.
        And put all hex digit in one list.
     */
    private static List<List<Integer>> getBinaryRepresentingOfHexDigits(List<Integer> binaryNumber)
    {
        int initialCapacity = binaryNumber.size() / 4;
        List<List<Integer>> BinaryRepresentationOfHexDigit = new ArrayList<>(initialCapacity);

        for (int beginingIndexOfHexNumber = 0, endingIndexOfHexNumber = 4;
             endingIndexOfHexNumber <= binaryNumber.size();
             beginingIndexOfHexNumber = endingIndexOfHexNumber, endingIndexOfHexNumber += 4)
        {
            BinaryRepresentationOfHexDigit.add(binaryNumber.subList(beginingIndexOfHexNumber, endingIndexOfHexNumber));
        }

        return BinaryRepresentationOfHexDigit;
    }

    private static char convertBinaryNumberIntoHexDigit(List<Integer> binaryNumber)
    {
        char[] arrayOfHexDigit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        int numberInDecimalSystem = 0;

        numberInDecimalSystem = convertBinaryNumberIntoDecimalDigit(binaryNumber);

        return arrayOfHexDigit[numberInDecimalSystem];
    }

    private static int convertBinaryNumberIntoDecimalDigit(List<Integer> binaryRepresentationOfOneHexDigit)
    {
        int decimalNumber = 0;

        int PositionOfCurrentDigitInList = binaryRepresentationOfOneHexDigit.size() - 1;
        for (int indexOfDigit = 0; indexOfDigit < binaryRepresentationOfOneHexDigit.size(); indexOfDigit++)
        {
            decimalNumber += binaryRepresentationOfOneHexDigit.get(PositionOfCurrentDigitInList)
                    * (int) Math.pow(2.0, (double) indexOfDigit);

            PositionOfCurrentDigitInList--;
        }

        return decimalNumber;
    }
}
