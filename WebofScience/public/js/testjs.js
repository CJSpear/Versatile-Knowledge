/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


"use strict";

// create a new module, and load the other pluggable modules
var module = angular.module('test', ['ngResource', 'ngStorage']);

module.config(function ($sessionStorageProvider, $httpProvider) {
   // get the auth token from the session storage
   let authToken = $sessionStorageProvider.get('authToken');

   // does the auth token actually exist?
   if (authToken) {
      // add the token to all HTTP requests
      $httpProvider.defaults.headers.common.Authorization = 'Basic ' + authToken;
   }
});

module.factory('gettest', function($resource){
    return $resource('api/tests');
});

module.controller('TestCont', function(gettest){
    this.tests = gettest.query();
});