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

    @Transactional(readOnly =  true)
    public Result getBookAdd(){
        TypedQuery<BookType> bookTypeQuery = db.em().createQuery(
                "SELECT bt FROM BookType bt ORDER BY bookTypeId",
                BookType.class);
        List<BookType> bookTypes = bookTypeQuery.getResultList();

        TypedQuery<Genre> genreQuery = db.em().createQuery(
                "SELECT g FROM Genre g ORDER BY genreId",
                Genre.class);
        List<Genre> genres = genreQuery.getResultList();

        TypedQuery<Retailer> retailerQuery = db.em().createQuery(
                "SELECT r FROM Retailer r ORDER BY retailerId",
                Retailer.class);
        List<Retailer> retailers = retailerQuery.getResultList();

        TypedQuery<Bookshelf> bookshelfQuery = db.em().createQuery(
                "SELECT b FROM Bookshelf b ORDER BY bookshelfId",
                Bookshelf.class);
        List<Bookshelf> bookshelves = bookshelfQuery.getResultList();

        return ok(views.html.addbook.render(bookTypes, genres, retailers, bookshelves));

    }

    @Transactional
    public Result postBookAdd(){
        Book books = new Book();

        DynamicForm form = formFactory.form().bindFromRequest();
        String bookName = form.get("bookname");
        String sBookPrice = form.get("bookprice");
        BigDecimal bookPrice = new BigDecimal(sBookPrice);
        String bookType = form.get("booktype");
        int bookTypeId = Integer.parseInt(bookType);
        String genre = form.get("genre");
        int genreId = Integer.parseInt(genre);
        String retailer = form.get("retailer");
        int retailerId = Integer.parseInt(retailer);
        String authorName = form.get("authorname");
        String bookshelf = form.get("bookshelf");
        int bookshelfId = Integer.parseInt(bookshelf);

        books.setBookName(bookName);
        books.setBookPrice(bookPrice);
        books.setBookTypeId(bookTypeId);
        books.setGenreId(genreId);
        books.setRetailerId(retailerId);
        books.setAuthorName(authorName);
        books.setBookshelfId(bookshelfId);
        db.em().persist(books);

        TypedQuery<BookType> bookTypeQuery = db.em().createQuery(
                "SELECT bt FROM BookType bt ORDER BY bookTypeId",
                BookType.class);
        List<BookType> bookTypes = bookTypeQuery.getResultList();

        TypedQuery<Genre> genreQuery = db.em().createQuery(
                "SELECT g FROM Genre g ORDER BY genreId",
                Genre.class);
        List<Genre> genres = genreQuery.getResultList();

        TypedQuery<Retailer> retailerQuery = db.em().createQuery(
                "SELECT r FROM Retailer r ORDER BY retailerId",
                Retailer.class);
        List<Retailer> retailers = retailerQuery.getResultList();

        TypedQuery<Bookshelf> bookshelfQuery = db.em().createQuery(
                "SELECT b FROM Bookshelf b ORDER BY bookshelfId",
                Bookshelf.class);
        List<Bookshelf> bookshelves = bookshelfQuery.getResultList();

        return ok(views.html.addbook.render(bookTypes, genres, retailers, bookshelves));

    }

    @Transactional(readOnly =  true)
    public Result getDiscAdd(){
        TypedQuery<Genre> genreQuery = db.em().createQuery(
                "SELECT g FROM Genre g ORDER BY genreId",
                Genre.class);
        List<Genre> genres = genreQuery.getResultList();

        TypedQuery<Retailer> retailerQuery = db.em().createQuery(
                "SELECT r FROM Retailer r ORDER BY retailerId",
                Retailer.class);
        List<Retailer> retailers = retailerQuery.getResultList();

        TypedQuery<Bookshelf> bookshelfQuery = db.em().createQuery(
                "SELECT b FROM Bookshelf b ORDER BY bookshelfId",
                Bookshelf.class);
        List<Bookshelf> bookshelves = bookshelfQuery.getResultList();

        TypedQuery<DiscType> discTypeQuery = db.em().createQuery(
                "SELECT dt FROM DiscType dt ORDER BY discTypeId",
                DiscType.class);
        List<DiscType> discTypes = discTypeQuery.getResultList();

        return ok(views.html.adddisc.render(discTypes, genres, retailers, bookshelves));

    }

    @Transactional
    public Result postDiscAdd(){
        Disc discs = new Disc();

        DynamicForm form = formFactory.form().bindFromRequest();
        String discName = form.get("discname");
        String sdiscPrice = form.get("discprice");
        BigDecimal discPrice = new BigDecimal(sdiscPrice);
        String discType = form.get("disctype");
        int discTypeId = Integer.parseInt(discType);
        String genre = form.get("genre");
        int genreId = Integer.parseInt(genre);
        String retailer = form.get("retailer");
        int retailerId = Integer.parseInt(retailer);
        String shelf = form.get("bookshelf");
        int bookshelfId = Integer.parseInt(shelf);
        String artistName = form.get("artistname");

        discs.setDiscName(discName);
        discs.setDiscPrice(discPrice);
        discs.setDiscTypeId(discTypeId);
        discs.setGenreId(genreId);
        discs.setRetailerId(retailerId);
        discs.setBookshelfId(bookshelfId);
        discs.setArtistName(artistName);
        db.em().persist(discs);

        TypedQuery<Genre> genreQuery = db.em().createQuery(
                "SELECT g FROM Genre g ORDER BY genreId",
                Genre.class);
        List<Genre> genres = genreQuery.getResultList();

        TypedQuery<Retailer> retailerQuery = db.em().createQuery(
                "SELECT r FROM Retailer r ORDER BY retailerId",
                Retailer.class);
        List<Retailer> retailers = retailerQuery.getResultList();

        TypedQuery<Bookshelf> bookshelfQuery = db.em().createQuery(
                "SELECT b FROM Bookshelf b ORDER BY bookshelfId",
                Bookshelf.class);
        List<Bookshelf> bookshelves = bookshelfQuery.getResultList();

        TypedQuery<DiscType> discTypeQuery = db.em().createQuery(
                "SELECT dt FROM DiscType dt ORDER BY discTypeId",
                DiscType.class);
        List<DiscType> discTypes = discTypeQuery.getResultList();

        return ok(views.html.adddisc.render(discTypes, genres, retailers, bookshelves));

    }

    @Transactional(readOnly =  true)
    public Result getGameAdd(){
        TypedQuery<Genre> genreQuery = db.em().createQuery(
                "SELECT g FROM Genre g ORDER BY genreId",
                Genre.class);
        List<Genre> genres = genreQuery.getResultList();

        TypedQuery<Retailer> retailerQuery = db.em().createQuery(
                "SELECT r FROM Retailer r ORDER BY retailerId",
                Retailer.class);
        List<Retailer> retailers = retailerQuery.getResultList();

        TypedQuery<Bookshelf> bookshelfQuery = db.em().createQuery(
                "SELECT b FROM Bookshelf b ORDER BY bookshelfId",
                Bookshelf.class);
        List<Bookshelf> bookshelves = bookshelfQuery.getResultList();

        TypedQuery<GameType> gameTypeQuery = db.em().createQuery(
                "SELECT gt FROM GameType gt ORDER BY gameTypeId",
                GameType.class);
        List<GameType> gameTypes = gameTypeQuery.getResultList();

        TypedQuery<models.Console> consoleQuery = db.em().createQuery(
                "SELECT c FROM Console c ORDER BY consoleId",
                models.Console.class);
        List<models.Console> consoles = consoleQuery.getResultList();

        return ok(views.html.addgame.render(gameTypes, genres, retailers, bookshelves, consoles));

    }

    @Transactional
    public Result postGameAdd(){
        Game games = new Game();

        DynamicForm form = formFactory.form().bindFromRequest();
        String gameName = form.get("gamename");
        String sgamePrice = form.get("gameprice");
        BigDecimal gamePrice = new BigDecimal(sgamePrice);
        String gameType = form.get("gametype");
        int gameTypeId = Integer.parseInt(gameType);
        String genre = form.get("genre");
        int genreId = Integer.parseInt(genre);
        String retailer = form.get("retailer");
        int retailerId = Integer.parseInt(retailer);
        String shelf = form.get("bookshelf");
        int bookshelfId = Integer.parseInt(shelf);
        String console = form.get("consolename");
        int consoleId = Integer.parseInt(console);

        games.setGameName(gameName);
        games.setGamePrice(gamePrice);
        games.setGameTypeId(gameTypeId);
        games.setGenreId(genreId);
        games.setRetailerId(retailerId);
        games.setBookshelfId(bookshelfId);
        games.setConsoleId(consoleId);
        db.em().persist(games);

        TypedQuery<Genre> genreQuery = db.em().createQuery(
                "SELECT g FROM Genre g ORDER BY genreId",
                Genre.class);
        List<Genre> genres = genreQuery.getResultList();

        TypedQuery<Retailer> retailerQuery = db.em().createQuery(
                "SELECT r FROM Retailer r ORDER BY retailerId",
                Retailer.class);
        List<Retailer> retailers = retailerQuery.getResultList();

        TypedQuery<Bookshelf> bookshelfQuery = db.em().createQuery(
                "SELECT b FROM Bookshelf b ORDER BY bookshelfId",
                Bookshelf.class);
        List<Bookshelf> bookshelves = bookshelfQuery.getResultList();

        TypedQuery<GameType> gameTypeQuery = db.em().createQuery(
                "SELECT gt FROM GameType gt ORDER BY gameTypeId",
                GameType.class);
        List<GameType> gameTypes = gameTypeQuery.getResultList();

        TypedQuery<models.Console> consoleQuery = db.em().createQuery(
                "SELECT c FROM Console c ORDER BY consoleId",
                models.Console.class);
        List<models.Console> consoles = consoleQuery.getResultList();

        return ok(views.html.addgame.render(gameTypes, genres, retailers, bookshelves, consoles));
    }
}
