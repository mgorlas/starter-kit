describe('bookUpdateController', function () {
    'use strict';

    beforeEach(function () {
        module('app.main');
        module('app.books');
    });

    var $scope;
    var $modalInstance;
    var book;
    beforeEach(inject(function ($rootScope) {
        $scope = $rootScope.$new();
        $modalInstance =  {                    
                close: jasmine.createSpy('modalInstance.close'),
                dismiss: jasmine.createSpy('modalInstance.dismiss'),
                result: {
                  then: jasmine.createSpy('modalInstance.result.then')
                }
              };
        book = {id: 1, title: 'first test'};
    }));

    it('updateBook and book and newTitle is defined', inject(function ($controller) {
        // when
        $controller('BookUpdateController', {$scope: $scope, $modalInstance : $modalInstance, book : book});
        // then
        expect($scope.newTitle).toBeDefined();
        expect($scope.updateBook).toBeDefined();
    }));

    it('update book should call bookService.updateTitleBook', inject(function ($controller, $q, bookService) {
        // given
    	
        $controller('BookUpdateController', {$scope: $scope, $modalInstance : $modalInstance, book : book});

        $scope.book = book;
        $scope.newTitle = 'New title';
        var searchDeferred = $q.defer();
        spyOn(bookService, 'updateTitleBook').and.returnValue(searchDeferred.promise);
        // when
        $scope.updateBook(true);
        searchDeferred.resolve();
        $scope.$digest();
        // then
       expect($modalInstance.close).toHaveBeenCalledWith();
       expect(bookService.updateTitleBook).toHaveBeenCalledWith($scope.book);
       expect($scope.newTitle).toBe($scope.book.title);
       expect(book).toBe($scope.book);
    }));
   
});
