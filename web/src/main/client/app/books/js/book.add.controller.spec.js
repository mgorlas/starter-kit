describe('BookAddController', function () {
    'use strict';

    beforeEach(function () {
        module('app.main');
        module('app.books');
    });

    var $scope;
    var $modalInstance;
    beforeEach(inject(function ($rootScope) {
        $scope = $rootScope.$new();
        $modalInstance =  {                    
                close: jasmine.createSpy('modalInstance.close'),
                dismiss: jasmine.createSpy('modalInstance.dismiss'),
                result: {
                  then: jasmine.createSpy('modalInstance.result.then')
                }
              };
    }));

    it('removeAuthor is defined', inject(function ($controller) {
        // when
        $controller('BookAddController', {$scope: $scope, $modalInstance : $modalInstance});
        // then
        expect($scope.removeAuthor).toBeDefined();
    }));
    it('addBook is defined', inject(function ($controller) {
    	// when
    	$controller('BookAddController', {$scope: $scope, $modalInstance : $modalInstance});
    	// then
    	expect($scope.addBook).toBeDefined();
    }));
    it('addNextAuthor is defined', inject(function ($controller) {
    	// when
    	$controller('BookAddController', {$scope: $scope, $modalInstance : $modalInstance});
    	// then
    	expect($scope.addNextAuthor).toBeDefined();
    }));

    it('add book should call bookService.saveBook', inject(function ($controller, $q, bookService) {
        // given
    	
        $controller('BookAddController', {$scope: $scope, $modalInstance : $modalInstance});

    	$scope.title = 'First book';
    	$scope.firstName = 'Jan';
    	$scope.lastName = 'Kowalski';
    	$scope.authors = [{id: null, firstName : $scope.firstName, lastName : $scope.lastName}];
    	$scope.book = {
    			id : null,
    			title : $scope.title,
    			authors : ''
    	};
    	
        var addDeferred = $q.defer();
        spyOn(bookService, 'saveBook').and.returnValue(addDeferred.promise);
        // when
        $scope.addBook(true, true, true);
        addDeferred.resolve();
        $scope.$digest();
        // then
       expect($modalInstance.close).toHaveBeenCalledWith();
       expect(bookService.saveBook).toHaveBeenCalledWith($scope.book);
       expect($scope.firstName + ' ' + $scope.lastName).toBe($scope.book.authors);
       expect($scope.title).toBe($scope.book.title);
    }));
    
    it('add author to array should call $scope.addNextAuthor', inject(function ($controller, $modal) {
    	// given
    	
    	$controller('BookAddController', {$scope: $scope, $modalInstance : $modalInstance});

    	$scope.authors = [];    
    	var author = {
    		id: 1,
    		firstName : 'jan',
    		lastName : 'Kowalski'
    	};
    	
    	var modalResult = {
                then: function(callback) {
                    callback(author); // passing fake value as result
                }
            };
    	
    	spyOn($modal, 'open').and.returnValue({result: modalResult});

        // when
    	$scope.addNextAuthor();
        $scope.$digest();
        // then
        expect($modal.open).toHaveBeenCalled();
        expect(1).toBe($scope.authors.length);
        expect(author.firstName).toBe($scope.authors[0].firstName);
        expect(author.lastName).toBe($scope.authors[0].lastName);
    }));
    
    it('remove author from array should call $scope.removeAuthor', inject(function ($controller) {
    	// given
    	
    	$controller('BookAddController', {$scope: $scope, $modalInstance : $modalInstance});
    	
    	$scope.authors = [ {id: 1, firstName : 'jan', lastName : 'Kowalski'}, {id: 2, firstName : 'Bartosz', lastName : 'Kalski'}];    
    	var beforeRemoveAuthorLength = $scope.authors.length;
    	// when
    	$scope.removeAuthor(1);
    	$scope.$digest();
    	// then
    	expect(beforeRemoveAuthorLength - 1).toBe($scope.authors.length);
    }));
   
});
