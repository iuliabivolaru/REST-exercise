    'use strict';
    angular.module('booksApp').controller('BookController',
        function BookController($scope, bookDetailsService, $routeParams){
        /*var onBookComplete = function(response){
         $scope.book = response.data;
         $http.get($scope.book)
         .then(onTitle);
         };

         var onTitle = function(response){
         $scope.title = response.data;
         };

         $scope.search = function(bookId) {
         $http.get("http://localhost:8080/rest/books/" + bookId)
         .then(onBookComplete);
         };



         $scope.bookId = 1;*/

            console.log("TEst");


            $scope.bookId = $routeParams.bookId;

            bookDetailsService.getBookDetails($routeParams.bookId).then(function(data){
                console.log(data);
                $scope.book = data;
            });



       /* var onBookComplete = function(response) {
            console.log(response.data);
            $scope.book = response.data;
        };

        var onError = function(reason) {
            $scope.error = "Could not fetch the book";
        };


        $http.get("http://localhost:8080/rest/books/1")
            .then(onBookComplete, onError);*/

    });



