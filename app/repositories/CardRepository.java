package repositories;

import models.Card;
import org.springframework.stereotype.Repository;
import play.db.ebean.Model.Finder;

import java.util.ArrayList;
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

    public List<Card> getCards(String colors, String rarities) {
        List<Card> cards = new ArrayList<>();
        for (char color : colors.toCharArray()) {
            for (char rarity : rarities.toCharArray()) {
                cards.addAll(find.where().contains("colors", String.valueOf(color)).eq("rarity", String.valueOf(rarity)).findSet());
            }
        }
        return cards;
    }
}
