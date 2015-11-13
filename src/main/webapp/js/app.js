'use strict';


var booksApp = angular.module('booksApp', ['ngRoute']);
angular
    .module('booksApp')
    .config(function($routeProvider) {
        $routeProvider.when('/bookDetails/:bookId',
            {
                templateUrl: 'templates/BookDetails.html',
                controller: 'BookController'
            });

        $routeProvider.otherwise({redirectTo: '/bookDetails/1'});
       // $locationProvider.html5Mode(true);

        console.log("Should show this");


    });
