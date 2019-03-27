package controllers;

import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.mvc.Controller;

import javax.inject.Inject;

public class DiscTypeController extends Controller {

    private FormFactory formFactory;
    private JPAApi db;

    @Inject

    public DiscTypeController (FormFactory formFactory, JPAApi db) {
        this.formFactory = formFactory;
        this.db = db;
    }
}
