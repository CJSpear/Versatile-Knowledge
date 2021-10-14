var Searchitems = angular.module('searching', ['ngResource', 'ngStorage']);

Searchitems.factory('searchAPI',  function ($resource) {
    return $resource("/api/search/:type/:val");

});


Searchitems.controller("SearchController", function ($scope, $http, $q, searchAPI) {


//       this.JSON = function(){
//        $http.get('js/json/messages.json').then(function (data){

//         $scope.messages = data.data;       }
// )};
//
//    $http.get('js/json/messages.json').then(function (data){
//
//        $scope.messages = data.data;
//        
//    })

     $scope.messages;

    $scope.SearchType;
    $scope.SearchInfo;
    $scope.items = [];
    response = [];


    this.search = function (SearchInfo, SearchType) {
        
//        console.log("starts working")     
        console.log(SearchType)
        console.log(SearchInfo)

  

//        
//         this.s = searchAPI.get({"type" : SearchInfo, "val" : SearchType }).$promise.then(function(data) {
//            $scope.messages = data;
//            alert($scope.messages);
//            });

//        this.s = valAPI.get({'val': SearchInfo });
        this.s = searchAPI.query({"type": SearchInfo, "val": SearchType},function(response, response2){
//
         $scope.messages = response;
            console.log(response);
            let responseToString = response.toString();
            var message = [];
           message = JSON.stringify(response)
           console.log(message);
           let remove_first_charater = message.slice(1,-1)
           let remove_2nd_character = remove_first_charater.slice(1,-1)
//           let remove_3rd_character = remove_2nd_character.slice(1,-1)
//                console.log(remove_first_charater);
                var finalData = remove_2nd_character.replace(/\\/g, "");
//                 console.log(finalData);

            obj = JSON.parse(finalData);
            
            
           console.log(obj);
            
            $scope.messages = obj;


            
//             this.s = response;
             
             
            
//            angular = response.fromJSON();
//            console.log(angular);
            
//            for (i in (response-1)){
//            response += response[i+1] 
//                 }
//           var message = [];
//            message = JSON.stringify(response)
//                        console.log(message);
//
//            $scope.messages = message;

//            return message
        });
   //        console.log("ending working");
//           console.log(this.s);
//        .then (function(this.s){
//        console.log(this.s);
//           });

//        for (i in (this.s-1)){
//            this.s += this.s[i+1] 
//        }
//        var message = [];
//        message.push(this.s);
//        console.log(message);
//        message = JSON.stringify(message);
//        console.log(message);
//       $scope.messages = this.s
    };



    // $scope.searchFunction({
    //     type: $scope.SearchType,
    //     input: $scope.SearchInput,
    //     $http({
    //    })
    // });

});

