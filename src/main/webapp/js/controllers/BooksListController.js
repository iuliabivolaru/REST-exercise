'use strict';
angular.module('booksApp').controller('BooksListController',
    function BooksListController($scope, booksListService){

        booksListService.getBooksDetails().then(function(data){
            console.log(data);
            $scope.books = data;
        });

    });



