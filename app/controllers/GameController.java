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

public class GameController extends Controller {

    private FormFactory formFactory;
    private JPAApi db;

    @Inject

    public GameController (FormFactory formFactory, JPAApi db) {
        this.formFactory = formFactory;
        this.db = db;
    }

    @Transactional(readOnly = true)
    public Result getGameEdit(int gameId){
        TypedQuery<Game> gameQuery = db.em().createQuery(
                "SELECT g FROM Game g WHERE gameId = :gameId",
                Game.class);
        gameQuery.setParameter("gameId", gameId);
        Game game = gameQuery.getSingleResult();

        TypedQuery<GameType> gameTypeQuery = db.em().createQuery(
                "SELECT gt FROM GameType gt ORDER BY gameTypeId",
                GameType.class);
        List<GameType> gameTypes = gameTypeQuery.getResultList();

        TypedQuery<GameGenre> genreQuery = db.em().createQuery(
                "SELECT g FROM GameGenre g ORDER BY gameGenreId",
                GameGenre.class);
        List<GameGenre> genres = genreQuery.getResultList();

        TypedQuery<Retailer> retailerQuery = db.em().createQuery(
                "SELECT r FROM Retailer r ORDER BY retailerId",
                Retailer.class);
        List<Retailer> retailers = retailerQuery.getResultList();

        TypedQuery<Bookshelf> bookshelfQuery = db.em().createQuery(
                "SELECT b FROM Bookshelf b ORDER BY bookshelfId",
                Bookshelf.class);
        List<Bookshelf> bookshelves = bookshelfQuery.getResultList();

        TypedQuery<Console> consoleQuery = db.em().createQuery(
                "SELECT c FROM Console c ORDER BY consoleId", Console.class);
        List<Console> consoles = consoleQuery.getResultList();

        return ok(views.html.updategame.render(game, gameTypes, genres, retailers, bookshelves, consoles));
    }

    @Transactional
    public Result postGameEdit(int gameId){
        TypedQuery<Game> gameQuery = db.em().createQuery(
                "SELECT g FROM Game g WHERE gameId = :gameId",
                Game.class);
        gameQuery.setParameter("gameId", gameId);
        Game game = gameQuery.getSingleResult();

        DynamicForm form = formFactory.form().bindFromRequest();
        String gameName = form.get("gamename");
        String sgameprice = form.get("gameprice");
        BigDecimal gamePrice = new BigDecimal(sgameprice);
        String sgametypeid = form.get("gametype");
        int gameTypeId = Integer.parseInt(sgametypeid);
        String sgenreId = form.get("genre");
        int genreId = Integer.parseInt(sgenreId);
        String sretailerId = form.get("retailer");
        int retailerId = Integer.parseInt(sretailerId);
        String sconsoleid = form.get("console");
        int consoleId = Integer.parseInt(sconsoleid);
        String sbookshelfId = form.get("bookshelf");
        int bookshelfId = Integer.parseInt(sbookshelfId);

        game.setGameName(gameName);
        game.setGamePrice(gamePrice);
        game.setGameTypeId(gameTypeId);
        game.setGameGenreId(genreId);
        game.setRetailerId(retailerId);
        game.setConsoleId(consoleId);
        game.setBookshelfId(bookshelfId);

        db.em().persist(game);

        TypedQuery<Bookshelf> bookshelfQuery = db.em().createQuery(
                "SELECT b FROM Bookshelf b WHERE bookshelfId = :bookshelfId",
                Bookshelf.class);
        bookshelfQuery.setParameter("bookshelfId", bookshelfId);
        Bookshelf bookshelf = bookshelfQuery.getSingleResult();
        List<Bookshelf> bookshelves = bookshelfQuery.getResultList();

        TypedQuery<BookDetail> bookDetailQuery = db.em().createQuery(
                "SELECT NEW models.BookDetail(b.bookId, b.bookName, " +
                        "b.bookPrice, bt.bookTypeName, g.genreName," +
                        " r.retailerName, b.authorName, b.bookshelfId) " +
                        "FROM Book b " +
                        "JOIN BookGenre g ON g.bookGenreId = b.bookGenreId " +
                        "JOIN BookType bt ON bt.bookTypeId = b.bookTypeId " +
                        "JOIN Retailer r ON r.retailerId = b.retailerId " +
                        "ORDER BY b.bookName", BookDetail.class);
        List<BookDetail> books = bookDetailQuery.getResultList();

        TypedQuery<GameDetail> gameDetailQuery = db.em().createQuery(
                "SELECT NEW models.GameDetail(g.gameId, g.gamePrice, " +
                        "g.gameName, gt.gameTypeName, ge.genreName, " +
                        "r.retailerName, c.consoleName, g.bookshelfId) " +
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
                        "g.genreName, r.retailerName, d.bookshelfId) " +
                        "FROM Disc d " +
                        "JOIN DiscType dt ON dt.discTypeId = d.discTypeId " +
                        "JOIN DiscGenre g ON g.discGenreId = d.discGenreId " +
                        "JOIN Retailer r ON r.retailerId = d.retailerId " +
                        "ORDER BY d.discName", DiscDetail.class);
        List<DiscDetail> discs = discDetailQuery.getResultList();

        TypedQuery<AlbumDetail> albumDetailQuery = db.em().createQuery(
                "SELECT NEW models.AlbumDetail(a.albumId, a.albumName, " +
                        "a.albumPrice, g.genreName, r.retailerName, a.artistName, a.bookshelfId) " +
                        "FROM Album a " +
                        "JOIN AlbumGenre g ON g.albumGenreId = a.albumGenreId " +
                        "JOIN Retailer r ON r.retailerId = a.retailerId " +
                        "ORDER BY a.albumName", AlbumDetail.class);
        List<AlbumDetail> albums = albumDetailQuery.getResultList();

        return ok(views.html.collection.render(bookshelf, books, games, discs, albums, bookshelves));
    }

