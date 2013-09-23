package services;

import models.Card;
import models.Pickorder;
import models.PickorderCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.CardRepository;
import repositories.PickorderCardRepository;
import repositories.PickorderRepository;

import java.util.List;

@Service
public class PickorderService {

    @Autowired
    private PickorderRepository pickorderRepository;

    @Autowired
    private PickorderCardRepository pickorderCardRepository;

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
            pickorderCardRepository.savePickorderCard(pickorderCard);
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

        for (PickorderCard pickorderCard : pickorder.getCards()) {
            if (pickorderCard.getRank().equals(rank)) {
                pickorderCard.setRank(newRank);
                pickorderCardRepository.updatePickorderCard(pickorderCard);
            } else if (pickorderCard.getRank().equals(newRank)) {
                pickorderCard.setRank(rank);
                pickorderCardRepository.updatePickorderCard(pickorderCard);
            }
        }
    }
}
