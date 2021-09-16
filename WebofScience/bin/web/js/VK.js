/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


"use strict";

// create a new module, and load the other pluggable modules
var module = angular.module('VK', ['ngResource', 'ngStorage']);

module.factory('registerAPI', function ($resource) {
    return $resource('api/register');
});

module.factory('signinAPI', function ($resource) {
    return $resource('api/users/:username/:password');
});

module.controller('UserController', function (registerAPI, signinAPI, $sessionStorage, $window, $http) {
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

            this.signin = function (username, password) {
                signinAPI.get({'username': username, 'password': password},
                        function (user) {
                            $sessionStorage.user = user;

                            $window.location = 'home.html';
                        },
                        function () {
                            ctrl.signInMessage = 'Sign in failed. Please try again.';
                        }
                );
            };

            this.checkSignIn = function () {
                // has the customer been added to the session?
                if ($sessionStorage.user) {
                    this.signedIn = true;
                    this.welcome = "Welcome " + $sessionStorage.user.firstName;
                } else {
                    this.signedIn = false;
                }
            };

            this.signOut = function () {
                $sessionStorage.$reset();
                $window.location = 'home.html';
            }
        });

module.controller('ArticleController', function () {

});