angular.module('app.authors').factory('authorRestService', function ($http, currentContextPath) {
    'use strict';

    return {
        search: function (namePrefix) {
            return $http.get(currentContextPath.get() + 'rest/authors/autors-by-name', {params: {namePrefix: namePrefix}});
        }
    };
});
