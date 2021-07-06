import ReactEcharts from "echarts-for-react";

function Charts(props) {

    let dates = [];
    let temperatures = [];
    let pressures = [];
    let humidities = [];

    for(let i = 0; i < props.weather.length; i++) {
      dates.push(props.weather[i]['date']);
      temperatures.push(props.weather[i]['temperature']);
      pressures.push(props.weather[i]['pressure']);
      humidities.push(props.weather[i]['humidity']);
    }   
  
     return (
        <ReactEcharts
        option={{         
         tooltip : {
            trigger: 'axis'
         },
         legend: {
            data:['Температура','Давление','Влажность']
         },
          xAxis: {
            type: "category",
            data: dates
          },
          yAxis: {
            type: "value"
          },
          series: [{ 
            name:"Температура",
            data: temperatures,
            type: "line",
            smooth: true
          },
          {
            name:"Давление",
            data: pressures,
            type: "line",
            smooth: true          
          },
          {
            name:"Влажность",
            data: humidities,
            type: "line",
            smooth: true          
          }]
        }}        
      />
    );
  }export default Charts;