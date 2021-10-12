var Searchitems = angular.module('searching', ['ngResource', 'ngStorage']);

console.log("hello")


Searchitems.factory('searchAPI', function($resource){

    return $resource("/api/search/:type/:val");

 });

Searchitems.controller("SearchController", ['$scope', '$http', function($scope, $http, searchAPI){



    $http.get('js/json/messages.json').then(function (data){

        $scope.messages = data.data;


        
    

  // $scope.searchFunction({
    //     type: $scope.SearchType,
    //     input: $scope.SearchInput,
    //     $http({
    //    })
    // });

})}
])
