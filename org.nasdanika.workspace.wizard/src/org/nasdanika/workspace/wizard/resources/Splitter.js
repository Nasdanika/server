require(['jquery', 'domReady!'], function(jQuery, doc) {
	var windowWidth = $(window).width();
	var min = windowWidth/10;
	var leftPanel = $('#left-panel');
	leftPanel.css("width", min*2);
	var rightPanel = $('#right-panel');
	var jDoc = $(doc);
	
	$('#splitter').mousedown(function (e) {
	    e.preventDefault();
	    jDoc.mousemove(function (e) {
	        e.preventDefault();
	        var x = e.pageX - leftPanel.offset().left;
	        if (x > min && x < windowWidth && e.pageX < (windowWidth - min)) {  
	          leftPanel.css("width", x);
	          rightPanel.css("margin-left", x);
	        }
	    })
	});
	jDoc.mouseup(function (e) {
	    jDoc.unbind('mousemove');
	});
});