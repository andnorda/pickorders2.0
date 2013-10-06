package repositories;

import models.Card;
import models.Color;
import org.springframework.stereotype.Repository;
import play.db.ebean.Model.Finder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class CardRepository {

    private Finder<Long,Card> find = new Finder<Long, Card>(Long.class, Card.class);

    public List<Card> getAll() {
        return find.all();
    }

    public Card getCard(Long id) {
        return find.byId(id);
    }

    /**
     * Gets cards of the chosen rarities that can be cast by the colors given.
     * (Excluding lands and artifacts unless otherwise specified)
     */
    public List<Card> getCards(String colors, String rarities) {
        List<Card> cards = new ArrayList<Card>();

        for (char rarity : rarities.toCharArray()){
            for (char color : colors.toCharArray()) {
                // Get cards matching each color exactly
                cards.addAll(find.where().eq("colors", String.valueOf(color)).eq("rarity", String.valueOf(rarity)).findList());
            }
            // Get cards of each two color permutation
            if (colors.length() > 1) {
                cards.addAll(getMulticolored(colors, rarity));
            }
        }

        return cards;
    }

    private List<Card> getMulticolored(String colors, char rarity) {
        List<Card> cards = new ArrayList<Card>();
        for (int i = 0; i < colors.length() - 1; i++) {
            for (int j = i + 1; j < colors.length(); j++) {
                cards.addAll(find.where().eq("colors", String.valueOf(colors.charAt(i)) + String.valueOf(colors.charAt(j))).eq("rarity", String.valueOf(rarity)).findList());
                cards.addAll(find.where().eq("colors", String.valueOf(colors.charAt(j)) + String.valueOf(colors.charAt(i))).eq("rarity", String.valueOf(rarity)).findList());
            }
        }
        return cards;
    }
}
