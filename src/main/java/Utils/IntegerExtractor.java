package Utils;

public class IntegerExtractor {

    public static int extract(String num){
        //₹4,418
        String extractedNumber = "";
        for(Character c:num.toCharArray()){
            if(Character.isDigit(c))
                extractedNumber+=c;
        }
        System.out.println(extractedNumber);

        return Integer.parseInt(extractedNumber);
    }

    /*public static void main(String[] args) {
        extract("₹4,418");
    }*/
}
