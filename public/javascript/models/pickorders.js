define(function(require) {

    var Backbone = require('backbone');
    var Pickorder = require('models/pickorder');

    var Pickorders = Backbone.Collection.extend({
        model: Pickorder,
        url: "/api/pickorders"
    });

    return Pickorders;

});