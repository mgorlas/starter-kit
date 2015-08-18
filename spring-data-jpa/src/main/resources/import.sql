insert into library(id, name) values (1, 'Biblioteka wrocławska');
insert into library(id, name) values (2, 'Biblioteka poznańska');
insert into library(id, name) values (3, 'Biblioteka Warszawska');

insert into book (id, title, library_id) values (1, 'Pierwsza książka', 1);
insert into book (id, title, library_id) values (2, 'Druga książka', 2);
insert into book (id, title, library_id) values (3, 'Trzecia książka', 3);
insert into book (id, title, library_id) values (4, 'Czwarta książka', 3);
insert into book (id, title, library_id) values (5, 'Piąta książka', 3);
insert into book (id, title, library_id) values (6, 'Szósta książka', 3);
insert into book (id, title, library_id) values (7, 'Siódma książka', 3);

insert into author (id, first_name, last_name) values (7, 'Jan', 'Kowalski');
insert into author (id, first_name, last_name) values (8, 'Zbigniew', 'Nowak');
insert into author (id, first_name, last_name) values (9, 'Janusz', 'Jankowski');
insert into author (id, first_name, last_name) values (10, 'Tomasz', 'Janik');
insert into author (id, first_name, last_name) values (11, 'Tadeusz', 'Tabim');
insert into author (id, first_name, last_name) values (12, 'Dariusz', 'Jakimon');
insert into author (id, first_name, last_name) values (13, 'Janusz', 'Polek');

insert into book_author(book_id, author_id) values (1, 7);
insert into book_author(book_id, author_id) values (2, 8);
insert into book_author(book_id, author_id) values (3, 9);
insert into book_author(book_id, author_id) values (4, 10);
insert into book_author(book_id, author_id) values (5, 11);
insert into book_author(book_id, author_id) values (6, 12);
insert into book_author(book_id, author_id) values (7, 13);


