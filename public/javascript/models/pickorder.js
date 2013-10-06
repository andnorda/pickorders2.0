define(function(require) {

    var Backbone = require('backbone');

    var PickorderCard = Backbone.Model.extend({

    });

    var PickorderCards = Backbone.Collection.extend({
        model: PickorderCard,

        comparator: function(pickorderCard) {
            return pickorderCard.get("rank");
        }
    });

    var Pickorder = Backbone.Model.extend({
        urlRoot: "/api/pickorders",

        parse: function(response) {
            response.pickorderCards = new PickorderCards();
            for (var i = 0; i < response.cards.length; i++) {
                response.pickorderCards.add(new PickorderCard(response.cards[i]));
            }

            return response;
        },

        checkbox: function(attribute, isChecked, value) {
            if (isChecked) {
                this.set(attribute, this.get(attribute) + value)
            } else {
                this.set(attribute, this.get(attribute).replace(value, ""));
            }
        }

    });

    return Pickorder;
});