describe('author service', function () {
    'use strict';

    var $authorService;
    beforeEach(function () {
        module('app.main');
        module('app.authors');
        inject(function(authorService) {
        	$authorService = authorService;
        });
    });

    it('search is defined', inject(function () {
        // then
        expect($authorService.searchAll).toBeDefined();
    }));

    it('calls authorRestService.searchAll', inject(function($q, authorRestService) {
    	// given
        var searchDeferred = $q.defer();
        spyOn(authorRestService, 'searchAll').and.returnValue(searchDeferred.promise);
        // when
        $authorService.searchAll();
        searchDeferred.resolve({data: null});
    	// then
        expect(authorRestService.searchAll).toHaveBeenCalled();
    }));
});