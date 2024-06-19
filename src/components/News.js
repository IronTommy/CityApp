import React, { useEffect, useState } from "react";
import axios from "axios";
import { Card, CardContent, CardMedia, Typography, Grid, Container } from "@mui/material";

const News = () => {
    const [news, setNews] = useState([]);

    useEffect(() => {
        const fetchNews = async () => {
            try {
                const response = await axios.get("http://localhost:8080/api/news?country=ru");
                console.log(response.data.articles); // Вывод данных в консоль
                setNews(response.data.articles);
            } catch (error) {
                console.error("Ошибка при получении новостей:", error);
            }
        };
        fetchNews();
    }, []);

    return (
        <Container>
            <Typography variant="h4" component="h2" gutterBottom>
                Новости
            </Typography>
            <Grid container spacing={4}>
                {news.map((article, index) => (
                    <Grid item key={index} xs={12} sm={6} md={4}>
                        <Card>
                            {article.urlToImage && (
                                <CardMedia
                                    component="img"
                                    height="140"
                                    image={article.urlToImage}
                                    alt={article.title}
                                    onError={(e) => { e.target.onerror = null; e.target.src = "/path/to/default/image.jpg"; }} // Укажите путь к изображению по умолчанию
                                />
                            )}
                            <CardContent>
                                <Typography gutterBottom variant="h5" component="div">
                                    <a href={article.url} target="_blank" rel="noopener noreferrer">
                                        {article.title}
                                    </a>
                                </Typography>
                                <Typography variant="body2" color="text.secondary">
                                    {article.description}
                                </Typography>
                                <Typography variant="caption" display="block" gutterBottom>
                                    Источник: {article.source.name}
                                </Typography>
                            </CardContent>
                        </Card>
                    </Grid>
                ))}
            </Grid>
        </Container>
    );
};

export default News;
