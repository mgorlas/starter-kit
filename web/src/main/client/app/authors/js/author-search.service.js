angular.module('app.authors').factory('authorService', function (authorRestService) {
    'use strict';

    return {
        searchAll: function () {
            return authorRestService.searchAll();
        } 
    };
});
