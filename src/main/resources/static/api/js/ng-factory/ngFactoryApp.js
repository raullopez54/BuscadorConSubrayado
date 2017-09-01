app.factory('utilService', function ()
{
  var service =
  {
    message: 0,
    getMessage: function ()
    {
      return this.message;
    },
    setMessage: function (msg)
    {
      this.message = msg;
    }
  };

  return service;
});