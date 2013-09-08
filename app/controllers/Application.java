package controllers;

import play.Play;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {

    public static Result index() {
        return ok(Play.application().getFile("public/main.html"));
    }

}
