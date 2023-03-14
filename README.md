# Bookstore management system  
### This project is a Bookstore Management System aimed at making the user experience of the bookstore website more efficient and user-friendly.  
The system enables the administrator to perform CRUD (Create, Read, Update, and Delete) operations on the webpage, such as displaying all books, adding new books, modifying books, and deleting books.  
The system is equipped with a search functionality that allows the user to search for books by entering different keywords such as bookId, title, ISBN, genre category, or price range. This makes the management of the bookstore more efficient.  

![bookstore](https://user-images.githubusercontent.com/118141976/224896345-ef3a907a-d2ec-42a5-9a1e-d37c575662bc.png)

## Features  
1. `CSS` and `Bootstrap` is used for the layout.
2. `Java Spring` is used for for backend coding.
3. The project uses `AJAX` method in `jQuery` to enable the exchange of data between the client and server without the need to refresh the webpage.  
4. `RESTful APIs` are utilized to allow clients to perform CRUD (Create, Retrieve, Update, and Delete) operations on the data stored in the `MySQL` database.  
5. The `Postman` tool is being used to make HTTP requests to APIs and see the responses for testing purposes in a user-friendly way.  


## The following are the different endpoints available in the system:  
![2](https://user-images.githubusercontent.com/118141976/224896955-20579464-db48-457e-b8ee-26a7f802d0e5.png)  
- Get All Books: This endpoint returns all books in the database and includes information such as bookId, title, ISBN, genre, and price. The endpoint is accessible via http://localhost:8080/book  

- Post: This endpoint allows for the entry of new books into the database. This increases the available choices of books for the user. The endpoint is accessible via http://localhost:8080/book  

- Put: This endpoint enables the updating of book information in the database. If any changes occur to a book, it can be updated through this endpoint by specifying the bookId. The endpoint is accessible via http://localhost:8080/book/{id}  

- Delete: This endpoint allows for the deletion of books in the database. If a book is no longer available, it can be deleted through this endpoint by specifying the bookId. The endpoint is accessible via http://localhost:8080/book/{id}  

- Get Book by Id: This endpoint returns a specific book object by specifying the bookId. The endpoint is accessible via http://localhost:8080/book/{id}  

- Get Book by Title: This endpoint searches for a book in the database based on its title and returns the book if it is found. If the book is not found, the endpoint returns an exception message. The endpoint is accessible via http://localhost:8080/book/name/{title}  

- Get Book by ISBN: This endpoint searches for a book in the database based on its ISBN and returns the book if it is found. The endpoint is accessible via http://localhost:8080/book/code/{codeISBN}  

- Get Book by Genre: This endpoint searches for books in the database based on a specified genre and returns a list of books if any books are found with that genre. The endpoint is accessible via http://localhost:8080/book/genre/{genre}  

- Get Books by Price: This endpoint searches for books in the database based on a specified price range and returns a list of books if any books are found within that price range. The endpoint is accessible via http://localhost:8080/book/price/{price}  


