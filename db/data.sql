INSERT INTO Genre (GenreId, GenreName)
VALUES (1, 'Horror'),
        (2, 'Adventure'),
        (3, 'Fiction'),
        (4, 'Non-Fiction'),
        (5, 'Romance'),
        (6, 'K-Pop'),
        (7, 'K-HipHop'),
        (8, 'Rock'),
        (9, 'J-Rock'),
        (10, 'Misc')
       ;

INSERT INTO BookType (BookTypeId, BookTypeName)
VALUES (1, 'Physical Book'),
        (2, 'AudioBook'),
        (3, 'eBook')
       ;

INSERT INTO DiscType (DiscTypeId, DiscTypeName)
VALUES (1, 'DVD'),
        (2, 'CD'),
        (3, 'Blu-ray')
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


INSERT INTO Bookshelf (BookshelfId, BookshelfName)
VALUES(1, ‘Currently Own’),
	  (2, ‘Wishlist’)
      ;

INSERT INTO Book (BookId, BookName, BookPrice, BookTypeId, GenreId, RetailerId, AuthorName, BookshelfId)
VALUES (1, '314', '0.00', 3, 1, 1,  'Dan DeWitt', 1),
        (2, 'Scythe',  '13.44', 1, 3, 3, 'Neal Shusterman', 1)
       ;

INSERT INTO Disc (DiscId, DiscName, DiscPrice, DiscTypeId, GenreId, RetailerId, BookshelfId)
VALUES (1, 'HER by Block B', '15.00', 2, 6, 5, 1),
        (2, 'SAW', '7.50', 1, 1, 2, 1)
       ;

INSERT INTO Game (GameId, GamePrice, GameName, GameTypeId, GenreId, RetailerId, BookshelfId)
VALUES(1, '115.00', 'Red Dead Redemption 2', 1, 2, 4, 1),
       (2, '12.00', 'Legend of Zelda Wind Waker Puzzle', 5, 10, 4, 1)
      ;

