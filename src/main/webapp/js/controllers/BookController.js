(function() {
    var app = angular.module("booksApp", []);
    var BookController = function($scope, $http){
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

        var onBookComplete = function(response) {
            $scope.book = response.data;
        };

        var onError = function(reason) {
            $scope.error = "Could not fetch the book";
        };


        $http.get("http://localhost:8080/rest/books/1")
            .then(onBookComplete, onError);


        //$scope.message = "Hello, Angular!";


    }

    app.controller("BookController", BookController);

}());