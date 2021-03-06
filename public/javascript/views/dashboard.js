define(function(require) {

    var $ = require('jquery');
    var Backbone = require('backbone');
    var Mustache = require('mustache');
    var PickorderListView = require('views/pickorder/pickorderList');
    var DashboardTemplate = require('text!/assets/templates/dashboard.html');

    var DashboardView = Backbone.View.extend({
        el: $(".content"),

        events: {
            "click .new-pickorder": "createPickorder"
        },

        initialize: function(options) {
            this.pickorderListView = new PickorderListView({
                collection: options.pickorders
            });
        },

        createPickorder: function() {
            Backbone.history.navigate("#pickorders/new", {trigger: true})
        },

        render: function() {
            var template = Mustache.render(DashboardTemplate);
            this.$el.html(template);

            this.$('.pickorder-list').html(this.pickorderListView.render().el);
        }
    });

    return DashboardView;
});