<%@ tag language="java" pageEncoding="ISO-8859-1"%>

<%@ attribute name="id" required="true" %>
<%@ attribute name="val" required="false" %>


<input type="text" id="${id}" name="${id}" value="${val}"  />

<script type="text/javascript">
	$("#${id}").datepicker({dateFormat: 'dd/mm/yy', changeMonth: true, changeYear: true, yearRange:"2010:2014"});
</script>