    @Transactional(readOnly = true)
    public Result getGame(int gameId){
        TypedQuery<Game> gameQuery = db.em().createQuery(
                "SELECT g FROM Game g WHERE gameId = :gameId",
                Game.class);
        gameQuery.setParameter("gameId", gameId);
        Game game = gameQuery.getSingleResult();

        TypedQuery<GameType> gameTypeQuery = db.em().createQuery(
                "SELECT gt FROM GameType gt WHERE gameTypeId = :gameTypeId",
                GameType.class);
        gameTypeQuery.setParameter("gameTypeId", game.getGameTypeId());
        GameType gameType = gameTypeQuery.getSingleResult();

        TypedQuery<Retailer> retailerQuery = db.em().createQuery(
                "SELECT r FROM Retailer r WHERE retailerId = :retailerId",
                Retailer.class);
        retailerQuery.setParameter("retailerId", game.getRetailerId());
        Retailer retailer = retailerQuery.getSingleResult();

        TypedQuery<GameGenre> gameGenreQuery = db.em().createQuery(
                "SELECT gg FROM GameGenre gg WHERE gameGenreId = :gameGenreId",
                GameGenre.class);
        gameGenreQuery.setParameter("gameGenreId", game.getGameGenreId());
        GameGenre gameGenre = gameGenreQuery.getSingleResult();

        TypedQuery<Console> consoleQuery = db.em().createQuery(
                "SELECT c FROM Console c WHERE consoleId = :consoleId",
                Console.class);
        consoleQuery.setParameter("consoleId", game.getConsoleId());
        Console console = consoleQuery.getSingleResult();

        TypedQuery<Bookshelf> bookshelfQuery = db.em().createQuery(
                "SELECT b FROM Bookshelf b ORDER BY bookshelfId",
                Bookshelf.class);
        List<Bookshelf> bookshelves = bookshelfQuery.getResultList();

        TypedQuery<Bookshelf> bookshelfTypedQuery = db.em().createQuery(
                "SELECT b FROM Bookshelf b WHERE bookshelfId = :bookshelfId",
                Bookshelf.class);
        bookshelfTypedQuery.setParameter("bookshelfId", game.getBookshelfId());
        Bookshelf bookshelf = bookshelfTypedQuery.getSingleResult();

//        type retailer console genre

        return ok(views.html.game.render(game, gameType, retailer, gameGenre, console, bookshelf, bookshelves));
    }
}
