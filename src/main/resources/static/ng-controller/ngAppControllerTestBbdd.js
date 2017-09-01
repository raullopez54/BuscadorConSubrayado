app.controller('ngAppControllerTestBbdd',
['$scope', '$http', '$timeout', 'utilService', function ($scope, $http, $timeout, utilService)
  {

    /**************************************************************************
     * 
     * CONFIG
     * 
     **************************************************************************/

utilService.setMessage('VERO MIS PASTELES')


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