define(function(require) {

    var Backbone = require('backbone');
    var Mustache = require('mustache');
    var HeaderTemplate = require('text!/assets/templates/header.html');

    var HeaderView = Backbone.View.extend({
        el: $('header'),

        render: function() {
            var template = Mustache.render(HeaderTemplate);
            this.$el.html(template);
        }
    });

    return HeaderView;
})