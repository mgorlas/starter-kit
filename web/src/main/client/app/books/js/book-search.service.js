angular.module('app.books').factory('bookService', function (bookRestService) {
    'use strict';

    return {
        search: function (titlePrefix) {
            return bookRestService.search(titlePrefix);
        },
        searchAll: function () {
        	return bookRestService.searchAll();
        },
        saveBook: function (book) {
        	return bookRestService.saveBook(book);
        },
        deleteBook: function (bookId) {
            return bookRestService.deleteBook(bookId);
        },
        updateTitleBook: function (book) {
            return bookRestService.updateTitleBook(book);
        }  
    };
});
