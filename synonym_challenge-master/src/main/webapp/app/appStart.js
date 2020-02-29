(function () {
    'use strict';

    var sc = angular.module('sc', [ 'ui.router']);

    sc.config(function ($stateProvider) {
        var loginState = {
            name: 'login',
            url: '/login',
            templateUrl: 'app/login/login.html',
            controller: 'loginController as lgnCtrl'
        }

        var registerState = {
            name: 'register',
            url: '/register',
            templateUrl: 'app/registration/registration.html',
            controller: 'registrationController as regCtrl'
        }

        var dashboardState = {
            name: 'dashboard',
            url: '/dashboard',
            templateUrl: 'app/dashboard/dashboard.html',
            controller: 'dashboardController as dashCtrl'
        }

        var playerState = {
            name: 'results',
            url: '/results/:gameId',
            templateUrl: 'app/player/player.html',
            controller: 'playerController as playCtrl'
        }


        $stateProvider.state(loginState);
        $stateProvider.state(registerState);
        $stateProvider.state(dashboardState);
        $stateProvider.state(playerState);
    });

})();