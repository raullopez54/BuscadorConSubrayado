app.factory('utilFactory', function ()
{
  var service =
  {
    contTestBBDD: 0,
    getContTestBBDD: function ()
    {
      return this.contTestBBDD;
    },
    setContTestBBDD: function (contTestBBDD)
    {
      this.contTestBBDD = contTestBBDD;
    },

    contSearchItems: 0,
    getContSearchItems: function ()
    {
      return this.contSearchItems;
    },
    setContSearchItems: function (contSearchItems)
    {
      this.contSearchItems = contSearchItems;
    }
  };

  return service;
});