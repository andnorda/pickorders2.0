define(function(require) {

    var $ = require('jquery');
    var Backbone = require('backbone');
    var Mustache = require('mustache');
    var DashboardTemplate = require('text!/assets/templates/dashboardTemplate.html');

    var DashboardView = Backbone.View.extend({
        el: $("#main"),

        events: {
            "click #cards": "cards"
        },

        render: function() {
            var template = Mustache.render(DashboardTemplate);
            this.$el.html(template);
        },

        cards: function(event) {
            event.preventDefault();
            Backbone.history.navigate("cards", {trigger: true})
        }
    });

    return DashboardView;
});