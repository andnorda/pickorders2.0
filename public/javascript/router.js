define(function(require) {

    var Backbone = require('backbone');
    var Cards = require('models/cards');
    var DashboardView = require('views/dashboardView');
    var CardsView = require('views/cardsView');

    var AppRouter = Backbone.Router.extend({
        routes: {
            "": "index",
            "cards": "cards"
        },

        initialize: function() {
        },

        index: function() {
            if (!this.dashboardView) {
                this.dashboardView = new DashboardView();
            }
            this.dashboardView.render();
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