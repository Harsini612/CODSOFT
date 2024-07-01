import java.util.Scanner;
public class StudentGradeCalculator{
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.print("\033c");
        System.out.print("---------------STUDENT GRADE CALCULATOR---------------");
        System.out.println();
        System.out.println("Enter the Number Of Subjects: ");

        int numOfSub=sc.nextInt();
        int[] marks=new int[numOfSub];
        int totalMarksObtained=0;
        int total=0;

        for(int i=0;i<numOfSub;i++){
            System.out.println("Enter the marks obtained for subject "+(i+1)+" (out of 100): ");
            marks[i]=sc.nextInt();
            totalMarksObtained+=marks[i];
        }

        double avgPercentage=(double) totalMarksObtained/numOfSub;

        char grade;
        if(avgPercentage>=90){
            grade='A';
        }
        else if(avgPercentage>=80){
            grade='B';
        }
        else if(avgPercentage>=70){
            grade='C';
        }
        else if(avgPercentage>=60){
            grade='D';
        }
        else if(avgPercentage>=50){
            grade='E';
        }
        else{
            grade='F';
        }
        
        for(int i=0;i<numOfSub;i++){
            total=numOfSub*100;
        }

        System.out.println("--------RESULTS--------");
        System.out.println();
        System.out.println("Congratulations!! ");
        System.out.println("You've obtained "+totalMarksObtained+" out of "+total);
        System.out.println("Your Average percentage is "+avgPercentage+" %");
        System.out.println("Your grade is "+grade);

        sc.close();
    }

}