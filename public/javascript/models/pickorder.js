define(function(require) {

    var Backbone = require('backbone');

    var Pickorder = Backbone.Model.extend({
        urlRoot: "/api/pickorders"
    });

    return Pickorder;
});