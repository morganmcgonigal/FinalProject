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
import javax.print.attribute.standard.Media;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionController extends Controller {

    private FormFactory formFactory;
    private JPAApi db;

    @Inject
    public CollectionController(FormFactory formFactory, JPAApi db) {
        this.formFactory = formFactory;
        this.db = db;
    }

    @Transactional(readOnly = true)
    public Result getCollection(int bookshelfId) {

        DynamicForm form = formFactory.form().bindFromRequest();
        String name = form.get("name");


        if (name == null){
            name = "";
        }

        name += "%" + "%";


        TypedQuery<Bookshelf> bookshelfQuery = db.em().createQuery(
                "SELECT b FROM Bookshelf b WHERE bookshelfId = :bookshelfId",
                Bookshelf.class);
        bookshelfQuery.setParameter("bookshelfId", bookshelfId);
        Bookshelf bookshelf = bookshelfQuery.getSingleResult();

        TypedQuery<Bookshelf> bookshelfTypedQuery = db.em().createQuery(
                "SELECT b FROM Bookshelf b",Bookshelf.class);
        List<Bookshelf> bookshelves = bookshelfTypedQuery.getResultList();


        TypedQuery<BookDetail> bookDetailQuery = db.em().createQuery(
                "SELECT NEW models.BookDetail(b.bookId, b.bookName, " +
                        "b.bookPrice, bt.bookTypeName, g.bookGenreName," +
                        " r.retailerName, b.authorName, b.bookshelfId, b.faceValue) " +
                        "FROM Book b " +
                        "JOIN BookGenre g ON g.bookGenreId = b.bookGenreId " +
                        "JOIN BookType bt ON bt.bookTypeId = b.bookTypeId " +
                        "JOIN Retailer r ON r.retailerId = b.retailerId " +
                        "WHERE b.bookName LIKE :name OR b.authorName LIKE :name " +
                        "ORDER BY b.bookName", BookDetail.class);
        bookDetailQuery.setParameter("name", name);
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
                        "WHERE g.gameName LIKE :name OR c.consoleName LIKE :name " +
                        "ORDER BY g.gameName", GameDetail.class);
        gameDetailQuery.setParameter("name", name);
        List<GameDetail> games = gameDetailQuery.getResultList();


        TypedQuery<DiscDetail> discDetailQuery = db.em().createQuery(
                "SELECT NEW models.DiscDetail(d.discId, d.discName," +
                        "d.discPrice, dt.discTypeName," +
                        "g.discGenreName, r.retailerName, d.bookshelfId, d.faceValue) " +
                        "FROM Disc d " +
                        "JOIN DiscType dt ON dt.discTypeId = d.discTypeId " +
                        "JOIN DiscGenre g ON g.discGenreId = d.discGenreId " +
                        "JOIN Retailer r ON r.retailerId = d.retailerId " +
                        "WHERE d.discName LIKE :name " +
                        "ORDER BY d.discName", DiscDetail.class);
        discDetailQuery.setParameter("name", name);
        List<DiscDetail> discs = discDetailQuery.getResultList();

        TypedQuery<AlbumDetail> albumDetailQuery = db.em().createQuery(
                "SELECT NEW models.AlbumDetail(a.albumId, a.albumName, " +
                        "a.albumPrice, ag.albumGenreName, r.retailerName, a.artistName, a.bookshelfId, a.faceValue) " +
                        "FROM Album a " +
                        "JOIN AlbumGenre ag ON ag.albumGenreId = a.albumGenreId " +
                        "JOIN Retailer r ON r.retailerId = a.retailerId " +
                        "WHERE a.albumName LIKE :name OR a.artistName LIKE :name " +
                        "ORDER BY a.albumName", AlbumDetail.class);
        albumDetailQuery.setParameter("name", name);
        List<AlbumDetail> albums = albumDetailQuery.getResultList();


        return ok(views.html.collection.render(bookshelf, books, games, discs, albums, bookshelves));
    }

    @Transactional(readOnly = true)
    public Result getCollectionChart(int bookshelfId) {

        TypedQuery<Bookshelf> bookshelfTypedQuery = db.em().createQuery(
                "SELECT b from Bookshelf b ORDER BY bookshelfId",
                Bookshelf.class);
        List<Bookshelf> bookshelves = bookshelfTypedQuery.getResultList();


        TypedQuery<Bookshelf> bookshelfQuery = db.em().createQuery(
                "SELECT b FROM Bookshelf b WHERE bookshelfId = :bookshelfId",
                Bookshelf.class);
        bookshelfQuery.setParameter("bookshelfId", bookshelfId);
        Bookshelf bookshelf = bookshelfQuery.getSingleResult();

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
                        "g.discGenreName, r.retailerName, d.artistName, d.bookshelfId, d.faceValue) " +
                        "FROM Disc d " +
                        "JOIN DiscType dt ON dt.discTypeId = d.discTypeId " +
                        "JOIN DiscGenre g ON g.discGenreId = d.discGenreId " +
                        "JOIN Retailer r ON r.retailerId = d.retailerId " +
                        "ORDER BY d.discName", DiscDetail.class);
        List<DiscDetail> discs = discDetailQuery.getResultList();

        TypedQuery<AlbumDetail> albumDetailQuery = db.em().createQuery(
                "SELECT NEW models.AlbumDetail(a.albumId, a.albumName, " +
                        "a.albumPrice, ag.albumGenreName, r.retailerName, a.artistName, a.bookshelfId, a.faceValue) " +
                        "FROM Album a " +
                        "JOIN AlbumGenre ag ON ag.albumGenreId = a.albumGenreId " +
                        "JOIN Retailer r ON r.retailerId = a.retailerId " +
                        "ORDER BY a.albumName", AlbumDetail.class);
        List<AlbumDetail> albums = albumDetailQuery.getResultList();

        return ok(views.html.collection.render(bookshelf, books, games, discs, albums, bookshelves));
    }

    @Transactional(readOnly = true)
    public Result getCollectionPDF(int bookshelfId) {
        TypedQuery<Bookshelf> bookshelfQuery = db.em().createQuery(
                "SELECT b FROM Bookshelf b WHERE bookshelfId = :bookshelfId",
                Bookshelf.class);
        bookshelfQuery.setParameter("bookshelfId", bookshelfId);
        Bookshelf bookshelf = bookshelfQuery.getSingleResult();

        TypedQuery<Bookshelf> bookshelfTypedQuery = db.em().createQuery(
                "SELECT b FROM Bookshelf b",Bookshelf.class);
        List<Bookshelf> bookshelves = bookshelfTypedQuery.getResultList();


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
                        "a.albumPrice, ag.albumGenreName, r.retailerName, a.artistName, a.bookshelfId, a.faceValue) " +
                        "FROM Album a " +
                        "JOIN AlbumGenre ag ON ag.albumGenreId = a.albumGenreId " +
                        "JOIN Retailer r ON r.retailerId = a.retailerId " +
                        "ORDER BY a.albumName", AlbumDetail.class);
        List<AlbumDetail> albums = albumDetailQuery.getResultList();



        return ok(views.html.index.render(bookshelves));
    }

    @Transactional(readOnly = true)
    public Result getBookAdd() {
        TypedQuery<BookType> bookTypeQuery = db.em().createQuery(
                "SELECT bt FROM BookType bt ORDER BY bookTypeId",
                BookType.class);
        List<BookType> bookTypes = bookTypeQuery.getResultList();

        TypedQuery<BookGenre> genreQuery = db.em().createQuery(
                "SELECT g FROM BookGenre g ORDER BY bookGenreId",
                BookGenre.class);
        List<BookGenre> genres = genreQuery.getResultList();

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
    public Result postBookAdd() {
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
        String sfaceValue = form.get("facevalue");
        BigDecimal faceValue = new BigDecimal(sfaceValue);

        books.setBookName(bookName);
        books.setBookPrice(bookPrice);
        books.setBookTypeId(bookTypeId);
        books.setBookGenreId(genreId);
        books.setRetailerId(retailerId);
        books.setAuthorName(authorName);
        books.setBookshelfId(bookshelfId);
        books.setFaceValue(faceValue);
        db.em().persist(books);

        TypedQuery<BookType> bookTypeQuery = db.em().createQuery(
                "SELECT bt FROM BookType bt ORDER BY bookTypeId",
                BookType.class);
        List<BookType> bookTypes = bookTypeQuery.getResultList();

        TypedQuery<BookGenre> genreQuery = db.em().createQuery(
                "SELECT g FROM BookGenre g ORDER BY bookGenreId",
                BookGenre.class);
        List<BookGenre> genres = genreQuery.getResultList();

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

    @Transactional(readOnly = true)
    public Result getDiscAdd() {
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

        TypedQuery<DiscType> discTypeQuery = db.em().createQuery(
                "SELECT dt FROM DiscType dt ORDER BY discTypeId",
                DiscType.class);
        List<DiscType> discTypes = discTypeQuery.getResultList();

        return ok(views.html.adddisc.render(discTypes, genres, retailers, bookshelves));

    }

    @Transactional
    public Result postDiscAdd() {
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
        String sfaceValue = form.get("facevalue");
        BigDecimal faceValue = new BigDecimal(sfaceValue);

        discs.setDiscName(discName);
        discs.setDiscPrice(discPrice);
        discs.setDiscTypeId(discTypeId);
        discs.setDiscGenreId(genreId);
        discs.setRetailerId(retailerId);
        discs.setBookshelfId(bookshelfId);
        discs.setFaceValue(faceValue);
        db.em().persist(discs);

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

        TypedQuery<DiscType> discTypeQuery = db.em().createQuery(
                "SELECT dt FROM DiscType dt ORDER BY discTypeId",
                DiscType.class);
        List<DiscType> discTypes = discTypeQuery.getResultList();

        return ok(views.html.adddisc.render(discTypes, genres, retailers, bookshelves));

    }

    @Transactional(readOnly = true)
    public Result getGameAdd() {
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
    public Result postGameAdd() {
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
        String sfaceValue = form.get("facevalue");
        BigDecimal faceValue = new BigDecimal(sfaceValue);

        games.setGameName(gameName);
        games.setGamePrice(gamePrice);
        games.setGameTypeId(gameTypeId);
        games.setGameGenreId(genreId);
        games.setRetailerId(retailerId);
        games.setBookshelfId(bookshelfId);
        games.setConsoleId(consoleId);
        games.setFaceValue(faceValue);
        db.em().persist(games);

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

    @Transactional(readOnly = true)
    public Result getAlbumAdd() {
        TypedQuery<AlbumGenre> albumGenreQuery = db.em().createQuery(
                "SELECT ag FROM AlbumGenre ag ORDER BY albumGenreId",
                AlbumGenre.class);
        List<AlbumGenre> albumGenres = albumGenreQuery.getResultList();

        TypedQuery<Retailer> retailerQuery = db.em().createQuery(
                "SELECT r FROM Retailer r ORDER BY retailerId",
                Retailer.class);
        List<Retailer> retailers = retailerQuery.getResultList();

        TypedQuery<Bookshelf> bookshelfQuery = db.em().createQuery(
                "SELECT b FROM Bookshelf b ORDER BY bookshelfId",
                Bookshelf.class);
        List<Bookshelf> bookshelves = bookshelfQuery.getResultList();

        return ok(views.html.addalbum.render(albumGenres, retailers, bookshelves));
    }

    @Transactional
    public Result postAlbumAdd() {
        Album albums = new Album();

        DynamicForm form = formFactory.form().bindFromRequest();
        String albumName = form.get("albumname");
        String salbumPrice = form.get("albumprice");
        BigDecimal albumPrice = new BigDecimal(salbumPrice);
        String genre = form.get("genre");
        int genreId = Integer.parseInt(genre);
        String retailer = form.get("retailer");
        int retailerId = Integer.parseInt(retailer);
        String shelf = form.get("bookshelf");
        int bookshelfId = Integer.parseInt(shelf);
        String artistName = form.get("artistname");
        String sfaceValue = form.get("facevalue");
        BigDecimal faceValue = new BigDecimal(sfaceValue);

        albums.setAlbumName(albumName);
        albums.setAlbumPrice(albumPrice);
        albums.setAlbumGenreId(genreId);
        albums.setRetailerId(retailerId);
        albums.setBookshelfId(bookshelfId);
        albums.setArtistName(artistName);
        albums.setFaceValue(faceValue);
        db.em().persist(albums);

        TypedQuery<AlbumGenre> genreQuery = db.em().createQuery(
                "SELECT ag FROM AlbumGenre ag ORDER BY albumGenreId",
                AlbumGenre.class);
        List<AlbumGenre> genres = genreQuery.getResultList();

        TypedQuery<Retailer> retailerQuery = db.em().createQuery(
                "SELECT r FROM Retailer r ORDER BY retailerId",
                Retailer.class);
        List<Retailer> retailers = retailerQuery.getResultList();

        TypedQuery<Bookshelf> bookshelfQuery = db.em().createQuery(
                "SELECT b FROM Bookshelf b ORDER BY bookshelfId",
                Bookshelf.class);
        List<Bookshelf> bookshelves = bookshelfQuery.getResultList();

        return ok(views.html.addalbum.render(genres, retailers, bookshelves));
    }

    @Transactional
    public Result getDeleteBook(int bookId) {

        Book book = db.em().find(Book.class, bookId);
        db.em().remove(book);

        TypedQuery<Bookshelf> bookshelfQuery = db.em().createQuery(
                "SELECT b FROM Bookshelf b ORDER BY bookshelfId",
                Bookshelf.class);
        List<Bookshelf> bookshelves = bookshelfQuery.getResultList();

        return ok(views.html.index.render(bookshelves));
    }

    @Transactional
    public Result getDeleteDisc(int discId) {

        Disc disc = db.em().find(Disc.class, discId);
        db.em().remove(disc);

        TypedQuery<Bookshelf> bookshelfQuery = db.em().createQuery(
                "SELECT b FROM Bookshelf b ORDER BY bookshelfId",
                Bookshelf.class);
        List<Bookshelf> bookshelves = bookshelfQuery.getResultList();

        return ok(views.html.index.render(bookshelves));
    }

    @Transactional
    public Result getDeleteGame(int gameId) {

        Game game = db.em().find(Game.class, gameId);
        db.em().remove(game);

        TypedQuery<Bookshelf> bookshelfQuery = db.em().createQuery(
                "SELECT b FROM Bookshelf b ORDER BY bookshelfId",
                Bookshelf.class);
        List<Bookshelf> bookshelves = bookshelfQuery.getResultList();

        return ok(views.html.index.render(bookshelves));
    }

    @Transactional
    public Result getDeleteAlbum(int albumId) {

        Album album = db.em().find(Album.class, albumId);
        db.em().remove(album);

        TypedQuery<Bookshelf> bookshelfQuery = db.em().createQuery(
                "SELECT b FROM Bookshelf b ORDER BY bookshelfId",
                Bookshelf.class);
        List<Bookshelf> bookshelves = bookshelfQuery.getResultList();

        return ok(views.html.index.render(bookshelves));
    }

    @Transactional(readOnly = true)
    public Result getAddBookshelf(){
        TypedQuery<Bookshelf> bookshelfQuery = db.em().createQuery(
                "SELECT b FROM Bookshelf b ORDER BY bookshelfId",
                Bookshelf.class);
        List<Bookshelf> bookshelves = bookshelfQuery.getResultList();

        return ok(views.html.addbookshelf.render(bookshelves));
    }

    @Transactional
    public Result postAddBookshelf(){
        Bookshelf bookshelf = new Bookshelf();

        DynamicForm form = formFactory.form().bindFromRequest();
        String bookshelfName = form.get("bookshelfname");

        bookshelf.setBookshelfName(bookshelfName);

        db.em().persist(bookshelf);

        TypedQuery<Bookshelf> bookshelfQuery = db.em().createQuery(
                "SELECT b FROM Bookshelf b ORDER BY bookshelfId",
                Bookshelf.class);
        List<Bookshelf> bookshelves = bookshelfQuery.getResultList();

        return ok(views.html.index.render(bookshelves));
    }

    @Transactional
    public Result getDeleteCollection(int bookshelfId){
        Bookshelf bookshelf = db.em().find(Bookshelf.class, bookshelfId);
        db.em().remove(bookshelf);

        TypedQuery<Bookshelf> bookshelfQuery = db.em().createQuery(
                "SELECT b FROM Bookshelf b ORDER BY bookshelfId",
                Bookshelf.class);
        List<Bookshelf> bookshelves = bookshelfQuery.getResultList();

        return ok(views.html.index.render(bookshelves));
    }

    private int bookshelfId;

    private String bookshelfName;
    private long books;
}
