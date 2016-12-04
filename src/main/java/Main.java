import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pettan on 04.12.2016.
 */
public class Main {

    public static void main(String[] args) {

        List<BigInteger> vysledky = new ArrayList<BigInteger>();
        Integer[] arr;

        while (true) {
            arr = P2.make(8);
            if (P2.isValid(arr) && !vysledky.contains(new BigInteger(P2.toString(arr)))) {
                System.out.println(P2.toString(arr));
                vysledky.add(new BigInteger(P2.toString(arr)));
                System.out.println("Dosažených výsledků = " + vysledky.size());
            }
       }



    }
}
