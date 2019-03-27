package controllers;

import models.*;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.io.Console;
import java.math.BigDecimal;
import java.util.List;

import static play.mvc.Results.ok;

public class CollectionController extends Controller {

    private FormFactory formFactory;
    private JPAApi db;

    @Inject
    public CollectionController(FormFactory formFactory, JPAApi db) {
        this.formFactory = formFactory;
        this.db = db;
    }

    @Transactional(readOnly = true)
    public Result getCollection(int bookshelfId){

        TypedQuery<BookDetail> bookDetailQuery = db.em().createQuery(
                "SELECT NEW models.BookDetail(b.bookId, b.bookName, " +
                        "b.bookPrice, bt.bookTypeName, g.genreName," +
                        " r.retailerName, b.authorName) " +
                        "FROM Book b " +
                        "JOIN Genre g ON g.genreId = b.genreId " +
                        "JOIN BookType bt ON bt.bookTypeId = b.bookTypeId " +
                        "JOIN Retailer r ON r.retailerId = b.retailerId " +
                        "ORDER BY b.bookId, b.bookName", BookDetail.class);
        List<BookDetail> books = bookDetailQuery.getResultList();


        TypedQuery<GameDetail> gameDetailQuery = db.em().createQuery(
                "SELECT NEW models.GameDetail(g.gameId, g.gamePrice, " +
                        "g.gameName, gt.gameTypeName, ge.genreName, " +
                        "r.retailerName, c.consoleName) " +
                        "FROM Game g " +
                        "JOIN GameType gt ON gt.gameTypeId = g.gameTypeId " +
                        "JOIN Genre ge ON ge.genreId = g.genreId " +
                        "JOIN Retailer r ON r.retailerId = g.retailerId " +
                        "JOIN Console c ON c.consoleId = g.consoleId " +
                        "ORDER BY g.gameId, g.gameName", GameDetail.class);
        List<GameDetail> games = gameDetailQuery.getResultList();


        TypedQuery<DiscDetail> discDetailQuery = db.em().createQuery(
                "SELECT NEW models.DiscDetail(d.discId, d.discName," +
                        "d.discPrice, dt.discTypeName," +
                        "g.genreName, r.retailerName, d.artistName) " +
                        "FROM Disc d " +
                        "JOIN DiscType dt ON dt.discTypeId = d.discTypeId " +
                        "JOIN Genre g ON g.genreId = d.genreId " +
                        "JOIN Retailer r ON r.retailerId = d.retailerId " +
                        "ORDER BY d.discId, d.discName", DiscDetail.class);
        List<DiscDetail> discs = discDetailQuery.getResultList();

        return ok(views.html.collection.render(books, games, discs));
    }
}
