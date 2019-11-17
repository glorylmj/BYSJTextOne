<html>
<script type="text/javascript">
  var currentUrl = window.location.href.toString();
  var value = currentUrl.substring(0,currentUrl.lastIndexOf("/")) + "/login/login.jsp";
  if(currentUrl.indexOf("?")>0){
    value += currentUrl.substring(currentUrl.indexOf("?"));
  }
  window.location.href = value;
</script>
</html>