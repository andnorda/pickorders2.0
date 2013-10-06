define(function(require) {

    var $ = require('jquery');
    var Backbone = require('backbone');
    var Mustache = require('mustache');
    var PickorderTemplate = require('text!/assets/templates/pickorder.html');

    var PickorderView = Backbone.View.extend({
        el: $(".content"),

        events: {
            "click img": "click"
        },

        click: function(event) {
            var target = $(event.target).closest('li');
            var targetRank = target.data("rank");
            var targetId = target.data("id");
            if (targetRank > 0) {
                //change model
                var aboveTarget = target.closest('ul').find('li:eq(' + (targetRank-1) + ')');
                var aboveTargetRank = aboveTarget.data("rank");
                var aboveTargetId = aboveTarget.data("id");

                //save
                this.model.save({rank: targetRank, newRank: aboveTargetRank}, {patch: true});

                //update view?
                console.log("targetId" + targetId)
                console.log("aboveTargetId" + aboveTargetId)
                target.after(aboveTarget);
                target.data("rank", aboveTargetRank);
                aboveTarget.data("rank", targetRank);
            }


        },

        render: function() {
            var template = Mustache.render(PickorderTemplate, {
                pickorder: this.model.attributes
            });
            this.$el.html(template);
        }
    });

    return PickorderView;
});