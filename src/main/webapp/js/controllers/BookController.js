    'use strict';
    angular.module('booksApp').controller('BookController',
        function BookController($scope, bookDetailsService, $routeParams){

            $scope.bookId = $routeParams.bookId;

            bookDetailsService.getBookDetails($routeParams.bookId).then(function(data){
                console.log(data);
                $scope.book = data;

            });

    });



