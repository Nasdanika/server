if (data.location) {
	window.location = data.location;
	$("#{{app-id}}-modal").modal('hide');
}