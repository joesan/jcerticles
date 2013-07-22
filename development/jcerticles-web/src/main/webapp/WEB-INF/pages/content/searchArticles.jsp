<%@ taglib prefix="s" uri="/struts-tags" %>
<div id="main">

		<div class="searchArticlesDiv">
			<s:form action="searchArticlesForQuery" namespace="/content" theme="simple">
				<h1>Search Articles</h1>
				<p>Search for Java and related articles... Still Under Construction</p>
						  <s:hidden name="skipRecords" value="0" />
						  <s:hidden name="takeRecords" value="5" />					
				<table> 
					<tr>
						<td><p>Enter your search criteria here:</p></td><td></td>
							<td>
								<div class="searchTextField"><s:textfield name="searchQuery" id="searchQuery" maxlength="50" size="52"/></div>
							</td>
						<td><s:submit id="submitSearch" value="Search Articles" /></td>
					</tr>
				</table>
				
				<table>
				  <tr>
					<s:if test="fileList != null && searchResultFlag == 0"> 
						<td><p>Sorry! No results found for the given search criteria. Retry with another search criteria.</p></td>
					</s:if>						
				  </tr>
				  <tr>
					<td width="31%" align="right">
						<div class="searchImgDiv">
							<p>Powered by <img src="<%=request.getContextPath()%>/images/content/lucene_logo.gif" height="18" width="85" />
							and <img src="<%=request.getContextPath()%>/images/content/tika_logo.gif" height="18" width="85" /></p>
						</div>
					</td>
				  </tr>
				</table>
			</s:form>
		</div>			
		
		<s:if test="fileList != null && fileList.size() > 0"> 
			<div class="searchResultsDiv">
					<h1>Search Results</h1>
					<p> Following articles might be of interest to you. Please click on the links to read the articles.<br></p>
						<div class="searchResultsPaging">
							<font color="white">Go to page ...</font>
							
							<s:url var="url" action='searchArticlesForQuery'>
							    <s:param name="skipRecords" value="0" />
							    <s:param name="takeRecords" value="5" />
							    <s:param name="searchQuery" value="searchQuery"/>
							</s:url>
							<s:if test = "skipRecords == 0 && takeRecords == 5">
								1 - 5&nbsp; |
							</s:if>
							<s:else>
								<s:a href="%{url}">1 - 5</s:a>&nbsp; |							
							</s:else>							
							
							<s:url var="url" action='searchArticlesForQuery'>
							    <s:param name="skipRecords" value="5" />
							    <s:param name="takeRecords" value="5" />
							    <s:param name="searchQuery" value="searchQuery"/>
							</s:url>
							<s:if test = "skipRecords == 5 && takeRecords == 5">
								6 - 10&nbsp; |
							</s:if>
							<s:else>
								<s:if test="2 lt totalSearchHits || 2 == totalSearchHits">
									<s:a href="%{url}">6 - 10</s:a>&nbsp; |
								</s:if>
								<s:else>
									6 - 10&nbsp; |						
								</s:else>							
							</s:else>
							
							<s:url var="url" action='searchArticlesForQuery'>
							    <s:param name="skipRecords" value="10" />
							    <s:param name="takeRecords" value="5" />
							    <s:param name="searchQuery" value="searchQuery"/>
							</s:url>
							<s:if test = "skipRecords == 10 && takeRecords == 5">
								11 - 15&nbsp; |
							</s:if>
							<s:else>
								<s:if test="3 lt totalSearchHits || 3 == totalSearchHits">
									<s:a href="%{url}">11 - 15</s:a>&nbsp; |
								</s:if>
								<s:else>
									11 - 15&nbsp; |								
								</s:else>							
							</s:else>
							
							<s:url var="url" action='searchArticlesForQuery'>
							    <s:param name="skipRecords" value="15" />
							    <s:param name="takeRecords" value="5" />
							    <s:param name="searchQuery" value="searchQuery"/>
							</s:url>
							<s:if test = "skipRecords == 15 && takeRecords == 5">
								16 - 20&nbsp; |
							</s:if>
							<s:else>
								<s:if test="4 lt totalSearchHits || 4 == totalSearchHits">
									<s:a href="%{url}">16 - 20</s:a>&nbsp; |
								</s:if>
								<s:else>
									16 - 20&nbsp; |								
								</s:else>							
							</s:else>
							
							<s:url var="url" action='searchArticlesForQuery'>
							    <s:param name="skipRecords" value="20" />
							    <s:param name="takeRecords" value="5" />
							    <s:param name="searchQuery" value="searchQuery"/>
							</s:url>
							<s:if test = "skipRecords == 20 && takeRecords == 5">
								21 - 25
							</s:if>
							<s:else>
								<s:if test="5 lt totalSearchHits || 5 == totalSearchHits">
									<s:a href="%{url}">21 - 25</s:a>
								</s:if>
								<s:else>
									21 - 25							
								</s:else>							
							</s:else>							
							 
						</div><br>
					       <s:iterator value="fileList">
							   <font color="white"><s:property value="fileTitle" /></font><br> 
							   <s:property value="fileSummary" />
						       <a href="<s:property value="filePath"/>"> ... Click here to read article</a><br><br>
					       </s:iterator>	 				
			</div>
		</s:if>
		<s:else>
			<div id="recentArticlesDiv">
					<h1>Recent Articles</h1>			
					<p>Following are some of the recently created articles... <br>
					Still Under Construction    </p>
			</div>
		</s:else>
	</div>