insert into book (id, title) values (1, 'Pierwsza książka');
insert into book (id, title) values (2, 'Druga książka');
insert into book (id, title) values (3, 'Trzecia książka');

insert into author (id, first_name, last_name) values (1, 'Zbigniew', 'Nowak');
insert into author (id, first_name, last_name) values (2, 'Jan', ' Kowalski');
insert into author (id, first_name, last_name) values (3, 'Janusz', ' Jankowski');

insert into book_author (book_id, author_id) values (1, 1);
insert into book_author (book_id, author_id) values (2, 1);
insert into book_author (book_id, author_id) values (2, 2);
insert into book_author (book_id, author_id) values (3, 3);
