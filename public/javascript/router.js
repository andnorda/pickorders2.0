define(function(require) {

    var Backbone = require('backbone');
    var Cards = require('models/cards');
    var CardsView = require('views/cardsView')

    var AppRouter = Backbone.Router.extend({
        routes: {
            "": "cards"
        },

        initialize: function() {
            this.cardsView = null;
        },

        cards: function() {
            if (!this.cardsView) {
                this.cardsView = new CardsView({
                    model: new Cards()
                });
            }
        }
    });

    return AppRouter;

});