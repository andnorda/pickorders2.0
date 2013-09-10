define(function(require) {

    var Backbone = require('backbone');
    var Cards = require('models/cards');
    var IndexView = require('views/indexView');
    var CardsView = require('views/cardsView');

    var AppRouter = Backbone.Router.extend({
        routes: {
            "": "index",
            "cards": "cards"
        },

        initialize: function() {
        },

        index: function() {
            if (!this.indexView) {
                this.indexView = new IndexView();
            }
            this.indexView.render();
        },

        cards: function() {
            if (!this.cardsView) {
                this.cardCollection = new Cards();
                this.cardsView = new CardsView({
                    collection: this.cardCollection
                });
            }
            this.cardCollection.fetch({reset: true});
        }
    });

    return AppRouter;

});