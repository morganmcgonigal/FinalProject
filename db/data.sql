INSERT INTO BookGenre (BookGenreId, GenreName)
VALUES (1, 'Fantasy'),
       (2, 'Westerns'),
       (3, 'Romance'),
       (4, 'Thriller'),
       (5, 'Mystery'),
       (6, 'Dtective Story'),
       (7, 'Dystopia'),
       (8, 'Memoir'),
       (9, 'Biography'),
       (10, 'Play'),
       (11, 'Musical'),
       (12, 'Satire'),
       (13, 'Haiku'),
       (14, 'Horror'),
       (15, 'DIY')
       ;

INSERT INTO DiscGenre (DiscGenreId, GenreName)
VALUES (1, 'Action'),
       (2, 'Adventure'),
       (3, 'Comedy'),
       (4, 'Crime & Gangster'),
       (5, 'Drama'),
       (6, 'Epics/Historical'),
       (7, 'Horror'),
       (8, 'Musicals/Dance'),
       (9, 'Science Fiction'),
       (10, 'War'),
       (11, 'Westerns')
       ;

INSERT INTO AlbumGenre (AlbumGenreId, GenreName)
VALUES (1, 'Alternative Rock'),
       (2, 'Electronic Rock'),
       (3, 'Folk Rock'),
       (4, 'Glam Rock'),
       (5, 'Hard Rock'),
       (6, 'Heavy Metal'),
       (7, 'Gothic Metal'),
       (8, 'Kawaii Metal'),
       (9, 'Metalcore'),
       (10, 'Rap Metal'),
       (11, 'Symphonic Metal'),
       (12, 'Pop Rock'),
       (13, 'Punk Rock'),
       (14, 'Rap Rock'),
       (15, 'Rock & Roll'),
       (16, 'Visual Kei'),
       (17, 'J-Pop'),
       (18, 'K-Pop'),
       (19, 'K-Hip Hop'),
       (20, 'K-Rock'),
       (21, 'Trot'),
       (22, 'C-Pop')
       ;

INSERT INTO GameGenre (GameGenreId, GenreName)
VALUES (1, 'Action'),
       (2, 'Action-Adventure'),
       (3, 'Adventure'),
       (4, 'Role-Playing'),
       (5, 'Simulation'),
       (6, 'Strategy'),
       (7, 'Sports'),
       (8, 'MMO'),
       (9, 'Board Game'),
       (10, 'Card Game'),
       (11, 'Party Game'),
       (12, 'Puzzle')
       ;

INSERT INTO BookType (BookTypeId, BookTypeName)
VALUES (1, 'Physical Book'),
        (2, 'AudioBook'),
        (3, 'eBook')
       ;

INSERT INTO DiscType (DiscTypeId, DiscTypeName)
VALUES (1, 'DVD'),
        (2, 'Blu-ray')
       ;

INSERT INTO GameType (GameTypeId, GameTypeName)
VALUES (1, 'Physical Video Game'),
        (2, 'Digital Video Game'),
        (3, 'Board Game'),
        (4, 'Card Game'),
        (5, 'Puzzles')
       ;

INSERT INTO Retailer (RetailerId, RetailerName)
VALUES (1, 'Amazon'),
        (2, 'Wal-Mart'),
        (3, 'Barnes & Noble'),
        (4, 'Gamestop'),
        (5, 'eBay'),
        (10, 'Gift')
       ;

INSERT INTO Console(ConsoleId, ConsoleName)
VALUES (1, 'NES'),
       (2, 'PC'),
       (3, 'Game Boy'),
       (4, 'Sega'),
       (5, 'PlayStation'),
       (6, 'N64'),
       (7, 'PlayStation 2'),
       (8, 'GameCube'),
       (9, 'Xbox'),
       (10, 'Game Boy Advance'),
       (11, 'Xbox 360'),
       (12, 'PlayStation 3'),
       (13, 'Wii'),
       (14, 'Nintendo DS'),
       (15, 'PlayStation Portable'),
       (16, 'Wii U'),
       (17, 'PlayStation 4'),
       (18, 'Xbox One'),
       (19, 'Nintendo Switch'),
       (20, 'Ninendo 3DS'),
       (21, 'PlayStation Vita'),
       (22, 'None')
       ;


INSERT INTO Bookshelf (BookshelfId, BookshelfName)
VALUES(1, 'Currently Own'),
	  (2, 'Wishlist')
      ;

INSERT INTO Book (BookId, BookName, BookPrice, BookTypeId, BookGenreId, RetailerId, AuthorName, BookshelfId)
VALUES (1, '314', '0.00', 3, 1, 1,  'Dan DeWitt', 1),
        (2, 'Scythe',  '13.44', 1, 3, 3, 'Neal Shusterman', 1)
       ;

INSERT INTO Disc (DiscId, DiscName, DiscPrice, DiscTypeId, DiscGenreId, RetailerId, BookshelfId)
VALUES (1, 'SAW', '7.50', 1, 1, 2, 1)
       ;

INSERT INTO Game (GameId, GamePrice, GameName, GameTypeId, RetailerId, BookshelfId, ConsoleId, GameGenreId)
VALUES(1, '115.00', 'Red Dead Redemption 2', 1, 4, 1, 17, 2),
       (2, '12.00', 'Legend of Zelda Wind Waker Puzzle', 5, 4, 1, 22, 12)
      ;

INSERT INTO Album (AlbumId, ArtistName, AlbumPrice, AlbumName, AlbumGenreId, BookshelfId, RetailerId)
VALUES (1, 'Block B', '15.00', 'HER', 18, 1, 5)
        ;