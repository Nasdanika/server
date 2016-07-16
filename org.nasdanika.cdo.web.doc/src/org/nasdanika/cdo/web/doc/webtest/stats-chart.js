var chart = c3.generate({
	bindto: '{{selector}}',
    data: {
        columns: {{columns}},
        type : 'pie',
        colors: {
            Pass: '#00ff00',
            Fail: '#ff0000',
            Pending: '#707070',
            Error: '#FFA500'
        }
    },        
    legend: {
        position: 'right'
    },
    size: {
        height: 200,
        width: 350
    },
    pie: {
        label : {
			format : function(value, ratio, id) {
				return value;
			}
		}
    }    
});
