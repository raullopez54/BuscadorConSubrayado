app.controller('ngAppControllerSearch',
['$scope', '$http', '$timeout', function ($scope, $http, $timeout)
  {

    /**************************************************************************
     * 
     * CONFIG
     * 
     **************************************************************************/

    var timer =
    {
      search:
      {
        id: null,
        ms: 750
      }
    };

    /**************************************************************************
     * 
     * INI
     * 
     **************************************************************************/

    (function ()
    {
      $http.post('/getItems', {})
      .then(function (response)
      {
        scopeItems(response.data);
      })
    })();



    /**************************************************************************
     * 
     * FUNCTIONS MODEL
     * 
     **************************************************************************/

    $scope.searchFn = function (e)
    {
      var value = e.target.value;

      $timeout.cancel(timer.search.id);
      timer.search.id = $timeout(function ()
      {
        $http.post('/searchItems',
        {
          nombre: value
        })
        .then(function (response)
        {
          scopeItems(response.data);
        });

      }, timer.search.ms);
    };




    /**************************************************************************
     * 
     * PRIVATE FUNCTIONS
     * 
     **************************************************************************/
    function scopeItems(data)
    {
      $scope.items = data;
    }

  }]);