define(function(require) {

    var Backbone = require('backbone');
    var HeaderView = require('views/header');
    var Pickorders = require('models/pickorders');
    var Cards = require('models/cards');
    var DashboardView = require('views/dashboard');
    var CardsView = require('views/card/cards');

    var AppRouter = Backbone.Router.extend({
        routes: {
            "": "index",
            "cards": "cards"
        },

        initialize: function() {
            var headerView = new HeaderView();
            headerView.render();
        },

        index: function() {
            if (!this.dashboardView) {
                this.pickorders = new Pickorders();
                this.dashboardView = new DashboardView({
                    pickorders: this.pickorders
                });
            }
            this.dashboardView.render();
            this.pickorders.fetch();
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