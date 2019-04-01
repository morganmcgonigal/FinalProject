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

public class AlbumController extends Controller {
    private JPAApi db;

    private FormFactory formFactory;

    @Inject

    public AlbumController(JPAApi db, FormFactory formFactory) {
        this.db = db;
        this.formFactory = formFactory;
    }

    @Transactional(readOnly = true)
    public Result getAlbumEdit(int albumId){
        TypedQuery<Album> albumQuery = db.em().createQuery(
                "SELECT b FROM Album b WHERE albumId = :albumId",
                Album.class);
        albumQuery.setParameter("albumId", albumId);
        Album album = albumQuery.getSingleResult();

        TypedQuery<AlbumGenre> albumGenreQuery = db.em().createQuery(
                "SELECT g FROM AlbumGenre g ORDER BY albumGenreId",
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

        return ok(views.html.updatealbum.render(album, albumGenres, retailers, bookshelves));
    }

    @Transactional
    public Result postAlbumEdit(int albumId){
        TypedQuery<Album> albumQuery = db.em().createQuery(
                "SELECT b FROM Album b WHERE albumId = :albumId",
                Album.class);
        albumQuery.setParameter("albumId", albumId);
        Album album = albumQuery.getSingleResult();

        DynamicForm form = formFactory.form().bindFromRequest();
        String albumName = form.get("albumname");
        String salbumPrice = form.get("albumprice");
        BigDecimal albumPrice = new BigDecimal(salbumPrice);
        String sgenreId = form.get("genre");
        int genreId = Integer.parseInt(sgenreId);
        String sretailerId = form.get("retailer");
        int retailerId = Integer.parseInt(sretailerId);
        String artistName = form.get("artistname");
        String sbookshelfId = form.get("bookshelf");
        int bookshelfId = Integer.parseInt(sbookshelfId);

        album.setAlbumName(albumName);
        album.setAlbumPrice(albumPrice);
        album.setAlbumGenreId(genreId);
        album.setRetailerId(retailerId);
        album.setArtistName(artistName);
        album.setBookshelfId(bookshelfId);

        db.em().persist(album);

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
                        "g.genreName, r.retailerName, d.artistName, d.bookshelfId) " +
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

        return ok(views.html.collection.render(bookshelf, books, games, discs, albums));
    }

    @Transactional (readOnly = true)
    public Result getAlbum(int albumId){
        TypedQuery<Album> albumQuery = db.em().createQuery(
                "SELECT a FROM Album a WHERE albumId = :albumId",
                Album.class);
        albumQuery.setParameter("albumId", albumId);
        Album album = albumQuery.getSingleResult();

        TypedQuery<AlbumGenre> albumGenreQuery = db.em().createQuery(
                "SELECT ag FROM AlbumGenre ag WHERE albumGenreId = :albumGenreId",
                AlbumGenre.class);
        albumGenreQuery.setParameter("albumGenreId", album.getAlbumGenreId());
        AlbumGenre albumGenre = albumGenreQuery.getSingleResult();

        TypedQuery<Retailer> retailerQuery = db.em().createQuery(
                "SELECT r FROM Retailer r WHERE retailerId = :retailerId",
                Retailer.class);
        retailerQuery.setParameter("retailerId", album.getRetailerId());
        Retailer retailer = retailerQuery.getSingleResult();

        return ok(views.html.album.render(album, albumGenre, retailer));
    }
}
