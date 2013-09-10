define(function(require) {

    var $ = require('jquery');
    var Backbone = require('backbone');
    var Mustache = require('mustache');
    var CardTemplate = require('text!/assets/templates/cardTemplate.html');

    var CardView = Backbone.View.extend({
        tagName: "li",

        render: function() {
            var template = Mustache.render(CardTemplate, { card: this.model.attributes })
            this.$el.html(template);
            return this;
        }
    });

    return CardView;
});