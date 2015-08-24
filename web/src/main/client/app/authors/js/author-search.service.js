angular.module('app.authors').factory('authorSearchService', function (authorSearchRestService) {
    'use strict';

    return {
        searchAll: function () {
            return authorSearchRestService.searchAll();
        } 
    };
});
