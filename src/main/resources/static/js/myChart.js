var decodedChartData = decodeHtml(chartData);
var chartJsonArray = JSON.parse(decodedChartData);

var arrayLength = chartJsonArray.length;
var numericData = [];
var labelData = [];

for(var i=0;i < arrayLength;i++){
	numericData[i] = chartJsonArray[i].stateCounts;
	labelData[i]= chartJsonArray[i].state;
}

new Chart(document.getElementById("myPieChart"), {
	type: 'pie',
	data: {
	  labels: labelData,
	  datasets: [{
	    label: '# of Votes',
	    data: numericData,
	    borderWidth: 1
	  }]
	},
	options: {
		plugins: {
		      title: {
		        display: true,
		        text: 'Project Statuses',
		        padding: {
		          top: 10,
		          bottom: 30
		        },
		        font: {
		          size: 14
		        }
		      }
		    }
	}
});

function decodeHtml(html){
	var txt = document.createElement("textarea");
	txt.innerHTML = html;
	return txt.value;
}