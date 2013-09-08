package models;

import org.codehaus.jackson.annotate.JsonIgnore;
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

    @Constraints.Required
    private String colors;

    @Constraints.Required
    private String type;

    @Constraints.Required
    private String set;

    @Constraints.Required
    private String rarity;

    @JsonIgnore
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

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public List<PickorderCard> getPickorders() {
        return pickorders;
    }

    public void setPickorders(List<PickorderCard> pickorders) {
        this.pickorders = pickorders;
    }
}
