<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<script src="resources/js/register.js"></script>

</head>
<body ng-app="registration" ng-controller="ctrl">
	<div class="container mt-4">
		<form ng-show="showForm">
			<div class="form-group row">
				<label for="staticEmail" class="col-sm-2 col-form-label">Email</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" ng-model="email">
				</div>
			</div>

			<div class="form-group row">
				<label for="staticEmail" class="col-sm-2 col-form-label">Password</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" ng-model="password">
				</div>
			</div>

			<div class="form-group row">
				<label for="staticEmail" class="col-sm-2 col-form-label">Gender</label>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="gender"
						ng-model="gender" value="M"> <label
						class="form-check-label" for="inlineRadio1">male</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="gender"
						ng-model="gender" value="F"> <label
						class="form-check-label" for="inlineRadio2">female</label>
				</div>
			</div>

			<div class="form-group row">
				<label for="staticEmail" class="col-sm-2 col-form-label">Address</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" ng-model="address">
				</div>
			</div>

			<div class="form-group row">
				<label for="staticEmail" class="col-sm-2 col-form-label">Phone</label>
				<div class="col-sm-10">
					<input type="number" class="form-control" ng-model="phone">
				</div>
			</div>

			<button ng-click="onSaveForm()" class="btn btn-primary">submit</button>
		</form>

		<div ng-repeat="x in listArray" ng-show="showList">
			<div id="accordion" class="ac1">
				<div class="card">
					<div class="card-header">
						<a class="card-link" data-toggle="collapse"
							href="#collapseOne{{$index}}" ng-click="onClickShow(x.id)">
							{{x.email}} </a>
					</div>
					<div id="collapseOne{{$index}}" class="collapse"
						data-parent="#accordion">
						<div class="card-body">
						<div class="row">
						<div class="col-md-8">
							<form ng-submit="onSaveSubForm()">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Treament Name</label>
									<div class="col-sm-5">
										<input type="text" class="form-control"
											ng-model="subform.name">
									</div>
								</div>
								<div class="form-group row">
									<label for="staticEmail" class="col-sm-4 col-form-label">Treatment
										Type</label>
									<div class="col-sm-5">
										<input type="text" class="form-control"
											ng-model="subform.type">
									</div>
								</div>
								<div class="form-group row">
									<label for="staticEmail" class="col-sm-4 col-form-label">Treated
										By</label>
									<div class="col-sm-5">
										<input type="text" class="form-control"
											ng-model="subform.treatedBy">
									</div>
								</div>
								<button class="btn btn-primary btn-sm">submit</button>
							</form>
							</div>
							<div class="col-md-4">
							<table class="table table-responsive table-bodered table-hover">
							<tr>
							<th>Name</th>
							<th>Type</th>
							<th>Doctor</th>
							</tr>
							<tr ng-repeat="y in treatArray">
							<td>{{y.name}}</td>
							<td>{{y.type}}</td>
							<td>{{y.treatedBy}}</td>
							<td><a href="#" ng-click="onEditTreatment(y)">edit</a></td>
							<td><a href="#" ng-click="onDeleteTreatment(y,$index)">delete</a></td>
							</tr>
							</table>
							</div>
						</div>
						</div>
					</div>
				</div>


			</div>
		</div>



		<div class="text-center">
			<button ng-click="onshowForm()" ng-show="showList"
				class="btn btn-primary mt-4">Add New Record</button>
			<!-- accordian end -->







		</div>

	</div>
</body>
</html>
