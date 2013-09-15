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
        int count = 0;
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

    public void update(Long id, Integer rank, Integer newRank) {
        Pickorder pickorder = pickorderRepository.getPickorder(id);

        for (PickorderCard card : pickorder.getCards()) {
            if (card.getRank() == rank) {
                card.setRank(newRank);
            } else if (card.getRank() == newRank) {
                card.setRank(rank);
            }
        }

        pickorderRepository.update(pickorder);

    }
}
