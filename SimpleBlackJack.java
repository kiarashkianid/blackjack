//SimpleBlackJack.java 
//Kiarash Kiani Dehkordi
//2021/01/01
//This program will make a simple version of blackjack game 
//...............................................................................................................................................................
//The rules of the game                                                                                                                                         .
//#)When the game starts, the player will be dealt a random card.The player’s cards are added to a count,If the card is a 2, 3, 4, 5, 6, 7, 8, 9 or 10,         .
//  it adds the value of the card.If the card is a J, Q or a K, it has a value of 10.If the card is an A, the user can choose whether they want it to           .
//  add 1 or 11 .                                                                                                                                               .     
//#)The player then gets to choose if they would like another card or to stop with the cards they have.If the player has a total of EXACTLY 21                  .
//  they win immediately and the game ends.If the player has a total HIGHER than 21, they lose immediately and the game ends.                                   .
//#)If the player has a total LESS than 21,the computer takes their turn.The computer will ALWAYS ask for a card if it has a total of 16 or less.               .
//  The computer will ALWAYS stop if it has a total of 17 or higher.                                                                                            .
//#)If the computer gets an A card:It will treat it as an 11 UNLESS it would make their score go over 21.If it would make the computer’s score go over 21,      .
//  they will treat it as a 1.                                                                                                                                  .
//#)Once the computer has its turn, the game will announce the winner and the game can end.                                                                     .
// If the computer has a score of higher than 21, the player wins, If the player has a higher score than the computer without going over 21, the player wins.   .
// If the player and the computer have the same score, the computer wins.Otherwise, if the computer has a higher score, the computer wins.                      .  
//...............................................................................................................................................................
//The comment with $ symbol are where the extra modifications are happening
//The modifications i did in this program are:
//-letting user play again
//-Making the program to not let a card dealt more than 4 times
//-letting the user to place a bet and also printing number of win and loses of the player and the money he won at the end
//-printing computer deck at the end if player wont win or lose by getting 21 or passing 21
   
import java.util.*;
import java.lang.*;


