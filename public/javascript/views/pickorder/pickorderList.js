define(function(require) {

    var $ = require('jquery');
    var Backbone = require('backbone');
    var PickorderListItemView = require('views/pickorder/pickorderListItem');

    var PickorderListView = Backbone.View.extend({
        tagName: 'ul',

        initialize: function() {
            this.listenTo(this.collection, "reset", this.render);
            this.listenTo(this.collection, "add", this.addOne);
        },

        addAll: function() {
            this.collection.forEach(this.addOne, this);
        },

        addOne: function(card) {
            var view = new PickorderListItemView({model: card});
            this.$el.append(view.render().el);
        },

        render: function() {
            return this;
        }

    });

    return PickorderListView;
});