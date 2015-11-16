'use strict';


var booksApp = angular.module('booksApp', ['ngRoute', 'ui.bootstrap']);
booksApp
    .config(function($routeProvider) {
        $routeProvider
            .when('/books',
            {
                templateUrl: 'templates/BooksListDetails.html',
                controller: 'BooksListController'
            })
            .when('/books/:bookId',
            {
                templateUrl: 'templates/BookDetails.html',
                controller: 'BookController'
            })
            .when('/books/add',
            {
                templateUrl: 'templates/BookAdd.html',
                controller: 'BookAddController'
            })
            .otherwise({redirectTo: '/books'});
    });
