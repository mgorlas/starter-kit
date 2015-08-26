describe('author add controller', function () {
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

    it('addAuthor and newAuthor is defined', inject(function ($controller) {
        // when
        $controller('AuthorAddController', {$scope: $scope, $modalInstance : $modalInstance});
        // then
        expect($scope.newAuthor).toBeDefined();
        expect($scope.addAuthor).toBeDefined();
    }));

    it('add author should call $scope.addAuthor', inject(function ($controller) {
        // given
        $controller('AuthorAddController', {$scope: $scope, $modalInstance : $modalInstance});

        $scope.nextFirstName = 'Jan';
        $scope.nextLastName = 'Kowalski';
        $scope.newAuthor = {
            	id : null,
            	firstName : '',
            	lastName :  ''
         };
        // when
        $scope.addAuthor(true, true);
        $scope.$digest();
        // then
       expect($modalInstance.close).toHaveBeenCalledWith($scope.newAuthor);
       expect($scope.nextFirstName).toBe($scope.newAuthor.firstName);
       expect($scope.nextLastName).toBe($scope.newAuthor.lastName);
    }));
});
