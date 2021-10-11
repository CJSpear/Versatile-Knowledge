
var Searchitems = angular.module('searching', []);


console.log("hello")

/*fetch('/WebofScience/{type}/{val}/Python/callPython.java')
    .then(res=> console.log(res))



fetch('/WebofScience/Python/callPython.java', {
    method: "POST",
    headers: {  'Content-Type' : 'application/json' },
    body: JSON.stringify({
        name: "User 1"
    })
}).then(res => {
    return res.json
}) .then(data=> console.log(data))
*/

Searchitems.factory('searchAPI', function($resource){
    return $resource("WebofScience/src/main/java/web/SearchModule.java");
 });

Searchitems.controller("SearchController", ['$scope', '$http', function($scope, $http, searchAPI){
    



  // $scope.searchFunction({
    //     type: $scope.SearchType,
    //     input: $scope.SearchInput,
    //     $http({
    //    })
    // });




    $http.get('public/json/messages.json').then(function (data){

        $scope.messages = data.data;

    });

}]);


function greet(name, element){
    console.log('hey ${name}!');
    element.$server.greet("server")
    element.innerHTML = "it workss";
}
