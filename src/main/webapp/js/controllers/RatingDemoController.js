angular.module('booksApp').controller('RatingDemoController', function ($scope) {
    $scope.rate = $scope.book.stars;
    $scope.max = 5;
    $scope.isReadonly = true;

    $scope.hoveringOver = function(value) {
        $scope.overStar = value;
        $scope.percent = 100 * (value / $scope.max);
    };

    $scope.ratingStates = {
         stateOn: 'glyphicon-star',
         stateOff: 'glyphicon-star-empty'
    };
});