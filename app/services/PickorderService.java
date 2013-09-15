package services;

import com.avaje.ebean.Ebean;
import models.Card;
import models.Pickorder;
import models.PickorderCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.CardRepository;
import repositories.PickorderRepository;

import java.util.List;

@Service
public class PickorderService {

    @Autowired
    private PickorderRepository pickorderRepository;

    @Autowired
    private CardRepository cardRepository;

    public void createPickorder(String name) {
        Pickorder pickorder = pickorderRepository.createPickorder(name);
        List<Card> cards = cardRepository.getAll();
        int count = 1;
        for (Card card : cards) {
            PickorderCard pickorderCard = new PickorderCard();
            pickorderCard.setCard(card);
            pickorderCard.setPickorder(pickorder);
            pickorderCard.setRank(count++);
            Ebean.save(pickorderCard);
        }

    }

    public Pickorder getPickorder(Long id) {
        return pickorderRepository.getPickorder(id);
    }

    public List<Pickorder> getAllPickorders() {
        return pickorderRepository.getAllPickorders();
    }
}
