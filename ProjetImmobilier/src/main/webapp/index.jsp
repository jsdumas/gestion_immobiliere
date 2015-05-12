<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form"%> <%@ taglib prefix="fmt"
uri="http://java.sun.com/jsp/jstl/fmt"%> <%@ taglib prefix="sec"
uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="fr">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>Real estate - Bootstrap</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">


<link id="switch_style" href="css/real_estate.css" rel="stylesheet">

<!--[if lt IE 9]>
		<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->

</head>

<body>

	<jsp:include page="header.jsp"></jsp:include>
	
	<jsp:include page="nav.jsp"></jsp:include>
	
	

		<div class="row">

			<div class="span4 well lform">
				<!-- 		<form  action="listings.html"> -->

				<form:form class="form-inline" action="" commandName="searchDTO"
					method="POST">
					<fieldset>
						<div class="row">
							<div class="span4">

								<div class="row">
									<div class="span2">
										<div class="control-group">
											<label for="focusedInput" class="control-label">Ville</label>

											<div class="controls">

												<form:select id="communes" class="input-medium focused"
													path="commune">
													<form:option value="" label="--- Selectionner Communes ---" />
													<form:options class="communeItem" items="${allCommunes}"
														itemValue="nomCommune" itemLabel="nomCommune" />
												</form:select>
											</div>
										</div>
									</div>



									<div class="span2 ">
										<label for="focusedInput" class="control-label">Quartier</label>
										<div class="controls">
											<form:select id="quartiers" class="input-medium focused"
												path="quartier">
												<form:option value="" label="--- Selectionner Quartiers ---" />
												<form:options class="quartierItem" items="${allQuartiers}"
													itemValue="libelleQuartier" itemLabel="libelleQuartier" />
											</form:select>
										</div>
									</div>
								</div>
								
								
								
								
								<div class="row">
									<div class="span2">
										<div class="control-group">
											<label for="focusedInput" class="control-label">Loyer minimum</label>
											<div class="controls">
												<form:select id="prixMin" class="input-medium focused"
													path="prixMin">
													<form:option value="" label="--- Selectionner un prix minimum ---" />
													<form:options class="prixMinItem" items="${prixMin}"/>
												</form:select>
											</div>
										</div>
									</div>



									<div class="span2 ">
										<label for="focusedInput" class="control-label">Loyer maximum</label>
										<div class="controls">
											<form:select id="prixMax" class="input-medium focused" path="prixMax">
<%--  												<form:option value="" label="--- Selectionner un prix maximum ---" /> --%>
<%--  												<form:options class="prixMaxItem" items="${prixMin}" /> --%>
 											</form:select>
										</div>
									</div>
								</div>



							</div>


							<div class="row">
								<!-- 							<input type="submit"> -->

								<div class="span2 pull-right" style="margin-top: 10px;">
									<button class="btn btn-primary pull-right" type="submit">Search</button>

								</div>
							</div>
						</div>
					</fieldset>
				</form:form>


				<!-- 			<fieldset> -->
				<!-- 				<div class="row"> -->
				<!-- 				<div class="span4"> -->
				<!-- 						<div class="control-group"> -->
				<!-- 							<label for="focusedInput" class="control-label">Location</label> -->
				<!-- 							<div class="controls"> -->
				<!-- 								<input type="text" value="" placeholder="Where do you want to live?" id="focusedInput" class="input-xlarge"> -->
				<!-- 							</div> -->
				<!-- 						</div>	 -->



<!-- 				<div class="row"> -->
<!-- 					<div class="span2"> -->
<!-- 						<div class="control-group"> -->
<!-- 							<label for="focusedInput" class="control-label">Number of -->
<!-- 								bedrooms:</label> -->
<!-- 							<div class="controls"> -->
<!-- 								<select class="input-medium focused"> -->
<!-- 									<option>Any</option> -->
<!-- 									<option>1</option> -->
<!-- 									<option>2</option> -->
<!-- 									<option>3</option> -->
<!-- 									<option>4</option> -->
<!-- 									<option>5+</option> -->
<!-- 								</select> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="span2"> -->
<!-- 						<label for="focusedInput" class="control-label">Rent or -->
<!-- 							Buy</label> -->
<!-- 						<div class="controls"> -->
<!-- 							<select class="input-medium focused"> -->
<!-- 								<option>Any</option> -->
<!-- 								<option>Rent</option> -->
<!-- 								<option>Buy</option> -->
<!-- 							</select> -->
<!-- 						</div> -->
<!-- 					</div> -->

