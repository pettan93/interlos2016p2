import java.util.*;

/**
 * Created by Pettan on 04.12.2016.
 */
public class P2 {


    public static String toString(Integer[] list) {
        List<Integer> l = Arrays.asList(list);
        String result = "";
        for (Integer number : l) {
            result = result + number;
        }
        return result;
    }


    public static Boolean isValid(Integer[] list) {
        List l = Arrays.asList(list);
        Integer n = l.size() / 2;
        for (int i = 0; i < n; i++) {
            Integer firstOccur = l.indexOf(i + 1) + 1;
            Integer lastOccur = l.lastIndexOf(i + 1) + 1;
            if ((lastOccur - firstOccur) != (i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static Integer[] make(Integer n) {

        Stack<Integer> unassigned = new Stack();
        HashSet<Integer> used = new HashSet<Integer>();

        for (int i = 1; i < n + 1; i++) unassigned.add(i);

        Integer[] arr = new Integer[n * 2];
        for (int i = 0; i < n * 2; i++) arr[i] = 0;

        while(unassigned.size() > 0){
            Integer toAssign = getUnusedRandom(n, used);

            Integer firstZero = getFirstZero(arr);

            if((firstZero + toAssign) >= arr.length) break;
            arr[firstZero] = toAssign;
            arr[firstZero + toAssign] = toAssign;

            unassigned.pop();
        }
        return arr;
    }


    public static Integer getUnusedRandom(Integer n, HashSet used) {
        Random random = new Random();
        int randomNumber = random.nextInt(n) + 1;
        while (used.contains(randomNumber)) {
            randomNumber = random.nextInt(n) + 1;
        }
        used.add(randomNumber);
        return randomNumber;

    }

    public static Integer getFirstZero(Integer[] l){
        for (int i = 0; i < l.length; i++) {
            if(l[i] == 0){
                return i;
            }
        }
        return null;
    }

}
