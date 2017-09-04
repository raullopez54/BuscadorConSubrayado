app.controller('ngAppControllerTestBbdd',
['$scope', '$http', '$timeout', 'utilFactory',
  function ($scope, $http, $timeout, utilFactory)
  {

    /**************************************************************************
     * 
     * CONFIG
     * 
     **************************************************************************/




    /**************************************************************************
     * 
     * INI
     * 
     **************************************************************************/

    $scope.testOk = false;




    /**************************************************************************
     * 
     * FUNCTIONS MODEL
     * 
     **************************************************************************/

    $scope.test = function ()
    {
      utilFactory.setContTestBBDD(utilFactory.getContTestBBDD() + 1);

      $http.post('/test',
      {
        table: 'propiedad del objeto'
      })
      .then(function (response)
      {
        scopeTest(response.data);
      });
    };


    /**************************************************************************
     * 
     * PRIVATE FUNCTIONS
     * 
     **************************************************************************/
    function scopeTest(data)
    {
      $scope.testOk = true;
      $scope.bbdd = data;

      $timeout(function ()
      {
        $scope.testOk = false;
      }, 5000);
    }

  }]);