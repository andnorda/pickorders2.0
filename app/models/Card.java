package models;

import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Card {

    @Id
    private Integer id;

    @Constraints.Required
    private String name;

    @OneToMany
    private List<PickorderCard> pickorders;

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

    public List<PickorderCard> getPickorders() {
        return pickorders;
    }

    public void setPickorders(List<PickorderCard> pickorders) {
        this.pickorders = pickorders;
    }
}
