define(function(require) {

    var $ = require('jquery');
    var _ = require('underscore');
    var Backbone = require('backbone');

    var CardView = Backbone.View.extend({
        tagName: "li",
        template: _.template("<img src=\"http://gatherer.wizards.com/Handlers/Image.ashx?type=card&name=<%- name %>\">"),

        render: function() {
            this.$el.html(this.template(this.model.toJSON()));
            return this;
        }
    });

    return CardView;
});