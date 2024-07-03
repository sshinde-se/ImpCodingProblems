//Program to check html dom elements are correctly nested
function StringChallenge(str) {


    // code goes here
    let test = str;
    let results = [];
    test.replace(/([^<>]*?)(<\/?[-:\w]+(?:>|\s[^<>]*?>)|$)/g, function(a, b, c) {
        if (b) results.push(b);
        if (c) results.push(c);
    });

    results;
    let match = {
        '<div>' : '</div>',
        '<p>' : '</p>',
        '<b>' : '</b>',
        '<i>' : '</i>',
        '<em>' : '</em>'
    };

    let tag = [];
// get all tags in sequence
    results = results.filter(item => item.includes("<"));
    let reducer = function(acc, value, index, array){
        if(index == array.length) {
            return acc;
        }
        if(array.indexOf(match[value]) != -1) {
            array.splice(array.indexOf(match[value]), 1);
        } else {
            acc.push(value);
        }

        return acc;
    }
    results.reduce(reducer, tag);

    return tag[0].replace("<","").replace(">", "");
}

// keep this function call here
console.log(StringChallenge(readline()));