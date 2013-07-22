<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/common/jquery/core/jquery-1.5.1.min.js"></script>

<script type="text/javascript">
		$(document).ready(function() {
			$("#menu ul li a").click(function() {
				$("#menu ul li").css({'background-color': '#F3F3F3', 'color': '#333', 'border-bottom': '4px solid #FFA600'});
			});
		});
</script>		

	<div id="menu">
		<ul>
			<li><a href="<%=request.getContextPath()%>/index.jsp">Home</a></li>
			<li><a href="<s:url action='exams'          namespace="/content"/>">Mock Exams</a></li>
			<li><a href="<s:url action='searchArticles' namespace="/content"/>">Articles</a></li>
			<li><a href="#">Code Samples</a></li>
			<li><a href="<s:url action='musings'        namespace="/content"/>">My Random Musings</a></li>
			<li><a href="<s:url action='contact'        namespace="/common"/>">About</a></li>
		</ul>
	</div>



