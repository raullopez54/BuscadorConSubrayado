app.controller('ngAppControllerSearch',
['$scope', '$http', '$timeout', function ($scope, $http, $timeout)
  {
    var timer =
    {
      search:
      {
        id: null,
        ms: 750
      }
    };

    $scope.searchFn = function (e)
    {
      var value = e.target.value;

      $timeout.cancel(timer.search.id);
      timer.search.id = $timeout(function ()
      {
        $http.post('/getItems',
        {
          nombre: value
        })
        .then(function (response)
        {
          var data = response.data;

          $scope.items = data;
        });

      }, timer.search.ms);
    };

  }]);