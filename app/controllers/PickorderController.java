package controllers;

import models.Pickorder;
import org.springframework.beans.factory.annotation.Autowired;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.PickorderService;

import java.util.List;

@org.springframework.stereotype.Controller
public class PickorderController extends Controller {

    @Autowired
    private PickorderService pickorderService;

    public Result createPickorder() {
        pickorderService.createPickorder();
        return ok("Success");
    }

    public Result getAllPickorders() {
        List<Pickorder> pickorders = pickorderService.getAllPickorders();
        return ok(Json.toJson(pickorders));
    }

    public Result getPickorder(Long id) {
        Pickorder pickorder = pickorderService.getPickorder(id);
        return ok(Json.toJson(pickorder));
    }

}
