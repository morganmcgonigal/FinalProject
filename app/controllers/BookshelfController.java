package controllers;

import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;

public class BookshelfController extends Controller {

    private FormFactory formFactory;
    private JPAApi db;

    @Inject

    public BookshelfController (FormFactory formFactory, JPAApi db) {
        this.formFactory = formFactory;
        this.db = db;
    }
}
