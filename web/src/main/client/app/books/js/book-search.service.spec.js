describe('book service', function() {
	'use strict';

	var $bookService;
	beforeEach(function() {
		module('app.main');
		module('app.books');
		inject(function(bookService) {
			$bookService = bookService;
		});
	});

	it('search is defined', inject(function() {
		// then
		expect($bookService.search).toBeDefined();
	}));
	it('searchAll is defined', inject(function() {
		// then
		expect($bookService.searchAll).toBeDefined();
	}));
	it('saveBook is defined', inject(function() {
		// then
		expect($bookService.saveBook).toBeDefined();
	}));
	it('deleteBook is defined', inject(function() {
		// then
		expect($bookService.deleteBook).toBeDefined();
	}));
	it('updateTitleBook is defined', inject(function() {
		// then
		expect($bookService.updateTitleBook).toBeDefined();
	}));

	it('calls bookRestService.searchAll', inject(function($q, bookRestService) {
		// given
		var searchDeferred = $q.defer();
		spyOn(bookRestService, 'searchAll').and
				.returnValue(searchDeferred.promise);
		// when
		$bookService.searchAll();
		searchDeferred.resolve({
			data : null
		});
		// then
		expect(bookRestService.searchAll).toHaveBeenCalled();
	}));

	it('calls bookRestService.search', inject(function($q, bookRestService) {
		// given
		var searchDeferred = $q.defer();
		spyOn(bookRestService, 'search').and
				.returnValue(searchDeferred.promise);
		// when
		$bookService.search('J');
		searchDeferred.resolve({
			data : null
		});
		// then
		expect(bookRestService.search).toHaveBeenCalled();
	}));

	it('calls bookRestService.deleteBook',
			inject(function($q, bookRestService) {
				// given
				var deleteDeferred = $q.defer();
				spyOn(bookRestService, 'deleteBook').and
						.returnValue(deleteDeferred.promise);
				// when
				$bookService.deleteBook(1);
				deleteDeferred.resolve({
					data : null
				});
				// then
				expect(bookRestService.deleteBook).toHaveBeenCalled();
			}));

	it('calls bookRestService.saveBook', inject(function($q, bookRestService) {
		// given
		var saveDeferred = $q.defer();
		spyOn(bookRestService, 'saveBook').and
				.returnValue(saveDeferred.promise);
		// when
		$bookService.saveBook({
			id : 1,
			title : '',
			authors : ''
		});
		// then
		expect(bookRestService.saveBook).toHaveBeenCalled();
	}));

	it('calls bookRestService.updateTitleBook', inject(function($q,
			bookRestService) {
		// given
		var updateDeferred = $q.defer();
		spyOn(bookRestService, 'updateTitleBook').and
				.returnValue(updateDeferred.promise);
		// when
		$bookService.updateTitleBook({
			id : 1,
			title : '',
			authors : ''
		});
		updateDeferred.resolve({
			data : null
		});
		// then
		expect(bookRestService.updateTitleBook).toHaveBeenCalled();
	}));

});