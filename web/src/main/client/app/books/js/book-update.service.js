angular.module('app.books').factory('bookUpdateService', function (bookUpdateRestService) {
    'use strict';

    return {
        updateBook: function (bookId, bookTitle) {
            return bookRestService.updateBook(bookId, bookTitle);
        }
    };
});
