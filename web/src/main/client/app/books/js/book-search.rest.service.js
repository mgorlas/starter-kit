angular.module('app.books').factory('bookRestService', function ($http, currentContextPath) {
    'use strict';

    return {
        search: function (titlePrefix) {
            return $http.get(currentContextPath.get() + 'rest/books/books-by-title', {params: {titlePrefix: titlePrefix}});
        },
        updateTitleBook: function (bookId ,bookTitle) {
        	return $http.get(currentContextPath.get() + 'rest/books/book-update-title', {params: {bookId: bookId}, {bookTitle: bookTitle}});
        },
        deleteBook: function (bookId) {
            return $http.delete(currentContextPath.get() + 'rest/books/book/' + bookId);
        }
    };
});
