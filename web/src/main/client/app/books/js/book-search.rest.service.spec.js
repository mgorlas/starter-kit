describe('book rest service', function() {
	'use strict';

	var $bookRestService;
	var httpBackend;
	var context;
	beforeEach(function() {
		module('app.main');
		module('app.books');
		inject(function(bookRestService, $httpBackend, currentContextPath) {
			$bookRestService = bookRestService;
			httpBackend = $httpBackend;
			context = currentContextPath.get();
		});
	});

	it('search is defined', inject(function() {
		// then
		expect($bookRestService.search).toBeDefined();
	}));
	it('searchAll is defined', inject(function() {
		// then
		expect($bookRestService.searchAll).toBeDefined();
	}));
	it('saveBook is defined', inject(function() {
		// then
		expect($bookRestService.saveBook).toBeDefined();
	}));
	it('deleteBook is defined', inject(function() {
		// then
		expect($bookRestService.deleteBook).toBeDefined();
	}));
	it('updateTitleBook is defined', inject(function() {
		// then
		expect($bookRestService.updateTitleBook).toBeDefined();
	}));

	it('calls bookRestService.searchAll with GET', inject(function() {
		// when
		httpBackend.expect('GET', context + 'rest/books/books').respond({
			data : null
		});
		$bookRestService.searchAll();
		// then
		httpBackend.flush();
	}));

	it('calls bookRestService.search with GET', inject(function() {
		//given
		var titlePrefix = 'P';
		// when
		httpBackend.expect('GET', context + 'rest/books/books-by-title?titlePrefix=' + titlePrefix )
				.respond({
					data : null
				});
		$bookRestService.search(titlePrefix);
		// then
		httpBackend.flush();
	}));


	it('calls bookRestService.saveBook with POST', inject(function() {
		// given
		var book = {
			id : 1,
			title : 'title book',
			authors : 'authors'
		};
		// when
		httpBackend.expect('POST', context + 'rest/books/book', book).respond({
			data : null
		});
		$bookRestService.saveBook(book);
		// then
		httpBackend.flush();
	}));

	it('calls bookRestService.updateTitleBook with POST', inject(function() {
		// given
		var book = {
			id : 1,
			title : 'title book',
			authors : 'authors'
		};
		// when
		httpBackend.expect('POST', context + 'rest/books/book-update-title',
				book).respond({
			data : null
		});
		$bookRestService.updateTitleBook(book);
		// then
		httpBackend.flush();
	}));

	it('calls bookRestService.deleteBook with GET', inject(function() {
		// when
		httpBackend.expect('DELETE', context + 'rest/books/book/1').respond({
			data : null
		});
		$bookRestService.deleteBook(1);
		// then
		httpBackend.flush();
	}));
});