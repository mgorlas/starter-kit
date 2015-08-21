angular.module('app.authors').factory('authorRestService', function ($http, currentContextPath) {
    'use strict';

    return {
        search: function (titlePrefix) {
            return $http.get(currentContextPath.get() + 'rest/books/books-by-title', {params: {titlePrefix: titlePrefix}});
        }
    };
});
