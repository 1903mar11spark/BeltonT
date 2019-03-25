window.onload = function(){

    getYear();
    getMake();

    document.getElementById("year").addEventListener("change", getModel);
    document.getElementById("cars").addEventListener("change", getModel);
    document.getElementById("model").addEventListener("change", printModel);

};


const apiUrl = "https://vpic.nhtsa.dot.gov/api/vehicles/getallmakes?format=json";

let get = {
    make:''
};   
//car is object with key veh assigned to a value of an empty string
let car = {
    veh: ''
}

function getYear(){
    for(i=1981;i<2020;i++){
        let opt = document.createElement("option");
        opt.innerText = i;
       document.getElementById("year").appendChild(opt).value=i;
    }
}


function getMake(){

    fetch(apiUrl, {method: "GET",})
  
    .then((response) => {
        return response.json();
    })
    
    .then((data) => {

       for(i=0;i<100;i++){
        let list1 = document.createElement("option");
        list1.innerText = data.Results[i].Make_Name;
       document.getElementById("cars").appendChild(list1);
      }
 })
}

function getModel(){

    let mak = document.getElementById("cars");
     make = mak.options[mak.selectedIndex].value;
     make.replace(/\s+/g,"");
    let yr = document.getElementById("year");
     year = yr.options[yr.selectedIndex].value;
      modelUrl = "https://vpic.nhtsa.dot.gov/api/vehicles/getmodelsformakeyear/make/"+make+"/modelyear/"+year+"?format=json"
    console.log(modelUrl);
    

    fetch(modelUrl, {method: "GET",})
    .then((response) =>{
        return response.json();
    })
    .then ((data) => {

 
        let element = document.getElementById("model");
        while (element.firstChild) {
          element.removeChild(element.firstChild);
        }
if(data.Results.length<1){
    let list0 = document.createElement("option");
    list0.innerText = "None";
   document.getElementById("model").appendChild(list0);
}
else{
for(i=0;i<data.Results.length;i++){
    car.veh = data.Results[i].Model_Name;
    let list1 = document.createElement("option");
    list1.innerText = car.veh;
   document.getElementById("model").appendChild(list1).value=data.Results[i].Model_Name;
}
document.getElementById("search").value=year+" "+make+" "+data.Results[0].Model_Name;
}
})
}

function printModel(){
    let md = document.getElementById("model");
    let model = md.options[md.selectedIndex].value;
    
       document.getElementById("search").value=year+" "+make+" "+model;
    }
    