angular.module('app.books').factory('bookUpdateRestService', function ($http, currentContextPath) {
    'use strict';

    return {
        updateBook: function (bookId, bookTitle) {
            return $http.get(currentContextPath.get() + 'rest/books/book-update-title', {params: {bookId: bookId}, {bookTitle: bookTitle}});
        }
    };
});
