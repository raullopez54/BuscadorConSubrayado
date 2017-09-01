app.factory('utilService', function ()
{
  var service =
  {
    message: 'MSG...',
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