var input = [1,2,3,4,3];
var output = findDup(input);
console.log(JSON.stringify(output));

function findDup(input) {
	const map = new Map();
  	var max = input[0];
  	for(var i = 0; i <= input.length -1;i++) {
    	if(!map.get(input[i])) {
        	map.set(input[i], 1);
        } else {
          map.set(input[i], map.get(input[i]) + 1);
        }
      	if(input[i] > max) {
        	max = input[i];
        }
    }
  	var output = [];
  	// find the duplicates.
  	map.forEach(function(value,key) {
    	if(value > 1 ) {
        	output.push(key);
        }
    });
  	output.push(max + 1);
  	return output;
}