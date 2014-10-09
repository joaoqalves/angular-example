'use strict';

angular.module('myApp.list', ['ngRoute', 'restangular'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/todo', {
    templateUrl: 'views/list/list.html',
    controller: 'ListController'
  });
}])
.config(['RestangularProvider', function(RestangularProvider) {
	RestangularProvider.setBaseUrl('http://192.168.3.67:8080/todo');
	RestangularProvider.setDefaultHeaders({'Content-Type': 'application/json'});
}])
.controller('ListController', ['Restangular', '$scope', function(Restangular, $scope) {

	$scope.tasks = [];
	Restangular.all('').getList()
		.then(function(tasks) {
			$scope.tasks = Restangular.stripRestangular(tasks);
		});

	$scope.newTask = {
		title: ""
	};

	var reOrder = function() {
		Restangular.all('reorder').customPUT($scope.tasks)
			.then(function(tasks) {
				$scope.tasks = Restangular.stripRestangular(tasks);
		});
	};

	$scope.up = function(task) {
		var position = $scope.tasks.indexOf(task);
		$scope.tasks[position] = $scope.tasks[position-1];
		$scope.tasks[position-1] = task;
		reOrder();
	};

	$scope.down = function(task) {
		var position = $scope.tasks.indexOf(task);
		$scope.tasks[position] = $scope.tasks[position+1];
		$scope.tasks[position+1] = task;
		reOrder();

	};

	$scope.add = function() {
		if($scope.newTask.title.trim() === "")
			alert('ahf');
		Restangular.one('add').customPOST($scope.newTask)
			.then(function(tasks) {
				$scope.tasks = Restangular.stripRestangular(tasks);
				$scope.newTask.title = "";
			});
	}

	$scope.remove = function(task) {
		Restangular.one('remove', task.id).customDELETE()
			.then(function(tasks) {
				$scope.tasks = Restangular.stripRestangular(tasks);
			});
	};

}]);