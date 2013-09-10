define(function(require) {

    var $ = require('jquery');
    var _ = require('underscore');
    var Backbone = require('backbone');
    var CardView = require('views/cardView');

    var CardsView = Backbone.View.extend({
        el: $("#main"),
        template: _.template("<ul id=\"card-list\"></ul>"),

        initialize: function() {
            this.listenTo(this.collection, "reset", this.render);
        },

        render: function() {
            this.$el.html(this.template);
            this.addAll();
            return this;
        },

        addOne: function(card) {
            var view = new CardView({model: card});
            this.$("#card-list").append(view.render().el);
        },

        addAll: function() {
            this.collection.forEach(this.addOne, this);
        }

    });

    return CardsView;
});