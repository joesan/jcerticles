
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="main">

	<h1>Create New Content</h1>

	<form action="assets/sample_posteddata.jsp" method="post">
		<table>
			<tr>
				<td>Passcode: <input type="password" name="firstname" /></td>
				<td>Token:    <input type="password" name="lastname" /></td>
			</tr>
			<tr>
				<td>Give me more : <input type="text" name="lastname" maxlength="100"/></td>
			</tr>			
		</table>

		<p>
			<textarea cols="80" id="contentEdit" name="contentEdit" rows="10">Add your content here...</textarea>
		</p>
		<p>
			<input type="submit" value="Submit"/>
		</p>
	</form>
	<ckeditor:replace  replace="contentEdit" basePath="/Quintilis31Web/ckeditor/" />
</div>
