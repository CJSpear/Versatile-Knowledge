/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


"use strict";

// create a new module, and load the other pluggable modules
var module = angular.module('VK', ['ngResource', 'ngStorage']);


module.config(function ($sessionStorageProvider, $httpProvider) {
    // get the auth token from the session storage
    let authToken = $sessionStorageProvider.get('authToken');

    // does the auth token actually exist?
    if (authToken) {
        // add the token to all HTTP requests
        $httpProvider.defaults.headers.common.Authorization = 'Basic ' + authToken;
    }
});

//user modules 
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

//end user modules 

// article factories 

module.factory('verifyArticleAPI', function ($resource) {
     return $resource('api/VerifyArticle');
});
        

module.factory('articlesAPI', function ($resource) {
    return $resource("/api/articles");
});


module.factory('editArticleAPI', function ($resource) {
    return $resource("/api/updateArt/:id");
});

module.factory('uploadArticleAPI', function ($resource) {
    return $resource("/api/articles/:id/file");
});

// end article factories

//admin factories 


module.factory('addVerifierAPI', function ($resource) {
    return $resource("/api/addVerifier");
});


module.factory('deleteVerifierAPI', function ($resource) {
    return $resource("/api/deleteVerifier/:id");
});

module.factory('updateVerifierAPI', function ($resource) {
    return $resource("/api/updateVerifier/:id");
});
 //end admin factories 

//verifier factories

module.factory('verifyArticlerAPI', function ($resource) {
    return $resource("/api/VerifyArticle");
});

module.factory('deleteArticleAPI', function ($resource) {
    return $resource("/api/deleteArticle/:id");
});


//end verifier factories 


//user controller 
module.controller('UserController', function (registerAPI, signinAPI, $sessionStorage, $window, $http, getUsers, allRoles) {
    //let ctrl = this;

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

this.loginMessage = "Please login to continue.";
let ctrl = this;

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


//article controller 
module.controller('ArticleController', function (articlesAPI,  editArticleAPI, uploadArticleAPI,  $http, $sessionStorage, $window) {
    let ctrl = this;
    
   
    
    this.uploadArticle = function (article) {
        articlesAPI.save(null, article,
                function () {

                    
                    $window.location = 'uploadArticle.html';
                },
                // error callback
                        function (error) {
                            console.log(error);
                        }
                );
                console.log(article);
            };

//second add article put statement uploadArticlesAPI

 this.editArticle = function (article) {
            editArticleAPI.update({'articleId': article.articleId}, article, function () {
                ctrl.updateMessage = "Article updated";
            });
        }; 

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
        
        
 //admin controller 
module.controller('AdminController', function (addVerifierAPI, deleteVerifierAPI, updateVerifierAPI, $sessionStorage,  $http) {

   
      this.addVerifier = function (verifier) {
        addVerifierAPI.save(null, verifier,
                function () {
                    
                    $window.location = 'manageVerifier.html';
                },
                // error callback
                        function (error) {
                            console.log(error);
                        }
                );
                console.log(verifier);
            };

      this.deleteVerifier = function (verifier) {
                if ($window.confirm("Are you sure you want to delete verifier?")) {
                console.log(verifier.username);
                deleteVerifierAPI.delete({'username': verifier.username}, function () {
                    $window.location = 'manageVerifier.html';
                });
            }

            };

        this.updateVerifier = function (verifier) {
            updateVerifierAPI.update({'username': verifier.username}, verifier, function () {
                ctrl.updateMessage = "Account updated";
                
                $window.location = 'manageVerifier.html';
            });
        };
    
       
});
 
