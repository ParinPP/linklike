<h1>Link Like</h1>

<g:form name="linkCreateForm" url="[action:'create']">
  Title: <g:textField name="title"/><br/>
  URL: <g:textField name="url"/><br/>
  <input type="submit" value="Add new link"/>
</g:form>
<hr>
<ul>
  <% if(links.size() == 0) { %>
    <li>No links</li>
  <% } else { %>
    <% for(link in links) { %>
      <li>
        <a href="http://<%= link.url %>"><%= link.title %></a> 
        (<a href="likeLink/<%= link.id %>">Like!</a> -- <a href="unLikeLink/<%= link.id %>">Unlike!</a>) | <%= link.likecounts %> likes
      </li>
    <% } %> 
  <% } %>
</ul>