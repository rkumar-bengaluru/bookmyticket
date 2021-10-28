var input = [1,2,3];
var anotherinput = [1,1,3,3,5,5,7,7];
var ainput = [1,3,2,3,5,0];
var binput = [1,1,2,2];
var cinput = [1,1,2];
console.log('input-' + findMissing(input));
console.log('another-' + findMissing(anotherinput));
console.log('ainput-' + findMissing(ainput));
console.log('binput-' + findMissing(binput));
console.log('binput-' + findMissing(cinput));
function findMissing(input) {
  	var count = 0;
  	var map = new Map();
  	for(var i = 0; i <= input.length -1;i++) {
      	//console.log(input[i] - 1);
    	map.set(input[i] - 1, true);
    }
  	for(var i = 0; i <= input.length -1;i++) {
      	//console.log(input[i] + ':' + map.get(input[i]));
    	if(map.get(input[i]) ===  true) {
          count++;
        } 
    }
  	return count;
}