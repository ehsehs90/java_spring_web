<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>title</title>
<style>
#header {
	text-align: center;
	background-color: orange;
	border-bottom: 3em solid green;
	padding: 1em;	
}

#header a {
	background-color: black;
	text-align: center;
	list-style: none;
	padding: 1em;
	border-radius: 10px 10px 0 0;
	width: 3em;
	color: yellow;
	text-decoration: none;
}

nav {
	background-color: gray;
	float: left;
	width: 25%;
	height: 50em;
	margin: auto;
}

section {
	float: left;
	width: 50%;
	height: 50em;
	text-align: center;
}

#what {
	background-color: gray;
	float: left;
	width: 25%;
	height: 50em;
}

footer {
	background-color: black;
	height: 5em;
	clear: both;
	color: white;
}

table {
	border: 2px solid black;
	margin: auto;
	border-collapse: collapse;
}

table th {
	text-align: center;
	background-color: black;
	color: yellow;
	font-weight: bold;
}

table td {
	text-align: center;
	width: 8em;
}

table tr:nth-child(2n+1) {
	background-color: gray;
	font-style: italic;
}

.func {
	list-style: none;
	background-color: orange;
	border: 2px solid white;
	margin: 1em;
	border-radius: 10px;
	width: 5em;
	height: 2em;
	text-align: center;
	font-weight: bold;
	vertical-align: middle;
}

.func a {
	color: green;
	text-decoration: none;
}

#what li {
	
}

.btn {
	list-style: none;
	color: gray;
	background-color: #e1e2e2;
	margin: 2em;
	width: 5em;
	height: 2em;
	text-align: center;
	vertical-align: middle;
}
</style>

</head>
<body>
	<div id="contents">
		<div id="header">
			<h1>Html5 & CSS3.0</h1>
			<a href="#">HTML5</a> 
			<a href="#">CSS</a> 
			<a href="#">JavaScript</a>
			<a href="#">jQuery</a> 
			<a href="#">Ajax</a>
		</div>
		<nav>
			<ul>
				<li class="func"><a href="#">기능1</a></li>
				<li class="func"><a href="#">기능2</a></li>
				<li class="func"><a href="#">기능3</a></li>
			</ul>
		</nav>

		<section>
			<h2>Table CSS</h2>
			<table>
				<tr>
					<th>ID</th>
					<th>PWD</th>
					<th>NAME</th>
				</tr>
				<tr>
					<td>java01</td>
					<td>1234</td>
					<td>홍길동</td>
				</tr>
				<tr>
					<td>java02</td>
					<td>1234</td>
					<td>고길동</td>
				</tr>
				<tr>
					<td>java03</td>
					<td>1234</td>
					<td>박길동</td>
				</tr>
				<tr>
					<td>java04</td>
					<td>1234</td>
					<td>김길동</td>
				</tr>
				<tr>
					<td>java05</td>
					<td>1234</td>
					<td>최길동</td>
				</tr>
			</table>
		</section>

		<div id="what">
			<ul>
				<li class='btn'>130x40</li>
				<li class='btn'>130x40</li>
				<li class='btn'>130x40</li>
				<li class='btn'>130x40</li>
			</ul>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>