define(function(require) {

    var $ = require('jquery');
    var _ = require('underscore');
    var Backbone = require('backbone');
    var CardView = require('views/cardView');

    var CardsView = Backbone.View.extend({

        el: $("#card-list"),

        initialize: function() {
            console.log(this)
            this.listenTo(this.model, "add", this.addOne);
            this.listenTo(this.model, "reset", this.addAll);
            this.listenTo(this.model, "all", this.render);

            this.model.fetch();
        },

        render: function() {
        },

        addOne: function(card) {
            console.log("addOne")
            var view = new CardView({model: card});
            this.$el.append(view.render().el);
        },

        addAll: function() {
            console.log("add all?")
        }

    });

    return CardsView;
});