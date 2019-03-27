package controllers;

import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.mvc.Controller;

import javax.inject.Inject;

public class RetailerController extends Controller {

    private FormFactory formFactory;
    private JPAApi db;

    @Inject
    public RetailerController (FormFactory formFactory, JPAApi db) {
        this.formFactory = formFactory;
        this.db = db;
    }
}
