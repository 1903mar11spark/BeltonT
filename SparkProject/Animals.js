window.onload = function(){
    document.getElementById("cat").addEventListener("click",getCat);
    document.getElementById("dog").addEventListener("click", getDog);
    document.getElementById("Gdog").addEventListener("click", function(){
        guess = 'dog'
        random();
    });
    document.getElementById("Gcat").addEventListener("click", function(){
        guess='cat';
        random();
    });
};

const catUrl = "https://api.thecatapi.com/v1/images/search"
const dogUrl = "https://random.dog/woof.json"

let cat={
    pic: ''
}

let dog={
    pic: ''
}

function getCat(){
    fetch(catUrl, {method: "GET",})

    .then((response) => {
        return response.json();
    })

    .then ((data) => {
        cat.pic=data[0].url;
        console.log(data[0].url);
        document.getElementById("pic").src=cat.pic;
    })
}

function getDog(){
    fetch(dogUrl, {method: "GET",})

    .then((response) => {
        return response.json();
    })

    .then ((data) =>{
        dog.pic=data.url;
        console.log(data.url);

        if (dog.pic.includes("mp4")){
            getDog();
        }
        else{
        document.getElementById("pic").src=dog.pic;
        }
    })
}
let ones=0;
let twos=0;
let total=0;
let correct=0;
let z='';

function corr(){
    correct++;
    z="correct";
}

function random(){
 
    var random =Math.floor(Math.random() * (2)) + +1; 
    console.log(random);
    if (random===1){
        getDog();

    if(guess=='dog'){
        corr();
    }
    else{
        z="incorrect";
    }
    
    ones++;}
    else{
        getCat();

    if(guess=='cat'){
        corr();
    }
    else{
        z="incorrect";
    }
    twos++;
}

document.getElementById("guess").innerText="You guessed "+guess+" and you were "+z;
let x=ones+twos;
let perc =(correct/x)*100;
document.getElementById("perc").innerText="Total: "+x+"\n"+"   Dogs: "+ones+"\n"+"    Cats: "+twos+"\n"+"\n"+"Percent Correct: "+perc;
}