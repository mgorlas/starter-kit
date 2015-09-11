angular.module('app.books').controller('AuthorAddController', function ($scope, $modalInstance) {
    'use strict';
    
    $scope.nextFirstName = '';
    $scope.nextLastName = '';
    
    $scope.newAuthor = {
        	id : null,
        	firstName : '',
        	lastName :  ''
     };
         
    
    $scope.addAuthor = function (booleanFirstName, booleanLastName) {
    	if(booleanFirstName && booleanLastName){
    		$scope.newAuthor.firstName = $scope.nextFirstName;
    		$scope.newAuthor.lastName = $scope.nextLastName;
    		$modalInstance.close($scope.newAuthor);
    	}
    };
    
    
 
});

    
   
