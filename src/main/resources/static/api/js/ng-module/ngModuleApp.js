var app = angular.module('app', ['ngRoute']);


app.config(['$routeProvider', '$locationProvider',
  function ($routeProvider, $locationProvider)
  {
    $routeProvider.otherwise(
    {
      redirectTo: '/'
    })
    .when('/',
    {
      templateUrl: GBL_COFG.urlTemplate('ini.html')
    })
    .when('/about',
    {
      templateUrl: GBL_COFG.urlTemplate('about.html')
    })
    .when('/test-bbdd',
    {
      templateUrl: GBL_COFG.urlTemplate('test-bbdd.html'),
      controller: 'ngAppControllerTestBbdd'
    })
    .when('/search',
    {
      templateUrl: GBL_COFG.urlTemplate('search.html'),
      controller: 'ngAppControllerSearch'
    });
  }]);


app.directive('apploading',
['$http', function ($http)
  {
    var loading =
    {
      restrict: 'A',
      link: function (scope, elm, attrs)
      {
        scope.isLoading = function ()
        {
          return $http.pendingRequests.length > 0;
        };

        scope.$watch(scope.isLoading, function (v)
        {
          if (v)
          {
            elm[0].classList.add('appLoading');
          }
          else
          {
            elm[0].classList.remove('appLoading');
          }
        });
      }
    };

    return loading;
  }]);


