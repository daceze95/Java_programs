import java.util.*;
/**
 * A Program that randomly generates an array of assumed test results consist of 1 and 2 
 * where 1 equals pass and two equals fail. Then the program outputs the number of test results of each type and displays the summary of the result
* the instructor gets a bonus if the number of passes is greater than or equal to 8.
 */

public class RandomResultAndSummary {
    static HashMap<Integer, String> gradeValuation = new HashMap<>();
    static String instructorBonus;
    static int totalPassOrNumOfPassResult = 0;
    static int totalFailOrNumOfFailedResult = 0;

    static {
        gradeValuation.put(1, "Pass");
        gradeValuation.put(2, "Fail");
    }

    static int randResult(){
       double num =  Math.floor(Math.random() * 10);
       return (int)(num % gradeValuation.size());
    }

    static int[] randArray(){
        int[] studentGrade = new int[10];
        int count = 0;

        while (count < studentGrade.length){
            studentGrade[count] = randResult();
            count++;
        }

        return studentGrade;
    }

    static void output(){
        int[] studentGrade = randArray();

        //changes all the failed values to correspond to the key in the map object
        for (int i = 0; i < studentGrade.length; i++){
           if(studentGrade[i] != 1){
               studentGrade[i] = 2;
           }
        }

            if((studentGrade.length != 0)){
            for (int i = 0; i < studentGrade.length; i++){
                if(gradeValuation.containsKey(studentGrade[i])){
                    if(gradeValuation.get(studentGrade[i]).equals("Pass")){
                        totalPassOrNumOfPassResult++;
                    }else{
                        totalFailOrNumOfFailedResult++;
                    }
                }else{
                    System.out.printf("Key %d at index %d not found!%n", studentGrade[i], i);
                }
            }

            System.out.print("Result list: ");
            System.out.println(Arrays.toString(studentGrade));
            System.out.println("\n***** SUMMARY  *****");
            System.out.printf("Total pass: %d%n", totalPassOrNumOfPassResult);
            System.out.printf("Total fail: %d%n", totalFailOrNumOfFailedResult);
            System.out.print(instructorBonus = totalPassOrNumOfPassResult >= 8 ? "Bonus to instructor!\n" : "No Bonus\n" );

        }else{
            System.out.println("Error! Failed to fetch result. Please try again...");
        }

    }

    public static void main(String[] args){
        output();
    }

}