<!-- 				</div> -->
<!-- 				<div class="row"> -->
<!-- 					<div class="span2"> -->
<!-- 						<div class="control-group"> -->
<!-- 							<label for="focusedInput" class="control-label">Minimum -->
<!-- 								Price</label> -->
<!-- 							<div class="controls"> -->
<!-- 								<select class="input-medium focused"> -->
<!-- 									<option selected="selected" value="">No min</option> -->
<!-- 									<option value="50000">50,000</option> -->
<!-- 									<option value="60000">60,000</option> -->
<!-- 									<option value="70000">70,000</option> -->
<!-- 									<option value="80000">80,000</option> -->
<!-- 									<option value="90000">90,000</option> -->
<!-- 									<option value="100000">100,000</option> -->
<!-- 									<option value="110000">110,000</option> -->
<!-- 									<option value="120000">120,000</option> -->
<!-- 									<option value="125000">125,000</option> -->
<!-- 									<option value="130000">130,000</option> -->
<!-- 									<option value="140000">140,000</option> -->
<!-- 									<option value="150000">150,000</option> -->
<!-- 									<option value="160000">160,000</option> -->
<!-- 									<option value="170000">170,000</option> -->
<!-- 									<option value="175000">175,000</option> -->
<!-- 									<option value="180000">180,000</option> -->
<!-- 									<option value="190000">190,000</option> -->
<!-- 									<option value="200000">200,000</option> -->
<!-- 									<option value="210000">210,000</option> -->
<!-- 									<option value="220000">220,000</option> -->
<!-- 									<option value="230000">230,000</option> -->
<!-- 									<option value="240000">240,000</option> -->
<!-- 									<option value="250000">250,000</option> -->
<!-- 									<option value="260000">260,000</option> -->
<!-- 									<option value="270000">270,000</option> -->
<!-- 									<option value="280000">280,000</option> -->
<!-- 									<option value="290000">290,000</option> -->
<!-- 									<option value="300000">300,000</option> -->
<!-- 									<option value="325000">325,000</option> -->
<!-- 									<option value="350000">350,000</option> -->
<!-- 									<option value="375000">375,000</option> -->
<!-- 									<option value="400000">400,000</option> -->
<!-- 									<option value="425000">425,000</option> -->
<!-- 									<option value="450000">450,000</option> -->
<!-- 									<option value="475000">475,000</option> -->
<!-- 									<option value="500000">500,000</option> -->
<!-- 									<option value="550000">550,000</option> -->
<!-- 									<option value="600000">600,000</option> -->
<!-- 									<option value="650000">650,000</option> -->
<!-- 									<option value="700000">700,000</option> -->
<!-- 									<option value="800000">800,000</option> -->
<!-- 									<option value="900000">900,000</option> -->
<!-- 									<option value="1000000">1,000,000</option> -->
<!-- 									<option value="1500000">1,500,000</option> -->
<!-- 									<option value="2000000">2,000,000</option> -->
<!-- 									<option value="3000000">3,000,000</option> -->
<!-- 									<option value="">No min</option> -->
<!-- 								</select> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="span2"> -->
<!-- 						<label for="focusedInput" class="control-label">Maximum -->
<!-- 							Price</label> -->
<!-- 						<div class="controls"> -->
<!-- 							<select class="input-medium focused"> -->
<!-- 								<option selected="selected" value="">No min</option> -->
<!-- 								<option value="50000">50,000</option> -->
<!-- 								<option value="60000">60,000</option> -->
<!-- 								<option value="70000">70,000</option> -->
<!-- 								<option value="80000">80,000</option> -->
<!-- 								<option value="90000">90,000</option> -->
<!-- 								<option value="100000">100,000</option> -->
<!-- 								<option value="110000">110,000</option> -->
<!-- 								<option value="120000">120,000</option> -->
<!-- 								<option value="125000">125,000</option> -->
<!-- 								<option value="130000">130,000</option> -->
<!-- 								<option value="140000">140,000</option> -->
<!-- 								<option value="150000">150,000</option> -->
<!-- 								<option value="160000">160,000</option> -->
<!-- 								<option value="170000">170,000</option> -->
<!-- 								<option value="175000">175,000</option> -->
<!-- 								<option value="180000">180,000</option> -->
<!-- 								<option value="190000">190,000</option> -->
<!-- 								<option value="200000">200,000</option> -->
<!-- 								<option value="210000">210,000</option> -->
<!-- 								<option value="220000">220,000</option> -->
<!-- 								<option value="230000">230,000</option> -->
<!-- 								<option value="240000">240,000</option> -->
<!-- 								<option value="250000">250,000</option> -->
<!-- 								<option value="260000">260,000</option> -->
<!-- 								<option value="270000">270,000</option> -->
<!-- 								<option value="280000">280,000</option> -->
<!-- 								<option value="290000">290,000</option> -->
<!-- 								<option value="300000">300,000</option> -->
<!-- 								<option value="325000">325,000</option> -->
<!-- 								<option value="350000">350,000</option> -->
<!-- 								<option value="375000">375,000</option> -->
<!-- 								<option value="400000">400,000</option> -->
<!-- 								<option value="425000">425,000</option> -->
<!-- 								<option value="450000">450,000</option> -->
<!-- 								<option value="475000">475,000</option> -->
<!-- 								<option value="500000">500,000</option> -->
<!-- 								<option value="550000">550,000</option> -->
<!-- 								<option value="600000">600,000</option> -->
<!-- 								<option value="650000">650,000</option> -->
<!-- 								<option value="700000">700,000</option> -->
<!-- 								<option value="800000">800,000</option> -->
<!-- 								<option value="900000">900,000</option> -->
<!-- 								<option value="1000000">1,000,000</option> -->
<!-- 								<option value="1500000">1,500,000</option> -->
<!-- 								<option value="2000000">2,000,000</option> -->
<!-- 								<option value="3000000">3,000,000</option> -->
<!-- 								<option value="">No min</option> -->
<!-- 							</select> -->
<!-- 						</div> -->
<!-- 					</div> -->

