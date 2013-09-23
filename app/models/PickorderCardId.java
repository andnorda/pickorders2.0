package models;

import play.db.ebean.Model;

import javax.persistence.Embeddable;

@Embeddable
public class PickorderCardId extends Model {

    private Long cardId;
    private Long pickorderId;

}
