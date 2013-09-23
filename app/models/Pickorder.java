package models;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Pickorder extends Model{

    @Id
    private Long id;

    @Constraints.Required
    private String name;

    @OneToMany
    private List<PickorderCard> cards;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PickorderCard> getCards() {
        return cards;
    }

    public void setCards(List<PickorderCard> cards) {
        this.cards = cards;
    }
}
