define(function(require) {

    var $ = require('jquery');
    var _ = require('underscore');
    var Backbone = require('backbone');

    var CardView = Backbone.View.extend({
        tagName: "li",
        template: _.template($("#card-template").html()),

        render: function() {
            this.$el.html(this.template(this.model.toJSON()));
            return this;
        }
    });

    return CardView;
});