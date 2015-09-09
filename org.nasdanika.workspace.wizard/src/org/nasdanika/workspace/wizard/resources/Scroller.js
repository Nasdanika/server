require(['jquery', 'domReady!'], function(jQuery, doc) {

	var toc = jQuery("#toc");
	toc.bind("select_node.jstree", function(e, data) {
		var nodeElement = jQuery('#'+data.node.id+"_anchor");
		var nodeOffsetTop = nodeElement[0].offsetTop;
		var tocScrollTop = toc.scrollTop() + toc[0].offsetTop;
		var nodeOffsetBottom = nodeOffsetTop + nodeElement.height();
		var tocScrollBottom = tocScrollTop+toc.height();
		if (nodeOffsetTop < tocScrollTop || nodeOffsetBottom > tocScrollBottom) {			
			var targetScrollTop = nodeOffsetTop - toc.height()/2;
			toc.animate({ scrollTop: targetScrollTop+"px" });
		}	
	});

});