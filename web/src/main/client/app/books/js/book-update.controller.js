angular.module('app.books').controller('BookUpdateController', function ($scope, $location, bookService, book, $modalInstance) {
    'use strict';
        
    $scope.book = book;
    $scope.newTitle = '';
    
    $scope.updateBook = function (booleanTitle) {
    	if(booleanTitle){
    	$scope.book.title = $scope.newTitle;
    	bookService.updateTitleBook(book);
    	$modalInstance.close();
    	}
    };
    
});
