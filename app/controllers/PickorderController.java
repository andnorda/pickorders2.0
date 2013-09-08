package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import play.mvc.Controller;
import play.mvc.Result;
import services.PickorderService;

@org.springframework.stereotype.Controller
public class PickorderController extends Controller {

    @Autowired
    private PickorderService pickorderService;

    public Result createPickorder() {
        pickorderService.createPickorder();
        return ok("Success");
    }

}
