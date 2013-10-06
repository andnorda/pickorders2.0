package repositories;

import com.avaje.ebean.Ebean;
import models.Pickorder;
import org.springframework.stereotype.Repository;
import play.db.ebean.Model;

import java.util.List;

@Repository
public class PickorderRepository {

    private Model.Finder<Long,Pickorder> find = new Model.Finder<Long, Pickorder>(Long.class, Pickorder.class);

    public Pickorder createPickorder(String name) {
        Pickorder pickorder = new Pickorder();
        pickorder.setName(name);
        Ebean.save(pickorder);
        return pickorder;
    }

    public Pickorder getPickorder(Long id) {
        return find.byId(id);
    }

    public List<Pickorder> getAllPickorders() {
        return find.all();
    }

    public void update(Pickorder pickorder) {
        Ebean.update(pickorder);
    }

    public void delete(Pickorder pickorder) {
        Ebean.delete(pickorder);
    }

    public void delete(Long id) {
        Ebean.delete(find.byId(id));
    }
}
