angular.module('app.books').controller('BookSearchController', function ($scope, $window, $location, bookService, Flash, $modal) {
    'use strict';

    $scope.books = [];
    $scope.gridOptions = { data: 'books' };
    $scope.prefix = '';
    $scope.authors = '';
    
    $scope.searchAll = function () {
    	bookService.searchAll().then(function (response) {
    		angular.copy(response.data, $scope.books);
    	}, function () {
    		Flash.create('danger', 'Wyjątek', 'custom-class');
    	   }
    	);
    };

    var removeBookById = function (bookId) {
        for (var i = 0; i < $scope.books.length; i = i + 1) {
            if ($scope.books[i].id === bookId) {
                $scope.books.splice(i, 1);
                break;
            }
        }
    };

    $scope.deleteBook = function (bookId) {
        bookService.deleteBook(bookId).then(function () {
            removeBookById(bookId);
            Flash.create('success', '<span class="glyphicon glyphicon-ok flashOk" aria-hidden="true"></span><strong>Well done!</strong> The book has been removed.', 'custom-class');
        });
    };

    $scope.search = function () {
        bookService.search($scope.prefix).then(function (response) {
            angular.copy(response.data, $scope.books);
        }, function () {
            Flash.create('danger', 'Wyjątek', 'custom-class');
        });
    };
    
    
    
    $scope.addBook = function () {
      var modalAdd = $modal.open({
            templateUrl: 'books/html/book-modal-save.html',
            controller: 'BookAddController',
            size: 'lg'
        });
      
      modalAdd.result.then(function () {
    	  $scope.searchAll();
    	  Flash.create('success', '<span class="glyphicon glyphicon-ok flashOk" aria-hidden="true"></span><strong>Well done!</strong> New book has been added.', 'custom-class');
    	});
    };
    
    $scope.updateBook = function (book) {
    	var modalInstance = $modal.open({
    		templateUrl: 'books/html/book-modal-update.html',
    		controller: 'BookUpdateController',
    		size: 'lg',
    		resolve: {
    			book: function () {
    				return book;
    			}
    		}
    	});
    	modalInstance.result.then(function () {
    		$scope.searchAll();
      	  Flash.create('success', '<span class="glyphicon glyphicon-ok flashOk" aria-hidden="true"></span><strong>Well done!</strong> The book has been updated.', 'custom-class');
      	});
    };
});
