package repositories;

import com.avaje.ebean.Ebean;
import models.Card;
import models.Pickorder;
import org.springframework.stereotype.Repository;
import play.db.ebean.Model;

@Repository
public class PickorderRepository {

    private Model.Finder<Long,Pickorder> find = new Model.Finder<Long, Pickorder>(Long.class, Pickorder.class);

    public Pickorder createPickorder(String name) {
        Pickorder pickorder = new Pickorder();
        pickorder.setName(name);
        Ebean.save(pickorder);
        return pickorder;
    }
}
