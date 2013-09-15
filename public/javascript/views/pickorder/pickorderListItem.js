define(function(require) {

    var $ = require('jquery');
    var Backbone = require('backbone');
    var Mustache = require('mustache');
    var PickorderListItemTemplate = require('text!/assets/templates/pickorderListItem.html');

    var PickorderListItemView = Backbone.View.extend({
        tagName: "li",

        render: function() {
            var template = Mustache.render(PickorderListItemTemplate, { pickorderListItem: this.model.attributes })
            this.$el.html(template);
            return this;
        }
    });

    return PickorderListItemView;
});