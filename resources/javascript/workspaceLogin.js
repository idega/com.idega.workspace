jQuery.noConflict();

jQuery(document).ready(function() {
	jQuery(".workspaceLogin a").click(function() {
		jQuery(".workspaceLogin input[name='login_state']").each(function() {
			jQuery(this).attr('value', 'logoff');
		});
		
		var form = jQuery(this).parents('form');
		if (form.attr('enctype') != 'application/x-www-form-urlencoded') {
			form.attr('enctype', 'application/x-www-form-urlencoded');
		}
		form.submit();
		return false;
	});
});