if (data.result) {
	this.result(data.result);
	this.location(data.location);
	
	//Modal resizing to address result.
	var modalBody = $('#{{app-id}}-modal .modal-body');
	var result = modalBody.find('#{{app-id}}-result');
	modalBody.height(result.height() + "px");			
} else if (data.location) {
	window.location = data.location;
	$("#{{app-id}}-modal").modal('hide');
} else if (data.validationResults) {
	this.messages([]);
	var vr = data.validationResults;
	for (var r in vr.results) {
		this.messages.push({
			name: null,
			style: 'list-group-item-'+vr.results[r].style.toLowerCase(),
			message: vr.results[r].message
		});
	}
	for (var nr in vr.namedElementValidationResults) {
		var nvra = vr.namedElementValidationResults[nr];
		for (var r in nvra) {
			this.messages.push({
				name: nr,
				style: 'list-group-item-'+nvra[r].statusStyle.toLowerCase(),
				message: nvra[r].message
			});					
		}
	}
	for (var fgn in this.status) {
		var nvra = vr.namedElementValidationResults[fgn];
		this.status[fgn]("");
		if (nvra) {
			for (var r in nvra) {
				var nStatus = "has-"+nvra[r].status.toLowerCase();
				this.status[fgn](nStatus);
				if (nStatus == "has-error") {
					break;
				}
			}
		}
	}	
	
	//Modal resizing to address error messages.
	var modalBody = $('#{{app-id}}-modal .modal-body');
	var form = modalBody.find('form');
	modalBody.height((form.height() + 30) + "px");	
}