<!-- 				</div> -->




<jsp:include page="caroussel.jsp"></jsp:include>





			</div>
		</div>

		<div class="row">
			<div class="span4">
				<h3>
					<span>Latest</span> properties
				</h3>
				<a href="map_properties.html"><img
					src="css/images/latest_properties.jpg" alt="" /></a>
				<p>
					Sign up for our weekly newsletter and stay up-to-date with the
					latest offers, and newest products.<a href="map_properties.html"
						class="pull-right">more...</a>
				</p>
			</div>
			<div class="span4">
				<h3>
					<span>New</span> homes
				</h3>
				<a href="listings.html"><img src="css/images/new_homes.png"
					alt="" /></a>
				<p>
					Sign up for our weekly newsletter and stay up-to-date with the
					latest offers, and newest products.<a href="listings.html"
						class="pull-right">more...</a>
				</p>
			</div>
			<div class="span4">
				<h3>
					<span>Homes</span> abroad
				</h3>
				<a href="listings.html"><img src="css/images/homes_abroad.png"
					alt="" /></a>
				<p>
					Sign up for our weekly newsletter and stay up-to-date with the
					latest offers, and newest products.<a href="listings.html"
						class="pull-right">more...</a>
				</p>
			</div>
		</div>



		<div class="row">
			<br />
			<div class="span4">
				<h3>
					<span>Popular</span> cities
				</h3>


				<div id="home_map_canvas"></div>



			</div>
			<div class="span8">
				<h3>
					<span>Featured</span> listings
				</h3>

				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>Description</th>
							<th>Region</th>
							<th>Price</th>
							<th>Days on market</th>
							<th>&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><a href="property.html">8 bedroom house for sale</a></td>
							<td>London</td>
							<td>&pound;39,950,000</td>
							<td>1 day</td>
							<td><a href="property.html">View</a></td>
						</tr>
						<tr>
							<td><a href="property.html">2 bedroom bungalow for sale</a></td>
							<td>London</td>
							<td>&pound;215,000</td>
							<td>3 days</td>
							<td><a href="property.html">View</a></td>
						</tr>
						<tr>
							<td><a href="property.html">3 bedroom house for sale</a></td>
							<td>London</td>
							<td>&pound;470,000</td>
							<td>2 weeks</td>
							<td><a href="property.html">View</a></td>
						</tr>
						<tr>
							<td><a href="property.html">3 bedroom house for rent</a></td>
							<td>London</td>
							<td>&pound;1,000pm</td>
							<td>1 month</td>
							<td><a href="property.html">View</a></td>
						</tr>
						<tr>
							<td><a href="property.html">6 bedroom house for sale</a></td>
							<td>London</td>
							<td>&pound;19,950,000</td>
							<td>2 months</td>
							<td><a href="property.html">View</a></td>
						</tr>
						<tr>
							<td><a href="property.html">5 bedroom bungalow for sale</a></td>
							<td>London</td>
							<td>&pound;950pm</td>
							<td>3 months</td>
							<td><a href="property.html">View</a></td>
						</tr>
						<tr>
							<td><a href="property.html">3 bedroom house for sale</a></td>
							<td>London</td>
							<td>&pound;470,000</td>
							<td>1 year</td>
							<td><a href="property.html">View</a></td>
						</tr>

					</tbody>
				</table>
				More cities : <a href="map_properties.html">London</a>, <a
					href="map_properties.html">Scotland</a>, <a
					href="map_properties.html">Wales</a>, <a href="map_properties.html">Northern
					Ireland</a>, <a href="map_properties.html">Birmingham</a>, <a
					href="map_properties.html">Leeds</a>, <a href="map_properties.html">Glasgow</a>,
				<a href="map_properties.html">Sheffield</a>, <a
					href="map_properties.html">Bradford</a>, <a
					href="map_properties.html">Edinburgh</a>, <a
					href="map_properties.html">Liverpool</a>, <a
					href="map_properties.html">Manchester</a>

			</div>

		</div>

		
		
		<jsp:include page="footer.jsp"></jsp:include>
		

	</div>
	<!-- /container -->


