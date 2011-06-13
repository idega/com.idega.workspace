jQuery.noConflict();

jQuery(document).ready(function() {
	jQuery(".workspaceLogin a").click(function() {
		jQuery(".workspaceLogin input[name='login_state']").each(function() {
			jQuery(this).attr('value', 'logoff');
		});
		
		var form = jQuery(this).parents('form');
		var onSubmit = form.attr('onsubmit');
		if (onSubmit == null || onSubmit == '') {
			if (form.attr('enctype') != 'application/x-www-form-urlencoded') {
				form.attr('enctype', 'application/x-www-form-urlencoded');
			}
			form.submit();
			return false;
		} else {
			LazyLoader.loadMultiple(['/dwr/engine.js', '/dwr/interface/WebUtil.js'], function() {
				WebUtil.logOut({
					callback: function(result) {
						if (result)
							window.location.href = window.location.href;
					}
				});
			});
		}
	});
});