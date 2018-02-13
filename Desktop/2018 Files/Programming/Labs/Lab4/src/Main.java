import java.util.Scanner;
public class Main {
    public static void main(String args[])
    {
        Scanner scnr = new Scanner(System.in);
        System.out.print("Enter a hexadecimal number: ");

        String hexNum = scnr.next();
        String s = "0x";

        boolean hexTrue = hexNum.contains(s);

        if (hexTrue) {
            hexNum=hexNum.substring(2);
        }

        int lengthHex = hexNum.length();
        int exp = lengthHex - 1 ;
        int placeHex = 0;
        long decimalValue = 0;

        while (exp >= 0) {
            char hexChar = hexNum.charAt(placeHex);
            long placeVal = 0 ;

           if (Character.isDigit(hexNum.charAt(placeHex))) {
               int hexCharASCII = (int) hexChar;
               placeVal = hexCharASCII - (int)'0';
           }
           else if (Character.isLetter(hexNum.charAt(placeHex))) {
               char hexUpperCase = Character.toUpperCase(hexChar);
               int hexCharASCII = (int) hexUpperCase;
               placeVal = (hexCharASCII - (int)'A') + 10;;
           }

           long decimalPlace = placeVal* (long)Math.pow(16, exp);

           decimalValue=decimalValue+decimalPlace;
           exp--;
           placeHex++;
        }
        System.out.println("Your number is "+decimalValue+" in decimal");
    }
}