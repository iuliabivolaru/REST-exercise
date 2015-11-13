angular.module('booksApp').factory('bookDetailsService', BookDetailsService);
function BookDetailsService($http){
    return {
        getBookDetails: function(bookId) {
            return $http.get('http://localhost:8080/rest/books/' + bookId)
                        .then(function(response){
                            return response.data;
                            console.log(response.data);
                         })
        }
    };
};