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

public class BookController extends Controller {

    private FormFactory formFactory;
    private JPAApi db;

    @Inject
    public BookController (FormFactory formFactory, JPAApi db) {
        this.formFactory = formFactory;
        this.db = db;
    }

    @Transactional(readOnly = true)
    public Result getBookEdit(int bookId){
        TypedQuery<Book> bookQuery = db.em().createQuery(
                "SELECT b FROM Book b WHERE bookId = :bookId",
                Book.class);
        bookQuery.setParameter("bookId", bookId);
        Book book = bookQuery.getSingleResult();

        TypedQuery<BookType> bookTypeQuery = db.em().createQuery(
                "SELECT bt FROM BookType bt ORDER BY bookTypeId",
                BookType.class);
        List<BookType> bookTypes = bookTypeQuery.getResultList();

        TypedQuery<BookGenre> bookGenreQuery = db.em().createQuery(
                "SELECT g FROM BookGenre g ORDER BY bookGenreId",
                BookGenre.class);
        List<BookGenre> bookGenres = bookGenreQuery.getResultList();

        TypedQuery<Retailer> retailerQuery = db.em().createQuery(
                "SELECT r FROM Retailer r ORDER BY retailerId",
                Retailer.class);
        List<Retailer> retailers = retailerQuery.getResultList();

        TypedQuery<Bookshelf> bookshelfQuery = db.em().createQuery(
                "SELECT b FROM Bookshelf b ORDER BY bookshelfId",
                Bookshelf.class);
        List<Bookshelf> bookshelves = bookshelfQuery.getResultList();

        return ok(views.html.updatebook.render(book, bookTypes, bookGenres, retailers, bookshelves));
    }

    @Transactional
    public Result postBookEdit(int bookId){
        TypedQuery<Book> bookQuery = db.em().createQuery(
                "SELECT b FROM Book b WHERE bookId = :bookId",
                Book.class);
        bookQuery.setParameter("bookId", bookId);
        Book book = bookQuery.getSingleResult();

        DynamicForm form = formFactory.form().bindFromRequest();
        String bookName = form.get("bookname");
        String sbookPrice = form.get("bookprice");
        BigDecimal bookPrice = new BigDecimal(sbookPrice);
        String sbookTypeId = form.get("booktype");
        int bookTypeId = Integer.parseInt(sbookTypeId);
        String sgenreId = form.get("genre");
        int genreId = Integer.parseInt(sgenreId);
        String sretailerId = form.get("retailer");
        int retailerId = Integer.parseInt(sretailerId);
        String authorName = form.get("authorname");
        String sbookshelfId = form.get("bookshelf");
        int bookshelfId = Integer.parseInt(sbookshelfId);

        book.setBookName(bookName);
        book.setBookPrice(bookPrice);
        book.setBookTypeId(bookTypeId);
        book.setBookGenreId(genreId);
        book.setRetailerId(retailerId);
        book.setAuthorName(authorName);
        book.setBookTypeId(bookshelfId);

        db.em().persist(book);

        TypedQuery<Bookshelf> bookshelfQuery = db.em().createQuery(
                "SELECT b FROM Bookshelf b WHERE bookshelfId = :bookshelfId",
                Bookshelf.class);
        bookshelfQuery.setParameter("bookshelfId", bookshelfId);
        Bookshelf bookshelf = bookshelfQuery.getSingleResult();

        TypedQuery<BookDetail> bookDetailQuery = db.em().createQuery(
                "SELECT NEW models.BookDetail(b.bookId, b.bookName, " +
                        "b.bookPrice, bt.bookTypeName, g.genreName," +
                        " r.retailerName, b.authorName, b.bookshelfId) " +
                        "FROM Book b " +
                        "JOIN BookGenre g ON g.genreId = b.genreId " +
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
                        "JOIN GameGenre ge ON ge.genreId = g.genreId " +
                        "JOIN Retailer r ON r.retailerId = g.retailerId " +
                        "JOIN Console c ON c.consoleId = g.consoleId " +
                        "ORDER BY g.gameName", GameDetail.class);
        List<GameDetail> games = gameDetailQuery.getResultList();


        TypedQuery<DiscDetail> discDetailQuery = db.em().createQuery(
                "SELECT NEW models.DiscDetail(d.discId, d.discName," +
                        "d.discPrice, dt.discTypeName," +
                        "g.genreName, r.retailerName, d.artistName, d.bookshelfId) " +
                        "FROM Disc d " +
                        "JOIN DiscType dt ON dt.discTypeId = d.discTypeId " +
                        "JOIN DiscGenre g ON g.genreId = d.genreId " +
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

        return ok(views.html.collection.render(bookshelf, books, games, discs, albums));
    }

    @Transactional(readOnly = true)
    public Result getBook(int bookId) {
        TypedQuery<Book> bookQuery = db.em().createQuery(
                "SELECT b FROM Book b WHERE bookId = :bookId", Book.class);
        bookQuery.setParameter("bookId", bookId);
        Book book = bookQuery.getSingleResult();

        TypedQuery<BookType> bookTypeQuery = db.em().createQuery(
                "SELECT bt FROM BookType bt WHERE bookTypeId = :bookTypeId",
                BookType.class);
        bookTypeQuery.setParameter("bookTypeId", book.getBookTypeId());
        BookType bookType = bookTypeQuery.getSingleResult();

        TypedQuery<Retailer> retailerQuery = db.em().createQuery(
                "SELECT r FROM Retailer r WHERE retailerId = :retailerId",
                Retailer.class);
        retailerQuery.setParameter("retailerId", book.getRetailerId());
        Retailer retailer = retailerQuery.getSingleResult();

        TypedQuery<BookGenre> bookGenreQuery = db.em().createQuery(
                "SELECT bg FROM BookGenre bg WHERE bookGenreId = :bookGenreId",
                BookGenre.class);
        bookGenreQuery.setParameter("bookGenreId", book.getBookGenreId());
        BookGenre bookGenre = bookGenreQuery.getSingleResult();

        return ok(views.html.book.render(book, bookType, retailer, bookGenre));
    }
}
