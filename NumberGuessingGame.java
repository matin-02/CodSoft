import java.util.*;


public class NumberGuessingGame
{
    /**
     * @param args
     */
    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        int chances = 5;
        int finals=0;
        boolean playAgain = true;
        System.out.println(" WELCOME TO THE GUESSING GAME  : ");

        System.out.println(" You Have " + chances + " To Win the Game : ");

        while(playAgain)
        {
            int rand = getrandN(1,100);
            boolean guess = false;
            System.out.println(" Guess the Number");
            for(int i=0;i < chances ; i++)
            {
                System.out.println(" Chances " + (i+1) + "  Guess the Number : ");
                int num = s.nextInt();
                if(num == rand)
                {
                    guess = true;
                    finals+=1;
                    System.out.println(" CONGRALUTION YOU WON THE GAME : ");
                    break;
                }
                else if(num > rand)
                {
                    System.out.println(" OO NO IT'S TOO HIGH : ");
                }
                else
                {
                    System.out.println(" SORRY NUMBER ID TOO LOW :  ");
                }
                if(guess == false)
                {
                    System.out.println(" YOU LOOSE THE GAME ");
                    System.out.println(" THE NUMBER WAS " + rand);
                }
                   /*System.out.println(" DO YOU WANT PLAY AGAIN(y/n)");
                    String pa = s.next();
                    playAgain = pa.equalsIgnoreCase("y");*/
                
            }
            System.out.println("Here is your Score : " + finals);
        }
    }
            
            public static int getrandN(int min,int max)
            {
                return (int)(Math.random() * (max - min + 1) + min);
            }
}

