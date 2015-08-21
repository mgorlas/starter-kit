angular.module('app.books').controller('BookUpdateController', function ($scope, $location, bookService, book, Flash) {
    'use strict';

    $scope.book = book;
    
    $scope.updateTitleBook = function () {
        bookService.updateTitleBook($scope.book.id, $scope.book,title).then(function () {
            Flash.create('success', 'The book was updated.', 'custom-class');
        });
    };
});
