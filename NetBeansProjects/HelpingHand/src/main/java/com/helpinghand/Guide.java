
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author macam
 */
public class Guide {
    
private static final ArrayList<Integer> breedPercentageArrayList = new ArrayList();

    public static void main(String[] args) {

       final Scanner scanner = new Scanner(System.in);
      System.out.print("What is your dogs name?: ");
      final String userDogName = scanner.nextLine();

      final String[] dogBreedArray = {"Husky", "Pug", "Pitbull", "Lab", "Poodle"};

      final int firstPercentage = getInitialDogBreedPercentage();
      breedPercentageArrayList.add(firstPercentage);

      final int secondPercentage = getRandomNumber(0, 100 - getArrayListSum());
      breedPercentageArrayList.add(secondPercentage);

      final int thirdPercentage = getRandomNumber(0, 100 - getArrayListSum());
      breedPercentageArrayList.add(thirdPercentage);

      final int fourthPercentage = getRandomNumber(0, 100 - getArrayListSum());
      breedPercentageArrayList.add(fourthPercentage);

      final int lastPercentage = 100 - getArrayListSum();
      breedPercentageArrayList.add(lastPercentage);





      System.out.println(userDogName + "'s genetics:");
      for (int i = 0; i < breedPercentageArrayList.size(); i++) {
         System.out.println(dogBreedArray[i] + " : " + Integer.toString(breedPercentageArrayList
            .get
            (i)) + "%");
      }
   }


   private static int getInitialDogBreedPercentage() {
      return getRandomNumber(0, 100);
   }


   private static int getRandomNumber(int randomFloor, int
      randomCeiling) {
       final Random random = new Random();
      return random.nextInt(randomCeiling - randomFloor) + randomFloor;
   }


   private static int getArrayListSum() {
       int sum = 0;
       for (int i = 0; i < breedPercentageArrayList.size(); i++ ) {
          sum = sum + breedPercentageArrayList.get(i);
      }
      return sum;
   }
}