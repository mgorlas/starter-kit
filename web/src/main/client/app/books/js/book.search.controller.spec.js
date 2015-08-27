describe('bookController', function () {
    'use strict';

    beforeEach(function () {
        module('app.main');
        module('flash');
        module('app.books');
    });

    var $scope;
    beforeEach(inject(function ($rootScope) {
        $scope = $rootScope.$new();
    }));

    it('search is defined', inject(function ($controller) {
        // when
        $controller('BookSearchController', {$scope: $scope});
        // then
        expect($scope.search).toBeDefined();
    }));
    
    it('delete is defined', inject(function ($controller) {
    	// when
    	$controller('BookSearchController', {$scope: $scope});
    	// then
    	expect($scope.deleteBook).toBeDefined();
    }));

    it('delete book should call bookService.deleteBook', inject(function ($controller, $q, bookService, Flash) {
        // given
        $controller('BookSearchController', {$scope: $scope});

        var bookId = 1;
        $scope.books = [{id: bookId, title: 'test'}];
        var deleteDeferred = $q.defer();
        spyOn(bookService, 'deleteBook').and.returnValue(deleteDeferred.promise);
        spyOn(Flash, 'create');
        // when
        $scope.deleteBook(bookId);
        deleteDeferred.resolve();
        $scope.$digest();
        // then
        expect(bookService.deleteBook).toHaveBeenCalledWith(bookId);
        expect(Flash.create).toHaveBeenCalledWith('success', '<span class="glyphicon glyphicon-ok flashOk" aria-hidden="true"></span><strong>Well done!</strong> The book has been removed.', 'custom-class');
        expect($scope.books.length).toBe(0);
    }));
    
    it('search books should call bookService.search', inject(function ($controller, $q, bookService) {
    	// given
    	$controller('BookSearchController', {$scope: $scope});
    
    	$scope.prefix = 'first';
    	$scope.books = [{id: 1, title: 'first book'}, {id: 2, title: 'second book'}];
    	var findBooks = {data : [{id: 1, title: 'first book'}]};
    	var searchDeferred = $q.defer();
    	spyOn(bookService, 'search').and.returnValue(searchDeferred.promise);
    	// when
    	$scope.search();
    	searchDeferred.resolve(findBooks);
    	$scope.$digest();
    	// then
    	expect(bookService.search).toHaveBeenCalledWith($scope.prefix);
    	expect(1).toBe($scope.books.length);
    }));
    
    it('search all books should call bookService.searchAll', inject(function ($controller, $q, bookService) {
    	// given
    	$controller('BookSearchController', {$scope: $scope});
    	
    	$scope.books = [];
    	var findBooks = {data : [{id: 1, title: 'first book'}, {id: 2, title: 'second book'}]};
    	var searchDeferred = $q.defer();
    	spyOn(bookService, 'searchAll').and.returnValue(searchDeferred.promise);
    	// when
    	$scope.searchAll();
    	searchDeferred.resolve(findBooks);
    	$scope.$digest();
    	// then
    	expect(bookService.searchAll).toHaveBeenCalledWith();
    	expect(2).toBe($scope.books.length);
    }));
    
    it('add book should call $scope.addBook', inject(function ($controller, $q, bookService, Flash, $modal) {
    	// given
    	$controller('BookSearchController', {$scope: $scope});
    	
    	$scope.books = [];
    	var findBooks = {data : [{id: 1, title: 'first book'}, {id: 2, title: 'second book'}]};
    	var modalResult = {
                then: function(callback) {
                    callback();
                }
         };
    	
    	var deleteDeferred = $q.defer();
    	spyOn($modal, 'open').and.returnValue({result: modalResult});
    	spyOn(bookService, 'searchAll').and.returnValue(deleteDeferred.promise);
    	spyOn(Flash, 'create');
    	// when
    	$scope.addBook();
    	deleteDeferred.resolve(findBooks);
    	$scope.$digest();
    	// then
    	expect(bookService.searchAll).toHaveBeenCalledWith();
    	expect(Flash.create).toHaveBeenCalledWith('success', '<span class="glyphicon glyphicon-ok flashOk" aria-hidden="true"></span><strong>Well done!</strong> New book has been added.', 'custom-class');
    	expect(2).toBe($scope.books.length);
    }));
    
    it('update title book should call $scope.updateBook', inject(function ($controller, $q, bookService, Flash, $modal) {
    	// given
    	$controller('BookSearchController', {$scope: $scope});
    	
    	$scope.books = [];
    	var book = {id: 1, title: 'first book'};
    	var findBooks = {data : [{id: 1, title: 'first book'}, {id: 2, title: 'second book'}]};
    	var modalResult = {
    			then: function(callback) {
    				callback();
    			}
    	};
    	
    	var deleteDeferred = $q.defer();
    	spyOn($modal, 'open').and.returnValue({result: modalResult});
    	spyOn(bookService, 'searchAll').and.returnValue(deleteDeferred.promise);
    	spyOn(Flash, 'create');
    	// when
    	$scope.updateBook(book);
    	deleteDeferred.resolve(findBooks);
    	$scope.$digest();
    	// then
    	expect(bookService.searchAll).toHaveBeenCalledWith();
    	expect(Flash.create).toHaveBeenCalledWith('success', '<span class="glyphicon glyphicon-ok flashOk" aria-hidden="true"></span><strong>Well done!</strong> The book has been updated.', 'custom-class');
    	expect(2).toBe($scope.books.length);
    }));
});
