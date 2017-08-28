app.controller('ng-app-controller-template1', ['$scope', '$http', function ($scope,
  $http)
  {
    console.log('1')
    $scope.mensaje = 'Texto cargado desde el controlador Pagina1Controller';

    $http.post('/test',
    {
      text: 'hello'
    })
    .then(function (response)
    {
      console.log(response.data)
    });

  }]);