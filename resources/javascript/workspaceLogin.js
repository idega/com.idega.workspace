jQuery(document).ready(function() {
	jQuery(".workspaceLogin a").click(function() {
		jQuery(".workspaceLogin input[name='login_state']").val('logoff');
		jQuery(this).parents('form').submit();
		return false;
	});
});