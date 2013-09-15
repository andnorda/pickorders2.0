define(function(require) {

    var $ = require('jquery');
    var Backbone = require('backbone');
    var Mustache = require('mustache');
    var PickorderTemplate = require('text!/assets/templates/pickorder.html');

    var PickorderView = Backbone.View.extend({
        el: $(".content"),

        render: function() {
            var template = Mustache.render(PickorderTemplate, {
                pickorder: this.model.attributes
            });
            this.$el.html(template);
        }
    });

    return PickorderView;
});