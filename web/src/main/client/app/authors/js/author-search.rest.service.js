angular.module('app.authors').factory('authorRestService', function ($http, currentContextPath) {
    'use strict';

    return {
        searchAll: function () {
            return $http.get(currentContextPath.get() + 'rest/authors/authors-list');
        }
    };
});
