require.config({
    paths: {
        jquery: 'libs/jquery-2.0.3.min',
        underscore: 'libs/underscore',
        backbone: 'libs/backbone',
        mustache: 'libs/mustache',
        text: 'libs/text'
    },

    shim: {
        'underscore': {
            exports: '_'
        },

        'backbone': {
            deps: ['jquery','underscore'],
            exports: 'Backbone'
        }
    }

});

define(function(require) {

    var Backbone = require('backbone');
    var AppRouter = require('router');

    new AppRouter();
    Backbone.history.start();

});
