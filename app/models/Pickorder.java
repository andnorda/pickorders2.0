package models;

import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Pickorder {

    @Id
    private Integer id;

    @Constraints.Required
    private String name;

    @OneToMany
    private List<PickorderCard> cards;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
