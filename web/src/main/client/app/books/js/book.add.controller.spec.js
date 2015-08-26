//describe('bookAddController', function () {
//    'use strict';
//
//    beforeEach(function () {
//        module('app.main');
//        module('app.books');
//    });
//
//    var $scope;
//    beforeEach(inject(function ($rootScope) {
//        $scope = $rootScope.$new();
//    }));
//
//    it('addBook is defined', inject(function ($controller) {
//        // when
//        $controller('BookAddController', {$scope: $scope});
//        // then
//        expect($scope.addBook).toBeDefined();
//    }));
//    it('removeAuthor is defined', inject(function ($controller) {
//    	// when
//    	$controller('BookAddController', {$scope: $scope});
//    	// then
//    	expect($scope.removeAuthor).toBeDefined();
//    }));
//    it('addNextAuthor is defined', inject(function ($controller) {
//    	// when
//    	$controller('BookAddController', {$scope: $scope});
//    	// then
//    	expect($scope.addNextAuthor).toBeDefined();
//    }));
//
//    it('delete book should call bookService.deleteBook', inject(function ($controller, $q, bookService, Flash) {
//        // given
//        $controller('BookSearchController', {$scope: $scope});
//
//        var bookId = 1;
//        $scope.books = [{id: bookId, title: 'test'}];
//        var deleteDeferred = $q.defer();
//        spyOn(bookService, 'deleteBook').and.returnValue(deleteDeferred.promise);
//        spyOn(Flash, 'create');
//        // when
//        $scope.deleteBook(bookId);
//        deleteDeferred.resolve();
//        $scope.$digest();
//        // then
//        expect(bookService.deleteBook).toHaveBeenCalledWith(bookId);
//        expect(Flash.create).toHaveBeenCalledWith('success', '<span class="glyphicon glyphicon-ok flashOk" aria-hidden="true"></span><strong>Well done!</strong> The book has been removed.', 'custom-class');
//        expect($scope.books.length).toBe(0);
//    }));
//    
//    it('search books should call bookService.search', inject(function ($controller, $q, bookService) {
//    	// given
//    	$controller('BookSearchController', {$scope: $scope});
//    
//    	$scope.prefix = 'first';
//    	$scope.books = [{id: 1, title: 'first test'}, {id: 2, title: 'second test'}];
//    	var booksFind = {data : [{id: 1, title: 'first test'}]};
//    	var searchDeferred = $q.defer();
//    	spyOn(bookService, 'search').and.returnValue(searchDeferred.promise);
//    	// when
//    	$scope.search();
//    	searchDeferred.resolve(booksFind);
//    	$scope.$digest();
//    	// then
//    	expect(bookService.search).toHaveBeenCalledWith($scope.prefix);
//    	expect(1).toBe($scope.books.length);
//    }));
//    
//    it('search all books should call bookService.searchAll', inject(function ($controller, $q, bookService) {
//    	// given
//    	$controller('BookSearchController', {$scope: $scope});
//    	
//    	$scope.books = [{id: 1, title: 'first test'}, {id: 2, title: 'second test'}];
//    	var booksFind = {data : [{id: 1, title: 'first test'}, {id: 2, title: 'second test'}]};
//    	var searchDeferred = $q.defer();
//    	spyOn(bookService, 'searchAll').and.returnValue(searchDeferred.promise);
//    	// when
//    	$scope.searchAll();
//    	searchDeferred.resolve(booksFind);
//    	$scope.$digest();
//    	// then
//    	expect(bookService.searchAll).toHaveBeenCalledWith();
//    	expect(2).toBe($scope.books.length);
//    }));
//});
