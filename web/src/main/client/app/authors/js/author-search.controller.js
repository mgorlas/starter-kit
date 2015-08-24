angular.module('app.authors').controller('AuthorSearchController', function ($scope, $window, $location, authorSearchService, Flash) {
    'use strict';

    $scope.authors = [];
    $scope.gridOptions = { data: 'authors' };
    $scope.prefix = '';

    $scope.$on('$viewContentLoaded', function () {
    	authorSearchService.searchAll().then(function (response) {
            angular.copy(response.data, $scope.authors);
        }, function () {
            Flash.create('danger', 'Wyjątek', 'custom-class');
        });
    });
});
