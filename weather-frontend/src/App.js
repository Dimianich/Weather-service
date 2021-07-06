import logo from './logo.svg';
import './App.css';
import React, { useState } from "react";
import Charts from './Charts';
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";

const WEATHER_SERVICE_URL = 'http://backend/api/weather';

function App () {
  const [isFetching, setIsFetching] = useState(false);
  const [weather, setWeather] = useState([]);
  const [startDate, setStartDate] = useState(new Date());
  const [endDate, setEndDate] = useState(new Date()); 

     
    return (      
      <div className='App'>
        <h1>Погода</h1>
        <DatePicker
        dateFormat="yyyy-MM-dd"
        selected={startDate}
        onChange={(date) => setStartDate(date)}
        selectsStart
        startDate={startDate}
        endDate={endDate}
      />
      <DatePicker
        dateFormat="yyyy-MM-dd"
        selected={endDate}
        onChange={(date) => setEndDate(date)}
        selectsEnd
        startDate={startDate}
        endDate={endDate}
        minDate={startDate}
      />        
        <button onClick={() => fetchWeather()}>
        Получить данные
      </button>
        <div className='Loading'>{{isFetching}['isFetching'] ? 'Получение данных...' : ''}</div>
        <Charts weather={weather}/>              
      </div>
    );
    

  function fetchWeather() {    
    let startYear = String({startDate}['startDate'].getFullYear());
    let startMonth = ({startDate}['startDate'].getMonth() + 1) < 10 ? "0" + String({startDate}['startDate'].getMonth() + 1) : String({startDate}['startDate'].getMonth() + 1);
    let startDay = {startDate}['startDate'].getDate() < 10 ? "0" + String({startDate}['startDate'].getDate()) : String({startDate}['startDate'].getDate());
    
    let endYear = String({endDate}['endDate'].getFullYear());
    let endMonth = ({endDate}['endDate'].getMonth() + 1) < 10 ? "0" + String({endDate}['endDate'].getMonth() + 1) : String({endDate}['endDate'].getMonth() + 1);
    let endDay = {endDate}['endDate'].getDate() < 10 ? "0" + String({endDate}['endDate'].getDate()) : String({endDate}['endDate'].getDate());

    let strStartDate = startYear + "-" + startMonth + "-" + startDay;
    let strEndDate = endYear + "-" + endMonth + "-" + endDay;
    
    setIsFetching(true);
    fetch(WEATHER_SERVICE_URL + "?startDate=" + strStartDate + "&endDate=" + strEndDate)
      .then(response => response.json())
      .then(result => {
        setWeather(result);
        setIsFetching(false);
      })
      .catch(e => console.log(e));    
  }    

}export default App;
