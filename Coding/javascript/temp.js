const coins = [1,2,5];
let amount = 11;
/**
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}
 */
var coinChange = function(coins, amount) {
    let ans = recurr(coins.length-1,amount,coins);
    return ans;
};

console.log(coinChange(coins,amount));

function recurr(index,amount,coins){
    console.log(index,amount);
    if(amount==0) return 0;
    if(index<0 || amount<0)  return 1e7;

    let take = 1e9;
    let notTake;
    if(amount>=coins[index])
        take = recurr(index,amount-coins[index],coins)+1;
    else
        notTake = recurr(index-1,amount,coins);
    console.log("take nottake ",take,notTake);
    return Math.min(take,notTake);
}
