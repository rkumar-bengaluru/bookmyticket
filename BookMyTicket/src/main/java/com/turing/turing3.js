var input = ["5","2","C","D","+"];
var ainput = ["5", "-2","4","C","D","9","+","+"];
console.log(baseball(input));
console.log(baseball(ainput));
function baseball(input) {
  	var output = [];
	for(var i = 0; i <= input.length -1;i++) {
      	if(input[i] === "C") {
        	if(output.length > 0) {
            	output.pop();
            }
        } else if(input[i] === "D") {
          	if(output.length > 0) {
        		var r = parseInt(output[output.length-1]) * 2;
              	output.push(r);
            }
        } else if(input[i] === "+") {
        	if(output.length > 1) {
            	var r = parseInt(output[output.length -1]) + 
                    parseInt(output[output.length -2]);
              	output.push(r);
            }
        } else {
        	output.push(parseInt(input[i]));
        };
    }
  	
  	var sum = 0;
  	for(var i = 0; i <= output.length -1; i++) {
    	sum += output[i];
    }
  	return sum;
}