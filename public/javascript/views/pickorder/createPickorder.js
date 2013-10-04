define(function(require) {

    var $ = require('jquery');
    var Backbone = require('backbone');
    var Mustache = require('mustache');
    var CreatePickorderTemplate = require('text!/assets/templates/createPickorder.html')

    var CreatePickorderView = Backbone.View.extend({
        el: $(".content"),

        events: {
            "input":        "input",
            "change":       "input",
            "submit form":  "create"
        },

        initialize: function() {
            this.model.set({
                name: "New pickorder",
                colors: "",
                rarities: ""
            })
        },

        input: function(event) {
            var attribute = $(event.target).attr("name");
            var type = $(event.target).attr("type");
            var value = $(event.target).val();
            var isChecked = $(event.target).is(':checked');

            if(attribute == "name") {
                this.model.set({name: value});
            } else if (type == "checkbox") {
                this.model.checkbox(attribute, isChecked, value);
            }
        },

        create: function(e) {
            e.preventDefault();
            this.model.save();
        },

        render: function() {
            var template = Mustache.render(CreatePickorderTemplate);
            this.$el.html(template);
        }
    });

    return CreatePickorderView;
});