angular.module('app.books').controller('AuthorAddController', function ($scope, $modalInstance) {
    'use strict';
    
    $scope.nextFirstName = '';
    $scope.nextLastName = '';
    
    $scope.authorNext = {
        	id : null,
        	firstName : '',
        	lastName :  ''
     };
         
    
    $scope.addAuthor = function () {
    	 $scope.authorNext.firstName = $scope.nextFirstName;
    	 $scope.authorNext.lastName = $scope.nextLastName;
        $modalInstance.close($scope.authorNext);
    };
 
});

    
   
