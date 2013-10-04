import com.avaje.ebean.Ebean;
import models.Card;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import play.Application;
import play.GlobalSettings;
import play.libs.Yaml;

import java.util.List;
import java.util.Map;

public class Global extends GlobalSettings {

    private ApplicationContext ctx;

    @Override
    public void onStart(Application app) {
        ctx = new ClassPathXmlApplicationContext("components.xml");

        if(Ebean.find(Card.class).findRowCount() == 0) {

            @SuppressWarnings("unchecked")
            Map<String,List<Object>> yaml = (Map<String,List<Object>>)Yaml.load("initial-data.yml");

            Ebean.save(yaml.get("cards"));

        }
    }

    @Override
    public <A> A getControllerInstance(Class<A> clazz) {
        return ctx.getBean(clazz);
    }

}