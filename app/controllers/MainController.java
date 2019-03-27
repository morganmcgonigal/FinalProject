package controllers;

import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;

public class MainController extends Controller {

    private FormFactory formFactory;
    private JPAApi db;

    @Inject
    public MainController(FormFactory formFactory, JPAApi db) {
        this.formFactory = formFactory;
        this.db = db;
    }

    public Result getIndex() {
        return ok(views.html.index.render());
    }
}
