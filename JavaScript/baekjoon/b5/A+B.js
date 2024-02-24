const fs = require('fs');
const inputData = fs.readFileSync(0, 'utf8').toString().split(' ');
console.log(parseInt(inputData[0])+parseInt(inputData[1]));