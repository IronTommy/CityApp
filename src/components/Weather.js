import React, { useState } from "react";
import axios from "axios";
import { Container, Typography, TextField, Button, Box, Grid, Card, CardContent } from "@mui/material";

const Weather = () => {
    const [city, setCity] = useState("");
    const [weather, setWeather] = useState(null);
    const [forecast, setForecast] = useState(null);

    const getWeather = async () => {
        try {
            const response = await axios.get(`http://localhost:8080/api/weather?city=${city}&lang=ru`);
            setWeather(response.data);
        } catch (error) {
            console.error('Ошибка при получении погоды:', error);
        }
    };

    const getForecast = async () => {
        try {
            const response = await axios.get(`http://localhost:8080/api/weather/forecast?city=${city}&lang=ru`);
            setForecast(response.data);
        } catch (error) {
            console.error('Ошибка при получении прогноза:', error);
        }
    };

    return (
        <Container>
            <Typography variant="h4" component="h2" gutterBottom>
                Погода в городе
            </Typography>
            <TextField
                label="Введите город"
                value={city}
                onChange={(e) => setCity(e.target.value)}
                fullWidth
            />
            <Box mt={2}>
                <Button variant="contained" onClick={getWeather}>
                    Получить погоду
                </Button>
                <Button variant="contained" onClick={getForecast} style={{ marginLeft: '10px' }}>
                    Получить прогноз
                </Button>
            </Box>
            {weather && (
                <Box mt={4}>
                    <Typography variant="h6" component="h3">
                        {weather.name}
                    </Typography>
                    <Typography>Температура: {weather.main.temp}°C</Typography>
                    <Typography>Описание: {weather.weather[0].description}</Typography>
                    <Typography>Влажность: {weather.main.humidity}%</Typography>
                    <Typography>Скорость ветра: {weather.wind.speed} м/с</Typography>
                    <Typography>Давление: {weather.main.pressure} гПа</Typography>
                    <Typography>Видимость: {weather.visibility} м</Typography>
                </Box>
            )}
            {forecast && (
                <Box mt={4}>
                    <Typography variant="h6" component="h3">
                        Прогноз на несколько дней
                    </Typography>
                    <Grid container spacing={2}>
                        {forecast.list.map((item, index) => (
                            <Grid item key={index} xs={12} sm={6} md={4}>
                                <Card>
                                    <CardContent>
                                        <Typography>Дата: {new Date(item.dt_txt).toLocaleDateString('ru-RU')}</Typography>
                                        <Typography>Температура: {item.main.temp}°C</Typography>
                                        <Typography>Описание: {item.weather[0].description}</Typography>
                                    </CardContent>
                                </Card>
                            </Grid>
                        ))}
                    </Grid>
                </Box>
            )}
        </Container>
    );
};

export default Weather;
