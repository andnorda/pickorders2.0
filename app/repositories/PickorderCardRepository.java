package repositories;

import com.avaje.ebean.Ebean;
import models.PickorderCard;
import org.springframework.stereotype.Repository;
import play.db.ebean.Model;

import java.util.List;

@Repository
public class PickorderCardRepository {

    private Model.Finder<Long,PickorderCard> find = new Model.Finder<Long, PickorderCard>(Long.class, PickorderCard.class);

    public void savePickorderCard(PickorderCard pickorderCard) {
        System.out.println("saving pickorderCard with rank " + pickorderCard.getRank());
        Ebean.save(pickorderCard);
    }

    public void updatePickorderCard(PickorderCard pickorderCard) {
        pickorderCard.update();
    }

    public PickorderCard getPickorderCard(Long id) {
        return find.byId(id);
    }

    public List<PickorderCard> getPickorderCards() {
        return find.all();
    }
}
