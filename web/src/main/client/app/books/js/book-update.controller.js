angular.module('app.books').controller('BookUpdateController', function ($scope,  $window, $location, book) {
    'use strict';

    $scope.book = book;
});
