var app = angular.module('myApp', ['ngRoute']);


app.factory('myService', function() {
	 var savedData = {}
	 function set(data) {
	   savedData = data;
	 }
	 function get() {
	  return savedData;
	 }

	 return {
	  set: set,
	  get: get
	 }

	});

//Application Configure to give single page facility
app.config(function($routeProvider) {
  $routeProvider

  .when('/home', {
    templateUrl : '/home',
    controller  : 'HomeController'
  })

  .when('/blog', {
    templateUrl : '/blog',
    controller  : 'BlogController'
  })

  .when('/about', {
    template : '<h2>in about</h2>',
    //controller  : 'AboutController'
  })

  .when('/login', {
	  
	  templateUrl : '/login',
	  controller : 'LoginForm'
	  
  })
  
  .when('/singup', {
	  
	  templateUrl : '/singup1',
	  controller : 'SingupForm'
	  
  })
  
  
  .otherwise({redirectTo: '/'});
});

//To display when click on Home
app.controller('HomeController', function($scope) {
	  $scope.message = 'Hello from HomeController';
	});
//To display content when click on blog
app.controller('BlogController', function($scope) {
	  $scope.message = 'Hello from BlogController';
	});
//To display content when click on About 
app.controller('AboutController', function($scope) {
	  $scope.message = 'Hello from AboutController';
	});
//To display content for login form	
app.controller('LoginForm', function($scope){

	});
//to display contet for singup form	
app.controller('SingupForm', function($scope){
	
});

//Controller for hadling make rest call for create user, login and checking email and username
app.controller("MyController",function($http,$scope,$httpParamSerializerJQLike,$location){
	
	$scope.createUser = function(){
		
		var objdata = {firstName:$scope.fname,lastName:$scope.lname,email:$scope.email,userName:$scope.uname,password:$scope.password};

		$http(
				{
					method  : 'POST',
					url     : 'http://localhost:8080/create',
					data    : objdata,
					headers : { 'Content-Type': 'application/json' }  // set the headers so angular passing info as form data (not request payload)
				} 
			 ).then
			      (
 							function (response){
								var data = response;
								//$scope.data = data	
								if(response.data == "OK"){
									//$location.path('/login');
									$scope.data = "You are registered, please login";
									//myService.set("You are registered, please login");
									//$location.path('/login');
								}
							},

							function (reason){
								$scope.errordata = reason.data;
							}	
					)
		}
	
	
		$scope.checkEmail = function(){

			var email_lower = $scope.email;
			var lower = email_lower.toLowerCase();
			var objdata = {email:lower};

			$http(
					{
						method  : 'GET',
						url     : 'http://localhost:8080/checkemail?',
						params    : objdata,
						headers : { 'Content-Type': 'application/json' }  // set the headers so angular passing info as form data (not request payload)
					} 
				 ).then
				      (
				    		  	    function (response){
									var data = response;
									//$scope.data = data	
									if($scope.data.data == "FOUND")
									{
										$scope.message = "email is already exit, please use other mail id";
										alert($scope.message)
									}
									if($scope.data.data == "NOT_FOUND"){
										$scope.message = "email is not present";
									}
								},

								function (reason){
									$scope.errordata = reason.data;
								}	
				      )
	}
		
		
		$scope.checkUserName = function(){
			
			var objdata = {username:$scope.uname};
			$http(
					{
						method  : 'GET',
						url     : 'http://localhost:8080/checkusername?',
						params    : objdata,
						headers : { 'Content-Type': 'application/json' }  // set the headers so angular passing info as form data (not request payload)
					} 
				 ).then
				      (
				    		  	    function (response){
									var data = response;
									//$scope.data = data	
									if($scope.data.data == "FOUND")
									{
										$scope.message = "username is already exit, please use different username! :)";
										alert($scope.message);
									}
									if($scope.data.data == "NOT_FOUND"){
										$scope.message = "usrname is not present";
									}
								},

								function (reason){
									$scope.errordata = "In Exception"//reason.data;
								}	
				      )
	}
	
	$scope.authenticateUser = function(){
		var objdata = {userName:$scope.uname,password:$scope.password};
		
		$http(
				{
					method  : 'POST',
					url     : 'http://localhost:8080/login1',
					data    : objdata,
					headers : { 'Content-Type': 'application/json' }  // set the headers so angular passing info as form data (not request payload)
				} 
			 ).then
			      (
 							function (response){
								var data = response;
								$scope.data = data	
								
							},

							function (reason){
								$scope.errordata = reason.data;
							}	
					)
		
	}
		

		
});






