// with O(n^2) time complexity
function twoSum(nums, target) {
    let val;
    const result = Array();
    //check if is an array
    if (nums instanceof Array && typeof target === 	"number"  ) {
        console.log("ok ");
    outer: for (i = 0; i < nums.length; i++){
            for (j = i; j < nums.length; j++){
                val = nums[i] + nums[j];
                if (val === target && i!== j) {
                    result[0] = i;
                    result[1] = j;
                    break outer;
                } else continue;
            }
    }   
        console.log("Numbers:" + result);

    } else console.log("not okay");
};
// to solve in O(n) time complexity best approach 


function twoSum(nums, target) {
    let parIndx = {};
    let ans;
    if (nums instanceof Array) {
        for (i = 0; i < nums.length; i++) {
            let num = nums[i];
            if (target - num in parIndx) {
                ans = [i, parIndx[target - num]];
            };
              parIndx[num] = i;
        } 
        console.log(ans);
    }

    
}

twoSum([2, 3, 3,4, 5, 6], 11);