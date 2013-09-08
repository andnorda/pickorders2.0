package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.CardService;

@org.springframework.stereotype.Controller
public class CardController extends Controller {

    @Autowired
    private CardService cardService;

    public Result getAllCards() {
        return ok(Json.toJson(cardService.getAllCards()));
    }
    public Result getCard(Long id) {
        return ok(Json.toJson(cardService.getCard(id)));
    }

}
