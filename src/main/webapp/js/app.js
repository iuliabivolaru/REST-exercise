'use strict';


var booksApp = angular.module('booksApp', ['ngRoute']);
angular
    .module('booksApp')
    .config(function($routeProvider) {
        $routeProvider.when('/bookDetails/1',
            {
                templateUrl: 'templates/BookDetails.html',
                controller: 'BookController'
            });

        $routeProvider.otherwise({redirectTo: '/bookDetails/1'});

        console.log("Should show this");


    });
