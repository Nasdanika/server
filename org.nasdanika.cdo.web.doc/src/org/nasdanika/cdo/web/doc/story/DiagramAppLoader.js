require(['knockout', 'domReady!', '{{docRoutePath}}/resources/js/story-diagram-view-model.js'], function(ko, doc, ViewModel) {
	var contextDiagramApp = doc.getElementById('{{id-base}}-app');
	if (contextDiagramApp) {
		ko.applyBindings(new ViewModel("{{id-base}}", "{{object-url}}", "{{view}}"), contextDiagramApp);
	} else {
		console.error("Context diagram application container not found: {{id-base}}-app");
	}
});
