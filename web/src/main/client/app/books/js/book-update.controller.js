angular.module('app.books').controller('BookUpdateController', function ($scope, $location, bookService, book) {
    'use strict';
        
    $scope.book = book;
    $scope.gridOptions = { data: 'books' };
    $scope.newTitle = '';
    
    $scope.updateBook = function () {
    	$scope.book.title = $scope.newTitle;
    	bookService.updateTitleBook(book);
    };
    
});
