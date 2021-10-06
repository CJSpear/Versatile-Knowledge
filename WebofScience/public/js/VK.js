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

module.factory('getUsers', function ($resource) {
    return $resource('api/users');
});

module.factory('allRoles', function ($resource) {
    return $resource('api/roles');
});

+// article factories 



        module.factory('verifyArticleAPI', function ($resource) {
            return $resource('api/VerifyArticle');
        });
module.factory('deleteArticleAPI', function ($resource) {
    return $resource('api/deleteArticle/:id');
});

module.controller('UserController', function (registerAPI, signinAPI, $sessionStorage, $window, $http, getUsers, allRoles) {
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
                            // console.log($sessionStorage.user);

                            //check role permission of user currently signed in
                            if ($sessionStorage.user.roleId === 1) {
                                $window.location = 'home.html';
                            } else {
                                $window.location = 'verifyArticle.html';
                            }
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

                    if ($sessionStorage.user.roleId === 1) {
                        this.isCont = true;
                        //$window.location = 'home.html'
                    } else if ($sessionStorage.user.roleId === 4) {
                        this.isAdmin = true;
                    } else {
                        this.isCont = false;
                        //$window.location = 'verifyArticle.html';
                        this.isAdmin = false;
                    }
                    console.log(this.isCont);
                } else {
                    this.signedIn = false;
                }


            };



            this.signOut = function () {
                $sessionStorage.$reset();
                $window.location = 'home.html';
            }

            this.users = getUsers.query();
            this.roles = allRoles.query();

        });

module.factory('articlesAPI', function ($resource) {
    return $resource("/api/articles");
});


module.factory('deleteArticleAPI', function ($resource) {
    return $resource("/api/articles/:id");
});


module.factory('editArticleAPI', function ($resource) {
    return $resource("/api/updateArt/:id");
});


module.controller('ArticleController', function (articlesAPI, deleteArticleAPI, editArticleAPI, $window) {
    let ctrl = this;
    this.uploadArticle = function (article) {
        articlesAPI.save(null, article,
                function () {
                    
                    
                    // extract id from rsp
                    
                    $window.location = 'uploadArticle.html';
                },
                // error callback
                        function (error) {
                            console.log(error);
                        }
                );
                console.log(article);
            };

// second post for file


});

module.controller('VeriferController', function (verifyArticleAPI, deleteArticleAPI, $window, $sessionStorage, $http) {
    let ctrl = this;

    this.verifyArticle = function (article) {
        verifyArticleAPI.save(null, article,
                // success callback
                        function () {
                            $window.location = 'viewArticle.html';
                        },
                        // error callback
                                function (error) {
                                    console.log(error);
                                }
                        );
                        console.log(article);
                    };

            this.deleteArticle = function (article) {
                deleteArticleAPI.delete(null, article,
                        );

            };

        });