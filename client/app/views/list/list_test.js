'use strict';

describe('myApp.view1 module', function() {

  beforeEach(module('myApp.list'));

  describe('view1 controller', function(){

    it('should ....', inject(function($controller) {
      //spec body
      var view1Ctrl = $controller('ListController');
      expect(view1Ctrl).toBeDefined();
    }));

  });
});