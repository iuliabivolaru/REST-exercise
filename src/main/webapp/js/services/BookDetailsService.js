angular.module('booksApp').factory('bookData', BookDetailsService);
function BookDetailsService($http){
    return {
        getBookDetails: function() {
            return $http.get('http://localhost:8080/rest/books/1')
                        .then(function(response){
                            return response.data;
                            console.log(response.data);
                         })
        }
    };
};