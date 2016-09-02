package domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Clemencio Morales Lucas on 02/09/2016.
 */
public class AppearancesCounter {

    public static final String THE_INPUT_ARRAY_CANNOT_BE_NULL = "The input array cannot be null.";
    private Map counter;

    public AppearancesCounter(){
        this.counter = new HashMap<Integer, Integer>();
    }

    public int[][] calculateAppearances(int [] input) throws IllegalArgumentException{
        if (input == null){
            throw new IllegalArgumentException(THE_INPUT_ARRAY_CANNOT_BE_NULL);
        }
        for (int i = 0; i < input.length; i++){
            if(this.counter.containsKey(input[i])){
                this.counter.put(input[i], (Integer)counter.get(input[i]) + 1);
            } else {
                this.counter.put(input[i], 1);
            }
        }
        return formatSolution();
    }

    private int[][] formatSolution() {
        int[][] solution = new int[counter.size()][1];
        Iterator it = counter.entrySet().iterator();
        int aux = 0;
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            solution[aux] = new int[]{(int) pair.getKey(), (int) pair.getValue()};
            aux++;
            it.remove(); // Avoids a ConcurrentModificationException
        }
        return solution;
    }

    public static void main(String [] args){
        int [][] solution = new AppearancesCounter().calculateAppearances(new int[]{1, 2, 3, 1, 4, 1, 2, 43, 3});
        System.out.println(Arrays.deepToString(solution));
    }
}
