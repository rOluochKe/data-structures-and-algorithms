package Java;

import java.util.Iterator;

public class CardHand {
  private LinkedPositionalList<Card> hand;
  private Position<Card> heartFinger;
  private Position<Card> clubFinger;
  private Position<Card> spadeFinger;
  private Position<Card> diamondFinger;

  // Constructor
  public CardHand() {
    hand = new LinkedPositionalList<>();
    heartFinger = null;
    clubFinger = null;
    spadeFinger = null;
    diamondFinger = null;
  }

  // Add a new card to the hand
  public void addCard(Rank r, Suit s) {
    Card newCard = new Card(r, s);
    Position<Card> newPos = hand.addLast(newCard);

    switch (s) {
      case HEARTS:
        if (heartFinger == null) {
          heartFinger = newPos;
        }
        break;
      case CLUBS:
        if (clubFinger == null) {
          clubFinger = newPos;
        }
        break;
      case SPADES:
        if (spadeFinger == null) {
          spadeFinger = newPos;
        }
        break;
      case DIAMONDS:
        if (diamondFinger == null) {
          diamondFinger = newPos;
        }
        break;
    }
  }

  // Remove and return a card of suit s from the hand
  public Card play(Suit s) {
    Position<Card> toRemove = null;

    switch (s) {
      case HEARTS:
        toRemove = heartFinger;
        break;
      case CLUBS:
        toRemove = clubFinger;
        break;
      case SPADES:
        toRemove = spadeFinger;
        break;
      case DIAMONDS:
        toRemove = diamondFinger;
        break;
    }

    if (toRemove == null) {
      toRemove = hand.first();
    }

    if (toRemove != null) {
      Card removedCard = hand.remove(toRemove);
      updateFinger(s);
      return removedCard;
    }

    return null;
  }

  // Return an iterator for all cards currently in the hand
  public Iterator<Card> iterator() {
    return new CardIterator(hand);
  }

  // Return an iterator for all cards of suit s that are currently in the hand
  public Iterator<Card> suitIterator(Suit s) {
    Position<Card> finger = null;

    switch (s) {
      case HEARTS:
        finger = heartFinger;
        break;
      case CLUBS:
        finger = clubFinger;
        break;
      case SPADES:
        finger = spadeFinger;
        break;
      case DIAMONDS:
        finger = diamondFinger;
        break;
    }

    if (finger == null) {
      return new CardSuitIterator(hand, s);
    } else {
      return new CardSuitIterator(hand, s, finger);
    }
  }

  // Update the finger after a card of suit s is played
  private void updateFinger(Suit s) {
    switch (s) {
      case HEARTS:
        heartFinger = findNextFinger(heartFinger);
        break;
      case CLUBS:
        clubFinger = findNextFinger(clubFinger);
        break;
      case SPADES:
        spadeFinger = findNextFinger(spadeFinger);
        break;
      case DIAMONDS:
        diamondFinger = findNextFinger(diamondFinger);
        break;
    }
  }

  // Find the next finger position after a card of suit s is played
  private Position<Card> findNextFinger(Position<Card> currentFinger) {
    if (currentFinger != null && currentFinger.getElement() != null) {
      Position<Card> next = hand.after(currentFinger);
      if (next == null) {
        next = hand.first();
      }
      return next;
    }
    return null;
  }
}