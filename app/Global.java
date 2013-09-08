import com.avaje.ebean.Ebean;
import models.Card;
import models.Pickorder;
import models.PickorderCard;
import play.Application;
import play.GlobalSettings;
import play.libs.Yaml;

import java.util.List;
import java.util.Map;

public class Global extends GlobalSettings {

    public void onStart(Application app) {
        InitialData.insert(app);
    }

    static class InitialData {

        public static void insert(Application app) {
            if(Ebean.find(Card.class).findRowCount() == 0) {

                Card brainstorm = new Card();
                brainstorm.setName("brainstorm");
                Ebean.save(brainstorm);

                Card counterspell = new Card();
                counterspell.setName("counterspell");
                Ebean.save(counterspell);

                Pickorder legacy = new Pickorder();
                legacy.setName("legacy");
                Ebean.save(legacy);

                Pickorder vintage = new Pickorder();
                vintage.setName("vintage");
                Ebean.save(vintage);

                PickorderCard legacyBrainstorm = new PickorderCard();
                legacyBrainstorm.setCard(brainstorm);
                legacyBrainstorm.setPickorder(legacy);
                legacyBrainstorm.setRank(1);
                Ebean.save(legacyBrainstorm);

                PickorderCard legacyCounterpell = new PickorderCard();
                legacyCounterpell.setCard(counterspell);
                legacyCounterpell.setPickorder(legacy);
                legacyCounterpell.setRank(2);
                Ebean.save(legacyCounterpell);

                PickorderCard vintageBrainstorm = new PickorderCard();
                vintageBrainstorm.setCard(brainstorm);
                vintageBrainstorm.setPickorder(vintage);
                vintageBrainstorm.setRank(2);
                Ebean.save(vintageBrainstorm);

                PickorderCard vintageCounterpell = new PickorderCard();
                vintageCounterpell.setCard(counterspell);
                vintageCounterpell.setPickorder(vintage);
                vintageCounterpell.setRank(1);
                Ebean.save(vintageCounterpell);

            }
        }

    }

}