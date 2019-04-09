package controllers;

import models.*;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

public class DiscController extends Controller {

    private FormFactory formFactory;
    private JPAApi db;

    @Inject

    public DiscController(FormFactory formFactory, JPAApi db) {
        this.formFactory = formFactory;
        this.db = db;
    }

    @Transactional(readOnly = true)
    public Result getDiscEdit(int discId) {
        TypedQuery<Disc> discQuery = db.em().createQuery(
                "SELECT d FROM Disc d WHERE discId = :discId",
                Disc.class);
        discQuery.setParameter("discId", discId);
        Disc disc = discQuery.getSingleResult();

        TypedQuery<DiscType> discTypeQuery = db.em().createQuery(
                "SELECT dt FROM DiscType dt ORDER BY discTypeId",
                DiscType.class);
        List<DiscType> discTypes = discTypeQuery.getResultList();

        TypedQuery<DiscGenre> genreQuery = db.em().createQuery(
                "SELECT g FROM DiscGenre g ORDER BY discGenreId",
                DiscGenre.class);
        List<DiscGenre> genres = genreQuery.getResultList();

        TypedQuery<Retailer> retailerQuery = db.em().createQuery(
                "SELECT r FROM Retailer r ORDER BY retailerId",
                Retailer.class);
        List<Retailer> retailers = retailerQuery.getResultList();

        TypedQuery<Bookshelf> bookshelfQuery = db.em().createQuery(
                "SELECT b FROM Bookshelf b ORDER BY bookshelfId",
                Bookshelf.class);
        List<Bookshelf> bookshelves = bookshelfQuery.getResultList();

        return ok(views.html.updatedisc.render(disc, discTypes, genres, retailers, bookshelves));
    }

    @Transactional
    public Result postDiscEdit(int discId) {
        TypedQuery<Disc> discQuery = db.em().createQuery(
                "SELECT d FROM Disc d WHERE discId = :discId",
                Disc.class);
        discQuery.setParameter("discId", discId);
        Disc disc = discQuery.getSingleResult();

        DynamicForm form = formFactory.form().bindFromRequest();
        String discName = form.get("discname");
        String sdiscprice = form.get("discprice");
        BigDecimal discPrice = new BigDecimal(sdiscprice);
        String sdisctypeid = form.get("disctype");
        int discTypeId = Integer.parseInt(sdisctypeid);
        String sgenreId = form.get("genre");
        int genreId = Integer.parseInt(sgenreId);
        String sretailerId = form.get("retailer");
        int retailerId = Integer.parseInt(sretailerId);
        String sbookshelfId = form.get("bookshelf");
        int bookshelfId = Integer.parseInt(sbookshelfId);
        String sfaceValue = form.get("facevalue");
        BigDecimal faceValue = new BigDecimal(sfaceValue);

        disc.setDiscName(discName);
        disc.setDiscPrice(discPrice);
        disc.setDiscTypeId(discTypeId);
        disc.setDiscGenreId(genreId);
        disc.setRetailerId(retailerId);
        disc.setBookshelfId(bookshelfId);
        disc.setFaceValue(faceValue);

        db.em().persist(disc);

        TypedQuery<Bookshelf> bookshelfQuery = db.em().createQuery(
                "SELECT b FROM Bookshelf b WHERE bookshelfId = :bookshelfId",
                Bookshelf.class);
        bookshelfQuery.setParameter("bookshelfId", bookshelfId);
        Bookshelf bookshelf = bookshelfQuery.getSingleResult();
        List<Bookshelf> bookshelves = bookshelfQuery.getResultList();

        TypedQuery<BookDetail> bookDetailQuery = db.em().createQuery(
                "SELECT NEW models.BookDetail(b.bookId, b.bookName, " +
                        "b.bookPrice, bt.bookTypeName, g.bookGenreName," +
                        " r.retailerName, b.authorName, b.bookshelfId, b.faceValue) " +
                        "FROM Book b " +
                        "JOIN BookGenre g ON g.bookGenreId = b.bookGenreId " +
                        "JOIN BookType bt ON bt.bookTypeId = b.bookTypeId " +
                        "JOIN Retailer r ON r.retailerId = b.retailerId " +
                        "ORDER BY b.bookName", BookDetail.class);
        List<BookDetail> books = bookDetailQuery.getResultList();

        TypedQuery<GameDetail> gameDetailQuery = db.em().createQuery(
                "SELECT NEW models.GameDetail(g.gameId, g.gamePrice, " +
                        "g.gameName, gt.gameTypeName, ge.gameGenreName, " +
                        "r.retailerName, c.consoleName, g.bookshelfId, g.faceValue) " +
                        "FROM Game g " +
                        "JOIN GameType gt ON gt.gameTypeId = g.gameTypeId " +
                        "JOIN GameGenre ge ON ge.gameGenreId = g.gameGenreId " +
                        "JOIN Retailer r ON r.retailerId = g.retailerId " +
                        "JOIN Console c ON c.consoleId = g.consoleId " +
                        "ORDER BY g.gameName", GameDetail.class);
        List<GameDetail> games = gameDetailQuery.getResultList();


        TypedQuery<DiscDetail> discDetailQuery = db.em().createQuery(
                "SELECT NEW models.DiscDetail(d.discId, d.discName," +
                        "d.discPrice, dt.discTypeName," +
                        "g.discGenreName, r.retailerName, d.bookshelfId, d.faceValue) " +
                        "FROM Disc d " +
                        "JOIN DiscType dt ON dt.discTypeId = d.discTypeId " +
                        "JOIN DiscGenre g ON g.discGenreId = d.discGenreId " +
                        "JOIN Retailer r ON r.retailerId = d.retailerId " +
                        "ORDER BY d.discName", DiscDetail.class);
        List<DiscDetail> discs = discDetailQuery.getResultList();

        TypedQuery<AlbumDetail> albumDetailQuery = db.em().createQuery(
                "SELECT NEW models.AlbumDetail(a.albumId, a.albumName, " +
                        "a.albumPrice, g.albumGenreName, r.retailerName, a.artistName, a.bookshelfId, a.faceValue) " +
                        "FROM Album a " +
                        "JOIN AlbumGenre g ON g.albumGenreId = a.albumGenreId " +
                        "JOIN Retailer r ON r.retailerId = a.retailerId " +
                        "ORDER BY a.albumName", AlbumDetail.class);
        List<AlbumDetail> albums = albumDetailQuery.getResultList();

        return ok(views.html.collection.render(bookshelf, books, games, discs, albums, bookshelves));
    }

