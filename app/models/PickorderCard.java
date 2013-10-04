package models;

import org.codehaus.jackson.annotate.JsonIgnore;
import play.data.validation.Constraints;

import javax.persistence.*;

@Entity
@Table(name="PICKORDER_CARD")
@IdClass(PickorderCardId.class)
public class PickorderCard {

    @Constraints.Required
    private Integer rank;

    @ManyToOne
    @PrimaryKeyJoinColumn(name="CARDID", referencedColumnName="ID")
    private Card card;

    @JsonIgnore
    @ManyToOne
    @PrimaryKeyJoinColumn(name="PICKORDERID", referencedColumnName="ID")
    private Pickorder pickorder;

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Pickorder getPickorder() {
        return pickorder;
    }

    public void setPickorder(Pickorder pickorder) {
        this.pickorder = pickorder;
    }
}
