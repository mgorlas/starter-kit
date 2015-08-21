angular.module('app.books').controller('BookUpdateController', function ($scope,  $window, $location, book, bookUpdateService) {
    'use strict';

    $scope.book = book;

    $scope.updateBook = function () {
        bookService.updateBook( $scope.book.id,  $scope.book.title);
    };
    
});
