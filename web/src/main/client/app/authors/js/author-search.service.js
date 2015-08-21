angular.module('app.authors').factory('authorService', function (authorRestService) {
    'use strict';

    return {
        search: function (titlePrefix) {
            return authorRestService.search(titlePrefix);
        } 
    };
});
