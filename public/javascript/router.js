define(function(require) {

    var Backbone = require('backbone');
    var HeaderView = require('views/header');
    var Pickorders = require('models/pickorders');
    var DashboardView = require('views/dashboard');
    var Pickorder = require('models/pickorder');
    var PickorderView = require('views/pickorder/pickorder');
    var CreatePickorderView = require('views/pickorder/createPickorder');

    var AppRouter = Backbone.Router.extend({
        routes: {
            "":                 "dashboard",
            "pickorders/new":   "createPickorder",
            "pickorders/:id":   "pickorder"
        },

        initialize: function() {
            var headerView = new HeaderView();
            headerView.render();
        },

        dashboard: function() {
            var pickorders = new Pickorders();
            var dashboardView = new DashboardView({ pickorders: pickorders });
            dashboardView.render();
            pickorders.fetch();
        },

        pickorder: function(id) {
            var pickorder = new Pickorder({id: id});
            pickorder.fetch({async: false});
            var pickorderView = new PickorderView({ model: pickorder });
            pickorderView.render();
        },

        createPickorder: function() {
            var pickorder = new Pickorder();
            var createPickorderView = new CreatePickorderView({model: pickorder});
            createPickorderView.render();
        }

    });

    return AppRouter;

});