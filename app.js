const HOST = "http://localhost:8080";

const createBook = () => {
  // getting the value from the form
  const bookTitle = document.querySelector("#bookTitleInput").value;
  const bookCodeISBN = document.querySelector("#bookCodeISBNInput").value;
  const bookGenre = document.querySelector("#bookGenreInput").value;
  const bookPrice = document.querySelector("#bookPriceInput").value;

  $.ajax({
    method: "post",
    url: `${HOST}/book`,
    data: JSON.stringify({
      title: bookTitle,
      codeISBN: bookCodeISBN,
      genre: bookGenre,
      price: bookPrice,
    }),
    headers: {
      Accept: "application/json",
      "Content-type": "application/json",
    },
  })
    .done((response) => alert(response))
    .fail((obj, textStatus) => {
      if ((obj && obj.responseJSON, obj.responseJSON.message)) {
        alert(obj.responseJSON.message);
      }
    });
};

const updateBook = () => {
  // getting the value from the form
  const bookId = document.querySelector("#bookIdInput").value;
  const bookTitle = document.querySelector("#bookTitleInput").value;
  const bookCodeISBN = document.querySelector("#bookCodeISBNInput").value;
  const bookGenre = document.querySelector("#bookGenreInput").value;
  const bookPrice = document.querySelector("#bookPriceInput").value;

  $.ajax({
    type: "PUT",
    url: `${HOST}/book/${bookId}`,
    contentType: "application/json",
    data: JSON.stringify({
      title: bookTitle,
      codeISBN: bookCodeISBN,
      genre: bookGenre,
      price: bookPrice,
    }),
    headers: {
      Accept: "application/json",
      "Content-type": "application/json",
    },
  })
    .done((response) => {
      for (const obj of response) {
        document.querySelector("#loadUpdate").innerHTML +=
          "<label>" +
          obj.bookId +
          "." +
          obj.title +
          "&nbsp" +
          "【" +
          obj.genre +
          "】" +
          "</label>" +
          "<br/>";
      }
    })
    .fail((obj, textStatus) => {
      if ((obj && obj.responseJSON, obj.responseJSON.message)) {
        alert(obj.responseJSON.message);
      }
    });
};

const deleteBook = () => {
  // getting the value from the form
  const bookId = document.querySelector("#bookIdInput").value;

  $.ajax({
    method: "delete",
    url: `${HOST}/book/${bookId}`,
    headers: {
      Accept: "application/json",
    },
  })
    .done((response) => alert(response))
    .fail((obj, textStatus) => {
      if ((obj && obj.responseJSON, obj.responseJSON.message)) {
        alert(obj.responseJSON.message);
      }
    });
};

const loadBook = () => {
  // getting the value from the form

  $.ajax({
    method: "get",
    url: `${HOST}/book`,
  })
    .done((response) => {
      document.querySelector("#loadData").innerHTML = "";
      for (const obj of response) {
        // console.log(obj.bookTitle);
        document.querySelector("#loadData").innerHTML +=
          "<label>" +
          obj.bookId +
          "." +
          obj.title +
          "&nbsp" +
          "【" +
          obj.genre +
          "】" +
          "</label>" +
          "<br/>";
      }
    })
    .fail((obj, textStatus) => {
      if ((obj && obj.responseJSON, obj.responseJSON.message)) {
        alert(obj.responseJSON.message);
      }
    });
};

const loadId = () => {
  // getting the value from the form
  const bookId = document.querySelector("#bookIdInput").value;
  $.ajax({
    method: "get",
    url: `${HOST}/book/${bookId}`,
  })
    .done((response) => {
      document.querySelector("#loadDataId").innerHTML = "";
      const obj = response;
      document.querySelector("#loadDataId").innerHTML +=
        "<label>" +
        obj.bookId +
        "." +
        obj.title +
        "&nbsp" +
        "【" +
        obj.genre +
        "】" +
        "</label>" +
        "<br/>";
    })
    .fail((obj, textStatus) => {
      if ((obj && obj.responseJSON, obj.responseJSON.message)) {
        alert(obj.responseJSON.message);
      }
    });
};

