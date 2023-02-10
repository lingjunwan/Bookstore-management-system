USE test_webservicefsd006;
drop table if exists book;
create table book
(
	bookId int auto_increment primary key,
	title varchar(45) not null,
	codeISBN varchar(45) not null,
	genre varchar(45) not null,
    price double not null
);
INSERT INTO book(bookId, title, codeISBN, genre, price)
VALUES
(1,'Peppa Pig', '978-3-16-148410-1', 'Children', 15.99),
(2,'Gone With The Wind', '978-3-16-148410-2', 'Novel', 20.99),
(3,'Wish', '978-3-16-148410-3', 'Fiction', 20.99);