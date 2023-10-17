import java.util.Arrays;
import java.util.Random;

public class Main {

    public static int material(int[] spaceship){

        // Current position in the array
        int currentPosition = 0;
        // Last completely checked/added to the result position
        int checkedPosition = 0;
        // Current value used for comparisons, basically a maximum
        int currentValue = 0;
        // Variable for storing the final result of the function
        int result = 0;
        // Variable for storing the temporary assumed sum for addition to the result
        int temporarySum = 0;
        //  Variable used to increase efficiency in case of a big value range change
        int subsetMax = 0;

        while (checkedPosition < spaceship.length - 1){
            if(currentValue <= spaceship[currentPosition]){
                // if a value higher than or equal to the current top value is found, add the temporary sum to the result and readjust the variables
                currentValue = spaceship[currentPosition];
                result += temporarySum;
                temporarySum = 0;
                checkedPosition = currentPosition;
            } else if(currentPosition < spaceship.length - 1){
                // otherwise if this isn't the end of the array, increase the temporary sum by the difference in value
                temporarySum += currentValue - spaceship[currentPosition];

                // if the value exceeds current subsets maximum we adjust it for potential optimisation
                if(spaceship[currentPosition] > subsetMax){
                    subsetMax = spaceship[currentPosition];
                }
            } else {
                // finally if we run out of values and couldn't add the sum to the result, we need to try lowering our expectation and redoing the check
                currentValue -= 1;
                currentPosition = checkedPosition;
                temporarySum = 0;
            }
            // regardless we need to increase the currentPosition
            currentPosition++;
        }

        return result;
    }
    public static void main(String[] args) {

        // Cases given in the task itself
        int[] spaceship0 = {6, 4, 2, 0, 3, 2, 0, 3, 1, 4, 5, 3, 2, 7, 5, 3, 0, 1, 2, 1, 3, 4, 6, 8, 1, 3};
        int[] spaceship1 = {6, 2, 1, 1, 8, 0, 5, 5, 0, 1, 8, 9, 6, 9, 4, 8, 0, 0};
        int[] spaceship2 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] spaceship3 = {0, 1, 0, 2, 1, 0, 3, 1, 0, 1, 2};
        int[] spaceship4 = {4, 2, 0, 3, 2, 5};

        // Output of the "input" data and results of the material function

        System.out.println("Spaceship 1: " + Arrays.toString(spaceship0));
        System.out.println("Result of calculations: " + material(spaceship0) + "\n");

        System.out.println("Spaceship 2: " + Arrays.toString(spaceship1));
        System.out.println("Result of calculations: " + material(spaceship1) + "\n");

        System.out.println("Spaceship 3: " + Arrays.toString(spaceship2));
        System.out.println("Result of calculations: " + material(spaceship2) + "\n");

        System.out.println("Spaceship 4: " + Arrays.toString(spaceship3));
        System.out.println("Result of calculations: " + material(spaceship3) + "\n");

        System.out.println("Spaceship 5: " + Arrays.toString(spaceship4));
        System.out.println("Result of calculations: " + material(spaceship4) + "\n");

        // additional randomly generated case
        Random rand = new Random();
        int length = rand.nextInt(15) + 8;
        int[] spaceshipRandom = new int[length];
        for (int i = 0; i < length; i++) {
            spaceshipRandom[i] = rand.nextInt(20);
        }

        System.out.println("Spaceship randomly generated: " + Arrays.toString(spaceshipRandom));
        System.out.println("Result of calculations: " + material(spaceshipRandom));
    }
}