package repositories;

import models.Card;
import org.springframework.stereotype.Repository;
import play.db.ebean.Model.Finder;

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
}
