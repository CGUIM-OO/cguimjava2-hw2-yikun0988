import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author TODO: please add student ID and name here 
 * My student ID is B0344223.
 * My name is 劉益坤.
 * 
 * Try to write some comments for your codes (methods, 15 points)
 * 整支程式需要填入的程式碼雖然需要用到的寫法都很基本，
 * 但是基於是利用類別產生物件在進行呼叫，所以要清楚整個程式的脈絡跟流程才有辦法完成這支程式，
 * 在main方法利用Deck類別產生deck物件，然後去呼叫類別中的printDeck方法，
 * 在此產生物件的時候，類別中就會因應我們填入所需的牌組數產生需要的花色跟牌數，
 * 但因為每張卡都不一樣，所以每張卡都是利用Card類別所產生的card物件去產生每一張牌，
 * 接著在呼叫deck物件的printDeck方法中有利用到我們所寫的printCard方法，
 * 先把我們原本在Deck類別中產生的每張牌的花色數字以及卡片數字轉換為花色名稱及卡片數字名稱，
 * 接著在print出來。
 * P.S.因為每個方法的寫法描述都寫在下方，所以就不細講了。
 */
public class HW2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N (deck of cards):");
		String testn = sc.nextLine();

		int nDeck = Integer.parseInt(testn);
		Deck deck = new Deck(nDeck);
		// TODO: please check your output, make sure that you print all cards on your
		// screen (10 points)
		deck.printDeck();

		if (isAllCardsCorrect(deck.getAllCards(), nDeck)) {
			System.out.println("Well done!");
		} else {
			System.out.println("Error, please check your sourse code");
		}
	}

	/**
	 * This method is used for checking your result, not a part of your HW2
	 * 
	 * @param allCards
	 *            �������
	 * @param nDeck
	 *            蝮賢��嗾����
	 * @return
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards, int nDeck) {
		// check the output
		boolean isCorrect = true;
		;
		HashMap<String, Integer> checkHash = new HashMap<String, Integer>();
		for (Card card : allCards) {
			int suit = card.getSuit();
			int rank = card.getRank();
			if (suit > 4 || suit < 1 || rank > 13 || rank < 1) {
				isCorrect = false;
				break;
			}
			if (checkHash.containsKey(suit + "," + rank)) {
				checkHash.put(suit + "," + rank, checkHash.get(suit + "," + rank) + 1);
			} else {
				checkHash.put(suit + "," + rank, 1);
			}

		}
		if (checkHash.keySet().size() == 52) {
			for (int value : checkHash.values()) {
				if (value != nDeck) {
					isCorrect = false;
					break;
				}
			}
		} else {
			isCorrect = false;
		}
		return isCorrect;
	}

}

/**
 * Description: TODO: please add description here 在Deck這個類別中，
 * 我在Deck的這個方法，是先利用老師在呼叫這個方法時所填入的我們所需要產生的牌組數(nDeck)，
 * 然後利用三層迴圈，先產生我們所需要產生的牌組數(nDeck)，在產生我們所需要的花色數量(4)， 接著在每個花色中產生應要有的數字數量(13)。
 *
 * 我在printDeck這個方法中，使用迴圈讓cards這個ArrayList利用Card類別中的printCard方法，
 * 把我們在cards中所有的卡片全部都print出來，那因為整齊的關係，所以我有用if-else來讓每個牌組前有牌組標題。
 **/
class Deck {
	private ArrayList<Card> cards;

	// TODO: Please implement the constructor (30 points)
	public Deck(int nDeck) {
		cards = new ArrayList<Card>();
		// 1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		// Hint: Use new Card(x,y) and 3 for loops to add card into deck
		// Sample code start
		// Card card=new Card(1,1); ->means new card as clubs ace
		// cards.add(card);
		// Sample code end
		for (int n = 0; n < nDeck; n++) {
			for (int s = 1; s <= 4; s++) {
				for (int r = 1; r <= 13; r++) {
					Card card = new Card(s, r);
					cards.add(card);
				}
			}
		}
	}

	// TODO: Please implement the method to print all cards on screen (10 points)
	public void printDeck() {
		// Hint: print all items in ArrayList<Card> cards,
		// TODO: please implement and reuse printCard method in Card class (5 points)
		int NumberOfDeck = 1;
		for (int a = 0; a < cards.size(); a++) {
			if (a % 52 == 0) {
				System.out.print("\n第" + NumberOfDeck + "組牌:");
				NumberOfDeck++;
			}
			cards.get(a).printCard();
		}
	}

	public ArrayList<Card> getAllCards() {
		return cards;
	}
}

/**
 * Description: TODO: please add description here
 * 在Card這個類別的printCard方法中，我先使用方法getSuit跟getRank，
 * 再利用switch-case讓我宣告的suit、rank變數存入我們所需的suit跟rank對應的花色名稱及卡片數字名稱，
 * 然後再把這兩個變數print出來。
 **/
class Card {
	private int suit; // Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
	private int rank; // 1~13

	/**
	 * @param s
	 *            suit
	 * @param r
	 *            rank
	 */
	public Card(int s, int r) {
		suit = s;
		rank = r;
	}

	// TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10
	// for rank)
	public void printCard() {
		// Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as
		// Clubs Ace
		String suit = null, rank = null;
		switch (getSuit()) {
		case 1:
			suit = "Clubs";
			break;
		case 2:
			suit = "Diamonds";
			break;
		case 3:
			suit = "Hearts";
			break;
		case 4:
			suit = "Spades";
			break;
		}
		switch (getRank()) {
		case 1:
			rank = "Ace";
			break;
		case 2:
			rank = "Two";
			break;
		case 3:
			rank = "Three";
			break;
		case 4:
			rank = "Four";
			break;
		case 5:
			rank = "Five";
			break;
		case 6:
			rank = "Six";
			break;
		case 7:
			rank = "Seven";
			break;
		case 8:
			rank = "Eight";
			break;
		case 9:
			rank = "Nine";
			break;
		case 10:
			rank = "Ten";
			break;
		case 11:
			rank = "Jack";
			break;
		case 12:
			rank = "Queen";
			break;
		case 13:
			rank = "King";
			break;
		}
		System.out.print("(" + suit + " " + rank + ") ");
	}

	public int getSuit() {
		return suit;
	}

	public int getRank() {
		return rank;
	}
}
