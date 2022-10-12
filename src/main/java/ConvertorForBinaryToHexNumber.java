import java.util.ArrayList;
import java.util.List;

public class ConvertorForBinaryToHexNumber {

    public static String  convertBinaryNumberIntoHexNumber(String binaryNumber)
    {
        String hexNumber = "";

        List<Integer> ListOfBinaryNumberDigits = convertStringToListRepresentationOfBinaryNumber(binaryNumber);

        List<List<Integer>> BinaryRepresentationOfHexDigit = getBinaryRepresentingOfHexDigits(ListOfBinaryNumberDigits);

        for (List<Integer> hexDigit : BinaryRepresentationOfHexDigit)
        {
            hexNumber += convertBinaryNumberIntoHexDigit(hexDigit);
        }

        return hexNumber;
    }

    private static List<Integer> convertStringToListRepresentationOfBinaryNumber(String binaryNumber)
    {
        List<Integer> listOfInteger = new ArrayList<>();

        char[] charArray = binaryNumber.toCharArray();

        if (charArray.length % 4 != 0)
        {
            int numberOfZerosToRepresentNumberCorrectly = 4 - (charArray.length % 4);
            for (int i = 0; i < numberOfZerosToRepresentNumberCorrectly; i++)
            {
                listOfInteger.add(0);
            }
        }
        for (char character: charArray)
        {
            listOfInteger.add(Character.digit(character,2));
        }

        return listOfInteger;
    }

    /*
        Get a list of binary digits representing one digit in the hexadecimal system.
        And put all hex digit in one list.
     */
    private static List<List<Integer>> getBinaryRepresentingOfHexDigits(List<Integer> binaryNumber)
    {
        List<List<Integer>> BinaryRepresentationOfHexDigit = new ArrayList<>();

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

        numberInDecimalSystem = convertBinaryNumberIntoDecimalNum(binaryNumber);

        return arrayOfHexDigit[numberInDecimalSystem];
    }

    private static int convertBinaryNumberIntoDecimalNum(List<Integer> binaryNumber)
    {
        int decimalNumber = 0;

        int PositionOfCurrentDigitInList = binaryNumber.size() - 1;
        for (int indexOfDigit = 0; indexOfDigit < binaryNumber.size(); indexOfDigit++)
        {
            decimalNumber += binaryNumber.get(PositionOfCurrentDigitInList)
                    * (int) Math.pow(2.0, (double) indexOfDigit);

            PositionOfCurrentDigitInList--;
        }

        return decimalNumber;
    }
}
