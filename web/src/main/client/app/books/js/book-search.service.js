angular.module('app.books').factory('bookService', function (bookRestService) {
    'use strict';

    return {
        search: function (titlePrefix) {
            return bookRestService.search(titlePrefix);
        },
        deleteBook: function (bookId) {
            return bookRestService.deleteBook(bookId);
        }
        updateTitleBook: function (bookId, bookTitle) {
        	return bookRestService.updateTitleBook(bookId, bookTitle);
        }
    };
});