const loadTitle = () => {
  // getting the value from the form
  const bookTitle = document.querySelector("#bookTitleInput").value;
  $.ajax({
    method: "get",
    url: `${HOST}/book/name/${bookTitle}`,
  })
    .done((response) => {
      document.querySelector("#loadDataTitle").innerHTML = "";
      const obj = response;
      document.querySelector("#loadDataTitle").innerHTML +=
        "<label>" +
        obj.bookId +
        "." +
        obj.title +
        "&nbsp" +
        "【" +
        obj.genre +
        "】" +
        "</label>" +
        "<br/>";
    })
    .fail((obj, textStatus) => {
      if ((obj && obj.responseJSON, obj.responseJSON.message)) {
        alert(obj.responseJSON.message);
      }
    });
};

const loadIsbn = () => {
  // getting the value from the form
  const bookCodeISBN = document.querySelector("#bookCodeISBNInput").value;
  $.ajax({
    method: "get",
    url: `${HOST}/book/code/${bookCodeISBN}`,
  })
    .done((response) => {
      document.querySelector("#loadDataIsbn").innerHTML = "";
      const obj = response;
      document.querySelector("#loadDataIsbn").innerHTML +=
        "<label>" +
        obj.bookId +
        "." +
        obj.title +
        "&nbsp" +
        "【" +
        obj.genre +
        "】" +
        "</label>" +
        "<br/>";
    })
    .fail((obj, textStatus) => {
      if ((obj && obj.responseJSON, obj.responseJSON.message)) {
        alert(obj.responseJSON.message);
      }
    });
};

const loadGenre = () => {
  // getting the value from the form
  const bookGenre = document.querySelector("#bookGenreInput").value;
  $.ajax({
    method: "get",
    url: `${HOST}/book/genre/${bookGenre}`,
  })
    .done((response) => {
      document.querySelector("#loadDataGenre").innerHTML = "";
      if (Array.isArray(response)) {
        response.forEach((book) => {
          document.querySelector("#loadDataGenre").innerHTML +=
            "<label>" +
            book.bookId +
            "." +
            book.title +
            "&nbsp" +
            "【" +
            book.genre +
            "】" +
            "</label>" +
            "<br/>";
        });
      } else {
        document.querySelector("#loadDataPrice").innerHTML +=
          "<label>" +
          response.bookId +
          "." +
          response.title +
          "&nbsp" +
          "【" +
          response.genre +
          "】" +
          "</label>" +
          "<br/>";
      }
    })
    .fail((obj, textStatus) => {
      if ((obj && obj.responseJSON, obj.responseJSON.message)) {
        alert(obj.responseJSON.message);
      }
    });
};

const loadPrice = () => {
  // getting the value from the form
  const bookPrice = document.querySelector("#bookPriceInput").value;
  $.ajax({
    method: "get",
    url: `${HOST}/book/price/${bookPrice}`,
  })
    .done((response) => {
      document.querySelector("#loadDataPrice").innerHTML = "";
      if (Array.isArray(response)) {
        response.forEach((book) => {
          document.querySelector("#loadDataPrice").innerHTML +=
            "<label>" +
            book.bookId +
            "." +
            book.title +
            "&nbsp" +
            "【" +
            book.genre +
            "】" +
            "</label>" +
            "<br/>";
        });
      } else {
        document.querySelector("#loadDataPrice").innerHTML +=
          "<label>" +
          response.bookId +
          "." +
          response.title +
          "&nbsp" +
          "【" +
          response.genre +
          "】" +
          "</label>" +
          "<br/>";
      }
    })
    .fail((obj, textStatus) => {
      if ((obj && obj.responseJSON, obj.responseJSON.message)) {
        alert(obj.responseJSON.message);
      }
    });
};

const btnSubmit = document.querySelector("#submitbtn");
btnSubmit.addEventListener("click", createBook);

const btnUpdate = document.querySelector("#updatebtn");
btnUpdate.addEventListener("click", updateBook);

const btnDelete = document.querySelector("#deletebtn");
btnDelete.addEventListener("click", deleteBook);

const btnSearch = document.querySelector("#searchbtn");
btnSearch.addEventListener("click", loadBook);

const btnSearchId = document.querySelector("#searchidbtn");
btnSearchId.addEventListener("click", loadId);

const btnSearchTitle = document.querySelector("#searchtitlebtn");
btnSearchTitle.addEventListener("click", loadTitle);

const btnSearchIsbn = document.querySelector("#searchisbnbtn");
btnSearchIsbn.addEventListener("click", loadIsbn);

const btnSearchGenre = document.querySelector("#searchgenrebtn");
btnSearchGenre.addEventListener("click", loadGenre);

const btnSearchPrice = document.querySelector("#searchpricebtn");
btnSearchPrice.addEventListener("click", loadPrice);
