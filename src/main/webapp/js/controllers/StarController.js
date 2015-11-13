

angular.module("booksApp").controller('StarController', ['$scope', function ($scope) {
    $scope.ratings = $scope.book.stars;
}]);

angular.module("booksApp").directive('starRating', function () {
    return {
        restrict: 'A',
        template: '<span ng-repeat="star in stars">x</span>',
        scope: {
            ratingValue: '='
        },
        link: function (scope, elem, attrs) {
            scope.stars = [];
            console.log(scope);
            for (var i = 0; i < scope.ratingValue; i++) {
                if(i < 6) {
                    scope.stars.push(
                        i
                    );
                }
            }
        }
    }
});
