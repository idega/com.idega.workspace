jQuery(document).ready(function() {
	jQuery('ul.welcomeList').tabs({ fx: { height: 'toggle', duration: 'fast' } });
	
	jQuery('ul.welcomeList li').click(function() {
		jQuery('ul.welcomeList li.selected').removeClass('selected');
		jQuery(this).addClass('selected');
	})
});