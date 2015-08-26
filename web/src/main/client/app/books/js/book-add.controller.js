angular.module('app.books').controller('BookAddController',	function($scope, bookService, $modal, $modalInstance) {
			'use strict';

	$scope.title = '';
	$scope.firstName = '';
	$scope.lastName = '';
	$scope.authors = [{
		id : null,
		firstName : '',
		lastName : ''
	}];

	$scope.book = {
		id : null,
		title : $scope.title,
		authors : ''
	};

	function authorToString(authorData) {
		return authorData.firstName + ' ' + authorData.lastName;
	}

	function authorsString() {
		var i = 0;
		var text = '';
		while (i < $scope.authors.length) {
			text += authorToString($scope.authors[i]) + ', ';
			i++;
		}
		return text.substr(0, text.length-2);
	}
	
	$scope.removeAuthor = function (index) {
		$scope.authors.splice(index, 1);
	};
	
	$scope.addBook = function(booleanTitle, booleanFirstName, booleanLastName) {
		if(booleanTitle, booleanFirstName, booleanLastName){
			$scope.book.title = $scope.title;
		$scope.book.authors = authorsString();
		bookService.saveBook($scope.book);
		$modalInstance.close();
		}
	};

	$scope.addNextAuthor = function() {

		var modalAuthor = $modal.open({
			templateUrl : 'books/html/author-modal-add.html',
			controller : 'AuthorAddController',
			size : 'lg',
		});

		modalAuthor.result.then(function(result) {
			$scope.authors.push(result);
		});
	};
});
