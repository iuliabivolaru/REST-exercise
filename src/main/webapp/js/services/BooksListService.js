angular.module('booksApp').factory('booksListService', BooksListService);
function BooksListService($http){
    return {
        getBooksDetails: function() {
            return $http.get('http://localhost:8080/rest/books')
                .then(function(response){
                    return response.data;
                    console.log(response.data);

                })
        }
    };
};