public class SimpleBlackJack
{
   public static void main(String[]args)
   {  
      //Declaring the variables
      int playerCard,computerCard,scoreP=0,scoreC=0,play=1,again=1;//scoreP is the score of player in the loop,scoreC is score of computer
      int[ ] winLose;//$This array will keep the number of win and loses of player and also the money they want to bet
      int[ ] computerDeck;//$This arrey will keep the deck of the computer
      int[ ] countCard;//$This arrey will keep the number of cards so a card wont dealt more than 4 times
      int i=0; 
      int mod;//$A flag for complex modification that will alow me to dealt each card for a max of 4 times 
      
      
      Scanner sc = new Scanner(System.in);
      winLose= new int[3];
      computerDeck= new int[21];
      countCard=new int[13];//$The size should be 13 cause there are 13 cards in this game and each unit of it will hold number of the cards with number of the unit that had been dealt
      
      winLose[0]=0;//Number of win
      winLose[1]=0;//Number of loses
      winLose[2]=0;//Money you win
      
      System.out.println("##    Welcome to black jack   ##");
      System.out.println("............................................................................................................................");
      //$The first while of the program will let the user to play as many times as they want
      while(again==1)
      {
      
         //$After each match player and computer score and their card become equal to zero      
         i=0;
         scoreP=0;
         scoreC=0;
         play=1;//$This var is a flag that will let only 4 cards dealt from each number 
         mod=1;
         //$The following line will ask the user if they want to put a bet on the game
         System.out.print("How much money do you want to bet on this game ?(enter $0 if you dont like to bet) :$");
         winLose[2]=sc.nextInt();
         System.out.println("Your bet is $"+winLose[2]+" it will double if you win and you will lose it all if you lose.");
         //$The following for loop will make the number of cards 0 every time 
         for(int k=0;k<=13;k++)
         {
            countCard[i]=0;
         }
         
         //The following while block will give player random cards untill they win or lose or its computer turn
         while(play==1)
         {     
            
            
            mod=1;
            
            //$ The following block will give only cards that havnt been dealt more than 4 times to the user 
            playerCard=(int)(Math.random() * 13)+1;
            while(mod==1)
            {
               playerCard=(int)(Math.random() * 13)+1;
               if (countCard[(playerCard-1)]<4)
               {
                  countCard[(playerCard-1)]++;
                  mod=0;
               }
            }
            mod=1;//$ The flag=1 so the same goes for the computer
            System.out.print("-here is your card ..... ");
            //$The following switch case block will print user cards ex; 1-10,J,Q,K and A
         
            switch(playerCard)
            {
               case(1):
                  System.out.print("Ace");
                  break;
               case(2):
                  System.out.print("2");
                  break;
               case(3):
                  System.out.print("3 ");
                  break;
               case(4):
                  System.out.print("4");
                  break;     
               case(5):
                  System.out.print("5");
                  break;
               case(6):
                  System.out.print("6");
                  break;
               case(7):
                  System.out.print("7");
                  break;     
               case(8):
                  System.out.print("8");
                  break;
               case(9):
                  System.out.print("9");
                  break;
               case(10):
                  System.out.print("10");
                  break;
               case(11):
                  System.out.print("jack");
                  break;
               case(12):
                  System.out.print("queen");
                  break;
               case(13):
                  System.out.print("king");
            }
            //This if block will let the player to chose the value for an ace card if they get one
            if(playerCard==1)
            {
               System.out.println("\nDo you want your ace card to have the value of 1 or 11 : ");
               playerCard=sc.nextInt();   
               scoreP+=playerCard;
            }
            else if(playerCard>=10)
            {
               scoreP+=10;
            }
            else
            {
               scoreP+=playerCard;
            }
            //This part will ask player if they want another card or not
            if(scoreP<21)
            {
               System.out.println("\nEnter 1 to get another card if you dont want to get another card enter another integer : ");
               play=sc.nextInt();
            }
            if(scoreP>=21)
            {
               play=4;
            }
         }
         //The following block will check if player win by getting 21 or lose by passing 21
         if(scoreP==21)
         {
            System.out.println("\n\nWow congrajulation!!!!!You win   :)");
            //Keep number of win and loses
            winLose[0]++;
            winLose[2]=winLose[2]*2;
            play=6;
         }
         else if(scoreP>21)
         {
            System.out.println("\nYou lose your score is higher than 21   :( ");
            //Keep number of win and loses
            winLose[1]++;
            winLose[2]=0;
            play=6;//This is another flag i used so if scoreP>21 then computer wouldnt get a card and player will lose imidietly
         }
         else
         {
            play=1;
         }
         //The following while will check if the user have not win or lose and its computer turn
         while(play==1)
         {
         
            //$The following block of code will check if computer card is already more than 4 times given so it gives a new card 
            mod=1;
            computerCard=(int)(Math.random() * 13)+1;
            while(mod==1)
            {
               computerCard=(int)(Math.random() * 13)+1;
               if (countCard[(computerCard-1)]<4)//$Check if we have more than 4 of one card so it can give a new card
               {
                  countCard[(computerCard-1)]++;
                  mod=0;
                  
               }
            }
            mod=1;
              
            
            if(computerCard>=10)//Check if the random card is j,k,q
            {
               scoreC+=10;
            }
            else if(computerCard==1)//This  else if block will check if computer gets an ace card what value it should use
            {
               if((scoreC+11)<=21)
               {
                  scoreC+=11;
               }
               else
               {
                  scoreC++;
               }
            }
            else//Check if computer gets 2-9
            {
               scoreC+=computerCard;
            }
            if(scoreC>=17)//This if block will check if computer needs to get another card or not
            {
               play=5;
            }
            computerDeck[i]=computerCard;//This line will save the computer deck so if computer win or lose it can show its deck of card
            i++;
         }
         
         //The following block of code will check if the player win or lose against computer
         if(scoreC>=scoreP && scoreP<21 && scoreC<22)
         {
            System.out.println("Computer won this match");
            winLose[1]++;//Number of win
            winLose[2]=0;//Calculate the money u will have if u win
         }         
         System.out.println("\n.......................................................................................................................");
         if (scoreP<21 && scoreC>0 && play!=6)//Check if computer win or lose so it can prints its deck of card
         {
            
            System.out.println("deck of computer was :");
            for(int j=0;j<=i;j++)
            {
               //The following switch case will print the deck of card of the computer 
               switch(computerDeck[j])
               {
                  case(1):
                     System.out.print("Ace,");
                     break;
                  case(2):
                     System.out.print("2,");
                     break;
                  case(3):
                     System.out.print("3,");
                     break;
                  case(4):
                     System.out.print("4,");
                     break;    
                  case(5):
                     System.out.print("5,");
                     break;
                  case(6):
                     System.out.print("6,");
                     break;
                  case(7):
                     System.out.print("7,");
                     break;     
                  case(8):
                     System.out.print("8,");
                     break;
                  case(9):
                     System.out.print("9,");
                     break;
                  case(10):
                     System.out.print("10,");
                     break;
                  case(11):
                     System.out.print("jack,");
                     break;
                  case(12):
                     System.out.print("queen,");
                     break;
                  case(13):
                     System.out.print("king,");
                     break;
               }
               
            }
         }
         //The following if will check if player win with higher points than computer
         if(scoreP>scoreC && scoreP<21)
         {
            System.out.println("\n\nWow congrajulation!!!!!You win   :)");
            winLose[0]++;
            winLose[2]=winLose[2]*2;
         }
         //The following else if will check if the player win because computer got higher than 21
         else if(scoreC>21)
         {
            System.out.println("\n\nWow congrajulation!!!!!You win computer score was greater than 21   :)");
            winLose[0]++;
            winLose[2]=winLose[2]*2;
         }
         play=3;//Exit this loop so player can decide if they want to play again or not
         
         //$let the user to play again by entering one 
         System.out.println("\n.......................................................................................................................");
         System.out.println("\nEnter 1 to play again enter any other integer to end the game: ");
         again=sc.nextInt();
         
         
      }
      //$This will show the user the money they won on the last match and number of wins and loses 
      System.out.println("#Number of matches you won: "+winLose[0]+"  #Number of matches you lost :"+winLose[1]);
      System.out.println("The money you won is $"+winLose[2]);
      
      
   }
}