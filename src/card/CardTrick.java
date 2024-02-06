package card;

import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author Axit Vipulbhai Dobariya
 * @modifier Axit Vipulbhai Dobariya
 * @studentNumber 991707553
 */
public class CardTrick {
    
    public static void main(String[] args)
    {
        // Step 1: Initialize variables and objects
        Card[] magicHand = new Card[7];
        Random rand = new Random();
        
        // Step 2: Fill the magic hand with random cards
        for (int i = 0; i < magicHand.length; i++)
        {
            Card c = new Card();
            // Generate random values for card
            c.setValue(rand.nextInt(13) + 1);
            // Generate random suit for card
            c.setSuit(Card.SUITS[rand.nextInt(4)]);
            // Add the card to the magic hand
            magicHand[i] = c;
        }
        
        // Step 3: Print the original magic hand
        System.out.println("Original Magic Hand:");
        for (Card card : magicHand) {
            System.out.println("Card - Value: " + card.getValue() + ", Suit: " + card.getSuit());
        }
        
        // Step 4: Add one luck card (hard-coded) to the magic hand
        Card luckyCard = new Card();
        luckyCard.setValue(7); // You can choose any number you like
        luckyCard.setSuit("Hearts"); // You can choose any suit you like
        magicHand[6] = luckyCard;
        
        // Step 5: Print the updated magic hand
        System.out.println("\nUpdated Magic Hand:");
        for (Card card : magicHand) {
            System.out.println("Card - Value: " + card.getValue() + ", Suit: " + card.getSuit());
        }
        
        // Step 6: Ask the user for their card
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the value of your card (1-13): ");
        int userValue = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter the suit of your card (Hearts, Diamonds, Spades, Clubs): ");
        String userSuit = scanner.nextLine();
        
        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(userSuit);
        
        // Step 7: Search for the user's card in the magic hand
        boolean found = false;
        
        for (Card c : magicHand) {
            if (c.getValue() == userCard.getValue() && c.getSuit().equalsIgnoreCase(userCard.getSuit())) {
                found = true;
                break;
            }
        }
        
        // Step 8: Report the result
        if (found) {
            System.out.println("Congratulations! Your card is in the magic hand.");
        } else {
            System.out.println("Sorry! Your card is not in the magic hand.");
        }
    }
}
