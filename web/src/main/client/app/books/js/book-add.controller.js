angular.module('app.books').controller('BookAddController',	function($scope, bookService, authorAddService, $modal) {
			'use strict';

	$scope.title = '';
	$scope.firstName = '';
	$scope.lastName = '';
	$scope.authors = [];

	$scope.author = {
		id : null,
		firstName : $scope.firstName,
		lastName : $scope.lastName
	};

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

	function addAuthor(){
		$scope.author.firstName = $scope.firstName;
		$scope.author.lastName = $scope.lastName;
		$scope.authors.push($scope.author);
	}
	
	$scope.addBook = function() {
		addAuthor();
		$scope.book.title = $scope.title;
		$scope.book.authors = authorsString();

		bookService.saveBook($scope.book);
		var i = 0;
		while (i < $scope.authors.length) {
			authorAddService.saveAuthor($scope.authors[i]);
			i++;
		}
	};

	$scope.addNextAuthor = function() {
		var modalInstance = $modal.open({
			templateUrl : 'books/html/author-modal-add.html',
			controller : 'AuthorAddController',
			size : 'lg',
		});

		modalInstance.result.then(function(result) {
			$scope.authors.push(result);
		});
	};
});
