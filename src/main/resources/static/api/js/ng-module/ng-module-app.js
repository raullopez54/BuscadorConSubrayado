var app = angular.module('app', ['ngRoute'])

app.config(['$routeProvider', '$locationProvider', function ($routeProvider,
  $locationProvider)
  {
//    $locationProvider.html5Mode(true);


    $routeProvider.otherwise(
    {
      redirectTo: '/'
    })

    .when('/pagina1',
    {
      templateUrl: GBL_COFG.urlTemplate('pagina1.html'),
      controller: 'ng-app-controller-template1'
    })

    .when('/pagina2',
    {
      templateUrl: GBL_COFG.urlTemplate('pagina2.html'),
      controller: 'ng-app-controller-template2'
    });
  }]);

app.directive('apploading', ['$http', function ($http)
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
          console.log(JSON.stringify(elm) + ' ' + JSON.stringify(attrs))
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


