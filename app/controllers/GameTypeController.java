package controllers;

import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.mvc.Controller;

import javax.inject.Inject;

public class GameTypeController extends Controller {

    private FormFactory formFactory;
    private JPAApi db;

    @Inject

    public GameTypeController (FormFactory formFactory, JPAApi db) {
        this.formFactory = formFactory;
        this.db = db;
    }
}
