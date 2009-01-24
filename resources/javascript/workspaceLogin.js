$j = jQuery.noConflict();

$j(document).ready(function() {
	$j(".workspaceLogin a").click(function() {
		$j(".workspaceLogin input[name='login_state']").val('logoff');
		$j(this).parents('form').submit();
		return false;
	});
});