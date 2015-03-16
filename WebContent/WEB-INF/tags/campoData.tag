<%@ tag language="java" pageEncoding="ISO-8859-1"%>

<%@ attribute name="id" required="true" %>

<input type="text" id="${id}" name="${id}"   />

<script type="text/javascript">
	$("#${id}").datepicker({dateFormat: 'dd/mm/yy', changeMonth: true, changeYear: true});
</script>

