define(function(require) {

    var $ = require('jquery');
    var Backbone = require('backbone');
    var PickorderListItemView = require('views/pickorder/pickorderListItem');

    var PickorderListView = Backbone.View.extend({
        tagName: 'ul',

        initialize: function() {
            this.listenTo(this.collection, "reset", this.addAll());
            this.listenTo(this.collection, "add", this.addOne);
        },

        addAll: function() {
            this.collection.forEach(this.addOne, this);
        },

        addOne: function(pickorderListItem) {
            var view = new PickorderListItemView({model: pickorderListItem});
            this.$el.append(view.render().el);
        },

        render: function() {
            return this;
        }

    });

    return PickorderListView;
});