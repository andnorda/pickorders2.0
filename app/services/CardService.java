package services;

import models.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.CardRepository;

import java.util.List;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepository;

    public List<Card> getAllCards() {
        return cardRepository.getAll();
    }

    public Card getCard(Long id) {
        return cardRepository.getCard(id);
    }
}
