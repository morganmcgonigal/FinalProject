package services;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Tab;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import models.*;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class PDF {

    public static byte[] getPDF(List<FinalCollectionTable> finalCollectionTables,
                                List<FinalAlbumCollectionTable> finalAlbumCollectionTables,
                                List<FinalDiscCollectionTable> finalDiscCollectionTables,
                                List<FinalGameCollectionTable> finalGameCollectionTables){
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(output);
        PdfDocument pdfDocument = new PdfDocument(writer);
        Document document = new Document(pdfDocument, PageSize.A4);

        Text space = new Text("\n");
        Tab tab = new Tab();

        Text collectionHeader = new Text("Entire Collection");
        collectionHeader.setFontSize(20);
        collectionHeader.setBold();

        Text bookCollectionHeader = new Text("Books");
        bookCollectionHeader.setFontSize(15);
        bookCollectionHeader.setBold();

        Paragraph paragraph = new Paragraph();
        paragraph.setTextAlignment(TextAlignment.CENTER);
        paragraph.add(collectionHeader);
        paragraph.add(space);

        Paragraph paragraph1 = new Paragraph();
        paragraph1.add(bookCollectionHeader);
        paragraph1.add(space);



        Table bookTable = new Table(7);
        bookTable.setWidth(UnitValue.createPercentValue(100));
        bookTable.addHeaderCell("Name");
        bookTable.addHeaderCell("Author");
        bookTable.addHeaderCell("Type");
        bookTable.addHeaderCell("Genre");
        bookTable.addHeaderCell("Retailer");
        bookTable.addHeaderCell("Paid Price");
        bookTable.addHeaderCell("Face Value");

        for (FinalCollectionTable finalCollectionTable : finalCollectionTables){
            bookTable.addCell(finalCollectionTable.getBookName());
            bookTable.addCell(finalCollectionTable.getAuthorName());
            bookTable.addCell(finalCollectionTable.getBookTypeName());
            bookTable.addCell(finalCollectionTable.getGenreName());
            bookTable.addCell(finalCollectionTable.getRetailerName());
            String priceString = finalCollectionTable.getBookPrice().toString();
            bookTable.addCell(priceString);
            String faceString = finalCollectionTable.getFaceValue().toString();
            bookTable.addCell(faceString);
        }

        Text albumCollectionHeader = new Text("Albums");
        albumCollectionHeader.setFontSize(15);
        albumCollectionHeader.setBold();

        Paragraph paragraph2 = new Paragraph();
        paragraph2.add(albumCollectionHeader);
        paragraph2.add(space);

        Table albumTable = new Table(6);
        albumTable.setWidth(UnitValue.createPercentValue(100));
        albumTable.addHeaderCell("Name");
        albumTable.addHeaderCell("Artist");
        albumTable.addHeaderCell("Genre");
        albumTable.addHeaderCell("Retailer");
        albumTable.addHeaderCell("Paid Price");
        albumTable.addHeaderCell("Face Value");

        for(FinalAlbumCollectionTable finalAlbumCollectionTable : finalAlbumCollectionTables){
            albumTable.addCell(finalAlbumCollectionTable.getAlbumName());
            albumTable.addCell(finalAlbumCollectionTable.getArtistName());
            albumTable.addCell(finalAlbumCollectionTable.getAlbumGenreName());
            albumTable.addCell(finalAlbumCollectionTable.getRetailerName());
            String priceString = finalAlbumCollectionTable.getAlbumPrice().toString();
            albumTable.addCell(priceString);
            String faceString = finalAlbumCollectionTable.getFaceValue().toString();
            albumTable.addCell(faceString);
        }

        Text discCollectionHeader = new Text("Discs");
        discCollectionHeader.setFontSize(15);
        discCollectionHeader.setBold();

        Paragraph paragraph3 = new Paragraph();
        paragraph3.add(discCollectionHeader);
        paragraph3.add(space);

        Table discTable = new Table(6);
        discTable.setWidth(UnitValue.createPercentValue(100));
        discTable.addHeaderCell("Name");
        discTable.addHeaderCell("Type");
        discTable.addHeaderCell("Genre");
        discTable.addHeaderCell("Retailer");
        discTable.addHeaderCell("Paid Price");
        discTable.addHeaderCell("Face Value");

        for(FinalDiscCollectionTable finalDiscCollectionTable : finalDiscCollectionTables){
            discTable.addCell(finalDiscCollectionTable.getDiscName());
            discTable.addCell(finalDiscCollectionTable.getDiscTypeName());
            discTable.addCell(finalDiscCollectionTable.getDiscGenreName());
            discTable.addCell(finalDiscCollectionTable.getRetailerName());
            String priceString = finalDiscCollectionTable.getDiscPrice().toString();
            discTable.addCell(priceString);
            String faceString = finalDiscCollectionTable.getFaceValue().toString();
            discTable.addCell(faceString);

        }

        Text gameCollectionHeader = new Text("Games");
        gameCollectionHeader.setFontSize(15);
        gameCollectionHeader.setBold();

        Paragraph paragraph4 = new Paragraph();
        paragraph4.add(gameCollectionHeader);
        paragraph4.add(space);

        Table gameTable = new Table(7);
        gameTable.setWidth(UnitValue.createPercentValue(100));
        gameTable.addHeaderCell("Name");
        gameTable.addHeaderCell("Console");
        gameTable.addHeaderCell("Type");
        gameTable.addHeaderCell("Genre");
        gameTable.addHeaderCell("Retailer");
        gameTable.addHeaderCell("Paid Price");
        gameTable.addHeaderCell("Face Value");

        for(FinalGameCollectionTable finalGameCollectionTable : finalGameCollectionTables){
            gameTable.addCell(finalGameCollectionTable.getGameName());
            gameTable.addCell(finalGameCollectionTable.getConsoleName());
            gameTable.addCell(finalGameCollectionTable.getGameTypeName());
            gameTable.addCell(finalGameCollectionTable.getGameGenreName());
            gameTable.addCell(finalGameCollectionTable.getRetailerName());
            String priceString = finalGameCollectionTable.getGamePrice().toString();
            gameTable.addCell(priceString);
            String faceString = finalGameCollectionTable.getFaceValue().toString();
            gameTable.addCell(faceString);

        }

        document.setFontSize(8);
        document.add(paragraph);
        document.add(paragraph1);
        document.add(bookTable);
        document.add(paragraph2);
        document.add(albumTable);
        document.add(paragraph3);
        document.add(discTable);
        document.add(paragraph4);
        document.add(gameTable);
        document.close();

        return output.toByteArray();
    }
}
