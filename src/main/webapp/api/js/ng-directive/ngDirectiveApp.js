app.directive('apploading',
['$http', '$timeout', function ($http, $timeout)
  {
    var timer =
    {
      loading:
      {
        id: null,
        ms: 750
      }
    };

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
          $timeout.cancel(timer.loading.id);

          if (v)
          {
            elm[0].classList.add('appLoading');
          }
          else
          {
            timer.loading.id = $timeout(function ()
            {
              elm[0].classList.remove('appLoading');
            }, timer.loading.ms);
          }

        });
      }
    };

    return loading;
  }]);