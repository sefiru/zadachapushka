import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map<String, String> digitsO = Map.of(
            "0", "0",
            "1", "1",
            "2", "2",
            "3", "3",
            "4", "4",
            "5", "5",
            "6", "6",
            "7", "7",
            "8", "8",
            "9", "9"
    );

    public static void main(String[] args)  {

        long start = System.currentTimeMillis();

        ArrayList<String> frstSet = new ArrayList();
        frstSet.add("");
        ArrayList<ArrayList> fullSet = new ArrayList();
        fullSet.add(frstSet);
        ArrayList<ArrayList> fullSetTemp = new ArrayList();

        for ( int i = 1; i <= 10; i++ ) {
            for ( ArrayList set : fullSet ) {
                for ( Object intt : set ) {
                    ArrayList<String> tmp = kek( (String) intt, i );
                    if ( tmp.isEmpty() )
                        continue;
                    fullSetTemp.add( tmp );
                }
            }
            fullSet = new ArrayList(fullSetTemp);
            //System.out.println(fullSetTemp);
            fullSetTemp.clear();
        }

        System.out.println(System.currentTimeMillis() - start);
    }

    private static ArrayList<String> kek ( String number, int delim ) {

        HashMap<String, String> digits = new HashMap<>(digitsO);

        for ( int i = 0; i < number.length(); i++ ) {
            if ( digits.containsKey(""+number.charAt(i)) ) {
                digits.remove(""+number.charAt(i));
            }
        }


        ArrayList<String> result = new ArrayList<>();

        for (Map.Entry<String, String> entry : digits.entrySet()) {
            long tempInt = Long.parseLong(number + entry.getKey() );

            if ( tempInt % delim == 0 ) {
                result.add( number + entry.getKey() );
                if ( (number + entry.getKey()).length() == 10 ) {
                    System.out.println(tempInt);
                }
            }
        }
        return result;
    }
}
