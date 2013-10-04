    define(function(require) {

    var Backbone = require('backbone');

    var Pickorder = Backbone.Model.extend({
        urlRoot: "/api/pickorders",

        checkbox: function(attribute, isChecked, value) {
            if (isChecked) {
                this.set(attribute, this.get(attribute) + value)
            } else {
                this.set(attribute, this.get(attribute).replace(value, ""));
            }
        }

    });

    return Pickorder;
});