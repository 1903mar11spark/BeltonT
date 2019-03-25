window.onload = function(){
    forcast();
    document.getElementById("London").addEventListener("click", forcast);

};

function forcast(){
    if(document.getElementById("input").value==''){
        var city = "Tampa";
    }
    else{ let input=document.getElementById("input").value;
    console.log(input);
    var city=input;}

    const forc="http://api.apixu.com/v1/forecast.json?key=cde5f8e535434d5bbff201441191903&q="+city+"&days=5";

    let weath ={
        later:''
    }

     fetch(forc, {method: "GET",})

     .then((response)=>{
         return response.json();
     })

     .then((data) =>{
        weath.later=data

        
    let element = document.getElementById("main");
    while (element.firstChild){
        element.removeChild(element.firstChild);
    }

    let element2 = document.getElementById("5day");
    while (element2.firstChild){
        element2.removeChild(element2.firstChild);
    }

        let where=document.createElement("span");
        where.id="where";
        document.getElementById("main").appendChild(where);

        let now=document.createElement("span");
        now.id="now";
        document.getElementById("main").appendChild(now);

        let more=document.createElement("span");
        more.id="more";
        document.getElementById("main").appendChild(more);


       let city=document.createElement("h2");
       city.style="margin: 0"
       city.innerText=data.location.name;
       document.getElementById("where").appendChild(city);

       let region=document.createElement("h6");
      region.innerText=data.location.region;
       document.getElementById("where").appendChild(region);

       let country=document.createElement("p");
        country.innerText=data.location.country;
       document.getElementById("where").appendChild(country);


        let tempNow= document.createElement("h1")
        tempNow.style="margin: 0";
        tempNow.innerText=data.current.temp_f;
        document.getElementById("now").appendChild(tempNow);



        let imgNow=document.createElement("img")

        let pic=data.current.condition.icon;
        let picture="http://"+pic.slice(2);
        imgNow.src=picture
        console.log(pic.slice(2))
        imgNow.height="30"
     
        document.getElementById("now").appendChild(imgNow);

   


        let feelsLike=document.createElement("h6")
        feelsLike.innerText="Feels like: "+data.current.feelslike_f;
        document.getElementById("now").appendChild(feelsLike);


        let text=document.createElement("p");
        text.innerText="Current conditions: "+data.current.condition.text;
        document.getElementById("more").appendChild(text);

        let hum=document.createElement("p");
        hum.innerText="Humidity: "+data.current.humidity;
        document.getElementById("more").appendChild(hum);

        let wind=document.createElement("p");
        wind.innerText="Wind: "+data.current.wind_dir+" "+data.current.wind_mph+" mph";
        document.getElementById("more").appendChild(wind);

        for(i=0;i<5;i++){
            let date=document.createElement("tr");
            date.id="row"+i;
            document.getElementById("5day").appendChild(date);


            let day=document.createElement("td");
            day.className="date"
            day.innerText=data.forecast.forecastday[i].date;
            document.getElementById("row"+i).appendChild(day);

            let max=document.createElement("td");
            max.className="max"
            max.innerText="High: "+data.forecast.forecastday[i].day.maxtemp_f;
            document.getElementById("row"+i).appendChild(max);

            let min=document.createElement("td");
            min.className="min"
            min.innerText="Low: "+data.forecast.forecastday[i].day.mintemp_f;
            document.getElementById("row"+i).appendChild(min);

            let prec=document.createElement("td");
            prec.className="prec"
            prec.innerText="Precipitation: "+data.forecast.forecastday[i].day.totalprecip_in;
            document.getElementById("row"+i).appendChild(prec);

            let humi=document.createElement("td");
            humi.className="humi"
            humi.innerText="Expected humidity: "+data.forecast.forecastday[i].day.avghumidity;
            document.getElementById("row"+i).appendChild(humi);

            let desc=document.createElement("td");
            desc.className="desc"
            desc.innerText=data.forecast.forecastday[i].day.condition.text;
            document.getElementById("row"+i).appendChild(desc);
        }
        
     })
     .catch((error) => {
        alert('Invalid location');
        console.log(error);
    });
    
}