<!-- 	<div id="theme_switcher"> -->
<!-- 		<div class="btn-group"> -->
<!-- 			<a class="btn btn-success dropdown-toggle" data-toggle="dropdown" -->
<!-- 				href="#">Switch theme <span class="caret"></span></a> -->
<!-- 			<ul class="dropdown-menu"> -->
<!-- 				<li><a href="#" data-rel="real_estate">Real Estate</a></li> -->
<!-- 				<li><a href="#" data-rel="cerulean">Cerulean</a></li> -->
<!-- 				<li><a href="#" data-rel="slate">Slate</a></li> -->
<!-- 				<li><a href="#" data-rel="united">United</a></li> -->
<!-- 				<li><a href="#" data-rel="cyborg">Cyborg</a></li> -->
<!-- 				<li><a href="#" data-rel="spacelab">Spacelab</a></li> -->
<!-- 				<li><a href="#" data-rel="journal">Journal</a></li> -->
<!-- 				<li><a href="#" data-rel="simplex">Simplex</a></li> -->
<!-- 				<li><a href="#" data-rel="amelia">Amelia</a></li> -->
<!-- 				<li><a href="#" data-rel="original">Original</a></li> -->
<!-- 			</ul> -->
<!-- 		</div> -->
	</div>


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script src="./js/ajax.js"></script>

	<script type="text/javascript"
		src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>
	<script type="text/javascript"
		src="js/jquery.aw-showcase/jquery.aw-showcase.js"></script>
	<link rel="stylesheet" href="js/jquery.aw-showcase/css/style.css" />
	<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>

	<link rel="stylesheet" href="js/badger/badger.min.css" />
	<script type="text/javascript" src="js/badger/badger.min.js"></script>

	<link rel="stylesheet" href="js/sticky/sticky.min.css" />
	<script type="text/javascript" src="js/sticky/sticky.min.js"></script>

	<script type="text/javascript" src="js/portamento-min.js"></script>
	<script type="text/javascript" src="js/global.js"></script>

</body>
</html>