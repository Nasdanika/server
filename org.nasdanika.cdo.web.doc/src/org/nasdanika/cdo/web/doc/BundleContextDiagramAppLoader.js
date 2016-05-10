require(['knockout', 'domReady!', '{{docRoutePath}}/resources/js/bundle-context-diagram-view-model.js'], function(ko, doc, ViewModel) {
	var contextDiagramApp = doc.getElementById('{{id-base}}-app');
	if (contextDiagramApp) {
		ko.applyBindings(new ViewModel("{{id-base}}", "{{diagram-url}}"), contextDiagramApp);
	} else {
		console.error("Context diagram application container not found: {{id-base}}-app");
	}
});
