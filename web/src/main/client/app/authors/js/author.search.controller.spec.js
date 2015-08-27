describe('Author Search Controller', function () {
    'use strict';

    beforeEach(function () {
        module('app.main');
        module('app.authors');
    });

    var $scope;
    beforeEach(inject(function ($rootScope) {
        $scope = $rootScope.$new();
    }));

    it('$scope.$on is defined', inject(function ($controller) {
        // when
        $controller('AuthorSearchController', {$scope: $scope});
        // then
        expect($scope.$on).toBeDefined();
    }));

    it('search all authors should call bookService.search', inject(function ($controller, $q, authorService) {
    	// given
    	$controller('AuthorSearchController', {$scope: $scope});
    
    	$scope.authors = [];
    	var findAuthors = {data : [{id: 1, firstName: 'Karol Krzysztof', lastName : 'Nowak'}, {id: 2, firstName: 'Mike', lastName : 'Robe'}]};
    	var searchDeferred = $q.defer();
    	spyOn(authorService, 'searchAll').and.returnValue(searchDeferred.promise);
    	// when
    	$scope.$broadcast('$viewContentLoaded');
    	searchDeferred.resolve(findAuthors);
    	$scope.$digest();
    	// then
    	expect(authorService.searchAll).toHaveBeenCalledWith();
    	expect(2).toBe($scope.authors.length);
    }));
});

