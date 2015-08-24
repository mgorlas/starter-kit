angular.module('app.books').controller('BookAddController', function ($scope, bookService, authorAddService) {
    'use strict';

    $scope.title = '';
    $scope.firstName = '';
    $scope.lastName = '';
    $scope.authors = [];
    
    var author = {
        	id : null,
        	firstName : $scope.firstName,
        	lastName :  $scope.lastName
     };
    
    var book = {
    	id : null,
    	title : $scope.title,
    	authors : ''
    };
    
    function authorToString(author){
    	return author.firstName + ' ' + author.lastName;
    }
    
    function authorsString(){
    	var i = 0;
    	var text = '';
    	while (i < $scope.authors.length) {
    	    text += authorToString($scope.authors[i]) + ', ';
    	    i++;
    	}
    	return text;
    }
       
    
    $scope.addBook = function () {
    	author.firstName = $scope.firstName;
    	author.lastName = $scope.lastName;
    	$scope.authors.push(author);
    	book.title = $scope.title;
    	book.authors = authorsString();
    	
    	bookService.saveBook(book);
    	authorAddService.saveAuthor(author);
    };

  
});

    
   
