import java.util.*;
public class StudentGradeCalculator
{
    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter no. of Subjects : ");
        int nsub = s.nextInt();
        int total = 0;
        for(int i=0;i<nsub;i++)
        {
            System.out.println("Enter marks obatined in Subject " + i +": ");
            int marks = s.nextInt(); 
            total += marks;
        }
        double averP = (double) total/nsub;
        String Grade;
        if(averP>=95)
        {
            Grade = "O";
        }
        else if(averP>=90)
        {
            Grade = "A+";
        }
        else if(averP>=80)
        {
            Grade = "A";
        }
        else if(averP>=70)
        {
            Grade = "B+";
        }
        else if(averP>=60)
        {
            Grade = "B";
        }
        else if(averP>=50)
        {
            Grade = "C";
        }
        else if(averP>=40)
        {
            Grade = "D";
        }
        else
        {
            Grade = "F";
        }
        System.out.println("Total Marks obtain is : " + total);
        System.out.println("Average Percentage Obtained : " + averP+"%" );
        System.out.println("Grade is : "+ Grade);

        s.close();

    }
}