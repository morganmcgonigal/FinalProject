package controllers;


import models.*;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import services.PDF;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.util.List;

public class FinalCollectionController extends Controller {

    private JPAApi db;
    private FormFactory formFactory;

    @Inject
    public FinalCollectionController(JPAApi db, FormFactory formFactory) {
        this.db = db;
        this.formFactory = formFactory;
    }

    @Transactional
    public Result getDocument() {

        int bookshelfId = 1;

        List<FinalCollectionTable> finalCollectionTableTypedQuery = db.em().createQuery(
                "SELECT NEW models.FinalCollectionTable(b.bookshelfId, b.bookId, b.bookName, b.bookPrice, bt.bookTypeName, " +
                        "bg.bookGenreName, r.retailerName, b.authorName) " +
                        "FROM Book b " +
                        "JOIN BookType bt ON b.bookTypeId = bt.bookTypeId " +
                        "JOIN BookGenre bg ON b.bookGenreId = bg.bookGenreId " +
                        "JOIN Retailer r ON b.retailerId = r.retailerId " +
                        "WHERE b.bookshelfId = :bookshelfId " +
                        "ORDER BY b.bookName", FinalCollectionTable.class).setParameter("bookshelfId", bookshelfId).getResultList();

        List<FinalAlbumCollectionTable> finalAlbumCollectionTables = db.em().createQuery(
                "SELECT NEW models.FinalAlbumCollectionTable(a.bookshelfId, a.albumId, a.albumName, " +
                        "a.artistName, a.albumPrice, ag.albumGenreName, r.retailerName) " +
                        "FROM Album a " +
                        "JOIN AlbumGenre ag ON a.albumGenreId = ag.albumGenreId " +
                        "JOIN Retailer r ON a.retailerId = r.retailerId " +
                        "WHERE a.bookshelfId = :bookshelfId " +
                        "ORDER BY a.albumName", FinalAlbumCollectionTable.class).setParameter("bookshelfId", bookshelfId).getResultList();

        List<FinalDiscCollectionTable> finalDiscCollectionTables = db.em().createQuery(
                "SELECT NEW models.FinalDiscCollectionTable(d.bookshelfId, d.discId, d.discName, " +
                        "d.discPrice, dt.discTypeName, r.retailerName, dg.discGenreName) " +
                        "FROM Disc d " +
                        "JOIN DiscType dt ON d.discTypeId = dt.discTypeId " +
                        "JOIN DiscGenre dg ON d.discGenreId = dg.discGenreId " +
                        "JOIN Retailer r ON d.retailerId = r.retailerId " +
                        "WHERE d.bookshelfId = :bookshelfId " +
                        "ORDER BY d.discName", FinalDiscCollectionTable.class).setParameter("bookshelfId", bookshelfId).getResultList();

        List<FinalGameCollectionTable> finalGameCollectionTables = db.em().createQuery(
                "SELECT NEW models.FinalGameCollectionTable(g.bookshelfId, g.gameId, g.gameName, g.gamePrice, " +
                        "gt.gameTypeName, c.consoleName, r.retailerName, gg.gameGenreName) " +
                        "FROM Game g " +
                        "JOIN GameType gt ON g.gameTypeId = gt.gameTypeId " +
                        "JOIN Console c ON c.consoleId = g.consoleId " +
                        "JOIN Retailer r ON r.retailerId = g.retailerId " +
                        "JOIN GameGenre gg ON g.gameGenreId = gg.gameGenreId " +
                        "WHERE g.bookshelfId = :bookshelfId " +
                        "ORDER BY g.gameName", FinalGameCollectionTable.class).setParameter("bookshelfId", bookshelfId).getResultList();

        return ok(PDF.getPDF(finalCollectionTableTypedQuery, finalAlbumCollectionTables, finalDiscCollectionTables, finalGameCollectionTables)).as("application/pdf");
    }
}