    @Transactional(readOnly = true)
    public Result getDisc(int discId) {
        TypedQuery<Disc> discQuery = db.em().createQuery(
                "SELECT d FROM Disc d WHERE discId = :discId",
                Disc.class);
        discQuery.setParameter("discId", discId);
        Disc disc = discQuery.getSingleResult();

        TypedQuery<DiscGenre> discGenreQuery = db.em().createQuery(
                "SELECT dg FROM DiscGenre dg WHERE discGenreId = :discGenreId",
                DiscGenre.class);
        discGenreQuery.setParameter("discGenreId", disc.getDiscGenreId());
        DiscGenre discGenre = discGenreQuery.getSingleResult();

        TypedQuery<Retailer> retailerQuery = db.em().createQuery(
                "SELECT r FROM Retailer r WHERE retailerId = :retailerId",
                Retailer.class);
        retailerQuery.setParameter("retailerId", disc.getRetailerId());
        Retailer retailer = retailerQuery.getSingleResult();

        TypedQuery<DiscType> discTypeQuery = db.em().createQuery(
                "SELECT dt FROM DiscType dt WHERE discTypeId = :discTypeId",
                DiscType.class);
        discTypeQuery.setParameter("discTypeId", disc.getDiscTypeId());
        DiscType discType = discTypeQuery.getSingleResult();

        TypedQuery<Bookshelf> bookshelfQuery = db.em().createQuery(
                "SELECT b FROM Bookshelf b ORDER BY bookshelfId",
                Bookshelf.class);
        List<Bookshelf> bookshelves = bookshelfQuery.getResultList();

        TypedQuery<Bookshelf> bookshelfTypedQuery = db.em().createQuery(
                "SELECT b FROM Bookshelf b WHERE bookshelfId = :bookshelfId",
                Bookshelf.class);
        bookshelfTypedQuery.setParameter("bookshelfId", disc.getBookshelfId());
        Bookshelf bookshelf = bookshelfTypedQuery.getSingleResult();

        return ok(views.html.disc.render(disc, discGenre, retailer, discType, bookshelf, bookshelves));
    }
}
