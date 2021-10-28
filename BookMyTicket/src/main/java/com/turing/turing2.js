var input = [1,2,3,4,5,6,7];

console.log(JSON.stringify(rotateright(input,3)));
function rotateright(input, k) {
  	for(var j = 0; j < k; j++) {
	var last = input[input.length -1];
  		for(var i = 0; i <= input.length -1; i++) {
    		var t = input[i];
      		input[i] = last;
      		last = t;
    	}
    }
  	return input;
}
