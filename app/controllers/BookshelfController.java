package controllers;

import models.Book;
import models.Bookshelf;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.util.List;

public class BookshelfController extends Controller {

    private FormFactory formFactory;
    private JPAApi db;

    @Inject

    public BookshelfController (FormFactory formFactory, JPAApi db) {
        this.formFactory = formFactory;
        this.db = db;
    }
}
