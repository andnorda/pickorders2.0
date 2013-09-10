define(function(require) {

    var $ = require('jquery');
    var _ = require('underscore');
    var Backbone = require('backbone');

    var CardView = Backbone.View.extend({
        el: $("#main"),
        template: _.template("<ul><li><a href='#' id='cards'>cards</button></li></ul>"),

        events: {
            "click #cards": "cards"
        },

        render: function() {
            this.$el.html(this.template);
            return this;
        },

        cards: function() {
            Backbone.history.navigate("cards", {trigger: true})
        }
    });

    return CardView;
});