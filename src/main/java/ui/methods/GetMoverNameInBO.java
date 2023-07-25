package ui.methods;

public class GetMoverNameInBO {
    public static String substringMoverName(String input){
        String staticPrefix = "Carrier Name: ";
        int startIndex = input.indexOf(staticPrefix) + staticPrefix.length();
        int endIndex = input.indexOf("/");
        return input.substring(startIndex, endIndex).trim();
    }
}
