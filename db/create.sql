
CREATE TABLE AlbumGenre (
                AlbumGenreId INT AUTO_INCREMENT NOT NULL,
                GenreName VARCHAR(30) NOT NULL,
                PRIMARY KEY (AlbumGenreId)
);


CREATE TABLE GameGenre (
                GameGenreId INT AUTO_INCREMENT NOT NULL,
                GenreName VARCHAR(30) NOT NULL,
                PRIMARY KEY (GameGenreId)
);


CREATE TABLE DiscGenre (
                DiscGenreId INT AUTO_INCREMENT NOT NULL,
                GenreName VARCHAR(30) NOT NULL,
                PRIMARY KEY (DiscGenreId)
);


CREATE TABLE BookGenre (
                BookGenreId INT AUTO_INCREMENT NOT NULL,
                GenreName VARCHAR(30) NOT NULL,
                PRIMARY KEY (BookGenreId)
);


CREATE TABLE Console (
                ConsoleId INT AUTO_INCREMENT NOT NULL,
                ConsoleName VARCHAR(30) NOT NULL,
                PRIMARY KEY (ConsoleId)
);


CREATE TABLE Retailer (
                RetailerId INT AUTO_INCREMENT NOT NULL,
                RetailerName VARCHAR(50) NOT NULL,
                PRIMARY KEY (RetailerId)
);


CREATE TABLE BookType (
                BookTypeId INT AUTO_INCREMENT NOT NULL,
                BookTypeName VARCHAR(50) NOT NULL,
                PRIMARY KEY (BookTypeId)
);


CREATE TABLE DiscType (
                DiscTypeId INT AUTO_INCREMENT NOT NULL,
                DiscTypeName VARCHAR(50) NOT NULL,
                PRIMARY KEY (DiscTypeId)
);


CREATE TABLE GameType (
                GameTypeId INT AUTO_INCREMENT NOT NULL,
                GameTypeName VARCHAR(50) NOT NULL,
                PRIMARY KEY (GameTypeId)
);


CREATE TABLE Bookshelf (
                BookshelfId INT AUTO_INCREMENT NOT NULL,
                BookshelfName VARCHAR(50) NOT NULL,
                PRIMARY KEY (BookshelfId)
);


CREATE TABLE Album (
                AlbumId INT AUTO_INCREMENT NOT NULL,
                ArtistName VARCHAR(50) NOT NULL,
                AlbumPrice DECIMAL(8,2) NOT NULL,
                AlbumName VARCHAR(50) NOT NULL,
                AlbumGenreId INT NOT NULL,
                BookshelfId INT NOT NULL,
                RetailerId INT NOT NULL,
                PRIMARY KEY (AlbumId)
);


CREATE TABLE Disc (
                DiscId INT AUTO_INCREMENT NOT NULL,
                DiscName VARCHAR(50) NOT NULL,
                DiscPrice DECIMAL(8,2) NOT NULL,
                DiscTypeId INT NOT NULL,
                RetailerId INT NOT NULL,
                BookshelfId INT NOT NULL,
                ArtistName VARCHAR(50),
                DiscGenreId INT NOT NULL,
                PRIMARY KEY (DiscId)
);


CREATE TABLE Game (
                GameId INT AUTO_INCREMENT NOT NULL,
                GamePrice DECIMAL(8,2) NOT NULL,
                GameName VARCHAR(50) NOT NULL,
                GameTypeId INT NOT NULL,
                RetailerId INT NOT NULL,
                BookshelfId INT NOT NULL,
                ConsoleId INT NOT NULL,
                GameGenreId INT NOT NULL,
                PRIMARY KEY (GameId)
);


CREATE TABLE Book (
                BookId INT AUTO_INCREMENT NOT NULL,
                BookName VARCHAR(50) NOT NULL,
                BookPrice DECIMAL(8,2) NOT NULL,
                BookTypeId INT NOT NULL,
                RetailerId INT NOT NULL,
                AuthorName VARCHAR(50) NOT NULL,
                BookshelfId INT NOT NULL,
                BookGenreId INT NOT NULL,
                PRIMARY KEY (BookId)
);


ALTER TABLE Album ADD CONSTRAINT albumgenre_album_fk
FOREIGN KEY (AlbumGenreId)
REFERENCES AlbumGenre (AlbumGenreId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Game ADD CONSTRAINT gamegenre_game_fk
FOREIGN KEY (GameGenreId)
REFERENCES GameGenre (GameGenreId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Disc ADD CONSTRAINT discgenre_disc_fk
FOREIGN KEY (DiscGenreId)
REFERENCES DiscGenre (DiscGenreId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Book ADD CONSTRAINT bookgenre_book_fk
FOREIGN KEY (BookGenreId)
REFERENCES BookGenre (BookGenreId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Game ADD CONSTRAINT console_game_fk
FOREIGN KEY (ConsoleId)
REFERENCES Console (ConsoleId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Game ADD CONSTRAINT retailer_game_fk
FOREIGN KEY (RetailerId)
REFERENCES Retailer (RetailerId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Disc ADD CONSTRAINT retailer_disc_fk
FOREIGN KEY (RetailerId)
REFERENCES Retailer (RetailerId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Book ADD CONSTRAINT retailer_book_fk
FOREIGN KEY (RetailerId)
REFERENCES Retailer (RetailerId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Album ADD CONSTRAINT retailer_album_fk
FOREIGN KEY (RetailerId)
REFERENCES Retailer (RetailerId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Book ADD CONSTRAINT booktype_book_fk
FOREIGN KEY (BookTypeId)
REFERENCES BookType (BookTypeId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Disc ADD CONSTRAINT disctype_disc_fk
FOREIGN KEY (DiscTypeId)
REFERENCES DiscType (DiscTypeId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Game ADD CONSTRAINT gametype_game_fk
FOREIGN KEY (GameTypeId)
REFERENCES GameType (GameTypeId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Book ADD CONSTRAINT bookshelf_book_fk
FOREIGN KEY (BookshelfId)
REFERENCES Bookshelf (BookshelfId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Game ADD CONSTRAINT bookshelf_game_fk
FOREIGN KEY (BookshelfId)
REFERENCES Bookshelf (BookshelfId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Disc ADD CONSTRAINT bookshelf_disc_fk
FOREIGN KEY (BookshelfId)
REFERENCES Bookshelf (BookshelfId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Album ADD CONSTRAINT bookshelf_album_fk
FOREIGN KEY (BookshelfId)
REFERENCES Bookshelf (BookshelfId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;