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

--      START BOOKS

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('314', '0.00', 3, 1, 'A.R. Wise', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('The Accidental Exorcist', '0.00', 3, 1, 'Joshua Graham', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('After - Part One', '0.00', 3, 1, 'D.R Johnson', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Afterburn', '0.00', 3, 1, 'Scott Nicholson', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Aftermath (Invasion of the Dead)', '0.00', 3, 1, 'Owen Baillie', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('All Hallows''s Eve', '0.00', 3, 1, 'Hal L. O''ween', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('American Ghost Stories', '0.00', 3, 1, 'Shana Dines', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Amethyst', '0.00', 3, 1, 'Heather Bowhay', 1, 1);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Anything Can Be Dangerous', '0.00', 3, 1, 'Matt Hults', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Awaken His Eyes', '0.00', 3, 1, 'Jason Tesar', 1, 1);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Bad Games', '0.00', 3, 1, 'Jeff Menapace', 1, 4);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('The Basement', '0.00', 3, 1, 'Chad P. Brown', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Before You Sleep: Three Horrors', '0.00', 3, 1, 'Adam Nevill', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Behold The Child', '0.00', 3, 1, 'Harry Shannon', 1, 4);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Black Bayou', '0.00', 3, 1, 'Sara Clancy', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Black Virus', '0.00', 3, 1, 'Bobby Adair', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Box of Darkness', '0.00', 3, 1, 'William Todd Rose', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Breakers', '0.00', 3, 1, 'Edward W. Robertson', 1, 16);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Calamity', '0.00', 3, 1, 'Chris DiLeo', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Circus of the Dead', '0.00', 3, 1, 'Seth Blackburn', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Cities of the Dead', '0.00', 3, 1, 'William Young', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Colony Z: The Island', '0.00', 3, 1, 'Luke Shephard', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Contamination', '0.00', 3, 1, 'T.W. Piperbrook', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Crrepy', '0.00', 3, 1, 'Jeff Bennington', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Dark Corners', '0.00', 3, 1, 'William Andrews', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Darlings of Decay', '0.00', 3, 1, 'Shannon Mayer', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Deadlocked 1', '0.00', 3, 1, 'A.R. Wise', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Deadlocked 2', '0.00', 3, 1, 'A.R. Wise', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('The Death Series', '0.00', 3, 1, 'Tamara Rose Blodgett', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Derelict', '0.00', 3, 1, 'Albert Berg', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('The Destroyer', '0.00', 3, 1, 'Michael-Scott Earle', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('The Doll', '0.00', 3, 1, 'J.C. Martin', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Ebola K', '0.00', 3, 1, 'Bobby Adair', 1, 4);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Everflame', '0.00', 3, 1, 'Dylan Lee Peters', 1, 1);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('The Fallen Star', '0.00', 3, 1, 'Jessica Sorensen', 1, 1);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Floor Four', '0.00', 3, 1, 'Lopez Jr.', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Forty-Four', '0.00', 3, 1, 'Jools Sinclair', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Gehenna', '0.00', 3, 1, 'Jason Brant', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('The Ghost Files', '0.00', 3, 1, 'Apryl Baker', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Godforsaken', '0.00', 3, 1, 'Tarryl Janik', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('The Grimm Diaries', '0.00', 3, 1, 'Cameron Jace', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Hell''s Bells', '0.00', 3, 1, 'Vincent Bivona', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('House Guest', '0.00', 3, 1, 'John Paul Allen', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Identity', '0.00', 3, 1, 'Ted Dekker', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Infestation', '0.00', 3, 1, 'Tanya R. Taylor', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('A Job From Hell', '0.00', 3, 1, 'Jayde Scott', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Kellie''s Diary #1', '0.00', 3, 1, 'Thomas Jenner', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Kurtain Motel', '0.00', 3, 1, 'A.I. Nasser', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('The Lake: A Short Story', '0.00', 3, 1, 'Tananarive Due', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('The Last Survivors', '0.00', 3, 1, 'Bobby Adair', 1, 4);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('LZR-1143: Perspectives', '0.00', 3, 1, 'Bryan James', 1, 4);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('LZR-1143: Within', '0.00', 3, 1, 'Bryan James', 1, 4);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Madhouse', '0.00', 3, 1, 'Miguel Estrada', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Midnight Harvest', '0.00', 3, 1, 'Elias Anderson', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Moorehead Manor', '0.00', 3, 1, 'David McMullen-Sullivan', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('The Odyssey', '0.00', 3, 1, 'Homer', 1, 17);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Orpheus', '2.99', 3, 1, 'Dan DeWitt', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Orpheus Born', '1.99', 3, 1, 'Dan DeWitt', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Panic', '0.00', 3, 1, 'K.R. Griffiths', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('The Peeling', '0.00', 3, 1, 'Iain Rob Wright', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('A Perfect Canvas', '0.00', 3, 1, 'Kevin Adkisson', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Plague Zone', '0.00', 3, 1, 'David Wellington', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('The Pornographer''s Party & Other Stories', '0.00', 3, 1, 'Chike Deluna', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('The Pull', '0.00', 3, 1, 'Daniel Blackmore', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Rag Doll', '0.00', 3, 1, 'Troy McCombs', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('The Raven', '0.00', 3, 1, 'Edgar Allen Poe', 1, 17);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Rebekka Franck Series', '0.00', 3, 1, 'Willow Rose', 1, 5);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Reign of Blood', '0.00', 3, 1, 'Alexia Purdy', 1, 1);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Riser', '0.00', 3, 1, 'Becca C Smith', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Rushed', '0.00', 3, 1, 'Brian Harmon', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Safe Haven', '0.00', 3, 1, 'Steve Byrne', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Season of the Harvest', '0.00', 3, 1, 'Michael R. Hicks', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Slow Burn', '0.00', 3, 1, 'Bobby Adair', 1, 4);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('The Soulkeepers', '0.00', 3, 1, 'G.P. Ching', 1, 1);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Surviving the Fog', '0.00', 3, 1, 'Stan Morris', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('The Survivors (Life After War)', '0.00', 3, 1, 'Angela White', 1, 1);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Sven the Zombie Slayer', '0.00', 3, 1, 'Guy James', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('THEY', '0.00', 3, 1, 'Vincent Hobbes', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('To Read or Not to Read', '0.00', 3, 1, 'Vincent Hobbes', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Underneath:  Short Tales of Horror and the Supernatural', '0.00', 3, 1, 'Dan DeWitt', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('UnEnchanted', '0.00', 3, 1, 'Chanda Hahn', 1, 1);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('The Uninvited', '0.00', 3, 1, 'Mike Evans', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Valley of Death: Zombie Trailer Park', '0.00', 3, 1, 'William Bebb', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Watcher', '0.00', 3, 1, 'Shawnee Small', 1, 1);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('The Woods of Red Hill', '0.00', 3, 1, 'Shaun Whittington', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('The Zodiac Killer', '0.00', 3, 1, 'WL Knightly', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('The Zombie Chronicles', '0.00', 3, 1, 'Chrissy Peebles', 1, 14);

INSERT INTO book (bookname, bookprice, booktypeid, retailerid, authorname, bookshelfid, bookgenreid)
VALUES ('Zombie Day Care', '0.00', 3, 1, 'Craig Halloran', 1, 14);

--       END BOOKS

--       START DISCS

INSERT INTO Disc (DiscId, DiscName, DiscPrice, DiscTypeId, DiscGenreId, RetailerId, BookshelfId)
VALUES (1, 'SAW', '7.50', 1, 1, 2, 1)
       ;

--       END DISCS

--       START GAMES

INSERT INTO Game (GameId, GamePrice, GameName, GameTypeId, RetailerId, BookshelfId, ConsoleId, GameGenreId)
VALUES(1, '115.00', 'Red Dead Redemption 2', 1, 4, 1, 17, 2),
       (2, '12.00', 'Legend of Zelda Wind Waker Puzzle', 5, 4, 1, 22, 12)
      ;

--      END GAMES

--      START ALBUMS

INSERT INTO Album (AlbumId, ArtistName, AlbumPrice, AlbumName, AlbumGenreId, BookshelfId, RetailerId)
VALUES (1, 'Block B', '15.00', 'HER', 18, 1, 5)
        ;

--      END ALBUMS