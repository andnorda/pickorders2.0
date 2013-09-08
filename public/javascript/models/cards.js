define(function(require) {

    var Backbone = require('backbone');
    var Card = require('models/card');

    var Cards = Backbone.Collection.extend({
        model: Card,
        url: "/api/cards"
    });

    return Cards;

});