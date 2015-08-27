describe('author rest service', function () {
    'use strict';

    var $authorRestService;
    var httpBackend;
    var context;
    beforeEach(function () {
        module('app.main');
        module('app.authors');
        inject(function(authorRestService, $httpBackend, currentContextPath) {
        	$authorRestService = authorRestService;
        	httpBackend = $httpBackend;
        	context = currentContextPath.get();
        });
    });

    it('searchAll is defined', inject(function () {
        // then
        expect($authorRestService.searchAll).toBeDefined();
    }));

    it('calls authorRestService.searchAll with GET', inject(function() {
        // when
    	httpBackend.expect('GET', context + 'rest/authors/authors-list').respond({data: null});
    	$authorRestService.searchAll();
    	// then
    	httpBackend.flush();
    }));
});