/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


"use strict";

// create a new module, and load the other pluggable modules
var module = angular.module('VK', ['ngResource', 'ngStorage']);

module.factory('registerAPI', function($resource){
   return $resource('api/register'); 
});

module.controller('UserController', function(registerAPI, $sessionStorage, $window, $http){
    let ctrl = this;
    
    this.registerUser = function (user) {
        registerAPI.save(null, user,
            // success callback
                function () {
                    $window.location = 'signin.html';
                },
                // error callback
                        function (error) {
                            console.log(error);
                        }
                 );
        console.log(user);
    };   
    
    if ($sessionStorage.user) {
        this.user = $sessionStorage.user;
     }
});

module.controller('ArticleController', function(){
    
});